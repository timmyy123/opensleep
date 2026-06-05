package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.math.RoundingMode;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakp implements zzafy {
    public static final /* synthetic */ int $r8$clinit = 0;
    private final zzahk zzf;
    private zzagb zzg;
    private zzahk zzh;
    private zzahk zzi;
    private int zzj;
    private zzap zzk;
    private zzap zzl;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private zzakt zzr;
    private boolean zzs;
    private final zzet zzb = new zzet(10);
    private final zzagv zzc = new zzagv();
    private final zzagr zzd = new zzagr();
    private long zzm = -9223372036854775807L;
    private final zzagt zze = new zzagt();

    public zzakp(int i) {
        zzafv zzafvVar = new zzafv();
        this.zzf = zzafvVar;
        this.zzi = zzafvVar;
        this.zzp = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0256  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zzi(zzafz zzafzVar) {
        int i;
        long j;
        int i2;
        zzakt zzakkVar;
        int i3;
        int i4;
        zzap zzapVar;
        long jZzn;
        zzajr zzajrVar;
        zzakm zzakmVarZze;
        zzakt zzaksVar;
        zzap zzapVarZzf;
        if (this.zzj == 0) {
            try {
                zzk(zzafzVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzr == null) {
            zzagv zzagvVar = this.zzc;
            zzet zzetVar = new zzet(zzagvVar.zzc);
            zzafzVar.zzi(zzetVar.zzi(), 0, zzagvVar.zzc);
            int i5 = zzagvVar.zza & 1;
            int i6 = zzagvVar.zze;
            int i7 = 21;
            if (i5 != 0) {
                if (i6 != 1) {
                    i7 = 36;
                }
            } else if (i6 == 1) {
                i7 = 13;
            }
            if (zzetVar.zze() >= i7 + 4) {
                zzetVar.zzh(i7);
                int iZzB = zzetVar.zzB();
                if (iZzB != 1483304551) {
                    if (iZzB == 1231971951) {
                        iZzB = 1231971951;
                    } else if (zzetVar.zze() >= 40) {
                        zzetVar.zzh(36);
                        iZzB = zzetVar.zzB() == 1447187017 ? 1447187017 : 0;
                    }
                }
                zzakt zzaktVar = null;
                if (iZzB == 1231971951) {
                    zzakv zzakvVarZza = zzakv.zza(zzagvVar, zzetVar);
                    zzagr zzagrVar = this.zzd;
                    if (!zzagrVar.zzb() && (i3 = zzakvVarZza.zze) != -1 && (i4 = zzakvVarZza.zzf) != -1) {
                        zzagrVar.zza = i3;
                        zzagrVar.zzb = i4;
                    }
                    zzakr zzakrVar = zzakvVarZza.zzd;
                    this.zzl = zzakrVar != null ? new zzap(-9223372036854775807L, zzakrVar) : null;
                    long jZzn2 = zzafzVar.zzn();
                    if (zzafzVar.zzo() != -1) {
                        long j2 = zzakvVarZza.zzc;
                        if (j2 != -1) {
                            long j3 = j2 + jZzn2;
                            if (zzafzVar.zzo() != j3) {
                                j = -9223372036854775807L;
                                long jZzo = zzafzVar.zzo();
                                StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + String.valueOf(jZzo).length() + 53 + 20);
                                i = -1;
                                zzba$$ExternalSyntheticOutline0.m(sb, "Data size mismatch between stream (", jZzo, ") and Xing frame (");
                                sb.append(j3);
                                sb.append("), using Xing value.");
                                zzeg.zzb("Mp3Extractor", sb.toString());
                            } else {
                                i = -1;
                                j = -9223372036854775807L;
                            }
                            zzafzVar.zzf(zzagvVar.zzc);
                            if (iZzB == 1483304551) {
                                zzakkVar = zzakw.zze(zzakvVarZza, jZzn2);
                            } else {
                                long jZzo2 = zzafzVar.zzo();
                                long jZzb = zzakvVarZza.zzb();
                                if (jZzb == j) {
                                    zzakkVar = null;
                                } else {
                                    long j4 = zzakvVarZza.zzc;
                                    if (j4 != -1) {
                                        jZzo2 = jZzn2 + j4;
                                        i2 = zzakvVarZza.zza.zzc;
                                    } else {
                                        if (jZzo2 != -1) {
                                            j4 = jZzo2 - jZzn2;
                                            i2 = zzakvVarZza.zza.zzc;
                                        }
                                        zzakkVar = null;
                                    }
                                    long j5 = j4 - ((long) i2);
                                    long j6 = jZzo2;
                                    RoundingMode roundingMode = RoundingMode.HALF_UP;
                                    zzakkVar = new zzakk(j6, jZzn2 + ((long) zzakvVarZza.zza.zzc), zzhah.zza(zzfl.zzv(j5, 8000000L, jZzb, roundingMode)), zzhah.zza(zzhab.zza(j5, zzakvVarZza.zzb, roundingMode)), false);
                                }
                            }
                            zzapVar = this.zzk;
                            jZzn = zzafzVar.zzn();
                            if (zzapVar != null || (zzajrVar = (zzajr) zzapVar.zzc(zzajr.class, zzgtn.zza())) == null) {
                                zzakmVarZze = null;
                            } else {
                                zzajt zzajtVar = (zzajt) zzapVar.zzc(zzajt.class, zzako.zza);
                                zzakmVarZze = zzakm.zze(jZzn, zzajrVar, zzajtVar != null ? j : zzfl.zzs(Long.parseLong((String) zzajtVar.zzb.get(0))));
                            }
                            if (this.zzs) {
                                if (zzakmVarZze != null) {
                                    zzaktVar = zzakmVarZze;
                                } else if (zzakkVar != null) {
                                    zzaktVar = zzakkVar;
                                }
                                if (zzaktVar == null) {
                                    zzet zzetVar2 = this.zzb;
                                    zzafzVar.zzi(zzetVar2.zzi(), 0, 4);
                                    zzetVar2.zzh(0);
                                    zzagvVar.zza(zzetVar2.zzB());
                                    zzakk zzakkVar2 = new zzakk(zzafzVar.zzo(), zzafzVar.zzn(), zzagvVar, false);
                                    zzagvVar = zzagvVar;
                                    zzaksVar = zzakkVar2;
                                } else {
                                    zzaksVar = zzaktVar;
                                }
                                this.zzh.zzO(zzaksVar.zza());
                            } else {
                                zzaksVar = new zzaks();
                            }
                            this.zzr = zzaksVar;
                            this.zzg.zzw(zzaksVar);
                            zzapVarZzf = this.zzk;
                            zzap zzapVar2 = this.zzl;
                            if (zzapVarZzf != null) {
                                zzapVarZzf = zzapVar2;
                            } else if (zzapVar2 != null) {
                                zzapVarZzf = zzapVarZzf.zzf(zzapVar2);
                            }
                            zzt zztVar = new zzt();
                            zztVar.zzn("audio/mpeg");
                            zztVar.zzo(zzagvVar.zzb);
                            zztVar.zzp(4096);
                            zztVar.zzG(zzagvVar.zze);
                            zztVar.zzH(zzagvVar.zzd);
                            zzagr zzagrVar2 = this.zzd;
                            zztVar.zzJ(zzagrVar2.zza);
                            zztVar.zzK(zzagrVar2.zzb);
                            zztVar.zzl(zzapVarZzf);
                            if (this.zzr.zzh() != -2147483647) {
                                zztVar.zzi(this.zzr.zzh());
                            }
                            this.zzi.zzA(zztVar.zzO());
                            this.zzo = zzafzVar.zzn();
                        }
                    }
                } else if (iZzB != 1447187017) {
                    if (iZzB != 1483304551) {
                        zzafzVar.zzl();
                        i = -1;
                        j = -9223372036854775807L;
                    }
                    zzakkVar = null;
                    zzapVar = this.zzk;
                    jZzn = zzafzVar.zzn();
                    if (zzapVar != null) {
                        zzajt zzajtVar2 = (zzajt) zzapVar.zzc(zzajt.class, zzako.zza);
                        zzakmVarZze = zzakm.zze(jZzn, zzajrVar, zzajtVar2 != null ? j : zzfl.zzs(Long.parseLong((String) zzajtVar2.zzb.get(0))));
                        if (this.zzs) {
                        }
                        this.zzr = zzaksVar;
                        this.zzg.zzw(zzaksVar);
                        zzapVarZzf = this.zzk;
                        zzap zzapVar22 = this.zzl;
                        if (zzapVarZzf != null) {
                        }
                        zzt zztVar2 = new zzt();
                        zztVar2.zzn("audio/mpeg");
                        zztVar2.zzo(zzagvVar.zzb);
                        zztVar2.zzp(4096);
                        zztVar2.zzG(zzagvVar.zze);
                        zztVar2.zzH(zzagvVar.zzd);
                        zzagr zzagrVar22 = this.zzd;
                        zztVar2.zzJ(zzagrVar22.zza);
                        zztVar2.zzK(zzagrVar22.zzb);
                        zztVar2.zzl(zzapVarZzf);
                        if (this.zzr.zzh() != -2147483647) {
                        }
                        this.zzi.zzA(zztVar2.zzO());
                        this.zzo = zzafzVar.zzn();
                    }
                } else {
                    zzakkVar = zzaku.zze(zzafzVar.zzo(), zzafzVar.zzn(), zzagvVar, zzetVar);
                    zzafzVar.zzf(zzagvVar.zzc);
                    i = -1;
                    j = -9223372036854775807L;
                    zzapVar = this.zzk;
                    jZzn = zzafzVar.zzn();
                    if (zzapVar != null) {
                    }
                }
            }
        } else {
            i = -1;
            j = -9223372036854775807L;
            long j7 = this.zzo;
            if (j7 != 0) {
                long jZzn3 = zzafzVar.zzn();
                if (jZzn3 < j7) {
                    zzafzVar.zzf((int) (j7 - jZzn3));
                }
            }
        }
        int i8 = this.zzq;
        if (i8 == 0) {
            zzafzVar.zzl();
            if (zzl(zzafzVar)) {
                return i;
            }
            zzet zzetVar3 = this.zzb;
            zzetVar3.zzh(0);
            int iZzB2 = zzetVar3.zzB();
            if (!zzn(iZzB2, this.zzj) || zzagw.zza(iZzB2) == i) {
                zzafzVar.zzf(1);
                this.zzj = 0;
                return 0;
            }
            zzagv zzagvVar2 = this.zzc;
            zzagvVar2.zza(iZzB2);
            if (this.zzm == j) {
                this.zzm = this.zzr.zzf(zzafzVar.zzn());
            }
            i8 = zzagvVar2.zzc;
            this.zzq = i8;
            this.zzp = zzafzVar.zzn() + ((long) i8);
        }
        int iZza = this.zzi.zza(zzafzVar, i8, true);
        if (iZza == -1) {
            return -1;
        }
        int i9 = this.zzq - iZza;
        this.zzq = i9;
        if (i9 > 0) {
            return 0;
        }
        zzahk zzahkVar = this.zzi;
        long jZzj = zzj(this.zzn);
        zzagv zzagvVar3 = this.zzc;
        zzahkVar.zze(jZzj, 1, zzagvVar3.zzc, 0, null);
        this.zzn += (long) zzagvVar3.zzg;
        this.zzq = 0;
        return 0;
    }

    private final long zzj(long j) {
        zzagv zzagvVar = this.zzc;
        return ((j * 1000000) / ((long) zzagvVar.zzd)) + this.zzm;
    }

    private final boolean zzk(zzafz zzafzVar, boolean z) throws EOFException {
        int iZzm;
        int i;
        int iZza;
        zzafzVar.zzl();
        if (zzafzVar.zzn() == 0) {
            zzap zzapVarZza = this.zze.zza(zzafzVar, null, 131072);
            this.zzk = zzapVarZza;
            if (zzapVarZza != null) {
                this.zzd.zza(zzapVarZza);
            }
            iZzm = (int) zzafzVar.zzm();
            if (!z) {
                zzafzVar.zzf(iZzm);
            }
            i = 0;
        } else {
            iZzm = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (!zzl(zzafzVar)) {
                zzet zzetVar = this.zzb;
                zzetVar.zzh(0);
                int iZzB = zzetVar.zzB();
                if ((i == 0 || zzn(iZzB, i)) && (iZza = zzagw.zza(iZzB)) != -1) {
                    i2++;
                    if (i2 != 1) {
                        if (i2 == 4) {
                            break;
                        }
                    } else {
                        this.zzc.zza(iZzB);
                        i = iZzB;
                    }
                    zzafzVar.zzk(iZza - 4);
                } else {
                    int i4 = i3 + 1;
                    if (i3 == 131072) {
                        if (z) {
                            return false;
                        }
                        zzm();
                        Utf8$$ExternalSyntheticBUOutline0.m$2();
                        return false;
                    }
                    if (z) {
                        zzafzVar.zzl();
                        zzafzVar.zzk(iZzm + i4);
                    } else {
                        zzafzVar.zzf(1);
                    }
                    i2 = 0;
                    i3 = i4;
                    i = 0;
                }
            } else if (i2 <= 0) {
                zzm();
                Utf8$$ExternalSyntheticBUOutline0.m$2();
                return false;
            }
        }
        if (z) {
            zzafzVar.zzf(iZzm + i3);
        } else {
            zzafzVar.zzl();
        }
        this.zzj = i;
        return true;
    }

    private final boolean zzl(zzafz zzafzVar) {
        zzakt zzaktVar = this.zzr;
        if (zzaktVar != null) {
            long jZzg = zzaktVar.zzg();
            if (jZzg != -1 && zzafzVar.zzm() > jZzg - 4) {
                return true;
            }
        }
        try {
            return !zzafzVar.zzh(this.zzb.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final void zzm() {
        zzakt zzaktVar = this.zzr;
        if ((zzaktVar instanceof zzakk) && zzaktVar.zzb()) {
            long j = this.zzp;
            if (j == -1 || j == this.zzr.zzg()) {
                return;
            }
            this.zzr = ((zzakk) this.zzr).zzi(this.zzp);
            zzagb zzagbVar = this.zzg;
            zzagbVar.getClass();
            zzagbVar.zzw(this.zzr);
            this.zzh.getClass();
            this.zzr.zza();
        }
    }

    private static boolean zzn(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) {
        return zzk(zzafzVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzg = zzagbVar;
        zzahk zzahkVarZzu = zzagbVar.zzu(0, 1);
        this.zzh = zzahkVarZzu;
        this.zzi = zzahkVarZzu;
        this.zzg.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) {
        this.zzh.getClass();
        String str = zzfl.zza;
        return zzi(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzj = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0L;
        this.zzq = 0;
        this.zzp = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public final void zzh() {
        this.zzs = true;
    }
}
