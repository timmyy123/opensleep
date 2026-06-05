package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzxy extends zzzj {
    private Object[] zza = new Object[8];
    private int zzb = 0;

    private final int zzh(zzyl zzylVar) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i + i].equals(zzylVar)) {
                return i;
            }
        }
        return -1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i = 0; i < this.zzb; i++) {
            sb.append(" '");
            sb.append(zzb(i));
            sb.append("': ");
            sb.append(zzc(i));
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final zzyl zzb(int i) {
        if (i < this.zzb) {
            return (zzyl) this.zza[i + i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final Object zzc(int i) {
        if (i < this.zzb) {
            return this.zza[i + i + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final Object zzd(zzyl zzylVar) {
        int iZzh = zzh(zzylVar);
        if (iZzh != -1) {
            return zzylVar.zze(this.zza[iZzh + iZzh + 1]);
        }
        return null;
    }

    public final void zze(zzyl zzylVar, Object obj) {
        int iZzh;
        if (!zzylVar.zzf() && (iZzh = zzh(zzylVar)) != -1) {
            zzabr.zza(obj, "metadata value");
            this.zza[iZzh + iZzh + 1] = obj;
            return;
        }
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i + i > length) {
            this.zza = Arrays.copyOf(objArr, length + length);
        }
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        zzabr.zza(zzylVar, "metadata key");
        objArr2[i2 + i2] = zzylVar;
        Object[] objArr3 = this.zza;
        int i3 = this.zzb;
        zzabr.zza(obj, "metadata value");
        objArr3[i3 + i3 + 1] = obj;
        this.zzb++;
    }

    public final void zzf(zzyl zzylVar) {
        int i;
        int iZzh = zzh(zzylVar);
        if (iZzh >= 0) {
            int i2 = iZzh + iZzh;
            int i3 = i2 + 2;
            while (true) {
                i = this.zzb;
                if (i3 >= i + i) {
                    break;
                }
                Object obj = this.zza[i3];
                if (!obj.equals(zzylVar)) {
                    Object[] objArr = this.zza;
                    objArr[i2] = obj;
                    objArr[i2 + 1] = objArr[i3 + 1];
                    i2 += 2;
                }
                i3 += 2;
            }
            this.zzb = i - ((i3 - i2) >> 1);
            while (i2 < i3) {
                this.zza[i2] = null;
                i2++;
            }
        }
    }
}
