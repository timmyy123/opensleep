package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzakw implements zzakt {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzakw(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = i2;
        this.zze = j3;
        this.zzg = jArr;
        this.zzf = j3 != -1 ? j + j3 : -1L;
    }

    public static zzakw zze(zzakv zzakvVar, long j) {
        long jZzb = zzakvVar.zzb();
        if (jZzb == -9223372036854775807L) {
            return null;
        }
        zzagv zzagvVar = zzakvVar.zza;
        return new zzakw(j, zzagvVar.zzc, jZzb, zzagvVar.zzf, zzakvVar.zzc, zzakvVar.zzg);
    }

    private final long zzi(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zzg != null;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        if (!zzb()) {
            zzahc zzahcVar = new zzahc(0L, this.zza + ((long) this.zzb));
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j2 = this.zzc;
        String str = zzfl.zza;
        long jMax = Math.max(0L, Math.min(j, j2));
        double d = (jMax * 100.0d) / j2;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.zzg;
                jArr.getClass();
                double d3 = jArr[i];
                d2 = (((i == 99 ? 256.0d : jArr[i + 1]) - d3) * (d - ((double) i))) + d3;
            }
        }
        long j3 = this.zze;
        zzahc zzahcVar2 = new zzahc(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d2 / 256.0d) * j3), j3 - 1)));
        return new zzagz(zzahcVar2, zzahcVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j) {
        if (!zzb()) {
            return 0L;
        }
        long j2 = j - this.zza;
        if (j2 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        jArr.getClass();
        double d = (j2 * 256.0d) / this.zze;
        int iZzo = zzfl.zzo(jArr, (long) d, true, true);
        long jZzi = zzi(iZzo);
        long j3 = jArr[iZzo];
        int i = iZzo + 1;
        long jZzi2 = zzi(i);
        return Math.round((j3 == (iZzo == 99 ? 256L : jArr[i]) ? 0.0d : (d - j3) / (r0 - j3)) * (jZzi2 - jZzi)) + jZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zzd;
    }
}
