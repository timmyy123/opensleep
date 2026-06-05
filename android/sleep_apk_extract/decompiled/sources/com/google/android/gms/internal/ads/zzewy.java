package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewy implements zzfck {
    private final AtomicReference zza = new AtomicReference();
    private final AtomicReference zzb = new AtomicReference(Boolean.FALSE);
    private final Clock zzc;
    private final Executor zzd;
    private final zzfck zze;
    private final long zzf;
    private final zzdzl zzg;

    public zzewy(zzfck zzfckVar, long j, Clock clock, Executor executor, zzdzl zzdzlVar) {
        this.zzc = clock;
        this.zze = zzfckVar;
        this.zzf = j;
        this.zzd = executor;
        this.zzg = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzewv zzewvVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznl)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznk)).booleanValue() && !((Boolean) this.zzb.getAndSet(Boolean.TRUE)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzcfr.zzd;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzewx
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzc();
                    }
                };
                long j = this.zzf;
                scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
            }
            synchronized (this) {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzewvVar = (zzewv) atomicReference.get();
                    if (zzewvVar == null) {
                        zzewv zzewvVar2 = new zzewv(this.zze.zza(), this.zzf, this.zzc);
                        atomicReference.set(zzewvVar2);
                        return zzewvVar2.zza;
                    }
                    if (!((Boolean) this.zzb.get()).booleanValue() && zzewvVar.zza()) {
                        ListenableFuture listenableFuture = zzewvVar.zza;
                        zzfck zzfckVar = this.zze;
                        zzewv zzewvVar3 = new zzewv(zzfckVar.zza(), this.zzf, this.zzc);
                        this.zza.set(zzewvVar3);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznm)).booleanValue()) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznn)).booleanValue()) {
                                zzdzk zzdzkVarZza = this.zzg.zza();
                                zzdzkVarZza.zzc("action", "scs");
                                zzdzkVarZza.zzc("sid", String.valueOf(zzfckVar.zzb()));
                                zzdzkVarZza.zzd();
                            }
                            return listenableFuture;
                        }
                        zzewvVar = zzewvVar3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            AtomicReference atomicReference2 = this.zza;
            zzewvVar = (zzewv) atomicReference2.get();
            if (zzewvVar == null || zzewvVar.zza()) {
                zzfck zzfckVar2 = this.zze;
                zzewv zzewvVar4 = new zzewv(zzfckVar2.zza(), this.zzf, this.zzc);
                atomicReference2.set(zzewvVar4);
                zzewvVar = zzewvVar4;
            }
        }
        return zzewvVar.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return this.zze.zzb();
    }

    public final /* synthetic */ void zzc() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeww
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        });
    }

    public final /* synthetic */ void zzd() {
        this.zza.set(new zzewv(this.zze.zza(), this.zzf, this.zzc));
    }
}
