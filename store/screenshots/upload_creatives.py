#!/usr/bin/env python3
"""Upload the App Store creative asset (product page header + search results) for each version locale.

Usage: ASC_JWT_CMD="<cmd printing a JWT>" upload_creatives.py <final_root> <app_id> <version_id> [locales]
Takes final_root/appstore/creative/<locale>/*.png (5244x2950 universal asset) and places it as both
PRODUCT_PAGE_HEADER_ASSET and APP_STORE_SEARCH_RESULTS_ASSET, replacing any existing ones.
"""
import sys
import time
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from upload_appstore import call  # noqa: E402  (JWT + retrying HTTP helper)

PLACEMENTS = ["PRODUCT_PAGE_HEADER_ASSET", "APP_STORE_SEARCH_RESULTS_ASSET"]


def upload_image(app_id, png, name):
    data = png.read_bytes()
    st, r = call("POST", "/appAssetLibraryImages", {"data": {"type": "appAssetLibraryImages",
                 "attributes": {"category": "CREATIVE_ASSETS", "fileName": name, "fileSize": len(data)},
                 "relationships": {"assetLibrary": {"data": {"type": "appAssetLibraries", "id": app_id}}}}})
    if st >= 300:
        raise RuntimeError(f"reserve {st} {r}")
    img = r["data"]["id"]
    for op in r["data"]["attributes"]["uploadOperations"]:
        hdrs = {h["name"]: h["value"] for h in op.get("requestHeaders", [])}
        st, r2 = call(op["method"], op["url"], raw=data[op["offset"]:op["offset"] + op["length"]], headers=hdrs)
        if st >= 300:
            raise RuntimeError(f"chunk {st} {r2}")
    st, r = call("PATCH", f"/appAssetLibraryImages/{img}", {"data": {"type": "appAssetLibraryImages", "id": img,
                 "attributes": {"uploaded": True}}})
    if st >= 300:
        raise RuntimeError(f"commit {st} {r}")
    for _ in range(80):
        _, r = call("GET", f"/appAssetLibraryImages/{img}")
        state = r["data"]["attributes"]["state"]
        if state in ("PREPARE_FOR_SUBMISSION", "APPROVED") and r["data"]["attributes"].get("imageAsset"):
            return img
        if "FAIL" in state:
            raise RuntimeError(f"processing {state} {r['data']['attributes'].get('stateDetails')}")
        time.sleep(3)
    raise RuntimeError(f"processing timeout ({state})")


def main():
    final_root, app_id, version_id = Path(sys.argv[1]), sys.argv[2], sys.argv[3]
    only = set(sys.argv[4:])
    _, vl = call("GET", f"/appStoreVersions/{version_id}/appStoreVersionLocalizations?limit=50")
    failures = 0
    for loc_obj in vl["data"]:
        loc, loc_id = loc_obj["attributes"]["locale"], loc_obj["id"]
        if only and loc not in only:
            continue
        pngs = sorted((final_root / "appstore" / "creative" / loc).glob("*.png"))
        if not pngs:
            print(f"{loc}: no creative, skipped"); continue
        try:
            img = upload_image(app_id, pngs[0], f"opensleep-creative-{loc}.png")
            _, cur = call("GET", f"/appStoreVersionLocalizations/{loc_id}/placements?limit=200")
            for p in cur.get("data", []):
                if p["attributes"]["placementType"] in PLACEMENTS:
                    call("DELETE", f"/appAssetLibraryPlacements/{p['id']}")
            for t in PLACEMENTS:
                st, r = call("POST", "/appAssetLibraryPlacements", {"data": {"type": "appAssetLibraryPlacements",
                             "attributes": {"placementType": t},
                             "relationships": {"appStoreVersionLocalization": {"data": {"type": "appStoreVersionLocalizations", "id": loc_id}},
                                               "image": {"data": {"type": "appAssetLibraryImages", "id": img}}}}})
                if st >= 300:
                    raise RuntimeError(f"place {t} {st} {r.get('errors', r)}")
            print(f"{loc}: header + search results placed")
        except Exception as e:  # keep going with the other locales
            failures += 1
            print(f"{loc}: FAILED {e}")
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
