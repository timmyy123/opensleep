package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhfs implements zzhln {
    static final /* synthetic */ zzhfs zza = new zzhfs();

    private /* synthetic */ zzhfs() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfx zzhfxVar = (zzhfx) zzhehVar;
        int i = zzhfu.$r8$clinit;
        if (zzhfxVar.zzc() == 24) {
            zzbuy$$ExternalSyntheticBUOutline0.m("192 bit AES GCM Parameters are not valid");
            return null;
        }
        zzhfp zzhfpVar = new zzhfp(null);
        zzhfpVar.zza(zzhfxVar);
        zzhfpVar.zzc(num);
        zzhfpVar.zzb(zzibb.zzb(zzhfxVar.zzc()));
        return zzhfpVar.zzd();
    }
}
