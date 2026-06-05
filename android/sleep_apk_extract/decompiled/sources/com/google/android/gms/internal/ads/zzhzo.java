package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzo implements zzhej {
    private final byte[] zza;

    private zzhzo(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use Ed25519 in FIPS-mode.");
            throw null;
        }
        if (bArr.length != 32) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Given private key's length is not 32");
            throw null;
        }
        byte[] bArrZzb = zzhlc.zzb(bArr);
        this.zza = bArrZzb;
        zzhlc.zza(bArrZzb);
    }

    public static zzhej zzb(zzhvf zzhvfVar) throws GeneralSecurityException {
        if (zzhkr.zza(1)) {
            try {
                return zzhyb.zzb(zzhvfVar);
            } catch (GeneralSecurityException unused) {
                return new zzhzo(zzhvfVar.zzf().zzc(zzhdo.zza()), zzhvfVar.zze().zze().zzc(), zzhvfVar.zzd().zzc().equals(zzhvd.zzc) ? new byte[]{0} : new byte[0]);
            }
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Can not use Ed25519 in FIPS-mode.");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) {
        throw null;
    }
}
