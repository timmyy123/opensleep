package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhpo implements zzhoj {
    public zzhpo(zzhob zzhobVar) {
    }

    public static zzhoj zza(zzhob zzhobVar) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot use AES-CMAC in FIPS-mode.");
            return null;
        }
        Provider providerZza = zzhkv.zza();
        if (providerZza != null) {
            try {
                return zzhpn.zza(zzhobVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzhpo(zzhobVar);
    }
}
