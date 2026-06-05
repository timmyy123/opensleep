package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzwy extends zzxb {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzwy(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            Locale locale = Locale.US;
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(length, i2, "Array range is invalid. Buffer.length=", ", offset=0, length="));
            throw null;
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzA() {
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzO(int i, int i2) throws zzwz {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzP(int i, int i2) throws zzwz {
        zzu(i << 3);
        zzt(i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzQ(int i, int i2) throws zzwz {
        zzu(i << 3);
        zzu(i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzR(int i, int i2) throws zzwz {
        zzu((i << 3) | 5);
        zzv(i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzS(int i, long j) throws zzwz {
        zzu(i << 3);
        zzw(j);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb, com.google.android.gms.internal.serialization.zzwj
    public final void zza(byte[] bArr, int i, int i2) throws zzwz {
        zzy(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzh(int i, long j) throws zzwz {
        zzu((i << 3) | 1);
        zzx(j);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzi(int i, boolean z) throws zzwz {
        zzu(i << 3);
        zzs(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzj(int i, String str) throws zzwz {
        zzu((i << 3) | 2);
        zzz(str);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzk(int i, zzwr zzwrVar) throws zzwz {
        zzu((i << 3) | 2);
        zzm(zzwrVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzl(int i, byte[] bArr) throws zzwz {
        int length = bArr.length;
        zzu((i << 3) | 2);
        zzn(bArr, 0, length);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzm(zzwr zzwrVar) throws zzwz {
        zzu(zzwrVar.zzc());
        zzwrVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzn(byte[] bArr, int i, int i2) throws zzwz {
        zzu(i2);
        zzy(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzo(int i, zzaaq zzaaqVar, zzabe zzabeVar) throws zzwz {
        zzu((i << 3) | 2);
        zzu(((zzvy) zzaaqVar).getSerializedSize(zzabeVar));
        zzabeVar.zzf(zzaaqVar, this.zze);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzp(int i, zzaaq zzaaqVar) throws zzwz {
        zzu(11);
        zzQ(2, i);
        zzu(26);
        zzr(zzaaqVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzq(int i, zzwr zzwrVar) throws zzwz {
        zzu(11);
        zzQ(2, i);
        zzk(3, zzwrVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzr(zzaaq zzaaqVar) throws zzwz {
        zzu(zzaaqVar.getSerializedSize());
        zzaaqVar.writeTo(this);
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzs(byte b) throws zzwz {
        int i = this.zzc;
        try {
            int i2 = i + 1;
            try {
                this.zza[i] = b;
                this.zzc = i2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i = i2;
                throw new zzwz(i, this.zzb, 1, e);
            }
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzt(int i) throws zzwz {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzu(int i) throws zzwz {
        int i2;
        int i3 = this.zzc;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.zza;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.zzc = i2;
                return;
            } else {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzwz(i2, this.zzb, 1, e);
                }
            }
            throw new zzwz(i2, this.zzb, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzv(int i) throws zzwz {
        int i2 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zzc = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzwz(i2, this.zzb, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzw(long j) throws zzwz {
        byte[] bArr;
        int i;
        int i2;
        byte[] bArr2;
        boolean z = zzxb.zzb;
        int i3 = this.zzc;
        if (!z || this.zzb - i3 < 10) {
            while (true) {
                long j2 = j & (-128);
                bArr = this.zza;
                if (j2 == 0) {
                    break;
                }
                int i4 = i3 + 1;
                try {
                    bArr[i3] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i3 = i4;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i4;
                }
                throw new zzwz(i, this.zzb, 1, e);
            }
            i = i3 + 1;
            try {
                bArr[i3] = (byte) j;
                i2 = i;
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
            }
        } else {
            while (true) {
                long j3 = j & (-128);
                bArr2 = this.zza;
                if (j3 == 0) {
                    break;
                }
                zzaby.zzp(bArr2, i3, (byte) (((int) j) | 128));
                j >>>= 7;
                i3++;
            }
            i2 = i3 + 1;
            zzaby.zzp(bArr2, i3, (byte) j);
        }
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzx(long j) throws zzwz {
        int i = this.zzc;
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new zzwz(i, this.zzb, 8, e);
        }
    }

    public final void zzy(byte[] bArr, int i, int i2) throws zzwz {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzwz(this.zzc, this.zzb, i2, e);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzxb
    public final void zzz(String str) throws zzwz {
        int i = this.zzc;
        try {
            int iZzD = zzxb.zzD(str.length() * 3);
            int iZzD2 = zzxb.zzD(str.length());
            if (iZzD2 != iZzD) {
                zzu(zzacd.zzb(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzacd.zzc(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzD2;
            this.zzc = i3;
            int iZzc = zzacd.zzc(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzu((iZzc - i) - iZzD2);
            this.zzc = iZzc;
        } catch (zzacc e) {
            this.zzc = i;
            zzJ(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzwz(e2);
        }
    }
}
