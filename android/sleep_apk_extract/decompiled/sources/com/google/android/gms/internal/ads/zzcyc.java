package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcyc implements zzhbt {
    final /* synthetic */ zzhbt zza;
    final /* synthetic */ zzcyi zzb;

    public zzcyc(zzcyi zzcyiVar, zzhbt zzhbtVar) {
        this.zza = zzhbtVar;
        Objects.requireNonNull(zzcyiVar);
        this.zzb = zzcyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zza.zza(th);
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze(((zzcyb) obj).zza, this.zza);
    }
}
