#!/usr/bin/env python3
"""Render the App Store creative asset (product page header + search results), feature-graphic style.

Usage: render_creative.py <raw_root> <final_root> [locales]
  raw_root:   iPhone captures at <raw_root>/iphone69-farm/<ui_lang>/{home,history-week,chat,detail}.png
  final_root: writes <final_root>/appstore/creative/<locale>/01_creative.png (5244x2950 universal asset)

Icon, app name and tagline sit inside Apple's art safe area (x 1921-3323, y 660-1622); real app screens
in iPhone frames fill the rest of the canvas so the banner stays full-bleed in every crop.
"""
import html
import json
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path

from PIL import Image

HERE = Path(__file__).resolve().parent
EDITOR = HERE.parent / "screenshot-editor" / "public"
CHROME = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"
W, H = 5244, 2950
SAFE = (1921, 660, 3323, 1622)
APP_STORE = ["en-US", "de-DE", "es-ES", "es-MX", "fr-FR", "fr-CA", "it", "pt-BR", "pt-PT"]
UI_LANGS = {"en", "es", "de", "fr", "it", "pt"}

# Frame PNG is 1470x3000 with the 1320x2868 screen cutout at (75, 66).
FRAME_W, FRAME_H, SCR_X, SCR_Y, SCR_W, SCR_H, SCR_R = 1470, 3000, 75, 66, 1320, 2868, 200
# (capture, centre x, centre y, scale, rotation deg, z) - two phones each side, fanned outwards.
PHONES = [
    ("history-week", 420, 1700, 0.74, -12, 1),
    ("home", 1250, 1560, 0.84, -5, 2),
    ("chat", 3994, 1560, 0.84, 5, 2),
    ("detail", 4824, 1700, 0.74, 12, 1),
]


def ui_lang(locale):
    lang = locale.split("-")[0]
    return lang if lang in UI_LANGS else "en"


def phone_html(src, cx, cy, scale, rot, z):
    w, h = FRAME_W * scale, FRAME_H * scale
    return f"""
<div class="phone" style="left:{cx - w / 2}px;top:{cy - h / 2}px;width:{w}px;height:{h}px;transform:rotate({rot}deg);z-index:{z}">
  <img class="screen" src="{src}" style="left:{SCR_X * scale}px;top:{SCR_Y * scale}px;width:{SCR_W * scale}px;height:{SCR_H * scale}px;border-radius:{SCR_R * scale}px">
  <img class="frame" src="{(EDITOR / 'frames' / 'iphone-portrait.png').as_uri()}">
</div>"""


def page(locale, raw_root, tagline):
    shots = raw_root / "iphone69-farm" / ui_lang(locale)
    phones = "".join(phone_html((shots / f"{name}.png").as_uri(), *rest) for name, *rest in PHONES)
    sx0, sy0, sx1, sy1 = SAFE
    lines = "<br>".join(html.escape(l) for l in tagline.split("\n"))
    return f"""<!doctype html><html lang="{locale}"><head><meta charset="utf-8"><style>
html,body{{margin:0;width:{W}px;height:{H}px;overflow:hidden;background:#07080B}}
body{{font-family:-apple-system,BlinkMacSystemFont,"SF Pro Display","Helvetica Neue",sans-serif;color:#F4F5F8;position:relative}}
.bg{{position:absolute;inset:0;background:
  radial-gradient(ellipse 1900px 1300px at 50% 40%, rgba(124,118,255,.55), rgba(59,56,200,.18) 55%, transparent 75%),
  radial-gradient(ellipse 1500px 1500px at 12% 70%, rgba(59,56,200,.45), transparent 70%),
  radial-gradient(ellipse 1500px 1500px at 88% 70%, rgba(59,56,200,.45), transparent 70%),
  linear-gradient(180deg,#141538 0%,#0B0C1E 55%,#07080B 100%)}}
.stars{{position:absolute;inset:0;background-image:
  radial-gradient(3px 3px at 22% 18%,rgba(255,255,255,.55),transparent),radial-gradient(2px 2px at 35% 9%,rgba(255,255,255,.45),transparent),
  radial-gradient(3px 3px at 64% 14%,rgba(255,255,255,.5),transparent),radial-gradient(2px 2px at 78% 24%,rgba(255,255,255,.4),transparent),
  radial-gradient(2px 2px at 46% 6%,rgba(255,255,255,.35),transparent),radial-gradient(3px 3px at 56% 27%,rgba(255,255,255,.3),transparent),
  radial-gradient(2px 2px at 8% 30%,rgba(255,255,255,.35),transparent),radial-gradient(2px 2px at 92% 12%,rgba(255,255,255,.4),transparent)}}
.phone{{position:absolute;filter:drop-shadow(0 60px 120px rgba(0,0,0,.7)) drop-shadow(0 0 140px rgba(124,118,255,.35))}}
.phone img{{position:absolute;display:block}}
.frame{{left:0;top:0;width:100%;height:100%}}
.shade{{position:absolute;inset:0;z-index:3;background:linear-gradient(180deg,transparent 62%,rgba(7,8,11,.85) 100%)}}
.copy{{position:absolute;z-index:4;left:{sx0}px;top:{sy0}px;width:{sx1 - sx0}px;height:{sy1 - sy0}px;
  display:flex;flex-direction:column;align-items:center;justify-content:center;text-align:center}}
.icon{{width:300px;height:300px;border-radius:68px;box-shadow:0 30px 90px rgba(0,0,0,.55),0 0 120px rgba(179,175,255,.45)}}
.name{{font-size:212px;font-weight:800;letter-spacing:-4px;line-height:1;margin-top:64px}}
.tag{{font-size:96px;font-weight:600;line-height:1.14;margin-top:44px;color:#DCDAFF}}
</style></head><body>
<div class="bg"></div><div class="stars"></div>{phones}<div class="shade"></div>
<div class="copy"><img class="icon" src="{(EDITOR / 'app-icon.png').as_uri()}"><div class="name">OpenSleep</div><div class="tag">{lines}</div></div>
</body></html>"""


def main():
    raw_root, final_root = Path(sys.argv[1]), Path(sys.argv[2])
    locales = sys.argv[3:] or APP_STORE
    taglines = json.loads((HERE / "captions" / "ai-headline.json").read_text(encoding="utf-8"))
    tmp = Path(tempfile.mkdtemp(prefix="creative-"))
    try:
        for loc in locales:
            src = tmp / f"{loc}.html"
            src.write_text(page(loc, raw_root, taglines[loc]), encoding="utf-8")
            png = tmp / f"{loc}.png"
            subprocess.run([CHROME, "--headless=new", "--disable-gpu", "--hide-scrollbars", "--allow-file-access-from-files",
                            f"--user-data-dir={tmp / 'profile'}", f"--window-size={W},{H}", "--force-device-scale-factor=1",
                            "--virtual-time-budget=4000", f"--screenshot={png}", src.as_uri()],
                           check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            out = final_root / "appstore" / "creative" / loc
            shutil.rmtree(out, ignore_errors=True)
            out.mkdir(parents=True)
            im = Image.open(png).convert("RGB")
            assert im.size == (W, H), im.size
            im.save(out / "01_creative.png", optimize=True)
            print(f"{loc}: {out / '01_creative.png'}")
    finally:
        shutil.rmtree(tmp, ignore_errors=True)


if __name__ == "__main__":
    main()
