package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.functions.Supplier;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface ScalarSupplier<T> extends Supplier<T> {
    @Override // io.reactivex.rxjava3.functions.Supplier
    T get();
}
