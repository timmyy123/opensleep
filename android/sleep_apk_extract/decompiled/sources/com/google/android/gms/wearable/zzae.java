package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzbq;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzae implements Runnable {
    final /* synthetic */ zzbq zza;
    final /* synthetic */ zzai zzb;

    public zzae(zzai zzaiVar, zzbq zzbqVar) {
        this.zza = zzbqVar;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onChannelEvent");
        if (wearableListenerServiceZzm == null) {
            return;
        }
        zzbq zzbqVar = this.zza;
        zzbqVar.zza(wearableListenerServiceZzm);
        zzbqVar.zza(wearableListenerServiceZzm.zzi());
    }
}
