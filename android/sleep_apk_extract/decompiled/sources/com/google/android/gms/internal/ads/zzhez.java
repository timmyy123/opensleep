package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhez implements zzhln {
    static final /* synthetic */ zzhez zza = new zzhez();

    private /* synthetic */ zzhez() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfg zzhfgVar = (zzhfg) zzhehVar;
        int i = zzhfc.$r8$clinit;
        if (zzhfgVar.zzc() != 16 && zzhfgVar.zzc() != 32) {
            zzbuy$$ExternalSyntheticBUOutline0.m("AES key size must be 16 or 32 bytes");
            return null;
        }
        zzhex zzhexVar = new zzhex(null);
        zzhexVar.zza(zzhfgVar);
        zzhexVar.zzd(num);
        zzhexVar.zzb(zzibb.zzb(zzhfgVar.zzc()));
        zzhexVar.zzc(zzibb.zzb(zzhfgVar.zzd()));
        return zzhexVar.zze();
    }
}
