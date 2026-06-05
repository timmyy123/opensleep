package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzfon {
    final Runnable zza;
    final long zzb;
    ScheduledFuture zzc;
    final /* synthetic */ zzfoo zzd;

    public zzfon(zzfoo zzfooVar, Runnable runnable, long j) {
        Objects.requireNonNull(zzfooVar);
        this.zzd = zzfooVar;
        this.zza = runnable;
        this.zzb = j;
    }
}
