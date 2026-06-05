package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhhz {
    private static final zzhln zza = zzhhy.zza;
    private static final zzhnf zzb = zzhnf.zzd(zzhhx.zza, zzhhw.class, zzhdi.class);

    public static void zza(boolean z) {
        int i = zzhke.$r8$clinit;
        zzhke.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzhhv.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzhhv.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzhhv.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzhhv.zzj);
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmo.zza().zzb(zzb);
        zzhmi.zza().zzb(zza, zzhib.class);
    }
}
