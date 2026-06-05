package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmo implements zzimu {
    private final zzind zza;

    private zzdmo(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdmo zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmo(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdnp) this.zza.zzb(), zzcfr.zzf);
    }
}
