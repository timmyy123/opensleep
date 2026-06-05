package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzaci implements zzacj {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzdt zzb;

    public zzaci(Executor executor, zzdt zzdtVar) {
        this.zza = executor;
        this.zzb = zzdtVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zza() {
        this.zzb.zza(this.zza);
    }
}
