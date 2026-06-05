package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzero implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdma zza;

    public zzero(zzerp zzerpVar, zzdma zzdmaVar) {
        this.zza = zzdmaVar;
        Objects.requireNonNull(zzerpVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzc().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdma zzdmaVar = this.zza;
        zzdmaVar.zzd().zza();
        zzdmaVar.zze().zza();
    }
}
