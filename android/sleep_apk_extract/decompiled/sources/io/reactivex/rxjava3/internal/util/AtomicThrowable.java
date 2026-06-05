package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }

    public boolean tryAddThrowable(Throwable th) {
        return ExceptionHelper.addThrowable(this, th);
    }

    public boolean tryAddThrowableOrReport(Throwable th) {
        if (tryAddThrowable(th)) {
            return true;
        }
        RxJavaPlugins.onError(th);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable thTerminate = terminate();
        if (thTerminate == null || thTerminate == ExceptionHelper.TERMINATED) {
            return;
        }
        RxJavaPlugins.onError(thTerminate);
    }

    public void tryTerminateConsumer(Subscriber<?> subscriber) {
        Throwable thTerminate = terminate();
        if (thTerminate == null) {
            subscriber.onComplete();
        } else if (thTerminate != ExceptionHelper.TERMINATED) {
            subscriber.onError(thTerminate);
        }
    }
}
