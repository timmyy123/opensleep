package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevl implements zzimu {
    private final zzind zza;

    private zzevl(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzevl zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzevl(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevj zzb() {
        return new zzevj(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
