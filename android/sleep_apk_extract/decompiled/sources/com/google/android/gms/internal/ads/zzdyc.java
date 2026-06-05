package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdyc implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdyc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdyc zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdyc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdyb((zzbhp) this.zza.zzb(), (zzfia) this.zzb.zzb());
    }
}
