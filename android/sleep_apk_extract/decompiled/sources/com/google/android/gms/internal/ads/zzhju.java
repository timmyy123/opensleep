package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhju implements zzhdi {
    private final zzhdi zza;
    private final byte[] zzb;

    private zzhju(zzhdi zzhdiVar, byte[] bArr) {
        this.zza = zzhdiVar;
        int length = bArr.length;
        if (length == 0 || length == 5) {
            this.zzb = bArr;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("identifier has an invalid length");
            throw null;
        }
    }

    public static zzhdi zzb(zzhlz zzhlzVar) throws GeneralSecurityException {
        byte[] bArrZzc;
        zzhnm zzhnmVarZzc = zzhlzVar.zzc(zzhdo.zza());
        zzhdi zzhdiVar = (zzhdi) zzhlo.zza().zzc(zzhnmVarZzc.zzg(), zzhdi.class).zza(zzhnmVarZzc.zzb());
        zzhtm zzhtmVarZzd = zzhnmVarZzc.zzd();
        int iOrdinal = zzhtmVarZzd.ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzhms.zzb(zzhlzVar.zzb().intValue()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzhms.zza(zzhlzVar.zzb().intValue()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzhtmVarZzd)));
            }
            bArrZzc = zzhms.zza(zzhlzVar.zzb().intValue()).zzc();
        } else {
            bArrZzc = zzhms.zza.zzc();
        }
        return new zzhju(zzhdiVar, bArrZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzhnz.zze(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("wrong prefix");
        return null;
    }
}
