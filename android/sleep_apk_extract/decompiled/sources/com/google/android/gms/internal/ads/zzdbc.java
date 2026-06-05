package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbc implements zzimu {
    private final zzind zza;

    private zzdbc(zzdba zzdbaVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbc zza(zzdba zzdbaVar, zzind zzindVar) {
        return new zzdbc(zzdbaVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdae) this.zza.zzb(), zzcfr.zzh);
    }
}
