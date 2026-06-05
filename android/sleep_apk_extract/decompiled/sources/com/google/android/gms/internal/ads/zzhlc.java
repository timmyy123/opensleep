package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhlc {
    private static final zzhkx zzb = new zzhkx(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final zzhkz zzc = new zzhkz(new zzhla(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] zza = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    public static byte[] zza(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 + i2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) ((bArr[i2] & 255) >> 4);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr2[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        zzhkz zzhkzVar = new zzhkz(zzc);
        zzhlb zzhlbVar = new zzhlb();
        for (i = 1; i < 64; i += 2) {
            zzhkx zzhkxVar = new zzhkx(zzb);
            zzk(zzhkxVar, i / 2, bArr2[i]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar);
        }
        zzhla zzhlaVar = new zzhla();
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        for (int i7 = 0; i7 < 64; i7 += 2) {
            zzhkx zzhkxVar2 = new zzhkx(zzb);
            zzk(zzhkxVar2, i7 / 2, bArr2[i7]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar2);
        }
        zzhla zzhlaVar2 = new zzhla(zzhkzVar);
        long[] jArr = new long[10];
        zzhlj.zzf(jArr, zzhlaVar2.zza);
        long[] jArr2 = new long[10];
        zzhlj.zzf(jArr2, zzhlaVar2.zzb);
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr3, zzhlaVar2.zzc);
        long[] jArr4 = new long[10];
        zzhlj.zzf(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhlj.zzb(jArr5, jArr2, jArr);
        zzhlj.zze(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhlj.zze(jArr6, jArr, jArr2);
        zzhlj.zze(jArr6, jArr6, zzhle.zza);
        zzhlj.zza(jArr6, jArr6, jArr4);
        zzhlj.zzc(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhlj.zzh(jArr5), zzhlj.zzh(jArr6))) {
            return zzhlaVar2.zzb();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("arithmetic error in scalar multiplication");
        return null;
    }

    public static byte[] zzb(byte[] bArr) {
        MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i = bArrDigest[31] & 127;
        bArrDigest[31] = (byte) i;
        bArrDigest[31] = (byte) (i | 64);
        return bArrDigest;
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte b;
        byte[] bArr4 = bArr2;
        byte[] bArr5 = bArr3;
        if (bArr4.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, 32, 64);
        int i = 31;
        while (true) {
            if (i < 0) {
                break;
            }
            int i2 = bArrCopyOfRange[i] & 255;
            int i3 = zza[i] & 255;
            if (i2 == i3) {
                i--;
                bArr4 = bArr2;
                bArr5 = bArr3;
            } else if (i2 < i3) {
                MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
                messageDigest.update(bArr4, 0, 32);
                messageDigest.update(bArr5);
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                long jZzn = zzn(bArrDigest, 0) & 2097151;
                long jZzo = zzo(bArrDigest, 2) >> 5;
                long jZzn2 = zzn(bArrDigest, 5) >> 2;
                long jZzo2 = zzo(bArrDigest, 7) >> 7;
                long jZzo3 = zzo(bArrDigest, 10) >> 4;
                long jZzn3 = zzn(bArrDigest, 13) >> 1;
                long jZzo4 = zzo(bArrDigest, 15) >> 6;
                long jZzn4 = zzn(bArrDigest, 18) >> 3;
                long jZzn5 = zzn(bArrDigest, 21) & 2097151;
                long jZzo5 = zzo(bArrDigest, 23) >> 5;
                long jZzn6 = zzn(bArrDigest, 26) >> 2;
                long jZzo6 = zzo(bArrDigest, 28) >> 7;
                long jZzo7 = zzo(bArrDigest, 31) >> 4;
                long jZzn7 = zzn(bArrDigest, 34) >> 1;
                long jZzo8 = zzo(bArrDigest, 36) >> 6;
                long jZzn8 = zzn(bArrDigest, 39) >> 3;
                long jZzn9 = zzn(bArrDigest, 42) & 2097151;
                long jZzo9 = zzo(bArrDigest, 44) >> 5;
                long jZzn10 = (zzn(bArrDigest, 47) >> 2) & 2097151;
                long jZzo10 = (zzo(bArrDigest, 49) >> 7) & 2097151;
                long jZzo11 = (zzo(bArrDigest, 52) >> 4) & 2097151;
                long jZzn11 = (zzn(bArrDigest, 55) >> 1) & 2097151;
                long jZzo12 = (zzo(bArrDigest, 57) >> 6) & 2097151;
                long jZzo13 = zzo(bArrDigest, 60) >> 3;
                long j = (jZzo11 * 666643) + jZzn5;
                long j2 = (jZzo10 * 666643) + jZzn4;
                long j3 = (jZzn10 * 666643) + (jZzo4 & 2097151);
                long j4 = (j3 + 1048576) >> 21;
                long j5 = j4 << 21;
                long j6 = (jZzn10 * 654183) + (jZzo10 * 470296) + j;
                long j7 = (j6 + 1048576) >> 21;
                long j8 = j7 << 21;
                long j9 = (jZzn10 * 136657) + (((jZzo11 * 654183) + ((jZzn11 * 470296) + ((jZzo12 * 666643) + (jZzn6 & 2097151)))) - (jZzo10 * 997805));
                long j10 = (j9 + 1048576) >> 21;
                long j11 = j10 << 21;
                long j12 = ((jZzo11 * 136657) + (((jZzo12 * 654183) + ((jZzo13 * 470296) + (jZzo7 & 2097151))) - (jZzn11 * 997805))) - (jZzo10 * 683901);
                long j13 = (j12 + 1048576) >> 21;
                long j14 = ((jZzo12 * 136657) + ((jZzo8 & 2097151) - (jZzo13 * 997805))) - (jZzn11 * 683901);
                long j15 = (j14 + 1048576) >> 21;
                long j16 = j15 << 21;
                long j17 = jZzn9 - (jZzo13 * 683901);
                long j18 = (j17 + 1048576) >> 21;
                long j19 = (jZzn10 * 470296) + j2 + j4;
                long j20 = (j19 + 1048576) >> 21;
                long j21 = j20 << 21;
                long j22 = (((jZzo10 * 654183) + ((jZzo11 * 470296) + ((jZzn11 * 666643) + (jZzo5 & 2097151)))) - (jZzn10 * 997805)) + j7;
                long j23 = (j22 + 1048576) >> 21;
                long j24 = j23 << 21;
                long j25 = (((jZzo10 * 136657) + (((jZzn11 * 654183) + ((jZzo12 * 470296) + ((jZzo13 * 666643) + (jZzo6 & 2097151)))) - (jZzo11 * 997805))) - (jZzn10 * 683901)) + j10;
                long j26 = (j25 + 1048576) >> 21;
                long j27 = j26 << 21;
                long j28 = (((jZzn11 * 136657) + (((jZzo13 * 654183) + (jZzn7 & 2097151)) - (jZzo12 * 997805))) - (jZzo11 * 683901)) + j13;
                long j29 = (j28 + 1048576) >> 21;
                long j30 = (((jZzo13 * 136657) + jZzn8) - (jZzo12 * 683901)) + j15;
                long j31 = (j30 + 1048576) >> 21;
                long j32 = (j12 - (j13 << 21)) + j26;
                long j33 = (j32 * 666643) + jZzn;
                long j34 = (j33 + 1048576) >> 21;
                long j35 = j34 << 21;
                long j36 = (j14 - j16) + j29;
                long j37 = j28 - (j29 << 21);
                long j38 = (j32 * 654183) + (j37 * 470296) + (j36 * 666643) + (jZzn2 & 2097151);
                long j39 = (j38 + 1048576) >> 21;
                long j40 = j39 << 21;
                long j41 = (j17 - (j18 << 21)) + j31;
                long j42 = j30 - (j31 << 21);
                long j43 = (j32 * 136657) + (((j36 * 654183) + ((j42 * 470296) + ((j41 * 666643) + (jZzo3 & 2097151)))) - (j37 * 997805));
                long j44 = (j43 + 1048576) >> 21;
                long j45 = j44 << 21;
                long j46 = (jZzo9 & 2097151) + j18;
                long j47 = ((j36 * 136657) + (((j41 * 654183) + ((j46 * 470296) + (j3 - j5))) - (j42 * 997805))) - (j37 * 683901);
                long j48 = (j47 + 1048576) >> 21;
                long j49 = j48 << 21;
                long j50 = ((j41 * 136657) + (((j6 - j8) + j20) - (j46 * 997805))) - (j42 * 683901);
                long j51 = (j50 + 1048576) >> 21;
                long j52 = j51 << 21;
                long j53 = ((j9 - j11) + j23) - (j46 * 683901);
                long j54 = (j53 + 1048576) >> 21;
                long j55 = j54 << 21;
                long j56 = (j32 * 470296) + (j37 * 666643) + (jZzo & 2097151) + j34;
                long j57 = (j56 + 1048576) >> 21;
                long j58 = (((j37 * 654183) + ((j36 * 470296) + ((j42 * 666643) + (jZzo2 & 2097151)))) - (j32 * 997805)) + j39;
                long j59 = (j58 + 1048576) >> 21;
                long j60 = (((j37 * 136657) + (((j42 * 654183) + ((j41 * 470296) + ((j46 * 666643) + (jZzn3 & 2097151)))) - (j36 * 997805))) - (j32 * 683901)) + j44;
                long j61 = (j60 + 1048576) >> 21;
                long j62 = (((j42 * 136657) + (((j46 * 654183) + (j19 - j21)) - (j41 * 997805))) - (j36 * 683901)) + j48;
                long j63 = (j62 + 1048576) >> 21;
                long j64 = (((j46 * 136657) + (j22 - j24)) - (j41 * 683901)) + j51;
                long j65 = (j64 + 1048576) >> 21;
                long j66 = (j25 - j27) + j54;
                long j67 = (j66 + 1048576) >> 21;
                long j68 = j67 << 21;
                long j69 = (j67 * 666643) + (j33 - j35);
                long j70 = j69 >> 21;
                long j71 = j70 << 21;
                long j72 = (j67 * 470296) + (j56 - (j57 << 21)) + j70;
                long j73 = j72 >> 21;
                long j74 = j73 << 21;
                long j75 = (j67 * 654183) + (j38 - j40) + j57 + j73;
                long j76 = j75 >> 21;
                long j77 = j76 << 21;
                long j78 = ((j58 - (j59 << 21)) - (j67 * 997805)) + j76;
                long j79 = j78 >> 21;
                long j80 = j79 << 21;
                long j81 = (j67 * 136657) + (j43 - j45) + j59 + j79;
                long j82 = j81 >> 21;
                long j83 = j82 << 21;
                long j84 = ((j60 - (j61 << 21)) - (j67 * 683901)) + j82;
                long j85 = j84 >> 21;
                long j86 = j85 << 21;
                long j87 = (j47 - j49) + j61 + j85;
                long j88 = j87 >> 21;
                long j89 = j88 << 21;
                long j90 = (j62 - (j63 << 21)) + j88;
                long j91 = j90 >> 21;
                long j92 = j91 << 21;
                long j93 = (j50 - j52) + j63 + j91;
                long j94 = j93 >> 21;
                long j95 = j94 << 21;
                long j96 = (j64 - (j65 << 21)) + j94;
                long j97 = j96 >> 21;
                long j98 = j97 << 21;
                long j99 = (j53 - j55) + j65 + j97;
                long j100 = j99 >> 21;
                long j101 = j100 << 21;
                long j102 = (j66 - j68) + j100;
                long j103 = j102 >> 21;
                long j104 = j103 << 21;
                long j105 = (666643 * j103) + (j69 - j71);
                long j106 = j105 >> 21;
                long j107 = j106 << 21;
                long j108 = (470296 * j103) + (j72 - j74) + j106;
                long j109 = j108 >> 21;
                long j110 = j109 << 21;
                long j111 = (654183 * j103) + (j75 - j77) + j109;
                long j112 = j111 >> 21;
                long j113 = j112 << 21;
                long j114 = ((j78 - j80) - (997805 * j103)) + j112;
                long j115 = j114 >> 21;
                long j116 = j115 << 21;
                long j117 = (136657 * j103) + (j81 - j83) + j115;
                long j118 = j117 >> 21;
                long j119 = j118 << 21;
                long j120 = ((j84 - j86) - (j103 * 683901)) + j118;
                long j121 = j120 >> 21;
                long j122 = j121 << 21;
                long j123 = (j87 - j89) + j121;
                long j124 = j123 >> 21;
                long j125 = j124 << 21;
                long j126 = (j90 - j92) + j124;
                long j127 = j126 >> 21;
                long j128 = j127 << 21;
                long j129 = (j93 - j95) + j127;
                long j130 = j129 >> 21;
                long j131 = j130 << 21;
                long j132 = (j96 - j98) + j130;
                long j133 = j132 >> 21;
                long j134 = j133 << 21;
                long j135 = (j99 - j101) + j133;
                long j136 = j135 >> 21;
                bArrDigest[0] = (byte) (j105 - j107);
                long j137 = j126 - j128;
                long j138 = j123 - j125;
                long j139 = j120 - j122;
                long j140 = j117 - j119;
                long j141 = j114 - j116;
                long j142 = j111 - j113;
                long j143 = j108 - j110;
                bArrDigest[1] = (byte) (r7 >> 8);
                bArrDigest[2] = (byte) ((r7 >> 16) | (j143 << 5));
                bArrDigest[3] = (byte) (j143 >> 3);
                bArrDigest[4] = (byte) (j143 >> 11);
                bArrDigest[5] = (byte) ((j143 >> 19) | (j142 << 2));
                bArrDigest[6] = (byte) (j142 >> 6);
                bArrDigest[7] = (byte) ((j142 >> 14) | (j141 << 7));
                bArrDigest[8] = (byte) (j141 >> 1);
                bArrDigest[9] = (byte) (j141 >> 9);
                bArrDigest[10] = (byte) ((j141 >> 17) | (j140 << 4));
                bArrDigest[11] = (byte) (j140 >> 4);
                bArrDigest[12] = (byte) (j140 >> 12);
                bArrDigest[13] = (byte) ((j140 >> 20) | (j139 + j139));
                bArrDigest[14] = (byte) (j139 >> 7);
                bArrDigest[15] = (byte) ((j139 >> 15) | (j138 << 6));
                bArrDigest[16] = (byte) (j138 >> 2);
                bArrDigest[17] = (byte) (j138 >> 10);
                bArrDigest[18] = (byte) ((j138 >> 18) | (j137 << 3));
                long j144 = j135 - (j136 << 21);
                long j145 = (j102 - j104) + j136;
                long j146 = j132 - j134;
                bArrDigest[19] = (byte) (j137 >> 5);
                bArrDigest[20] = (byte) (j137 >> 13);
                bArrDigest[21] = (byte) (j129 - j131);
                bArrDigest[22] = (byte) (r9 >> 8);
                bArrDigest[23] = (byte) ((r9 >> 16) | (j146 << 5));
                bArrDigest[24] = (byte) (j146 >> 3);
                bArrDigest[25] = (byte) (j146 >> 11);
                bArrDigest[26] = (byte) ((j146 >> 19) | (j144 << 2));
                bArrDigest[27] = (byte) (j144 >> 6);
                bArrDigest[28] = (byte) ((j144 >> 14) | (j145 << 7));
                bArrDigest[29] = (byte) (j145 >> 1);
                bArrDigest[30] = (byte) (j145 >> 9);
                bArrDigest[31] = (byte) (j145 >> 17);
                long[] jArr = new long[10];
                long[] jArrZzg = zzhlj.zzg(bArr5);
                long[] jArr2 = new long[10];
                jArr2[0] = 1;
                long[] jArr3 = new long[10];
                long[] jArr4 = new long[10];
                long[] jArr5 = new long[10];
                long[] jArr6 = new long[10];
                long[] jArr7 = new long[10];
                zzhlj.zzf(jArr4, jArrZzg);
                zzhlj.zze(jArr5, jArr4, zzhle.zza);
                zzhlj.zzb(jArr4, jArr4, jArr2);
                zzhlj.zza(jArr5, jArr5, jArr2);
                long[] jArr8 = new long[10];
                zzhlj.zzf(jArr8, jArr5);
                zzhlj.zze(jArr8, jArr8, jArr5);
                zzhlj.zzf(jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr5);
                zzhlj.zze(jArr, jArr, jArr4);
                long[] jArr9 = new long[10];
                long[] jArr10 = new long[10];
                long[] jArr11 = new long[10];
                zzhlj.zzf(jArr9, jArr);
                zzhlj.zzf(jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr10);
                zzhlj.zze(jArr10, jArr, jArr10);
                zzhlj.zze(jArr9, jArr9, jArr10);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i4 = 1; i4 < 5; i4++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i5 = 1; i5 < 10; i5++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i6 = 1; i6 < 20; i6++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i7 = 1; i7 < 10; i7++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i8 = 1; i8 < 50; i8++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i9 = 1; i9 < 100; i9++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i10 = 1; i10 < 50; i10++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr, jArr9, jArr);
                zzhlj.zze(jArr, jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr4);
                zzhlj.zzf(jArr6, jArr);
                zzhlj.zze(jArr6, jArr6, jArr5);
                zzhlj.zzb(jArr7, jArr6, jArr4);
                if (zze(jArr7)) {
                    zzhlj.zza(jArr7, jArr6, jArr4);
                    if (zze(jArr7)) {
                        zzbuy$$ExternalSyntheticBUOutline0.m("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                        return false;
                    }
                    zzhlj.zze(jArr, jArr, zzhle.zzc);
                }
                if (zze(jArr)) {
                    b = 255;
                } else {
                    b = 255;
                    if (((bArr3[31] & 255) >> 7) != 0) {
                        zzbuy$$ExternalSyntheticBUOutline0.m("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                        return false;
                    }
                }
                if (zzf(jArr) == ((bArr3[31] & b) >> 7)) {
                    zzm(jArr, jArr);
                }
                zzhlj.zze(jArr3, jArr, jArrZzg);
                zzhlb zzhlbVar = new zzhlb(new zzhla(jArr, jArrZzg, jArr2), jArr3);
                zzhky[] zzhkyVarArr = new zzhky[8];
                zzhkyVarArr[0] = new zzhky(zzhlbVar);
                zzhkz zzhkzVar = new zzhkz(new zzhla(), new long[10]);
                zzi(zzhkzVar, zzhlbVar.zza);
                zzhlb zzhlbVar2 = new zzhlb(zzhkzVar);
                for (int i11 = 1; i11 < 8; i11++) {
                    zzg(zzhkzVar, zzhlbVar2, zzhkyVarArr[i11 - 1]);
                    zzhkyVarArr[i11] = new zzhky(new zzhlb(zzhkzVar));
                }
                byte[] bArrZzl = zzl(bArrDigest);
                byte[] bArrZzl2 = zzl(bArrCopyOfRange);
                zzhkz zzhkzVar2 = new zzhkz(zzc);
                zzhlb zzhlbVar3 = new zzhlb();
                int i12 = b;
                while (i12 >= 0 && bArrZzl[i12] == 0 && bArrZzl2[i12] == 0) {
                    i12--;
                }
                while (i12 >= 0) {
                    zzi(zzhkzVar2, new zzhla(zzhkzVar2));
                    byte b2 = bArrZzl[i12];
                    if (b2 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhkyVarArr[bArrZzl[i12] / 2]);
                    } else if (b2 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhkyVarArr[(-bArrZzl[i12]) / 2]);
                    }
                    byte b3 = bArrZzl2[i12];
                    if (b3 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhle.zze[bArrZzl2[i12] / 2]);
                    } else if (b3 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhle.zze[(-bArrZzl2[i12]) / 2]);
                    }
                    i12--;
                }
                byte[] bArrZzb = new zzhla(zzhkzVar2).zzb();
                for (int i13 = 0; i13 < 32; i13++) {
                    if (bArrZzb[i13] != bArr2[i13]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void zzd() {
        if (zzhle.zza != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Could not initialize Ed25519.");
    }

    public static /* synthetic */ boolean zze(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhlj.zzd(jArr2);
        byte[] bArrZzh = zzhlj.zzh(jArr2);
        for (int i = 0; i < 32; i++) {
            if (bArrZzh[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int zzf(long[] jArr) {
        return zzhlj.zzh(jArr)[0] & 1;
    }

    private static void zzg(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zzb);
        long[] jArr6 = zzhkxVar.zza;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zza(jArr7, jArr, jArr8);
        zzhlj.zzb(jArr8, jArr, jArr8);
    }

    private static void zzh(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zza);
        long[] jArr6 = zzhkxVar.zzb;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zzb(jArr7, jArr, jArr8);
        zzhlj.zza(jArr8, jArr, jArr8);
    }

    private static void zzi(zzhkz zzhkzVar, zzhla zzhlaVar) {
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = zzhlaVar2.zza;
        long[] jArr2 = zzhlaVar.zza;
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr, jArr2);
        long[] jArr4 = zzhlaVar2.zzc;
        long[] jArr5 = zzhlaVar.zzb;
        zzhlj.zzf(jArr4, jArr5);
        long[] jArr6 = zzhkzVar.zzb;
        zzhlj.zzf(jArr6, zzhlaVar.zzc);
        zzhlj.zza(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhlaVar2.zzb;
        zzhlj.zza(jArr7, jArr2, jArr5);
        zzhlj.zzf(jArr3, jArr7);
        zzhlj.zza(jArr7, jArr4, jArr);
        zzhlj.zzb(jArr4, jArr4, jArr);
        zzhlj.zzb(jArr, jArr3, jArr7);
        zzhlj.zzb(jArr6, jArr6, jArr4);
    }

    private static int zzj(int i, int i2) {
        int i3 = (~(i ^ i2)) & PHIpAddressSearchManager.END_IP_SCAN;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return (i5 & (i5 + i5)) >> 7;
    }

    private static void zzk(zzhkx zzhkxVar, int i, byte b) {
        zzhkx[][] zzhkxVarArr = zzhle.zzd;
        int i2 = (b & 255) >> 7;
        int i3 = (-i2) & b;
        int i4 = b - (i3 + i3);
        zzhkxVar.zzb(zzhkxVarArr[i][0], zzj(i4, 1));
        zzhkxVar.zzb(zzhkxVarArr[i][1], zzj(i4, 2));
        zzhkxVar.zzb(zzhkxVarArr[i][2], zzj(i4, 3));
        zzhkxVar.zzb(zzhkxVarArr[i][3], zzj(i4, 4));
        zzhkxVar.zzb(zzhkxVarArr[i][4], zzj(i4, 5));
        zzhkxVar.zzb(zzhkxVarArr[i][5], zzj(i4, 6));
        zzhkxVar.zzb(zzhkxVarArr[i][6], zzj(i4, 7));
        zzhkxVar.zzb(zzhkxVarArr[i][7], zzj(i4, 8));
        long[] jArr = zzhkxVar.zzc;
        long[] jArr2 = zzhkxVar.zza;
        long[] jArrCopyOf = Arrays.copyOf(zzhkxVar.zzb, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(jArr, 10);
        zzm(jArrCopyOf3, jArrCopyOf3);
        zzhkxVar.zzb(new zzhkx(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i2);
    }

    private static byte[] zzl(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        int i5 = b << i4;
                        int i6 = b2 + i5;
                        if (i6 <= 15) {
                            bArr2[i3] = (byte) i6;
                            bArr2[i] = 0;
                        } else {
                            int i7 = b2 - i5;
                            if (i7 >= -15) {
                                bArr2[i3] = (byte) i7;
                                while (true) {
                                    if (i >= 256) {
                                        break;
                                    }
                                    if (bArr2[i] == 0) {
                                        bArr2[i] = 1;
                                        break;
                                    }
                                    bArr2[i] = 0;
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void zzm(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    private static long zzn(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long zzo(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | zzn(bArr, i);
    }
}
