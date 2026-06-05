package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxi implements zzdef, zzbeq, zzdht {
    private final zzfkf zza;
    private final zzddj zzb;
    private final zzdeo zzc;
    private final zzdfk zzf;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();
    private final AtomicBoolean zzg = new AtomicBoolean();

    public zzcxi(zzfkf zzfkfVar, zzddj zzddjVar, zzdeo zzdeoVar, zzdfk zzdfkVar) {
        this.zza = zzfkfVar;
        this.zzb = zzddjVar;
        this.zzc = zzdeoVar;
        this.zzf = zzdfkVar;
    }

    private final void zzd() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdH() {
        if (this.zza.zze == 4) {
            zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdI() {
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        int i = this.zza.zze;
        if (i == 1) {
            if (zzbepVar.zzj) {
                zzd();
            }
        } else if (i == 4 && zzbepVar.zzj && this.zzg.compareAndSet(false, true)) {
            this.zzf.zza();
        }
        if (zzbepVar.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final synchronized void zzg() {
        int i = this.zza.zze;
        if (i == 1 || i == 4) {
            return;
        }
        zzd();
    }
}
