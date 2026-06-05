package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcyi {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcyi(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    public final void zza(zzhbt zzhbtVar) {
        zzhbw.zzr(this.zzc, new zzcyc(this, zzhbtVar), this.zza);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final /* synthetic */ ListenableFuture zzc(zzhbt zzhbtVar, ListenableFuture listenableFuture, zzcxt zzcxtVar) {
        if (zzcxtVar != null) {
            zzhbtVar.zzb(zzcxtVar);
        }
        return zzhbw.zzi(listenableFuture, ((Long) zzble.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final /* synthetic */ void zze(List list, final zzhbt zzhbtVar) {
        if (list == null || list.isEmpty()) {
            this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcyh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzhbtVar.zza(new zzeed(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureZza = zzhbw.zza(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcye
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    zzhbtVar.zza((Throwable) obj);
                    return zzhbw.zza(null);
                }
            };
            Executor executor = this.zza;
            listenableFutureZza = zzhbw.zzj(zzhbw.zzh(listenableFutureZza, Throwable.class, zzhbeVar, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcyf
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzc(zzhbtVar, listenableFuture, (zzcxt) obj);
                }
            }, executor);
        }
        zzhbw.zzr(listenableFutureZza, new zzcyd(this, zzhbtVar), this.zza);
    }

    public final /* synthetic */ void zzf() {
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcyg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        });
    }
}
