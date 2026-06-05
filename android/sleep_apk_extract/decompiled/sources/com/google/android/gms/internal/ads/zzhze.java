package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhze implements zziak {
    private static final ThreadLocal zza = new zzhzd();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzhze(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        zziax.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) zza.get()).getBlockSize();
        this.zzd = blockSize;
        if (i <= blockSize) {
            this.zzc = i;
        } else {
            zzbuy$$ExternalSyntheticBUOutline0.m("invalid IV size");
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziak
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        if (length < i) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int i2 = length - i;
        byte[] bArr3 = new byte[i2];
        Cipher cipher = (Cipher) zza.get();
        byte[] bArr4 = new byte[this.zzd];
        System.arraycopy(bArr2, 0, bArr4, 0, i);
        cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i, i2, bArr3, 0) == i2) {
            return bArr3;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("stored output's length does not match input's length");
        return null;
    }
}
