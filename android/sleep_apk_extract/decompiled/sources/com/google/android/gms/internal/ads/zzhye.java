package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhye implements zzhek {
    private final zzhek zza;
    private final byte[] zzb;
    private final byte[] zzc;

    private zzhye(zzhek zzhekVar, byte[] bArr, byte[] bArr2) {
        this.zza = zzhekVar;
        this.zzb = bArr;
        this.zzc = bArr2;
    }

    public static zzhek zzb(zzhlz zzhlzVar) {
        zzhnm zzhnmVarZzc = zzhlzVar.zzc(zzhdo.zza());
        return new zzhye((zzhek) zzhlo.zza().zzc(zzhnmVarZzc.zzg(), zzhek.class).zza(zzhnmVarZzc.zzb()), zzc(zzhnmVarZzc), zzd(zzhnmVarZzc));
    }

    public static byte[] zzc(zzhnm zzhnmVar) throws GeneralSecurityException {
        int iOrdinal = zzhnmVar.zzd().ordinal();
        if (iOrdinal == 1) {
            return zzhms.zzb(zzhnmVar.zze().intValue()).zzc();
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhms.zza.zzc();
            }
            if (iOrdinal != 4) {
                zzbuy$$ExternalSyntheticBUOutline0.m("unknown output prefix type");
                return null;
            }
        }
        return zzhms.zza(zzhnmVar.zze().intValue()).zzc();
    }

    public static byte[] zzd(zzhnm zzhnmVar) {
        return zzhnmVar.zzd().equals(zzhtm.LEGACY) ? new byte[]{0} : new byte[0];
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        if (length == 0 && this.zzc.length == 0) {
            this.zza.zza(bArr, bArr2);
            return;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature (output prefix mismatch)");
            return;
        }
        byte[] bArr4 = this.zzc;
        if (bArr4.length != 0) {
            bArr2 = zzhzl.zza(bArr2, bArr4);
        }
        this.zza.zza(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
    }
}
