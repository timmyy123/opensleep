package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmm implements zzimu {
    private final zzind zza;

    private zzdmm(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdmm zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmm(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdlw) this.zza.zzb(), zzcfr.zzf);
    }
}
