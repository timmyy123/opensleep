package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhof {
    private static final zzhln zza = zzhoe.zza;
    private static final zzhnf zzb = zzhnf.zzd(zzhoc.zza, zzhob.class, zzhoj.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhod.zza, zzhob.class, zzheg.class);
    private static final zzhdr zzd = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesCmacKey", zzheg.class, zzhsp.SYMMETRIC, zzhqk.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering AES CMAC is not supported in FIPS mode");
            return;
        }
        int i = zzhpl.$r8$clinit;
        zzhpl.zza(zzhmr.zza());
        zzhmi.zza().zzb(zza, zzhoi.class);
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        zzhoi zzhoiVar = zzhpg.zzc;
        map.put("AES_CMAC", zzhoiVar);
        map.put("AES256_CMAC", zzhoiVar);
        zzhog zzhogVar = new zzhog(null);
        zzhogVar.zza(32);
        zzhogVar.zzb(16);
        zzhogVar.zzc(zzhoh.zzd);
        map.put("AES256_CMAC_RAW", zzhogVar.zzd());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhlo.zza().zzb(zzd, true);
    }

    public static /* synthetic */ zzhob zzb(zzhoi zzhoiVar, Integer num) throws GeneralSecurityException {
        zze(zzhoiVar);
        zzhoa zzhoaVar = new zzhoa(null);
        zzhoaVar.zza(zzhoiVar);
        zzhoaVar.zzb(zzibb.zzb(zzhoiVar.zzc()));
        zzhoaVar.zzc(num);
        return zzhoaVar.zzd();
    }

    public static /* synthetic */ zzhoj zzc(zzhob zzhobVar) throws GeneralSecurityException {
        zze(zzhobVar.zzf());
        return zzhpo.zza(zzhobVar);
    }

    public static /* synthetic */ zzheg zzd(zzhob zzhobVar) throws GeneralSecurityException {
        zze(zzhobVar.zzf());
        return zziap.zza(zzhobVar);
    }

    private static void zze(zzhoi zzhoiVar) throws GeneralSecurityException {
        if (zzhoiVar.zzc() == 32) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("AesCmacKey size wrong, must be 32 bytes");
    }
}
