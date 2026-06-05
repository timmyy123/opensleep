package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfpm implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfpm(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzfpm zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfpm(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfpk(zzfoa.zzc(), (ScheduledExecutorService) this.zza.zzb(), ((zzfpn) this.zzb).zzb());
    }
}
