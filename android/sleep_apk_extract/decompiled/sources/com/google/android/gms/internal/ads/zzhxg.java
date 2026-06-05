package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhxg {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhxd.zza, zzhxa.class, zzhej.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhxf.zza, zzhxc.class, zzhek.class);
    private static final zzhei zzd = zzhlw.zzf("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey", zzhej.class, zzhuc.zzl());
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey", zzhek.class, zzhsp.ASYMMETRIC_PUBLIC, zzhue.zzi());
    private static final zzhln zzf = zzhxe.zza;
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzhkr.zza(i)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            return;
        }
        int i2 = zzhyu.$r8$clinit;
        zzhyu.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        BigInteger bigInteger = zzhwy.zza;
        zzhwv zzhwvVar = new zzhwv(null);
        zzhww zzhwwVar = zzhww.zza;
        zzhwvVar.zzd(zzhwwVar);
        zzhwvVar.zze(zzhwwVar);
        zzhwvVar.zzf(32);
        zzhwvVar.zza(3072);
        BigInteger bigInteger2 = zzhwy.zza;
        zzhwvVar.zzb(bigInteger2);
        zzhwx zzhwxVar = zzhwx.zza;
        zzhwvVar.zzc(zzhwxVar);
        map.put("RSA_SSA_PSS_3072_SHA256_F4", zzhwvVar.zzg());
        zzhwv zzhwvVar2 = new zzhwv(null);
        zzhwvVar2.zzd(zzhwwVar);
        zzhwvVar2.zze(zzhwwVar);
        zzhwvVar2.zzf(32);
        zzhwvVar2.zza(3072);
        zzhwvVar2.zzb(bigInteger2);
        zzhwx zzhwxVar2 = zzhwx.zzd;
        zzhwvVar2.zzc(zzhwxVar2);
        map.put("RSA_SSA_PSS_3072_SHA256_F4_RAW", zzhwvVar2.zzg());
        map.put("RSA_SSA_PSS_3072_SHA256_SHA256_32_F4", zzhwe.zzk);
        zzhwv zzhwvVar3 = new zzhwv(null);
        zzhww zzhwwVar2 = zzhww.zzc;
        zzhwvVar3.zzd(zzhwwVar2);
        zzhwvVar3.zze(zzhwwVar2);
        zzhwvVar3.zzf(64);
        zzhwvVar3.zza(4096);
        zzhwvVar3.zzb(bigInteger2);
        zzhwvVar3.zzc(zzhwxVar);
        map.put("RSA_SSA_PSS_4096_SHA512_F4", zzhwvVar3.zzg());
        zzhwv zzhwvVar4 = new zzhwv(null);
        zzhwvVar4.zzd(zzhwwVar2);
        zzhwvVar4.zze(zzhwwVar2);
        zzhwvVar4.zzf(64);
        zzhwvVar4.zza(4096);
        zzhwvVar4.zzb(bigInteger2);
        zzhwvVar4.zzc(zzhwxVar2);
        map.put("RSA_SSA_PSS_4096_SHA512_F4_RAW", zzhwvVar4.zzg());
        map.put("RSA_SSA_PSS_4096_SHA512_SHA512_64_F4", zzhwe.zzl);
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmi.zza().zzb(zzf, zzhwy.class);
        zzhlo.zza().zzf(zzd, i, true);
        zzhlo.zza().zzf(zze, i, false);
    }
}
