package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Callables {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$returning$0(Object obj) {
        return obj;
    }

    public static <T> Callable<T> returning(T t) {
        return new Callables$$ExternalSyntheticLambda0(t, 0);
    }
}
