package com.google.api.client.util.escape;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnicodeEscaper extends Escaper {
    public static int codePointAt(CharSequence charSequence, int i, int i2) {
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

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    public abstract char[] escape(int i);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i2 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Trailing high surrogate at end of input");
                return null;
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i3 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            if (cArrEscape != null) {
                int i4 = i - i2;
                int i5 = length2 + i4;
                int length3 = cArrEscape.length + i5;
                if (cArrCharBufferFromThreadLocal.length < length3) {
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, zzba$$ExternalSyntheticOutline0.m$1(length3, length, i, 32));
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArrCharBufferFromThreadLocal, length2);
                    length2 = i5;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i2 = i3;
            }
            i = nextEscapeIndex(str, i3, length);
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = i6 + length2;
            if (cArrCharBufferFromThreadLocal.length < i7) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, i7);
            }
            str.getChars(i2, length, cArrCharBufferFromThreadLocal, length2);
            length2 = i7;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, length2);
    }

    public abstract int nextEscapeIndex(CharSequence charSequence, int i, int i2);
}
