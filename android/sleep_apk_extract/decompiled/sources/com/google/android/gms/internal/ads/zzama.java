package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzama implements zzahb {
    private final long zza;
    private final zzamb[] zzb;
    private final int zzc;

    public zzama(long j, zzamb[] zzambVarArr, int i) {
        this.zza = j;
        this.zzb = zzambVarArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        long j2;
        long j3;
        long j4;
        int iZzb;
        long j5 = j;
        zzamb[] zzambVarArr = this.zzb;
        if (zzambVarArr.length == 0) {
            zzahc zzahcVar = zzahc.zza;
            return new zzagz(zzahcVar, zzahcVar);
        }
        int i = this.zzc;
        if (i != -1) {
            zzaml zzamlVar = zzambVarArr[i].zzb;
            int iZzl = zzamc.zzl(zzamlVar, j5);
            if (iZzl == -1) {
                zzahc zzahcVar2 = zzahc.zza;
                return new zzagz(zzahcVar2, zzahcVar2);
            }
            long[] jArr = zzamlVar.zzf;
            long j6 = jArr[iZzl];
            long[] jArr2 = zzamlVar.zzc;
            j2 = jArr2[iZzl];
            if (j6 >= j5 || iZzl >= zzamlVar.zzb - 1 || (iZzb = zzamlVar.zzb(j5)) == -1 || iZzb == iZzl) {
                j3 = -9223372036854775807L;
                j4 = -1;
            } else {
                j3 = jArr[iZzb];
                j4 = jArr2[iZzb];
            }
            j5 = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
            j4 = -1;
        }
        long jZzh = j2;
        long jZzh2 = j4;
        for (int i2 = 0; i2 < zzambVarArr.length; i2++) {
            if (i2 != i) {
                zzaml zzamlVar2 = zzambVarArr[i2].zzb;
                jZzh = zzamc.zzh(zzamlVar2, j5, jZzh);
                if (j3 != -9223372036854775807L) {
                    jZzh2 = zzamc.zzh(zzamlVar2, j3, jZzh2);
                }
            }
        }
        zzahc zzahcVar3 = new zzahc(j5, jZzh);
        return j3 == -9223372036854775807L ? new zzagz(zzahcVar3, zzahcVar3) : new zzagz(zzahcVar3, new zzahc(j3, jZzh2));
    }
}
