package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfah implements zzfci {
    public final zzfke zza;

    public zzfah(zzfke zzfkeVar) {
        this.zza = zzfkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfke zzfkeVar = this.zza;
        if (zzfkeVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznt)).booleanValue()) {
                return;
            }
            bundle.putBoolean("render_in_browser", zzfkeVar.zzb());
            bundle.putBoolean("disable_ml", zzfkeVar.zzc());
        }
    }
}
