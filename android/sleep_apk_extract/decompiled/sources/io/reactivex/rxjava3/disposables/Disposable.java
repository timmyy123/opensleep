package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public interface Disposable {
    static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    static Disposable fromRunnable(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    void dispose();

    boolean isDisposed();
}
