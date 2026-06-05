package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfbw implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfbw(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
    }

    public static zzfbw zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfbw(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfbu zzb() {
        return new zzfbu((zzcdz) this.zza.zzb(), zzfoa.zzc(), ((zzcns) this.zzb).zza());
    }
}
