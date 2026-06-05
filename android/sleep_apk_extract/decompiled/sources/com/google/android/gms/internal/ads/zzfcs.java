package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfcs implements zzimu {
    private final zzind zza;

    private zzfcs(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzfcs zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfcs(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfcq zzb() {
        return new zzfcq(((zzcns) this.zza).zza(), zzfoa.zzc());
    }
}
