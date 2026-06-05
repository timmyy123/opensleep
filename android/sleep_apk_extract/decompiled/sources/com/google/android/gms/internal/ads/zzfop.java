package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfop implements zzimu {
    private final zzind zza;

    private zzfop(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzfop zza(zzind zzindVar, zzind zzindVar2) {
        return new zzfop(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfoo((ScheduledExecutorService) this.zza.zzb(), zzfoa.zzc());
    }
}
