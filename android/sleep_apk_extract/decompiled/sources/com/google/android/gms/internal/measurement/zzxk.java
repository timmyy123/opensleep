package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class zzxk extends zzyq {
    private static final zzyf zza = new zzxj();
    private final AtomicLong zzb = new AtomicLong(2147483647L);

    public static zzyq zza(zzzj zzzjVar, zzyd zzydVar) {
        Integer num = (Integer) zzzjVar.zzd(zzxx.zzb);
        if (num == null) {
            return null;
        }
        zzxk zzxkVar = (zzxk) zza.zzb(zzydVar, zzzjVar);
        return zzxkVar.zzb.incrementAndGet() >= ((long) num.intValue()) ? zzxkVar : zzyq.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        this.zzb.set(0L);
    }
}
