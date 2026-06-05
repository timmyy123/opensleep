package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcq implements zzcr {
    final /* synthetic */ zzct zza;
    private final float[] zzb;
    private float[] zzc;
    private float[] zzd;
    private float[] zze;
    private double zzf;
    private double zzg;
    private double zzh;

    public zzcq(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.zza = zzctVar;
        this.zzb = new float[zzctVar.zzh()];
        this.zzc = new float[zzctVar.zzh() * zzctVar.zzg()];
        this.zzd = new float[zzctVar.zzh() * zzctVar.zzg()];
        this.zze = new float[zzctVar.zzh() * zzctVar.zzg()];
    }

    private final int zzs(float[] fArr, int i, int i2, int i3) {
        int i4 = 255;
        int i5 = 0;
        double d = 0.0d;
        double d2 = 1.0d;
        int i6 = i2;
        while (true) {
            double d3 = i4;
            double d4 = i5;
            if (i6 > i3) {
                this.zzf = d2 / d4;
                this.zzg = d / d3;
                return i5;
            }
            int i7 = 0;
            double dAbs = 0.0d;
            while (i7 < i6) {
                int iZzg = this.zza.zzg() * i;
                dAbs += (double) Math.abs(fArr[iZzg + i7] - fArr[(iZzg + i6) + i7]);
                i7++;
                i4 = i4;
            }
            int i8 = i4;
            double d5 = d4 * dAbs;
            double d6 = i6;
            double d7 = d2 * d6;
            if (d5 < d7) {
                d2 = dAbs;
            }
            if (d5 < d7) {
                i5 = i6;
            }
            double d8 = d3 * dAbs;
            double d9 = d6 * d;
            if (d8 > d9) {
                d = dAbs;
            }
            i4 = d8 > d9 ? i6 : i8;
            i6++;
        }
    }

    private final float[] zzt(float[] fArr, int i, int i2) {
        zzct zzctVar = this.zza;
        int length = fArr.length / zzctVar.zzg();
        return i + i2 <= length ? fArr : Arrays.copyOf(fArr, Fragment$$ExternalSyntheticOutline1.m$1(length, 3, 2, i2) * zzctVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzb(int i, long j, long j2) {
        int i2 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i2 >= zzctVar.zzg()) {
                return;
            }
            float[] fArr = this.zzd;
            int iZzg = zzctVar.zzg();
            int iZzj = zzctVar.zzj();
            float[] fArr2 = this.zze;
            int iZzg2 = (zzctVar.zzg() * i) + i2;
            float f = fArr2[iZzg2];
            float f2 = fArr2[iZzg2 + zzctVar.zzg()];
            long jZzm = ((long) zzctVar.zzm()) * j;
            long jZzl = ((long) zzctVar.zzl()) * j2;
            long jZzl2 = ((long) (zzctVar.zzl() + 1)) * j2;
            long j3 = jZzl2 - jZzm;
            fArr[(iZzj * iZzg) + i2] = ((j3 * f) + ((r12 - j3) * f2)) / (jZzl2 - jZzl);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        double d = this.zzf;
        return d != 0.0d && this.zza.zzn() != 0 && this.zzg <= d * 3.0d && d + d > this.zzh * 3.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzd(int i, int i2) {
        int iZzg;
        int i3 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i3 >= zzctVar.zzh() / i2) {
                return;
            }
            double d = 0.0d;
            int i4 = 0;
            while (true) {
                iZzg = zzctVar.zzg() * i2;
                if (i4 < iZzg) {
                    d += (double) this.zzc[(iZzg * i3) + (zzctVar.zzg() * i) + i4];
                    i4++;
                }
            }
            this.zzb[i3] = (float) (d / ((double) iZzg));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zze(int i, int i2, int i3) {
        return zzs(this.zzb, 0, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zzf(int i, int i2, int i3) {
        return zzs(this.zzc, i, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzg() {
        this.zzh = 0.0d;
        this.zzf = 0.0d;
        this.zzg = 0.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzh(int i, int i2, int i3, int i4, int i5) {
        float[] fArr = this.zzd;
        float[] fArr2 = this.zzc;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                fArr[i9] = ((fArr2[i8] * i10) + (fArr2[i7] * (i - i10))) / i;
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzi() {
        this.zzh = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzj(int i) {
        this.zzc = zzt(this.zzc, this.zza.zzi(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzk(int i) {
        this.zzd = zzt(this.zzd, this.zza.zzj(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzl(int i) {
        this.zze = zzt(this.zze, this.zza.zzk(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzm(int i, int i2) {
        for (int i3 = 0; i3 < this.zza.zzg() * i2; i3++) {
            this.zzc[i + i3] = 0.0f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzn(ByteBuffer byteBuffer, int i) {
        zzct zzctVar = this.zza;
        byteBuffer.asFloatBuffer().get(this.zzc, zzctVar.zzi() * zzctVar.zzg(), i / 4);
        byteBuffer.position(byteBuffer.position() + i);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzo(ByteBuffer byteBuffer, int i) {
        zzct zzctVar = this.zza;
        byteBuffer.asFloatBuffer().put(this.zzd, 0, zzctVar.zzg() * i);
        byteBuffer.position((i * 4 * zzctVar.zzg()) + byteBuffer.position());
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzp() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzq() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzr() {
        return this.zzc;
    }
}
