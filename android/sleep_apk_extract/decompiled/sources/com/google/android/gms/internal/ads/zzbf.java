package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbf {
    public static final zzbf zza = new zzbc();

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    public final boolean equals(Object obj) {
        int iZzj;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        zzbf zzbfVar = (zzbf) obj;
        if (zzbfVar.zza() == zza() && zzbfVar.zzc() == zzc()) {
            zzbe zzbeVar = new zzbe();
            zzbd zzbdVar = new zzbd();
            zzbe zzbeVar2 = new zzbe();
            zzbd zzbdVar2 = new zzbd();
            for (int i = 0; i < zza(); i++) {
                if (!zzb(i, zzbeVar, 0L).equals(zzbfVar.zzb(i, zzbeVar2, 0L))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzc(); i2++) {
                if (!zzd(i2, zzbdVar, true).equals(zzbfVar.zzd(i2, zzbdVar2, true))) {
                    return false;
                }
            }
            int iZzk = zzk(true);
            if (iZzk == zzbfVar.zzk(true) && (iZzj = zzj(true)) == zzbfVar.zzj(true)) {
                while (iZzk != iZzj) {
                    int iZzh = zzh(iZzk, 0, true);
                    if (iZzh != zzbfVar.zzh(iZzk, 0, true)) {
                        return false;
                    }
                    iZzk = iZzh;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        int iZza = zza() + 217;
        int i2 = 0;
        while (true) {
            i = iZza * 31;
            if (i2 >= zza()) {
                break;
            }
            iZza = i + zzb(i2, zzbeVar, 0L).hashCode();
            i2++;
        }
        int iZzc = zzc() + i;
        for (int i3 = 0; i3 < zzc(); i3++) {
            iZzc = (iZzc * 31) + zzd(i3, zzbdVar, true).hashCode();
        }
        int iZzk = zzk(true);
        while (iZzk != -1) {
            iZzc = (iZzc * 31) + iZzk;
            iZzk = zzh(iZzk, 0, true);
        }
        return iZzc;
    }

    public abstract int zza();

    public abstract zzbe zzb(int i, zzbe zzbeVar, long j);

    public abstract int zzc();

    public abstract zzbd zzd(int i, zzbd zzbdVar, boolean z);

    public abstract int zze(Object obj);

    public abstract Object zzf(int i);

    public final boolean zzg() {
        return zza() == 0;
    }

    public int zzh(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == zzj(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == zzj(z) ? zzk(z) : i + 1;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return 0;
    }

    public int zzi(int i, int i2, boolean z) {
        if (i == zzk(false)) {
            return -1;
        }
        return i - 1;
    }

    public int zzj(boolean z) {
        if (zzg()) {
            return -1;
        }
        return zza() - 1;
    }

    public int zzk(boolean z) {
        return zzg() ? -1 : 0;
    }

    public final int zzl(int i, zzbd zzbdVar, zzbe zzbeVar, int i2, boolean z) {
        int i3 = zzd(i, zzbdVar, false).zzc;
        if (zzb(i3, zzbeVar, 0L).zzo != i) {
            return i + 1;
        }
        int iZzh = zzh(i3, i2, z);
        if (iZzh == -1) {
            return -1;
        }
        return zzb(iZzh, zzbeVar, 0L).zzn;
    }

    public final Pair zzm(zzbe zzbeVar, zzbd zzbdVar, int i, long j) {
        Pair pairZzn = zzn(zzbeVar, zzbdVar, i, j, 0L);
        pairZzn.getClass();
        return pairZzn;
    }

    public final Pair zzn(zzbe zzbeVar, zzbd zzbdVar, int i, long j, long j2) {
        zzgtj.zzm(i, zza(), "index");
        zzb(i, zzbeVar, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzbeVar.zzl;
            j = 0;
        }
        int i2 = zzbeVar.zzn;
        zzd(i2, zzbdVar, false);
        while (i2 < zzbeVar.zzo) {
            long j4 = zzbdVar.zze;
            if (j == 0) {
                break;
            }
            int i3 = i2 + 1;
            long j5 = zzd(i3, zzbdVar, false).zze;
            if (j < 0) {
                break;
            }
            i2 = i3;
        }
        zzd(i2, zzbdVar, true);
        long j6 = zzbdVar.zze;
        long j7 = zzbdVar.zzd;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long jMax = Math.max(0L, j);
        Object obj = zzbdVar.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzbd zzo(Object obj, zzbd zzbdVar) {
        return zzd(zze(obj), zzbdVar, true);
    }
}
