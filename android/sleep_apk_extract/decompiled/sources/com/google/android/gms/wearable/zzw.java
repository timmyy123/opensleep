package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzw implements Runnable {
    final /* synthetic */ DataHolder zza;
    final /* synthetic */ zzai zzb;

    public zzw(zzai zzaiVar, DataHolder dataHolder) {
        this.zza = dataHolder;
        Objects.requireNonNull(zzaiVar);
        this.zzb = zzaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zza);
        try {
            WearableListenerService wearableListenerServiceZzm = this.zzb.zzm("onDataChanged");
            if (wearableListenerServiceZzm != null) {
                wearableListenerServiceZzm.onDataChanged(dataEventBuffer);
            }
        } finally {
            dataEventBuffer.release();
        }
    }
}
