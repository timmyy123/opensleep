package com.google.android.gms.internal.measurement;

import java.nio.charset.StandardCharsets;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzagi {
    public static final int zza(String str, byte[] bArr, int i, int i2) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        if (length - i <= i2) {
            System.arraycopy(bytes, 0, bArr, i, length);
            return i + length;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1("Not enough space in output buffer to encode UTF-8 string");
        return 0;
    }
}
