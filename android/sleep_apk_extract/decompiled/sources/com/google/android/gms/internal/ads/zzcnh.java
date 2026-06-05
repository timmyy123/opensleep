package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnh implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcnh(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcnh zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcnh(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcng((zzcmt) this.zza.zzb(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
