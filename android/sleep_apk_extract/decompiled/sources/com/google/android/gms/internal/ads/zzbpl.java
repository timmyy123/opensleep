package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbpl implements zzbpq {
    static final /* synthetic */ zzbpl zza = new zzbpl();

    private /* synthetic */ zzbpl() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcmg zzcmgVar = (zzcmg) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        String str = (String) map.get("u");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("URL missing from httpTrack GMSG.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzg)).booleanValue() && str.isEmpty()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("URL is empty from httpTrack GMSG.");
        } else {
            zzckl zzcklVar = (zzckl) zzcmgVar;
            new com.google.android.gms.ads.internal.util.zzbt(zzcmgVar.getContext(), ((zzcmo) zzcmgVar).zzs().afmaVersion, str, null, zzcklVar.zzC() != null ? zzcklVar.zzC().zzax : null).zzb();
        }
    }
}
