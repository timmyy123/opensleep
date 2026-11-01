#!/usr/bin/env bash
# Prints an App Store Connect ES256 JWT to stdout (never echo it; use inside $(...)).
# Usage: asc_jwt.sh <p8-path> <key-id> [issuer-id]
#   With issuer-id -> team key ("iss"). Without -> individual key ("sub":"user").
set -euo pipefail
P8="$1"; KID="$2"; ISS="${3:-}"
b64url() { openssl base64 -A | tr '+/' '-_' | tr -d '='; }
now=$(date +%s); exp=$((now + 600))
header=$(printf '{"alg":"ES256","kid":"%s","typ":"JWT"}' "$KID" | b64url)
if [[ -n "$ISS" ]]; then
  payload=$(printf '{"iss":"%s","iat":%d,"exp":%d,"aud":"appstoreconnect-v1"}' "$ISS" "$now" "$exp" | b64url)
else
  payload=$(printf '{"sub":"user","iat":%d,"exp":%d,"aud":"appstoreconnect-v1"}' "$now" "$exp" | b64url)
fi
# openssl emits a DER ECDSA signature; convert to raw r||s (32 bytes each).
sig=$(printf '%s.%s' "$header" "$payload" \
  | openssl dgst -sha256 -sign "$P8" \
  | python3 -I -c '
import sys
d = sys.stdin.buffer.read()
assert d[0] == 0x30
i = 2 if d[1] < 0x80 else 2 + (d[1] & 0x7f)
def read_int(i):
    assert d[i] == 0x02
    n = d[i+1]; v = d[i+2:i+2+n]
    return v.lstrip(b"\x00").rjust(32, b"\x00"), i + 2 + n
r, i = read_int(i); s, _ = read_int(i)
sys.stdout.buffer.write(r + s)' | b64url)
printf '%s.%s.%s' "$header" "$payload" "$sig"
