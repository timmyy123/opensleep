package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    public static <T, R> R apply(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    public static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) apply(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Scheduler Callable returned null");
        return null;
    }

    public static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        try {
            Scheduler schedulerCall = callable.call();
            if (schedulerCall != null) {
                return schedulerCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
            return function == null ? callRequireNonNull(callable) : applyRequireNonNull(function, callable);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("scheduler == null");
        return null;
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> function = onMainThreadHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("scheduler == null");
        return null;
    }
}
