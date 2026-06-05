package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class zzyp {
    private static final zzyf zza = new zzyo();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    public /* synthetic */ zzyp(byte[] bArr) {
    }

    public static int zza(zzyq zzyqVar, zzyd zzydVar, zzzj zzzjVar) {
        zzyp zzypVar = (zzyp) zza.zzb(zzydVar, zzzjVar);
        int iIncrementAndGet = zzypVar.zzc.incrementAndGet();
        if (zzyqVar == zzyq.zzc || !zzypVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzyqVar.zzb();
            zzypVar.zzb.set(false);
            zzypVar.zzc.addAndGet(-iIncrementAndGet);
            return iIncrementAndGet - 1;
        } catch (Throwable th) {
            zzypVar.zzb.set(false);
            throw th;
        }
    }
}
