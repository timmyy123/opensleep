package com.google.firebase.components;

import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Provider;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
class OptionalProvider<T> implements Provider<T> {
    private volatile Provider<T> delegate;
    private Deferred$DeferredHandler<T> handler;
    private static final Deferred$DeferredHandler<Object> NOOP_HANDLER = new OptionalProvider$$ExternalSyntheticLambda0();
    private static final Provider<Object> EMPTY_PROVIDER = new OptionalProvider$$ExternalSyntheticLambda1(0);

    private OptionalProvider(Deferred$DeferredHandler<T> deferred$DeferredHandler, Provider<T> provider) {
        this.handler = deferred$DeferredHandler;
        this.delegate = provider;
    }

    public static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    private static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.delegate.get();
    }

    public void set(Provider<T> provider) {
        Deferred$DeferredHandler<T> deferred$DeferredHandler;
        if (this.delegate != EMPTY_PROVIDER) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("provide() can be called only once.");
            return;
        }
        synchronized (this) {
            deferred$DeferredHandler = this.handler;
            this.handler = null;
            this.delegate = provider;
        }
        ((OptionalProvider$$ExternalSyntheticLambda0) deferred$DeferredHandler).getClass();
        lambda$static$0(provider);
    }
}
