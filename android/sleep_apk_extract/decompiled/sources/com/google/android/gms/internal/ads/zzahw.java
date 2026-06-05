package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzahw {
    private final zzahv zza;
    private final zzahk zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long[] zzm;
    private int[] zzn;

    public zzahw(int i, zzahv zzahvVar, zzahk zzahkVar) {
        this.zza = zzahvVar;
        int iZzc = zzahvVar.zzc();
        boolean z = true;
        if (iZzc != 1) {
            if (iZzc == 2) {
                iZzc = 2;
            } else {
                z = false;
            }
        }
        zzgtj.zza(z);
        this.zzc = zzj(i, iZzc == 2 ? 1667497984 : 1651965952);
        this.zze = zzahvVar.zzd();
        this.zzb = zzahkVar;
        this.zzd = iZzc == 2 ? zzj(i, 1650720768) : -1;
        this.zzl = -1L;
        this.zzm = new long[512];
        this.zzn = new int[512];
        this.zzf = zzahvVar.zzd;
    }

    private final long zzh(int i) {
        return (this.zze * ((long) i)) / ((long) this.zzf);
    }

    private final zzahc zzi(int i) {
        return new zzahc(((long) this.zzn[i]) * zzh(1), this.zzm[i]);
    }

    private static int zzj(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    public final void zza(long j, boolean z) {
        if (this.zzl == -1) {
            this.zzl = j;
        }
        if (z) {
            if (this.zzk == this.zzn.length) {
                long[] jArr = this.zzm;
                this.zzm = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzn;
                this.zzn = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzm;
            int i = this.zzk;
            jArr2[i] = j;
            this.zzn[i] = this.zzj;
            this.zzk = i + 1;
        }
        this.zzj++;
    }

    public final void zzb() {
        int i;
        this.zzm = Arrays.copyOf(this.zzm, this.zzk);
        this.zzn = Arrays.copyOf(this.zzn, this.zzk);
        if ((this.zzc & 1651965952) != 1651965952 || this.zza.zzf == 0 || (i = this.zzk) <= 0) {
            return;
        }
        this.zzf = i;
    }

    public final boolean zzc(int i) {
        return this.zzc == i || this.zzd == i;
    }

    public final void zzd(int i) {
        this.zzg = i;
        this.zzh = i;
    }

    public final boolean zze(zzafz zzafzVar) {
        int i = this.zzh;
        zzahk zzahkVar = this.zzb;
        int iZza = i - zzahkVar.zza(zzafzVar, i, false);
        this.zzh = iZza;
        boolean z = iZza == 0;
        if (z) {
            if (this.zzg > 0) {
                zzahkVar.zze(zzh(this.zzi), Arrays.binarySearch(this.zzn, this.zzi) >= 0 ? 1 : 0, this.zzg, 0, null);
            }
            this.zzi++;
        }
        return z;
    }

    public final void zzf(long j) {
        if (this.zzk == 0) {
            this.zzi = 0;
        } else {
            this.zzi = this.zzn[zzfl.zzo(this.zzm, j, true, true)];
        }
    }

    public final zzagz zzg(long j) {
        if (this.zzk == 0) {
            zzahc zzahcVar = new zzahc(0L, this.zzl);
            return new zzagz(zzahcVar, zzahcVar);
        }
        int iZzh = (int) (j / zzh(1));
        int iZzn = zzfl.zzn(this.zzn, iZzh, true, true);
        if (this.zzn[iZzn] == iZzh) {
            zzahc zzahcVarZzi = zzi(iZzn);
            return new zzagz(zzahcVarZzi, zzahcVarZzi);
        }
        zzahc zzahcVarZzi2 = zzi(iZzn);
        int i = iZzn + 1;
        return i < this.zzm.length ? new zzagz(zzahcVarZzi2, zzi(i)) : new zzagz(zzahcVarZzi2, zzahcVarZzi2);
    }
}
