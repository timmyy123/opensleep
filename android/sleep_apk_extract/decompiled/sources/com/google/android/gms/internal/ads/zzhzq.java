package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhzq implements zzhek {
    public static zzhek zzb(zzhvl zzhvlVar) throws GeneralSecurityException {
        byte[] bArr = null;
        if (zzhkr.zza(1)) {
            try {
                return zzhyc.zzb(zzhvlVar);
            } catch (GeneralSecurityException unused) {
                return new zzhzp(zzhvlVar.zzd().zzc(), zzhvlVar.zze().zzc(), zzhvlVar.zzf().zzc().equals(zzhvd.zzc) ? new byte[]{0} : new byte[0], bArr);
            }
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Can not use Ed25519 in FIPS-mode.");
        return null;
    }
}
