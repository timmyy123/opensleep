package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqe implements zzapt {
    private final String zza;
    private final int zzb;
    private final String zzc = "video/mp2t";
    private final zzet zzd;
    private final zzes zze;
    private zzahk zzf;
    private String zzg;
    private zzv zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private String zzw;

    public zzaqe(String str, int i, String str2) {
        this.zza = str;
        this.zzb = i;
        zzet zzetVar = new zzet(1024);
        this.zzd = zzetVar;
        byte[] bArrZzi = zzetVar.zzi();
        this.zze = new zzes(bArrZzi, bArrZzi.length);
        this.zzm = -9223372036854775807L;
    }

    private final int zzf(zzes zzesVar) throws zzat {
        int iZzc = zzesVar.zzc();
        zzaev zzaevVarZzb = zzaew.zzb(zzesVar, true);
        this.zzw = zzaevVarZzb.zzc;
        this.zzt = zzaevVarZzb.zza;
        this.zzv = zzaevVarZzb.zzb;
        return iZzc - zzesVar.zzc();
    }

    private static long zzg(zzes zzesVar) {
        return zzesVar.zzj((zzesVar.zzj(2) + 1) * 8);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzi = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzagbVar.zzu(zzarhVar.zzb(), 1);
        this.zzg = zzarhVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) throws zzat {
        int i;
        int i2;
        int iZzj;
        boolean zZzi;
        this.zzf.getClass();
        while (zzetVar.zzd() > 0) {
            int i3 = this.zzi;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iZzs = zzetVar.zzs();
                    if ((iZzs & 224) == 224) {
                        this.zzl = iZzs;
                        this.zzi = 2;
                    } else if (iZzs != 86) {
                        this.zzi = 0;
                    }
                } else if (i3 != 2) {
                    int iMin = Math.min(zzetVar.zzd(), this.zzk - this.zzj);
                    zzes zzesVar = this.zze;
                    zzetVar.zzm(zzesVar.zza, this.zzj, iMin);
                    int i4 = this.zzj + iMin;
                    this.zzj = i4;
                    if (i4 == this.zzk) {
                        zzesVar.zzf(0);
                        if (zzesVar.zzi()) {
                            if (this.zzn) {
                            }
                            this.zzi = 0;
                        } else {
                            this.zzn = true;
                            int iZzj2 = zzesVar.zzj(1);
                            if (iZzj2 == 1) {
                                iZzj = zzesVar.zzj(1);
                                i2 = 1;
                            } else {
                                i2 = iZzj2;
                                iZzj = 0;
                            }
                            this.zzo = iZzj;
                            if (iZzj != 0) {
                                throw zzat.zzb(null, null);
                            }
                            if (i2 == 1) {
                                zzg(zzesVar);
                                i2 = 1;
                            }
                            if (!zzesVar.zzi()) {
                                throw zzat.zzb(null, null);
                            }
                            this.zzp = zzesVar.zzj(6);
                            int iZzj3 = zzesVar.zzj(4);
                            int iZzj4 = zzesVar.zzj(3);
                            if (iZzj3 != 0 || iZzj4 != 0) {
                                throw zzat.zzb(null, null);
                            }
                            if (i2 == 0) {
                                int iZzd = zzesVar.zzd();
                                int iZzf = zzf(zzesVar);
                                zzesVar.zzf(iZzd);
                                byte[] bArr = new byte[(iZzf + 7) / 8];
                                zzesVar.zzl(bArr, 0, iZzf);
                                zzt zztVar = new zzt();
                                zztVar.zza(this.zzg);
                                zztVar.zzn(this.zzc);
                                zztVar.zzo("audio/mp4a-latm");
                                zztVar.zzk(this.zzw);
                                zztVar.zzG(this.zzv);
                                zztVar.zzH(this.zzt);
                                zztVar.zzr(Collections.singletonList(bArr));
                                zztVar.zze(this.zza);
                                zztVar.zzg(this.zzb);
                                zzv zzvVarZzO = zztVar.zzO();
                                if (!zzvVarZzO.equals(this.zzh)) {
                                    this.zzh = zzvVarZzO;
                                    this.zzu = 1024000000 / ((long) zzvVarZzO.zzI);
                                    this.zzf.zzA(zzvVarZzO);
                                }
                            } else {
                                zzesVar.zzh(((int) zzg(zzesVar)) - zzf(zzesVar));
                            }
                            int iZzj5 = zzesVar.zzj(3);
                            this.zzq = iZzj5;
                            if (iZzj5 == 0) {
                                zzesVar.zzh(8);
                            } else if (iZzj5 == 1) {
                                zzesVar.zzh(9);
                            } else if (iZzj5 == 3 || iZzj5 == 4 || iZzj5 == 5) {
                                zzesVar.zzh(6);
                            } else {
                                if (iZzj5 != 6 && iZzj5 != 7) {
                                    Home$$ExternalSyntheticBUOutline0.m$2();
                                    return;
                                }
                                zzesVar.zzh(1);
                            }
                            boolean zZzi2 = zzesVar.zzi();
                            this.zzr = zZzi2;
                            this.zzs = 0L;
                            if (zZzi2) {
                                if (i2 != 1) {
                                    do {
                                        zZzi = zzesVar.zzi();
                                        this.zzs = (this.zzs << 8) + ((long) zzesVar.zzj(8));
                                    } while (zZzi);
                                } else {
                                    this.zzs = zzg(zzesVar);
                                }
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(8);
                            }
                        }
                        if (this.zzo != 0) {
                            throw zzat.zzb(null, null);
                        }
                        if (this.zzp != 0) {
                            throw zzat.zzb(null, null);
                        }
                        if (this.zzq != 0) {
                            throw zzat.zzb(null, null);
                        }
                        int i5 = 0;
                        while (true) {
                            int iZzj6 = zzesVar.zzj(8);
                            i = i5 + iZzj6;
                            if (iZzj6 != 255) {
                                break;
                            } else {
                                i5 = i;
                            }
                        }
                        int iZzd2 = zzesVar.zzd();
                        int i6 = iZzd2 & 7;
                        zzet zzetVar2 = this.zzd;
                        if (i6 == 0) {
                            zzetVar2.zzh(iZzd2 >> 3);
                        } else {
                            zzesVar.zzl(zzetVar2.zzi(), 0, i * 8);
                            zzetVar2.zzh(0);
                        }
                        this.zzf.zzc(this.zzd, i);
                        zzgtj.zzi(this.zzm != -9223372036854775807L);
                        this.zzf.zze(this.zzm, 1, i, 0, null);
                        this.zzm += this.zzu;
                        if (this.zzr) {
                            zzesVar.zzh((int) this.zzs);
                        }
                        this.zzi = 0;
                    } else {
                        continue;
                    }
                } else {
                    int iZzs2 = ((this.zzl & (-225)) << 8) | zzetVar.zzs();
                    this.zzk = iZzs2;
                    zzet zzetVar3 = this.zzd;
                    if (iZzs2 > zzetVar3.zzi().length) {
                        zzetVar3.zza(iZzs2);
                        zzes zzesVar2 = this.zze;
                        byte[] bArrZzi = zzetVar3.zzi();
                        zzesVar2.zzb(bArrZzi, bArrZzi.length);
                    }
                    this.zzj = 0;
                    this.zzi = 3;
                }
            } else if (zzetVar.zzs() == 86) {
                this.zzi = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
