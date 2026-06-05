package com.urbandroid.common;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/common/AsyncContext;", "T", "", "weakRef", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getWeakRef", "()Ljava/lang/ref/WeakReference;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsyncContext<T> {
    private final WeakReference<T> weakRef;

    public AsyncContext(WeakReference<T> weakReference) {
        weakReference.getClass();
        this.weakRef = weakReference;
    }

    public final WeakReference<T> getWeakRef() {
        return this.weakRef;
    }
}
