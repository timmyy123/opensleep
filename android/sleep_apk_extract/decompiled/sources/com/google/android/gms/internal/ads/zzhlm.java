package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhlm {
    public static boolean zza(String str) {
        int length = str.length();
        int i = 0;
        while (i != length) {
            char cCharAt = str.charAt(i);
            int i2 = i + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i = i2;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i2 == length || !Character.isLowSurrogate(str.charAt(i2))) {
                    return false;
                }
                i += 2;
            }
        }
        return true;
    }

    public static zzibg zzb(String str) throws IOException {
        try {
            zzicd zzicdVar = new zzicd(new StringReader(str));
            zzicdVar.zza(zzibl.LEGACY_STRICT);
            return zzhlk.zza(zzicdVar);
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    public static long zzc(Number number) {
        if (number instanceof zzhll) {
            return Long.parseLong(number.toString());
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("does not contain a parsed number.");
        return 0L;
    }
}
