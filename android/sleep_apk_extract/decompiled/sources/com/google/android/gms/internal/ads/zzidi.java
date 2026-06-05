package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzidi extends zzidj {
    private final byte[] zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private final OutputStream zzg;

    public zzidi(OutputStream outputStream, int i) {
        super(null);
        if (outputStream == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("out");
            throw null;
        }
        this.zzg = outputStream;
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("bufferSize must be >= 0");
            throw null;
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.zzc = bArr;
        this.zzd = bArr.length;
    }

    private final void zzK(int i) throws IOException {
        if (this.zzd - this.zze < i) {
            zzL();
        }
    }

    private final void zzL() throws IOException {
        this.zzg.write(this.zzc, 0, this.zze);
        this.zze = 0;
    }

    public final void zzA(long j) {
        if (zzidj.zzc) {
            long j2 = this.zze;
            while (true) {
                long j3 = j & (-128);
                int i = (int) j;
                byte[] bArr = this.zzc;
                if (j3 == 0) {
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    zziha.zzo(bArr, i2, (byte) i);
                    this.zzf += (int) (((long) this.zze) - j2);
                    return;
                }
                int i3 = this.zze;
                this.zze = i3 + 1;
                zziha.zzo(bArr, i3, (byte) (i | 128));
                j >>>= 7;
            }
        } else {
            while (true) {
                long j4 = j & (-128);
                int i4 = (int) j;
                byte[] bArr2 = this.zzc;
                if (j4 == 0) {
                    int i5 = this.zze;
                    this.zze = i5 + 1;
                    bArr2[i5] = (byte) i4;
                    this.zzf++;
                    return;
                }
                int i6 = this.zze;
                this.zze = i6 + 1;
                bArr2[i6] = (byte) (i4 | 128);
                this.zzf++;
                j >>>= 7;
            }
        }
    }

    public final void zzB(int i) {
        int i2 = this.zze;
        byte[] bArr = this.zzc;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
        this.zze = i2 + 4;
        this.zzf += 4;
    }

    public final void zzC(long j) {
        int i = this.zze;
        byte[] bArr = this.zzc;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
        this.zze = i + 8;
        this.zzf += 8;
    }

    public final void zzD(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzd;
        int i4 = this.zze;
        int i5 = i3 - i4;
        byte[] bArr2 = this.zzc;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            this.zze += i2;
            this.zzf += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i4, i5);
        int i6 = i + i5;
        this.zze = i3;
        this.zzf += i5;
        zzL();
        int i7 = i2 - i5;
        if (i7 <= i3) {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.zze = i7;
        } else {
            this.zzg.write(bArr, i6, i7);
        }
        this.zzf += i7;
    }

    @Override // com.google.android.gms.internal.ads.zzicr
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzD(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzb(int i, int i2) throws IOException {
        zzr((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzc(int i, int i2) throws IOException {
        zzK(20);
        zzz(i << 3);
        if (i2 >= 0) {
            zzz(i2);
        } else {
            zzA(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzd(int i, int i2) throws IOException {
        zzK(20);
        zzz(i << 3);
        zzz(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zze(int i, int i2) throws IOException {
        zzK(14);
        zzz((i << 3) | 5);
        zzB(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzf(int i, long j) throws IOException {
        zzK(20);
        zzz(i << 3);
        zzA(j);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzg(int i, long j) throws IOException {
        zzK(18);
        zzz((i << 3) | 1);
        zzC(j);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzh(int i, boolean z) throws IOException {
        zzK(11);
        zzz(i << 3);
        zzv(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzi(int i, String str) throws IOException {
        zzr((i << 3) | 2);
        zzw(str);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzj(int i, zzida zzidaVar) throws IOException {
        zzr((i << 3) | 2);
        zzk(zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzk(zzida zzidaVar) throws IOException {
        zzr(zzidaVar.zzb());
        zzidaVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzl(byte[] bArr, int i, int i2) throws IOException {
        zzr(i2);
        zzD(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzo(zzifp zzifpVar) throws IOException {
        zzr(zzifpVar.zzbr());
        zzifpVar.zzcX(this);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzp(byte b) throws IOException {
        if (this.zze == this.zzd) {
            zzL();
        }
        zzv(b);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzq(int i) throws IOException {
        if (i >= 0) {
            zzr(i);
        } else {
            zzt(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzr(int i) throws IOException {
        zzK(5);
        zzz(i);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzs(int i) throws IOException {
        zzK(4);
        zzB(i);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzt(long j) throws IOException {
        zzK(10);
        zzA(j);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzu(long j) throws IOException {
        zzK(8);
        zzC(j);
    }

    public final void zzv(byte b) {
        byte[] bArr = this.zzc;
        int i = this.zze;
        bArr[i] = b;
        this.zze = i + 1;
        this.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzw(String str) throws IOException {
        int iZzc;
        int length = str.length() * 3;
        int iZzF = zzidj.zzF(length);
        int i = iZzF + length;
        int i2 = this.zzd;
        if (i > i2) {
            byte[] bArr = new byte[length];
            int iZzd = zzihf.zzd(str, bArr, 0, length);
            zzr(iZzd);
            zzD(bArr, 0, iZzd);
            return;
        }
        if (i > i2 - this.zze) {
            zzL();
        }
        int iZzF2 = zzidj.zzF(str.length());
        int i3 = this.zze;
        try {
            if (iZzF2 == iZzF) {
                int i4 = i3 + iZzF2;
                this.zze = i4;
                int iZzd2 = zzihf.zzd(str, this.zzc, i4, i2 - i4);
                this.zze = i3;
                iZzc = (iZzd2 - i3) - iZzF2;
                zzz(iZzc);
                this.zze = iZzd2;
            } else {
                iZzc = zzihf.zzc(str);
                zzz(iZzc);
                this.zze = zzihf.zzd(str, this.zzc, this.zze, iZzc);
            }
            this.zzf += iZzc;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzidh(e);
        }
    }

    public final void zzx() {
        if (this.zze > 0) {
            zzL();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final int zzy() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    public final void zzz(int i) {
        if (zzidj.zzc) {
            long j = this.zze;
            while (true) {
                int i2 = i & (-128);
                byte[] bArr = this.zzc;
                if (i2 == 0) {
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zziha.zzo(bArr, i3, (byte) i);
                    this.zzf += (int) (((long) this.zze) - j);
                    return;
                }
                int i4 = this.zze;
                this.zze = i4 + 1;
                zziha.zzo(bArr, i4, (byte) (i | 128));
                i >>>= 7;
            }
        } else {
            while (true) {
                int i5 = i & (-128);
                byte[] bArr2 = this.zzc;
                if (i5 == 0) {
                    int i6 = this.zze;
                    this.zze = i6 + 1;
                    bArr2[i6] = (byte) i;
                    this.zzf++;
                    return;
                }
                int i7 = this.zze;
                this.zze = i7 + 1;
                bArr2[i7] = (byte) (i | 128);
                this.zzf++;
                i >>>= 7;
            }
        }
    }
}
