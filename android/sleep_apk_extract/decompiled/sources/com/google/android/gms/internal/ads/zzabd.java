package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabd {
    private final int[] zza;
    private final zzzn[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzzn zze;

    public zzabd(String[] strArr, int[] iArr, zzzn[] zzznVarArr, int[] iArr2, int[][][] iArr3, zzzn zzznVar) {
        this.zza = iArr;
        this.zzb = zzznVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzznVar;
    }

    public final int zza(int i) {
        return this.zza[i];
    }

    public final zzzn zzb(int i) {
        return this.zzb[i];
    }

    public final int zzc(int i, int i2, int i3) {
        return this.zzd[i][i2][i3];
    }

    public final int zzd(int i, int i2, boolean z) {
        zzzn[] zzznVarArr = this.zzb;
        int i3 = zzznVarArr[i].zza(i2).zza;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if ((this.zzd[i][i2][i6] & 7) == 4) {
                iArr[i5] = i6;
                i5++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
        String str = null;
        int i7 = 0;
        int iMin = 16;
        boolean z2 = false;
        while (i4 < iArrCopyOf.length) {
            String str2 = zzznVarArr[i].zza(i2).zza(iArrCopyOf[i4]).zzp;
            int i8 = i7 + 1;
            if (i7 == 0) {
                str = str2;
            } else {
                z2 |= !Objects.equals(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i][i2][i4] & 24);
            i4++;
            i7 = i8;
        }
        return z2 ? Math.min(iMin, this.zzc[i]) : iMin;
    }

    public final zzzn zze() {
        return this.zze;
    }
}
