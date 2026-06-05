package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcyd implements zzhbt {
    final /* synthetic */ zzhbt zza;
    final /* synthetic */ zzcyi zzb;

    public zzcyd(zzcyi zzcyiVar, zzhbt zzhbtVar) {
        this.zza = zzhbtVar;
        Objects.requireNonNull(zzcyiVar);
        this.zzb = zzcyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zzf();
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzf();
        this.zza.zzb((zzcxt) obj);
    }
}
