package com.google.android.gms.fitness.data;

/* JADX INFO: loaded from: classes3.dex */
public final class zzag {
    private final double zza;
    private final double zzb;

    public /* synthetic */ zzag(double d, double d2, byte[] bArr) {
        this.zza = d;
        this.zzb = d2;
    }

    public final boolean zza(double d) {
        return d >= this.zza && d <= this.zzb;
    }
}
