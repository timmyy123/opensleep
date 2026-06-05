package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbd implements zzimu {
    private final zzind zza;

    private zzdbd(zzdba zzdbaVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbd zza(zzdba zzdbaVar, zzind zzindVar) {
        return new zzdbd(zzdbaVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzday) this.zza.zzb(), zzcfr.zzh);
    }
}
