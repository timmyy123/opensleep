package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhgd {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhga.zza, zzhfz.class, zzhdi.class);
    private static final zzhln zzc = zzhgc.zza;
    private static final zzhmj zzd = zzhgb.zza;
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzhdi.class, zzhsp.SYMMETRIC, zzhrk.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering AES GCM SIV is not supported in FIPS mode");
            return;
        }
        int i = zzhjg.$r8$clinit;
        zzhjg.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        zzhge zzhgeVar = new zzhge(null);
        zzhgeVar.zza(16);
        zzhgf zzhgfVar = zzhgf.zza;
        zzhgeVar.zzb(zzhgfVar);
        map.put("AES128_GCM_SIV", zzhgeVar.zzc());
        zzhge zzhgeVar2 = new zzhge(null);
        zzhgeVar2.zza(16);
        zzhgf zzhgfVar2 = zzhgf.zzc;
        zzhgeVar2.zzb(zzhgfVar2);
        map.put("AES128_GCM_SIV_RAW", zzhgeVar2.zzc());
        zzhge zzhgeVar3 = new zzhge(null);
        zzhgeVar3.zza(32);
        zzhgeVar3.zzb(zzhgfVar);
        map.put("AES256_GCM_SIV", zzhgeVar3.zzc());
        zzhge zzhgeVar4 = new zzhge(null);
        zzhgeVar4.zza(32);
        zzhgeVar4.zzb(zzhgfVar2);
        map.put("AES256_GCM_SIV_RAW", zzhgeVar4.zzc());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmk.zza().zzb(zzd, zzhgg.class);
        zzhmi.zza().zzb(zzc, zzhgg.class);
        zzhmo.zza().zzb(zzb);
        zzhlo.zza().zzb(zze, true);
    }
}
