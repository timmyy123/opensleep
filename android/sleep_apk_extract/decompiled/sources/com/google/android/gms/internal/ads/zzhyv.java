package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhyv implements zzhej {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};

    private zzhyv(RSAPrivateCrtKey rSAPrivateCrtKey, zzhww zzhwwVar, zzhww zzhwwVar2, int i, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        zziax.zzc(rSAPrivateCrtKey.getModulus().bitLength());
        zziax.zzd(rSAPrivateCrtKey.getPublicExponent());
        zzhyw.zzc(zzhwwVar);
        zzhyw.zzd(zzhwwVar, zzhwwVar2, i);
    }

    public static zzhej zzb(zzhxa zzhxaVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        Provider providerZzb = zzhyw.zzb();
        if (providerZzb == null) {
            throw new NoSuchProviderException("RSA SSA PSS using Conscrypt is not supported.");
        }
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", providerZzb);
        zzhwy zzhwyVarZzd = zzhxaVar.zzd();
        return new zzhyv((RSAPrivateCrtKey) keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(zzhxaVar.zze().zzd(), zzhwyVarZzd.zzd(), zzhxaVar.zzi().zzb(zzhdo.zza()), zzhxaVar.zzf().zzb(zzhdo.zza()), zzhxaVar.zzh().zzb(zzhdo.zza()), zzhxaVar.zzj().zzb(zzhdo.zza()), zzhxaVar.zzk().zzb(zzhdo.zza()), zzhxaVar.zzl().zzb(zzhdo.zza()))), zzhwyVarZzd.zzf(), zzhwyVarZzd.zzg(), zzhwyVarZzd.zzh(), zzhxaVar.zze().zze().zzc(), zzhwyVarZzd.zze().equals(zzhwx.zzc) ? zzb : zza, providerZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) {
        throw null;
    }
}
