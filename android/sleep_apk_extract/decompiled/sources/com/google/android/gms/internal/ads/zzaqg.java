package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqg implements zzapt {
    private String zzf;
    private zzahk zzg;
    private boolean zzj;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzp;
    private int zzt;
    private boolean zzv;
    private final String zza = "video/mp2t";
    private int zze = 0;
    private final zzet zzb = new zzet(new byte[15], 2);
    private final zzes zzc = new zzes();
    private final zzet zzd = new zzet();
    private final zzaqh zzq = new zzaqh();
    private int zzr = -2147483647;
    private int zzs = -1;
    private long zzu = -1;
    private boolean zzk = true;
    private boolean zzn = true;
    private double zzh = -9.223372036854776E18d;
    private double zzi = -9.223372036854776E18d;

    public zzaqg(String str) {
    }

    private static final void zzf(zzet zzetVar, zzet zzetVar2, boolean z) {
        int iZzg = zzetVar.zzg();
        int iMin = Math.min(zzetVar.zzd(), zzetVar2.zzd());
        zzetVar.zzm(zzetVar2.zzi(), zzetVar2.zzg(), iMin);
        zzetVar2.zzk(iMin);
        if (z) {
            zzetVar.zzh(iZzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zze = 0;
        this.zzm = 0;
        this.zzb.zza(2);
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = -2147483647;
        this.zzs = -1;
        this.zzt = 0;
        this.zzu = -1L;
        this.zzv = false;
        this.zzj = false;
        this.zzn = true;
        this.zzk = true;
        this.zzh = -9.223372036854776E18d;
        this.zzi = -9.223372036854776E18d;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzarhVar.zzc();
        this.zzg = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzl = i;
        if (!this.zzk && (this.zzp != 0 || !this.zzn)) {
            this.zzj = true;
        }
        if (j != -9223372036854775807L) {
            double d = j;
            if (this.zzj) {
                this.zzi = d;
            } else {
                this.zzh = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) throws zzat {
        int i;
        this.zzg.getClass();
        while (zzetVar.zzd() > 0) {
            int i2 = this.zze;
            int iZzj = 0;
            if (i2 == 0) {
                int i3 = this.zzl;
                if ((i3 & 2) != 0) {
                    if ((i3 & 4) == 0) {
                        while (zzetVar.zzd() > 0) {
                            int i4 = this.zzm << 8;
                            this.zzm = i4;
                            int iZzs = i4 | zzetVar.zzs();
                            this.zzm = iZzs;
                            if ((iZzs & 16777215) == 12583333) {
                                zzetVar.zzh(zzetVar.zzg() - 3);
                                this.zzm = 0;
                            }
                        }
                    }
                    this.zze = 1;
                    break;
                }
                zzetVar.zzh(zzetVar.zze());
            } else if (i2 != 1) {
                zzaqh zzaqhVar = this.zzq;
                int i5 = zzaqhVar.zza;
                if (i5 == 1 || i5 == 17) {
                    zzf(zzetVar, this.zzd, true);
                }
                int iMin = Math.min(zzetVar.zzd(), zzaqhVar.zzc - this.zzo);
                this.zzg.zzc(zzetVar, iMin);
                int i6 = this.zzo + iMin;
                this.zzo = i6;
                if (i6 == zzaqhVar.zzc) {
                    int i7 = zzaqhVar.zza;
                    if (i7 == 1) {
                        byte[] bArrZzi = this.zzd.zzi();
                        zzaqi zzaqiVarZzb = zzaqj.zzb(new zzes(bArrZzi, bArrZzi.length));
                        this.zzr = zzaqiVarZzb.zzb;
                        this.zzs = zzaqiVarZzb.zzc;
                        long j = this.zzu;
                        long j2 = zzaqhVar.zzb;
                        if (j != j2) {
                            this.zzu = j2;
                            int i8 = zzaqiVarZzb.zza;
                            String strConcat = i8 != -1 ? "mhm1".concat(String.format(".%02X", Integer.valueOf(i8))) : "mhm1";
                            byte[] bArr = zzaqiVarZzb.zzd;
                            zzgwm zzgwmVarZzk = null;
                            if (bArr != null && bArr.length > 0) {
                                zzgwmVarZzk = zzgwm.zzk(zzfl.zzb, bArr);
                            }
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzf);
                            zztVar.zzn(this.zza);
                            zztVar.zzo("audio/mhm1");
                            zztVar.zzH(this.zzr);
                            zztVar.zzk(strConcat);
                            zztVar.zzr(zzgwmVarZzk);
                            this.zzg.zzA(zztVar.zzO());
                        }
                        this.zzv = true;
                    } else if (i7 == 17) {
                        byte[] bArrZzi2 = this.zzd.zzi();
                        zzes zzesVar = new zzes(bArrZzi2, bArrZzi2.length);
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(2);
                            iZzj = zzesVar.zzj(13);
                        }
                        this.zzt = iZzj;
                    } else if (i7 == 2) {
                        if (this.zzv) {
                            this.zzk = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i9 = this.zzs - this.zzt;
                        double d = this.zzr;
                        long jRound = Math.round(this.zzh);
                        if (this.zzj) {
                            this.zzj = false;
                            this.zzh = this.zzi;
                        } else {
                            this.zzh += (((double) i9) * 1000000.0d) / d;
                        }
                        this.zzg.zze(jRound, i, this.zzp, 0, null);
                        this.zzv = false;
                        this.zzt = 0;
                        this.zzp = 0;
                    }
                    this.zze = 1;
                }
            } else {
                zzet zzetVar2 = this.zzb;
                zzf(zzetVar, zzetVar2, false);
                if (zzetVar2.zzd() == 0) {
                    zzes zzesVar2 = this.zzc;
                    int iZze = zzetVar2.zze();
                    zzesVar2.zzb(zzetVar2.zzi(), iZze);
                    zzaqh zzaqhVar2 = this.zzq;
                    if (zzaqj.zza(zzesVar2, zzaqhVar2)) {
                        this.zzo = 0;
                        this.zzp = zzaqhVar2.zzc + iZze + this.zzp;
                        zzetVar2.zzh(0);
                        this.zzg.zzc(zzetVar2, zzetVar2.zze());
                        zzetVar2.zza(2);
                        this.zzd.zza(zzaqhVar2.zzc);
                        this.zzn = true;
                        this.zze = 2;
                    } else if (zzetVar2.zze() < 15) {
                        zzetVar2.zzf(zzetVar2.zze() + 1);
                    }
                }
                this.zzn = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
