package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhzc {
    public static zzhek zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zziaz zziazVarZzd;
        zzhna zzhnaVar = new zzhna();
        for (int i = 0; i < zzhecVar.zzd(); i++) {
            zzhdz zzhdzVarZze = ((zzheb) zzhecVar).zze(i);
            if (zzhdzVarZze.zzb().equals(zzhds.zza)) {
                zzhek zzhekVar = (zzhek) zzhnkVar.zza(zzhdzVarZze);
                zzhdq zzhdqVarZza = zzhdzVarZze.zza();
                if (zzhdqVarZza instanceof zzhxk) {
                    zziazVarZzd = ((zzhxk) zzhdqVarZza).zze();
                } else {
                    if (!(zzhdqVarZza instanceof zzhlz)) {
                        String name = zzhdqVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzhdqVarZza.zza());
                        throw new GeneralSecurityException(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(name.length() + 59 + strValueOf.length()), "Cannot get output prefix for key of class ", name, " with parameters ", strValueOf));
                    }
                    zziazVarZzd = ((zzhlz) zzhdqVarZza).zzd();
                }
                zzhnaVar.zza(zziazVarZzd, new zzhzb(zzhekVar, zzhdzVarZze.zzc()));
            }
        }
        zzhecVar.zzf(zzhmc.class);
        return new zzhza(zzhnaVar.zzb(), zzhmg.zza);
    }
}
