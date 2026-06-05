package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeyl implements zzimu {
    private final zzind zza;

    private zzeyl(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzeyl zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyl(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfaw(zzezi.zzc(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznJ)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
