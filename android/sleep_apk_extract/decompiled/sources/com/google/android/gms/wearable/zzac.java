package com.google.android.gms.wearable;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzac implements Runnable {
    final /* synthetic */ com.google.android.gms.wearable.internal.zzl zza;
    final /* synthetic */ zzai zzb;

    public zzac(zzai zzaiVar, com.google.android.gms.wearable.internal.zzl zzlVar) {
        this.zza = zzlVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onNotificationReceived");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onNotificationReceived(this.zza);
    }
}
