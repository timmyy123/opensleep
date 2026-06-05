package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzmf {
    private final zznm zzc;
    private final zzdz zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzju zzh;
    private zzmc zzi;
    private zzmc zzj;
    private zzmc zzk;
    private zzmc zzl;
    private zzmc zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzln zzr;
    private final zzbd zza = new zzbd();
    private final zzbe zzb = new zzbe();
    private List zzq = new ArrayList();

    public zzmf(zznm zznmVar, zzdz zzdzVar, zzln zzlnVar, zzju zzjuVar) {
        this.zzc = zznmVar;
        this.zzd = zzdzVar;
        this.zzr = zzlnVar;
        this.zzh = zzjuVar;
    }

    private static zzxk zzA(zzbf zzbfVar, Object obj, long j, long j2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.zzo(obj, zzbdVar);
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzbfVar.zze(obj);
        zzbdVar.zzb();
        zzbfVar.zzo(obj, zzbdVar);
        int iZze = zzbdVar.zze(j);
        return iZze == -1 ? new zzxk(obj, j2, zzbdVar.zzf(j)) : new zzxk(obj, iZze, zzbdVar.zzd(iZze), j2);
    }

    private final void zzB() {
        int i = zzgwm.$r8$clinit;
        final zzgwj zzgwjVar = new zzgwj();
        for (zzmc zzmcVarZzp = this.zzi; zzmcVarZzp != null; zzmcVarZzp = zzmcVarZzp.zzp()) {
            zzgwjVar.zzf(zzmcVarZzp.zzg.zza);
        }
        zzmc zzmcVar = this.zzj;
        final zzxk zzxkVar = zzmcVar == null ? null : zzmcVar.zzg.zza;
        this.zzd.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzme
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgwjVar, zzxkVar);
            }
        });
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i);
            if (zzmcVar.zzb.equals(obj)) {
                return zzmcVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final int zzD(zzbf zzbfVar) {
        zzbf zzbfVar2;
        zzmc zzmcVarZzp = this.zzi;
        if (zzmcVarZzp == null) {
            return 0;
        }
        int iZze = zzbfVar.zze(zzmcVarZzp.zzb);
        while (true) {
            zzbfVar2 = zzbfVar;
            iZze = zzbfVar2.zzl(iZze, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzmcVarZzp.getClass();
                if (zzmcVarZzp.zzp() == null || zzmcVarZzp.zzg.zzi) {
                    break;
                }
                zzmcVarZzp = zzmcVarZzp.zzp();
            }
            zzmc zzmcVarZzp2 = zzmcVarZzp.zzp();
            if (iZze == -1 || zzmcVarZzp2 == null || zzbfVar2.zze(zzmcVarZzp2.zzb) != iZze) {
                break;
            }
            zzmcVarZzp = zzmcVarZzp2;
            zzbfVar = zzbfVar2;
        }
        int iZzs = zzs(zzmcVarZzp);
        zzmcVarZzp.zzg = zzx(zzbfVar2, zzmcVarZzp.zzg);
        return iZzs;
    }

    private final zzmd zzE(zzbf zzbfVar, zzmc zzmcVar, long j) {
        zzbf zzbfVar2;
        long jLongValue;
        long j2;
        long j3;
        zzbf zzbfVar3;
        zzbd zzbdVar;
        zzbe zzbeVar;
        long j4;
        long j5;
        long j6;
        Object obj;
        long j7;
        zzmd zzmdVar = zzmcVar.zzg;
        long jZza = zzmcVar.zza();
        long j8 = zzmdVar.zzf;
        boolean z = zzmdVar.zzi;
        long j9 = (jZza + j8) - j;
        zzxk zzxkVar = zzmdVar.zza;
        long j10 = 0;
        if (!z) {
            Object obj2 = zzxkVar.zza;
            zzbd zzbdVar2 = this.zza;
            zzbfVar.zzo(obj2, zzbdVar2);
            if (!zzxkVar.zzb()) {
                int i = zzxkVar.zze;
                if (i != -1) {
                    zzbdVar2.zzi(i);
                }
                int iZzd = zzbdVar2.zzd(i);
                zzbdVar2.zzk(i);
                if (iZzd != zzbdVar2.zzg(i)) {
                    return zzG(zzbfVar, obj2, i, iZzd, j8, zzxkVar.zzd, false);
                }
                zzK(zzbfVar, obj2, i);
                return zzH(zzbfVar, obj2, 0L, -9223372036854775807L, j8, zzxkVar.zzd, false);
            }
            int i2 = zzxkVar.zzb;
            if (zzbdVar2.zzg(i2) == -1) {
                return null;
            }
            int iZza = zzbdVar2.zzg.zza(i2).zza(zzxkVar.zzc);
            long j11 = zzmdVar.zzd;
            if (iZza < 0) {
                return zzG(zzbfVar, obj2, i2, iZza, j11, zzxkVar.zzd, false);
            }
            if (j11 == -9223372036854775807L) {
                zzbe zzbeVar2 = this.zzb;
                long jMax = zzL(zzbfVar, zzbdVar2.zzc, zzbdVar2.zzd, zzbeVar2) ? Math.max(0L, j9) : -9223372036854775807L;
                zzbfVar2 = zzbfVar;
                Pair pairZzn = zzbfVar2.zzn(zzbeVar2, zzbdVar2, zzbdVar2.zzc, -9223372036854775807L, jMax);
                if (pairZzn == null) {
                    return null;
                }
                jLongValue = ((Long) pairZzn.second).longValue();
                j3 = jMax;
                j2 = -9223372036854775807L;
            } else {
                zzbfVar2 = zzbfVar;
                jLongValue = j11;
                j2 = jLongValue;
                j3 = -9223372036854775807L;
            }
            zzK(zzbfVar2, obj2, i2);
            return zzH(zzbfVar2, obj2, Math.max(0L, jLongValue), j3, j2, zzxkVar.zzd, false);
        }
        Object obj3 = zzxkVar.zza;
        int iZze = zzbfVar.zze(obj3);
        int i3 = this.zzf;
        boolean z2 = this.zzg;
        zzbe zzbeVar3 = this.zzb;
        zzbd zzbdVar3 = this.zza;
        int iZzl = zzbfVar.zzl(iZze, zzbdVar3, zzbeVar3, i3, z2);
        if (iZzl == -1) {
            return null;
        }
        int i4 = zzbfVar.zzd(iZzl, zzbdVar3, true).zzc;
        Object obj4 = zzbdVar3.zzb;
        obj4.getClass();
        long j12 = zzxkVar.zzd;
        if (zzbfVar.zzb(i4, zzbeVar3, 0L).zzn == iZzl) {
            long jMax2 = zzL(zzbfVar, zzbdVar3.zzc, zzbdVar3.zzd, zzbeVar3) ? Math.max(0L, j9) : -9223372036854775807L;
            Pair pairZzn2 = zzbfVar.zzn(zzbeVar3, zzbdVar3, i4, -9223372036854775807L, jMax2);
            if (pairZzn2 == null) {
                return null;
            }
            Object obj5 = pairZzn2.first;
            long jLongValue2 = ((Long) pairZzn2.second).longValue();
            zzmc zzmcVarZzp = zzmcVar.zzp();
            if (zzmcVarZzp == null || !zzmcVarZzp.zzb.equals(obj5)) {
                long jZzC = zzC(obj5);
                if (jZzC == -1) {
                    jZzC = this.zze;
                    this.zze = 1 + jZzC;
                }
                j7 = jZzC;
            } else {
                j7 = zzmcVarZzp.zzg.zza.zzd;
            }
            long j13 = jMax2;
            zzbeVar = zzbeVar3;
            obj = obj5;
            j4 = j7;
            j6 = j13;
            zzbfVar3 = zzbfVar;
            zzbdVar = zzbdVar3;
            j5 = jLongValue2;
            j10 = -9223372036854775807L;
        } else {
            zzbfVar3 = zzbfVar;
            zzbdVar = zzbdVar3;
            zzbeVar = zzbeVar3;
            j4 = j12;
            j5 = 0;
            j6 = -9223372036854775807L;
            obj = obj4;
        }
        zzxk zzxkVarZzA = zzA(zzbfVar3, obj, j5, j4, zzbeVar, zzbdVar);
        long j14 = j5;
        zzbd zzbdVar4 = zzbdVar;
        if (j10 != -9223372036854775807L && zzmdVar.zzd != -9223372036854775807L) {
            zzbfVar3.zzo(obj3, zzbdVar4).zzb();
            int i5 = zzbdVar4.zzg.zzd;
        }
        return zzF(zzbfVar3, zzxkVarZzA, j10, j14, j6);
    }

    private final zzmd zzF(zzbf zzbfVar, zzxk zzxkVar, long j, long j2, long j3) {
        Object obj = zzxkVar.zza;
        zzbfVar.zzo(obj, this.zza);
        return zzxkVar.zzb() ? zzG(zzbfVar, obj, zzxkVar.zzb, zzxkVar.zzc, j, zzxkVar.zzd, false) : zzH(zzbfVar, obj, j2, j3, j, zzxkVar.zzd, false);
    }

    private final zzmd zzG(zzbf zzbfVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzxk zzxkVar = new zzxk(obj, i, i2, j2);
        Object obj2 = zzxkVar.zza;
        int i3 = zzxkVar.zzb;
        int i4 = zzxkVar.zzc;
        zzbd zzbdVar = this.zza;
        long jZzh = zzbfVar.zzo(obj2, zzbdVar).zzh(i3, i4);
        if (i2 == zzbdVar.zzd(i)) {
            zzbdVar.zzj();
        }
        zzbdVar.zzk(i3);
        long jMax = 0;
        if (jZzh != -9223372036854775807L && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzmd(zzxkVar, jMax, -9223372036854775807L, j, -9223372036854775807L, jZzh, false, false, false, false, false);
    }

    private final zzmd zzH(zzbf zzbfVar, Object obj, long j, long j2, long j3, long j4, boolean z) {
        long j5;
        long j6;
        long j7;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        int iZzf = zzbdVar.zzf(j);
        if (iZzf == -1) {
            zzbdVar.zzb();
        } else {
            zzbdVar.zzk(iZzf);
        }
        zzxk zzxkVar = new zzxk(obj, j4, iZzf);
        boolean zZzM = zzM(zzxkVar);
        boolean zZzI = zzI(zzbfVar, zzxkVar);
        boolean zZzJ = zzJ(zzbfVar, zzxkVar, zZzM);
        if (iZzf != -1) {
            zzbdVar.zzk(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzi(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzc(iZzf);
            j5 = 0;
        } else {
            j5 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L) {
            j7 = j5;
            j6 = j7;
        } else {
            j6 = zzbdVar.zzd;
            j7 = -9223372036854775807L;
        }
        return new zzmd(zzxkVar, (j6 == -9223372036854775807L || j < j6) ? j : Math.max(0L, j6 - 1), j2, j3, j7, j6, false, false, zZzM, zZzI, zZzJ);
    }

    private final boolean zzI(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzM(zzxkVar)) {
            return false;
        }
        Object obj = zzxkVar.zza;
        return zzbfVar.zzb(zzbfVar.zzo(obj, this.zza).zzc, this.zzb, 0L).zzo == zzbfVar.zze(obj);
    }

    private final boolean zzJ(zzbf zzbfVar, zzxk zzxkVar, boolean z) {
        int iZze = zzbfVar.zze(zzxkVar.zza);
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzd(iZze, zzbdVar, false).zzc;
        zzbe zzbeVar = this.zzb;
        return !zzbfVar.zzb(i, zzbeVar, 0L).zzi && zzbfVar.zzl(iZze, zzbdVar, zzbeVar, this.zzf, this.zzg) == -1 && z;
    }

    private final long zzK(zzbf zzbfVar, Object obj, int i) {
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        zzbdVar.zzc(i);
        long j = zzbdVar.zzg.zza(i).zzi;
        return 0L;
    }

    private static boolean zzL(zzbf zzbfVar, int i, long j, zzbe zzbeVar) {
        if (j == -9223372036854775807L) {
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzi && !zzbeVar.zzk) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzM(zzxk zzxkVar) {
        return !zzxkVar.zzb() && zzxkVar.zze == -1;
    }

    public final int zza(zzbf zzbfVar, int i) {
        this.zzf = i;
        return zzD(zzbfVar);
    }

    public final int zzb(zzbf zzbfVar, boolean z) {
        this.zzg = z;
        return zzD(zzbfVar);
    }

    public final void zzc(zzbf zzbfVar, zzju zzjuVar) {
        this.zzh = zzjuVar;
        long j = zzjuVar.zzb;
        zzj();
    }

    public final boolean zzd(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final boolean zze(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzm;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final void zzf(long j) {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            zzmcVar.zzi(j);
        }
    }

    public final boolean zzg() {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            return !zzmcVar.zzg.zzk && zzmcVar.zzd() && this.zzl.zzg.zzf != -9223372036854775807L && this.zzn < 100;
        }
        return true;
    }

    public final zzmd zzh(long j, zzms zzmsVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar == null ? zzF(zzmsVar.zza, zzmsVar.zzb, zzmsVar.zzc, zzmsVar.zzs, -9223372036854775807L) : zzE(zzmsVar.zza, zzmcVar, j);
    }

    public final zzmc zzi(zzmd zzmdVar) {
        zzmc zzmcVarZza;
        zzmc zzmcVar = this.zzl;
        long jZza = zzmcVar == null ? 1000000000000L : (zzmcVar.zza() + zzmcVar.zzg.zzf) - zzmdVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzmcVarZza = null;
                break;
            }
            zzmd zzmdVar2 = ((zzmc) this.zzq.get(i)).zzg;
            long j = zzmdVar2.zzf;
            long j2 = zzmdVar.zzf;
            if ((j == -9223372036854775807L || j == j2) && zzmdVar2.zzb == zzmdVar.zzb && zzmdVar2.zza.equals(zzmdVar.zza)) {
                zzmcVarZza = (zzmc) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzmcVarZza == null) {
            zzmcVarZza = this.zzr.zza(zzmdVar, jZza);
        } else {
            zzmcVarZza.zzg = zzmdVar;
            zzmcVarZza.zzb(jZza);
        }
        zzmc zzmcVar2 = this.zzl;
        if (zzmcVar2 != null) {
            zzmcVar2.zzo(zzmcVarZza);
        } else {
            this.zzi = zzmcVarZza;
            this.zzj = zzmcVarZza;
            this.zzk = zzmcVarZza;
        }
        this.zzo = null;
        this.zzl = zzmcVarZza;
        this.zzn++;
        zzB();
        return zzmcVarZza;
    }

    public final void zzj() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzmc) this.zzq.get(i)).zzn();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final zzmc zzk() {
        return this.zzl;
    }

    public final zzmc zzl() {
        return this.zzm;
    }

    public final zzmc zzm() {
        return this.zzi;
    }

    public final zzmc zzn() {
        return this.zzj;
    }

    public final zzmc zzo() {
        return this.zzk;
    }

    public final zzmc zzp() {
        zzmc zzmcVar = this.zzk;
        zzmc zzmcVar2 = this.zzj;
        if (zzmcVar == zzmcVar2) {
            zzmcVar2.getClass();
            this.zzk = zzmcVar2.zzp();
        }
        zzmcVar2.getClass();
        this.zzj = zzmcVar2.zzp();
        zzB();
        zzmc zzmcVar3 = this.zzj;
        zzmcVar3.getClass();
        return zzmcVar3;
    }

    public final zzmc zzq() {
        zzmc zzmcVar = this.zzk;
        zzmcVar.getClass();
        this.zzk = zzmcVar.zzp();
        zzB();
        zzmc zzmcVar2 = this.zzk;
        zzmcVar2.getClass();
        return zzmcVar2;
    }

    public final zzmc zzr() {
        zzmc zzmcVar = this.zzi;
        if (zzmcVar == null) {
            return null;
        }
        if (zzmcVar == this.zzj) {
            this.zzj = zzmcVar.zzp();
        }
        if (zzmcVar == this.zzk) {
            this.zzk = zzmcVar.zzp();
        }
        zzmcVar.zzn();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzmc zzmcVar2 = this.zzi;
            this.zzo = zzmcVar2.zzb;
            this.zzp = zzmcVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzp();
        zzB();
        return this.zzi;
    }

    public final int zzs(zzmc zzmcVar) {
        zzmcVar.getClass();
        int i = 0;
        if (zzmcVar != this.zzl) {
            this.zzl = zzmcVar;
            while (zzmcVar.zzp() != null) {
                zzmcVar = zzmcVar.zzp();
                zzmcVar.getClass();
                if (zzmcVar == this.zzj) {
                    zzmc zzmcVar2 = this.zzi;
                    this.zzj = zzmcVar2;
                    this.zzk = zzmcVar2;
                    i = 3;
                }
                if (zzmcVar == this.zzk) {
                    this.zzk = this.zzj;
                    i |= 2;
                }
                zzmcVar.zzn();
                this.zzn--;
            }
            zzmc zzmcVar3 = this.zzl;
            zzmcVar3.getClass();
            zzmcVar3.zzo(null);
            zzB();
        }
        return i;
    }

    public final void zzt() {
        zzmc zzmcVar = this.zzm;
        if (zzmcVar == null || zzmcVar.zze()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzmc zzmcVar2 = (zzmc) this.zzq.get(i);
                if (!zzmcVar2.zze()) {
                    this.zzm = zzmcVar2;
                    return;
                }
            }
        }
    }

    public final zzmc zzu(zzxi zzxiVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i);
            if (zzmcVar.zza == zzxiVar) {
                return zzmcVar;
            }
        }
        return null;
    }

    public final void zzv() {
        if (this.zzn == 0) {
            return;
        }
        zzmc zzmcVarZzp = this.zzi;
        zzmcVarZzp.getClass();
        this.zzo = zzmcVarZzp.zzb;
        this.zzp = zzmcVarZzp.zzg.zza.zzd;
        while (zzmcVarZzp != null) {
            zzmcVarZzp.zzn();
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzB();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzw(zzbf zzbfVar, long j, long j2, long j3) {
        zzmd zzmdVarZzE;
        long j4;
        zzmd zzmdVar;
        int i;
        zzmd zzmdVar2;
        int i2;
        zzmc zzmcVarZzp = this.zzi;
        zzmc zzmcVar = null;
        while (zzmcVarZzp != null) {
            zzmd zzmdVar3 = zzmcVarZzp.zzg;
            if (zzmcVar != null) {
                zzmdVarZzE = zzE(zzbfVar, zzmcVar, j);
                if (zzmdVarZzE != null && zzmdVar3.zza.equals(zzmdVarZzE.zza)) {
                    long j5 = zzmdVar3.zzb;
                    long j6 = zzmdVarZzE.zzb;
                    if (j5 == j6) {
                        zzmdVar = zzmdVar3;
                        j4 = -9223372036854775807L;
                        i = 0;
                    } else {
                        j4 = -9223372036854775807L;
                        long j7 = zzmdVar3.zzc;
                        if (j7 != -9223372036854775807L) {
                            zzmdVar = zzmdVar3;
                            i = 0;
                            long j8 = zzmdVarZzE.zzc;
                            if (j8 != -9223372036854775807L) {
                                if (Math.abs((j6 - j8) - (j5 - j7)) >= 5000000) {
                                }
                            }
                        }
                    }
                    if (j5 != j6) {
                        zzmdVar2 = zzmdVar;
                        zzmdVarZzE = zzmdVarZzE.zza(j5, zzmdVar2.zzc);
                    } else {
                        zzmdVar2 = zzmdVar;
                    }
                }
                return zzs(zzmcVar);
            }
            zzmdVarZzE = zzx(zzbfVar, zzmdVar3);
            zzmdVar2 = zzmdVar3;
            j4 = -9223372036854775807L;
            i = 0;
            zzmcVarZzp.zzg = zzmdVarZzE.zzb(zzmdVar2.zzd);
            long j9 = zzmdVar2.zzf;
            long j10 = zzmdVarZzE.zzf;
            if (j9 != j10) {
                zzmcVarZzp.zzs();
                long jZza = j10 == j4 ? Long.MAX_VALUE : j10 + zzmcVarZzp.zza();
                if (zzmcVarZzp == this.zzj) {
                    boolean z = zzmcVarZzp.zzg.zzh;
                    i2 = (j2 == Long.MIN_VALUE || j2 >= jZza) ? 1 : i;
                }
                int i3 = (zzmcVarZzp != this.zzk || (j3 != Long.MIN_VALUE && j3 < jZza)) ? i : 1;
                int iZzs = zzs(zzmcVarZzp);
                if (iZzs != 0) {
                    return iZzs;
                }
                if (j9 == j4) {
                    j9 = j4;
                }
                int i4 = (i2 == 0 || j9 == j4) ? i : 1;
                return i3 != 0 ? i4 | 2 : i4;
            }
            zzmcVar = zzmcVarZzp;
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzmd zzx(zzbf zzbfVar, zzmd zzmdVar) {
        long j;
        long jZzh;
        long j2;
        long j3;
        int i;
        zzxk zzxkVar = zzmdVar.zza;
        boolean zZzM = zzM(zzxkVar);
        boolean zZzI = zzI(zzbfVar, zzxkVar);
        boolean zZzJ = zzJ(zzbfVar, zzxkVar, zZzM);
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        if (zzxkVar.zzb() || (i = zzxkVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbdVar.zzc(i);
            j = 0;
        }
        if (zzxkVar.zzb()) {
            jZzh = zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc);
        } else {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
                if (zzxkVar.zzb()) {
                    int i2 = zzxkVar.zze;
                    if (i2 != -1) {
                        zzbdVar.zzk(i2);
                    }
                } else {
                    zzbdVar.zzk(zzxkVar.zzb);
                }
                return new zzmd(zzxkVar, zzmdVar.zzb, zzmdVar.zzc, zzmdVar.zzd, j2, j3, false, false, zZzM, zZzI, zZzJ);
            }
            jZzh = zzbdVar.zzd;
        }
        j2 = j;
        j3 = jZzh;
        if (zzxkVar.zzb()) {
        }
        return new zzmd(zzxkVar, zzmdVar.zzb, zzmdVar.zzc, zzmdVar.zzd, j2, j3, false, false, zZzM, zZzI, zZzJ);
    }

    public final zzxk zzy(zzbf zzbfVar, Object obj, long j) {
        long jZzC;
        int iZze;
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZze = zzbfVar.zze(obj2)) == -1 || zzbfVar.zzd(iZze, zzbdVar, false).zzc != i) {
            zzmc zzmcVarZzp = this.zzi;
            while (true) {
                if (zzmcVarZzp == null) {
                    zzmc zzmcVarZzp2 = this.zzi;
                    while (true) {
                        if (zzmcVarZzp2 != null) {
                            int iZze2 = zzbfVar.zze(zzmcVarZzp2.zzb);
                            if (iZze2 != -1 && zzbfVar.zzd(iZze2, zzbdVar, false).zzc == i) {
                                jZzC = zzmcVarZzp2.zzg.zza.zzd;
                                break;
                            }
                            zzmcVarZzp2 = zzmcVarZzp2.zzp();
                        } else {
                            jZzC = zzC(obj);
                            if (jZzC == -1) {
                                jZzC = this.zze;
                                this.zze = 1 + jZzC;
                                if (this.zzi == null) {
                                    this.zzo = obj;
                                    this.zzp = jZzC;
                                }
                            }
                        }
                    }
                } else {
                    if (zzmcVarZzp.zzb.equals(obj)) {
                        jZzC = zzmcVarZzp.zzg.zza.zzd;
                        break;
                    }
                    zzmcVarZzp = zzmcVarZzp.zzp();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j2 = jZzC;
        zzbfVar.zzo(obj, zzbdVar);
        int i2 = zzbdVar.zzc;
        zzbe zzbeVar = this.zzb;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        Object obj3 = obj;
        for (int iZze3 = zzbfVar.zze(obj); iZze3 >= zzbeVar.zzn; iZze3--) {
            zzbfVar.zzd(iZze3, zzbdVar, true);
            zzbdVar.zzb();
            if (zzbdVar.zze(zzbdVar.zzd) != -1) {
                Object obj4 = zzbdVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzA(zzbfVar, obj3, j, j2, zzbeVar, zzbdVar);
    }

    public final /* synthetic */ void zzz(zzgwj zzgwjVar, zzxk zzxkVar) {
        this.zzc.zzz(zzgwjVar.zzi(), zzxkVar);
    }
}
