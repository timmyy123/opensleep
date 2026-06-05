package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzh implements zzhdi {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzhzh(byte[] bArr, zziaz zziazVar) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        this.zza = zzhiu.zzb(bArr);
        this.zzb = zziazVar.zzc();
    }

    public static zzhdi zzb(zzhfq zzhfqVar) {
        zzhfqVar.zzf();
        zzhfqVar.zzf();
        return new zzhzh(zzhfqVar.zze().zzc(zzhdo.zza()), zzhfqVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("ciphertext is null");
            return null;
        }
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (OutputPrefix mismatch).");
            return null;
        }
        AlgorithmParameterSpec algorithmParameterSpecZzc = zzhiu.zzc(bArr, length2, 12);
        SecretKey secretKey = this.zza;
        Cipher cipherZza = zzhiu.zza();
        cipherZza.init(2, secretKey, algorithmParameterSpecZzc);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        return cipherZza.doFinal(bArr, length2 + 12, (length - length2) - 12);
    }
}
