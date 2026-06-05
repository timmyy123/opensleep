package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzetm implements zzetr {
    final /* synthetic */ zzetn zza;

    public zzetm(zzetn zzetnVar) {
        Objects.requireNonNull(zzetnVar);
        this.zza = zzetnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxt zzcxtVar = (zzcxt) obj;
        zzetn zzetnVar = this.zza;
        synchronized (zzetnVar) {
            zzetnVar.zze(zzcxtVar.zzn());
            zzcxtVar.zzj();
        }
    }
}
