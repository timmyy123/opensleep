package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeyq implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzeyq(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
        this.zzc = zzindVar4;
    }

    public static zzeyq zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzeyq(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfad zzfadVarZzc = zzfaf.zzc();
        zzewy zzewyVar = (zzewy) this.zza.zzb();
        List list = (List) this.zzb.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (list.contains("24")) {
            return new zzfaw(zzewyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznG)).intValue(), scheduledExecutorService);
        }
        return new zzfaw(zzfadVarZzc, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznG)).intValue(), scheduledExecutorService);
    }
}
