package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface ExecutionTracker {
    void cancelPendingFutures(Throwable th);

    void track(SettableFuture<?> settableFuture);
}
