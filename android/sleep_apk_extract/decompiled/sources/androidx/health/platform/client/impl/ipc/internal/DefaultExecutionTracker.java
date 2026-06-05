package androidx.health.platform.client.impl.ipc.internal;

import com.facebook.FacebookSdk$$ExternalSyntheticLambda9;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DefaultExecutionTracker implements ExecutionTracker {
    private final Set<SettableFuture<?>> mFuturesInProgress = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$track$0(SettableFuture settableFuture) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.remove(settableFuture);
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void cancelPendingFutures(Throwable th) {
        HashSet hashSet;
        synchronized (this.mFuturesInProgress) {
            hashSet = new HashSet(this.mFuturesInProgress);
            this.mFuturesInProgress.clear();
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((SettableFuture) it.next()).setException(th);
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void track(SettableFuture<?> settableFuture) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.add(settableFuture);
            settableFuture.addListener(new FacebookSdk$$ExternalSyntheticLambda9(this, settableFuture, 4), MoreExecutors.directExecutor());
        }
    }
}
