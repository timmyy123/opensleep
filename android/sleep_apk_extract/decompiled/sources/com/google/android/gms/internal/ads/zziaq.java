package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zziaq implements zzhek {
    private final RSAPublicKey zza;
    private final zziai zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    public /* synthetic */ zziaq(RSAPublicKey rSAPublicKey, zziai zziaiVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhks.zza()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Conscrypt is not available, and we cannot use Java Implementation of RSA-PKCS1.5 in FIPS-mode.");
            throw null;
        }
        zziax.zzb(zziaiVar);
        zziax.zzc(rSAPublicKey.getModulus().bitLength());
        zziax.zzd(rSAPublicKey.getPublicExponent());
        this.zza = rSAPublicKey;
        this.zzb = zziaiVar;
        this.zzc = bArr;
        this.zzd = bArr2;
    }

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZza;
        int i;
        RSAPublicKey rSAPublicKey = this.zza;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        if (iBitLength != bArr.length) {
            zzbuy$$ExternalSyntheticBUOutline0.m("invalid signature's length");
            return;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m("signature out of range");
            return;
        }
        byte[] bArrZzb = zzhku.zzb(bigInteger.modPow(publicExponent, modulus), iBitLength);
        zziai zziaiVar = this.zzb;
        zziax.zzb(zziaiVar);
        MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb(zziaw.zzb(zziaiVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.zzd;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int iOrdinal = zziaiVar.ordinal();
        int i2 = 2;
        if (iOrdinal == 2) {
            bArrZza = zziaj.zza("3031300d060960864801650304020105000420");
        } else if (iOrdinal == 3) {
            bArrZza = zziaj.zza("3041300d060960864801650304020205000430");
        } else {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unsupported hash ".concat(zziaiVar.toString()));
            }
            bArrZza = zziaj.zza("3051300d060960864801650304020305000440");
        }
        if (iBitLength < bArrZza.length + bArrDigest.length + 11) {
            zzbuy$$ExternalSyntheticBUOutline0.m("intended encoded message length too short");
            return;
        }
        byte[] bArr4 = new byte[iBitLength];
        bArr4[0] = 0;
        bArr4[1] = 1;
        int i3 = 0;
        while (true) {
            i = i2 + 1;
            if (i3 >= (iBitLength - r3) - 3) {
                break;
            }
            bArr4[i2] = -1;
            i3++;
            i2 = i;
        }
        bArr4[i2] = 0;
        int length = bArrZza.length;
        System.arraycopy(bArrZza, 0, bArr4, i, length);
        System.arraycopy(bArrDigest, 0, bArr4, i + length, bArrDigest.length);
        if (MessageDigest.isEqual(bArrZzb, bArr4)) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("invalid signature");
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzc;
        int length = bArr3.length;
        if (length == 0) {
            zzb(bArr, bArr2);
        } else if (zzhnz.zze(bArr3, bArr)) {
            zzb(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        } else {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature (output prefix mismatch)");
        }
    }
}
