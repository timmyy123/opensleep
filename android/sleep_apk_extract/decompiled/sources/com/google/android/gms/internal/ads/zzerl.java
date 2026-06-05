package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class zzerl implements com.google.android.gms.ads.internal.zzg {
    private com.google.android.gms.ads.internal.zzg zza;

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zza(View view) {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zza;
        if (zzgVar != null) {
            zzgVar.zza(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzb() {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zza;
        if (zzgVar != null) {
            zzgVar.zzb();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzc() {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zza;
        if (zzgVar != null) {
            zzgVar.zzc();
        }
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.zzg zzgVar) {
        this.zza = zzgVar;
    }
}
