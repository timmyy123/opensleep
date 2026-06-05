package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhor {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhon.zza, zzhom.class, zzhoj.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhoq.zza, zzhom.class, zzheg.class);
    private static final zzhdr zzd = zzhlw.zze("type.googleapis.com/google.crypto.tink.HmacKey", zzheg.class, zzhsp.SYMMETRIC, zzhsj.zzh());
    private static final zzhmj zze = zzhop.zza;
    private static final zzhln zzf = zzhoo.zza;
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzhkr.zza(i)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
            return;
        }
        int i2 = zzhpu.$r8$clinit;
        zzhpu.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzhpg.zza);
        zzhos zzhosVar = new zzhos(null);
        zzhosVar.zza(32);
        zzhosVar.zzb(16);
        zzhou zzhouVar = zzhou.zzd;
        zzhosVar.zzc(zzhouVar);
        zzhot zzhotVar = zzhot.zzc;
        zzhosVar.zzd(zzhotVar);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzhosVar.zze());
        zzhos zzhosVar2 = new zzhos(null);
        zzhosVar2.zza(32);
        zzhosVar2.zzb(32);
        zzhou zzhouVar2 = zzhou.zza;
        zzhosVar2.zzc(zzhouVar2);
        zzhosVar2.zzd(zzhotVar);
        map.put("HMAC_SHA256_256BITTAG", zzhosVar2.zze());
        zzhos zzhosVar3 = new zzhos(null);
        zzhosVar3.zza(32);
        zzhosVar3.zzb(32);
        zzhosVar3.zzc(zzhouVar);
        zzhosVar3.zzd(zzhotVar);
        map.put("HMAC_SHA256_256BITTAG_RAW", zzhosVar3.zze());
        zzhos zzhosVar4 = new zzhos(null);
        zzhosVar4.zza(64);
        zzhosVar4.zzb(16);
        zzhosVar4.zzc(zzhouVar2);
        zzhot zzhotVar2 = zzhot.zze;
        zzhosVar4.zzd(zzhotVar2);
        map.put("HMAC_SHA512_128BITTAG", zzhosVar4.zze());
        zzhos zzhosVar5 = new zzhos(null);
        zzhosVar5.zza(64);
        zzhosVar5.zzb(16);
        zzhosVar5.zzc(zzhouVar);
        zzhosVar5.zzd(zzhotVar2);
        map.put("HMAC_SHA512_128BITTAG_RAW", zzhosVar5.zze());
        zzhos zzhosVar6 = new zzhos(null);
        zzhosVar6.zza(64);
        zzhosVar6.zzb(32);
        zzhosVar6.zzc(zzhouVar2);
        zzhosVar6.zzd(zzhotVar2);
        map.put("HMAC_SHA512_256BITTAG", zzhosVar6.zze());
        zzhos zzhosVar7 = new zzhos(null);
        zzhosVar7.zza(64);
        zzhosVar7.zzb(32);
        zzhosVar7.zzc(zzhouVar);
        zzhosVar7.zzd(zzhotVar2);
        map.put("HMAC_SHA512_256BITTAG_RAW", zzhosVar7.zze());
        map.put("HMAC_SHA512_512BITTAG", zzhpg.zzb);
        zzhos zzhosVar8 = new zzhos(null);
        zzhosVar8.zza(64);
        zzhosVar8.zzb(64);
        zzhosVar8.zzc(zzhouVar);
        zzhosVar8.zzd(zzhotVar2);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzhosVar8.zze());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmi.zza().zzb(zzf, zzhov.class);
        zzhmk.zza().zzb(zze, zzhov.class);
        zzhlo.zza().zzf(zzd, i, true);
    }
}
