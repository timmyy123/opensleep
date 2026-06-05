package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhvk {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhvi.zza, zzhvf.class, zzhej.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhvj.zza, zzhvl.class, zzhek.class);
    private static final zzhei zzd = zzhlw.zzf("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", zzhej.class, zzhsd.zzg());
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.Ed25519PublicKey", zzhek.class, zzhsp.ASYMMETRIC_PUBLIC, zzhsf.zzg());
    private static final zzhmj zzf = zzhvh.zza;
    private static final zzhln zzg = zzhvg.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering AES GCM SIV is not supported in FIPS mode");
            return;
        }
        int i = zzhya.$r8$clinit;
        zzhya.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("ED25519", zzhve.zzb(zzhvd.zza));
        zzhvd zzhvdVar = zzhvd.zzd;
        map.put("ED25519_RAW", zzhve.zzb(zzhvdVar));
        map.put("ED25519WithRawOutput", zzhve.zzb(zzhvdVar));
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmi.zza().zzb(zzg, zzhve.class);
        zzhmk.zza().zzb(zzf, zzhve.class);
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhlo.zza().zzb(zzd, true);
        zzhlo.zza().zzb(zze, false);
    }
}
