package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeyd implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;

    private zzeyd(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
    }

    public static zzeyd zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzeyd(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzevr zzevrVarZzb = ((zzevt) this.zza).zzb();
        zzewy zzewyVar = (zzewy) this.zzb.zzb();
        List list = (List) this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        if (list.contains("10")) {
            return new zzfaw(zzewyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznE)).intValue(), scheduledExecutorService);
        }
        return new zzfaw(zzevrVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznE)).intValue(), scheduledExecutorService);
    }
}
