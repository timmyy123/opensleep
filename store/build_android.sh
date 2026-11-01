#!/bin/zsh
# Build the signed Play bundle for OpenSleep and keep its R8 mapping.
# usage: build_android.sh <versionCode> <out_dir>   (bump android/app/build.gradle.kts first)
# The upload keystore is ~/Downloads/opensleep.jks (alias "key0"); its password is read from the macOS
# Keychain (service opensleep-android-upload-key, account key), added once with:
#   security add-generic-password -s opensleep-android-upload-key -a key -w
# or from the file named by OPENSLEEP_KEY_PASSWORD_FILE when that is set.
set -euo pipefail
REPO=${0:A:h:h}; CODE=$1; OUT=$2
export JAVA_HOME="/Applications/Android Studio.app/Contents/jbr/Contents/Home"
grep -q "versionCode = $CODE" $REPO/android/app/build.gradle.kts || { echo "build.gradle.kts is not at versionCode $CODE"; exit 1; }
mkdir -p $OUT
if [[ -n ${OPENSLEEP_KEY_PASSWORD_FILE:-} ]]; then
  P=$(<$OPENSLEEP_KEY_PASSWORD_FILE)
else
  P=$(security find-generic-password -s opensleep-android-upload-key -a key -w)
fi
cd $REPO/android
env "ORG_GRADLE_PROJECT_android.injected.signing.store.file=$HOME/Downloads/opensleep.jks" \
    "ORG_GRADLE_PROJECT_android.injected.signing.store.password=$P" \
    "ORG_GRADLE_PROJECT_android.injected.signing.key.alias=key0" \
    "ORG_GRADLE_PROJECT_android.injected.signing.key.password=$P" \
    ./gradlew :app:bundleRelease --console=plain > $OUT/android-$CODE.log 2>&1 || { unset P; tail -30 $OUT/android-$CODE.log; exit 1; }
unset P
cp app/build/outputs/bundle/release/app-release.aab $OUT/app-release-$CODE.aab
cp app/build/outputs/mapping/release/mapping.txt $OUT/mapping-$CODE.txt
"$JAVA_HOME/bin/keytool" -printcert -jarfile $OUT/app-release-$CODE.aab | grep -m1 SHA256
echo "bundle: $OUT/app-release-$CODE.aab"
