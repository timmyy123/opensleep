package com.google.firebase.events;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public interface Subscriber {
    <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);
}
