package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewk implements zzimu {
    private final zzind zza;

    private zzewk(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzewk zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzewk(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewi zzb() {
        return new zzewi(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
