package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzduo implements zzhbt {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbpq zzb;

    public zzduo(zzdux zzduxVar, String str, zzbpq zzbpqVar) {
        this.zza = str;
        this.zzb = zzbpqVar;
        Objects.requireNonNull(zzduxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcku) obj).zzac(this.zza, this.zzb);
    }
}
