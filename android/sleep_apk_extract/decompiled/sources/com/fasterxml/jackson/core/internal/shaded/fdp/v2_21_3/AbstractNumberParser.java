package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractNumberParser {
    static final byte[] CHAR_TO_HEX_MAP;

    static {
        byte[] bArr = new byte[256];
        CHAR_TO_HEX_MAP = bArr;
        Arrays.fill(bArr, (byte) -1);
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            CHAR_TO_HEX_MAP[c] = (byte) (c - '0');
        }
        for (char c2 = 'A'; c2 <= 'F'; c2 = (char) (c2 + 1)) {
            CHAR_TO_HEX_MAP[c2] = (byte) (c2 - '7');
        }
        for (char c3 = 'a'; c3 <= 'f'; c3 = (char) (c3 + 1)) {
            CHAR_TO_HEX_MAP[c3] = (byte) (c3 - 'W');
        }
        CHAR_TO_HEX_MAP[46] = -4;
    }

    public static char charAt(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            return charSequence.charAt(i);
        }
        return (char) 0;
    }

    public static int checkBounds(int i, int i2, int i3) {
        if ((((i - i3) - i2) | i2 | i3) >= 0) {
            return i3 + i2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("offset < 0 or length > str.length");
        return 0;
    }

    public static int lookupHex(char c) {
        if (c < 128) {
            return CHAR_TO_HEX_MAP[c];
        }
        return -1;
    }

    public static char charAt(char[] cArr, int i, int i2) {
        if (i < i2) {
            return cArr[i];
        }
        return (char) 0;
    }
}
