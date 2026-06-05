package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class zzqf implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ ListeningScheduledExecutorService zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ TimeUnit zzd;

    public zzqf(zzqi zzqiVar, Runnable runnable, ListeningScheduledExecutorService listeningScheduledExecutorService, long j, TimeUnit timeUnit) {
        this.zza = runnable;
        this.zzb = listeningScheduledExecutorService;
        this.zzc = j;
        this.zzd = timeUnit;
        Objects.requireNonNull(zzqiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzpx.zza(this.zzb.schedule((Runnable) this, this.zzc, this.zzd));
    }
}
