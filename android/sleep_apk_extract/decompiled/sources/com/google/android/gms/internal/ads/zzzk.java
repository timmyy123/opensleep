package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzzk implements zzxi, zzxh {
    private final zzxi zza;
    private final long zzb;
    private zzxh zzc;

    public zzzk(zzxi zzxiVar, long j) {
        this.zza = zzxiVar;
        this.zzb = j;
    }

    public final zzxi zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j) {
        this.zzc = zzxhVar;
        this.zza.zzb(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j) {
        zzzc[] zzzcVarArr2 = new zzzc[zzzcVarArr.length];
        int i = 0;
        while (true) {
            zzzc zzzcVarZza = null;
            if (i >= zzzcVarArr.length) {
                break;
            }
            zzzj zzzjVar = (zzzj) zzzcVarArr[i];
            if (zzzjVar != null) {
                zzzcVarZza = zzzjVar.zza();
            }
            zzzcVarArr2[i] = zzzcVarZza;
            i++;
        }
        zzxi zzxiVar = this.zza;
        long j2 = this.zzb;
        long jZze = zzxiVar.zze(zzabaVarArr, zArr, zzzcVarArr2, zArr2, j - j2);
        for (int i2 = 0; i2 < zzzcVarArr.length; i2++) {
            zzzc zzzcVar = zzzcVarArr2[i2];
            if (zzzcVar == null) {
                zzzcVarArr[i2] = null;
            } else {
                zzzc zzzcVar2 = zzzcVarArr[i2];
                if (zzzcVar2 == null || ((zzzj) zzzcVar2).zza() != zzzcVar) {
                    zzzcVarArr[i2] = new zzzj(zzzcVar, j2);
                }
            }
        }
        return jZze + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j, boolean z) {
        this.zza.zzf(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j) {
        this.zza.zzg(j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        long jZzh = this.zza.zzh();
        if (jZzh == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzh + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzi + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j) {
        long j2 = this.zzb;
        return this.zza.zzj(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j, zzni zzniVar) {
        long j2 = this.zzb;
        return this.zza.zzk(j - j2, zzniVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzl + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        long j = zzmaVar.zza;
        long j2 = this.zzb;
        zzlz zzlzVarZza = zzmaVar.zza();
        zzlzVarZza.zza(j - j2);
        return this.zza.zzm(zzlzVarZza.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzp(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}
