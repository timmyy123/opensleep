package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdao implements zzimu {
    private final zzind zza;

    private zzdao(zzdag zzdagVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdao zza(zzdag zzdagVar, zzind zzindVar) {
        return new zzdao(zzdagVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzcyo) this.zza.zzb(), zzcfr.zzh);
    }
}
