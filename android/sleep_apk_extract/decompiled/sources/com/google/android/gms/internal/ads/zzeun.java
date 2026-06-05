package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeun implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeun(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzeun zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzeun(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeul zzb() {
        return new zzeul(zzfoa.zzc(), ((zzdci) this.zza).zza(), (zzflo) this.zzb.zzb());
    }
}
