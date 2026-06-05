package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhjb implements zzhdi {
    private static final byte[] zza = zziaj.zza("7a806c");
    private static final byte[] zzb = zziaj.zza("46bb91c3c5");
    private static final byte[] zzc = zziaj.zza("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] zzd = zziaj.zza("bae8e37fc83441b16034566b");
    private static final byte[] zze = zziaj.zza("af60eb711bd85bc1e4d3e0a462e074eea428a8");
    private final zzhja zzf;
    private final SecretKey zzg;
    private final byte[] zzh;

    private zzhjb(byte[] bArr, byte[] bArr2, zzhja zzhjaVar) throws InvalidAlgorithmParameterException {
        this.zzh = bArr2;
        zziax.zza(bArr.length);
        this.zzg = new SecretKeySpec(bArr, "AES");
        this.zzf = zzhjaVar;
    }

    public static boolean zzb(Cipher cipher) {
        try {
            byte[] bArr = zzd;
            cipher.init(2, new SecretKeySpec(zzc, "AES"), new GCMParameterSpec(128, bArr, 0, bArr.length));
            cipher.updateAAD(zzb);
            byte[] bArr2 = zze;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), zza);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public static zzhdi zzc(zzhfz zzhfzVar, zzhja zzhjaVar) {
        if (zzb((Cipher) zzhjaVar.zza())) {
            return new zzhjb(zzhfzVar.zze().zzc(zzhdo.zza()), zzhfzVar.zzc().zzc(), zzhjaVar);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Cipher does not implement AES GCM SIV.");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzh;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (OutputPrefix mismatch).");
            return null;
        }
        Cipher cipher = (Cipher) this.zzf.zza();
        cipher.init(2, this.zzg, new GCMParameterSpec(128, bArr, length2, 12));
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        return cipher.doFinal(bArr, length2 + 12, (length - length2) - 12);
    }
}
