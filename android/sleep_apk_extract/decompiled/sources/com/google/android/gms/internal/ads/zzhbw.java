package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhbw extends zzhby {
    public static ListenableFuture zza(Object obj) {
        return obj == null ? zzhca.zza : new zzhca(obj);
    }

    public static ListenableFuture zzb() {
        return zzhca.zza;
    }

    public static ListenableFuture zzc(Throwable th) {
        th.getClass();
        return new zzhbz(th);
    }

    public static ListenableFuture zzd(Callable callable, Executor executor) {
        zzhcv zzhcvVar = new zzhcv(callable);
        executor.execute(zzhcvVar);
        return zzhcvVar;
    }

    public static ListenableFuture zze(Runnable runnable, Executor executor) {
        zzhcv zzhcvVarZze = zzhcv.zze(runnable, null);
        executor.execute(zzhcvVarZze);
        return zzhcvVarZze;
    }

    public static ListenableFuture zzf(zzhbd zzhbdVar, Executor executor) {
        zzhcv zzhcvVar = new zzhcv(zzhbdVar);
        executor.execute(zzhcvVar);
        return zzhcvVar;
    }

    public static ListenableFuture zzg(ListenableFuture listenableFuture, Class cls, zzgta zzgtaVar, Executor executor) {
        int i = zzhao.$r8$clinit;
        zzhan zzhanVar = new zzhan(listenableFuture, cls, zzgtaVar);
        listenableFuture.addListener(zzhanVar, zzhcn.zzd(executor, zzhanVar));
        return zzhanVar;
    }

    public static ListenableFuture zzh(ListenableFuture listenableFuture, Class cls, zzhbe zzhbeVar, Executor executor) {
        int i = zzhao.$r8$clinit;
        zzham zzhamVar = new zzham(listenableFuture, cls, zzhbeVar);
        listenableFuture.addListener(zzhamVar, zzhcn.zzd(executor, zzhamVar));
        return zzhamVar;
    }

    public static ListenableFuture zzi(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : zzhcs.zze(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static ListenableFuture zzj(ListenableFuture listenableFuture, zzhbe zzhbeVar, Executor executor) {
        int i = zzhav.$r8$clinit;
        zzhat zzhatVar = new zzhat(listenableFuture, zzhbeVar);
        listenableFuture.addListener(zzhatVar, zzhcn.zzd(executor, zzhatVar));
        return zzhatVar;
    }

    public static ListenableFuture zzk(ListenableFuture listenableFuture, zzgta zzgtaVar, Executor executor) {
        int i = zzhav.$r8$clinit;
        zzhau zzhauVar = new zzhau(listenableFuture, zzgtaVar);
        listenableFuture.addListener(zzhauVar, zzhcn.zzd(executor, zzhauVar));
        return zzhauVar;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzhbf(zzgwm.zzr(listenableFutureArr), true);
    }

    public static ListenableFuture zzm(Iterable iterable) {
        return new zzhbf(zzgwm.zzp(iterable), true);
    }

    public static zzhbv zzn(Iterable iterable) {
        return new zzhbv(false, zzgwm.zzp(iterable), null);
    }

    @SafeVarargs
    public static zzhbv zzo(ListenableFuture... listenableFutureArr) {
        return new zzhbv(true, zzgwm.zzr(listenableFutureArr), null);
    }

    public static zzhbv zzp(Iterable iterable) {
        return new zzhbv(true, zzgwm.zzp(iterable), null);
    }

    @SafeVarargs
    public static ListenableFuture zzq(ListenableFuture... listenableFutureArr) {
        return new zzhbf(zzgwm.zzr(listenableFutureArr), false);
    }

    public static void zzr(ListenableFuture listenableFuture, zzhbt zzhbtVar, Executor executor) {
        zzhbtVar.getClass();
        listenableFuture.addListener(new zzhbu(listenableFuture, zzhbtVar), executor);
    }

    public static Object zzs(Future future) {
        if (future.isDone()) {
            return zzhcx.zza(future);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(zzgua.zzd("Future was expected to be done: %s", future));
        return null;
    }

    public static Object zzt(Future future) {
        try {
            return zzhcx.zza(future);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Error) {
                throw new zzhbm((Error) e.getCause());
            }
            throw new zzhcw(e.getCause());
        }
    }
}
