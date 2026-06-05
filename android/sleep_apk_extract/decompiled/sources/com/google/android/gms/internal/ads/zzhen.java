package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhen {
    public static byte[] zza(zzheh zzhehVar) {
        return ((zzhnn) zzhmr.zza().zzk(zzhehVar, zzhnn.class)).zzc().zzaN();
    }

    public static zzheh zzb(byte[] bArr) {
        try {
            zzhst zzhstVarZzd = zzhst.zzd(bArr, zzido.zza());
            zzhmr zzhmrVarZza = zzhmr.zza();
            zzhnn zzhnnVarZzb = zzhnn.zzb(zzhstVarZzd);
            return !zzhmrVarZza.zzi(zzhnnVarZzb) ? new zzhma(zzhnnVarZzb) : zzhmrVarZza.zzj(zzhnnVarZzb);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }
}
