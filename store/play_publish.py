#!/usr/bin/env python3
"""Publish OpenSleep to Google Play in a single edit.

Usage: play_publish.py --sa <service-account.json> --aab <app-release.aab> --mapping <mapping.txt>
                       --listings store/listings --shots <final_root>/play [--track production] [--commit]
Without --commit the edit is validated and then deleted (dry run).
"""
import argparse
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.request
from pathlib import Path

PKG = "tech.opensleep"
API = f"https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{PKG}"
UPLOAD = f"https://androidpublisher.googleapis.com/upload/androidpublisher/v3/applications/{PKG}"
IMAGE_SETS = {"phone": ["phoneScreenshots"], "tablet7": ["sevenInchScreenshots"],
              "tablet10": ["tenInchScreenshots"], "feature": ["featureGraphic"]}


class Play:
    def __init__(self, sa):
        self.sa = sa
        self.refresh()

    def refresh(self):
        env = dict(os.environ, CLOUDSDK_AUTH_CREDENTIAL_FILE_OVERRIDE=self.sa)
        for attempt in range(6):
            try:
                self.token = subprocess.check_output(["gcloud", "auth", "print-access-token",
                                                      "--scopes=https://www.googleapis.com/auth/androidpublisher"],
                                                     env=env, text=True, stderr=subprocess.DEVNULL).strip()
                return
            except subprocess.CalledProcessError:
                if attempt == 5:
                    raise
                time.sleep(2 ** attempt)

    def call(self, method, url, body=None, raw=None, ctype="application/json"):
        data = raw if raw is not None else (json.dumps(body).encode() if body is not None else None)
        for attempt in range(6):
            req = urllib.request.Request(url, method=method, data=data,
                                         headers={"Authorization": f"Bearer {self.token}", "Content-Type": ctype})
            try:
                with urllib.request.urlopen(req, timeout=600) as r:
                    txt = r.read()
                    return r.status, (json.loads(txt) if txt else {})
            except urllib.error.HTTPError as e:
                if attempt < 5 and e.code == 401:
                    self.refresh(); continue
                if attempt < 5 and e.code in (429, 500, 502, 503, 504):
                    time.sleep(2 ** attempt); continue
                txt = e.read()
                try:
                    return e.code, json.loads(txt)
                except Exception:
                    return e.code, {"raw": txt[:400].decode(errors="replace")}
            except (urllib.error.URLError, TimeoutError, ConnectionError):
                if attempt == 5:
                    raise
                time.sleep(2 ** attempt)

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--sa", required=True); ap.add_argument("--aab", required=True); ap.add_argument("--mapping")
    ap.add_argument("--listings", required=True); ap.add_argument("--shots", required=True)
    ap.add_argument("--track", default="production"); ap.add_argument("--commit", action="store_true")
    a = ap.parse_args()

    p = Play(a.sa)
    st, e = p.call("POST", f"{API}/edits", {})
    if st >= 300:
        sys.exit(f"open edit failed: {st} {e}")
    edit = e["id"]
    E = f"{API}/edits/{edit}"
    ok = True

    def fail(msg):
        nonlocal ok
        ok = False
        print("ERROR", msg)

    try:
        notes = []
        for f in sorted(Path(a.listings).glob("*.json")):
            d = json.loads(f.read_text(encoding="utf-8"))
            for lang in d.get("playLocales", []):
                pl = d["play"]
                st, r = p.call("PUT", f"{E}/listings/{lang}", {"language": lang, "title": pl["title"],
                               "shortDescription": pl["shortDescription"], "fullDescription": pl["fullDescription"]})
                if st >= 300: fail(f"listing {lang}: {st} {r.get('error', r)}"); continue
                notes.append({"language": lang, "text": pl["releaseNotes"]})
                img_note = []
                for dev, types in IMAGE_SETS.items():
                    pngs = sorted((Path(a.shots) / dev / lang).glob("[0-9][0-9]_*.png"))[:8]
                    if not pngs:
                        continue
                    for t in types:
                        p.call("DELETE", f"{E}/listings/{lang}/{t}")
                        for png in pngs:
                            st, r = p.call("POST", f"{UPLOAD}/edits/{edit}/listings/{lang}/{t}?uploadType=media",
                                           raw=png.read_bytes(), ctype="image/png")
                            if st >= 300: fail(f"{lang} {t} {png.name}: {st} {r.get('error', r)}")
                        img_note.append(f"{t}={len(pngs)}")
                print(f"listing {lang}: ok {' '.join(img_note)}")

        st, r = p.call("POST", f"{UPLOAD}/edits/{edit}/bundles?uploadType=media", raw=Path(a.aab).read_bytes(),
                       ctype="application/octet-stream")
        if st >= 300:
            fail(f"bundle upload: {st} {r.get('error', r)}")
        else:
            vc = r["versionCode"]
            print(f"bundle uploaded: versionCode {vc}")
            if a.mapping and Path(a.mapping).exists():
                st, r = p.call("POST", f"{UPLOAD}/edits/{edit}/apks/{vc}/deobfuscationFiles/proguard?uploadType=media",
                               raw=Path(a.mapping).read_bytes(), ctype="application/octet-stream")
                print(f"mapping.txt: {'ok' if st < 300 else (st, r.get('error', r))}")
            st, r = p.call("PUT", f"{E}/tracks/{a.track}", {"track": a.track, "releases": [{
                "name": "1.0.6", "versionCodes": [str(vc)], "status": "completed", "releaseNotes": notes}]})
            if st >= 300: fail(f"track {a.track}: {st} {r.get('error', r)}")
            else: print(f"track {a.track}: release 1.0.6 (versionCode {vc}) with notes in {len(notes)} languages")

        st, r = p.call("POST", f"{E}:validate")
        if st >= 300: fail(f"validate: {st} {r.get('error', r)}")
        else: print("edit validated")

        if ok and a.commit:
            st, r = p.call("POST", f"{E}:commit")
            if st >= 300: fail(f"commit: {st} {r.get('error', r)}")
            else: print(f"COMMITTED edit {edit}"); return
    finally:
        if not (ok and a.commit):
            p.call("DELETE", E)
            print("edit discarded (dry run or error)")
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
