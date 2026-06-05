package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzwo implements zzxi, zzxh {
    public final zzxi zza;
    long zzb;
    private zzxh zzc;
    private zzwn[] zzd = new zzwn[0];
    private long zze = 0;
    private long zzf = -9223372036854775807L;

    public zzwo(zzxi zzxiVar, boolean z, long j, long j2) {
        this.zza = zzxiVar;
        this.zzb = j2;
    }

    private static long zzt(long j, long j2, long j3) {
        long jMax = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    public final void zza(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j) {
        this.zzc = zzxhVar;
        this.zza.zzb(this, j);
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
        int length = zzzcVarArr.length;
        this.zzd = new zzwn[length];
        zzzc[] zzzcVarArr2 = new zzzc[length];
        int i = 0;
        while (true) {
            zzzc zzzcVar = null;
            if (i >= zzzcVarArr.length) {
                break;
            }
            zzwn[] zzwnVarArr = this.zzd;
            zzwn zzwnVar = (zzwn) zzzcVarArr[i];
            zzwnVarArr[i] = zzwnVar;
            if (zzwnVar != null) {
                zzzcVar = zzwnVar.zza;
            }
            zzzcVarArr2[i] = zzzcVar;
            i++;
        }
        long jZze = this.zza.zze(zzabaVarArr, zArr, zzzcVarArr2, zArr2, j);
        long jZzt = zzt(jZze, j, this.zzb);
        long j2 = -9223372036854775807L;
        if (zzo()) {
            if (jZze < j) {
                j2 = jZzt;
                break;
            }
            if (jZze != 0) {
                for (zzaba zzabaVar : zzabaVarArr) {
                    if (zzabaVar != null) {
                        zzv zzvVarZzc = zzabaVar.zzc();
                        if (!zzas.zzd(zzvVarZzc.zzp, zzvVarZzc.zzk)) {
                            j2 = jZzt;
                            break;
                        }
                    }
                }
            }
        }
        this.zze = j2;
        for (int i2 = 0; i2 < zzzcVarArr.length; i2++) {
            zzzc zzzcVar2 = zzzcVarArr2[i2];
            zzwn[] zzwnVarArr2 = this.zzd;
            if (zzzcVar2 == null) {
                zzwnVarArr2[i2] = null;
            } else {
                zzwn zzwnVar2 = zzwnVarArr2[i2];
                if (zzwnVar2 == null || zzwnVar2.zza != zzzcVar2) {
                    zzwnVarArr2[i2] = new zzwn(this, zzzcVar2);
                }
            }
            zzzcVarArr[i2] = this.zzd[i2];
        }
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j, boolean z) {
        this.zza.zzf(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        if (zzo()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            this.zzf = j;
            long jZzh = zzh();
            return jZzh != -9223372036854775807L ? jZzh : j;
        }
        long jZzh2 = this.zza.zzh();
        if (jZzh2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jZzt = zzt(jZzh2, 0L, this.zzb);
        if (jZzt == this.zzf) {
            return -9223372036854775807L;
        }
        this.zzf = jZzt;
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzi < j) {
                return jZzi;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j) {
        this.zze = -9223372036854775807L;
        for (zzwn zzwnVar : this.zzd) {
            if (zzwnVar != null) {
                zzwnVar.zza();
            }
        }
        return zzt(this.zza.zzj(j), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j, zzni zzniVar) {
        if (j == 0) {
            return 0L;
        }
        long j2 = zzniVar.zzd;
        String str = zzfl.zza;
        long jMax = Math.max(0L, Math.min(j2, j));
        long j3 = zzniVar.zze;
        long j4 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j));
        if (jMax != j2 || jMax2 != j3) {
            zzniVar = new zzni(jMax, jMax2);
        }
        return this.zza.zzk(j, zzniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzl < j) {
                return jZzl;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        return this.zza.zzm(zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }

    public final boolean zzo() {
        return this.zze != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzp(this);
    }

    public final /* synthetic */ long zzq() {
        return this.zzf;
    }

    public final /* synthetic */ void zzr(long j) {
        this.zzf = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}
