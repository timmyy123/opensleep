package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhdt {
    public static final zzhst zza(zzheh zzhehVar) {
        try {
            return ((zzhnn) zzhmr.zza().zzk(null, zzhnn.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzhny("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }

    public static final zzheh zzb(zzheh zzhehVar) {
        return zzhehVar != null ? zzhehVar : zzhen.zzb(zza(null).zzaN());
    }
}
