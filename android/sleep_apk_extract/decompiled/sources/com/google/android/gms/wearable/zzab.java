package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzao;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzab implements Runnable {
    final /* synthetic */ zzao zza;
    final /* synthetic */ zzai zzb;

    public zzab(zzai zzaiVar, zzao zzaoVar) {
        this.zza = zzaoVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onConnectedCapabilityChanged");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        wearableListenerServiceZzm.onCapabilityChanged(this.zza);
    }
}
