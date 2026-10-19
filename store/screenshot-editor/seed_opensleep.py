#!/usr/bin/env python3
"""Seed the app-store-screenshots editor project for OpenSleep.

- Hard-links real device captures into public/screenshots/... for every store locale
  (screenshot UI language = locale's language if the app ships it, else English).
- Writes app-store-screenshots.json: Midnight Glow Pro theme, localized label + headline per slide,
  decks for iPhone, iPad, iPhone Duo (outer, portrait), Android phone / 7" / 10" tablet and the feature graphic.

Usage: seed_opensleep.py <raw_root>   (re-run any time captures change)
"""
import json
import os
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
CAPTIONS = HERE.parent / "screenshots" / "captions"
UI_LANGS = {"en", "es", "de", "fr", "it", "pt"}
APP_STORE = ["en-US", "de-DE", "es-ES", "es-MX", "fr-FR", "fr-CA", "it", "pt-BR", "pt-PT"]
PLAY = ["en-US", "ar", "cs-CZ", "da-DK", "de-DE", "es-ES", "es-419", "es-US", "fi-FI", "fr-FR", "hi-IN", "hu-HU", "id",
        "it-IT", "iw-IL", "ja-JP", "ko-KR", "nl-NL", "no-NO", "pl-PL", "pt-BR", "ro", "ru-RU", "sk", "sv-SE", "th",
        "tr-TR", "uk", "vi", "zh-CN"]
LOCALES = list(dict.fromkeys(APP_STORE + PLAY))

# deck -> (raw capture dir, public subdir, ordered capture names)
FULL = ["chat", "detail", "history-week", "home"]
ANDROID = FULL  # Week chart labels fixed on Android too
DECKS = {
    "iphone": ("iphone69-farm", "apple/iphone", FULL),
    "ipad": ("ipad13-farm", "apple/ipad", FULL),
    "duo-outer": ("duo", "apple/duo-outer/portrait", FULL),
    # Android skips the Week chart: its day labels still overlap on Android (iOS is fixed).
    "android": ("android-phone", "android/phone", ANDROID),
    "android-10": ("android-tablet", "android/tablet-10/portrait", ANDROID),
    "android-7": ("android-tablet", "android/tablet-7/portrait", ANDROID),
}
SLIDE_FOR = {"chat": "chat", "detail": "stages", "history-week": "history", "home": "track"}
LAYOUT = {"chat": "hero", "detail": "device-bottom", "history-week": "device-top", "home": "hero"}


def ui_lang(loc):
    lang = loc.split("-")[0]
    return lang if lang in UI_LANGS else "en"


def link(src, dst):
    dst.parent.mkdir(parents=True, exist_ok=True)
    if dst.exists() or dst.is_symlink():
        dst.unlink()
    os.link(src, dst)


AI_HEADLINE = json.loads((CAPTIONS / "ai-headline.json").read_text(encoding="utf-8"))


def text_for(loc, key, field):
    c = json.loads((CAPTIONS / f"{loc}.json").read_text(encoding="utf-8"))["slides"][key]
    if field == "headline" and key == "chat":
        return AI_HEADLINE[loc]  # says the AI runs on the device itself
    if field == "headline":
        return c["headline"].replace("*", "").replace(" / ", "\n")
    # Label: the short eyebrow (pill tag on hero slides, section word on the others).
    if "pill_tag" in c:
        return c["pill_tag"]
    return c["eyebrow"].split(" / ", 1)[-1]


def main():
    raw_root = Path(sys.argv[1])
    public = HERE / "public" / "screenshots"
    decks, report = {}, []
    for deck, (raw_name, sub, shots) in DECKS.items():
        raw = raw_root / raw_name
        available = [s for s in shots if all((raw / ui_lang(l) / f"{s}.png").exists() for l in LOCALES)]
        for loc in LOCALES:
            for i, s in enumerate(available, 1):
                link(raw / ui_lang(loc) / f"{s}.png", public / sub / loc / f"{i:02d}.png")
        slides = []
        for i, s in enumerate(available, 1):
            key = SLIDE_FOR[s]
            slide = {
                "id": f"{deck}-{key}",
                "layout": LAYOUT[s],
                "label": {loc: text_for(loc, key, "label") for loc in LOCALES},
                "headline": {loc: text_for(loc, key, "headline") for loc in LOCALES},
                "screenshot": f"/screenshots/{sub}/{{locale}}/{i:02d}.png",
            }
            if s == "history-week":
                slide["inverted"] = True
            if s == "detail" and deck != "duo-outer":
                # iPad shows the detail page as a centered sheet, so its stage ring sits lower.
                focus_y = 0.50 if deck == "ipad" else 0.36
                slide["callout"] = {"focusX": 0.5, "focusY": focus_y, "zoom": 2.2, "shape": "circle"}
            if s == "chat":
                # Keep "AI sleep coach. / Runs on your device." on two lines on every device.
                slide["typography"] = {"headlineScale": 0.82}
            slides.append(slide)
        decks[deck] = slides
        report.append(f"{deck}: {len(slides)} slides ({', '.join(available) or 'no captures yet'})")

    fg_head = {loc: text_for(loc, "chat", "headline").replace("\n", " ") for loc in LOCALES}
    decks["feature-graphic"] = [{"id": "fg-1", "layout": "feature-graphic",
                                 "label": {loc: "" for loc in LOCALES}, "headline": fg_head, "screenshot": ""}]

    proj_file = HERE / "app-store-screenshots.json"
    state = json.loads(proj_file.read_text()) if proj_file.exists() else {}
    state.get("slidesByDevice", {}).pop("creative-universal", None)  # creatives come from render_creative.py
    state.update({
        "schemaVersion": max(state.get("schemaVersion", 2), 2),
        "appName": "OpenSleep",
        "themeId": "midnight-glow-pro",
        "connectedCanvas": True,
        "locales": LOCALES,
        "locale": "en-US",
        "device": "iphone",
        "orientation": "portrait",
        "appIcon": "/app-icon.png",
        "scene": {"backdrop": "spotlight", "span": True, "decoration": "none", "shadow": 70, "glow": 75,
                  "tilt": 0, "headlineWeight": 600, "headlineCase": "as-typed", "captionAlign": "auto"},
        "slidesByDevice": decks,
    })
    proj_file.write_text(json.dumps(state, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
    print("\n".join(report))
    print(f"locales: {len(LOCALES)}")


if __name__ == "__main__":
    main()
