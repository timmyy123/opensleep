package com.google.android.gms.internal.ads;

import android.util.Range;

/* JADX INFO: loaded from: classes3.dex */
final class zzadv {
    private long zza;
    private long zzb;
    private double zzc;
    private Range zzd;

    public zzadv(float f) {
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d));
        this.zzd = range;
        this.zzc = ((Double) range.getUpper()).doubleValue();
        this.zza = -9223372036854775807L;
        this.zzb = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(long j, long j2) {
        double dDoubleValue;
        zzgtj.zza(j != -9223372036854775807L);
        zzgtj.zza(j2 != -9223372036854775807L);
        long j3 = this.zza;
        if (j3 != -9223372036854775807L) {
            dDoubleValue = (this.zzb == -9223372036854775807L || j == j3) ? ((Double) this.zzd.getUpper()).doubleValue() : (j2 - r4) / (j - j3);
        }
        this.zzc = (((Double) this.zzd.clamp(Double.valueOf(dDoubleValue))).doubleValue() * 0.20000000298023224d) + (this.zzc * 0.800000011920929d);
        this.zza = j;
        this.zzb = j2;
    }

    public final long zzb(long j) {
        long j2 = this.zza;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (long) (((j - j2) * this.zzc) + this.zzb);
    }

    public final void zzc(float f) {
        zzgtj.zza(f > 0.0f);
        this.zzd = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / ((double) f)));
        zzd();
    }

    public final void zzd() {
        this.zzc = ((Double) this.zzd.getUpper()).doubleValue();
        this.zza = -9223372036854775807L;
        this.zzb = -9223372036854775807L;
    }
}
