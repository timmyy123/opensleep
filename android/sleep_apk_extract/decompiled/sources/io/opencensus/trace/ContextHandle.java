package io.opencensus.trace;

/* JADX INFO: loaded from: classes5.dex */
public interface ContextHandle {
    ContextHandle attach();

    void detach(ContextHandle contextHandle);
}
