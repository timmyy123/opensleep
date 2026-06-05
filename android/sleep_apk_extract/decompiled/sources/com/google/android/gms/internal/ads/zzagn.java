package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzagn implements zzahb {
    private final zzahb zza;

    public zzagn(zzahb zzahbVar) {
        this.zza = zzahbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public zzagz zzc(long j) {
        return this.zza.zzc(j);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzj() {
        return this.zza.zzj();
    }
}
