package com.google.gdata.util.common.base;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnicodeEscaper {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: com.google.gdata.util.common.base.UnicodeEscaper.2
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    public static final int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i >= i2) {
            Events$$ExternalSyntheticBUOutline0.m$2("Index exceeds specified range");
            return 0;
        }
        int i3 = i + 1;
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            Gson$$ExternalSyntheticBUOutline0.m(cCharAt, i, "Unexpected low surrogate character '");
            return 0;
        }
        if (i3 == i2) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i3);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        Gson$$ExternalSyntheticBUOutline0.m(cCharAt2, i3, "Expected low surrogate but got char '");
        return 0;
    }

    private static final char[] growBuffer(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    public abstract char[] escape(int i);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrGrowBuffer = DEST_TL.get();
        int i2 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Trailing high surrogate at end of input");
                return null;
            }
            char[] cArrEscape = escape(iCodePointAt);
            if (cArrEscape != null) {
                int i3 = i - i2;
                int i4 = length2 + i3;
                int length3 = cArrEscape.length + i4;
                if (cArrGrowBuffer.length < length3) {
                    cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, (length - i) + length3 + 32);
                }
                if (i3 > 0) {
                    str.getChars(i2, i, cArrGrowBuffer, length2);
                    length2 = i4;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrGrowBuffer, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
            }
            i2 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            i = nextEscapeIndex(str, i2, length);
        }
        int i5 = length - i2;
        if (i5 > 0) {
            int i6 = i5 + length2;
            if (cArrGrowBuffer.length < i6) {
                cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, i6);
            }
            str.getChars(i2, length, cArrGrowBuffer, length2);
            length2 = i6;
        }
        return new String(cArrGrowBuffer, 0, length2);
    }

    public abstract int nextEscapeIndex(CharSequence charSequence, int i, int i2);
}
