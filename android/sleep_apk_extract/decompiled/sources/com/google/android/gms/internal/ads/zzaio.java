package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
final class zzaio implements zzafy {
    private zzagb zzb;
    private zzaix zzc;
    private zzafz zzd;
    private zzahg zze;
    private zzamc zzf;
    private int zzh;
    private long zzi;
    private int zzj;
    private final zzet zza = new zzet(16);
    private long zzk = -1;
    private int zzg = 0;

    private final void zzh() {
        zzagb zzagbVar = this.zzb;
        zzagbVar.getClass();
        zzagbVar.zzv();
        this.zzb.zzw(new zzaha(-9223372036854775807L, 0L));
        this.zzg = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws EOFException, InterruptedIOException {
        int i;
        zzet zzetVar = new zzet(16);
        boolean z = true;
        while (true) {
            zzetVar.zza(8);
            if (!zzafzVar.zzh(zzetVar.zzi(), 0, 8, true)) {
                return false;
            }
            long jZzz = zzetVar.zzz();
            int iZzB = zzetVar.zzB();
            if (jZzz != 1) {
                i = 8;
            } else {
                if (!zzafzVar.zzh(zzetVar.zzi(), 8, 8, true)) {
                    return false;
                }
                jZzz = zzetVar.zzJ();
                i = 16;
            }
            long j = i;
            if (jZzz < j) {
                return false;
            }
            int i2 = (int) (jZzz - j);
            if (z) {
                if (iZzB != 1718909296 || i2 < 8) {
                    return false;
                }
                zzetVar.zza(4);
                zzafp zzafpVar = (zzafp) zzafzVar;
                zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
                if (zzetVar.zzB() != 1751476579) {
                    return false;
                }
                zzafpVar.zzj(i2 - 4, false);
            } else {
                if (iZzB == 1836086884) {
                    return true;
                }
                if (i2 != 0) {
                    ((zzafp) zzafzVar).zzj(i2, false);
                }
            }
            z = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzb = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws zzat {
        while (true) {
            int i = this.zzg;
            if (i == 0) {
                if (this.zzj == 0) {
                    zzet zzetVar = this.zza;
                    if (!zzafzVar.zzb(zzetVar.zzi(), 0, 8, true)) {
                        zzh();
                        return -1;
                    }
                    this.zzj = 8;
                    zzetVar.zzh(0);
                    this.zzi = zzetVar.zzz();
                    this.zzh = zzetVar.zzB();
                }
                long jZzJ = this.zzi;
                if (jZzJ == 1) {
                    zzet zzetVar2 = this.zza;
                    zzafzVar.zzc(zzetVar2.zzi(), 8, 8);
                    this.zzj += 8;
                    jZzJ = zzetVar2.zzJ();
                    this.zzi = jZzJ;
                }
                if (this.zzh == 1836086884) {
                    long jZzn = zzafzVar.zzn();
                    this.zzk = jZzn;
                    long j = this.zzj;
                    zzaix zzaixVar = new zzaix(0L, jZzn - j, -9223372036854775807L, jZzn, jZzJ - j);
                    this.zzc = zzaixVar;
                    zzagb zzagbVar = this.zzb;
                    zzagbVar.getClass();
                    zzahk zzahkVarZzu = zzagbVar.zzu(1024, 4);
                    zzt zztVar = new zzt();
                    zztVar.zzn("image/heic");
                    zztVar.zzl(new zzap(-9223372036854775807L, zzaixVar));
                    zzahkVarZzu.zzA(zztVar.zzO());
                    this.zzg = 2;
                } else {
                    this.zzg = 1;
                }
            } else if (i == 1) {
                zzafzVar.zzf((int) (this.zzi - ((long) this.zzj)));
                this.zzj = 0;
                this.zzg = 0;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        return -1;
                    }
                    if (this.zze == null || zzafzVar != this.zzd) {
                        this.zzd = zzafzVar;
                        this.zze = new zzahg(zzafzVar, this.zzk);
                    }
                    zzamc zzamcVar = this.zzf;
                    zzamcVar.getClass();
                    int iZzd = zzamcVar.zzd(this.zze, zzagyVar);
                    if (iZzd == 1) {
                        zzagyVar.zza += this.zzk;
                    }
                    return iZzd;
                }
                if (this.zzf == null) {
                    this.zzf = new zzamc(zzanj.zza, 8);
                }
                zzahg zzahgVar = new zzahg(zzafzVar, this.zzk);
                this.zze = zzahgVar;
                if (this.zzf.zza(zzahgVar)) {
                    zzamc zzamcVar2 = this.zzf;
                    long j2 = this.zzk;
                    zzagb zzagbVar2 = this.zzb;
                    zzagbVar2.getClass();
                    zzamcVar2.zzc(new zzahi(j2, zzagbVar2));
                    this.zzg = 3;
                } else {
                    zzh();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        if (j != 0) {
            if (this.zzg == 3) {
                zzamc zzamcVar = this.zzf;
                zzamcVar.getClass();
                zzamcVar.zze(j, j2);
                return;
            }
            return;
        }
        this.zzg = 0;
        this.zzj = 0;
        this.zzk = -1L;
        if (this.zzf != null) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
        if (this.zzf != null) {
            this.zzf = null;
        }
    }
}
