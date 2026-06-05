package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzg implements zzhdi {
    private static final ThreadLocal zza = new zzhzf();
    private final byte[] zzb;
    private final zzhqd zzc;
    private final SecretKeySpec zzd;
    private final int zze;

    private zzhzg(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use AES-EAX in FIPS-mode.");
            throw null;
        }
        if (i != 12 && i != 16) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("IV size should be either 12 or 16 bytes");
            throw null;
        }
        this.zze = i;
        int length = bArr.length;
        zziax.zza(length);
        this.zzd = new SecretKeySpec(bArr, "AES");
        this.zzc = zziam.zzb(zzhqb.zzc(zzhqc.zzb(length), zzibb.zza(bArr, zzhdo.zza())));
        this.zzb = bArr2;
    }

    public static zzhdi zzb(zzhfi zzhfiVar) throws GeneralSecurityException {
        if (zzhkr.zza(1)) {
            zzhfiVar.zzf();
            return new zzhzg(zzhfiVar.zze().zzc(zzhdo.zza()), zzhfiVar.zzf().zzd(), zzhfiVar.zzc().zzc());
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Can not use AES-EAX in FIPS-mode.");
        return null;
    }

    private final byte[] zzc(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3 + 16];
        bArr2[15] = (byte) i;
        System.arraycopy(bArr, i2, bArr2, 16, i3);
        return this.zzc.zza(bArr2, 16);
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i = this.zze;
        int i2 = ((length - length2) - i) - 16;
        if (i2 < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (OutputPrefix mismatch).");
            return null;
        }
        byte[] bArrZzc = zzc(0, bArr, length2, i);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZzc2 = zzc(1, bArr2, 0, bArr2.length);
        byte[] bArrZzc3 = zzc(2, bArr, length2 + i, i2);
        int i3 = length - 16;
        byte b = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            b = (byte) (b | (((bArr[i3 + i4] ^ bArrZzc2[i4]) ^ bArrZzc[i4]) ^ bArrZzc3[i4]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzd, new IvParameterSpec(bArrZzc));
        return cipher.doFinal(bArr, bArr3.length + i, i2);
    }
}
