#!/usr/bin/env python3
"""Replace App Store screenshots on an editable version, per locale and display type.

Usage: upload_appstore.py <final_root> <version_id> [locale ...]
  final_root/appstore/{iphone69,ipad13,duo}/<locale>/NN_*.png
JWT command comes from env ASC_JWT_CMD. Sets listed in REMOVE are deleted (old sizes).
"""
import hashlib
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.request
from pathlib import Path

API = "https://api.appstoreconnect.apple.com/v1"
SLOTS = {"iphone69": "APP_IPHONE_67", "ipad13": "APP_IPAD_PRO_3GEN_129", "duo": "APP_IPHONE_DUO"}
REMOVE = {"APP_IPHONE_65"}


def jwt():
    return subprocess.check_output(os.environ["ASC_JWT_CMD"], shell=True, text=True).strip()


def call(method, url, body=None, raw=None, headers=None):
    url = url if url.startswith("http") else API + url
    for attempt in range(6):
        h = headers or {"Authorization": f"Bearer {jwt()}", "Content-Type": "application/json"}
        req = urllib.request.Request(url, method=method, headers=h,
                                     data=raw if raw is not None else (json.dumps(body).encode() if body else None))
        try:
            with urllib.request.urlopen(req, timeout=120) as r:
                data = r.read()
                return r.status, (json.loads(data) if data and data[:1] == b"{" else {})
        except urllib.error.HTTPError as e:
            if e.code in (429, 500, 502, 503, 504) and attempt < 5:
                time.sleep(2 ** attempt); continue
            txt = e.read()
            return e.code, (json.loads(txt) if txt[:1] == b"{" else {"raw": txt[:300].decode(errors="replace")})
        except (urllib.error.URLError, TimeoutError, ConnectionError):
            if attempt < 5:
                time.sleep(2 ** attempt); continue
            raise


def upload_one(set_id, png):
    data = png.read_bytes()
    st, r = call("POST", "/appScreenshots", {"data": {"type": "appScreenshots",
                 "attributes": {"fileName": png.name, "fileSize": len(data)},
                 "relationships": {"appScreenshotSet": {"data": {"type": "appScreenshotSets", "id": set_id}}}}})
    if st >= 300:
        return f"reserve failed {st} {r}"
    shot_id = r["data"]["id"]
    for op in r["data"]["attributes"]["uploadOperations"]:
        chunk = data[op["offset"]:op["offset"] + op["length"]]
        hdrs = {h["name"]: h["value"] for h in op.get("requestHeaders", [])}
        st2, r2 = call(op["method"], op["url"], raw=chunk, headers=hdrs)
        if st2 >= 300:
            return f"chunk upload failed {st2} {r2}"
    md5 = hashlib.md5(data).hexdigest()
    st3, r3 = call("PATCH", f"/appScreenshots/{shot_id}", {"data": {"type": "appScreenshots", "id": shot_id,
                   "attributes": {"uploaded": True, "sourceFileChecksum": md5}}})
    if st3 >= 300:
        return f"commit failed {st3} {r3}"
    for _ in range(60):
        _, r4 = call("GET", f"/appScreenshots/{shot_id}?fields%5BappScreenshots%5D=assetDeliveryState")
        state = r4["data"]["attributes"]["assetDeliveryState"]["state"]
        if state == "COMPLETE":
            return "ok"
        if state == "FAILED":
            return f"processing FAILED {r4['data']['attributes']['assetDeliveryState'].get('errors')}"
        time.sleep(3)
    return "processing timeout"


def main():
    final_root, version_id = Path(sys.argv[1]), sys.argv[2]
    only = set(sys.argv[3:])
    _, vl = call("GET", f"/appStoreVersions/{version_id}/appStoreVersionLocalizations?limit=50")
    failures = 0
    for loc_obj in vl["data"]:
        loc, loc_id = loc_obj["attributes"]["locale"], loc_obj["id"]
        if only and loc not in only:
            continue
        _, sets = call("GET", f"/appStoreVersionLocalizations/{loc_id}/appScreenshotSets?limit=50")
        by_type = {s["attributes"]["screenshotDisplayType"]: s["id"] for s in sets.get("data", [])}
        for t in REMOVE & set(by_type):
            st, _ = call("DELETE", f"/appScreenshotSets/{by_type[t]}")
            print(f"{loc}: removed old {t} set ({st})")
        for dev, slot in SLOTS.items():
            pngs = sorted((final_root / "appstore" / dev / loc).glob("[0-9][0-9]_*.png"))
            if not pngs:
                print(f"{loc}: {slot} - no images, skipped"); continue
            if slot in by_type:
                set_id = by_type[slot]
                _, cur = call("GET", f"/appScreenshotSets/{set_id}/appScreenshots?limit=20")
                for s in cur.get("data", []):
                    call("DELETE", f"/appScreenshots/{s['id']}")
            else:
                st, r = call("POST", "/appScreenshotSets", {"data": {"type": "appScreenshotSets",
                             "attributes": {"screenshotDisplayType": slot},
                             "relationships": {"appStoreVersionLocalization": {"data": {"type": "appStoreVersionLocalizations", "id": loc_id}}}}})
                if st >= 300:
                    print(f"{loc}: create {slot} failed {st} {r.get('errors', r)}"); failures += 1; continue
                set_id = r["data"]["id"]
            results = [upload_one(set_id, p) for p in pngs]
            bad = [f"{p.name}: {res}" for p, res in zip(pngs, results) if res != "ok"]
            failures += len(bad)
            print(f"{loc}: {slot} {len(pngs) - len(bad)}/{len(pngs)} uploaded" + (f"  FAIL {bad}" if bad else ""))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
