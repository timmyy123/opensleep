package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcev {
    public final ListenableFuture zza(Context context, int i) {
        zzcfw zzcfwVar = new zzcfw();
        com.google.android.gms.ads.internal.client.zzay.zza();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzA(context)) {
            zzcfr.zza.execute(new zzceu(this, context, zzcfwVar));
        }
        return zzcfwVar;
    }
}
