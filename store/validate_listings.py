#!/usr/bin/env python3
"""Validate store listing source files (store/listings/<locale>.json) against store limits.

Exit code 1 if any field is missing or over its limit, so CI can gate uploads on it.
"""
import json
import re
import sys
from pathlib import Path

LIMITS = {
    "appStore": {
        "name": 30,
        "subtitle": 30,
        "keywords": 100,
        "promotionalText": 170,
        "description": 4000,
        "whatsNew": 4000,
    },
    "play": {
        "title": 30,
        "shortDescription": 80,
        "fullDescription": 4000,
        "releaseNotes": 500,
    },
}


def words(text):
    return {w for w in re.findall(r"[\w']+", text.lower()) if len(w) > 1}


# Apple rejects listings that mention Android; keep Play text free of Apple platform names too.
FORBIDDEN = {
    "appStore": re.compile(r"android|google play|health connect|play store", re.I),
    "play": re.compile(r"iphone|ipad|\bios\b|apple health|app store", re.I),
}
LOCALE_KEYS = {"appStore": "appStoreLocales", "play": "playLocales"}


def validate(path):
    data = json.loads(path.read_text(encoding="utf-8"))
    rows, errors = [], []
    for store, fields in LIMITS.items():
        # A language may ship to only one store; validate the sections it targets.
        if not data.get(LOCALE_KEYS[store]):
            continue
        section = data.get(store, {})
        for value in section.values():
            if isinstance(value, str) and FORBIDDEN[store].search(value):
                errors.append(f"{store} text mentions '{FORBIDDEN[store].search(value).group(0)}'")
        for field, limit in fields.items():
            value = section.get(field)
            if not value:
                errors.append(f"{store}.{field} missing")
                continue
            n = len(value)
            ok = n <= limit
            rows.append((store, field, n, limit, "ok" if ok else "OVER"))
            if not ok:
                errors.append(f"{store}.{field} is {n}/{limit}")

    kw = data.get("appStore", {}).get("keywords", "")
    if kw:
        if ", " in kw or kw.startswith(" ") or kw.endswith(" "):
            errors.append("appStore.keywords must not contain spaces around commas")
        terms = kw.split(",")
        if len(terms) != len(set(terms)):
            errors.append("appStore.keywords has duplicate terms")
        taken = words(data["appStore"].get("name", "")) | words(data["appStore"].get("subtitle", ""))
        repeated = sorted(words(kw) & taken)
        if repeated:
            errors.append(f"appStore.keywords repeats name/subtitle words: {', '.join(repeated)}")
    return data.get("locale", path.stem), rows, errors


def main():
    root = Path(sys.argv[1]) if len(sys.argv) > 1 else Path(__file__).parent / "listings"
    failed = False
    for path in sorted(root.glob("*.json")):
        locale, rows, errors = validate(path)
        print(f"== {locale}")
        for store, field, n, limit, status in rows:
            print(f"   {store:8} {field:17} {n:5}/{limit:<5} {status}")
        for e in errors:
            print(f"   ERROR: {e}")
        failed |= bool(errors)
    sys.exit(1 if failed else 0)


if __name__ == "__main__":
    main()
