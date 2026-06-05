package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaig implements zzafy {
    private zzagb zzd;
    private zzahk zze;
    private zzap zzg;
    private zzagl zzh;
    private int zzi;
    private int zzj;
    private zzaie zzk;
    private int zzl;
    private long zzm;
    private final byte[] zza = new byte[42];
    private final zzet zzb = new zzet(new byte[32768], 0);
    private final zzagf zzc = new zzagf();
    private int zzf = 0;

    public zzaig(int i) {
    }

    private final long zzh(zzet zzetVar, boolean z) {
        boolean zZza;
        this.zzh.getClass();
        int iZzg = zzetVar.zzg();
        while (iZzg <= zzetVar.zze() - 16) {
            zzetVar.zzh(iZzg);
            zzagl zzaglVar = this.zzh;
            int i = this.zzj;
            zzagf zzagfVar = this.zzc;
            if (zzagg.zza(zzetVar, zzaglVar, i, zzagfVar)) {
                zzetVar.zzh(iZzg);
                return zzagfVar.zza;
            }
            iZzg++;
        }
        if (!z) {
            zzetVar.zzh(iZzg);
            return -1L;
        }
        while (iZzg <= zzetVar.zze() - this.zzi) {
            zzetVar.zzh(iZzg);
            try {
                zZza = zzagg.zza(zzetVar, this.zzh, this.zzj, this.zzc);
            } catch (IndexOutOfBoundsException unused) {
                zZza = false;
            }
            if (zzetVar.zzg() <= zzetVar.zze() && zZza) {
                zzetVar.zzh(iZzg);
                return this.zzc.zza;
            }
            iZzg++;
        }
        zzetVar.zzh(zzetVar.zze());
        return -1L;
    }

    private final void zzi() {
        long j = this.zzm * 1000000;
        zzagl zzaglVar = this.zzh;
        String str = zzfl.zza;
        this.zze.zze(j / ((long) zzaglVar.zze), 1, this.zzl, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) {
        zzagi.zza(zzafzVar, false);
        zzet zzetVar = new zzet(4);
        ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, 4, false);
        return zzetVar.zzz() == 1716281667;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzd = zzagbVar;
        this.zze = zzagbVar.zzu(0, 1);
        zzagbVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws zzat {
        boolean zZzb;
        zzagl zzaglVar;
        zzahb zzahaVar;
        boolean z;
        int i = this.zzf;
        if (i == 0) {
            zzafzVar.zzl();
            long jZzm = zzafzVar.zzm();
            zzap zzapVarZza = zzagi.zza(zzafzVar, true);
            zzafzVar.zzf((int) (zzafzVar.zzm() - jZzm));
            this.zzg = zzapVarZza;
            this.zzf = 1;
            return 0;
        }
        if (i == 1) {
            zzafzVar.zzi(this.zza, 0, 42);
            zzafzVar.zzl();
            this.zzf = 2;
            return 0;
        }
        if (i == 2) {
            zzet zzetVar = new zzet(4);
            zzafzVar.zzc(zzetVar.zzi(), 0, 4);
            if (zzetVar.zzz() != 1716281667) {
                throw zzat.zzb("Failed to read FLAC stream marker.", null);
            }
            this.zzf = 3;
            return 0;
        }
        if (i == 3) {
            zzagh zzaghVar = new zzagh(this.zzh);
            do {
                zZzb = zzagi.zzb(zzafzVar, zzaghVar);
                zzaglVar = zzaghVar.zza;
                String str = zzfl.zza;
                this.zzh = zzaglVar;
            } while (!zZzb);
            zzaglVar.getClass();
            this.zzi = Math.max(zzaglVar.zzc, 6);
            zzv zzvVarZzc = this.zzh.zzc(this.zza, this.zzg);
            zzahk zzahkVar = this.zze;
            zzt zztVarZza = zzvVarZzc.zza();
            zztVarZza.zzn("audio/flac");
            zzahkVar.zzA(zztVarZza.zzO());
            this.zze.zzO(this.zzh.zza());
            this.zzf = 4;
            return 0;
        }
        if (i == 4) {
            zzafzVar.zzl();
            zzet zzetVar2 = new zzet(2);
            zzafzVar.zzi(zzetVar2.zzi(), 0, 2);
            int iZzt = zzetVar2.zzt();
            if ((iZzt >> 2) != 16382) {
                zzafzVar.zzl();
                throw zzat.zzb("First frame does not start with sync code.", null);
            }
            zzafzVar.zzl();
            this.zzj = iZzt;
            zzagb zzagbVar = this.zzd;
            String str2 = zzfl.zza;
            long jZzn = zzafzVar.zzn();
            long jZzo = zzafzVar.zzo();
            zzagl zzaglVar2 = this.zzh;
            zzaglVar2.getClass();
            zzagk zzagkVar = zzaglVar2.zzk;
            if (zzagkVar != null && zzagkVar.zza.length > 0) {
                zzahaVar = new zzagj(zzaglVar2, jZzn);
            } else if (jZzo == -1 || zzaglVar2.zzj <= 0) {
                zzahaVar = new zzaha(zzaglVar2.zza(), 0L);
            } else {
                zzaie zzaieVar = new zzaie(zzaglVar2, this.zzj, jZzn, jZzo);
                this.zzk = zzaieVar;
                zzahaVar = zzaieVar.zza();
            }
            zzagbVar.zzw(zzahaVar);
            this.zzf = 5;
            return 0;
        }
        this.zze.getClass();
        zzagl zzaglVar3 = this.zzh;
        zzaglVar3.getClass();
        zzaie zzaieVar2 = this.zzk;
        if (zzaieVar2 != null && zzaieVar2.zzc()) {
            return zzaieVar2.zzd(zzafzVar, zzagyVar);
        }
        if (this.zzm == -1) {
            this.zzm = zzagg.zzb(zzafzVar, zzaglVar3);
            return 0;
        }
        zzet zzetVar3 = this.zzb;
        int iZze = zzetVar3.zze();
        if (iZze < 32768) {
            int iZza = zzafzVar.zza(zzetVar3.zzi(), iZze, 32768 - iZze);
            z = iZza == -1;
            if (!z) {
                zzetVar3.zzf(iZze + iZza);
            } else if (zzetVar3.zzd() == 0) {
                zzi();
                return -1;
            }
        } else {
            z = false;
        }
        int iZzg = zzetVar3.zzg();
        int i2 = this.zzl;
        int i3 = this.zzi;
        if (i2 < i3) {
            zzetVar3.zzk(Math.min(i3 - i2, zzetVar3.zzd()));
        }
        long jZzh = zzh(zzetVar3, z);
        int iZzg2 = zzetVar3.zzg() - iZzg;
        zzetVar3.zzh(iZzg);
        this.zze.zzc(zzetVar3, iZzg2);
        this.zzl += iZzg2;
        if (jZzh != -1) {
            zzi();
            this.zzl = 0;
            this.zzm = jZzh;
        }
        int length = zzetVar3.zzi().length - zzetVar3.zze();
        if (zzetVar3.zzd() >= 16 || length >= 16) {
            return 0;
        }
        int iZzd = zzetVar3.zzd();
        System.arraycopy(zzetVar3.zzi(), zzetVar3.zzg(), zzetVar3.zzi(), 0, iZzd);
        zzetVar3.zzh(0);
        zzetVar3.zzf(iZzd);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzaie zzaieVar = this.zzk;
            if (zzaieVar != null) {
                zzaieVar.zzb(j2);
            }
        }
        this.zzm = j2 != 0 ? -1L : 0L;
        this.zzl = 0;
        this.zzb.zza(0);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
