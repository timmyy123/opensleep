package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhzt {
    public static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i;
        int length = bArr.length;
        if ((length & 1) != 0 || length == 0 || length > 132) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid IEEE_P1363 encoding");
            return null;
        }
        int i2 = length >> 1;
        byte[] bArrZzc = zzc(Arrays.copyOf(bArr, i2));
        byte[] bArrZzc2 = zzc(Arrays.copyOfRange(bArr, i2, length));
        int length2 = bArrZzc.length;
        int length3 = bArrZzc2.length;
        int i3 = length2 + 4 + length3;
        if (i3 >= 128) {
            bArr2 = new byte[i3 + 3];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) i3;
            i = 3;
        } else {
            bArr2 = new byte[i3 + 2];
            bArr2[0] = 48;
            bArr2[1] = (byte) i3;
            i = 2;
        }
        int i4 = i + 1;
        bArr2[i] = 2;
        int i5 = i + 2;
        bArr2[i4] = (byte) length2;
        System.arraycopy(bArrZzc, 0, bArr2, i5, length2);
        int i6 = i5 + length2;
        bArr2[i6] = 2;
        bArr2[i6 + 1] = (byte) length3;
        System.arraycopy(bArrZzc2, 0, bArr2, i6 + 2, length3);
        return bArr2;
    }

    public static ECParameterSpec zzb(zzhzr zzhzrVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzhzrVar.ordinal();
        if (iOrdinal == 0) {
            return zzhlg.zza;
        }
        if (iOrdinal == 1) {
            return zzhlg.zzb;
        }
        if (iOrdinal == 2) {
            return zzhlg.zzc;
        }
        throw new NoSuchAlgorithmException("curve not implemented:".concat(zzhzrVar.toString()));
    }

    private static byte[] zzc(byte[] bArr) {
        int length;
        int i = 0;
        while (true) {
            length = bArr.length;
            if (i >= length || bArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == length) {
            i = length - 1;
        }
        int i2 = (bArr[i] & 128) == 128 ? 1 : 0;
        int i3 = length - i;
        byte[] bArr2 = new byte[i3 + i2];
        System.arraycopy(bArr, i, bArr2, i2, i3);
        return bArr2;
    }
}
