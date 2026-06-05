package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public enum FlowableInternalHelper$RequestMax implements Consumer<Subscription> {
    INSTANCE;

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }
}
