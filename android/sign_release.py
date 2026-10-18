#!/usr/bin/env python3
"""Build and sign the Play release bundle using passwords from the environment.

Reads OPENSLEEP_STORE_PW / OPENSLEEP_KEY_PW (never printed, never put on a command line) and hands
them to Gradle through ORG_GRADLE_PROJECT_android.injected.signing.* environment variables.
Then checks the AAB's signing certificate against the upload key Play expects.

Usage (from the shell where the two variables are exported):  python3 android/sign_release.py
"""
import os
import subprocess
import sys
from pathlib import Path

ANDROID_DIR = Path(__file__).resolve().parent
KEYSTORE = Path.home() / "Downloads" / "opensleep.jks"
ALIAS = "key0"
EXPECTED_SHA256 = "12:16:E0:EB:8F:13:65:2E:59:20:C6:19:26:3E:FC:08:9F:DF:B6:4B:38:79:AB:AC:9E:5D:84:E7:73:E3:5E:C1"
JBR = "/Applications/Android Studio.app/Contents/jbr/Contents/Home"


def main():
    # Either OPENSLEEP_STORE_PW/OPENSLEEP_KEY_PW, or OPENSLEEP_PW_FILE pointing at a file holding the
    # (shared) password. The file is read here so the password never appears on a command line.
    pw_file = os.environ.get("OPENSLEEP_PW_FILE")
    if pw_file:
        pw = Path(pw_file).read_text().strip()
        os.environ.setdefault("OPENSLEEP_STORE_PW", pw)
        os.environ.setdefault("OPENSLEEP_KEY_PW", pw)
    missing = [v for v in ("OPENSLEEP_STORE_PW", "OPENSLEEP_KEY_PW") if not os.environ.get(v)]
    if missing:
        sys.exit(f"Missing env vars: {', '.join(missing)} (export them in this shell first)")
    if not KEYSTORE.exists():
        sys.exit(f"Keystore not found: {KEYSTORE}")

    env = dict(os.environ)
    env.setdefault("JAVA_HOME", JBR)
    env.setdefault("ANDROID_HOME", str(Path.home() / "Library/Android/sdk"))
    env["ORG_GRADLE_PROJECT_android.injected.signing.store.file"] = str(KEYSTORE)
    env["ORG_GRADLE_PROJECT_android.injected.signing.store.password"] = os.environ["OPENSLEEP_STORE_PW"]
    env["ORG_GRADLE_PROJECT_android.injected.signing.key.alias"] = ALIAS
    env["ORG_GRADLE_PROJECT_android.injected.signing.key.password"] = os.environ["OPENSLEEP_KEY_PW"]

    print("Building signed release bundle (bundleRelease)...", flush=True)
    r = subprocess.run(["./gradlew", ":app:bundleRelease", "--console=plain", "-q"], cwd=ANDROID_DIR, env=env)
    if r.returncode != 0:
        sys.exit("Gradle build failed")

    aab = ANDROID_DIR / "app/build/outputs/bundle/release/app-release.aab"
    out = subprocess.run([f"{env['JAVA_HOME']}/bin/keytool", "-printcert", "-jarfile", str(aab)],
                         capture_output=True, text=True).stdout
    sha = next((l.split("SHA256:")[1].strip() for l in out.splitlines() if "SHA256:" in l), "")
    if sha.upper() != EXPECTED_SHA256:
        sys.exit(f"Signed with an unexpected certificate ({sha[:23]}...); Play would reject it.")
    print(f"OK: {aab} ({aab.stat().st_size / 1e6:.1f} MB), signed with the Play upload key.")
    print("SIGN_RELEASE_DONE")


if __name__ == "__main__":
    main()
