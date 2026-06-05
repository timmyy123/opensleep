package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzyw {
    private final zzabl zza;
    private final zzet zzb = new zzet(32);
    private zzyv zzc;
    private zzyv zzd;
    private zzyv zze;
    private long zzf;

    public zzyw(zzabl zzablVar) {
        this.zza = zzablVar;
        zzyv zzyvVar = new zzyv(0L, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.zzc = zzyvVar;
        this.zzd = zzyvVar;
        this.zze = zzyvVar;
    }

    private final int zzi(int i) {
        zzyv zzyvVar = this.zze;
        if (zzyvVar.zzc == null) {
            zzabj zzabjVarZza = this.zza.zza();
            zzyv zzyvVar2 = new zzyv(this.zze.zzb, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            zzyvVar.zzc = zzabjVarZza;
            zzyvVar.zzd = zzyvVar2;
        }
        return Math.min(i, (int) (this.zze.zzb - this.zzf));
    }

    private final void zzj(int i) {
        long j = this.zzf + ((long) i);
        this.zzf = j;
        zzyv zzyvVar = this.zze;
        if (j == zzyvVar.zzb) {
            this.zze = zzyvVar.zzd;
        }
    }

    private static zzyv zzk(zzyv zzyvVar, zziv zzivVar, zzyx zzyxVar, zzet zzetVar) {
        zzyv zzyvVarZzm;
        if (zzivVar.zzk()) {
            long j = zzyxVar.zzb;
            int iZzt = 1;
            zzetVar.zza(1);
            zzyv zzyvVarZzm2 = zzm(zzyvVar, j, zzetVar.zzi(), 1);
            long j2 = j + 1;
            byte b = zzetVar.zzi()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzis zzisVar = zzivVar.zzb;
            byte[] bArr = zzisVar.zza;
            if (bArr == null) {
                zzisVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzyvVarZzm = zzm(zzyvVarZzm2, j2, zzisVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzetVar.zza(2);
                zzyvVarZzm = zzm(zzyvVarZzm, j3, zzetVar.zzi(), 2);
                j3 += 2;
                iZzt = zzetVar.zzt();
            }
            int i3 = iZzt;
            int[] iArr = zzisVar.zzd;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzisVar.zze;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                zzetVar.zza(i4);
                zzyvVarZzm = zzm(zzyvVarZzm, j3, zzetVar.zzi(), i4);
                j3 += (long) i4;
                zzetVar.zzh(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = zzetVar.zzt();
                    iArr4[i5] = zzetVar.zzH();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzyxVar.zza - ((int) (j3 - zzyxVar.zzb));
            }
            zzahj zzahjVar = zzyxVar.zzc;
            String str = zzfl.zza;
            zzisVar.zza(i3, iArr2, iArr4, zzahjVar.zzb, zzisVar.zza, zzahjVar.zza, zzahjVar.zzc, zzahjVar.zzd);
            long j4 = zzyxVar.zzb;
            int i6 = (int) (j3 - j4);
            zzyxVar.zzb = j4 + ((long) i6);
            zzyxVar.zza -= i6;
        } else {
            zzyvVarZzm = zzyvVar;
        }
        if (!zzivVar.zze()) {
            zzivVar.zzj(zzyxVar.zza);
            return zzl(zzyvVarZzm, zzyxVar.zzb, zzivVar.zzc, zzyxVar.zza);
        }
        zzetVar.zza(4);
        zzyv zzyvVarZzm3 = zzm(zzyvVarZzm, zzyxVar.zzb, zzetVar.zzi(), 4);
        int iZzH = zzetVar.zzH();
        zzyxVar.zzb += 4;
        zzyxVar.zza -= 4;
        zzivVar.zzj(iZzH);
        zzyv zzyvVarZzl = zzl(zzyvVarZzm3, zzyxVar.zzb, zzivVar.zzc, iZzH);
        zzyxVar.zzb += (long) iZzH;
        int i7 = zzyxVar.zza - iZzH;
        zzyxVar.zza = i7;
        ByteBuffer byteBuffer = zzivVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            zzivVar.zzf = ByteBuffer.allocate(i7);
        } else {
            zzivVar.zzf.clear();
        }
        return zzl(zzyvVarZzl, zzyxVar.zzb, zzivVar.zzf, zzyxVar.zza);
    }

    private static zzyv zzl(zzyv zzyvVar, long j, ByteBuffer byteBuffer, int i) {
        zzyv zzyvVarZzn = zzn(zzyvVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzyvVarZzn.zzb - j));
            byteBuffer.put(zzyvVarZzn.zzc.zza, zzyvVarZzn.zzb(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzyvVarZzn.zzb) {
                zzyvVarZzn = zzyvVarZzn.zzd;
            }
        }
        return zzyvVarZzn;
    }

    private static zzyv zzm(zzyv zzyvVar, long j, byte[] bArr, int i) {
        zzyv zzyvVarZzn = zzn(zzyvVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzyvVarZzn.zzb - j));
            System.arraycopy(zzyvVarZzn.zzc.zza, zzyvVarZzn.zzb(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzyvVarZzn.zzb) {
                zzyvVarZzn = zzyvVarZzn.zzd;
            }
        }
        return zzyvVarZzn;
    }

    private static zzyv zzn(zzyv zzyvVar, long j) {
        while (j >= zzyvVar.zzb) {
            zzyvVar = zzyvVar.zzd;
        }
        return zzyvVar;
    }

    public final void zza() {
        zzyv zzyvVar = this.zzc;
        if (zzyvVar.zzc != null) {
            this.zza.zzc(zzyvVar);
            zzyvVar.zzc();
        }
        this.zzc.zza(0L, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        zzyv zzyvVar2 = this.zzc;
        this.zzd = zzyvVar2;
        this.zze = zzyvVar2;
        this.zzf = 0L;
        this.zza.zzd();
    }

    public final void zzb() {
        this.zzd = this.zzc;
    }

    public final void zzc(zziv zzivVar, zzyx zzyxVar) {
        this.zzd = zzk(this.zzd, zzivVar, zzyxVar, this.zzb);
    }

    public final void zzd(zziv zzivVar, zzyx zzyxVar) {
        zzk(this.zzd, zzivVar, zzyxVar, this.zzb);
    }

    public final void zze(long j) {
        zzyv zzyvVar;
        if (j != -1) {
            while (true) {
                zzyvVar = this.zzc;
                if (j < zzyvVar.zzb) {
                    break;
                }
                this.zza.zzb(zzyvVar.zzc);
                this.zzc = this.zzc.zzc();
            }
            if (this.zzd.zza < zzyvVar.zza) {
                this.zzd = zzyvVar;
            }
        }
    }

    public final long zzf() {
        return this.zzf;
    }

    public final int zzg(zzj zzjVar, int i, boolean z) throws EOFException {
        int iZzi = zzi(i);
        zzyv zzyvVar = this.zze;
        int iZza = zzjVar.zza(zzyvVar.zzc.zza, zzyvVar.zzb(this.zzf), iZzi);
        if (iZza != -1) {
            zzj(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2();
        return 0;
    }

    public final void zzh(zzet zzetVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzyv zzyvVar = this.zze;
            zzetVar.zzm(zzyvVar.zzc.zza, zzyvVar.zzb(this.zzf), iZzi);
            i -= iZzi;
            zzj(iZzi);
        }
    }
}
