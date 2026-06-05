package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzhcu extends zzhcd {
    final /* synthetic */ zzhcv zza;
    private final Callable zzb;

    public zzhcu(zzhcv zzhcvVar, Callable callable) {
        Objects.requireNonNull(zzhcvVar);
        this.zza = zzhcvVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final Object zza() {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final String zzc() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final void zzf(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
