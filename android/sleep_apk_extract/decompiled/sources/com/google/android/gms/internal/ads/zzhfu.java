package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhfu {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhfr.zza, zzhfq.class, zzhdi.class);
    private static final zzhdr zzc = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesGcmKey", zzhdi.class, zzhsp.SYMMETRIC, zzhrg.zze());
    private static final zzhmj zzd = zzhft.zza;
    private static final zzhln zze = zzhfs.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzhkr.zza(i)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
            return;
        }
        int i2 = zzhiz.$r8$clinit;
        zzhiz.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzhhv.zza);
        zzhfv zzhfvVar = new zzhfv(null);
        zzhfvVar.zzb(12);
        zzhfvVar.zza(16);
        zzhfvVar.zzc(16);
        zzhfw zzhfwVar = zzhfw.zzc;
        zzhfvVar.zzd(zzhfwVar);
        map.put("AES128_GCM_RAW", zzhfvVar.zze());
        map.put("AES256_GCM", zzhhv.zzb);
        zzhfv zzhfvVar2 = new zzhfv(null);
        zzhfvVar2.zzb(12);
        zzhfvVar2.zza(32);
        zzhfvVar2.zzc(16);
        zzhfvVar2.zzd(zzhfwVar);
        map.put("AES256_GCM_RAW", zzhfvVar2.zze());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmk.zza().zzb(zzd, zzhfx.class);
        zzhmi.zza().zzb(zze, zzhfx.class);
        zzhlo.zza().zzf(zzc, i, true);
    }
}
