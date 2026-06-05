package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class zzxf extends zzzp {
    private final boolean zzb;
    private final zzbe zzc;
    private final zzbd zzd;
    private zzxd zze;
    private zzxc zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzxf(zzxm zzxmVar, boolean z) {
        boolean z2;
        super(zzxmVar);
        if (z) {
            zzxmVar.zzI();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        zzxmVar.zzH();
        this.zze = zzxd.zzp(zzxmVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzs() == null || !obj.equals(zzxd.zzc)) ? obj : this.zze.zzs();
    }

    private final boolean zzL(long j) {
        zzxc zzxcVar = this.zzf;
        int iZze = this.zze.zze(zzxcVar.zza.zza);
        if (iZze == -1) {
            return false;
        }
        zzxd zzxdVar = this.zze;
        zzbd zzbdVar = this.zzd;
        zzxdVar.zzd(iZze, zzbdVar, false);
        long j2 = zzbdVar.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzxcVar.zzo(j);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzA(zzak zzakVar) {
        if (this.zzi) {
            zzxd zzxdVar = this.zze;
            this.zze = zzxdVar.zzr(zzzl.zzp(zzxdVar.zzb, zzakVar));
        } else {
            this.zze = zzxd.zzp(zzakVar);
        }
        ((zzzp) this).zza.zzA(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void zzB() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzv(null, ((zzzp) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final zzxc zzG(zzxk zzxkVar, zzabl zzablVar, long j) {
        zzxc zzxcVar = new zzxc(zzxkVar, zzablVar, j);
        zzxcVar.zzr(((zzzp) this).zza);
        if (this.zzh) {
            zzxcVar.zzt(zzxkVar.zza(zzK(zzxkVar.zza)));
            return zzxcVar;
        }
        this.zzf = zzxcVar;
        if (!this.zzg) {
            this.zzg = true;
            zzv(null, ((zzzp) this).zza);
        }
        return zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzD(zzxi zzxiVar) {
        ((zzxc) zzxiVar).zzu();
        if (zzxiVar == this.zzf) {
            this.zzf = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzzp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzE(zzbf zzbfVar) {
        zzxk zzxkVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzr(zzbfVar);
            zzxc zzxcVar = this.zzf;
            if (zzxcVar != null) {
                zzL(zzxcVar.zzq());
            }
        } else if (zzbfVar.zzg()) {
            this.zze = this.zzi ? this.zze.zzr(zzbfVar) : zzxd.zzq(zzbfVar, zzbe.zza, zzxd.zzc);
        } else {
            zzbe zzbeVar = this.zzc;
            zzbfVar.zzb(0, zzbeVar, 0L);
            Object obj = zzbeVar.zzb;
            zzxc zzxcVar2 = this.zzf;
            if (zzxcVar2 != null) {
                long jZza = zzxcVar2.zza();
                this.zze.zzo(zzxcVar2.zza.zza, this.zzd);
                this.zze.zzb(0, zzbeVar, 0L);
                if (jZza == 0) {
                    jZza = 0;
                }
                Pair pairZzm = zzbfVar.zzm(zzbeVar, this.zzd, 0, jZza);
                Object obj2 = pairZzm.first;
                long jLongValue = ((Long) pairZzm.second).longValue();
                this.zze = this.zzi ? this.zze.zzr(zzbfVar) : zzxd.zzq(zzbfVar, obj, obj2);
                zzxc zzxcVar3 = this.zzf;
                if (zzxcVar3 != null && zzL(jLongValue)) {
                    zzxk zzxkVar = zzxcVar3.zza;
                    zzxkVarZza = zzxkVar.zza(zzK(zzxkVar.zza));
                }
            }
        }
        this.zzi = true;
        this.zzh = true;
        zze(this.zze);
        if (zzxkVarZza != null) {
            zzxc zzxcVar4 = this.zzf;
            zzxcVar4.getClass();
            zzxcVar4.zzt(zzxkVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final zzxk zzF(zzxk zzxkVar) {
        Object objZzs = this.zze.zzs();
        Object obj = zzxkVar.zza;
        if (objZzs != null && this.zze.zzs().equals(obj)) {
            obj = zzxd.zzc;
        }
        return zzxkVar.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzwj
    public final void zzd() {
        this.zzh = false;
        this.zzg = false;
        super.zzd();
    }

    public final zzbf zzz() {
        return this.zze;
    }
}
