package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhpv implements zzheg {
    private zzhpv(zzheg zzhegVar, zzhtm zzhtmVar, byte[] bArr) {
    }

    public static zzheg zza(zzhlz zzhlzVar) throws GeneralSecurityException {
        byte[] bArrZzc;
        zzhnm zzhnmVarZzc = zzhlzVar.zzc(zzhdo.zza());
        zzheg zzhegVar = (zzheg) zzhlo.zza().zzc(zzhnmVarZzc.zzg(), zzheg.class).zza(zzhnmVarZzc.zzb());
        zzhtm zzhtmVarZzd = zzhnmVarZzc.zzd();
        int iOrdinal = zzhtmVarZzd.ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzhms.zzb(zzhlzVar.zzb().intValue()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzhms.zza(zzhlzVar.zzb().intValue()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                zzbuy$$ExternalSyntheticBUOutline0.m("unknown output prefix type");
                return null;
            }
            bArrZzc = zzhms.zza(zzhlzVar.zzb().intValue()).zzc();
        } else {
            bArrZzc = zzhms.zza.zzc();
        }
        return new zzhpv(zzhegVar, zzhtmVarZzd, bArrZzc);
    }
}
