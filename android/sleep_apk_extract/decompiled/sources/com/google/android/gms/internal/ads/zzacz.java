package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzacz implements zzaer {
    final /* synthetic */ zzade zza;

    public zzacz(zzade zzadeVar) {
        Objects.requireNonNull(zzadeVar);
        this.zza = zzadeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zza() {
        zzmz zzmzVarZzbc = this.zza.zzbc();
        if (zzmzVarZzbc != null) {
            zzmzVarZzbc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzb() {
        zzade zzadeVar = this.zza;
        if (zzadeVar.zzbp() != null) {
            zzadeVar.zzbo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzc() {
        zzade zzadeVar = this.zza;
        if (zzadeVar.zzbp() != null) {
            zzadeVar.zzaz(0, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzd(zzbv zzbvVar) {
    }
}
