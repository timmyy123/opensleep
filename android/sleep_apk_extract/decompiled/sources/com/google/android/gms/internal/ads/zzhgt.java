package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhgt {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzhdr zzb = zzhlw.zze("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzhdi.class, zzhsp.SYMMETRIC, zzhtj.zze());
    private static final zzhln zzc = zzhgs.zza;
    private static final zzhnf zzd = zzhnf.zzd(zzhgr.zza, zzhhc.class, zzhdi.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Registering KMS Envelope AEAD is not supported in FIPS mode");
            return;
        }
        int i = zzhhl.$r8$clinit;
        zzhhl.zza(zzhmr.zza());
        zzhmi.zza().zzb(zzc, zzhhg.class);
        zzhmo.zza().zzb(zzd);
        zzhlo.zza().zzb(zzb, true);
    }
}
