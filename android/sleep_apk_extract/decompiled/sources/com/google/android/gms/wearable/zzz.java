package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzib;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzz implements Runnable {
    final /* synthetic */ zzib zza;
    final /* synthetic */ zzai zzb;

    public zzz(zzai zzaiVar, zzib zzibVar) {
        this.zza = zzibVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onPeerDisconnected");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onPeerDisconnected(this.zza);
    }
}
