package com.google.android.gms.internal.ads;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgea {
    public static String zza(byte[] bArr, boolean z) {
        return zzc(z).zzj(bArr, 0, bArr.length);
    }

    public static byte[] zzb(String str, boolean z) {
        byte[] bArrZzk = zzc(z).zzk(str);
        if (bArrZzk.length != 0 || str.length() <= 0) {
            return bArrZzk;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Unable to decode ".concat(str));
        return null;
    }

    private static zzgzh zzc(boolean z) {
        return z ? zzgzh.zzm().zzh() : zzgzh.zzl();
    }
}
