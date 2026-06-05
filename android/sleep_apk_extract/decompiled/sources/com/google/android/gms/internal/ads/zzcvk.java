package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvk implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzcvk(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzcvk zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcvk(zzindVar, zzindVar2, zzindVar3);
    }

    public static zzdfs zzd(ScheduledExecutorService scheduledExecutorService, Clock clock, zzdzl zzdzlVar) {
        return new zzdfs(scheduledExecutorService, clock, zzdzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdfs zzb() {
        return zzd((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb(), (zzdzl) this.zzc.zzb());
    }
}
