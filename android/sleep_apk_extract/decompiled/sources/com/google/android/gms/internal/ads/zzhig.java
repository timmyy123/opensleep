package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhig {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhif.zza, zzhic.class, zzhdi.class);
    private static final zzhdr zzc = zzhlw.zze("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzhdi.class, zzhsp.SYMMETRIC, zzhum.zze());
    private static final zzhmj zzd = zzhid.zza;
    private static final zzhln zze = zzhie.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering XChaCha20Poly1305 is not supported in FIPS mode");
            return;
        }
        int i = zzhkk.$r8$clinit;
        zzhkk.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzhii.zzb(zzhih.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzhii.zzb(zzhih.zzc));
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmi.zza().zzb(zze, zzhii.class);
        zzhmk.zza().zzb(zzd, zzhii.class);
        zzhlo.zza().zzb(zzc, true);
    }
}
