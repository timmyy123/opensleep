package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzamz {
    private zzahk zzb;
    private zzagb zzc;
    private zzamv zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzamt zza = new zzamt();
    private zzamx zzj = new zzamx();

    public void zza(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzamx();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    public abstract long zzb(zzet zzetVar);

    public abstract boolean zzc(zzet zzetVar, long j, zzamx zzamxVar);

    public final void zze(zzagb zzagbVar, zzahk zzahkVar) {
        this.zzc = zzagbVar;
        this.zzb = zzahkVar;
        zza(true);
    }

    public final void zzf(long j, long j2) {
        this.zza.zza();
        if (j == 0) {
            zza(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzi = zzi(j2);
            this.zze = jZzi;
            zzamv zzamvVar = this.zzd;
            String str = zzfl.zza;
            zzamvVar.zzb(jZzi);
            this.zzh = 2;
        }
    }

    public final int zzg(zzafz zzafzVar, zzagy zzagyVar) {
        this.zzb.getClass();
        String str = zzfl.zza;
        int i = this.zzh;
        if (i != 0) {
            if (i == 1) {
                zzafzVar.zzf((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i != 2) {
                return -1;
            }
            long jZza = this.zzd.zza(zzafzVar);
            if (jZza >= 0) {
                zzagyVar.zza = jZza;
                return 1;
            }
            if (jZza < -1) {
                zzj(-(jZza + 2));
            }
            if (!this.zzl) {
                zzahb zzahbVarZzc = this.zzd.zzc();
                zzahbVarZzc.getClass();
                this.zzc.zzw(zzahbVarZzc);
                this.zzb.zzO(zzahbVarZzc.zza());
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zzb(zzafzVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzet zzetVarZzd = this.zza.zzd();
            long jZzb = zzb(zzetVarZzd);
            if (jZzb >= 0) {
                long j = this.zzg;
                if (j + jZzb >= this.zze) {
                    long jZzh = zzh(j);
                    this.zzb.zzc(zzetVarZzd, zzetVarZzd.zze());
                    this.zzb.zze(jZzh, 1, zzetVarZzd.zze(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += jZzb;
            return 0;
        }
        while (true) {
            zzamt zzamtVar = this.zza;
            if (!zzamtVar.zzb(zzafzVar)) {
                this.zzh = 3;
                return -1;
            }
            long jZzn = zzafzVar.zzn();
            long j2 = this.zzf;
            this.zzk = jZzn - j2;
            if (!zzc(zzamtVar.zzd(), j2, this.zzj)) {
                zzv zzvVar = this.zzj.zza;
                this.zzi = zzvVar.zzI;
                if (!this.zzm) {
                    this.zzb.zzA(zzvVar);
                    this.zzm = true;
                }
                zzamv zzamvVar = this.zzj.zzb;
                if (zzamvVar != null) {
                    this.zzd = zzamvVar;
                } else if (zzafzVar.zzo() == -1) {
                    this.zzd = new zzamy(null);
                } else {
                    zzamu zzamuVarZzc = zzamtVar.zzc();
                    this.zzd = new zzamo(this, this.zzf, zzafzVar.zzo(), zzamuVarZzc.zzd + zzamuVarZzc.zze, zzamuVarZzc.zzb, (zzamuVarZzc.zza & 4) != 0);
                }
                this.zzh = 2;
                zzamtVar.zze();
                return 0;
            }
            this.zzf = zzafzVar.zzn();
        }
    }

    public final long zzh(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    public final long zzi(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    public void zzj(long j) {
        this.zzg = j;
    }
}
