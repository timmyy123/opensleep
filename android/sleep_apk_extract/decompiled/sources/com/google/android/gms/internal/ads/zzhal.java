package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhal {
    public static byte zza(long j) {
        zzgtj.zze((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }
}
