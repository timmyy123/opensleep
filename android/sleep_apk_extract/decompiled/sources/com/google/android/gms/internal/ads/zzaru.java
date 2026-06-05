package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class zzaru implements zzahb {
    private final zzarr zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaru(zzarr zzarrVar, int i, long j, long j2) {
        this.zza = zzarrVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzarrVar.zzd);
        this.zzd = j3;
        this.zze = zze(j3);
    }

    private final long zze(long j) {
        return zzfl.zzv(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        long j2 = this.zzb;
        zzarr zzarrVar = this.zza;
        long j3 = (((long) zzarrVar.zzc) * j) / (j2 * 1000000);
        String str = zzfl.zza;
        long j4 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j3, j4));
        long j5 = zzarrVar.zzd;
        long jZze = zze(jMax);
        long j6 = this.zzc;
        zzahc zzahcVar = new zzahc(jZze, (jMax * j5) + j6);
        if (jZze >= j || jMax == j4) {
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j7 = jMax + 1;
        return new zzagz(zzahcVar, new zzahc(zze(j7), (j5 * j7) + j6));
    }
}
