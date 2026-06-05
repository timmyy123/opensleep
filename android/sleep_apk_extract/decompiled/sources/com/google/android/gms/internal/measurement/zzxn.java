package com.google.android.gms.internal.measurement;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class zzxn extends zzyq {
    private static final zzyf zza = new zzxl();
    private final AtomicLong zzb = new AtomicLong(-1);

    public static zzyq zza(zzzj zzzjVar, zzyd zzydVar, long j) {
        if (zzzjVar.zzd(zzxx.zzd) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        AtomicLong atomicLong = this.zzb;
        atomicLong.set(Math.max(-atomicLong.get(), 0L));
    }
}
