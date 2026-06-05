package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
public final class zztt implements zztj {
    public zztt(zzts zztsVar) {
    }

    public static int zza(int i, int i2, int i3) {
        return zzhah.zza(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    public static final int zzb(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 250000;
        if (i3 == 0) {
            int iZza = zza(250000, i5, i4);
            int iZza2 = zza(750000, i5, i4);
            String str = zzfl.zza;
            return Math.max(iZza, Math.min(i * 4, iZza2));
        }
        if (i3 == 1) {
            return zzhah.zza((((long) zzc(i2)) * 50000000) / 1000000);
        }
        if (i2 == 5) {
            i7 = 500000;
        } else if (i2 == 8) {
            i7 = 1000000;
            i2 = 8;
        }
        return zzhah.zza((((long) i7) * ((long) (i6 != -1 ? zzgzz.zzb(i6, 8, RoundingMode.CEILING) : zzc(i2)))) / 1000000);
    }

    private static int zzc(int i) {
        int iZzf = zzagc.zzf(i);
        zzgtj.zzi(iZzf != -2147483647);
        return iZzf;
    }
}
