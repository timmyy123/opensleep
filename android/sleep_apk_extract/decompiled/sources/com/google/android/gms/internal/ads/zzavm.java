package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final class zzavm {
    public static zzawm zza(final long j) {
        return zzawm.zzf(new zzawe() { // from class: com.google.android.gms.internal.ads.zzavl
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                try {
                    ((zzawh) obj).zzb.zzb(zzawm.zzb(j));
                    return Optional.empty();
                } catch (zzawc unused) {
                    return Optional.of(zzauw.zza);
                }
            }
        });
    }

    public static int zzb(long j, zzawl zzawlVar, boolean z) throws IOException {
        long[] jArr = {2000490107, 1476547902, 1834034217, 268849430, 1839467528, 4368198174L, 449620248, 1652701270, 1629190168};
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        long j9 = jArr[7];
        long j10 = (((((~j2) & j3) | j4) + ((j2 & j5) | j6)) - j7) + j8;
        long j11 = j9 % 1629190168;
        int i = ((((~1725868784) & 388366538) | 739792167) + ((1725868784 & 1395525853) | 1087913783)) - 2073845026;
        int i2 = 1550046828 % 184366026;
        int i3 = ((((~84870791) & 719462960) | 688752780) + ((84870791 & 317383283) | 806209731)) - 1437974767;
        int i4 = 2023762697 % 959200313;
        int i5 = ((((~294151249) & 1465191424) | 201912514) + ((294151249 & 1398095366) | 75641662)) - 1330100008;
        int i6 = 1583887958 % 619175679;
        long j12 = z ? (j >> ((((((~1375552878) & 930005102) | 1249030018) + ((1375552878 & 1024213116) | 136481682)) - 2090967727) ^ (2014126950 % 228698447))) ^ (j + j) : j;
        int i7 = 1;
        while (true) {
            long j13 = j10 ^ j11;
            long j14 = j12 >>> (i3 ^ i4);
            boolean z2 = j14 != 0 || i7 < 0;
            int i8 = (int) (j12 & j13);
            if (z2) {
                int i9 = i ^ i2;
                i8 = ((i8 | (i5 ^ i6)) << i9) >> i9;
            }
            zzawlVar.zza((byte) i8);
            if (!z2) {
                return i7;
            }
            i7++;
            j12 = j14;
        }
    }
}
