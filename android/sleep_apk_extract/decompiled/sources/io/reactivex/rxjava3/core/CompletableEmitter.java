package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable th);

    boolean tryOnError(Throwable th);
}
