package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class zzfvd implements Runnable {
    final /* synthetic */ zzfve zza;

    public zzfvd(zzfve zzfveVar) {
        Objects.requireNonNull(zzfveVar);
        this.zza = zzfveVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfve zzfveVar = this.zza;
        AtomicBoolean atomicBooleanZzf = zzfveVar.zzf();
        float fZzc = zzfveVar.zzc();
        atomicBooleanZzf.set(false);
        if (((Float) zzfveVar.zze().getAndSet(Float.valueOf(fZzc))).floatValue() != fZzc) {
            zzfveVar.zzd().post(new zzfvc(this, fZzc));
        }
    }
}
