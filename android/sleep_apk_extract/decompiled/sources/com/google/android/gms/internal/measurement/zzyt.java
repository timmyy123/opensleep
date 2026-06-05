package com.google.android.gms.internal.measurement;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class zzyt extends zzyq {
    private static final zzyf zzb = new zzyr();
    private static final ThreadLocal zze = new zzys();
    final AtomicInteger zza = new AtomicInteger();

    public static zzyq zza(zzzj zzzjVar, zzyd zzydVar) {
        Integer num = (Integer) zzzjVar.zzd(zzxx.zzc);
        if (num == null || num.intValue() <= 0) {
            return null;
        }
        zzyt zzytVar = (zzyt) zzb.zzb(zzydVar, zzzjVar);
        return (((Random) zze.get()).nextInt(num.intValue()) == 0 ? zzytVar.zza.incrementAndGet() : zzytVar.zza.get()) > 0 ? zzytVar : zzyq.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        this.zza.decrementAndGet();
    }
}
