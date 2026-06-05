package com.google.android.gms.internal.consent_sdk;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzpq extends zzpv {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    public zzpq(int i) {
        super(null);
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("bufferSize must be >= 0");
            throw null;
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final void zzc(byte b) {
        byte[] bArr = this.zza;
        int i = this.zzc;
        bArr[i] = b;
        this.zzc = i + 1;
        this.zzd++;
    }

    public final void zzd(int i) {
        int i2 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
        this.zzc = i2 + 4;
        this.zzd += 4;
    }

    public final void zze(long j) {
        int i = this.zzc;
        byte[] bArr = this.zza;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
        this.zzc = i + 8;
        this.zzd += 8;
    }

    public final void zzf(int i) {
        if (zzpv.zzb) {
            long j = this.zzc;
            while (true) {
                int i2 = i & (-128);
                byte[] bArr = this.zza;
                if (i2 == 0) {
                    int i3 = this.zzc;
                    this.zzc = i3 + 1;
                    zzsw.zzn(bArr, i3, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j);
                    return;
                }
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzsw.zzn(bArr, i4, (byte) (i | 128));
                i >>>= 7;
            }
        } else {
            while (true) {
                int i5 = i & (-128);
                byte[] bArr2 = this.zza;
                if (i5 == 0) {
                    int i6 = this.zzc;
                    this.zzc = i6 + 1;
                    bArr2[i6] = (byte) i;
                    this.zzd++;
                    return;
                }
                int i7 = this.zzc;
                this.zzc = i7 + 1;
                bArr2[i7] = (byte) (i | 128);
                this.zzd++;
                i >>>= 7;
            }
        }
    }

    public final void zzg(long j) {
        if (zzpv.zzb) {
            long j2 = this.zzc;
            while (true) {
                long j3 = j & (-128);
                int i = (int) j;
                byte[] bArr = this.zza;
                if (j3 == 0) {
                    int i2 = this.zzc;
                    this.zzc = i2 + 1;
                    zzsw.zzn(bArr, i2, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j2);
                    return;
                }
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzsw.zzn(bArr, i3, (byte) (i | 128));
                j >>>= 7;
            }
        } else {
            while (true) {
                long j4 = j & (-128);
                int i4 = (int) j;
                byte[] bArr2 = this.zza;
                if (j4 == 0) {
                    int i5 = this.zzc;
                    this.zzc = i5 + 1;
                    bArr2[i5] = (byte) i4;
                    this.zzd++;
                    return;
                }
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr2[i6] = (byte) (i4 | 128);
                this.zzd++;
                j >>>= 7;
            }
        }
    }
}
