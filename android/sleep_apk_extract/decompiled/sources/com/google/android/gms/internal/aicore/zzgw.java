package com.google.android.gms.internal.aicore;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgw {
    private static final zzgw zza = new zzgw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgw(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z;
    }

    public static zzgw zza() {
        return zza;
    }

    public static zzgw zzb() {
        return new zzgw(0, new int[8], new Object[8], true);
    }

    public static zzgw zzc(zzgw zzgwVar, zzgw zzgwVar2) {
        int i = zzgwVar.zzb + zzgwVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzgwVar.zzc, i);
        System.arraycopy(zzgwVar2.zzc, 0, iArrCopyOf, zzgwVar.zzb, zzgwVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzgwVar.zzd, i);
        System.arraycopy(zzgwVar2.zzd, 0, objArrCopyOf, zzgwVar.zzb, zzgwVar2.zzb);
        return new zzgw(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzi(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgw)) {
            return false;
        }
        zzgw zzgwVar = (zzgw) obj;
        int i = this.zzb;
        if (i == zzgwVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgwVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgwVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int iM = zzba$$ExternalSyntheticOutline0.m(i2, 31, i3, 31);
        Object[] objArr = this.zzd;
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return iM + iHashCode;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
        }
    }

    public final void zze() {
        if (this.zze) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$1();
    }

    public final void zzf(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgc.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzg(int i, Object obj) {
        zze();
        zzi(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final zzgw zzh(zzgw zzgwVar) {
        if (zzgwVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzgwVar.zzb;
        zzi(i);
        System.arraycopy(zzgwVar.zzc, 0, this.zzc, this.zzb, zzgwVar.zzb);
        System.arraycopy(zzgwVar.zzd, 0, this.zzd, this.zzb, zzgwVar.zzb);
        this.zzb = i;
        return this;
    }
}
