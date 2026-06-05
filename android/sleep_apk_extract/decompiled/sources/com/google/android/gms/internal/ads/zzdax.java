package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdax implements zzimu {
    private final zzind zza;

    private zzdax(zzdag zzdagVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdax zza(zzdag zzdagVar, zzind zzindVar) {
        return new zzdax(zzdagVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdbp) this.zza.zzb(), zzcfr.zzh);
    }
}
