package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhxe implements zzhln {
    static final /* synthetic */ zzhxe zza = new zzhxe();

    private /* synthetic */ zzhxe() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhwy zzhwyVar = (zzhwy) zzhehVar;
        int i = zzhxg.$r8$clinit;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhzz.zze.zzb("RSA");
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(zzhwyVar.zzc(), new BigInteger(1, zzhwyVar.zzd().toByteArray())));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        zzhxb zzhxbVar = new zzhxb(null);
        zzhxbVar.zza(zzhwyVar);
        zzhxbVar.zzb(rSAPublicKey.getModulus());
        zzhxbVar.zzc(num);
        zzhxc zzhxcVarZzd = zzhxbVar.zzd();
        zzhwz zzhwzVar = new zzhwz(null);
        zzhwzVar.zza(zzhxcVarZzd);
        zzhwzVar.zzb(zziba.zza(rSAPrivateCrtKey.getPrimeP(), zzhdo.zza()), zziba.zza(rSAPrivateCrtKey.getPrimeQ(), zzhdo.zza()));
        zzhwzVar.zzc(zziba.zza(rSAPrivateCrtKey.getPrivateExponent(), zzhdo.zza()));
        zzhwzVar.zzd(zziba.zza(rSAPrivateCrtKey.getPrimeExponentP(), zzhdo.zza()), zziba.zza(rSAPrivateCrtKey.getPrimeExponentQ(), zzhdo.zza()));
        zzhwzVar.zze(zziba.zza(rSAPrivateCrtKey.getCrtCoefficient(), zzhdo.zza()));
        return zzhwzVar.zzf();
    }
}
