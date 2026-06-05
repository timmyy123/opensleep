package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaht implements zzafy {
    private final zzet zza;
    private final zzahs zzb;
    private final boolean zzc;
    private final zzanj zzd;
    private int zze;
    private zzagb zzf;
    private zzahu zzg;
    private long zzh;
    private zzahw[] zzi;
    private long zzj;
    private zzahw zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    public zzaht(int i, zzanj zzanjVar) {
        this.zzd = zzanjVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzet(12);
        this.zzb = new zzahs(null);
        this.zzf = new zzagx();
        this.zzi = new zzahw[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    private final zzahw zzi(int i) {
        for (zzahw zzahwVar : this.zzi) {
            if (zzahwVar.zzc(i)) {
                return zzahwVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) {
        zzet zzetVar = this.zza;
        zzafzVar.zzi(zzetVar.zzi(), 0, 12);
        zzetVar.zzh(0);
        if (zzetVar.zzC() != 1179011410) {
            return false;
        }
        zzetVar.zzk(4);
        return zzetVar.zzC() == 541677121;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zze = 0;
        if (this.zzc) {
            zzagbVar = new zzanm(zzagbVar, this.zzd);
        }
        this.zzf = zzagbVar;
        this.zzj = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws zzat {
        boolean z;
        int i;
        long j;
        long j2 = this.zzj;
        if (j2 != -1) {
            long jZzn = zzafzVar.zzn();
            if (j2 < jZzn || j2 > 262144 + jZzn) {
                zzagyVar.zza = j2;
                z = true;
            } else {
                zzafzVar.zzf((int) (j2 - jZzn));
                z = false;
            }
        } else {
            z = false;
        }
        this.zzj = -1L;
        if (z) {
            return 1;
        }
        int i2 = this.zze;
        zzahw zzahwVar = null;
        if (i2 == 0) {
            if (!zza(zzafzVar)) {
                throw zzat.zzb("AVI Header List not found", null);
            }
            zzafzVar.zzf(12);
            this.zze = 1;
            return 0;
        }
        if (i2 == 1) {
            zzet zzetVar = this.zza;
            zzafzVar.zzc(zzetVar.zzi(), 0, 12);
            zzetVar.zzh(0);
            zzahs zzahsVar = this.zzb;
            zzahsVar.zza(zzetVar);
            int i3 = zzahsVar.zza;
            if (i3 != 1414744396) {
                StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(i3, 22));
                sb.append("LIST expected, found: ");
                sb.append(i3);
                throw zzat.zzb(sb.toString(), null);
            }
            int iZzC = zzetVar.zzC();
            if (iZzC == 1819436136) {
                this.zzl = zzahsVar.zzb;
                this.zze = 2;
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iZzC, 22));
            sb2.append("hdrl expected, found: ");
            sb2.append(iZzC);
            throw zzat.zzb(sb2.toString(), null);
        }
        if (i2 == 2) {
            int i4 = this.zzl - 4;
            zzet zzetVar2 = new zzet(i4);
            zzafzVar.zzc(zzetVar2.zzi(), 0, i4);
            zzahx zzahxVarZzb = zzahx.zzb(1819436136, zzetVar2);
            if (zzahxVarZzb.zza() != 1819436136) {
                int iZza = zzahxVarZzb.zza();
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb3.append("Unexpected header list type ");
                sb3.append(iZza);
                throw zzat.zzb(sb3.toString(), null);
            }
            zzahu zzahuVar = (zzahu) zzahxVarZzb.zzc(zzahu.class);
            if (zzahuVar == null) {
                throw zzat.zzb("AviHeader not found", null);
            }
            this.zzg = zzahuVar;
            this.zzh = ((long) zzahuVar.zzc) * ((long) zzahuVar.zza);
            ArrayList arrayList = new ArrayList();
            zzgwm zzgwmVar = zzahxVarZzb.zza;
            int size = zzgwmVar.size();
            int i5 = 0;
            int i6 = 0;
            while (i5 < size) {
                zzahq zzahqVar = (zzahq) zzgwmVar.get(i5);
                if (zzahqVar.zza() == 1819440243) {
                    zzahx zzahxVar = (zzahx) zzahqVar;
                    int i7 = i6 + 1;
                    zzahv zzahvVar = (zzahv) zzahxVar.zzc(zzahv.class);
                    zzahy zzahyVar = (zzahy) zzahxVar.zzc(zzahy.class);
                    if (zzahvVar == null) {
                        zzeg.zzc("AviExtractor", "Missing Stream Header");
                    } else if (zzahyVar == null) {
                        zzeg.zzc("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzd = zzahvVar.zzd();
                        zzv zzvVar = zzahyVar.zza;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzb(i6);
                        int i8 = zzahvVar.zze;
                        if (i8 != 0) {
                            zztVarZza.zzp(i8);
                        }
                        zzahz zzahzVar = (zzahz) zzahxVar.zzc(zzahz.class);
                        if (zzahzVar != null) {
                            zztVarZza.zzc(zzahzVar.zza);
                        }
                        int iZzf = zzas.zzf(zzvVar.zzp);
                        if (iZzf == 1) {
                            zzahk zzahkVarZzu = this.zzf.zzu(i6, iZzf);
                            zzahkVarZzu.zzA(zztVarZza.zzO());
                            zzahkVarZzu.zzO(jZzd);
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzahwVar = new zzahw(i6, zzahvVar, zzahkVarZzu);
                        } else if (iZzf == 2) {
                            iZzf = 2;
                            zzahk zzahkVarZzu2 = this.zzf.zzu(i6, iZzf);
                            zzahkVarZzu2.zzA(zztVarZza.zzO());
                            zzahkVarZzu2.zzO(jZzd);
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzahwVar = new zzahw(i6, zzahvVar, zzahkVarZzu2);
                        } else {
                            zzahwVar = null;
                        }
                    }
                    if (zzahwVar != null) {
                        arrayList.add(zzahwVar);
                    }
                    i6 = i7;
                }
                i5++;
                zzahwVar = null;
            }
            this.zzi = (zzahw[]) arrayList.toArray(new zzahw[0]);
            this.zzf.zzv();
            this.zze = 3;
            return 0;
        }
        if (i2 == 3) {
            long j3 = this.zzm;
            if (j3 != -1 && zzafzVar.zzn() != j3) {
                this.zzj = j3;
                return 0;
            }
            zzet zzetVar3 = this.zza;
            zzafzVar.zzi(zzetVar3.zzi(), 0, 12);
            zzafzVar.zzl();
            zzetVar3.zzh(0);
            zzahs zzahsVar2 = this.zzb;
            zzahsVar2.zza(zzetVar3);
            int iZzC2 = zzetVar3.zzC();
            int i9 = zzahsVar2.zza;
            if (i9 == 1179011410) {
                zzafzVar.zzf(12);
                return 0;
            }
            if (i9 != 1414744396 || iZzC2 != 1769369453) {
                this.zzj = zzafzVar.zzn() + ((long) zzahsVar2.zzb) + 8;
                return 0;
            }
            long jZzn2 = zzafzVar.zzn();
            this.zzm = jZzn2;
            long j4 = jZzn2 + ((long) zzahsVar2.zzb) + 8;
            this.zzn = j4;
            if (!this.zzp) {
                zzahu zzahuVar2 = this.zzg;
                zzahuVar2.getClass();
                if ((zzahuVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j4;
                    return 0;
                }
                this.zzf.zzw(new zzaha(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzafzVar.zzn() + 12;
            this.zze = 6;
            return 0;
        }
        if (i2 == 4) {
            zzet zzetVar4 = this.zza;
            zzafzVar.zzc(zzetVar4.zzi(), 0, 8);
            zzetVar4.zzh(0);
            int iZzC3 = zzetVar4.zzC();
            int iZzC4 = zzetVar4.zzC();
            if (iZzC3 != 829973609) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC4);
                return 0;
            }
            this.zze = 5;
            this.zzo = iZzC4;
            return 0;
        }
        if (i2 != 5) {
            if (zzafzVar.zzn() >= this.zzn) {
                return -1;
            }
            zzahw zzahwVar2 = this.zzk;
            if (zzahwVar2 != null) {
                if (!zzahwVar2.zze(zzafzVar)) {
                    return 0;
                }
                this.zzk = null;
                return 0;
            }
            if ((zzafzVar.zzn() & 1) == 1) {
                zzafzVar.zzf(1);
            }
            zzet zzetVar5 = this.zza;
            zzafzVar.zzi(zzetVar5.zzi(), 0, 12);
            zzetVar5.zzh(0);
            int iZzC5 = zzetVar5.zzC();
            if (iZzC5 == 1414744396) {
                zzetVar5.zzh(8);
                zzafzVar.zzf(zzetVar5.zzC() != 1769369453 ? 8 : 12);
                zzafzVar.zzl();
                return 0;
            }
            int iZzC6 = zzetVar5.zzC();
            if (iZzC5 == 1263424842) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC6) + 8;
                return 0;
            }
            zzafzVar.zzf(8);
            zzafzVar.zzl();
            zzahw zzahwVarZzi = zzi(iZzC5);
            if (zzahwVarZzi == null) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC6);
                return 0;
            }
            zzahwVarZzi.zzd(iZzC6);
            this.zzk = zzahwVarZzi;
            return 0;
        }
        zzet zzetVar6 = new zzet(this.zzo);
        zzafzVar.zzc(zzetVar6.zzi(), 0, this.zzo);
        if (zzetVar6.zzd() < 16) {
            i = 0;
            j = 0;
        } else {
            int iZzg = zzetVar6.zzg();
            zzetVar6.zzk(8);
            long jZzC = zzetVar6.zzC();
            i = 0;
            long j5 = this.zzm;
            j = jZzC > j5 ? 0L : j5 + 8;
            zzetVar6.zzh(iZzg);
        }
        while (zzetVar6.zzd() >= 16) {
            int iZzC7 = zzetVar6.zzC();
            int iZzC8 = zzetVar6.zzC();
            long jZzC2 = ((long) zzetVar6.zzC()) + j;
            zzetVar6.zzk(4);
            zzahw zzahwVarZzi2 = zzi(iZzC7);
            if (zzahwVarZzi2 != null) {
                zzahwVarZzi2.zza(jZzC2, (iZzC8 & 16) == 16 ? 1 : i);
            }
        }
        zzahw[] zzahwVarArr = this.zzi;
        int length = zzahwVarArr.length;
        for (int i10 = i; i10 < length; i10++) {
            zzahwVarArr[i10].zzb();
        }
        this.zzp = true;
        int length2 = this.zzi.length;
        zzagb zzagbVar = this.zzf;
        if (length2 == 0) {
            zzagbVar.zzw(new zzaha(this.zzh, 0L));
        } else {
            zzagbVar.zzw(new zzahr(this, this.zzh));
        }
        this.zze = 6;
        this.zzj = this.zzm;
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzahw zzahwVar : this.zzi) {
            zzahwVar.zzf(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public final /* synthetic */ zzahw[] zzh() {
        return this.zzi;
    }
}
