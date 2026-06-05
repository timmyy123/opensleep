package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeyt implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeyt(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeyt zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyt(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfaw(((zzfau) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznH)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
