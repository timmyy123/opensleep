package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzamh {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzahf zza(zzafz zzafzVar) {
        return zzc(zzafzVar, true);
    }

    public static zzahf zzb(zzafz zzafzVar) {
        return zzc(zzafzVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzahf zzc(zzafz zzafzVar, boolean z) {
        zzahf zzahfVar;
        long jZzD;
        zzet zzetVar;
        int i;
        int i2;
        zzet zzetVar2;
        int i3;
        int i4;
        int[] iArr;
        long jZzo = zzafzVar.zzo();
        long j = -1;
        long j2 = 4096;
        if (jZzo != -1 && jZzo <= 4096) {
            j2 = jZzo;
        }
        zzet zzetVar3 = new zzet(64);
        int i5 = (int) j2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            zzetVar3.zza(8);
            if (!zzafzVar.zzh(zzetVar3.zzi(), i6, 8, true)) {
                break;
            }
            long jZzz = zzetVar3.zzz();
            int iZzB = zzetVar3.zzB();
            if (jZzz == 1) {
                zzafzVar.zzi(zzetVar3.zzi(), 8, 8);
                i = 16;
                zzetVar3.zzf(16);
                jZzD = zzetVar3.zzD();
                zzetVar = zzetVar3;
            } else {
                if (jZzz == 0) {
                    long jZzo2 = zzafzVar.zzo();
                    if (jZzo2 != j) {
                        jZzz = (jZzo2 - zzafzVar.zzm()) + 8;
                    }
                }
                jZzD = jZzz;
                zzetVar = zzetVar3;
                i = 8;
            }
            long j3 = i;
            if (jZzD < j3) {
                zzahfVar = null;
                if (iZzB == 1718773093) {
                    if (i == 8) {
                        iZzB = 1718773093;
                        jZzD = 8;
                    } else {
                        iZzB = 1718773093;
                    }
                }
                return new zzakx(iZzB, jZzD, i);
            }
            zzahfVar = null;
            i7 += i;
            if (iZzB != 1836019574) {
                if (iZzB == 1970628964) {
                    iZzB = 1970628964;
                } else {
                    i2 = 1;
                    if (iZzB != 1953653099 || iZzB == 1835297121 || iZzB == 1835626086) {
                        zzetVar2 = zzetVar;
                        i3 = 0;
                    } else {
                        if (iZzB == 1836019558 || iZzB == 1836475768) {
                            i6 = i2;
                            break;
                        }
                        i8 |= (iZzB == 1835295092 ? 0 : i2) ^ 1;
                        if (iZzB == 1937007212) {
                            if (jZzD > 1000000) {
                                i6 = 0;
                                break;
                            }
                            iZzB = 1937007212;
                        }
                        int i9 = iZzB;
                        if ((((long) i7) + jZzD) - j3 >= i5) {
                            i6 = 0;
                            break;
                        }
                        int i10 = (int) (jZzD - j3);
                        i7 += i10;
                        if (i9 != 1718909296) {
                            zzetVar2 = zzetVar;
                            i3 = 0;
                            if (i10 != 0) {
                                zzafzVar.zzk(i10);
                            }
                        } else {
                            if (i10 < 8) {
                                return new zzakx(1718909296, i10, 8);
                            }
                            zzetVar2 = zzetVar;
                            zzetVar2.zza(i10);
                            i3 = 0;
                            zzafzVar.zzi(zzetVar2.zzi(), 0, i10);
                            int iZzB2 = zzetVar2.zzB();
                            int i11 = (zzd(iZzB2) ? 1 : 0) | i8;
                            zzetVar2.zzk(4);
                            int iZzd = zzetVar2.zzd() / 4;
                            if (i11 == 0 && iZzd > 0) {
                                int[] iArr2 = new int[iZzd];
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= iZzd) {
                                        i4 = i11;
                                        iArr = iArr2;
                                        break;
                                    }
                                    int iZzB3 = zzetVar2.zzB();
                                    iArr2[i12] = iZzB3;
                                    if (zzd(iZzB3)) {
                                        iArr = iArr2;
                                        i4 = i2;
                                        break;
                                    }
                                    i12++;
                                }
                            } else {
                                i4 = i11;
                                iArr = zzahfVar;
                            }
                            if (i4 == 0) {
                                return new zzamm(iZzB2, iArr);
                            }
                            i8 = i4;
                        }
                    }
                    i6 = i3;
                    zzetVar3 = zzetVar2;
                    j = -1;
                }
            }
            i5 += (int) jZzD;
            i2 = 1;
            if (jZzo != -1 && i5 > jZzo) {
                i5 = (int) jZzo;
            }
            if (iZzB == 1836019574) {
                zzetVar3 = zzetVar;
                j = -1;
                i6 = 0;
            } else if (iZzB != 1953653099) {
                zzetVar2 = zzetVar;
                i3 = 0;
                i6 = i3;
                zzetVar3 = zzetVar2;
                j = -1;
            }
        }
        zzahfVar = null;
        return i8 == 0 ? zzamd.zza : z != i6 ? i6 != 0 ? zzals.zza : zzals.zzb : zzahfVar;
    }

    private static boolean zzd(int i) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
