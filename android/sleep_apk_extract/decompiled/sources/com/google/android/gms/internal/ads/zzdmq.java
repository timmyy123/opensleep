package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmq implements zzimu {
    private final zzind zza;

    private zzdmq(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdmq zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmq(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdvj) this.zza.zzb(), zzcfr.zzh);
    }
}
