package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
final class zzfut extends TimerTask {
    final /* synthetic */ zzfuv zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzfuw zzc;

    public zzfut(zzfuw zzfuwVar, zzfuv zzfuvVar, Timer timer) {
        this.zza = zzfuvVar;
        this.zzb = timer;
        Objects.requireNonNull(zzfuwVar);
        this.zzc = zzfuwVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzc.zze();
        this.zza.zza(true);
        this.zzb.cancel();
    }
}
