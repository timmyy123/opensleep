package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwq implements zzddm {
    private final zzcku zza;

    public zzdwq(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zza(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzb(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzc(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.destroy();
        }
    }
}
