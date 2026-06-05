package com.google.android.gms.internal.clearcut;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbk {
    private int zzfq;
    private int zzfr;
    private boolean zzfs;

    private zzbk() {
        this.zzfq = 100;
        this.zzfr = Integer.MAX_VALUE;
        this.zzfs = false;
    }

    public static zzbk zza(byte[] bArr, int i, int i2, boolean z) {
        zzbm zzbmVar = new zzbm(bArr, 0, i2, false);
        try {
            zzbmVar.zzl(i2);
            return zzbmVar;
        } catch (zzco e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static int zzm(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }
}
