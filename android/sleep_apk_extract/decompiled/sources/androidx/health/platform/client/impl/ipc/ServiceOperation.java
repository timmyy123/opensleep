package androidx.health.platform.client.impl.ipc;

import android.os.IBinder;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface ServiceOperation<R> {
    void execute(IBinder iBinder, SettableFuture<R> settableFuture);
}
