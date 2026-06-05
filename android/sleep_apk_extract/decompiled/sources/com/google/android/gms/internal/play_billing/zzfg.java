package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzfg extends zzes {
    final /* synthetic */ zzfh zza;
    private final Callable zzb;

    public zzfg(zzfh zzfhVar, Callable callable) {
        this.zza = zzfhVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    public final Object zza() {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    public final void zzc(Throwable th) {
        this.zza.zzo(th);
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    public final void zzd(Object obj) {
        this.zza.zzn(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    public final boolean zzf() {
        return this.zza.isDone();
    }
}
