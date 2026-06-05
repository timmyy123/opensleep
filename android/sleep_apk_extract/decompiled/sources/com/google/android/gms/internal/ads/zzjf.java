package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzjf {
    public int zza = 1;
    public boolean zzb;
    public int zzc;
    private int zzd;

    public final synchronized void zza() {
        this.zzd++;
    }

    public final synchronized void zzb() {
        this.zzd--;
    }

    public final synchronized int zzc() {
        return this.zzd;
    }
}
