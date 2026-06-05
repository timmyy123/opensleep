package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafp implements zzafz {
    private final zzj zzb;
    private final long zzc;
    private long zzd;
    private int zzf;
    private int zzg;
    private byte[] zze = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
    private final byte[] zza = new byte[4096];

    static {
        zzal.zzb("media3.extractor");
    }

    public zzafp(zzj zzjVar, long j, long j2) {
        this.zzb = zzjVar;
        this.zzd = j;
        this.zzc = j2;
    }

    private final void zzp(int i) {
        int i2 = this.zzf + i;
        int length = this.zze.length;
        if (i2 > length) {
            String str = zzfl.zza;
            this.zze = Arrays.copyOf(this.zze, Math.max(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i2, Math.min(length + length, i2 + 524288)));
        }
    }

    private final int zzq(int i) {
        int iMin = Math.min(this.zzg, i);
        zzs(iMin);
        return iMin;
    }

    private final int zzr(byte[] bArr, int i, int i2) {
        int i3 = this.zzg;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.zze, 0, bArr, i, iMin);
        zzs(iMin);
        return iMin;
    }

    private final void zzs(int i) {
        int i2 = this.zzg - i;
        this.zzg = i2;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i2 < bArr.length + (-524288) ? new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.zze = bArr2;
    }

    private final int zzt(byte[] bArr, int i, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iZza = this.zzb.zza(bArr, i + i3, i2 - i3);
        if (iZza != -1) {
            return i3 + iZza;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2();
        return 0;
    }

    private final void zzu(int i) {
        if (i != -1) {
            this.zzd += (long) i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        zzafp zzafpVar;
        int iZzr = zzr(bArr, i, i2);
        if (iZzr == 0) {
            zzafpVar = this;
            iZzr = zzafpVar.zzt(bArr, i, i2, 0, true);
        } else {
            zzafpVar = this;
        }
        zzafpVar.zzu(iZzr);
        return iZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zzb(byte[] bArr, int i, int i2, boolean z) throws EOFException, InterruptedIOException {
        int iZzr = zzr(bArr, i, i2);
        while (iZzr < i2 && iZzr != -1) {
            iZzr = zzt(bArr, i, i2, iZzr, z);
        }
        zzu(iZzr);
        return iZzr != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzc(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        zzb(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final int zzd(int i) throws EOFException, InterruptedIOException {
        zzafp zzafpVar;
        int iZzq = zzq(1);
        if (iZzq == 0) {
            zzafpVar = this;
            iZzq = zzafpVar.zzt(this.zza, 0, Math.min(1, 4096), 0, true);
        } else {
            zzafpVar = this;
        }
        zzafpVar.zzu(iZzq);
        return iZzq;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zze(int i, boolean z) throws EOFException, InterruptedIOException {
        int iZzq = zzq(i);
        while (iZzq < i && iZzq != -1) {
            iZzq = zzt(this.zza, -iZzq, Math.min(i, iZzq + 4096), iZzq, z);
        }
        zzu(iZzq);
        return iZzq != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzf(int i) throws EOFException, InterruptedIOException {
        zze(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final int zzg(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        zzafp zzafpVar;
        int iMin;
        zzp(i2);
        int i3 = this.zzg;
        int i4 = this.zzf;
        int i5 = i3 - i4;
        if (i5 == 0) {
            zzafpVar = this;
            iMin = zzafpVar.zzt(this.zze, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            zzafpVar.zzg += iMin;
        } else {
            zzafpVar = this;
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(zzafpVar.zze, zzafpVar.zzf, bArr, i, iMin);
        zzafpVar.zzf += iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zzh(byte[] bArr, int i, int i2, boolean z) {
        if (!zzj(i2, z)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzi(byte[] bArr, int i, int i2) {
        zzh(bArr, i, i2, false);
    }

    public final boolean zzj(int i, boolean z) throws EOFException, InterruptedIOException {
        zzp(i);
        int iZzt = this.zzg - this.zzf;
        while (iZzt < i) {
            zzafp zzafpVar = this;
            int i2 = i;
            boolean z2 = z;
            iZzt = zzafpVar.zzt(this.zze, this.zzf, i2, iZzt, z2);
            if (iZzt == -1) {
                return false;
            }
            zzafpVar.zzg = zzafpVar.zzf + iZzt;
            this = zzafpVar;
            i = i2;
            z = z2;
        }
        this.zzf += i;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzk(int i) throws EOFException, InterruptedIOException {
        zzj(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzl() {
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzm() {
        return this.zzd + ((long) this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzn() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzo() {
        return this.zzc;
    }
}
