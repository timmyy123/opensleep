#!/usr/bin/env python3
"""Push App Store text from store/listings/*.json into an editable App Store version + app info.
Version-level: description, keywords, promotionalText, whatsNew. App-info-level: name, subtitle.
Usage: asc_text.py <listings_dir> <version_id> <app_info_id>   (JWT from ASC_JWT_CMD env)
"""
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.request
from pathlib import Path

API = "https://api.appstoreconnect.apple.com/v1"


def jwt():
    return subprocess.check_output(os.environ["ASC_JWT_CMD"], shell=True, text=True).strip()


def call(method, path, body=None):
    for attempt in range(5):
        req = urllib.request.Request(API + path, method=method,
                                     data=json.dumps(body).encode() if body else None,
                                     headers={"Authorization": f"Bearer {jwt()}", "Content-Type": "application/json"})
        try:
            with urllib.request.urlopen(req) as r:
                raw = r.read()
                return r.status, (json.loads(raw) if raw else {})
        except urllib.error.HTTPError as e:
            if e.code in (429, 500, 502, 503) and attempt < 4:
                time.sleep(2 ** attempt)
                continue
            return e.code, json.loads(e.read() or b"{}")


def main():
    listings, version_id, info_id = Path(sys.argv[1]), sys.argv[2], sys.argv[3]
    _, vl = call("GET", f"/appStoreVersions/{version_id}/appStoreVersionLocalizations?limit=50")
    _, il = call("GET", f"/appInfos/{info_id}/appInfoLocalizations?limit=50")
    ver_by = {x["attributes"]["locale"]: x["id"] for x in vl.get("data", [])}
    info_by = {x["attributes"]["locale"]: x["id"] for x in il.get("data", [])}
    ok = True
    for f in sorted(listings.glob("*.json")):
        d = json.loads(f.read_text(encoding="utf-8"))
        for loc in d.get("appStoreLocales", []):
            a = d["appStore"]
            vattrs = {k: a[k] for k in ("description", "keywords", "promotionalText", "whatsNew")}
            if loc in ver_by:
                st, r = call("PATCH", f"/appStoreVersionLocalizations/{ver_by[loc]}",
                             {"data": {"type": "appStoreVersionLocalizations", "id": ver_by[loc], "attributes": vattrs}})
            else:
                st, r = call("POST", "/appStoreVersionLocalizations",
                             {"data": {"type": "appStoreVersionLocalizations", "attributes": {"locale": loc, **vattrs},
                                       "relationships": {"appStoreVersion": {"data": {"type": "appStoreVersions", "id": version_id}}}}})
            iattrs = {"name": a["name"], "subtitle": a["subtitle"]}
            if loc in info_by:
                st2, r2 = call("PATCH", f"/appInfoLocalizations/{info_by[loc]}",
                               {"data": {"type": "appInfoLocalizations", "id": info_by[loc], "attributes": iattrs}})
            else:
                st2, r2 = call("POST", "/appInfoLocalizations",
                               {"data": {"type": "appInfoLocalizations", "attributes": {"locale": loc, **iattrs},
                                         "relationships": {"appInfo": {"data": {"type": "appInfos", "id": info_id}}}}})
            errs = [e.get("detail") for e in (r.get("errors", []) + r2.get("errors", []))]
            print(f"{loc:6} version {st}  info {st2}  {'; '.join(errs)[:200]}")
            ok &= st < 300 and st2 < 300
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
