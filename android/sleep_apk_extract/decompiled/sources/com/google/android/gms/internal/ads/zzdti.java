package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdti implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdti(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzdti zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzdti(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdth zzb() {
        return new zzdth(zzfoa.zzc(), ((zzdtd) this.zza).zzb(), (zzdzg) this.zzb.zzb());
    }
}
