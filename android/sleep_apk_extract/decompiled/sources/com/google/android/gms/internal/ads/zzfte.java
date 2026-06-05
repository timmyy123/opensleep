package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfte implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfte(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzfte zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfte(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzftd zzb() {
        return new zzftd((zzdzl) this.zza.zzb(), ((zzcns) this.zzb).zza());
    }
}
