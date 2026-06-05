package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhgp {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhgo.zza, zzhgu.class, zzhdi.class);
    private static final zzhdr zzc = zzhlw.zze("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzhdi.class, zzhsp.REMOTE, zzhtf.zze());
    private static final zzhln zzd = zzhgn.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering KMS AEAD is not supported in FIPS mode");
            return;
        }
        int i = zzhhb.$r8$clinit;
        zzhhb.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmi.zza().zzb(zzd, zzhgw.class);
        zzhlo.zza().zzb(zzc, true);
    }
}
