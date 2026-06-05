package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhu implements zzho {
    private final Context zza;
    private final zzho zzb;

    public zzhu(Context context) {
        zzhw zzhwVar = new zzhw();
        this.zza = context.getApplicationContext();
        this.zzb = zzhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzho
    public final /* bridge */ /* synthetic */ zzhp zza() {
        return new zzhv(this.zza, this.zzb.zza());
    }
}
