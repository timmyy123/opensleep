package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeyj implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeyj(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeyj zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyj(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfaw(((zzexg) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznT)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
