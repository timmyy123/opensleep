package com.google.api.client.util;

/* JADX INFO: loaded from: classes4.dex */
public final class Joiner {
    private final com.google.common.base.Joiner wrapped;

    private Joiner(com.google.common.base.Joiner joiner) {
        this.wrapped = joiner;
    }

    public static Joiner on(char c) {
        return new Joiner(com.google.common.base.Joiner.on(c));
    }

    public final String join(Iterable<?> iterable) {
        return this.wrapped.join((Iterable<? extends Object>) iterable);
    }
}
