package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeiq {
    private final zzcaw zza;

    public zzeiq(zzcaw zzcawVar) {
        this.zza = zzcawVar;
    }

    public final void zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziG)).booleanValue()) {
            zzcfu.zzb(listenableFutureZza, "persistFlags");
        } else {
            zzcfu.zza(listenableFutureZza, "persistFlags", zzcfr.zzh);
        }
    }
}
