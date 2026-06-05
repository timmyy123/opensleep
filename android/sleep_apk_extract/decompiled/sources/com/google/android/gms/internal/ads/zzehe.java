package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzehe implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzehe(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzehe zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzehe(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzehd zzb() {
        return new zzehd(zzfoa.zzc(), ((zzegj) this.zza).zzb(), zzimt.zzc(this.zzb));
    }
}
