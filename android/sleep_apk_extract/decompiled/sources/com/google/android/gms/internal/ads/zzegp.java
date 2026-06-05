package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzegp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzegp(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
    }

    public static zzegp zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzegp(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzego zzb() {
        return new zzego(((zzinb) this.zza).zzd(), zzfoa.zzc(), ((zzdfw) this.zzb).zzb());
    }
}
