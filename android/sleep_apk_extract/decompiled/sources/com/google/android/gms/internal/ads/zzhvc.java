package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhvc {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhuz.zza, zzhuw.class, zzhej.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhvb.zza, zzhuy.class, zzhek.class);
    private static final zzhei zzd = zzhlw.zzf("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey", zzhej.class, zzhrw.zzg());
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.EcdsaPublicKey", zzhek.class, zzhsp.ASYMMETRIC_PUBLIC, zzhry.zzi());
    private static final zzhln zzf = zzhva.zza;
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzhkr.zza(i)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
            return;
        }
        int i2 = zzhxr.$r8$clinit;
        zzhxr.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("ECDSA_P256", zzhwe.zza);
        map.put("ECDSA_P256_IEEE_P1363", zzhwe.zzd);
        zzhup zzhupVar = new zzhup(null);
        zzhupVar.zzc(zzhur.zza);
        zzhupVar.zzb(zzhuq.zza);
        zzhupVar.zza(zzhus.zza);
        zzhupVar.zzd(zzhut.zzd);
        map.put("ECDSA_P256_RAW", zzhupVar.zze());
        map.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", zzhwe.zzf);
        map.put("ECDSA_P384", zzhwe.zzb);
        map.put("ECDSA_P384_IEEE_P1363", zzhwe.zze);
        zzhup zzhupVar2 = new zzhup(null);
        zzhupVar2.zzc(zzhur.zzc);
        zzhuq zzhuqVar = zzhuq.zzb;
        zzhupVar2.zzb(zzhuqVar);
        zzhus zzhusVar = zzhus.zzb;
        zzhupVar2.zza(zzhusVar);
        zzhut zzhutVar = zzhut.zza;
        zzhupVar2.zzd(zzhutVar);
        map.put("ECDSA_P384_SHA512", zzhupVar2.zze());
        zzhup zzhupVar3 = new zzhup(null);
        zzhupVar3.zzc(zzhur.zzb);
        zzhupVar3.zzb(zzhuqVar);
        zzhupVar3.zza(zzhusVar);
        zzhupVar3.zzd(zzhutVar);
        map.put("ECDSA_P384_SHA384", zzhupVar3.zze());
        map.put("ECDSA_P521", zzhwe.zzc);
        map.put("ECDSA_P521_IEEE_P1363", zzhwe.zzg);
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmi.zza().zzb(zzf, zzhuu.class);
        zzhlo.zza().zzf(zzd, i, true);
        zzhlo.zza().zzf(zze, i, false);
    }
}
