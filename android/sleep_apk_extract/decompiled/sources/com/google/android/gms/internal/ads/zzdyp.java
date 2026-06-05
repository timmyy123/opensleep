package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdyp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdyp(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdyp zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzdyp(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyo zzb() {
        return new zzdyo((zzbhp) this.zza.zzb(), ((zzimy) this.zzb).zzb());
    }
}
