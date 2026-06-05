package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevx implements zzfck {
    final zzcfd zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzhcg zzd;
    private final Context zze;

    public zzevx(Context context, zzcfd zzcfdVar, ScheduledExecutorService scheduledExecutorService, zzhcg zzhcgVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdT)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcfdVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdP)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdU)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdQ)).booleanValue()) {
                    return zzhbw.zzk(zzgcs.zza(this.zzb.getAppSetIdInfo(), null), zzevw.zza, zzcfr.zzh);
                }
                Task<AppSetIdInfo> taskZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdT)).booleanValue() ? zzfmd.zzb(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZzb == null) {
                    return zzhbw.zza(new zzevy(null, -1));
                }
                ListenableFuture listenableFutureZzj = zzhbw.zzj(zzgcs.zza(taskZzb, null), zzevu.zza, zzcfr.zzh);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdR)).booleanValue()) {
                    listenableFutureZzj = zzhbw.zzi(listenableFutureZzj, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdS)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzhbw.zzg(listenableFutureZzj, Exception.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzevv
                    @Override // com.google.android.gms.internal.ads.zzgta
                    public final /* synthetic */ Object apply(Object obj) {
                        this.zza.zza.zzg((Exception) obj, "AppSetIdInfoSignal");
                        return new zzevy(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzhbw.zza(new zzevy(null, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 11;
    }
}
