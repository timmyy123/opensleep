package com.google.android.gms.internal.vision;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzii extends zzhq {
    private static final Logger zzb = Logger.getLogger(zzii.class.getName());
    private static final boolean zzc = zzma.zza();
    zzil zza;

    private zzii() {
    }

    public static int zzb(String str) {
        int length;
        try {
            length = zzmd.zza(str);
        } catch (zzmg unused) {
            length = str.getBytes(zzjf.zza).length;
        }
        return zzg(length) + length;
    }

    @Deprecated
    public static int zzc(int i, zzkk zzkkVar, zzlc zzlcVar) {
        int iZzg = zzg(i << 3) << 1;
        zzhf zzhfVar = (zzhf) zzkkVar;
        int iZzi = zzhfVar.zzi();
        if (iZzi == -1) {
            iZzi = zzlcVar.zzb(zzhfVar);
            zzhfVar.zzb(iZzi);
        }
        return iZzg + iZzi;
    }

    public static int zzd(int i, zzht zzhtVar) {
        return zzc(3, zzhtVar) + zzg(2, i) + (zzg(8) << 1);
    }

    public static int zze(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzf(int i, long j) {
        return zze(zzi(j)) + zzg(i << 3);
    }

    public static int zzg(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzh(int i, int i2) {
        return zzg(zzm(i2)) + zzg(i << 3);
    }

    public static int zzi(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzj(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzf(i2) + zzg(i << 3);
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b);

    public abstract void zza(int i);

    public abstract void zza(int i, int i2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzht zzhtVar);

    public abstract void zza(int i, zzkk zzkkVar);

    public abstract void zza(int i, zzkk zzkkVar, zzlc zzlcVar);

    public abstract void zza(int i, String str);

    public abstract void zza(int i, boolean z);

    public abstract void zza(long j);

    public final void zza(String str, zzmg zzmgVar) throws zzb {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzmgVar);
        byte[] bytes = str.getBytes(zzjf.zza);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public abstract void zzb(int i);

    public abstract void zzb(int i, int i2);

    public abstract void zzb(int i, zzht zzhtVar);

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzc(long j);

    public abstract void zzd(int i);

    public abstract void zze(int i, int i2);

    public static int zze(int i, long j) {
        return zze(j) + zzg(i << 3);
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzg(int i, int i2) {
        return zzg(i2) + zzg(i << 3);
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zzg(int i, long j) {
        return zzg(i << 3) + 8;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i) {
        return 4;
    }

    public static int zzi(int i) {
        return 4;
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public static int zzf(int i, int i2) {
        return zzf(i2) + zzg(i << 3);
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzh(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public static int zzh(int i) {
        return zzg(zzm(i));
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public final void zzb(int i, long j) {
        zza(i, zzi(j));
    }

    public final void zzb(long j) {
        zza(zzi(j));
    }

    public final void zzd(int i, int i2) {
        zzc(i, zzm(i2));
    }

    public static int zzb(int i, float f) {
        return zzg(i << 3) + 4;
    }

    public static int zzd(int i, long j) {
        return zze(j) + zzg(i << 3);
    }

    public static int zzb(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public static class zzb extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        public zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static int zzb(int i, String str) {
        return zzb(str) + zzg(i << 3);
    }

    public final void zzc(int i) {
        zzb(zzm(i));
    }

    public static int zzb(int i, zzkk zzkkVar, zzlc zzlcVar) {
        return zza(zzkkVar, zzlcVar) + zzg(i << 3);
    }

    public static int zzc(int i, zzht zzhtVar) {
        int iZzg = zzg(i << 3);
        int iZza = zzhtVar.zza();
        return zzg(iZza) + iZza + iZzg;
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(zzht zzhtVar) {
        int iZza = zzhtVar.zza();
        return zzg(iZza) + iZza;
    }

    @Deprecated
    public static int zzc(zzkk zzkkVar) {
        return zzkkVar.zzm();
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzb(zzkk zzkkVar) {
        int iZzm = zzkkVar.zzm();
        return zzg(iZzm) + iZzm;
    }

    public final void zzb() {
        if (zza() == 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Did not write as much data as expected.");
    }

    public static zzii zza(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public final void zza(int i, float f) {
        zze(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(float f) {
        zzd(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) {
        zzc(Double.doubleToRawLongBits(d));
    }

    public final void zza(boolean z) {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public static int zza(zzkk zzkkVar, zzlc zzlcVar) {
        zzhf zzhfVar = (zzhf) zzkkVar;
        int iZzi = zzhfVar.zzi();
        if (iZzi == -1) {
            iZzi = zzlcVar.zzb(zzhfVar);
            zzhfVar.zzb(iZzi);
        }
        return zzg(iZzi) + iZzi;
    }

    public static class zza extends zzii {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        public zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("buffer");
                throw null;
            }
            if (((bArr.length - i2) | i2) < 0) {
                Home$$ExternalSyntheticBUOutline0.m("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)});
                throw null;
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i2;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(long j) throws zzb {
            if (!zzii.zzc || zza() < 10) {
                while (true) {
                    long j2 = j & (-128);
                    byte[] bArr = this.zzb;
                    if (j2 == 0) {
                        int i = this.zze;
                        this.zze = i + 1;
                        bArr[i] = (byte) j;
                        return;
                    } else {
                        try {
                            int i2 = this.zze;
                            this.zze = i2 + 1;
                            bArr[i2] = (byte) ((((int) j) & 127) | 128);
                            j >>>= 7;
                        } catch (IndexOutOfBoundsException e) {
                            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                        }
                    }
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            while (true) {
                long j3 = j & (-128);
                byte[] bArr2 = this.zzb;
                if (j3 == 0) {
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zzma.zza(bArr2, i3, (byte) j);
                    return;
                } else {
                    int i4 = this.zze;
                    this.zze = i4 + 1;
                    zzma.zza(bArr2, i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i) throws zzb {
            if (!zzii.zzc || zzhi.zza() || zza() < 5) {
                while (true) {
                    int i2 = i & (-128);
                    byte[] bArr = this.zzb;
                    if (i2 == 0) {
                        int i3 = this.zze;
                        this.zze = i3 + 1;
                        bArr[i3] = (byte) i;
                        return;
                    } else {
                        try {
                            int i4 = this.zze;
                            this.zze = i4 + 1;
                            bArr[i4] = (byte) ((i & 127) | 128);
                            i >>>= 7;
                        } catch (IndexOutOfBoundsException e) {
                            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                        }
                    }
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            int i5 = i & (-128);
            byte[] bArr2 = this.zzb;
            if (i5 == 0) {
                int i6 = this.zze;
                this.zze = i6 + 1;
                zzma.zza(bArr2, i6, (byte) i);
                return;
            }
            int i7 = this.zze;
            this.zze = i7 + 1;
            zzma.zza(bArr2, i7, (byte) (i | 128));
            int i8 = i >>> 7;
            int i9 = i8 & (-128);
            byte[] bArr3 = this.zzb;
            if (i9 == 0) {
                int i10 = this.zze;
                this.zze = i10 + 1;
                zzma.zza(bArr3, i10, (byte) i8);
                return;
            }
            int i11 = this.zze;
            this.zze = i11 + 1;
            zzma.zza(bArr3, i11, (byte) (i8 | 128));
            int i12 = i >>> 14;
            int i13 = i12 & (-128);
            byte[] bArr4 = this.zzb;
            if (i13 == 0) {
                int i14 = this.zze;
                this.zze = i14 + 1;
                zzma.zza(bArr4, i14, (byte) i12);
                return;
            }
            int i15 = this.zze;
            this.zze = i15 + 1;
            zzma.zza(bArr4, i15, (byte) (i12 | 128));
            int i16 = i >>> 21;
            int i17 = i16 & (-128);
            byte[] bArr5 = this.zzb;
            if (i17 == 0) {
                int i18 = this.zze;
                this.zze = i18 + 1;
                zzma.zza(bArr5, i18, (byte) i16);
                return;
            }
            int i19 = this.zze;
            this.zze = i19 + 1;
            zzma.zza(bArr5, i19, (byte) (i16 | 128));
            byte[] bArr6 = this.zzb;
            int i20 = this.zze;
            this.zze = i20 + 1;
            zzma.zza(bArr6, i20, (byte) (i >>> 28));
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(long j) throws zzb {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                int i2 = i + 1;
                this.zze = i2;
                bArr[i] = (byte) j;
                int i3 = i + 2;
                this.zze = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i + 3;
                this.zze = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i + 4;
                this.zze = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i + 5;
                this.zze = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i + 6;
                this.zze = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i + 7;
                this.zze = i8;
                bArr[i7] = (byte) (j >> 48);
                this.zze = i + 8;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzd(int i) throws zzb {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                int i3 = i2 + 1;
                this.zze = i3;
                bArr[i2] = (byte) i;
                int i4 = i2 + 2;
                this.zze = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i2 + 3;
                this.zze = i5;
                bArr[i4] = (byte) (i >> 16);
                this.zze = i2 + 4;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zze(int i, int i2) throws zzb {
            zza(i, 5);
            zzd(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, long j) throws zzb {
            zza(i, 0);
            zza(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(int i, long j) throws zzb {
            zza(i, 1);
            zzc(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, boolean z) throws zzb {
            zza(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(int i, int i2) throws zzb {
            zza(i, 0);
            zzb(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, String str) throws zzb {
            zza(i, 2);
            zza(str);
        }

        private final void zzc(byte[] bArr, int i, int i2) throws zzb {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzht zzhtVar) throws zzb {
            zza(i, 2);
            zza(zzhtVar);
        }

        public final void zza(zzht zzhtVar) throws zzb {
            zzb(zzhtVar.zza());
            zzhtVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzkk zzkkVar, zzlc zzlcVar) throws zzb {
            zza(i, 2);
            zzhf zzhfVar = (zzhf) zzkkVar;
            int iZzi = zzhfVar.zzi();
            if (iZzi == -1) {
                iZzi = zzlcVar.zzb(zzhfVar);
                zzhfVar.zzb(iZzi);
            }
            zzb(iZzi);
            zzlcVar.zza(zzkkVar, this.zza);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzkk zzkkVar) throws zzb {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzkkVar);
            zza(1, 4);
        }

        public final void zza(zzkk zzkkVar) throws zzb {
            zzb(zzkkVar.zzm());
            zzkkVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(byte b) throws zzb {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i) throws zzb {
            if (i >= 0) {
                zzb(i);
            } else {
                zza(i);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, int i2) throws zzb {
            zzb((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.vision.zzhq
        public final void zza(byte[] bArr, int i, int i2) throws zzb {
            zzc(bArr, i, i2);
        }

        public final void zza(String str) throws zzb {
            int i = this.zze;
            try {
                int iZzg = zzii.zzg(str.length() * 3);
                int iZzg2 = zzii.zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.zze = i2;
                    int iZza = zzmd.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzb((iZza - i) - iZzg2);
                    this.zze = iZza;
                    return;
                }
                zzb(zzmd.zza(str));
                this.zze = zzmd.zza(str, this.zzb, this.zze, zza());
            } catch (zzmg e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final int zza() {
            return this.zzd - this.zze;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i, zzht zzhtVar) throws zzb {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzhtVar);
            zza(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i, int i2) throws zzb {
            zza(i, 0);
            zza(i2);
        }
    }
}
