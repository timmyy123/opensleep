package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes4.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call();
}
