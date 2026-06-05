package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdn {
    private int zzb;
    private int zzc;
    private int zzd = 7;
    private int[] zza = new int[8];

    public final void zza(int i) {
        int[] iArr = this.zza;
        int i2 = this.zzc;
        iArr[i2] = i;
        int i3 = this.zzd & (i2 + 1);
        this.zzc = i3;
        int i4 = this.zzb;
        if (i3 == i4) {
            int length = iArr.length;
            int i5 = length - i4;
            int i6 = length + length;
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i4, iArr2, 0, i5);
            System.arraycopy(this.zza, 0, iArr2, i5, this.zzb);
            this.zza = iArr2;
            this.zzb = 0;
            this.zzc = length;
            this.zzd = i6 - 1;
        }
    }

    public final int zzb() {
        int i = this.zzb;
        if (i == this.zzc) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = this.zza[i];
        this.zzb = (i + 1) & this.zzd;
        return i2;
    }

    public final void zzc() {
        this.zzc = this.zzb;
    }

    public final boolean zzd() {
        return this.zzb == this.zzc;
    }
}
