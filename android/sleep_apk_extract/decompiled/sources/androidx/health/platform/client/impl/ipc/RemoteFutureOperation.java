package androidx.health.platform.client.impl.ipc;

import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface RemoteFutureOperation<S, R> {
    void execute(S s, SettableFuture<R> settableFuture);
}
