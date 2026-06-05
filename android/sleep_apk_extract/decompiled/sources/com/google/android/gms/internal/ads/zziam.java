package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zziam implements zzhqd {
    public static zzhqd zzb(zzhqb zzhqbVar) {
        zzhqd zzhqdVarZzb = zzhqh.zzb(zzhqbVar);
        try {
            return new zzial(zzhqdVarZzb, zzhqi.zzb(zzhqbVar), null);
        } catch (GeneralSecurityException unused) {
            return zzhqdVarZzb;
        }
    }
}
