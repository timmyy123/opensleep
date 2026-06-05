package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzafx {
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(int i) {
        if (i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368) {
            return 1;
        }
        if (i == 1683496997 || i == 622876772) {
            return 2;
        }
        if (i == 1078008818 || i == -233094848) {
            return 3;
        }
        return (i == 1908687592 || i == -398277519) ? 4 : 0;
    }

    public static zzv zzb(byte[] bArr, String str, String str2, int i, String str3, zzq zzqVar) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(60);
        int i2 = zzb[zzesVarZzi.zzj(6)];
        int i3 = zzc[zzesVarZzi.zzj(4)];
        int iZzj = zzesVarZzi.zzj(5);
        int i4 = iZzj >= 29 ? -1 : (zzd[iZzj] * 1000) / 2;
        zzesVarZzi.zzh(10);
        int i5 = i2 + (zzesVarZzi.zzj(2) > 0 ? 1 : 0);
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzn("video/mp2t");
        zztVar.zzo("audio/vnd.dts");
        zztVar.zzi(i4);
        zztVar.zzG(i5);
        zztVar.zzH(i3);
        zztVar.zzs(null);
        zztVar.zze(str2);
        zztVar.zzg(i);
        return zztVar.zzO();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzc(byte[] bArr) {
        int i;
        int i2;
        byte b;
        int i3;
        int i4;
        int i5;
        byte b2;
        boolean z = false;
        byte b3 = bArr[0];
        if (b3 != -2) {
            if (b3 == -1) {
                i4 = (bArr[7] & 3) << 12;
                i5 = (bArr[6] & 255) << 4;
                b2 = bArr[9];
            } else if (b3 != 31) {
                i = (bArr[5] & 3) << 12;
                i2 = (bArr[6] & 255) << 4;
                b = bArr[7];
            } else {
                i4 = (bArr[6] & 3) << 12;
                i5 = (bArr[7] & 255) << 4;
                b2 = bArr[8];
            }
            i3 = (((b2 & 60) >> 2) | i4 | i5) + 1;
            z = true;
            return !z ? (i3 * 16) / 14 : i3;
        }
        i = (bArr[4] & 3) << 12;
        i2 = (bArr[7] & 255) << 4;
        b = bArr[6];
        i3 = (((b & 240) >> 4) | i | i2) + 1;
        if (!z) {
        }
    }

    public static zzafw zzd(byte[] bArr) throws zzat {
        int iZzj;
        int i;
        long jZzv;
        int i2;
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(40);
        int iZzj2 = zzesVarZzi.zzj(2);
        boolean zZzi = zzesVarZzi.zzi();
        int i3 = true != zZzi ? 16 : 20;
        zzesVarZzi.zzh(true != zZzi ? 8 : 12);
        int iZzj3 = zzesVarZzi.zzj(i3) + 1;
        boolean zZzi2 = zzesVarZzi.zzi();
        int iZzj4 = -1;
        int i4 = 0;
        if (zZzi2) {
            iZzj = zzesVarZzi.zzj(2);
            int iZzj5 = zzesVarZzi.zzj(3) + 1;
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(36);
            }
            int iZzj6 = zzesVarZzi.zzj(3) + 1;
            int iZzj7 = zzesVarZzi.zzj(3) + 1;
            if (iZzj6 != 1 || iZzj7 != 1) {
                throw zzat.zzc("Multiple audio presentations or assets not supported");
            }
            int i5 = iZzj2 + 1;
            int iZzj8 = zzesVarZzi.zzj(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                if (((iZzj8 >> i6) & 1) == 1) {
                    zzesVarZzi.zzh(8);
                }
            }
            int i7 = iZzj5 * 512;
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(2);
                int iZzj9 = (zzesVarZzi.zzj(2) + 1) << 2;
                int iZzj10 = zzesVarZzi.zzj(2) + 1;
                while (i4 < iZzj10) {
                    zzesVarZzi.zzh(iZzj9);
                    i4++;
                }
            }
            i4 = i7;
        } else {
            iZzj = -1;
        }
        zzesVarZzi.zzh(i3);
        zzesVarZzi.zzh(12);
        if (zZzi2) {
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(4);
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(24);
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzo(zzesVarZzi.zzj(10) + 1);
            }
            zzesVarZzi.zzh(5);
            i = zze[zzesVarZzi.zzj(4)];
            iZzj4 = zzesVarZzi.zzj(8) + 1;
        } else {
            i = -2147483647;
        }
        int i8 = i;
        if (zZzi2) {
            if (iZzj == 0) {
                i2 = 32000;
            } else if (iZzj == 1) {
                i2 = 44100;
            } else {
                if (iZzj != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj).length() + 51);
                    sb.append("Unsupported reference clock code in DTS HD header: ");
                    sb.append(iZzj);
                    throw zzat.zzb(sb.toString(), null);
                }
                i2 = 48000;
            }
            jZzv = zzfl.zzv(i4, 1000000L, i2, RoundingMode.DOWN);
        } else {
            jZzv = -9223372036854775807L;
        }
        return new zzafw("audio/vnd.dts.hd;profile=lbr", iZzj4, i8, iZzj3, jZzv, 0, null);
    }

    public static int zze(byte[] bArr) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(42);
        return zzesVarZzi.zzj(true != zzesVarZzi.zzi() ? 8 : 12) + 1;
    }

    public static zzafw zzf(byte[] bArr, AtomicInteger atomicInteger) throws zzat {
        long jZzv;
        int iZzj;
        AtomicInteger atomicInteger2;
        int i;
        int i2;
        zzes zzesVarZzi = zzi(bArr);
        int iZzj2 = zzesVarZzi.zzj(32);
        int iZzh = zzh(zzesVarZzi, zzf, true);
        int i3 = iZzh + 1;
        char c = iZzj2 == 1078008818 ? (char) 1 : (char) 0;
        if (c == 0) {
            jZzv = -9223372036854775807L;
            iZzj = -2147483647;
        } else {
            if (!zzesVarZzi.zzi()) {
                throw zzat.zzc("Only supports full channel mask-based audio presentation");
            }
            int i4 = iZzh - 1;
            if (((bArr[iZzh] & 255) | ((char) (bArr[i4] << 8))) != zzfl.zzK(bArr, 0, i4, 65535)) {
                throw zzat.zzb("CRC check failed", null);
            }
            int iZzj3 = zzesVarZzi.zzj(2);
            if (iZzj3 == 0) {
                i = 512;
            } else if (iZzj3 == 1) {
                i = 480;
            } else {
                if (iZzj3 != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 51);
                    sb.append("Unsupported base duration index in DTS UHD header: ");
                    sb.append(iZzj3);
                    throw zzat.zzb(sb.toString(), null);
                }
                i = 384;
            }
            int iZzj4 = zzesVarZzi.zzj(3) + 1;
            int iZzj5 = zzesVarZzi.zzj(2);
            if (iZzj5 == 0) {
                i2 = 32000;
            } else if (iZzj5 == 1) {
                i2 = 44100;
            } else {
                if (iZzj5 != 2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 48);
                    sb2.append("Unsupported clock rate index in DTS UHD header: ");
                    sb2.append(iZzj5);
                    throw zzat.zzb(sb2.toString(), null);
                }
                i2 = 48000;
            }
            if (zzesVarZzi.zzi()) {
                zzesVarZzi.zzh(36);
            }
            iZzj = (1 << zzesVarZzi.zzj(2)) * i2;
            jZzv = zzfl.zzv(i * iZzj4, 1000000L, i2, RoundingMode.DOWN);
        }
        int i5 = iZzj;
        long j = jZzv;
        int iZzh2 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            iZzh2 += zzh(zzesVarZzi, zzg, true);
        }
        for (int i6 = 0; i6 <= 0; i6++) {
            if (c != 0) {
                atomicInteger2 = atomicInteger;
                atomicInteger2.set(zzh(zzesVarZzi, zzh, true));
            } else {
                atomicInteger2 = atomicInteger;
            }
            iZzh2 += atomicInteger2.get() != 0 ? zzh(zzesVarZzi, zzi, true) : 0;
        }
        return new zzafw("audio/vnd.dts.uhd;profile=p2", 2, i5, i3 + iZzh2, j, 0, null);
    }

    public static int zzg(byte[] bArr) {
        zzes zzesVarZzi = zzi(bArr);
        zzesVarZzi.zzh(32);
        return zzh(zzesVarZzi, zzj, true) + 1;
    }

    private static int zzh(zzes zzesVar, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzesVar.zzi(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return zzesVar.zzj(iArr[i]) + i3;
    }

    private static zzes zzi(byte[] bArr) {
        byte b = bArr[0];
        if (b == 127 || b == 100 || b == 64 || b == 113) {
            return new zzes(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = bArrCopyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b3 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b3;
            }
        }
        int length = bArrCopyOf.length;
        zzes zzesVar = new zzes(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzes zzesVar2 = new zzes(bArrCopyOf, length);
            while (zzesVar2.zzc() >= 16) {
                zzesVar2.zzh(2);
                zzesVar.zzp(zzesVar2.zzj(14), 14);
            }
        }
        zzesVar.zzb(bArrCopyOf, bArrCopyOf.length);
        return zzesVar;
    }
}
