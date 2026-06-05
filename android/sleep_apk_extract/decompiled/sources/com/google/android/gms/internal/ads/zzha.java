package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
public final class zzha {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzha(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final boolean zza() {
        int i = (this.zza[this.zzc] & 255) >> this.zzd;
        zzc(1);
        return 1 == (i & 1);
    }

    public final int zzb(int i) {
        int i2 = this.zzc;
        int i3 = 8 - this.zzd;
        int i4 = i2 + 1;
        byte[] bArr = this.zza;
        int iMin = Math.min(i, i3);
        int i5 = ((bArr[i2] & 255) >> this.zzd) & (PHIpAddressSearchManager.END_IP_SCAN >> (8 - iMin));
        while (iMin < i) {
            i5 |= (bArr[i4] & 255) << iMin;
            iMin += 8;
            i4++;
        }
        int i6 = i5 & ((-1) >>> (32 - i));
        zzc(i);
        return i6;
    }

    public final void zzc(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.zzc + i3;
        this.zzc = i4;
        int i5 = (i - (i3 * 8)) + this.zzd;
        this.zzd = i5;
        if (i5 > 7) {
            i4++;
            this.zzc = i4;
            i5 -= 8;
            this.zzd = i5;
        }
        boolean z = false;
        if (i4 >= 0 && (i4 < (i2 = this.zzb) || (i4 == i2 && i5 == 0))) {
            z = true;
        }
        zzgtj.zzi(z);
    }

    public final int zzd() {
        return (this.zzc * 8) + this.zzd;
    }
}
