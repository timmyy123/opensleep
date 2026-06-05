package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdoq implements zzimu {
    private final zzind zza;

    private zzdoq(zzdop zzdopVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdoq zza(zzdop zzdopVar, zzind zzindVar) {
        return new zzdoq(zzdopVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzdos) this.zza).zzb().zza();
    }
}
