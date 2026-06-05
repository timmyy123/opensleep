package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgp {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }

    public static boolean zzb(zzv zzvVar, byte[] bArr, int i) {
        String strZzq = zzq(zzvVar);
        if (strZzq == null) {
            return false;
        }
        int iHashCode = strZzq.hashCode();
        if (iHashCode != -1662541442) {
            return iHashCode != 1331836730 ? iHashCode == 1331856911 && strZzq.equals("video/vvc") && ((bArr[5] & 248) >> 3) == 23 : strZzq.equals("video/avc") && (bArr[4] & 31) == 6;
        }
        if (strZzq.equals("video/hevc") && ((bArr[4] & 126) >> 1) == 39) {
            return true;
        }
        return false;
    }

    public static int zzc(zzv zzvVar) {
        String strZzq = zzq(zzvVar);
        if (Objects.equals(strZzq, "video/avc")) {
            return 1;
        }
        return (Objects.equals(strZzq, "video/hevc") || Objects.equals(strZzq, "video/vvc")) ? 2 : 0;
    }

    public static boolean zzd(byte[] bArr, int i, int i2, zzv zzvVar) {
        String str = zzvVar.zzp;
        if (Objects.equals(str, "video/avc")) {
            byte b = bArr[4];
            if (((b & 96) >> 5) != 0) {
                return true;
            }
            int i3 = b & 31;
            return (i3 == 1 || i3 == 9 || i3 == 14) ? false : true;
        }
        if (Objects.equals(str, "video/hevc")) {
            zzgd zzgdVarZzl = zzl(new zzgw(bArr, 4, i2 + 4));
            int i4 = zzgdVarZzl.zza;
            if (i4 == 35) {
                return false;
            }
            return (i4 <= 14 && i4 % 2 == 0 && zzgdVarZzl.zzc == zzvVar.zzG + (-1)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0235 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016c A[PHI: r2
      0x016c: PHI (r2v6 int) = (r2v4 int), (r2v3 int) binds: [B:87:0x0171, B:83:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016f A[PHI: r2
      0x016f: PHI (r2v4 int) = (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v7 int) binds: [B:74:0x0156, B:76:0x015a, B:78:0x015e, B:80:0x0162, B:82:0x0166, B:84:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgo zze(byte[] bArr, int i, int i2) {
        int iZzg;
        int i3;
        boolean zZze;
        int i4;
        int iZzg2;
        int i5;
        int i6;
        int iZzg3;
        boolean z;
        boolean zZze2;
        int iZzg4;
        int i7;
        float f;
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzc;
        boolean zZze3;
        boolean zZze4;
        int i12;
        zzgw zzgwVar = new zzgw(bArr, i, i2);
        int iZzf = zzgwVar.zzf(8);
        int iZzf2 = zzgwVar.zzf(8);
        int iZzf3 = zzgwVar.zzf(8);
        int iZzg5 = zzgwVar.zzg();
        if (iZzf == 100 || iZzf == 110 || iZzf == 122 || iZzf == 244 || iZzf == 44 || iZzf == 83 || iZzf == 86 || iZzf == 118 || iZzf == 128) {
            iZzg = zzgwVar.zzg();
            if (iZzg != 3) {
                zZze = zzgwVar.zze();
                i3 = 3;
            } else {
                i3 = iZzg;
                zZze = false;
            }
            i4 = 16;
            int iZzg6 = zzgwVar.zzg();
            iZzg2 = zzgwVar.zzg();
            zzgwVar.zza();
            if (zzgwVar.zze()) {
                int i13 = i3 != 3 ? 8 : 12;
                int i14 = 0;
                while (i14 < i13) {
                    if (zzgwVar.zze()) {
                        int i15 = i14 < 6 ? 16 : 64;
                        int iZzh = 8;
                        int i16 = 8;
                        for (int i17 = 0; i17 < i15; i17++) {
                            if (iZzh != 0) {
                                iZzh = ((zzgwVar.zzh() + i16) + 256) % 256;
                            }
                            if (iZzh != 0) {
                                i16 = iZzh;
                            }
                        }
                    }
                    i14++;
                }
            }
            i5 = iZzg6;
        } else if (iZzf == 138) {
            iZzf = 138;
            iZzg = zzgwVar.zzg();
            if (iZzg != 3) {
            }
            i4 = 16;
            int iZzg62 = zzgwVar.zzg();
            iZzg2 = zzgwVar.zzg();
            zzgwVar.zza();
            if (zzgwVar.zze()) {
            }
            i5 = iZzg62;
        } else {
            iZzg = 1;
            i4 = 16;
            i5 = 0;
            zZze = false;
            iZzg2 = 0;
        }
        int iZzg7 = zzgwVar.zzg() + 4;
        int iZzg8 = zzgwVar.zzg();
        if (iZzg8 == 0) {
            iZzg3 = zzgwVar.zzg() + 4;
            i6 = 244;
        } else {
            if (iZzg8 == 1) {
                boolean zZze5 = zzgwVar.zze();
                zzgwVar.zzh();
                zzgwVar.zzh();
                long jZzg = zzgwVar.zzg();
                for (int i18 = 0; i18 < jZzg; i18++) {
                    zzgwVar.zzg();
                }
                z = zZze5;
                iZzg8 = 1;
                i6 = 244;
                iZzg3 = 0;
                int iZzg9 = zzgwVar.zzg();
                zzgwVar.zza();
                int iZzg10 = zzgwVar.zzg() + 1;
                int iZzg11 = zzgwVar.zzg() + 1;
                zZze2 = zzgwVar.zze();
                int i19 = 2 - (zZze2 ? 1 : 0);
                if (!zZze2) {
                    zzgwVar.zza();
                }
                zzgwVar.zza();
                int i20 = iZzg10 * 16;
                int i21 = iZzg11 * i19 * 16;
                if (zzgwVar.zze()) {
                    int iZzg12 = zzgwVar.zzg();
                    int iZzg13 = zzgwVar.zzg();
                    int iZzg14 = zzgwVar.zzg();
                    int iZzg15 = zzgwVar.zzg();
                    if (iZzg == 0) {
                        i12 = 1;
                    } else {
                        i12 = iZzg == 3 ? 1 : 2;
                        i19 *= iZzg == 1 ? 2 : 1;
                    }
                    i20 -= (iZzg12 + iZzg13) * i12;
                    i21 -= (iZzg14 + iZzg15) * i19;
                }
                if (iZzf != 44 || iZzf == 86 || iZzf == 100 || iZzf == 110 || iZzf == 122) {
                    iZzg4 = (iZzf2 & 16) != 0 ? 0 : i4;
                } else if (iZzf == i6) {
                    iZzf = i6;
                    if ((iZzf2 & 16) != 0) {
                    }
                }
                float f2 = 1.0f;
                int i22 = -1;
                if (zzgwVar.zze()) {
                    i7 = iZzg4;
                    f = 1.0f;
                    i8 = -1;
                    i9 = -1;
                } else if (zzgwVar.zze()) {
                    int iZzf4 = zzgwVar.zzf(8);
                    if (iZzf4 == 255) {
                        int i23 = i4;
                        int iZzf5 = zzgwVar.zzf(i23);
                        int iZzf6 = zzgwVar.zzf(i23);
                        if (iZzf5 != 0 && iZzf6 != 0) {
                            f2 = iZzf5 / iZzf6;
                        }
                    } else if (iZzf4 < 17) {
                        f2 = zzb[iZzf4];
                    } else {
                        i10 = iZzg7;
                        zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzf4).length() + 35), "Unexpected aspect_ratio_idc value: ", iZzf4, "NalUnitUtil");
                        if (zzgwVar.zze()) {
                        }
                        if (zzgwVar.zze()) {
                        }
                        if (zzgwVar.zze()) {
                        }
                        if (zzgwVar.zze()) {
                        }
                        zZze3 = zzgwVar.zze();
                        if (zZze3) {
                        }
                        zZze4 = zzgwVar.zze();
                        if (zZze4) {
                        }
                        if (zZze3) {
                            zzgwVar.zza();
                            zzgwVar.zza();
                            if (zzgwVar.zze()) {
                            }
                            int i24 = i22;
                            i22 = i11;
                            iZzg7 = i10;
                            i8 = i24;
                            i9 = iZzc;
                            i7 = iZzg4;
                            f = f2;
                        }
                    }
                    i10 = iZzg7;
                    if (zzgwVar.zze()) {
                    }
                    if (zzgwVar.zze()) {
                    }
                    if (zzgwVar.zze()) {
                    }
                    if (zzgwVar.zze()) {
                    }
                    zZze3 = zzgwVar.zze();
                    if (zZze3) {
                    }
                    zZze4 = zzgwVar.zze();
                    if (zZze4) {
                    }
                    if (zZze3) {
                    }
                } else {
                    i10 = iZzg7;
                    if (zzgwVar.zze()) {
                        zzgwVar.zza();
                    }
                    if (zzgwVar.zze()) {
                        zzgwVar.zzb(3);
                        int i25 = true != zzgwVar.zze() ? 2 : 1;
                        if (zzgwVar.zze()) {
                            int iZzf7 = zzgwVar.zzf(8);
                            int iZzf8 = zzgwVar.zzf(8);
                            zzgwVar.zzb(8);
                            int iZzb = zzi.zzb(iZzf7);
                            iZzc = zzi.zzc(iZzf8);
                            i11 = iZzb;
                        } else {
                            i11 = -1;
                            iZzc = -1;
                        }
                        i22 = i25;
                    } else {
                        i11 = -1;
                        iZzc = -1;
                    }
                    if (zzgwVar.zze()) {
                        zzgwVar.zzg();
                        zzgwVar.zzg();
                    }
                    if (zzgwVar.zze()) {
                        zzgwVar.zzb(65);
                    }
                    zZze3 = zzgwVar.zze();
                    if (zZze3) {
                        zzp(zzgwVar);
                    }
                    zZze4 = zzgwVar.zze();
                    if (zZze4) {
                        zzp(zzgwVar);
                    }
                    if (zZze3 || zZze4) {
                        zzgwVar.zza();
                    }
                    zzgwVar.zza();
                    if (zzgwVar.zze()) {
                        zzgwVar.zza();
                        zzgwVar.zzg();
                        zzgwVar.zzg();
                        zzgwVar.zzg();
                        zzgwVar.zzg();
                        iZzg4 = zzgwVar.zzg();
                        zzgwVar.zzg();
                    }
                    int i242 = i22;
                    i22 = i11;
                    iZzg7 = i10;
                    i8 = i242;
                    i9 = iZzc;
                    i7 = iZzg4;
                    f = f2;
                }
                return new zzgo(iZzf, iZzf2, iZzf3, iZzg5, iZzg9, i20, i21, f, i5, iZzg2, zZze, zZze2, iZzg7, iZzg8, iZzg3, z, i22, i8, i9, i7);
            }
            i6 = 244;
            iZzg3 = 0;
        }
        z = false;
        int iZzg92 = zzgwVar.zzg();
        zzgwVar.zza();
        int iZzg102 = zzgwVar.zzg() + 1;
        int iZzg112 = zzgwVar.zzg() + 1;
        zZze2 = zzgwVar.zze();
        int i192 = 2 - (zZze2 ? 1 : 0);
        if (!zZze2) {
        }
        zzgwVar.zza();
        int i202 = iZzg102 * 16;
        int i212 = iZzg112 * i192 * 16;
        if (zzgwVar.zze()) {
        }
        if (iZzf != 44) {
            if ((iZzf2 & 16) != 0) {
            }
        }
        float f22 = 1.0f;
        int i222 = -1;
        if (zzgwVar.zze()) {
        }
        return new zzgo(iZzf, iZzf2, iZzf3, iZzg5, iZzg92, i202, i212, f, i5, iZzg2, zZze, zZze2, iZzg7, iZzg8, iZzg3, z, i222, i8, i9, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x05f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgm zzf(byte[] bArr, int i, int i2) {
        int i3;
        int[] iArr;
        zzgl zzglVar;
        boolean z;
        int iZzf;
        zzgd zzgdVar;
        int iZzf2;
        int iZzf3;
        int iZzf4;
        zzgwm zzgwmVar;
        boolean[][] zArr;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean[][] zArr2;
        int[] iArr2;
        boolean[][] zArr3;
        int[] iArr3;
        int i8;
        int i9;
        int i10;
        boolean zZze;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iZzg;
        int i16;
        int i17;
        boolean z2;
        boolean z3;
        zzgw zzgwVar = new zzgw(bArr, i, i2);
        zzgd zzgdVarZzl = zzl(zzgwVar);
        zzgwVar.zzb(4);
        boolean zZze2 = zzgwVar.zze();
        boolean zZze3 = zzgwVar.zze();
        int iZzf5 = zzgwVar.zzf(6);
        int i18 = iZzf5 + 1;
        int iZzf6 = zzgwVar.zzf(3);
        zzgwVar.zzb(17);
        zzge zzgeVarZzm = zzm(zzgwVar, true, iZzf6, null);
        for (int i19 = true != zzgwVar.zze() ? iZzf6 : 0; i19 <= iZzf6; i19++) {
            zzgwVar.zzg();
            zzgwVar.zzg();
            zzgwVar.zzg();
        }
        int iZzf7 = zzgwVar.zzf(6);
        int iZzg2 = zzgwVar.zzg() + 1;
        int i20 = 6;
        zzgf zzgfVar = new zzgf(zzgwm.zzj(zzgeVarZzm), new int[1]);
        boolean z4 = i18 >= 2 && iZzg2 >= 2;
        boolean z5 = zZze2 && zZze3;
        int i21 = 1;
        int i22 = iZzf7 + 1;
        if (!z4 || !z5 || i22 < i18) {
            return new zzgm(zzgdVarZzl, null, zzgfVar, null, null);
        }
        Class cls = Integer.TYPE;
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) cls, iZzg2, i22);
        int[] iArr5 = new int[iZzg2];
        int[] iArr6 = new int[iZzg2];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i23 = 1; i23 < iZzg2; i23++) {
            int i24 = 0;
            for (int i25 = 0; i25 <= iZzf7; i25++) {
                if (zzgwVar.zze()) {
                    iArr4[i23][i24] = i25;
                    iArr6[i23] = i25;
                    i24++;
                }
                iArr5[i23] = i24;
            }
        }
        if (zzgwVar.zze()) {
            zzgwVar.zzb(64);
            if (zzgwVar.zze()) {
                zzgwVar.zzg();
            }
            int iZzg3 = zzgwVar.zzg();
            int i26 = 0;
            while (i26 < iZzg3) {
                zzgwVar.zzg();
                if (i26 == 0 || zzgwVar.zze()) {
                    boolean zZze4 = zzgwVar.zze();
                    boolean zZze5 = zzgwVar.zze();
                    if (zZze4 || zZze5) {
                        zZze = zzgwVar.zze();
                        i11 = iZzg3;
                        if (zZze) {
                            zzgwVar.zzb(19);
                        }
                        zzgwVar.zzb(8);
                        if (zZze) {
                            zzgwVar.zzb(4);
                        }
                        zzgwVar.zzb(15);
                        i13 = zZze4;
                        i12 = zZze5;
                        i14 = 0;
                        while (i14 <= iZzf6) {
                            if (zzgwVar.zze() || zzgwVar.zze()) {
                                zzgwVar.zzg();
                            } else {
                                if (zzgwVar.zze()) {
                                    i15 = i14;
                                    iZzg = 0;
                                }
                                zzgd zzgdVar2 = zzgdVarZzl;
                                i16 = i13 + i12;
                                int[][] iArr7 = iArr4;
                                i17 = 0;
                                while (i17 < i16) {
                                    int i27 = i16;
                                    for (int i28 = 0; i28 <= iZzg; i28++) {
                                        zzgwVar.zzg();
                                        zzgwVar.zzg();
                                        if (zZze) {
                                            zzgwVar.zzg();
                                            zzgwVar.zzg();
                                        }
                                        zzgwVar.zza();
                                    }
                                    i17++;
                                    i16 = i27;
                                }
                                i14 = i15 + 1;
                                zzgdVarZzl = zzgdVar2;
                                iArr4 = iArr7;
                            }
                            i15 = i14;
                            iZzg = zzgwVar.zzg();
                            zzgd zzgdVar22 = zzgdVarZzl;
                            i16 = i13 + i12;
                            int[][] iArr72 = iArr4;
                            i17 = 0;
                            while (i17 < i16) {
                            }
                            i14 = i15 + 1;
                            zzgdVarZzl = zzgdVar22;
                            iArr4 = iArr72;
                        }
                        i26++;
                        iZzg3 = i11;
                    } else {
                        i11 = iZzg3;
                        z3 = zZze4;
                        z2 = zZze5;
                    }
                } else {
                    i11 = iZzg3;
                    z3 = false;
                    z2 = false;
                }
                zZze = false;
                i13 = z3;
                i12 = z2;
                i14 = 0;
                while (i14 <= iZzf6) {
                }
                i26++;
                iZzg3 = i11;
            }
        }
        zzgd zzgdVar3 = zzgdVarZzl;
        int[][] iArr8 = iArr4;
        if (!zzgwVar.zze()) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        zzgwVar.zzc();
        zzge zzgeVarZzm2 = zzm(zzgwVar, false, iZzf6, zzgeVarZzm);
        boolean zZze6 = zzgwVar.zze();
        boolean[] zArr4 = new boolean[16];
        int i29 = 0;
        for (int i30 = 0; i30 < 16; i30++) {
            boolean zZze7 = zzgwVar.zze();
            zArr4[i30] = zZze7;
            if (zZze7) {
                i29++;
            }
        }
        if (i29 == 0 || !zArr4[1]) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        int i31 = i29 + 1;
        int[] iArr9 = new int[i29];
        for (int i32 = 0; i32 < i29 - (zZze6 ? 1 : 0); i32++) {
            iArr9[i32] = zzgwVar.zzf(3);
        }
        int[] iArr10 = new int[i31];
        if (zZze6) {
            for (int i33 = 1; i33 < i29; i33++) {
                for (int i34 = 0; i34 < i33; i34++) {
                    iArr10[i33] = iArr9[i34] + 1 + iArr10[i33];
                }
            }
            iArr10[i29] = 6;
        }
        int[][] iArr11 = (int[][]) Array.newInstance((Class<?>) cls, i18, i29);
        int[] iArr12 = new int[i18];
        iArr12[0] = 0;
        boolean zZze8 = zzgwVar.zze();
        int i35 = 1;
        while (i35 < i18) {
            if (zZze8) {
                iArr12[i35] = zzgwVar.zzf(i20);
            } else {
                iArr12[i35] = i35;
            }
            if (zZze6) {
                i10 = i35;
                for (int i36 = 0; i36 < i29; i36++) {
                    iArr11[i10][i36] = (iArr12[i10] & ((1 << iArr10[r31]) - 1)) >> iArr10[i36];
                }
            } else {
                int i37 = 0;
                while (i37 < i29) {
                    iArr11[i35][i37] = zzgwVar.zzf(iArr9[i37] + 1);
                    i37++;
                    i35 = i35;
                }
                i10 = i35;
            }
            i35 = i10 + 1;
            i20 = 6;
        }
        int[] iArr13 = new int[i22];
        int i38 = 1;
        int i39 = 0;
        while (i39 < i18) {
            iArr13[iArr12[i39]] = -1;
            int[] iArr14 = iArr13;
            int i40 = 0;
            int i41 = 0;
            while (i40 < 16) {
                if (zArr4[i40]) {
                    i9 = i21;
                    if (i40 == i9) {
                        iArr14[iArr12[i39]] = iArr11[i39][i41];
                        i40 = i9;
                    }
                    i41++;
                } else {
                    i9 = i21;
                }
                i40 += i9;
                i21 = i9;
            }
            if (i39 > 0) {
                int i42 = 0;
                while (true) {
                    if (i42 >= i39) {
                        i38++;
                        break;
                    }
                    if (iArr14[iArr12[i39]] == iArr14[iArr12[i42]]) {
                        break;
                    }
                    i42++;
                }
            }
            i39++;
            iArr13 = iArr14;
            i21 = 1;
        }
        int[] iArr15 = iArr13;
        int iZzf8 = zzgwVar.zzf(4);
        if (i38 < 2 || iZzf8 == 0) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        int[] iArr16 = new int[i38];
        for (int i43 = 0; i43 < i38; i43++) {
            iArr16[i43] = zzgwVar.zzf(iZzf8);
        }
        int[] iArr17 = new int[i22];
        for (int i44 = 0; i44 < i18; i44++) {
            iArr17[Math.min(iArr12[i44], iZzf7)] = i44;
        }
        zzgwj zzgwjVar = new zzgwj();
        int i45 = 0;
        while (i45 <= iZzf7) {
            int[] iArr18 = iArr16;
            int i46 = i38;
            int iMin = Math.min(iArr15[i45], i46 - 1);
            int[] iArr19 = iArr17;
            zzgwjVar.zzf(new zzgc(iArr19[i45], iMin >= 0 ? iArr18[iMin] : -1));
            i45++;
            i38 = i46;
            iArr16 = iArr18;
            iArr17 = iArr19;
        }
        zzgwm zzgwmVarZzi = zzgwjVar.zzi();
        if (((zzgc) zzgwmVarZzi.get(0)).zzb == -1) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        int i47 = 1;
        while (true) {
            zzgd zzgdVar4 = zzgdVar3;
            if (i47 > iZzf7) {
                zzgdVar3 = zzgdVar4;
                i3 = -1;
                i47 = -1;
                break;
            }
            zzgdVar3 = zzgdVar4;
            i3 = -1;
            if (((zzgc) zzgwmVarZzi.get(i47)).zzb != -1) {
                break;
            }
            i47++;
        }
        if (i47 == i3) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        Class cls2 = Boolean.TYPE;
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) cls2, i18, i18);
        boolean[][] zArr6 = (boolean[][]) Array.newInstance((Class<?>) cls2, i18, i18);
        int i48 = 1;
        while (i48 < i18) {
            boolean[][] zArr7 = zArr6;
            for (int i49 = 0; i49 < i48; i49++) {
                boolean[] zArr8 = zArr5[i48];
                boolean[] zArr9 = zArr7[i48];
                boolean zZze9 = zzgwVar.zze();
                zArr9[i49] = zZze9;
                zArr8[i49] = zZze9;
            }
            i48++;
            zArr6 = zArr7;
        }
        boolean[][] zArr10 = zArr6;
        for (int i50 = 1; i50 < i18; i50++) {
            int i51 = 0;
            while (i51 < iZzf5) {
                int i52 = i51;
                int i53 = 0;
                while (true) {
                    if (i53 < i50) {
                        boolean[] zArr11 = zArr10[i50];
                        if (zArr11[i53] && zArr10[i53][i52]) {
                            zArr11[i52] = true;
                            break;
                        }
                        i53++;
                    }
                }
                i51 = i52 + 1;
            }
        }
        int[] iArr20 = new int[i22];
        int i54 = 0;
        while (i54 < i18) {
            int[] iArr21 = iArr20;
            int i55 = 0;
            for (int i56 = 0; i56 < i54; i56++) {
                i55 += zArr5[i54][i56] ? 1 : 0;
            }
            iArr21[iArr12[i54]] = i55;
            i54++;
            iArr20 = iArr21;
        }
        int[] iArr22 = iArr20;
        int i57 = 0;
        for (int i58 = 0; i58 < i18; i58++) {
            if (iArr22[iArr12[i58]] == 0) {
                i57++;
            }
        }
        if (i57 > 1) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        int[] iArr23 = new int[i18];
        int[] iArr24 = new int[iZzg2];
        if (zzgwVar.zze()) {
            iArr = iArr24;
            int i59 = 0;
            while (i59 < i18) {
                int i60 = i59;
                iArr23[i60] = zzgwVar.zzf(3);
                i59 = i60 + 1;
            }
        } else {
            iArr = iArr24;
            Arrays.fill(iArr23, 0, i18, iZzf6);
        }
        int i61 = 0;
        while (i61 < iZzg2) {
            int[] iArr25 = iArr23;
            int i62 = i61;
            int[] iArr26 = iArr12;
            int iMax = 0;
            for (int i63 = 0; i63 < iArr5[i62]; i63++) {
                iMax = Math.max(iMax, iArr25[((zzgc) zzgwmVarZzi.get(iArr8[i62][i63])).zza]);
            }
            iArr[i62] = iMax + 1;
            i61 = i62 + 1;
            iArr23 = iArr25;
            iArr12 = iArr26;
        }
        int[] iArr27 = iArr12;
        if (zzgwVar.zze()) {
            int i64 = 0;
            while (i64 < iZzf5) {
                int i65 = i64 + 1;
                int i66 = i65;
                while (i66 < i18) {
                    if (zArr5[i66][i64]) {
                        i8 = i64;
                        zzgwVar.zzb(3);
                    } else {
                        i8 = i64;
                    }
                    i66++;
                    i64 = i8;
                }
                i64 = i65;
            }
        }
        zzgwVar.zza();
        int iZzg4 = zzgwVar.zzg() + 1;
        zzgwj zzgwjVar2 = new zzgwj();
        zzgwjVar2.zzf(zzgeVarZzm);
        if (iZzg4 > 1) {
            zzgwjVar2.zzf(zzgeVarZzm2);
            for (int i67 = 2; i67 < iZzg4; i67++) {
                zzgeVarZzm2 = zzm(zzgwVar, zzgwVar.zze(), iZzf6, zzgeVarZzm2);
                zzgwjVar2.zzf(zzgeVarZzm2);
            }
        }
        zzgwm zzgwmVarZzi2 = zzgwjVar2.zzi();
        int iZzg5 = zzgwVar.zzg() + iZzg2;
        if (iZzg5 > iZzg2) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        int iZzf9 = zzgwVar.zzf(2);
        boolean[][] zArr12 = (boolean[][]) Array.newInstance((Class<?>) cls2, iZzg5, i22);
        int[] iArr28 = new int[iZzg5];
        int i68 = 0;
        int[] iArr29 = new int[iZzg5];
        int i69 = 0;
        while (i69 < iZzg2) {
            iArr28[i69] = i68;
            int i70 = i69;
            int i71 = iArr6[i70];
            iArr29[i70] = i71;
            if (iZzf9 == 0) {
                iArr2 = iArr6;
                zArr3 = zArr12;
                iArr3 = iArr28;
                Arrays.fill(zArr12[i70], i68, iArr5[i70], true);
                iArr3[i70] = iArr5[i70];
            } else {
                iArr2 = iArr6;
                zArr3 = zArr12;
                iArr3 = iArr28;
                if (iZzf9 == 1) {
                    for (int i72 = 0; i72 < iArr5[i70]; i72++) {
                        zArr3[i70][i72] = iArr8[i70][i72] == i71;
                    }
                    iArr3[i70] = 1;
                } else {
                    i68 = 0;
                    zArr3[0][0] = true;
                    iArr3[0] = 1;
                    i69 = i70 + 1;
                    iArr6 = iArr2;
                    zArr12 = zArr3;
                    iArr28 = iArr3;
                }
            }
            i68 = 0;
            i69 = i70 + 1;
            iArr6 = iArr2;
            zArr12 = zArr3;
            iArr28 = iArr3;
        }
        boolean[][] zArr13 = zArr12;
        int[] iArr30 = iArr28;
        int[] iArr31 = new int[i22];
        int i73 = 2;
        int[] iArr32 = new int[2];
        iArr32[1] = i22;
        iArr32[i68] = iZzg5;
        boolean[][] zArr14 = (boolean[][]) Array.newInstance((Class<?>) cls2, iArr32);
        int i74 = 1;
        int i75 = 0;
        while (i74 < iZzg5) {
            if (iZzf9 == i73) {
                for (int i76 = 0; i76 < iArr5[i74]; i76++) {
                    zArr13[i74][i76] = zzgwVar.zze();
                    int i77 = iArr30[i74];
                    boolean z6 = zArr13[i74][i76];
                    iArr30[i74] = i77 + (z6 ? 1 : 0);
                    if (z6) {
                        iArr29[i74] = iArr8[i74][i76];
                    }
                }
            }
            if (i75 == 0) {
                i5 = 0;
                if (iArr8[i74][0] == 0 && zArr13[i74][0]) {
                    i75 = 0;
                    for (int i78 = 1; i78 < iArr5[i74]; i78++) {
                        if (iArr8[i74][i78] == i47 && zArr13[i74][i47]) {
                            i75 = i74;
                        }
                    }
                } else {
                    i75 = 0;
                }
            } else {
                i5 = 0;
            }
            int i79 = i5;
            while (i79 < iArr5[i74]) {
                if (iZzg4 > 1) {
                    zArr14[i74][i79] = zArr13[i74][i79];
                    zArr2 = zArr5;
                    i6 = iZzg4;
                    int iZzc = zzgzw.zzc(iZzg4, RoundingMode.CEILING);
                    if (zArr14[i74][i79]) {
                        i7 = iZzf9;
                        if (zArr14[i74][i79]) {
                        }
                    } else {
                        int i80 = ((zzgc) zzgwmVarZzi.get(iArr8[i74][i79])).zza;
                        int i81 = i5;
                        while (i81 < i79) {
                            i7 = iZzf9;
                            if (zArr10[i80][((zzgc) zzgwmVarZzi.get(iArr8[i74][i81])).zza]) {
                                zArr14[i74][i79] = true;
                                break;
                            }
                            i81++;
                            iZzf9 = i7;
                        }
                        i7 = iZzf9;
                        if (zArr14[i74][i79]) {
                            if (i75 <= 0 || i74 != i75) {
                                zzgwVar.zzb(iZzc);
                            } else {
                                iArr31[i79] = zzgwVar.zzf(iZzc);
                            }
                        }
                    }
                } else {
                    i6 = iZzg4;
                    i7 = iZzf9;
                    zArr2 = zArr5;
                }
                i79++;
                zArr5 = zArr2;
                iZzg4 = i6;
                iZzf9 = i7;
            }
            int i82 = iZzg4;
            int i83 = iZzf9;
            boolean[][] zArr15 = zArr5;
            if (iArr30[i74] == 1 && iArr22[iArr29[i74]] > 0) {
                zzgwVar.zza();
            }
            i74++;
            zArr5 = zArr15;
            iZzg4 = i82;
            iZzf9 = i83;
            i73 = 2;
        }
        boolean[][] zArr16 = zArr5;
        if (i75 == 0) {
            return new zzgm(zzgdVar3, null, zzgfVar, null, null);
        }
        zzgd zzgdVar5 = zzgdVar3;
        int iZzg6 = zzgwVar.zzg();
        int i84 = iZzg6 + 1;
        zzgwj zzgwjVarZzv = zzgwm.zzv(i84);
        int[] iArr33 = new int[i18];
        int i85 = 0;
        while (i85 < i84) {
            int iZzf10 = zzgwVar.zzf(16);
            zzgwm zzgwmVar2 = zzgwmVarZzi;
            int iZzf11 = zzgwVar.zzf(16);
            if (zzgwVar.zze()) {
                zzgdVar = zzgdVar5;
                iZzf2 = zzgwVar.zzf(2);
                if (iZzf2 == 3) {
                    zzgwVar.zza();
                }
                iZzf3 = zzgwVar.zzf(4);
                iZzf4 = zzgwVar.zzf(4);
            } else {
                zzgdVar = zzgdVar5;
                iZzf2 = 0;
                iZzf3 = 0;
                iZzf4 = 0;
            }
            if (zzgwVar.zze()) {
                int iZzg7 = zzgwVar.zzg();
                zArr = zArr14;
                int iZzg8 = zzgwVar.zzg();
                i4 = i85;
                int iZzg9 = zzgwVar.zzg();
                zzgwmVar = zzgwmVarZzi2;
                int iZzg10 = zzgwVar.zzg();
                iZzf10 = zzn(iZzf10, iZzf2, iZzg7, iZzg8);
                iZzf11 = zzo(iZzf11, iZzf2, iZzg9, iZzg10);
            } else {
                zzgwmVar = zzgwmVarZzi2;
                zArr = zArr14;
                i4 = i85;
            }
            zzgwjVarZzv.zzf(new zzgg(iZzf2, iZzf3, iZzf4, iZzf10, iZzf11));
            i85 = i4 + 1;
            zzgwmVarZzi = zzgwmVar2;
            zArr14 = zArr;
            zzgdVar5 = zzgdVar;
            zzgwmVarZzi2 = zzgwmVar;
        }
        zzgwm zzgwmVar3 = zzgwmVarZzi;
        zzgd zzgdVar6 = zzgdVar5;
        zzgwm zzgwmVar4 = zzgwmVarZzi2;
        boolean[][] zArr17 = zArr14;
        if (i84 <= 1 || !zzgwVar.zze()) {
            for (int i86 = 1; i86 < i18; i86++) {
                iArr33[i86] = Math.min(i86, iZzg6);
            }
        } else {
            int iZzc2 = zzgzw.zzc(i84, RoundingMode.CEILING);
            for (int i87 = 1; i87 < i18; i87++) {
                iArr33[i87] = zzgwVar.zzf(iZzc2);
            }
        }
        zzgh zzghVar = new zzgh(zzgwjVarZzv.zzi(), iArr33);
        zzgwVar.zzb(2);
        for (int i88 = 1; i88 < i18; i88++) {
            if (iArr22[iArr27[i88]] == 0) {
                zzgwVar.zza();
            }
        }
        for (int i89 = 1; i89 < iZzg5; i89++) {
            boolean zZze10 = zzgwVar.zze();
            int i90 = 0;
            while (i90 < iArr[i89]) {
                if ((i90 <= 0 || !zZze10) ? i90 == 0 : zzgwVar.zze()) {
                    for (int i91 = 0; i91 < iArr5[i89]; i91++) {
                        if (zArr17[i89][i91]) {
                            zzgwVar.zzg();
                        }
                    }
                    zzgwVar.zzg();
                    zzgwVar.zzg();
                }
                i90++;
            }
        }
        int iZzg11 = zzgwVar.zzg() + 2;
        if (zzgwVar.zze()) {
            zzgwVar.zzb(iZzg11);
        } else {
            for (int i92 = 1; i92 < i18; i92++) {
                for (int i93 = 0; i93 < i92; i93++) {
                    if (zArr16[i92][i93]) {
                        zzgwVar.zzb(iZzg11);
                    }
                }
            }
        }
        int iZzg12 = zzgwVar.zzg();
        for (int i94 = 1; i94 <= iZzg12; i94++) {
            zzgwVar.zzb(8);
        }
        if (zzgwVar.zze()) {
            zzgwVar.zzc();
            if (zzgwVar.zze() || zzgwVar.zze()) {
                zzgwVar.zza();
            }
            boolean zZze11 = zzgwVar.zze();
            boolean zZze12 = zzgwVar.zze();
            if (zZze11 || zZze12) {
                for (int i95 = 0; i95 < iZzg2; i95++) {
                    for (int i96 = 0; i96 < iArr[i95]; i96++) {
                        boolean zZze13 = zZze11 ? zzgwVar.zze() : false;
                        boolean zZze14 = zZze12 ? zzgwVar.zze() : false;
                        if (zZze13) {
                            zzgwVar.zzb(32);
                        }
                        if (zZze14) {
                            zzgwVar.zzb(18);
                        }
                    }
                }
            }
            boolean zZze15 = zzgwVar.zze();
            if (zZze15) {
                z = true;
                iZzf = zzgwVar.zzf(4) + 1;
            } else {
                z = true;
                iZzf = i18;
            }
            zzgwj zzgwjVarZzv2 = zzgwm.zzv(iZzf);
            int[] iArr34 = new int[i18];
            int i97 = 0;
            while (i97 < iZzf) {
                zzgwVar.zzb(3);
                int i98 = z != zzgwVar.zze() ? 2 : 1;
                int iZzb = zzi.zzb(zzgwVar.zzf(8));
                int iZzc3 = zzi.zzc(zzgwVar.zzf(8));
                zzgwVar.zzb(8);
                zzgwjVarZzv2.zzf(new zzgk(iZzb, i98, iZzc3));
                i97++;
                z = true;
            }
            if (zZze15 && iZzf > 1) {
                for (int i99 = 0; i99 < i18; i99++) {
                    iArr34[i99] = zzgwVar.zzf(4);
                }
            }
            zzglVar = new zzgl(zzgwjVarZzv2.zzi(), iArr34);
        } else {
            zzglVar = null;
        }
        return new zzgm(zzgdVar6, zzgwmVar3, new zzgf(zzgwmVar4, iArr31), zzghVar, zzglVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgj zzg(byte[] bArr, int i, int i2, zzgm zzgmVar) {
        boolean z;
        int i3;
        int i4;
        int iZzo;
        int iZzn;
        int iZzg;
        int i5;
        int i6;
        int i7;
        int i8;
        int iZzg2;
        int i9;
        int i10;
        int i11;
        int iMax;
        float f;
        zzge zzgeVar;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int iZzb;
        int iZzc;
        int i19;
        zzgl zzglVar;
        int i20;
        int i21;
        zzgd zzgdVar;
        int i22;
        int i23;
        int i24;
        zzgh zzghVar;
        zzgd zzgdVarZzl = zzl(new zzgw(bArr, i, i2));
        zzgw zzgwVar = new zzgw(bArr, i + 2, i2);
        zzgwVar.zzb(4);
        int iZzf = zzgwVar.zzf(3);
        int i25 = zzgdVarZzl.zzb;
        if (i25 == 0 || iZzf != 7) {
            z = false;
        } else {
            iZzf = 7;
            z = true;
        }
        if (zzgmVar != null) {
            zzgwm zzgwmVar = zzgmVar.zza;
            i3 = !zzgwmVar.isEmpty() ? ((zzgc) zzgwmVar.get(Math.min(i25, zzgwmVar.size() - 1))).zza : 0;
        }
        zzge zzgeVarZzm = null;
        if (!z) {
            zzgwVar.zza();
            zzgeVarZzm = zzm(zzgwVar, true, iZzf, null);
        } else if (zzgmVar != null) {
            zzgf zzgfVar = zzgmVar.zzb;
            int i26 = zzgfVar.zzb[i3];
            zzgwm zzgwmVar2 = zzgfVar.zza;
            if (zzgwmVar2.size() > i26) {
                zzgeVarZzm = (zzge) zzgwmVar2.get(i26);
            }
        }
        int iZzg3 = zzgwVar.zzg();
        if (z) {
            int iZzf2 = zzgwVar.zze() ? zzgwVar.zzf(8) : -1;
            if (zzgmVar == null || (zzghVar = zzgmVar.zzc) == null) {
                i6 = 0;
                i8 = 0;
                iZzg = 0;
                i9 = 0;
                iZzg2 = 0;
                i5 = 0;
                i7 = 0;
            } else {
                if (iZzf2 == -1) {
                    iZzf2 = zzghVar.zzb[i3];
                }
                if (iZzf2 != -1) {
                    zzgwm zzgwmVar3 = zzghVar.zza;
                    if (zzgwmVar3.size() > iZzf2) {
                        zzgg zzggVar = (zzgg) zzgwmVar3.get(iZzf2);
                        int i27 = zzggVar.zza;
                        i7 = zzggVar.zzd;
                        i5 = zzggVar.zze;
                        iZzg = zzggVar.zzb;
                        iZzg2 = zzggVar.zzc;
                        i9 = i27;
                        i6 = i5;
                        i8 = i7;
                    }
                }
            }
        } else {
            int iZzg4 = zzgwVar.zzg();
            if (iZzg4 == 3) {
                zzgwVar.zza();
                i4 = 3;
            } else {
                i4 = iZzg4;
            }
            int iZzg5 = zzgwVar.zzg();
            int iZzg6 = zzgwVar.zzg();
            if (zzgwVar.zze()) {
                int iZzg7 = zzgwVar.zzg();
                int iZzg8 = zzgwVar.zzg();
                int iZzg9 = zzgwVar.zzg();
                int iZzg10 = zzgwVar.zzg();
                iZzn = zzn(iZzg5, i4, iZzg7, iZzg8);
                iZzo = zzo(iZzg6, i4, iZzg9, iZzg10);
            } else {
                iZzo = iZzg6;
                iZzn = iZzg5;
            }
            iZzg = zzgwVar.zzg();
            i5 = iZzo;
            i6 = iZzg6;
            i7 = iZzn;
            i8 = iZzg5;
            iZzg2 = zzgwVar.zzg();
            i9 = iZzg4;
        }
        int iZzg11 = zzgwVar.zzg();
        if (z) {
            i10 = i6;
            i11 = i8;
            iMax = -1;
        } else {
            i10 = i6;
            i11 = i8;
            iMax = -1;
            for (int i28 = true != zzgwVar.zze() ? iZzf : 0; i28 <= iZzf; i28++) {
                zzgwVar.zzg();
                iMax = Math.max(zzgwVar.zzg(), iMax);
                zzgwVar.zzg();
            }
        }
        zzgwVar.zzg();
        zzgwVar.zzg();
        zzgwVar.zzg();
        zzgwVar.zzg();
        zzgwVar.zzg();
        zzgwVar.zzg();
        if (zzgwVar.zze()) {
            if (z && zzgwVar.zze()) {
                zzgwVar.zzb(6);
            } else if (zzgwVar.zze()) {
                int i29 = 4;
                int i30 = 0;
                while (i30 < i29) {
                    int i31 = i29;
                    int i32 = iMax;
                    for (int i33 = 0; i33 < 6; i33 = i24 + (i30 == 3 ? 3 : 1)) {
                        if (zzgwVar.zze()) {
                            i24 = i33;
                            int iMin = Math.min(64, 1 << ((i30 + i30) + 4));
                            if (i30 > 1) {
                                zzgwVar.zzh();
                            }
                            for (int i34 = 0; i34 < iMin; i34++) {
                                zzgwVar.zzh();
                            }
                        } else {
                            zzgwVar.zzg();
                            i24 = i33;
                        }
                    }
                    i30++;
                    iMax = i32;
                    i29 = i31;
                }
            }
        }
        int i35 = iMax;
        zzgwVar.zzb(2);
        if (zzgwVar.zze()) {
            zzgwVar.zzb(8);
            zzgwVar.zzg();
            zzgwVar.zzg();
            zzgwVar.zza();
        }
        int iZzg12 = zzgwVar.zzg();
        int i36 = 0;
        int[] iArr = new int[0];
        int i37 = iZzf;
        int[] iArrCopyOf = new int[0];
        int i38 = iZzg;
        int i39 = -1;
        int i40 = -1;
        while (i36 < iZzg12) {
            if (i36 == 0 || !zzgwVar.zze()) {
                i20 = iZzg12;
                i21 = i36;
                zzgdVar = zzgdVarZzl;
                i22 = i3;
                int iZzg13 = zzgwVar.zzg();
                int iZzg14 = zzgwVar.zzg();
                int[] iArr2 = new int[iZzg13];
                int i41 = 0;
                while (i41 < iZzg13) {
                    iArr2[i41] = (i41 > 0 ? iArr2[i41 - 1] : 0) - (zzgwVar.zzg() + 1);
                    zzgwVar.zza();
                    i41++;
                }
                int[] iArr3 = new int[iZzg14];
                int i42 = 0;
                while (i42 < iZzg14) {
                    iArr3[i42] = zzgwVar.zzg() + 1 + (i42 > 0 ? iArr3[i42 - 1] : 0);
                    zzgwVar.zza();
                    i42++;
                }
                iArr = iArr2;
                iArrCopyOf = iArr3;
                i39 = iZzg13;
                i40 = iZzg14;
            } else {
                i20 = iZzg12;
                int i43 = i39 + i40;
                boolean zZze = zzgwVar.zze();
                boolean z2 = true;
                int iZzg15 = zzgwVar.zzg() + 1;
                int i44 = 1 - ((zZze ? 1 : 0) + (zZze ? 1 : 0));
                i21 = i36;
                int i45 = i43 + 1;
                zzgdVar = zzgdVarZzl;
                boolean[] zArr = new boolean[i45];
                int i46 = 0;
                while (i46 <= i43) {
                    if (zzgwVar.zze()) {
                        zArr[i46] = z2;
                    } else {
                        zArr[i46] = zzgwVar.zze();
                    }
                    i46++;
                    z2 = true;
                }
                int i47 = i40 - 1;
                int[] iArr4 = new int[i45];
                int[] iArr5 = new int[i45];
                int i48 = 0;
                while (true) {
                    i23 = i44 * iZzg15;
                    if (i47 < 0) {
                        break;
                    }
                    int i49 = iArrCopyOf[i47] + i23;
                    if (i49 < 0 && zArr[i39 + i47]) {
                        iArr4[i48] = i49;
                        i48++;
                    }
                    i47--;
                }
                if (i23 < 0 && zArr[i43]) {
                    iArr4[i48] = i23;
                    i48++;
                }
                i22 = i3;
                int i50 = i48;
                for (int i51 = 0; i51 < i39; i51++) {
                    int i52 = iArr[i51] + i23;
                    if (i52 < 0 && zArr[i51]) {
                        iArr4[i50] = i52;
                        i50++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i50);
                int i53 = 0;
                for (int i54 = i39 - 1; i54 >= 0; i54--) {
                    int i55 = iArr[i54] + i23;
                    if (i55 > 0 && zArr[i54]) {
                        iArr5[i53] = i55;
                        i53++;
                    }
                }
                if (i23 > 0 && zArr[i43]) {
                    iArr5[i53] = i23;
                    i53++;
                }
                int i56 = i53;
                for (int i57 = 0; i57 < i40; i57++) {
                    int i58 = iArrCopyOf[i57] + i23;
                    if (i58 > 0 && zArr[i39 + i57]) {
                        iArr5[i56] = i58;
                        i56++;
                    }
                }
                iArr = iArrCopyOf2;
                iArrCopyOf = Arrays.copyOf(iArr5, i56);
                i39 = i50;
                i40 = i56;
            }
            i36 = i21 + 1;
            iZzg12 = i20;
            i3 = i22;
            zzgdVarZzl = zzgdVar;
        }
        zzgd zzgdVar2 = zzgdVarZzl;
        int i59 = i3;
        if (zzgwVar.zze()) {
            int iZzg16 = zzgwVar.zzg();
            for (int i60 = 0; i60 < iZzg16; i60++) {
                zzgwVar.zzb(iZzg11 + 5);
            }
        }
        zzgwVar.zzb(2);
        float f2 = 1.0f;
        if (zzgwVar.zze()) {
            if (zzgwVar.zze()) {
                int iZzf3 = zzgwVar.zzf(8);
                if (iZzf3 == 255) {
                    int iZzf4 = zzgwVar.zzf(16);
                    int iZzf5 = zzgwVar.zzf(16);
                    if (iZzf4 != 0 && iZzf5 != 0) {
                        f2 = iZzf4 / iZzf5;
                    }
                } else if (iZzf3 < 17) {
                    f2 = zzb[iZzf3];
                } else {
                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzf3).length() + 35), "Unexpected aspect_ratio_idc value: ", iZzf3, "NalUnitUtil");
                }
            }
            if (zzgwVar.zze()) {
                zzgwVar.zza();
            }
            if (zzgwVar.zze()) {
                zzgwVar.zzb(3);
                i19 = true != zzgwVar.zze() ? 2 : 1;
                if (zzgwVar.zze()) {
                    int iZzf6 = zzgwVar.zzf(8);
                    int iZzf7 = zzgwVar.zzf(8);
                    zzgwVar.zzb(8);
                    iZzb = zzi.zzb(iZzf6);
                    iZzc = zzi.zzc(iZzf7);
                } else {
                    iZzb = -1;
                    iZzc = -1;
                }
            } else if (zzgmVar == null || (zzglVar = zzgmVar.zzd) == null) {
                iZzb = -1;
                iZzc = -1;
                i19 = -1;
            } else {
                int i61 = zzglVar.zzb[i59];
                zzgwm zzgwmVar4 = zzglVar.zza;
                if (zzgwmVar4.size() > i61) {
                    zzgk zzgkVar = (zzgk) zzgwmVar4.get(i61);
                    int i62 = zzgkVar.zza;
                    int i63 = zzgkVar.zzb;
                    iZzc = zzgkVar.zzc;
                    iZzb = i62;
                    i19 = i63;
                }
            }
            if (zzgwVar.zze()) {
                zzgwVar.zzg();
                zzgwVar.zzg();
            }
            zzgwVar.zza();
            if (zzgwVar.zze()) {
                i5 += i5;
            }
            i16 = iZzb;
            f = f2;
            zzgeVar = zzgeVarZzm;
            i12 = iZzg3;
            i13 = i7;
            i14 = i10;
            i15 = i11;
            i18 = iZzc;
            i17 = i19;
        } else {
            f = 1.0f;
            zzgeVar = zzgeVarZzm;
            i12 = iZzg3;
            i13 = i7;
            i14 = i10;
            i15 = i11;
            i16 = -1;
            i17 = -1;
            i18 = -1;
        }
        return new zzgj(zzgdVar2, i37, zzgeVar, i9, i38, iZzg2, i12, i13, i5, i15, i14, f, i35, i16, i17, i18);
    }

    public static zzgn zzh(byte[] bArr, int i, int i2) {
        zzgw zzgwVar = new zzgw(bArr, 4, i2);
        int iZzg = zzgwVar.zzg();
        int iZzg2 = zzgwVar.zzg();
        zzgwVar.zza();
        return new zzgn(iZzg, iZzg2, zzgwVar.zze());
    }

    public static int zzi(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzgtj.zzi(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzj(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzj(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzj(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzj(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static void zzj(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static String zzk(List list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = (byte[]) list.get(i);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i2 = zzgwm.$r8$clinit;
                zzgwj zzgwjVar = new zzgwj();
                int i3 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i3 >= length2) {
                        break;
                    }
                    int iZzi = zzi(bArr, i3, length2, zArr);
                    if (iZzi != length2) {
                        zzgwjVar.zzf(Integer.valueOf(iZzi));
                    }
                    i3 = iZzi + 3;
                }
                zzgwm zzgwmVarZzi = zzgwjVar.zzi();
                for (int i4 = 0; i4 < zzgwmVarZzi.size(); i4++) {
                    if (((Integer) zzgwmVarZzi.get(i4)).intValue() + 3 < length) {
                        zzgw zzgwVar = new zzgw(bArr, ((Integer) zzgwmVarZzi.get(i4)).intValue() + 3, length);
                        zzgd zzgdVarZzl = zzl(zzgwVar);
                        if (zzgdVarZzl.zza == 33 && zzgdVarZzl.zzb == 0) {
                            zzgwVar.zzb(4);
                            int iZzf = zzgwVar.zzf(3);
                            zzgwVar.zza();
                            zzge zzgeVarZzm = zzm(zzgwVar, true, iZzf, null);
                            return zzdq.zzc(zzgeVarZzm.zza, zzgeVarZzm.zzb, zzgeVarZzm.zzc, zzgeVarZzm.zzd, zzgeVarZzm.zze, zzgeVarZzm.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    private static zzgd zzl(zzgw zzgwVar) {
        zzgwVar.zza();
        return new zzgd(zzgwVar.zzf(6), zzgwVar.zzf(6), zzgwVar.zzf(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzge zzm(zzgw zzgwVar, boolean z, int i, zzge zzgeVar) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean zZze;
        int iZzf;
        int i5;
        int[] iArr2 = new int[6];
        if (z) {
            int iZzf2 = zzgwVar.zzf(2);
            zZze = zzgwVar.zze();
            iZzf = zzgwVar.zzf(5);
            i5 = 0;
            for (int i6 = 0; i6 < 32; i6++) {
                if (zzgwVar.zze()) {
                    i5 |= 1 << i6;
                }
            }
            for (int i7 = 0; i7 < 6; i7++) {
                iArr2[i7] = zzgwVar.zzf(8);
            }
            i2 = iZzf2;
        } else {
            if (zzgeVar == null) {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
                int iZzf3 = zzgwVar.zzf(8);
                int i8 = 0;
                for (int i9 = 0; i9 < i; i9++) {
                    if (zzgwVar.zze()) {
                        i8 += 88;
                    }
                    if (zzgwVar.zze()) {
                        i8 += 8;
                    }
                }
                zzgwVar.zzb(i8);
                if (i > 0) {
                    int i10 = 8 - i;
                    zzgwVar.zzb(i10 + i10);
                }
                return new zzge(i2, z2, i3, i4, iArr, iZzf3);
            }
            int i11 = zzgeVar.zza;
            zZze = zzgeVar.zzb;
            iZzf = zzgeVar.zzc;
            i5 = zzgeVar.zzd;
            iArr2 = zzgeVar.zze;
            i2 = i11;
        }
        iArr = iArr2;
        z2 = zZze;
        i3 = iZzf;
        i4 = i5;
        int iZzf32 = zzgwVar.zzf(8);
        int i82 = 0;
        while (i9 < i) {
        }
        zzgwVar.zzb(i82);
        if (i > 0) {
        }
        return new zzge(i2, z2, i3, i4, iArr, iZzf32);
    }

    private static int zzn(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - ((i3 + i4) * i5);
    }

    private static int zzo(int i, int i2, int i3, int i4) {
        return i - ((i3 + i4) * (i2 == 1 ? 2 : 1));
    }

    private static void zzp(zzgw zzgwVar) {
        int iZzg = zzgwVar.zzg() + 1;
        zzgwVar.zzb(8);
        for (int i = 0; i < iZzg; i++) {
            zzgwVar.zzg();
            zzgwVar.zzg();
            zzgwVar.zza();
        }
        zzgwVar.zzb(20);
    }

    private static String zzq(zzv zzvVar) {
        String str;
        String str2 = zzvVar.zzp;
        if (Objects.equals(str2, "video/dolby-vision") && (str = zzvVar.zzk) != null) {
            if (str.startsWith("dva1") || str.startsWith("dvav")) {
                return "video/avc";
            }
            if (str.startsWith("dvh1") || str.startsWith("dvhe")) {
                return "video/hevc";
            }
        }
        return str2;
    }
}
