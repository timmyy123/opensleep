package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzib;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzy implements Runnable {
    final /* synthetic */ zzib zza;
    final /* synthetic */ zzai zzb;

    public zzy(zzai zzaiVar, zzib zzibVar) {
        this.zza = zzibVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onPeerConnected");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onPeerConnected(this.zza);
    }
}
