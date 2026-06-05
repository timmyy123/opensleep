package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhxs implements zzhej {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};

    private zzhxs(ECPrivateKey eCPrivateKey, zziai zziaiVar, zzhzs zzhzsVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (zzhkr.zza(2)) {
            zziaw.zza(zziaiVar);
        } else {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
            throw null;
        }
    }

    public static zzhej zzb(zzhuw zzhuwVar) {
        Provider providerZza = zzhkv.zza();
        return new zzhxs((ECPrivateKey) (providerZza != null ? KeyFactory.getInstance("EC", providerZza) : (KeyFactory) zzhzz.zzf.zzb("EC")).generatePrivate(new ECPrivateKeySpec(zzhuwVar.zzf().zzb(zzhdo.zza()), zzhzt.zzb((zzhzr) zzhxt.zzc.zzb(zzhuwVar.zzd().zzd())))), (zziai) zzhxt.zza.zzb(zzhuwVar.zzd().zze()), (zzhzs) zzhxt.zzb.zzb(zzhuwVar.zzd().zzc()), zzhuwVar.zze().zze().zzc(), zzhuwVar.zzd().zzf().equals(zzhut.zzc) ? zzb : zza, providerZza);
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) {
        throw null;
    }
}
