package com.google.common.collect;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ForwardingObject {
    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
