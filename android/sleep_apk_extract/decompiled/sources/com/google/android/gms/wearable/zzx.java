package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzhk;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzx implements Runnable {
    final /* synthetic */ zzhk zza;
    final /* synthetic */ zzai zzb;

    public zzx(zzai zzaiVar, zzhk zzhkVar) {
        this.zza = zzhkVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onMessageReceived");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onMessageReceived(this.zza);
    }
}
