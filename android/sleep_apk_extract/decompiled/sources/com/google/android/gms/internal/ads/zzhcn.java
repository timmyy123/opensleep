package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhcn {
    public static Executor zza() {
        return zzhbl.INSTANCE;
    }

    public static zzhcg zzb(ExecutorService executorService) {
        return executorService instanceof zzhcg ? (zzhcg) executorService : executorService instanceof ScheduledExecutorService ? new zzhcm((ScheduledExecutorService) executorService) : new zzhci(executorService);
    }

    public static zzhch zzc(ScheduledExecutorService scheduledExecutorService) {
        return new zzhcm(scheduledExecutorService);
    }

    public static Executor zzd(final Executor executor, final zzhap zzhapVar) {
        executor.getClass();
        return executor == zzhbl.INSTANCE ? executor : new Executor() { // from class: com.google.android.gms.internal.ads.zzhcj
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                zzhcn.zzf(executor, zzhapVar, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzf(Executor executor, zzhap zzhapVar, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            zzhapVar.zzb(e);
        }
    }
}
