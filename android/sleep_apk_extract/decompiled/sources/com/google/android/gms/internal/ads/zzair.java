package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzair implements zzafy {
    private zzagb zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzaix zzg;
    private zzafz zzh;
    private zzahg zzi;
    private zzamc zzj;
    private final zzet zza = new zzet(2);
    private long zzf = -1;

    private final int zzh(zzafz zzafzVar) {
        zzet zzetVar = this.zza;
        zzetVar.zza(2);
        ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, 2, false);
        return zzetVar.zzt();
    }

    private final int zzi(zzafz zzafzVar) {
        zzet zzetVar = this.zza;
        zzetVar.zza(2);
        zzafzVar.zzi(zzetVar.zzi(), 0, 2);
        return zzetVar.zzt() - 2;
    }

    private final void zzj() {
        zzagb zzagbVar = this.zzb;
        zzagbVar.getClass();
        zzagbVar.zzv();
        this.zzb.zzw(new zzaha(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws EOFException, InterruptedIOException {
        int iZzi;
        if (zzh(zzafzVar) == 65496) {
            while (true) {
                int iZzh = zzh(zzafzVar);
                this.zzd = iZzh;
                if (iZzh == 65498 || (iZzi = zzi(zzafzVar)) < 0) {
                    break;
                }
                if (this.zzd != 65505) {
                    ((zzafp) zzafzVar).zzj(iZzi, false);
                } else {
                    zzet zzetVar = this.zza;
                    zzetVar.zza(iZzi);
                    ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, iZzi, false);
                    if (!Objects.equals(zzetVar.zzM((char) 0), "http://ns.adobe.com/xap/1.0/") ? false : zzaiu.zzb(zzetVar.zzM((char) 0))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzb = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018e  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws zzat {
        String strZzM;
        zzait zzaitVarZza;
        zzaix zzaixVar;
        long j;
        int i = this.zzc;
        long j2 = -1;
        if (i == 0) {
            zzet zzetVar = this.zza;
            zzetVar.zza(2);
            zzafzVar.zzc(zzetVar.zzi(), 0, 2);
            int iZzt = zzetVar.zzt();
            this.zzd = iZzt;
            if (iZzt == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                } else {
                    zzj();
                }
            } else if ((iZzt < 65488 || iZzt > 65497) && iZzt != 65281) {
                this.zzc = 1;
            }
            return 0;
        }
        if (i == 1) {
            this.zze = zzi(zzafzVar);
            zzafzVar.zzf(2);
            this.zzc = 2;
            return 0;
        }
        if (i != 2) {
            if (i != 4) {
                if (i != 5) {
                    if (i == 6) {
                        return -1;
                    }
                    Home$$ExternalSyntheticBUOutline0.m$2();
                    return 0;
                }
                if (this.zzi == null || zzafzVar != this.zzh) {
                    this.zzh = zzafzVar;
                    this.zzi = new zzahg(zzafzVar, this.zzf);
                }
                zzamc zzamcVar = this.zzj;
                zzamcVar.getClass();
                int iZzd = zzamcVar.zzd(this.zzi, zzagyVar);
                if (iZzd == 1) {
                    zzagyVar.zza += this.zzf;
                }
                return iZzd;
            }
            long jZzn = zzafzVar.zzn();
            long j3 = this.zzf;
            if (jZzn != j3) {
                zzagyVar.zza = j3;
                return 1;
            }
            if (zzafzVar.zzh(this.zza.zzi(), 0, 1, true)) {
                zzafzVar.zzl();
                if (this.zzj == null) {
                    this.zzj = new zzamc(zzanj.zza, 8);
                }
                zzahg zzahgVar = new zzahg(zzafzVar, this.zzf);
                this.zzi = zzahgVar;
                if (this.zzj.zza(zzahgVar)) {
                    zzamc zzamcVar2 = this.zzj;
                    long j4 = this.zzf;
                    zzagb zzagbVar = this.zzb;
                    zzagbVar.getClass();
                    zzamcVar2.zzc(new zzahi(j4, zzagbVar));
                    zzaix zzaixVar2 = this.zzg;
                    zzaixVar2.getClass();
                    zzagb zzagbVar2 = this.zzb;
                    zzagbVar2.getClass();
                    zzahk zzahkVarZzu = zzagbVar2.zzu(1024, 4);
                    zzt zztVar = new zzt();
                    zztVar.zzn("image/jpeg");
                    zztVar.zzl(new zzap(-9223372036854775807L, zzaixVar2));
                    zzahkVarZzu.zzA(zztVar.zzO());
                    this.zzc = 5;
                } else {
                    zzj();
                }
            } else {
                zzj();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzet zzetVar2 = new zzet(this.zze);
            zzafzVar.zzc(zzetVar2.zzi(), 0, this.zze);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzetVar2.zzM((char) 0)) && (strZzM = zzetVar2.zzM((char) 0)) != null) {
                long jZzo = zzafzVar.zzo();
                if (jZzo != -1 && (zzaitVarZza = zzaiu.zza(strZzM)) != null) {
                    List list = zzaitVarZza.zzb;
                    if (list.size() < 2) {
                        zzaixVar = null;
                        this.zzg = zzaixVar;
                        if (zzaixVar != null) {
                            this.zzf = zzaixVar.zzd;
                        }
                    } else {
                        int size = list.size() - 1;
                        long j5 = -1;
                        long j6 = -1;
                        long j7 = -1;
                        long j8 = -1;
                        while (size >= 0) {
                            zzais zzaisVar = (zzais) list.get(size);
                            String str = zzaisVar.zza;
                            long j9 = j2;
                            boolean z = str.equals("video/mp4") || str.equals("video/quicktime");
                            if (size == 0) {
                                jZzo -= zzaisVar.zzc;
                                j = 0;
                            } else {
                                j = jZzo - zzaisVar.zzb;
                            }
                            long j10 = j;
                            long j11 = jZzo;
                            jZzo = j10;
                            if (z && jZzo != j11) {
                                j8 = j11 - jZzo;
                                j7 = jZzo;
                            }
                            if (size == 0) {
                                j6 = j11;
                            }
                            if (size == 0) {
                                j5 = jZzo;
                            }
                            size--;
                            j2 = j9;
                        }
                        long j12 = j2;
                        if (j7 != j12 && j8 != j12 && j5 != j12 && j6 != j12) {
                            zzaixVar = new zzaix(j5, j6, zzaitVarZza.zza, j7, j8);
                        }
                        this.zzg = zzaixVar;
                        if (zzaixVar != null) {
                        }
                    }
                }
            }
        } else {
            zzafzVar.zzf(this.zze);
        }
        this.zzc = 0;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzamc zzamcVar = this.zzj;
            zzamcVar.getClass();
            zzamcVar.zze(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
