package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzamp implements zzamv {
    private final zzagl zza;
    private final zzagk zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzamp(zzagl zzaglVar, zzagk zzagkVar) {
        this.zza = zzaglVar;
        this.zzb = zzagkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final long zza(zzafz zzafzVar) {
        long j = this.zzd;
        if (j < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfl.zzo(jArr, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzahb zzc() {
        zzgtj.zzi(this.zzc != -1);
        return new zzagj(this.zza, this.zzc);
    }

    public final void zzd(long j) {
        this.zzc = j;
    }
}
