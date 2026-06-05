package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhow {
    static {
        int i = zzhto.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzhpa.zzc();
        zzhok.zzc();
        zzhor.zza(true);
        if (zzhks.zza()) {
            return;
        }
        zzhof.zza(true);
    }
}
