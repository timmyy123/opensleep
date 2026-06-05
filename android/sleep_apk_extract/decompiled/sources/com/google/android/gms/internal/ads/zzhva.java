package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhva implements zzhln {
    static final /* synthetic */ zzhva zza = new zzhva();

    private /* synthetic */ zzhva() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhuu zzhuuVar = (zzhuu) zzhehVar;
        int i = zzhvc.$r8$clinit;
        ECParameterSpec eCParameterSpecZza = zzhuuVar.zzd().zza();
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhzz.zze.zzb("EC");
        keyPairGenerator.initialize(eCParameterSpecZza);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        zzhux zzhuxVar = new zzhux(null);
        zzhuxVar.zza(zzhuuVar);
        zzhuxVar.zzc(num);
        zzhuxVar.zzb(eCPublicKey.getW());
        zzhuy zzhuyVarZzd = zzhuxVar.zzd();
        zzhuv zzhuvVar = new zzhuv(null);
        zzhuvVar.zza(zzhuyVarZzd);
        zzhuvVar.zzb(zziba.zza(eCPrivateKey.getS(), zzhdo.zza()));
        return zzhuvVar.zzc();
    }
}
