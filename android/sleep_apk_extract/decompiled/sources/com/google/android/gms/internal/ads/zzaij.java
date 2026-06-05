package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaij implements zzafy {
    private zzagb zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaih zzo;
    private zzain zzp;
    private final zzet zza = new zzet(4);
    private final zzet zzb = new zzet(9);
    private final zzet zzc = new zzet(11);
    private final zzet zzd = new zzet();
    private final zzaik zze = new zzaik();
    private int zzg = 1;

    private final zzet zzh(zzafz zzafzVar) {
        zzet zzetVar = this.zzd;
        if (this.zzl > zzetVar.zzj()) {
            int iZzj = zzetVar.zzj();
            zzetVar.zzb(new byte[Math.max(iZzj + iZzj, this.zzl)], 0);
        } else {
            zzetVar.zzh(0);
        }
        zzetVar.zzf(this.zzl);
        zzafzVar.zzc(zzetVar.zzi(), 0, this.zzl);
        return zzetVar;
    }

    private final void zzi() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzw(new zzaha(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws EOFException, InterruptedIOException {
        zzet zzetVar = this.zza;
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(zzetVar.zzi(), 0, 3, false);
        zzetVar.zzh(0);
        if (zzetVar.zzx() != 4607062) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 2, false);
        zzetVar.zzh(0);
        if ((zzetVar.zzt() & 250) != 0) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        zzafzVar.zzl();
        zzafp zzafpVar2 = (zzafp) zzafzVar;
        zzafpVar2.zzj(iZzB, false);
        zzafpVar2.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        return zzetVar.zzB() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzf = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0007 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) {
        boolean zZzf;
        boolean z;
        this.zzf.getClass();
        while (true) {
            int i = this.zzg;
            int i2 = 8;
            if (i == 1) {
                zzet zzetVar = this.zzb;
                if (!zzafzVar.zzb(zzetVar.zzi(), 0, 9, true)) {
                    return -1;
                }
                zzetVar.zzh(0);
                zzetVar.zzk(4);
                int iZzs = zzetVar.zzs();
                int i3 = iZzs & 4;
                int i4 = iZzs & 1;
                if (i3 != 0 && this.zzo == null) {
                    this.zzo = new zzaih(this.zzf.zzu(8, 1));
                }
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzain(this.zzf.zzu(9, 2));
                }
                this.zzf.zzv();
                this.zzj = zzetVar.zzB() - 5;
                this.zzg = 2;
            } else if (i == 2) {
                zzafzVar.zzf(this.zzj);
                this.zzj = 0;
                this.zzg = 3;
            } else if (i == 3) {
                zzet zzetVar2 = this.zzc;
                if (!zzafzVar.zzb(zzetVar2.zzi(), 0, 11, true)) {
                    return -1;
                }
                zzetVar2.zzh(0);
                this.zzk = zzetVar2.zzs();
                this.zzl = zzetVar2.zzx();
                this.zzm = zzetVar2.zzx();
                this.zzm = (((long) (zzetVar2.zzs() << 24)) | this.zzm) * 1000;
                zzetVar2.zzk(3);
                this.zzg = 4;
            } else {
                if (i != 4) {
                    Home$$ExternalSyntheticBUOutline0.m$2();
                    return 0;
                }
                long j = this.zzh ? this.zzi + this.zzm : this.zze.zzc() == -9223372036854775807L ? 0L : this.zzm;
                int i5 = this.zzk;
                if (i5 == 8) {
                    if (this.zzo != null) {
                        zzi();
                        zZzf = this.zzo.zzf(zzh(zzafzVar), j);
                    }
                    z = true;
                    if (!this.zzh && zZzf) {
                        this.zzh = true;
                        this.zzi = this.zze.zzc() != -9223372036854775807L ? -this.zzm : 0L;
                    }
                    this.zzj = 4;
                    this.zzg = 2;
                    if (!z) {
                        return 0;
                    }
                } else {
                    i2 = i5;
                }
                if (i2 == 9) {
                    if (this.zzp != null) {
                        zzi();
                        zZzf = this.zzp.zzf(zzh(zzafzVar), j);
                        z = true;
                    }
                    zzafzVar.zzf(this.zzl);
                    zZzf = false;
                    z = false;
                } else {
                    if (i2 == 18 && !this.zzn) {
                        zzaik zzaikVar = this.zze;
                        boolean zZzf2 = zzaikVar.zzf(zzh(zzafzVar), j);
                        long jZzc = zzaikVar.zzc();
                        if (jZzc != -9223372036854775807L) {
                            this.zzf.zzw(new zzagu(zzaikVar.zze(), zzaikVar.zzd(), jZzc));
                            this.zzn = true;
                        }
                        zZzf = zZzf2;
                        z = true;
                    }
                    zzafzVar.zzf(this.zzl);
                    zZzf = false;
                    z = false;
                }
                if (!this.zzh) {
                    this.zzh = true;
                    this.zzi = this.zze.zzc() != -9223372036854775807L ? -this.zzm : 0L;
                }
                this.zzj = 4;
                this.zzg = 2;
                if (!z) {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
