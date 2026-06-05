package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbe implements zzimu {
    private final zzind zza;

    private zzdbe(zzdba zzdbaVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbe zza(zzdba zzdbaVar, zzind zzindVar) {
        return new zzdbe(zzdbaVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzday) this.zza.zzb(), zzcfr.zzh);
    }
}
