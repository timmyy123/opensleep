package androidx.health.platform.client.impl.ipc.internal;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public interface QueueOperation {
    void execute(IBinder iBinder);

    ConnectionConfiguration getConnectionConfiguration();

    void setException(Throwable th);

    QueueOperation trackExecution(ExecutionTracker executionTracker);
}
