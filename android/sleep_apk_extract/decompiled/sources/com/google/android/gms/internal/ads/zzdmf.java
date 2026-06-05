package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmf implements zzimu {
    private final zzind zza;

    private zzdmf(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdmf zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmf(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzfpq) this.zza.zzb(), zzcfr.zzh);
    }
}
