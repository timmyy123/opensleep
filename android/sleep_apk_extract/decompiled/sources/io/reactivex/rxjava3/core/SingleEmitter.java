package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleEmitter<T> {
    boolean isDisposed();

    void onSuccess(T t);

    boolean tryOnError(Throwable th);
}
