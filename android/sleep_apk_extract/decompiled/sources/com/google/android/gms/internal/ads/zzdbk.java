package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbk implements zzdcr, zzdkd, zzdht, zzddh, zzbeq {
    private final zzddj zza;
    private final zzdfk zzb;
    private final zzfkf zzc;
    private final ScheduledExecutorService zzd;
    private final Executor zze;
    private ScheduledFuture zzg;
    private final String zzi;
    private final zzhcp zzf = zzhcp.zze();
    private final AtomicBoolean zzh = new AtomicBoolean();

    public zzdbk(zzddj zzddjVar, zzfkf zzfkfVar, ScheduledExecutorService scheduledExecutorService, Executor executor, String str, zzdfk zzdfkVar) {
        this.zza = zzddjVar;
        this.zzc = zzfkfVar;
        this.zzd = scheduledExecutorService;
        this.zze = executor;
        this.zzi = str;
        this.zzb = zzdfkVar;
    }

    private final boolean zzl() {
        return this.zzi.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final synchronized void zzdH() {
        if (this.zzc.zze == 4) {
            this.zza.zza();
            return;
        }
        zzhcp zzhcpVar = this.zzf;
        if (zzhcpVar.isDone()) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzg;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzhcpVar.zza(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdI() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmV)).booleanValue() && zzl() && zzbepVar.zzj && this.zzh.compareAndSet(false, true) && this.zzc.zze != 3) {
            com.google.android.gms.ads.internal.util.zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        zzfkf zzfkfVar = this.zzc;
        if (zzfkfVar.zze == 3) {
            return;
        }
        int i = zzfkfVar.zzY;
        if (i == 0 || i == 1) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmV)).booleanValue() && zzl()) {
                return;
            }
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzg() {
        zzfkf zzfkfVar = this.zzc;
        int i = zzfkfVar.zze;
        if (i == 3) {
            return;
        }
        if (i == 4) {
            this.zzb.zza();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzch)).booleanValue() && zzfkfVar.zzY == 2) {
            int i2 = zzfkfVar.zzq;
            if (i2 == 0) {
                this.zza.zza();
            } else {
                zzhbw.zzr(this.zzf, new zzdbi(this), this.zze);
                this.zzg = this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdbj
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzi();
                    }
                }, i2, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzh() {
    }

    public final /* synthetic */ void zzi() {
        synchronized (this) {
            try {
                zzhcp zzhcpVar = this.zzf;
                if (zzhcpVar.isDone()) {
                    return;
                }
                zzhcpVar.zza(Boolean.TRUE);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final synchronized void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            zzhcp zzhcpVar = this.zzf;
            if (zzhcpVar.isDone()) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzhcpVar.zzb(new Exception());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ zzddj zzk() {
        return this.zza;
    }
}
