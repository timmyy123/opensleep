package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwt implements zzimu {
    private final zzind zza;

    private zzdwt(zzdws zzdwsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdwt zza(zzdws zzdwsVar, zzind zzindVar) {
        return new zzdwt(zzdwsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq(((zzdwr) this.zza).zzb(), zzcfr.zzf);
    }
}
