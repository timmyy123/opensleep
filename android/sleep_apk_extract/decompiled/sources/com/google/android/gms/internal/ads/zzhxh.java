package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhxh {
    static {
        int i = zzhto.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() {
        zzhwg.zzc();
        zzhwi.zzc();
        zzhvc.zza(true);
        zzhwu.zza(true);
        zzhxg.zza(true);
        if (zzhks.zza()) {
            return;
        }
        zzhvk.zza(true);
    }
}
