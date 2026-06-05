package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzji implements zzmb {
    private final zznl zza;
    private final zzjh zzb;
    private zzna zzc;
    private zzmb zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzji(zzjh zzjhVar, zzdo zzdoVar) {
        this.zzb = zzjhVar;
        this.zza = new zznl(zzdoVar);
    }

    public final void zza() {
        this.zzf = true;
        this.zza.zza();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zzb();
    }

    public final void zzc(long j) {
        this.zza.zzc(j);
    }

    public final void zzd(zzna zznaVar) throws zzjk {
        zzmb zzmbVar;
        zzmb zzmbVarZzd = zznaVar.zzd();
        if (zzmbVarZzd == null || zzmbVarZzd == (zzmbVar = this.zzd)) {
            return;
        }
        if (zzmbVar != null) {
            throw zzjk.zzc(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.zzd = zzmbVarZzd;
        this.zzc = zznaVar;
        zzmbVarZzd.zzi(this.zza.zzj());
    }

    public final void zze(zzna zznaVar) {
        if (zznaVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzf(boolean z) {
        zznl zznlVar;
        zzav zzavVarZzj;
        zzna zznaVar = this.zzc;
        if (zznaVar == null || zznaVar.zzab() || ((z && this.zzc.zze() != 2) || (!this.zzc.zzaa() && (z || this.zzc.zzcW())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zza();
            }
        } else {
            zzmb zzmbVar = this.zzd;
            zzmbVar.getClass();
            long jZzg = zzmbVar.zzg();
            if (this.zze) {
                zznl zznlVar2 = this.zza;
                if (jZzg < zznlVar2.zzg()) {
                    zznlVar2.zzb();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        zznlVar2.zza();
                    }
                    zznlVar = this.zza;
                    zznlVar.zzc(jZzg);
                    zzavVarZzj = zzmbVar.zzj();
                    if (!zzavVarZzj.equals(zznlVar.zzj())) {
                        zznlVar.zzi(zzavVarZzj);
                        this.zzb.zzc(zzavVarZzj);
                    }
                }
            } else {
                zznlVar = this.zza;
                zznlVar.zzc(jZzg);
                zzavVarZzj = zzmbVar.zzj();
                if (!zzavVarZzj.equals(zznlVar.zzj())) {
                }
            }
        }
        return zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final long zzg() {
        if (this.zze) {
            return this.zza.zzg();
        }
        zzmb zzmbVar = this.zzd;
        zzmbVar.getClass();
        return zzmbVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zzh() {
        if (this.zze) {
            return false;
        }
        zzmb zzmbVar = this.zzd;
        zzmbVar.getClass();
        return zzmbVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzi(zzav zzavVar) {
        zzmb zzmbVar = this.zzd;
        if (zzmbVar != null) {
            zzmbVar.zzi(zzavVar);
            zzavVar = this.zzd.zzj();
        }
        this.zza.zzi(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzav zzj() {
        zzmb zzmbVar = this.zzd;
        return zzmbVar != null ? zzmbVar.zzj() : this.zza.zzj();
    }
}
