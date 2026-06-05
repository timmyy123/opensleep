package com.google.android.gms.internal.consent_sdk;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzde extends zzdd {
    public zzde(char c) {
    }

    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i = 44;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return FileInsert$$ExternalSyntheticOutline0.m("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }
}
