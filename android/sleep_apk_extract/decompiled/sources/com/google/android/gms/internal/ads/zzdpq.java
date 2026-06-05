package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdpq {
    private zzbmb zza;

    public zzdpq(zzdpb zzdpbVar) {
        this.zza = zzdpbVar;
    }

    public final synchronized zzbmb zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbmb zzbmbVar) {
        this.zza = zzbmbVar;
    }
}
