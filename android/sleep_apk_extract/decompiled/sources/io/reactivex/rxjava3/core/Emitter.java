package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
public interface Emitter<T> {
    void onComplete();

    void onNext(T t);
}
