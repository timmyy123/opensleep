package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhmh implements zzhln {
    static final /* synthetic */ zzhmh zza = new zzhmh();

    private /* synthetic */ zzhmh() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        int i = zzhmi.$r8$clinit;
        zzhst zzhstVarZzc = ((zzhma) zzhehVar).zzb().zzc();
        zzhdr zzhdrVarZzd = zzhlo.zza().zzd(zzhstVarZzc.zza());
        if (zzhlo.zza().zze(zzhstVarZzc.zza())) {
            zzhsq zzhsqVarZzd = zzhdrVarZzd.zzd(zzhstVarZzc.zzb());
            return new zzhlz(zzhnm.zza(zzhsqVarZzd.zza(), zzhsqVarZzd.zzb(), zzhsqVarZzd.zzc(), zzhstVarZzc.zzc(), num), zzhdo.zza());
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Creating new keys is not allowed.");
        return null;
    }
}
