package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdvx implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdwi zza;

    public zzdvx(zzdwi zzdwiVar) {
        Objects.requireNonNull(zzdwiVar);
        this.zza = zzdwiVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdk() {
        this.zza.zzb().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdl() {
        this.zza.zzb().zzb();
    }
}
