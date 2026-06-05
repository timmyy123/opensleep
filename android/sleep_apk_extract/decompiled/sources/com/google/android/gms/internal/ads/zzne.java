package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzne {
    private final zzna zza;
    private final int zzb;
    private final zzna zzc;
    private int zzd = 0;
    private boolean zze = false;
    private boolean zzf = false;

    public zzne(zzna zznaVar, zzna zznaVar2, int i) {
        this.zza = zznaVar;
        this.zzb = i;
        this.zzc = zznaVar2;
    }

    private final boolean zzN() {
        int i = this.zzd;
        return i == 2 || i == 4;
    }

    private final boolean zzO() {
        return this.zzd == 3;
    }

    private final boolean zzP(zzmc zzmcVar, zzna zznaVar) {
        if (zznaVar == null) {
            return true;
        }
        zzzc[] zzzcVarArr = zzmcVar.zzc;
        int i = this.zzb;
        zzzc zzzcVar = zzzcVarArr[i];
        if (zznaVar.zzcV() != null) {
            if (zznaVar.zzcV() == zzzcVar) {
                if (zzzcVar != null && !zznaVar.zzcW()) {
                    zzmcVar.zzp();
                    boolean z = zzmcVar.zzg.zzh;
                }
            }
            zzmc zzmcVarZzp = zzmcVar.zzp();
            return zzmcVarZzp != null && zzmcVarZzp.zzc[i] == zznaVar.zzcV();
        }
        return true;
    }

    private final void zzQ(boolean z) {
        if (z) {
            zzna zznaVar = this.zzc;
            zznaVar.getClass();
            zznaVar.zzx(17, this.zza);
        } else {
            zzna zznaVar2 = this.zza;
            zzna zznaVar3 = this.zzc;
            zznaVar3.getClass();
            zznaVar2.zzx(17, zznaVar3);
        }
    }

    private final void zzR(zzna zznaVar, zzzc zzzcVar, zzji zzjiVar, long j, boolean z) {
        if (zzW(zznaVar)) {
            if (zzzcVar != zznaVar.zzcV()) {
                zzS(zznaVar, zzjiVar);
            } else if (z) {
                zznaVar.zzp(j, true);
            }
        }
    }

    private final void zzS(zzna zznaVar, zzji zzjiVar) {
        boolean z = true;
        if (this.zza != zznaVar && this.zzc != zznaVar) {
            z = false;
        }
        zzgtj.zzi(z);
        if (zzW(zznaVar)) {
            zzjiVar.zze(zznaVar);
            zzY(zznaVar);
            zznaVar.zzr();
        }
    }

    private final void zzT(boolean z) {
        if (z) {
            if (this.zze) {
                this.zza.zzs();
                this.zze = false;
                return;
            }
            return;
        }
        if (this.zzf) {
            zzna zznaVar = this.zzc;
            zznaVar.getClass();
            zznaVar.zzs();
            this.zzf = false;
        }
    }

    private final int zzU(zzna zznaVar, zzmc zzmcVar, zzabi zzabiVar, zzji zzjiVar) {
        if (zznaVar != null && zzW(zznaVar)) {
            zzna zznaVar2 = this.zza;
            boolean z = zznaVar != zznaVar2;
            if ((zznaVar != zznaVar2 || !zzN()) && (zznaVar != this.zzc || !zzO())) {
                zzzc zzzcVarZzcV = zznaVar.zzcV();
                zzzc[] zzzcVarArr = zzmcVar.zzc;
                int i = this.zzb;
                zzzc zzzcVar = zzzcVarArr[i];
                boolean zZza = zzabiVar.zza(i);
                if (zZza && zzzcVarZzcV == zzzcVar) {
                    return 1;
                }
                if (!zznaVar.zzm()) {
                    zzv[] zzvVarArrZzV = zzV(zzabiVar.zzc[i]);
                    zzzc zzzcVar2 = zzzcVarArr[i];
                    zzzcVar2.getClass();
                    zznaVar.zzcU(zzvVarArrZzV, zzzcVar2, zzmcVar.zzc(), zzmcVar.zza(), zzmcVar.zzg.zza);
                    return 3;
                }
                if (!zznaVar.zzab()) {
                    return 0;
                }
                zzS(zznaVar, zzjiVar);
                if (!zZza || zzc()) {
                    zzT(!z);
                }
                return 1;
            }
        }
        return 1;
    }

    private static zzv[] zzV(zzaba zzabaVar) {
        int iZze = zzabaVar != null ? zzabaVar.zze() : 0;
        zzv[] zzvVarArr = new zzv[iZze];
        for (int i = 0; i < iZze; i++) {
            zzabaVar.getClass();
            zzvVarArr[i] = zzabaVar.zzb(i);
        }
        return zzvVarArr;
    }

    private static boolean zzW(zzna zznaVar) {
        return zznaVar.zze() != 0;
    }

    private final zzna zzX(zzmc zzmcVar) {
        if (zzmcVar != null) {
            int i = this.zzb;
            zzzc[] zzzcVarArr = zzmcVar.zzc;
            if (zzzcVarArr[i] != null) {
                zzna zznaVar = this.zza;
                zzzc zzzcVarZzcV = zznaVar.zzcV();
                zzzc zzzcVar = zzzcVarArr[i];
                if (zzzcVarZzcV == zzzcVar) {
                    return zznaVar;
                }
                zzna zznaVar2 = this.zzc;
                if (zznaVar2 != null && zznaVar2.zzcV() == zzzcVar) {
                    return zznaVar2;
                }
            }
        }
        return null;
    }

    private static final void zzY(zzna zznaVar) {
        if (zznaVar.zze() == 2) {
            zznaVar.zzq();
        }
    }

    private static final void zzZ(zzna zznaVar, long j) {
        zznaVar.zzl();
    }

    public final void zzA(zzji zzjiVar) {
        zzS(this.zza, zzjiVar);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            boolean z = zzW(zznaVar) && this.zzd != 3;
            zzS(zznaVar, zzjiVar);
            zzT(false);
            if (z) {
                zzQ(true);
            }
        }
        this.zzd = 0;
    }

    public final void zzB() {
        int i = this.zzd;
        if (i == 3 || i == 4) {
            zzQ(i == 4);
            this.zzd = this.zzd != 4 ? 1 : 0;
        } else if (i == 2) {
            this.zzd = 0;
        }
    }

    public final void zzC(zzji zzjiVar) {
        boolean z;
        zzna zznaVar;
        if (zzc()) {
            int i = this.zzd;
            if (i == 4) {
                z = true;
            } else if (i == 2) {
                i = 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zznaVar = this.zza;
            } else {
                zznaVar = this.zzc;
                zznaVar.getClass();
            }
            zzS(zznaVar, zzjiVar);
            zzT(z);
            this.zzd = i == 4 ? 1 : 0;
        }
    }

    public final void zzD(zzzc zzzcVar, zzji zzjiVar, long j, boolean z) {
        zzR(this.zza, zzzcVar, zzjiVar, j, z);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zzR(zznaVar, zzzcVar, zzjiVar, j, z);
        }
    }

    public final void zzE(zzmc zzmcVar, long j, boolean z) {
        zzna zznaVarZzX = zzX(zzmcVar);
        if (zznaVarZzX != null) {
            zznaVarZzX.zzp(j, z);
        }
    }

    public final boolean zzF(zzmc zzmcVar, long j) {
        zzna zznaVarZzX = zzX(zzmcVar);
        return zznaVarZzX != null && zznaVarZzX.zzW(j);
    }

    public final void zzG() {
        if (!zzW(this.zza)) {
            zzT(true);
        }
        zzna zznaVar = this.zzc;
        if (zznaVar == null || zzW(zznaVar)) {
            return;
        }
        zzT(false);
    }

    public final int zzH(zzmc zzmcVar, zzabi zzabiVar, zzji zzjiVar) {
        int iZzU = zzU(this.zza, zzmcVar, zzabiVar, zzjiVar);
        return iZzU == 1 ? zzU(this.zzc, zzmcVar, zzabiVar, zzjiVar) : iZzU;
    }

    public final void zzI() {
        this.zza.zzt();
        this.zze = false;
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zznaVar.zzt();
            this.zzf = false;
        }
    }

    public final void zzJ(Object obj) {
        if (zze() != 2) {
            return;
        }
        int i = this.zzd;
        if (i != 4 && i != 1) {
            this.zza.zzx(1, obj);
            return;
        }
        zzna zznaVar = this.zzc;
        zznaVar.getClass();
        zznaVar.zzx(1, obj);
    }

    public final void zzK(zzadr zzadrVar) {
        if (zze() != 2) {
            zze();
            return;
        }
        this.zza.zzx(7, zzadrVar);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zznaVar.zzx(7, zzadrVar);
        }
    }

    public final void zzL(float f) {
        if (zze() != 1) {
            return;
        }
        zzna zznaVar = this.zza;
        Float fValueOf = Float.valueOf(f);
        zznaVar.zzx(2, fValueOf);
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 != null) {
            zznaVar2.zzx(2, fValueOf);
        }
    }

    public final boolean zzM() {
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            return zzW(this.zza);
        }
        zzna zznaVar = this.zzc;
        zznaVar.getClass();
        return zzW(zznaVar);
    }

    public final boolean zza() {
        return this.zzc != null;
    }

    public final void zzb() {
        int i;
        zzgtj.zzi(!zzc());
        if (zzW(this.zza)) {
            i = 3;
        } else {
            zzna zznaVar = this.zzc;
            i = (zznaVar == null || !zzW(zznaVar)) ? 2 : 4;
        }
        this.zzd = i;
    }

    public final boolean zzc() {
        return zzN() || zzO();
    }

    public final int zzd() {
        zzna zznaVar = this.zzc;
        boolean zZzW = zzW(this.zza);
        int i = 0;
        if (zznaVar != null && zzW(zznaVar)) {
            i = 1;
        }
        return (zZzW ? 1 : 0) + i;
    }

    public final int zze() {
        return this.zza.zza();
    }

    public final long zzf(zzmc zzmcVar) {
        zzna zznaVarZzX = zzX(zzmcVar);
        Objects.requireNonNull(zznaVarZzX);
        return zznaVarZzX.zzk();
    }

    public final boolean zzg(zzmc zzmcVar) {
        zzna zznaVarZzX = zzX(zzmcVar);
        zznaVarZzX.getClass();
        return zznaVarZzX.zzcW();
    }

    public final void zzh(zzmc zzmcVar, long j) {
        zzna zznaVarZzX = zzX(zzmcVar);
        zznaVarZzX.getClass();
        zzZ(zznaVarZzX, j);
    }

    public final void zzi(zzabi zzabiVar, zzabi zzabiVar2, long j) {
        int i;
        int i2 = this.zzb;
        boolean zZza = zzabiVar.zza(i2);
        boolean zZza2 = zzabiVar2.zza(i2);
        zzna zznaVar = this.zzc;
        if (zznaVar == null || (i = this.zzd) == 3 || (i == 0 && zzW(this.zza))) {
            zznaVar = this.zza;
        }
        if (!zZza || zznaVar.zzm()) {
            return;
        }
        zze();
        zznd zzndVar = zzabiVar.zzb[i2];
        zznd zzndVar2 = zzabiVar2.zzb[i2];
        if (zZza2 && Objects.equals(zzndVar2, zzndVar) && !zzc()) {
            return;
        }
        zzZ(zznaVar, j);
    }

    public final void zzj(long j) {
        int i;
        zzna zznaVar = this.zza;
        if (zzW(zznaVar) && (i = this.zzd) != 4 && i != 2) {
            zzZ(zznaVar, j);
        }
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 == null || !zzW(zznaVar2) || this.zzd == 3) {
            return;
        }
        zzZ(zznaVar2, j);
    }

    public final long zzk(long j, long j2) {
        zzna zznaVar = this.zza;
        long jZzV = zzW(zznaVar) ? zznaVar.zzV(j, j2) : Long.MAX_VALUE;
        zzna zznaVar2 = this.zzc;
        return (zznaVar2 == null || !zzW(zznaVar2)) ? jZzV : Math.min(jZzV, zznaVar2.zzV(j, j2));
    }

    public final void zzl() {
        zzna zznaVar = this.zza;
        if (zzW(zznaVar)) {
            zznaVar.zzY();
            return;
        }
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 == null || !zzW(zznaVar2)) {
            return;
        }
        zznaVar2.zzY();
    }

    public final void zzm(float f, float f2) {
        this.zza.zzX(f, f2);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zznaVar.zzX(f, f2);
        }
    }

    public final void zzn(zzbf zzbfVar) {
        this.zza.zzo(zzbfVar);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zznaVar.zzo(zzbfVar);
        }
    }

    public final boolean zzo() {
        zzna zznaVar = this.zza;
        boolean zZzab = zzW(zznaVar) ? zznaVar.zzab() : true;
        zzna zznaVar2 = this.zzc;
        return (zznaVar2 == null || !zzW(zznaVar2)) ? zZzab : zznaVar2.zzab() & zZzab;
    }

    public final boolean zzp(zzmc zzmcVar) {
        return zzX(zzmcVar) != null;
    }

    public final boolean zzq(zzmc zzmcVar) {
        return (zzN() && zzX(zzmcVar) == this.zza) || (zzO() && zzX(zzmcVar) == this.zzc);
    }

    public final boolean zzr(zzmc zzmcVar) {
        return zzP(zzmcVar, this.zza) && zzP(zzmcVar, this.zzc);
    }

    public final void zzs(long j, long j2) {
        zzna zznaVar = this.zza;
        if (zzW(zznaVar)) {
            zznaVar.zzZ(j, j2);
        }
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 == null || !zzW(zznaVar2)) {
            return;
        }
        zznaVar2.zzZ(j, j2);
    }

    public final boolean zzt(zzmc zzmcVar) {
        zzna zznaVarZzX = zzX(zzmcVar);
        return zznaVarZzX == null || zznaVarZzX.zzcW() || zznaVarZzX.zzaa() || zznaVarZzX.zzab();
    }

    public final void zzu(zzmc zzmcVar) {
        zzna zznaVarZzX = zzX(zzmcVar);
        zznaVarZzX.getClass();
        zznaVarZzX.zzn();
    }

    public final void zzv() {
        zzna zznaVar = this.zza;
        if (zznaVar.zze() == 1 && this.zzd != 4) {
            zznaVar.zzcT();
            return;
        }
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 == null || zznaVar2.zze() != 1 || this.zzd == 3) {
            return;
        }
        zznaVar2.zzcT();
    }

    public final void zzw() {
        zzna zznaVar = this.zza;
        if (zzW(zznaVar)) {
            zzY(zznaVar);
        }
        zzna zznaVar2 = this.zzc;
        if (zznaVar2 == null || !zzW(zznaVar2)) {
            return;
        }
        zzY(zznaVar2);
    }

    public final void zzx(zznd zzndVar, zzaba zzabaVar, zzzc zzzcVar, long j, boolean z, boolean z2, long j2, long j3, zzxk zzxkVar, zzji zzjiVar) throws zzjk {
        zzv[] zzvVarArrZzV = zzV(zzabaVar);
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            this.zze = true;
            zzna zznaVar = this.zza;
            zznaVar.zzf(zzndVar, zzvVarArrZzV, zzzcVar, j, z, z2, j2, j3, zzxkVar);
            zzjiVar.zzd(zznaVar);
            return;
        }
        this.zzf = true;
        zzna zznaVar2 = this.zzc;
        zznaVar2.getClass();
        zznaVar2.zzf(zzndVar, zzvVarArrZzV, zzzcVar, j, z, z2, j2, j3, zzxkVar);
        zzjiVar.zzd(zznaVar2);
    }

    public final void zzy(int i, Object obj, zzmc zzmcVar) {
        zzna zznaVarZzX = zzX(zzmcVar);
        zznaVarZzX.getClass();
        zznaVarZzX.zzx(11, obj);
    }

    public final void zzz(zznh zznhVar) {
        this.zza.zzx(18, zznhVar);
        zzna zznaVar = this.zzc;
        if (zznaVar != null) {
            zznaVar.zzx(18, zznhVar);
        }
    }
}
