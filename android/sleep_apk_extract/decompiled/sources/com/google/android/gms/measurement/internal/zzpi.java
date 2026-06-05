package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzpi {
    private long zza;
    private com.google.android.gms.internal.measurement.zzib zzb;
    private String zzc;
    private Map zzd;
    private zzls zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private int zzi;

    public final zzpj zza() {
        return new zzpj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, null);
    }

    public final zzpi zzb(long j) {
        this.zza = j;
        return this;
    }

    public final zzpi zzc(com.google.android.gms.internal.measurement.zzib zzibVar) {
        this.zzb = zzibVar;
        return this;
    }

    public final zzpi zzd(String str) {
        this.zzc = str;
        return this;
    }

    public final zzpi zze(Map map) {
        this.zzd = map;
        return this;
    }

    public final zzpi zzf(zzls zzlsVar) {
        this.zze = zzlsVar;
        return this;
    }

    public final zzpi zzg(long j) {
        this.zzf = j;
        return this;
    }

    public final zzpi zzh(long j) {
        this.zzg = j;
        return this;
    }

    public final zzpi zzi(long j) {
        this.zzh = j;
        return this;
    }

    public final zzpi zzj(int i) {
        this.zzi = i;
        return this;
    }
}
