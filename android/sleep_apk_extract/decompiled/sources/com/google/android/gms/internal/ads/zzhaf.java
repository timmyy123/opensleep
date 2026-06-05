package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhaf implements Serializable {
    private static final zzhaf zza = new zzhaf(new int[0], 0, 0);
    private final int[] zzb;
    private final int zzc;

    private zzhaf(int[] iArr, int i, int i2) {
        this.zzb = iArr;
        this.zzc = i2;
    }

    public static zzhaf zza() {
        return zza;
    }

    public static zzhaf zzb(int i, int i2, int i3) {
        return new zzhaf(new int[]{0, 2, 1}, 0, 3);
    }

    public static zzhaf zzc(int i, int i2, int i3, int i4, int i5) {
        return new zzhaf(new int[]{0, 2, 1, 3, 4}, 0, 5);
    }

    public static zzhaf zzd(int i, int i2, int i3, int i4, int i5, int i6) {
        return new zzhaf(new int[]{0, 2, 1, 5, 3, 4}, 0, 6);
    }

    public static zzhaf zze(int i, int... iArr) {
        int length = iArr.length;
        int i2 = length + 1;
        int[] iArr2 = new int[i2];
        iArr2[0] = 0;
        System.arraycopy(iArr, 0, iArr2, 1, length);
        return new zzhaf(iArr2, 0, i2);
    }

    public static zzhaf zzf(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzhaf(iArrCopyOf, 0, iArrCopyOf.length);
    }

    public static zzhae zzg(int i) {
        zzgtj.zzd(i >= 0, "Invalid initialCapacity: %s", i);
        return new zzhae(i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhaf)) {
            return false;
        }
        zzhaf zzhafVar = (zzhaf) obj;
        int i = this.zzc;
        if (i != zzhafVar.zzc) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (zzi(i2) != zzhafVar.zzi(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i = 0; i < this.zzc; i++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.zzb[i]);
        }
        return iHashCode;
    }

    public final String toString() {
        int i = this.zzc;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append('[');
        int[] iArr = this.zzb;
        sb.append(iArr[0]);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(", ");
            sb.append(iArr[i2]);
        }
        sb.append(']');
        return sb.toString();
    }

    public final int zzh() {
        return this.zzc;
    }

    public final int zzi(int i) {
        zzgtj.zzm(i, this.zzc, "index");
        return this.zzb[i];
    }

    public /* synthetic */ zzhaf(int[] iArr, int i, int i2, byte[] bArr) {
        this(iArr, 0, i2);
    }
}
