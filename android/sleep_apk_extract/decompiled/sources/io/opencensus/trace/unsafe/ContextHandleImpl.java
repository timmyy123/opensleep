package io.opencensus.trace.unsafe;

import io.grpc.Context;
import io.opencensus.trace.ContextHandle;

/* JADX INFO: loaded from: classes5.dex */
class ContextHandleImpl implements ContextHandle {
    private final Context context;

    public ContextHandleImpl(Context context) {
        this.context = context;
    }

    @Override // io.opencensus.trace.ContextHandle
    public ContextHandle attach() {
        return new ContextHandleImpl(this.context.attach());
    }

    @Override // io.opencensus.trace.ContextHandle
    public void detach(ContextHandle contextHandle) {
        this.context.detach(((ContextHandleImpl) contextHandle).context);
    }

    public Context getContext() {
        return this.context;
    }
}
