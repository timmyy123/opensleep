package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzakv {
    public final zzagv zza;
    public final long zzb;
    public final long zzc;
    public final zzakr zzd;
    public final int zze;
    public final int zzf;
    public final long[] zzg;

    private zzakv(zzagv zzagvVar, long j, long j2, long[] jArr, zzakr zzakrVar, int i, int i2) {
        this.zza = new zzagv(zzagvVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzg = jArr;
        this.zzd = zzakrVar;
        this.zze = i;
        this.zzf = i2;
    }

    public static zzakv zza(zzagv zzagvVar, zzet zzetVar) {
        long[] jArr;
        int i;
        int i2;
        int iZzB = zzetVar.zzB();
        int iZzH = (iZzB & 1) != 0 ? zzetVar.zzH() : -1;
        long jZzz = (iZzB & 2) != 0 ? zzetVar.zzz() : -1L;
        zzakr zzakrVarZzb = null;
        if ((iZzB & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = zzetVar.zzs();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzB & 8) != 0) {
            zzetVar.zzk(4);
        }
        if (zzetVar.zzd() >= 24) {
            zzetVar.zzk(11);
            zzakrVarZzb = zzakr.zzb(Float.intBitsToFloat(zzetVar.zzB()), zzetVar.zzt(), zzetVar.zzt());
            zzetVar.zzk(2);
            int iZzx = zzetVar.zzx();
            i2 = iZzx & 4095;
            i = iZzx >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzakv(zzagvVar, iZzH, jZzz, jArr, zzakrVarZzb, i, i2);
    }

    public final long zzb() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        return zzfl.zzt((j * ((long) r6.zzg)) - 1, this.zza.zzd);
    }
}
