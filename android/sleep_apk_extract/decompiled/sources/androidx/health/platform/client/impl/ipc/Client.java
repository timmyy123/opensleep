package androidx.health.platform.client.impl.ipc;

import android.os.IBinder;
import android.os.IInterface;
import androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation;
import androidx.health.platform.client.impl.ipc.internal.ConnectionConfiguration;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import androidx.health.platform.client.impl.ipc.internal.ExecutionTracker;
import androidx.health.platform.client.impl.ipc.internal.ListenerKey;
import androidx.health.platform.client.impl.ipc.internal.QueueOperation;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class Client<S extends IInterface> {
    private static final int UNKNOWN_VERSION = -1;
    protected final ConnectionConfiguration mConnectionConfiguration;
    protected final ConnectionManager mConnectionManager;
    protected volatile int mCurrentVersion = -1;
    private final RemoteOperation<S, Integer> mRemoteVersionGetter;
    private final ServiceGetter<S> mServiceGetter;

    public interface ServiceGetter<S> {
        S getService(IBinder iBinder);
    }

    public Client(ClientConfiguration clientConfiguration, ConnectionManager connectionManager, final ServiceGetter<S> serviceGetter, final RemoteOperation<S, Integer> remoteOperation) {
        this.mConnectionConfiguration = new ConnectionConfiguration(clientConfiguration.getServicePackageName(), clientConfiguration.getApiClientName(), clientConfiguration.getBindAction(), new QueueOperation() { // from class: androidx.health.platform.client.impl.ipc.Client.1
            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder iBinder) {
                Client.this.mCurrentVersion = ((Integer) remoteOperation.execute((IInterface) serviceGetter.getService(iBinder))).intValue();
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public ConnectionConfiguration getConnectionConfiguration() {
                return Client.this.mConnectionConfiguration;
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void setException(Throwable th) {
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public QueueOperation trackExecution(ExecutionTracker executionTracker) {
                return this;
            }
        });
        this.mConnectionManager = connectionManager;
        this.mServiceGetter = serviceGetter;
        this.mRemoteVersionGetter = remoteOperation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$execute$0(RemoteOperation remoteOperation, IInterface iInterface, SettableFuture settableFuture) {
        settableFuture.set(remoteOperation.execute(iInterface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getCurrentRemoteVersion$1(Integer num) {
        this.mCurrentVersion = num.intValue();
        return Integer.valueOf(this.mCurrentVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerListener$2(RemoteOperation remoteOperation, IInterface iInterface, SettableFuture settableFuture) {
        settableFuture.set(remoteOperation.execute(iInterface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unregisterListener$3(RemoteOperation remoteOperation, IInterface iInterface, SettableFuture settableFuture) {
        settableFuture.set(remoteOperation.execute(iInterface));
    }

    public <R> QueueOperation createQueueOperation(final RemoteFutureOperation<S, R> remoteFutureOperation, final SettableFuture<R> settableFuture) {
        return new BaseQueueOperation(this.mConnectionConfiguration) { // from class: androidx.health.platform.client.impl.ipc.Client.3
            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder iBinder) {
                remoteFutureOperation.execute(Client.this.getService(iBinder), settableFuture);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void setException(Throwable th) {
                settableFuture.setException(th);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public QueueOperation trackExecution(ExecutionTracker executionTracker) {
                executionTracker.track(settableFuture);
                return this;
            }
        };
    }

    public <R> ListenableFuture<R> execute(RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.scheduleForExecution(createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    public <R> ListenableFuture<R> executeWithVersionCheck(final int i, final RemoteFutureOperation<S, R> remoteFutureOperation) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        Futures.addCallback(getCurrentRemoteVersion(false), new FutureCallback<Integer>() { // from class: androidx.health.platform.client.impl.ipc.Client.2
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                settableFutureCreate.setException(th);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Integer num) {
                int iIntValue = num.intValue();
                int i2 = i;
                Client client = Client.this;
                if (iIntValue >= i2) {
                    client.mConnectionManager.scheduleForExecution(client.createQueueOperation(remoteFutureOperation, settableFutureCreate));
                } else {
                    client.mConnectionManager.scheduleForExecution(new BaseQueueOperation(client.mConnectionConfiguration));
                    settableFutureCreate.setException(Client.this.getApiVersionCheckFailureException(num.intValue(), i));
                }
            }
        }, MoreExecutors.directExecutor());
        return settableFutureCreate;
    }

    public Exception getApiVersionCheckFailureException(int i, int i2) {
        return new ApiVersionException(i, i2);
    }

    public ConnectionConfiguration getConnectionConfiguration() {
        return this.mConnectionConfiguration;
    }

    public ConnectionManager getConnectionManager() {
        return this.mConnectionManager;
    }

    public ListenableFuture<Integer> getCurrentRemoteVersion(boolean z) {
        return (this.mCurrentVersion == -1 || z) ? Futures.transform(execute(this.mRemoteVersionGetter), new Function() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$getCurrentRemoteVersion$1((Integer) obj);
            }
        }, MoreExecutors.directExecutor()) : Futures.immediateFuture(Integer.valueOf(this.mCurrentVersion));
    }

    public S getService(IBinder iBinder) {
        return this.mServiceGetter.getService(iBinder);
    }

    public <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.registerListener(listenerKey, createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    public <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.unregisterListener(listenerKey, createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    public <R> ListenableFuture<R> execute(RemoteOperation<S, R> remoteOperation) {
        return execute(new Client$$ExternalSyntheticLambda0(remoteOperation, 1));
    }

    public <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, RemoteOperation<S, R> remoteOperation) {
        return registerListener(listenerKey, new Client$$ExternalSyntheticLambda0(remoteOperation, 0));
    }

    public <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, RemoteOperation<S, R> remoteOperation) {
        return unregisterListener(listenerKey, new Client$$ExternalSyntheticLambda0(remoteOperation, 2));
    }
}
