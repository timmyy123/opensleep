package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafi {
    public static final zzafi zza = new zzafi(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzafi(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzafi zza(long j, long j2) {
        return new zzafi(-1, j, j2);
    }

    public static zzafi zzb(long j, long j2) {
        return new zzafi(-2, j, j2);
    }

    public static zzafi zzc(long j) {
        return new zzafi(0, -9223372036854775807L, j);
    }

    public final /* synthetic */ int zzd() {
        return this.zzb;
    }

    public final /* synthetic */ long zze() {
        return this.zzc;
    }

    public final /* synthetic */ long zzf() {
        return this.zzd;
    }
}
