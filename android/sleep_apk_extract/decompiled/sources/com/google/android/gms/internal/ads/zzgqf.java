package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgqf {
    private final zzgfh zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private long zzc = -1;
    private long zzd = -1;
    private Throwable zze = null;
    private final int zzf;

    public zzgqf(int i, zzgcn zzgcnVar, zzgfh zzgfhVar) {
        this.zzf = i;
        this.zza = zzgfhVar;
    }

    public final void zza() {
        if (this.zzb.get()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Finished trace.");
        } else {
            this.zzc = SystemClock.uptimeMillis();
        }
    }

    public final void zzb(Throwable th) {
        if (this.zzb.get()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Finished trace.");
        } else {
            this.zze = th;
        }
    }

    public final void zzc() {
        AtomicBoolean atomicBoolean = this.zzb;
        if (atomicBoolean.getAndSet(true)) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Finished trace.");
            return;
        }
        this.zzd = SystemClock.uptimeMillis();
        this.zza.zzb(this.zzf - 1, atomicBoolean.get() ? this.zzd - this.zzc : -1L, this.zze, null);
    }
}
