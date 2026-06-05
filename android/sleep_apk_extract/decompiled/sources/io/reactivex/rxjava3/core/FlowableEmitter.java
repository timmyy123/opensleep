package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
public interface FlowableEmitter<T> extends Emitter<T> {
    boolean isCancelled();

    boolean tryOnError(Throwable th);
}
