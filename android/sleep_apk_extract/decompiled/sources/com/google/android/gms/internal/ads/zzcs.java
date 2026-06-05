package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcs implements zzcr {
    final /* synthetic */ zzct zza;
    private final short[] zzb;
    private short[] zzc;
    private short[] zzd;
    private short[] zze;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzcs(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.zza = zzctVar;
        this.zzb = new short[zzctVar.zzh()];
        this.zzc = new short[zzctVar.zzh() * zzctVar.zzg()];
        this.zzd = new short[zzctVar.zzh() * zzctVar.zzg()];
        this.zze = new short[zzctVar.zzh() * zzctVar.zzg()];
    }

    private final int zzs(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = PHIpAddressSearchManager.END_IP_SCAN;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                int iZzg = this.zza.zzg() * i;
                iAbs += Math.abs(sArr[iZzg + i8] - sArr[(iZzg + i2) + i8]);
            }
            int i9 = iAbs * i6;
            int i10 = i4 * i2;
            if (i9 < i10) {
                i4 = iAbs;
            }
            if (i9 < i10) {
                i6 = i2;
            }
            int i11 = iAbs * i5;
            int i12 = i7 * i2;
            if (i11 > i12) {
                i7 = iAbs;
            }
            if (i11 > i12) {
                i5 = i2;
            }
            i2++;
        }
        this.zzf = i4 / i6;
        this.zzg = i7 / i5;
        return i6;
    }

    private final short[] zzt(short[] sArr, int i, int i2) {
        zzct zzctVar = this.zza;
        int length = sArr.length / zzctVar.zzg();
        return i + i2 <= length ? sArr : Arrays.copyOf(sArr, Fragment$$ExternalSyntheticOutline1.m$1(length, 3, 2, i2) * zzctVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzb(int i, long j, long j2) {
        int i2 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i2 >= zzctVar.zzg()) {
                return;
            }
            short[] sArr = this.zzd;
            int iZzg = zzctVar.zzg();
            int iZzj = zzctVar.zzj();
            short[] sArr2 = this.zze;
            int iZzg2 = (zzctVar.zzg() * i) + i2;
            short s = sArr2[iZzg2];
            short s2 = sArr2[iZzg2 + zzctVar.zzg()];
            long jZzm = ((long) zzctVar.zzm()) * j;
            long jZzl = ((long) zzctVar.zzl()) * j2;
            long jZzl2 = ((long) (zzctVar.zzl() + 1)) * j2;
            int i3 = i2;
            long j3 = jZzl2 - jZzl;
            long j4 = jZzl2 - jZzm;
            sArr[(iZzj * iZzg) + i3] = (short) ((((j3 - j4) * ((long) s2)) + (j4 * ((long) s))) / j3);
            i2 = i3 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        int i = this.zzf;
        return i != 0 && this.zza.zzn() != 0 && this.zzg <= i * 3 && i + i > this.zzh * 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzd(int i, int i2) {
        int iZzg;
        short[] sArr = this.zzc;
        int i3 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i3 >= zzctVar.zzh() / i2) {
                return;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                iZzg = zzctVar.zzg() * i2;
                if (i4 < iZzg) {
                    i5 += sArr[(iZzg * i3) + (zzctVar.zzg() * i) + i4];
                    i4++;
                }
            }
            this.zzb[i3] = (short) (i5 / iZzg);
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
        this.zzh = 0;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzh(int i, int i2, int i3, int i4, int i5) {
        short[] sArr = this.zzd;
        short[] sArr2 = this.zzc;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i8] * i10) + ((i - i10) * sArr2[i7])) / i);
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
            this.zzc[i + i3] = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzn(ByteBuffer byteBuffer, int i) {
        zzct zzctVar = this.zza;
        byteBuffer.asShortBuffer().get(this.zzc, zzctVar.zzi() * zzctVar.zzg(), i / 2);
        byteBuffer.position(byteBuffer.position() + i);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzo(ByteBuffer byteBuffer, int i) {
        zzct zzctVar = this.zza;
        byteBuffer.asShortBuffer().put(this.zzd, 0, zzctVar.zzg() * i);
        byteBuffer.position(((i + i) * zzctVar.zzg()) + byteBuffer.position());
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
