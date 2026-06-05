package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfaw implements zzfck {
    private final zzfck zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzfaw(zzfck zzfckVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfckVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        TimeUnit timeUnit = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzde)).booleanValue() ? TimeUnit.MICROSECONDS : TimeUnit.MILLISECONDS;
        long j = this.zzb;
        if (j > 0) {
            listenableFutureZza = zzhbw.zzi(listenableFutureZza, j, timeUnit, this.zzc);
        }
        return zzhbw.zzh(listenableFutureZza, Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfav
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, zzcfr.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return this.zza.zzb();
    }

    public final /* synthetic */ ListenableFuture zzc(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdc)).booleanValue()) {
            zzfck zzfckVar = this.zza;
            zzcfd zzcfdVarZzh = com.google.android.gms.ads.internal.zzt.zzh();
            int iZzb = zzfckVar.zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 22);
            sb.append("OptionalSignalTimeout:");
            sb.append(iZzb);
            zzcfdVarZzh.zzg(th, sb.toString());
        }
        return zzhbw.zza(null);
    }
}
