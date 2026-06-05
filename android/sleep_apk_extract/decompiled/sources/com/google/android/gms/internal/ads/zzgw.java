package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgw {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze = 0;

    public zzgw(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzc = i;
        this.zzd = i;
        this.zzb = i2;
        zzk();
    }

    private final int zzi() {
        int i = 0;
        while (!zze()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzf(i) : 0);
    }

    private final boolean zzj(int i) {
        int i2 = i - 2;
        if (this.zzc > i2 || i >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i] == 3 && bArr[i2] == 0 && bArr[i + (-1)] == 0;
    }

    private final void zzk() {
        int i;
        int i2 = this.zzd;
        boolean z = false;
        if (i2 >= 0 && (i2 < (i = this.zzb) || (i2 == i && this.zze == 0))) {
            z = true;
        }
        zzgtj.zzi(z);
    }

    public final void zza() {
        int i = this.zze + 1;
        this.zze = i;
        if (i == 8) {
            this.zze = 0;
            int i2 = this.zzd;
            this.zzd = i2 + (true == zzj(i2 + 1) ? 2 : 1);
        }
        zzk();
    }

    public final void zzb(int i) {
        int i2 = this.zzd;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.zzd = i4;
        int i5 = (i - (i3 * 8)) + this.zze;
        this.zze = i5;
        if (i5 > 7) {
            this.zzd = i4 + 1;
            this.zze = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzd) {
                zzk();
                return;
            } else if (zzj(i2)) {
                this.zzd++;
                i2 += 2;
            }
        }
    }

    public final void zzc() {
        int i = this.zze;
        if (i > 0) {
            zzb(8 - i);
        }
    }

    public final boolean zzd(int i) {
        int i2 = this.zzd;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.zze + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 > this.zzb) {
                break;
            }
            if (zzj(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.zzb;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public final boolean zze() {
        int i = this.zza[this.zzd] & (128 >> this.zze);
        zza();
        return i != 0;
    }

    public final int zzf(int i) {
        int i2;
        this.zze += i;
        int i3 = 0;
        while (true) {
            i2 = this.zze;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.zze = i4;
            byte[] bArr = this.zza;
            int i5 = this.zzd;
            i3 |= (bArr[i5] & 255) << i4;
            if (true != zzj(i5 + 1)) {
                i = 1;
            }
            this.zzd = i5 + i;
        }
        byte[] bArr2 = this.zza;
        int i6 = this.zzd;
        int i7 = i3 | ((bArr2[i6] & 255) >> (8 - i2));
        int i8 = 32 - i;
        if (i2 == 8) {
            this.zze = 0;
            this.zzd = i6 + (true != zzj(i6 + 1) ? 1 : 2);
        }
        int i9 = ((-1) >>> i8) & i7;
        zzk();
        return i9;
    }

    public final int zzg() {
        return zzi();
    }

    public final int zzh() {
        int iZzi = zzi();
        int i = iZzi % 2;
        return ((iZzi + 1) / 2) * (i == 0 ? -1 : 1);
    }
}
