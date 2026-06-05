package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzzb implements zzahk {
    private zzv zzA;
    private boolean zzC;
    private final zzyw zza;
    private final zzun zzd;
    private final zzui zze;
    private zzza zzf;
    private zzv zzg;
    private zzug zzh;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzx;
    private final zzyx zzb = new zzyx();
    private int zzi = 1000;
    private long[] zzj = new long[1000];
    private long[] zzk = new long[1000];
    private long[] zzn = new long[1000];
    private int[] zzm = new int[1000];
    private int[] zzl = new int[1000];
    private zzahj[] zzo = new zzahj[1000];
    private final zzzi zzc = new zzzi(zzyy.zza);
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private long zzv = Long.MIN_VALUE;
    private boolean zzz = true;
    private boolean zzy = true;
    private boolean zzB = true;
    private int zzw = -1;

    public zzzb(zzabl zzablVar, zzun zzunVar, zzui zzuiVar) {
        this.zzd = zzunVar;
        this.zze = zzuiVar;
        this.zza = new zzyw(zzablVar);
    }

    private final synchronized void zzB() {
        this.zzs = 0;
        this.zza.zzb();
    }

    private final synchronized int zzC(zzlw zzlwVar, zziv zzivVar, boolean z, boolean z2, zzyx zzyxVar) {
        boolean z3 = false;
        zzivVar.zzd = false;
        int i = this.zzq + this.zzs;
        if (this.zzw != -1 && i >= 0) {
            z3 = true;
        }
        if (zzI() && !z3) {
            zzv zzvVar = ((zzyz) this.zzc.zza(i)).zza;
            if (!z && zzvVar == this.zzg) {
                int iZzN = zzN(this.zzs);
                if (!zzK(iZzN)) {
                    zzivVar.zzd = true;
                    return -3;
                }
                zzivVar.zzg(this.zzm[iZzN]);
                if (this.zzs == this.zzp - 1 && (z2 || this.zzx)) {
                    zzivVar.zzh(536870912);
                }
                zzivVar.zze = this.zzn[iZzN];
                zzyxVar.zza = this.zzl[iZzN];
                zzyxVar.zzb = this.zzk[iZzN];
                zzyxVar.zzc = this.zzo[iZzN];
                return -4;
            }
            zzJ(zzvVar, zzlwVar);
            return -5;
        }
        if (!z2 && !this.zzx && !z3) {
            zzv zzvVar2 = this.zzA;
            if (zzvVar2 == null || (!z && zzvVar2 == this.zzg)) {
                return -3;
            }
            zzJ(zzvVar2, zzlwVar);
            return -5;
        }
        zzivVar.zzg(4);
        zzivVar.zze = Long.MIN_VALUE;
        return -4;
    }

    private final synchronized boolean zzD(zzv zzvVar) {
        try {
            this.zzz = false;
            if (Objects.equals(zzvVar, this.zzA)) {
                return false;
            }
            zzzi zzziVar = this.zzc;
            if (zzziVar.zzf() || !((zzyz) zzziVar.zzc()).zza.equals(zzvVar)) {
                this.zzA = zzvVar;
            } else {
                this.zzA = ((zzyz) zzziVar.zzc()).zza;
            }
            boolean z = this.zzB;
            zzv zzvVar2 = this.zzA;
            String str = zzvVar2.zzp;
            this.zzB = z & (zzas.zzf(str) == 1 && zzas.zzd(str, zzvVar2.zzk));
            this.zzC = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized long zzE(long j, boolean z, boolean z2) throws Throwable {
        Throwable th;
        zzzb zzzbVar;
        zzzb zzzbVar2;
        try {
            try {
                int i = this.zzp;
                if (i != 0) {
                    long[] jArr = this.zzn;
                    int i2 = this.zzr;
                    if (j < jArr[i2]) {
                        zzzbVar2 = this;
                    } else {
                        if (z2) {
                            try {
                                int i3 = this.zzs;
                                if (i3 != i) {
                                    i = i3 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                zzzbVar = this;
                                throw th;
                            }
                        }
                        zzzbVar2 = this;
                        int iZzL = zzzbVar2.zzL(i2, i, j, false);
                        if (iZzL != -1) {
                            long jZzM = zzzbVar2.zzM(iZzL);
                            return jZzM;
                        }
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                zzzbVar = this;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final synchronized long zzF() {
        int i = this.zzp;
        if (i == 0) {
            return -1L;
        }
        return zzM(i);
    }

    private final void zzG() {
        if (this.zzh != null) {
            this.zzh = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzH(long j, int i, long j2, int i2, zzahj zzahjVar) {
        try {
            int i3 = this.zzp;
            if (i3 > 0) {
                int iZzN = zzN(i3 - 1);
                zzgtj.zza(this.zzk[iZzN] + ((long) this.zzl[iZzN]) <= j2);
            }
            this.zzx = (536870912 & i) != 0;
            this.zzv = Math.max(this.zzv, j);
            int iZzN2 = zzN(this.zzp);
            this.zzn[iZzN2] = j;
            this.zzk[iZzN2] = j2;
            this.zzl[iZzN2] = i2;
            this.zzm[iZzN2] = i;
            this.zzo[iZzN2] = zzahjVar;
            this.zzj[iZzN2] = 0;
            zzzi zzziVar = this.zzc;
            if (zzziVar.zzf() || !((zzyz) zzziVar.zzc()).zza.equals(this.zzA)) {
                zzv zzvVar = this.zzA;
                if (zzvVar == null) {
                    throw null;
                }
                zzziVar.zzb(this.zzq + this.zzp, new zzyz(zzvVar, zzum.zzb, null));
            }
            int i4 = this.zzp + 1;
            this.zzp = i4;
            int i5 = this.zzi;
            if (i4 == i5) {
                int i6 = i5 + 1000;
                long[] jArr = new long[i6];
                long[] jArr2 = new long[i6];
                long[] jArr3 = new long[i6];
                int[] iArr = new int[i6];
                int[] iArr2 = new int[i6];
                zzahj[] zzahjVarArr = new zzahj[i6];
                int i7 = this.zzr;
                int i8 = i5 - i7;
                System.arraycopy(this.zzk, i7, jArr2, 0, i8);
                System.arraycopy(this.zzn, this.zzr, jArr3, 0, i8);
                System.arraycopy(this.zzm, this.zzr, iArr, 0, i8);
                System.arraycopy(this.zzl, this.zzr, iArr2, 0, i8);
                System.arraycopy(this.zzo, this.zzr, zzahjVarArr, 0, i8);
                System.arraycopy(this.zzj, this.zzr, jArr, 0, i8);
                int i9 = this.zzr;
                System.arraycopy(this.zzk, 0, jArr2, i8, i9);
                System.arraycopy(this.zzn, 0, jArr3, i8, i9);
                System.arraycopy(this.zzm, 0, iArr, i8, i9);
                System.arraycopy(this.zzl, 0, iArr2, i8, i9);
                System.arraycopy(this.zzo, 0, zzahjVarArr, i8, i9);
                System.arraycopy(this.zzj, 0, jArr, i8, i9);
                this.zzk = jArr2;
                this.zzn = jArr3;
                this.zzm = iArr;
                this.zzl = iArr2;
                this.zzo = zzahjVarArr;
                this.zzj = jArr;
                this.zzr = 0;
                this.zzi = i6;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean zzI() {
        return this.zzs != this.zzp;
    }

    private final void zzJ(zzv zzvVar, zzlw zzlwVar) {
        zzv zzvVar2 = this.zzg;
        zzq zzqVar = zzvVar2 == null ? null : zzvVar2.zzt;
        this.zzg = zzvVar;
        zzq zzqVar2 = zzvVar.zzt;
        zzun zzunVar = this.zzd;
        zzlwVar.zzb = zzvVar.zzb(zzunVar.zzb(zzvVar));
        zzlwVar.zza = this.zzh;
        if (zzvVar2 == null || !Objects.equals(zzqVar, zzqVar2)) {
            zzug zzugVarZza = zzunVar.zza(this.zze, zzvVar);
            this.zzh = zzugVarZza;
            zzlwVar.zza = zzugVarZza;
        }
    }

    private final boolean zzK(int i) {
        if (this.zzh == null) {
            return true;
        }
        int i2 = this.zzm[i];
        return false;
    }

    private final int zzL(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzn[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzm[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.zzi) {
                i = 0;
            }
        }
        return i3;
    }

    private final long zzM(int i) {
        long j = this.zzu;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int iZzN = zzN(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                jMax = Math.max(jMax, this.zzn[iZzN]);
                if ((this.zzm[iZzN] & 1) != 0) {
                    break;
                }
                iZzN--;
                if (iZzN == -1) {
                    iZzN = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j, jMax);
        this.zzp -= i;
        int i3 = this.zzq + i;
        this.zzq = i3;
        int i4 = this.zzr + i;
        this.zzr = i4;
        int i5 = this.zzi;
        if (i4 >= i5) {
            this.zzr = i4 - i5;
        }
        int i6 = this.zzs - i;
        this.zzs = i6;
        if (i6 < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(i3);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i7 = this.zzr;
        if (i7 == 0) {
            i7 = this.zzi;
        }
        int i8 = i7 - 1;
        return this.zzk[i8] + ((long) this.zzl[i8]);
    }

    private final int zzN(int i) {
        int i2 = this.zzr + i;
        int i3 = this.zzi;
        return i2 < i3 ? i2 : i2 - i3;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzA(zzv zzvVar) {
        boolean zZzD = zzD(zzvVar);
        zzza zzzaVar = this.zzf;
        if (zzzaVar == null || !zZzD) {
            return;
        }
        zzzaVar.zzy(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i, boolean z, int i2) {
        return this.zza.zzg(zzjVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i, int i2) {
        this.zza.zzh(zzetVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(long j, int i, int i2, int i3, zzahj zzahjVar) {
        if (this.zzy) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzy = false;
            }
        }
        if (this.zzB) {
            if (j < this.zzt) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzC) {
                    zzeg.zzc("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzA)));
                    this.zzC = true;
                }
                i |= 1;
            }
        }
        int i4 = i;
        zzH(j, i4, (this.zza.zzf() - ((long) i2)) - ((long) i3), i2, zzahjVar);
    }

    public final void zzf() {
        zzg(true);
        zzG();
    }

    public final void zzg(boolean z) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzw = -1;
        this.zzy = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzx = false;
        this.zzc.zze();
        if (z) {
            this.zzA = null;
            this.zzz = true;
            this.zzB = true;
        }
    }

    public final void zzh(long j) {
        this.zzt = j;
    }

    public final synchronized void zzi(long j) {
    }

    public final int zzj() {
        return this.zzq + this.zzp;
    }

    public final void zzk() {
        zzy();
        zzG();
    }

    public final void zzl() {
        zzug zzugVar = this.zzh;
        if (zzugVar != null) {
            throw zzugVar.zza();
        }
    }

    public final int zzm() {
        return this.zzq;
    }

    public final int zzn() {
        return this.zzq + this.zzs;
    }

    public final synchronized zzv zzo() {
        if (this.zzz) {
            return null;
        }
        return this.zzA;
    }

    public final synchronized long zzp() {
        return this.zzv;
    }

    public final synchronized boolean zzq() {
        return this.zzx;
    }

    public final synchronized boolean zzr(boolean z) {
        int i = this.zzq + this.zzs;
        boolean z2 = true;
        if (this.zzw != -1 && i >= 0) {
            return true;
        }
        if (zzI()) {
            if (((zzyz) this.zzc.zza(i)).zza != this.zzg) {
                return true;
            }
            return zzK(zzN(this.zzs));
        }
        if (!z && !this.zzx) {
            zzv zzvVar = this.zzA;
            if (zzvVar == null) {
                z2 = false;
            } else if (zzvVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    public final int zzs(zzlw zzlwVar, zziv zzivVar, int i, boolean z) {
        boolean z2 = (i & 2) != 0;
        zzyx zzyxVar = this.zzb;
        int iZzC = zzC(zzlwVar, zzivVar, z2, z, zzyxVar);
        if (iZzC != -4) {
            return iZzC;
        }
        if (!zzivVar.zzb()) {
            int i2 = i & 1;
            if ((i & 4) == 0) {
                zzyw zzywVar = this.zza;
                if (i2 != 0) {
                    zzywVar.zzd(zzivVar, zzyxVar);
                    return -4;
                }
                zzywVar.zzc(zzivVar, zzyxVar);
            } else if (i2 != 0) {
                return -4;
            }
            this.zzs++;
        }
        return -4;
    }

    public final synchronized boolean zzt(int i) {
        zzB();
        int i2 = this.zzq;
        if (i >= i2 && i <= this.zzp + i2 && (this.zzw == -1 || i < 0)) {
            this.zzt = Long.MIN_VALUE;
            this.zzs = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean zzu(long j, boolean z) throws Throwable {
        zzzb zzzbVar;
        Throwable th;
        zzzb zzzbVar2;
        long j2;
        int iZzL;
        try {
            try {
                zzB();
                int i = this.zzs;
                int iZzN = zzN(i);
                long j3 = this.zzv;
                if (!zzI() || j < this.zzn[iZzN]) {
                    zzzbVar2 = this;
                } else {
                    if (j > j3) {
                        if (z) {
                            z = true;
                        }
                        zzzbVar2 = this;
                    }
                    boolean z2 = this.zzB;
                    int i2 = this.zzp;
                    if (z2) {
                        iZzL = i2 - i;
                        int i3 = 0;
                        while (true) {
                            if (i3 < iZzL) {
                                try {
                                    if (this.zzn[iZzN] >= j) {
                                        zzzbVar2 = this;
                                        j2 = j;
                                        iZzL = i3;
                                        break;
                                    }
                                    iZzN++;
                                    if (iZzN == this.zzi) {
                                        iZzN = 0;
                                    }
                                    i3++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    zzzbVar = this;
                                    throw th;
                                }
                            } else {
                                zzzbVar2 = this;
                                j2 = j;
                                if (!z) {
                                    iZzL = -1;
                                }
                            }
                        }
                    } else {
                        zzzbVar2 = this;
                        j2 = j;
                        iZzL = zzzbVar2.zzL(iZzN, i2 - i, j2, true);
                    }
                    if (iZzL != -1) {
                        zzzbVar2.zzt = j2;
                        zzzbVar2.zzs += iZzL;
                        return true;
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zzzbVar = this;
            th = th;
            throw th;
        }
    }

    public final synchronized int zzv(long j, boolean z) {
        zzzb zzzbVar;
        Throwable th;
        try {
            try {
                int i = this.zzs;
                int iZzN = zzN(i);
                if (!zzI() || j < this.zzn[iZzN]) {
                    return 0;
                }
                if (j <= this.zzv || !z) {
                    int iZzL = zzL(iZzN, this.zzp - i, j, true);
                    if (iZzL == -1) {
                        return 0;
                    }
                    return iZzL;
                }
                try {
                    return this.zzp - i;
                } catch (Throwable th2) {
                    th = th2;
                    zzzbVar = this;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            zzzbVar = this;
        }
        th = th;
        throw th;
    }

    public final synchronized void zzw(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzs + i <= this.zzp) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzgtj.zza(z);
        this.zzs += i;
    }

    public final void zzx(long j, boolean z, boolean z2) {
        this.zza.zze(zzE(j, false, z2));
    }

    public final void zzy() {
        this.zza.zze(zzF());
    }

    public final void zzz(zzza zzzaVar) {
        this.zzf = zzzaVar;
    }
}
