package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcfr {
    public static final zzhcg zza;
    public static final zzhcg zzb;
    public static final zzhcg zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzhch zze;
    public static final zzhcg zzf;
    public static final ExecutorService zzg;
    public static final zzhcg zzh;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    static {
        ExecutorService threadPoolExecutor;
        ExecutorService executorServiceZza;
        ExecutorService executorServiceZzc;
        if (ClientLibraryUtils.isPackageSide()) {
            zzgal.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcfo("Default")));
        } else {
            zzbih zzbihVar = zzbiq.zzmI;
            if (com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar) == null || !((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar)).booleanValue()) {
                threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcfo("Default"));
            } else {
                zzbih zzbihVar2 = zzbiq.zzmJ;
                if (com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar2) != null) {
                    zzbih zzbihVar3 = zzbiq.zzmK;
                    if (com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar3) != null) {
                        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar2)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar2)).intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcfo("Default"));
                        threadPoolExecutor2.allowCoreThreadTimeOut(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zze(zzbihVar3)).booleanValue());
                        threadPoolExecutor = threadPoolExecutor2;
                    }
                }
            }
        }
        zza = new zzcfq(threadPoolExecutor, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZza = zzgal.zza().zza(5, new zzcfo("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcfo("Loader"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorServiceZza = threadPoolExecutor3;
        }
        zzb = new zzcfq(executorServiceZza, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzc = zzgal.zza().zzc(new zzcfo("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcfo("Activeview"));
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            executorServiceZzc = threadPoolExecutor4;
        }
        zzc = new zzcfq(executorServiceZzc, null);
        zzcfn zzcfnVar = new zzcfn(3, new zzcfo(AppEventsConstants.EVENT_NAME_SCHEDULE));
        zzd = zzcfnVar;
        zze = zzhcn.zzc(zzcfnVar);
        zzf = new zzcfq(new zzcfp(), null);
        zzg = Executors.newSingleThreadExecutor(new zzcfo("AdQualityMetrics"));
        zzh = new zzcfq(zzhcn.zza(), null);
    }
}
