package com.google.android.gms.nearby.connection;

/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private int zza;
    private int zzb;

    public final zze zza(int i) {
        this.zzb = i;
        return this;
    }

    public final zze zzb(int i) {
        this.zza = i;
        return this;
    }

    public final BandwidthInfo zzc() {
        return new BandwidthInfo(this.zza, this.zzb, null);
    }
}
