package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
interface Pools$Pool<T> {
    T acquire();

    boolean release(T t);

    void releaseAll(T[] tArr, int i);
}
