package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdoy implements zzimu {
    private final zzind zza;

    private zzdoy(zzdop zzdopVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdoy zza(zzdop zzdopVar, zzind zzindVar) {
        return new zzdoy(zzdopVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdrt) this.zza.zzb(), zzcfr.zza);
    }
}
