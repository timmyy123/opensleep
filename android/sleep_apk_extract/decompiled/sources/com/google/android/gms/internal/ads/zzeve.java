package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeve {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzevd zzb;

    public final void zza(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }

    public final void zzc(zzevd zzevdVar) {
        this.zzb = zzevdVar;
    }

    public final zzevd zzd() {
        return this.zzb;
    }
}
