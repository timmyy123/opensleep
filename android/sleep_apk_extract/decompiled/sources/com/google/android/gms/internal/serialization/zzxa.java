package com.google.android.gms.internal.serialization;

import java.io.IOException;
import java.io.OutputStream;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzxa extends zzwx {
    private final OutputStream zzg;

    public zzxa(OutputStream outputStream, int i) {
        super(i);
        if (outputStream != null) {
            this.zzg = outputStream;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("out");
            throw null;
        }
    }

    private final void zzM(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzN();
        }
    }

    private final void zzN() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzA() throws IOException {
        if (this.zzc > 0) {
            zzN();
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzO(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzP(int i, int i2) throws IOException {
        zzM(20);
        zzd(i << 3);
        if (i2 >= 0) {
            zzd(i2);
        } else {
            zze(i2);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzQ(int i, int i2) throws IOException {
        zzM(20);
        zzd(i << 3);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzR(int i, int i2) throws IOException {
        zzM(14);
        zzd((i << 3) | 5);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzS(int i, long j) throws IOException {
        zzM(20);
        zzd(i << 3);
        zze(j);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb, com.google.android.gms.internal.serialization.zzwj
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzy(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzh(int i, long j) throws IOException {
        zzM(18);
        zzd((i << 3) | 1);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzi(int i, boolean z) throws IOException {
        zzM(11);
        zzd(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzj(int i, String str) throws IOException {
        zzu((i << 3) | 2);
        zzz(str);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzk(int i, zzwr zzwrVar) throws IOException {
        zzu((i << 3) | 2);
        zzm(zzwrVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzl(int i, byte[] bArr) throws IOException {
        int length = bArr.length;
        zzu((i << 3) | 2);
        zzn(bArr, 0, length);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzm(zzwr zzwrVar) throws IOException {
        zzu(zzwrVar.zzc());
        zzwrVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzn(byte[] bArr, int i, int i2) throws IOException {
        zzu(i2);
        zzy(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzo(int i, zzaaq zzaaqVar, zzabe zzabeVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(((zzvy) zzaaqVar).getSerializedSize(zzabeVar));
        zzabeVar.zzf(zzaaqVar, this.zze);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzp(int i, zzaaq zzaaqVar) throws IOException {
        zzu(11);
        zzQ(2, i);
        zzu(26);
        zzr(zzaaqVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzq(int i, zzwr zzwrVar) throws IOException {
        zzu(11);
        zzQ(2, i);
        zzk(3, zzwrVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzr(zzaaq zzaaqVar) throws IOException {
        zzu(zzaaqVar.getSerializedSize());
        zzaaqVar.writeTo(this);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzs(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzN();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzt(int i) throws IOException {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzu(int i) throws IOException {
        zzM(5);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzv(int i) throws IOException {
        zzM(4);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzw(long j) throws IOException {
        zzM(10);
        zze(j);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzx(long j) throws IOException {
        zzM(8);
        zzg(j);
    }

    public final void zzy(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        byte[] bArr2 = this.zza;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, bArr2, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, 0, bArr2, i4, i5);
        this.zzc = this.zzb;
        this.zzd += i5;
        zzN();
        int i6 = i2 - i5;
        if (i6 <= this.zzb) {
            System.arraycopy(bArr, i5, this.zza, 0, i6);
            this.zzc = i6;
        } else {
            this.zzg.write(bArr, i5, i6);
        }
        this.zzd += i6;
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzz(String str) throws IOException {
        int iZzb;
        try {
            int length = str.length() * 3;
            int iZzD = zzxb.zzD(length);
            int i = iZzD + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzc = zzacd.zzc(str, bArr, 0, length);
                zzu(iZzc);
                zzy(bArr, 0, iZzc);
                return;
            }
            if (i > i2 - this.zzc) {
                zzN();
            }
            int iZzD2 = zzxb.zzD(str.length());
            int i3 = this.zzc;
            try {
                if (iZzD2 == iZzD) {
                    int i4 = i3 + iZzD2;
                    this.zzc = i4;
                    int iZzc2 = zzacd.zzc(str, this.zza, i4, this.zzb - i4);
                    this.zzc = i3;
                    iZzb = (iZzc2 - i3) - iZzD2;
                    zzd(iZzb);
                    this.zzc = iZzc2;
                } else {
                    iZzb = zzacd.zzb(str);
                    zzd(iZzb);
                    this.zzc = zzacd.zzc(str, this.zza, this.zzc, iZzb);
                }
                this.zzd += iZzb;
            } catch (zzacc e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzwz(e2);
            }
        } catch (zzacc e3) {
            zzJ(str, e3);
        }
    }
}
