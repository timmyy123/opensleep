package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdvy implements zzbyh {
    final /* synthetic */ zzdwh zza;

    public zzdvy(zzdwh zzdwhVar) {
        Objects.requireNonNull(zzdwhVar);
        this.zza = zzdwhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zza(int i, int i2, int i3, int i4) {
        this.zza.zzg().zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzb() {
        this.zza.zzg().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzc() {
        this.zza.zzh().zza();
    }
}
