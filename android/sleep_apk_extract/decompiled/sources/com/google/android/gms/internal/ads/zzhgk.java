package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhgk {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhgj.zza, zzhgh.class, zzhdi.class);
    private static final zzhln zzc = zzhgi.zza;
    private static final zzhdr zzd = zzhlw.zze("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzhdi.class, zzhsp.SYMMETRIC, zzhro.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering ChaCha20Poly1305 is not supported in FIPS mode");
            return;
        }
        int i = zzhjm.$r8$clinit;
        zzhjm.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmi.zza().zzb(zzc, zzhgm.class);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzhgm.zzb(zzhgl.zza));
        map.put("CHACHA20_POLY1305_RAW", zzhgm.zzb(zzhgl.zzc));
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhlo.zza().zzb(zzd, true);
    }
}
