package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeem implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeem(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar3;
        this.zzb = zzindVar4;
    }

    public static zzeem zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzeem(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeel zzb() {
        return new zzeel(zzfog.zzc(), zzfoa.zzc(), ((zzeez) this.zza).zzb(), zzimt.zzc(this.zzb));
    }
}
