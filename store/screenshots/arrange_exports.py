#!/usr/bin/env python3
"""Unzip the screenshot tool's bundles and arrange them for the store uploaders.

Usage: arrange_exports.py <exports_dir> <final_root>
  App Store: final_root/appstore/{iphone69,ipad13,duo}/<locale>/NN_<layout>.png
  Play:      final_root/play/{phone,tablet7,tablet10,feature}/<locale>/NN_<layout>.png
"""
import shutil
import sys
import zipfile
from pathlib import Path

# zip name -> (folder inside the zip "<platform>/<device>/<WxH>", store, slot dir)
MAP = {
    "iphone": ("ios/iphone/1320x2868", "appstore", "iphone69"),
    "ipad": ("ios/ipad/2064x2752", "appstore", "ipad13"),
    "duo-outer": ("ios/duo-outer/1398x2034", "appstore", "duo"),
    "android": ("android/android/1080x1920", "play", "phone"),
    "android-7": ("android/android-7/1200x1920", "play", "tablet7"),
    "android-10": ("android/android-10/1600x2560", "play", "tablet10"),
    "feature-graphic": ("android/feature-graphic/1024x500", "play", "feature"),
}


def main():
    exports, final_root = Path(sys.argv[1]), Path(sys.argv[2])
    for name, (prefix, store, slot) in MAP.items():
        z = exports / f"{name}.zip"
        if not z.exists():
            print(f"{name}: no zip, skipped")
            continue
        out = final_root / store / slot
        shutil.rmtree(out, ignore_errors=True)
        n = 0
        with zipfile.ZipFile(z) as zf:
            for path in zf.namelist():
                # <prefix>/<locale>/NN-<layout>.png
                if not path.startswith(prefix + "/") or not path.endswith(".png"):
                    continue
                locale, fname = path[len(prefix) + 1:].split("/", 1)
                dest = out / locale / fname.replace("-", "_", 1)
                dest.parent.mkdir(parents=True, exist_ok=True)
                dest.write_bytes(zf.read(path))
                n += 1
        print(f"{name} -> {store}/{slot}: {n} images")


if __name__ == "__main__":
    main()
