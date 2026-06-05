package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhes {
    private static final zzhdn zza = new zzher();

    public static zzhdn zza() throws GeneralSecurityException {
        if (!zzhks.zza()) {
            return zza;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
        return null;
    }
}
