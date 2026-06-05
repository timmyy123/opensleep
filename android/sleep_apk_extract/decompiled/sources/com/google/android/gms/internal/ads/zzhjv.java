package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhjv {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long jZzc = zzc(bArr, 0, 0);
        long jZzc2 = zzc(bArr, 3, 2) & 67108611;
        long jZzc3 = zzc(bArr, 6, 4) & 67092735;
        long jZzc4 = zzc(bArr, 9, 6) & 66076671;
        long jZzc5 = zzc(bArr, 12, 8) & 1048575;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 >= length) {
                long j6 = j + (j2 >> 26);
                long j7 = j6 & 67108863;
                long j8 = j3 + (j6 >> 26);
                long j9 = j8 & 67108863;
                long j10 = j4 + (j8 >> 26);
                long j11 = j10 & 67108863;
                long j12 = ((j10 >> 26) * 5) + j5;
                long j13 = j12 >> 26;
                long j14 = j12 & 67108863;
                long j15 = j14 + 5;
                long j16 = (j2 & 67108863) + j13;
                long j17 = j16 + (j15 >> 26);
                long j18 = (j17 >> 26) + j7;
                long j19 = j9 + (j18 >> 26);
                long j20 = (j11 + (j19 >> 26)) - 67108864;
                long j21 = j20 >> 63;
                long j22 = ~j21;
                long j23 = (j16 & j21) | (j17 & 67108863 & j22);
                long j24 = (j7 & j21) | (j18 & 67108863 & j22);
                long j25 = (j9 & j21) | (j19 & 67108863 & j22);
                long j26 = (j11 & j21) | (j20 & j22);
                long jZzb = (((j14 & j21) | (j15 & 67108863 & j22) | (j23 << 26)) & 4294967295L) + zzb(bArr, 16);
                long jZzb2 = (((j23 >> 6) | (j24 << 20)) & 4294967295L) + zzb(bArr, 20);
                long jZzb3 = (((j25 << 14) | (j24 >> 12)) & 4294967295L) + zzb(bArr, 24);
                long jZzb4 = (((j25 >> 18) | (j26 << 8)) & 4294967295L) + zzb(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, jZzb & 4294967295L, 0);
                long j27 = jZzb2 + (jZzb >> 32);
                zzd(bArr4, j27 & 4294967295L, 4);
                long j28 = jZzb3 + (j27 >> 32);
                zzd(bArr4, j28 & 4294967295L, 8);
                zzd(bArr4, (jZzb4 + (j28 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int iMin = Math.min(16, length - i2);
            System.arraycopy(bArr2, i2, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, i, (byte) 0);
            }
            long j29 = jZzc5 * 5;
            long j30 = jZzc4 * 5;
            long j31 = jZzc3 * 5;
            long jZzc6 = j5 + zzc(bArr3, 0, 0);
            long jZzc7 = j2 + zzc(bArr3, 3, 2);
            long jZzc8 = j + zzc(bArr3, 6, 4);
            long jZzc9 = j3 + zzc(bArr3, 9, 6);
            long jZzc10 = j4 + (zzc(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
            long j32 = jZzc7 * jZzc;
            long j33 = jZzc7 * jZzc2;
            long j34 = jZzc8 * jZzc;
            long j35 = jZzc7 * jZzc3;
            long j36 = jZzc8 * jZzc2;
            long j37 = jZzc9 * jZzc;
            long j38 = jZzc7 * jZzc4;
            long j39 = jZzc8 * jZzc3;
            long j40 = jZzc9 * jZzc2;
            long j41 = jZzc10 * jZzc;
            long j42 = (jZzc2 * 5 * jZzc10) + (jZzc9 * j31) + (jZzc8 * j30) + (jZzc7 * j29) + (jZzc6 * jZzc);
            long j43 = j42 & 67108863;
            long j44 = jZzc9 * j30;
            long j45 = j31 * jZzc10;
            long j46 = j45 + j44 + (jZzc8 * j29) + (jZzc6 * jZzc2) + j32 + (j42 >> 26);
            long j47 = j30 * jZzc10;
            long j48 = j47 + (jZzc9 * j29) + (jZzc6 * jZzc3) + j33 + j34 + (j46 >> 26);
            long j49 = (jZzc10 * j29) + (jZzc6 * jZzc4) + j35 + j36 + j37 + (j48 >> 26);
            long j50 = (jZzc6 * jZzc5) + j38 + j39 + j40 + j41 + (j49 >> 26);
            long j51 = ((j50 >> 26) * 5) + j43;
            j2 = (j46 & 67108863) + (j51 >> 26);
            i2 += 16;
            j = j48 & 67108863;
            j3 = j49 & 67108863;
            j4 = j50 & 67108863;
            i = 17;
            j5 = j51 & 67108863;
        }
    }

    private static long zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((long) (((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16))) & 4294967295L;
    }

    private static long zzc(byte[] bArr, int i, int i2) {
        return (zzb(bArr, i) >> i2) & 67108863;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = (byte) (255 & j);
            j >>= 8;
        }
    }
}
