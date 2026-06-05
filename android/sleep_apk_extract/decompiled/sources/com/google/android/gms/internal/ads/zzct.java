package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class zzct {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final zzcr zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private double zzq;

    public zzct(int i, int i2, float f, float f2, int i3, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = i / i3;
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        this.zzh = i4 + i4;
        this.zzi = z ? new zzcq(this) : new zzcs(this);
    }

    private final void zzo(int i, int i2) {
        zzcr zzcrVar = this.zzi;
        zzcrVar.zzk(i2);
        Object objZzr = zzcrVar.zzr();
        Object objZzq = zzcrVar.zzq();
        int i3 = this.zzk;
        int i4 = this.zzb;
        System.arraycopy(objZzr, i * i4, objZzq, i3 * i4, i2 * i4);
        this.zzk += i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzp() {
        float f;
        int iZze;
        int i;
        double d;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        long j;
        long j2;
        float f3 = this.zzc;
        float f4 = this.zzd;
        double d2 = f3 / f4;
        int i8 = this.zzk;
        int i9 = 0;
        int i10 = 1;
        if (d2 > 1.0000100135803223d || d2 < 0.9999899864196777d) {
            int i11 = this.zzj;
            int i12 = this.zzh;
            if (i11 >= i12) {
                int i13 = 0;
                while (true) {
                    int i14 = this.zzo;
                    if (i14 > 0) {
                        int iMin = Math.min(i12, i14);
                        zzo(i13, iMin);
                        this.zzo -= iMin;
                        i13 += iMin;
                        f = f4;
                        d = d2;
                        i2 = i10;
                        i3 = i12;
                    } else {
                        int i15 = this.zza;
                        int i16 = i15 > 4000 ? i15 / 4000 : i10;
                        int i17 = this.zzb;
                        if (i17 != i10) {
                            zzcr zzcrVar = this.zzi;
                            zzcrVar.zzd(i13, i16);
                            int i18 = this.zzf;
                            int i19 = this.zzg;
                            f = f4;
                            int iZze2 = zzcrVar.zze(i9, i18 / i16, i19 / i16);
                            if (i16 == i10) {
                                int i20 = iZze2 * i16;
                                int i21 = i16 * 4;
                                int i22 = i20 - i21;
                                if (i22 >= i18) {
                                    i18 = i22;
                                }
                                int i23 = i20 + i21;
                                if (i23 <= i19) {
                                    i19 = i23;
                                }
                                if (i17 == i10) {
                                    iZze = zzcrVar.zzf(i13, i18, i19);
                                } else {
                                    zzcrVar.zzd(i13, i10);
                                    iZze = zzcrVar.zze(i9, i18, i19);
                                }
                            } else {
                                iZze = iZze2;
                            }
                            i = i17;
                            zzcr zzcrVar2 = this.zzi;
                            int i24 = zzcrVar2.zzc() ? this.zzp : iZze;
                            int i25 = i13 + i24;
                            zzcrVar2.zzi();
                            this.zzp = iZze;
                            double d3 = i24;
                            if (d2 > 1.0d) {
                                double d4 = d2 - 1.0d;
                                i2 = i10;
                                i3 = i12;
                                double d5 = this.zzq;
                                if (d2 >= 2.0d) {
                                    double d6 = (d3 / d4) + d5;
                                    int iRound = (int) Math.round(d6);
                                    d = d2;
                                    this.zzq = d6 - ((double) iRound);
                                    i5 = iRound;
                                } else {
                                    d = d2;
                                    double d7 = (((2.0d - d) * d3) / d4) + d5;
                                    int iRound2 = (int) Math.round(d7);
                                    this.zzo = iRound2;
                                    this.zzq = d7 - ((double) iRound2);
                                    i5 = i24;
                                }
                                zzcrVar2.zzk(i5);
                                zzcrVar2.zzh(i5, i, this.zzk, i13, i25);
                                this.zzk += i5;
                                i13 = i24 + i5 + i13;
                            } else {
                                d = d2;
                                i2 = i10;
                                i3 = i12;
                                double d8 = 1.0d - d;
                                double d9 = this.zzq;
                                if (d < 0.5d) {
                                    double d10 = ((d3 * d) / d8) + d9;
                                    int iRound3 = (int) Math.round(d10);
                                    this.zzq = d10 - ((double) iRound3);
                                    i4 = iRound3;
                                } else {
                                    double d11 = ((((d + d) - 1.0d) * d3) / d8) + d9;
                                    int iRound4 = (int) Math.round(d11);
                                    this.zzo = iRound4;
                                    this.zzq = d11 - ((double) iRound4);
                                    i4 = i24;
                                }
                                int i26 = i24 + i4;
                                zzcrVar2.zzk(i26);
                                System.arraycopy(zzcrVar2.zzr(), i13 * i, zzcrVar2.zzq(), this.zzk * i, i24 * i);
                                int i27 = i13;
                                zzcrVar2.zzh(i4, i, this.zzk + i24, i25, i27);
                                this.zzk += i26;
                                i13 = i27 + i4;
                            }
                        } else if (i16 == i10) {
                            iZze = this.zzi.zzf(i13, this.zzf, this.zzg);
                            f = f4;
                            i = i10;
                            zzcr zzcrVar22 = this.zzi;
                            if (zzcrVar22.zzc()) {
                            }
                            int i252 = i13 + i24;
                            zzcrVar22.zzi();
                            this.zzp = iZze;
                            double d32 = i24;
                            if (d2 > 1.0d) {
                            }
                        } else {
                            i17 = i10;
                            zzcr zzcrVar3 = this.zzi;
                            zzcrVar3.zzd(i13, i16);
                            int i182 = this.zzf;
                            int i192 = this.zzg;
                            f = f4;
                            int iZze22 = zzcrVar3.zze(i9, i182 / i16, i192 / i16);
                            if (i16 == i10) {
                            }
                            i = i17;
                            zzcr zzcrVar222 = this.zzi;
                            if (zzcrVar222.zzc()) {
                            }
                            int i2522 = i13 + i24;
                            zzcrVar222.zzi();
                            this.zzp = iZze;
                            double d322 = i24;
                            if (d2 > 1.0d) {
                            }
                        }
                    }
                    if (i13 + i3 > i11) {
                        break;
                    }
                    f4 = f;
                    i10 = i2;
                    i12 = i3;
                    d2 = d;
                    i9 = 0;
                }
                int i28 = this.zzj - i13;
                zzcr zzcrVar4 = this.zzi;
                int i29 = this.zzb;
                System.arraycopy(zzcrVar4.zzr(), i13 * i29, zzcrVar4.zzr(), 0, i29 * i28);
                this.zzj = i28;
            }
            f2 = this.zze * f;
            if (f2 != 1.0f || this.zzk == i8) {
            }
            int i30 = this.zza;
            long j3 = i30;
            long j4 = (long) (i30 / f2);
            while (j4 != 0 && j3 != 0 && j4 % 2 == 0 && j3 % 2 == 0) {
                j4 /= 2;
                j3 /= 2;
            }
            int i31 = this.zzk - i8;
            zzcr zzcrVar5 = this.zzi;
            zzcrVar5.zzl(i31);
            int i32 = this.zzb;
            System.arraycopy(zzcrVar5.zzq(), i8 * i32, zzcrVar5.zzp(), this.zzl * i32, i31 * i32);
            this.zzk = i8;
            this.zzl += i31;
            int i33 = 0;
            while (true) {
                i6 = this.zzl - 1;
                if (i33 >= i6) {
                    break;
                }
                while (true) {
                    i7 = this.zzm + 1;
                    j = i7;
                    long j5 = j * j4;
                    j2 = this.zzn;
                    if (j5 <= j2 * j3) {
                        break;
                    }
                    int i34 = i2;
                    zzcrVar5.zzk(i34);
                    zzcrVar5.zzb(i33, j3, j4);
                    this.zzn += i34;
                    this.zzk += i34;
                }
                int i35 = i2;
                this.zzm = i7;
                if (j == j3) {
                    this.zzm = 0;
                    zzgtj.zzi(j2 == j4 ? i35 : 0);
                    this.zzn = 0;
                }
                i33++;
                i2 = i35;
            }
            if (i6 != 0) {
                System.arraycopy(zzcrVar5.zzp(), i6 * i32, zzcrVar5.zzp(), 0, (this.zzl - i6) * i32);
                this.zzl -= i6;
                return;
            }
            return;
        }
        zzo(0, this.zzj);
        this.zzj = 0;
        f = f4;
        i2 = 1;
        f2 = this.zze * f;
        if (f2 != 1.0f) {
        }
    }

    public final int zza() {
        return this.zzj * this.zzb * this.zzi.zza();
    }

    public final void zzb(ByteBuffer byteBuffer) {
        zzcr zzcrVar = this.zzi;
        int iRemaining = byteBuffer.remaining();
        int iZza = iRemaining / (this.zzb * zzcrVar.zza());
        zzcrVar.zzj(iZza);
        zzcrVar.zzn(byteBuffer, iRemaining);
        this.zzj += iZza;
        zzp();
    }

    public final void zzc(ByteBuffer byteBuffer) {
        zzgtj.zzi(this.zzk >= 0);
        int i = this.zzb;
        int iRemaining = byteBuffer.remaining();
        zzcr zzcrVar = this.zzi;
        int iMin = Math.min(iRemaining / (zzcrVar.zza() * i), this.zzk);
        zzcrVar.zzo(byteBuffer, iMin);
        this.zzk -= iMin;
        System.arraycopy(zzcrVar.zzq(), iMin * i, zzcrVar.zzq(), 0, this.zzk * i);
    }

    public final void zzd() {
        int i = this.zzj;
        int i2 = this.zzo;
        int i3 = this.zzk;
        float f = this.zzc;
        float f2 = this.zzd;
        int i4 = i3 + ((int) ((((((((double) (i - i2)) / ((double) (f / f2))) + ((double) i2)) + this.zzq) + ((double) this.zzl)) / ((double) (this.zze * f2))) + 0.5d));
        this.zzq = 0.0d;
        int i5 = this.zzh;
        int i6 = i5 + i5;
        zzcr zzcrVar = this.zzi;
        zzcrVar.zzj(i + i6);
        zzcrVar.zzm(i * this.zzb, i6);
        this.zzj += i6;
        zzp();
        if (this.zzk > i4) {
            this.zzk = Math.max(i4, 0);
        }
        this.zzj = 0;
        this.zzo = 0;
        this.zzl = 0;
    }

    public final void zze() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 0;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0.0d;
        this.zzi.zzg();
    }

    public final int zzf() {
        zzgtj.zzi(this.zzk >= 0);
        return this.zzk * this.zzb * this.zzi.zza();
    }

    public final /* synthetic */ int zzg() {
        return this.zzb;
    }

    public final /* synthetic */ int zzh() {
        return this.zzh;
    }

    public final /* synthetic */ int zzi() {
        return this.zzj;
    }

    public final /* synthetic */ int zzj() {
        return this.zzk;
    }

    public final /* synthetic */ int zzk() {
        return this.zzl;
    }

    public final /* synthetic */ int zzl() {
        return this.zzm;
    }

    public final /* synthetic */ int zzm() {
        return this.zzn;
    }

    public final /* synthetic */ int zzn() {
        return this.zzp;
    }
}
