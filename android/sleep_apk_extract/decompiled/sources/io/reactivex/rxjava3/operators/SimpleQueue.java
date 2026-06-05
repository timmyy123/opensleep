package io.reactivex.rxjava3.operators;

/* JADX INFO: loaded from: classes5.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll();
}
