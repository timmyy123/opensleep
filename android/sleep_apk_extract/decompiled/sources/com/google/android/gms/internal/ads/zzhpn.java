package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhpn implements zzhoj {
    private zzhpn(zzhob zzhobVar, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot use AES-CMAC in FIPS-mode.");
            throw null;
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzhobVar.zze().zzc();
            zzhobVar.zzf();
            new SecretKeySpec(zzhobVar.zzd().zzc(zzhdo.zza()), "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }

    public static zzhoj zza(zzhob zzhobVar, Provider provider) {
        return new zzhpn(zzhobVar, provider);
    }
}
