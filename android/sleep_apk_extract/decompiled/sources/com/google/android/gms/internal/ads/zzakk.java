package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzakk extends zzafo implements zzakt {
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;

    private zzakk(long j, long j2, int i, int i2, boolean z, boolean z2) {
        super(j, j2, i, i2, false, z2);
        this.zza = j2;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j == -1 ? -1L : j;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j) {
        return zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zzb;
    }

    public final zzakk zzi(long j) {
        return new zzakk(j, this.zza, this.zzb, this.zzc, false, false);
    }

    public zzakk(long j, long j2, int i, int i2, boolean z) {
        this(j, j2, i, i2, false, true);
    }

    public zzakk(long j, long j2, zzagv zzagvVar, boolean z) {
        this(j, j2, zzagvVar.zzf, zzagvVar.zzc, false, true);
    }
}
