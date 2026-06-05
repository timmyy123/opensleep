package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagu implements zzahb {
    private final zzeh zza;
    private final zzeh zzb;
    private long zzc;

    public zzagu(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzgtj.zza(length == length2);
        if (length2 <= 0 || jArr2[0] <= 0) {
            this.zza = new zzeh(length2);
            this.zzb = new zzeh(length2);
        } else {
            int i = length2 + 1;
            zzeh zzehVar = new zzeh(i);
            this.zza = zzehVar;
            zzeh zzehVar2 = new zzeh(i);
            this.zzb = zzehVar2;
            zzehVar.zza(0L);
            zzehVar2.zza(0L);
        }
        this.zza.zzb(jArr);
        this.zzb.zzb(jArr2);
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zzb.zzd() > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzeh zzehVar = this.zzb;
        if (zzehVar.zzd() == 0) {
            zzahc zzahcVar = zzahc.zza;
            return new zzagz(zzahcVar, zzahcVar);
        }
        int iZzp = zzfl.zzp(zzehVar, j, true, true);
        long jZzc = zzehVar.zzc(iZzp);
        zzeh zzehVar2 = this.zza;
        zzahc zzahcVar2 = new zzahc(jZzc, zzehVar2.zzc(iZzp));
        if (zzahcVar2.zzb == j || iZzp == zzehVar.zzd() - 1) {
            return new zzagz(zzahcVar2, zzahcVar2);
        }
        int i = iZzp + 1;
        return new zzagz(zzahcVar2, new zzahc(zzehVar.zzc(i), zzehVar2.zzc(i)));
    }
}
