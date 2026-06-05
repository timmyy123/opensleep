package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzduk implements zzbpq {
    private final zzbnf zza;
    private final zzdux zzb;
    private final zzimo zzc;

    public zzduk(zzdqd zzdqdVar, zzdpt zzdptVar, zzdux zzduxVar, zzimo zzimoVar) {
        this.zza = zzdqdVar.zzg(zzdptVar.zzS());
        this.zzb = zzduxVar;
        this.zzc = zzimoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbmv) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 40), "Failed to call onCustomClick for asset ", str, ".");
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strM, e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzd("/nativeAdCustomClick", this);
    }
}
