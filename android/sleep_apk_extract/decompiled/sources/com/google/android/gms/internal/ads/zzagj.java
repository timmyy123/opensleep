package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagj implements zzahb {
    private final zzagl zza;
    private final long zzb;

    public zzagj(zzagl zzaglVar, long j) {
        this.zza = zzaglVar;
        this.zzb = j;
    }

    private final zzahc zze(long j, long j2) {
        return new zzahc((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzagl zzaglVar = this.zza;
        zzagk zzagkVar = zzaglVar.zzk;
        zzagkVar.getClass();
        long jZzb = zzaglVar.zzb(j);
        long[] jArr = zzagkVar.zza;
        int iZzo = zzfl.zzo(jArr, jZzb, true, false);
        long j2 = iZzo == -1 ? 0L : jArr[iZzo];
        long[] jArr2 = zzagkVar.zzb;
        zzahc zzahcVarZze = zze(j2, iZzo != -1 ? jArr2[iZzo] : 0L);
        if (zzahcVarZze.zzb == j || iZzo == jArr.length - 1) {
            return new zzagz(zzahcVarZze, zzahcVarZze);
        }
        int i = iZzo + 1;
        return new zzagz(zzahcVarZze, zze(jArr[i], jArr2[i]));
    }
}
