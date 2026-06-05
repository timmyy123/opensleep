package com.google.android.datatransport.runtime.dagger.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class InstanceFactory<T> implements Factory<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t) {
        this.instance = t;
    }

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }
}
