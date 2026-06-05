package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfeo implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfeo(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzfeo zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfeo(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfem zzb() {
        return new zzfem(zzcrk.zza(), (ScheduledExecutorService) this.zza.zzb(), ((zzcns) this.zzb).zza());
    }
}
