package com.google.android.gms.wearable;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzaa implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzai zzb;

    public zzaa(zzai zzaiVar, List list) {
        this.zza = list;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onConnectedNodes");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onConnectedNodes(this.zza);
    }
}
