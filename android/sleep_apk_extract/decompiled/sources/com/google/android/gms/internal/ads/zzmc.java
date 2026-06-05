package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzmc {
    public final zzxi zza;
    public final Object zzb;
    public final zzzc[] zzc;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzmd zzg;
    public boolean zzh;
    private final boolean[] zzi;
    private final zznc[] zzj;
    private final zzabh zzk;
    private final zzmr zzl;
    private zzmc zzm;
    private zzzn zzn;
    private zzabi zzo;
    private long zzp;

    public zzmc(zznc[] zzncVarArr, long j, zzabh zzabhVar, zzabl zzablVar, zzmr zzmrVar, zzmd zzmdVar, zzabi zzabiVar, long j2) {
        this.zzj = zzncVarArr;
        this.zzp = j;
        this.zzk = zzabhVar;
        this.zzl = zzmrVar;
        zzxk zzxkVar = zzmdVar.zza;
        this.zzb = zzxkVar.zza;
        this.zzg = zzmdVar;
        this.zzn = zzzn.zza;
        this.zzo = zzabiVar;
        this.zzc = new zzzc[2];
        this.zzi = new boolean[2];
        long j3 = zzmdVar.zzb;
        long j4 = zzmdVar.zze;
        zzxi zzxiVarZze = zzmrVar.zze(zzxkVar, zzablVar, j3);
        this.zza = j4 != -9223372036854775807L ? new zzwo(zzxiVarZze, true, 0L, j4) : zzxiVarZze;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzabi zzabiVar = this.zzo;
            if (i >= zzabiVar.zza) {
                return;
            }
            zzabiVar.zza(i);
            zzaba zzabaVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzabi zzabiVar = this.zzo;
            if (i >= zzabiVar.zza) {
                return;
            }
            zzabiVar.zza(i);
            zzaba zzabaVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza() {
        return this.zzp;
    }

    public final void zzb(long j) {
        this.zzp = j;
    }

    public final long zzc() {
        return this.zzg.zzb + this.zzp;
    }

    public final boolean zzd() {
        if (this.zze) {
            return !this.zzf || this.zza.zzi() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zze() {
        if (this.zze) {
            return zzd() || zzf() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }

    public final long zzf() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzi = this.zzf ? this.zza.zzi() : Long.MIN_VALUE;
        return jZzi == Long.MIN_VALUE ? this.zzg.zzf : jZzi;
    }

    public final long zzg() {
        if (this.zze) {
            return this.zza.zzl();
        }
        return 0L;
    }

    public final void zzh(float f, zzbf zzbfVar, boolean z) {
        this.zze = true;
        this.zzn = this.zza.zzd();
        zzabi zzabiVarZzk = zzk(f, zzbfVar, z);
        zzmd zzmdVar = this.zzg;
        long jMax = zzmdVar.zzb;
        long j = zzmdVar.zzf;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZzl = zzl(zzabiVarZzk, jMax, false);
        long j2 = this.zzp;
        zzmd zzmdVar2 = this.zzg;
        this.zzp = (zzmdVar2.zzb - jZzl) + j2;
        this.zzg = zzmdVar2.zza(jZzl, zzmdVar2.zzc);
    }

    public final void zzi(long j) {
        zzgtj.zzi(zzw());
        if (this.zze) {
            this.zza.zzg(j - this.zzp);
        }
    }

    public final void zzj(zzma zzmaVar) {
        zzgtj.zzi(zzw());
        this.zza.zzm(zzmaVar);
    }

    public final zzabi zzk(float f, zzbf zzbfVar, boolean z) {
        zzzn zzznVar = this.zzn;
        zzxk zzxkVar = this.zzg.zza;
        zzabh zzabhVar = this.zzk;
        zznc[] zzncVarArr = this.zzj;
        zzabi zzabiVarZzr = zzabhVar.zzr(zzncVarArr, zzznVar, zzxkVar, zzbfVar);
        for (int i = 0; i < zzabiVarZzr.zza; i++) {
            boolean zZza = zzabiVarZzr.zza(i);
            zzaba[] zzabaVarArr = zzabiVarZzr.zzc;
            if (zZza) {
                if (zzabaVarArr[i] == null) {
                    zzncVarArr[i].zza();
                    z = false;
                }
                zzgtj.zzi(z);
            } else {
                zzgtj.zzi(zzabaVarArr[i] == null);
            }
        }
        for (zzaba zzabaVar : zzabiVarZzr.zzc) {
        }
        return zzabiVarZzr;
    }

    public final long zzl(zzabi zzabiVar, long j, boolean z) {
        return zzm(zzabiVar, j, false, new boolean[2]);
    }

    public final long zzm(zzabi zzabiVar, long j, boolean z, boolean[] zArr) {
        zznc[] zzncVarArr;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzabiVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z || !zzabiVar.zzb(this.zzo, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzncVarArr = this.zzj;
            if (i2 >= 2) {
                break;
            }
            zzncVarArr[i2].zza();
            i2++;
        }
        zzv();
        this.zzo = zzabiVar;
        zzu();
        zzxi zzxiVar = this.zza;
        zzaba[] zzabaVarArr = zzabiVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzzc[] zzzcVarArr = this.zzc;
        long jZze = zzxiVar.zze(zzabaVarArr, zArr3, zzzcVarArr, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            zzncVarArr[i3].zza();
        }
        this.zzf = false;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzzcVarArr[i4] != null) {
                zzgtj.zzi(zzabiVar.zza(i4));
                zzncVarArr[i4].zza();
                this.zzf = true;
            } else {
                zzgtj.zzi(zzabaVarArr[i4] == null);
            }
        }
        return jZze;
    }

    public final void zzn() {
        zzv();
        zzxi zzxiVar = this.zza;
        try {
            boolean z = zzxiVar instanceof zzwo;
            zzmr zzmrVar = this.zzl;
            if (z) {
                zzmrVar.zzf(((zzwo) zzxiVar).zza);
            } else {
                zzmrVar.zzf(zzxiVar);
            }
        } catch (RuntimeException e) {
            zzeg.zzf("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzmc zzmcVar) {
        if (zzmcVar == this.zzm) {
            return;
        }
        zzv();
        this.zzm = zzmcVar;
        zzu();
    }

    public final zzmc zzp() {
        return this.zzm;
    }

    public final zzzn zzq() {
        return this.zzn;
    }

    public final zzabi zzr() {
        return this.zzo;
    }

    public final void zzs() {
        zzxi zzxiVar = this.zza;
        if (zzxiVar instanceof zzwo) {
            long j = this.zzg.zze;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzwo) zzxiVar).zza(0L, j);
        }
    }

    public final void zzt(zzxh zzxhVar, long j) {
        this.zzd = true;
        this.zza.zzb(zzxhVar, j);
    }
}
