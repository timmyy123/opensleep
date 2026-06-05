package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfh {
    private long[] zza = new long[10];
    private Object[] zzb = new Object[10];
    private int zzc;
    private int zzd;

    public zzfh(int i) {
    }

    private final Object zzf() {
        zzgtj.zzi(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i = this.zzc;
        Object obj = objArr[i];
        objArr[i] = null;
        this.zzc = (i + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized void zza(long j, Object obj) {
        try {
            if (this.zzd > 0) {
                if (j <= this.zza[((this.zzc + r0) - 1) % this.zzb.length]) {
                    zzb();
                }
            }
            int length = this.zzb.length;
            if (this.zzd >= length) {
                int i = length + length;
                long[] jArr = new long[i];
                Object[] objArr = new Object[i];
                int i2 = this.zzc;
                int i3 = length - i2;
                System.arraycopy(this.zza, i2, jArr, 0, i3);
                System.arraycopy(this.zzb, this.zzc, objArr, 0, i3);
                int i4 = this.zzc;
                if (i4 > 0) {
                    System.arraycopy(this.zza, 0, jArr, i3, i4);
                    System.arraycopy(this.zzb, 0, objArr, i3, this.zzc);
                }
                this.zza = jArr;
                this.zzb = objArr;
                this.zzc = 0;
            }
            int i5 = this.zzc;
            int i6 = this.zzd;
            Object[] objArr2 = this.zzb;
            int length2 = (i5 + i6) % objArr2.length;
            this.zza[length2] = j;
            objArr2[length2] = obj;
            this.zzd = i6 + 1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public final synchronized int zzc() {
        return this.zzd;
    }

    public final synchronized Object zzd() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    public final synchronized Object zze(long j) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }
}
