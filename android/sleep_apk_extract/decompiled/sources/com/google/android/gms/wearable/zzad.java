package com.google.android.gms.wearable;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzad implements Runnable {
    final /* synthetic */ com.google.android.gms.wearable.internal.zzj zza;
    final /* synthetic */ zzai zzb;

    public zzad(zzai zzaiVar, com.google.android.gms.wearable.internal.zzj zzjVar) {
        this.zza = zzjVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onEntityUpdate");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onEntityUpdate(this.zza);
    }
}
