package androidx.health.platform.client.impl.ipc.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.health.platform.client.impl.logger.Logger;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnection implements android.content.ServiceConnection {
    private static final int MAX_RETRIES = 10;
    private static final String TAG = "ServiceConnection";
    IBinder mBinder;
    private final Callback mCallback;
    private final ConnectionConfiguration mConnectionConfiguration;
    private final Context mContext;
    private final ExecutionTracker mExecutionTracker;
    volatile boolean mIsServiceBound;
    private int mServiceConnectionRetry;
    private final Queue<QueueOperation> mOperationQueue = new ConcurrentLinkedQueue();
    private final Map<ListenerKey, QueueOperation> mRegisteredListeners = new HashMap();
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: androidx.health.platform.client.impl.ipc.internal.ServiceConnection$$ExternalSyntheticLambda0
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            this.f$0.lambda$new$0();
        }
    };

    public interface Callback {
        boolean isBindToSelfEnabled();

        void onConnected(ServiceConnection serviceConnection);

        void onDisconnected(ServiceConnection serviceConnection, long j);
    }

    public ServiceConnection(Context context, ConnectionConfiguration connectionConfiguration, ExecutionTracker executionTracker, Callback callback) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mConnectionConfiguration = (ConnectionConfiguration) Preconditions.checkNotNull(connectionConfiguration);
        this.mExecutionTracker = (ExecutionTracker) Preconditions.checkNotNull(executionTracker);
        this.mCallback = (Callback) Preconditions.checkNotNull(callback);
    }

    private void cancelAllOperationsInQueue(Throwable th) {
        for (QueueOperation queueOperation : new ArrayList(this.mOperationQueue)) {
            if (this.mOperationQueue.remove(queueOperation)) {
                queueOperation.setException(th);
            }
        }
    }

    private void cleanOnDeath(IBinder iBinder) {
        try {
            iBinder.linkToDeath(this.mDeathRecipient, 0);
        } catch (RemoteException e) {
            Logger.warning(TAG, "Cannot link to death, binder already died. Cleaning operations.", e);
            handleRetriableDisconnection(e);
        }
    }

    private String getBindPackageName() {
        return this.mCallback.isBindToSelfEnabled() ? this.mContext.getPackageName() : this.mConnectionConfiguration.getPackageName();
    }

    private static int getRetryDelayMs(int i) {
        return 200 << i;
    }

    private void handleNonRetriableDisconnection(Throwable th) {
        this.mServiceConnectionRetry = 10;
        handleRetriableDisconnection(th);
    }

    private synchronized void handleRetriableDisconnection(Throwable th) {
        if (isConnected()) {
            Logger.warning(TAG, "Connection is already re-established. No need to reconnect again");
            return;
        }
        clearConnection(th);
        if (this.mServiceConnectionRetry < 10) {
            Logger.warning(TAG, "WCS SDK Client '" + this.mConnectionConfiguration.getClientName() + "' disconnected, retrying connection. Retry attempt: " + this.mServiceConnectionRetry, th);
            this.mCallback.onDisconnected(this, (long) getRetryDelayMs(this.mServiceConnectionRetry));
        } else {
            Logger.error(TAG, "Connection disconnected and maximum number of retries reached.", th);
        }
    }

    private boolean isConnected() {
        IBinder iBinder = this.mBinder;
        return iBinder != null && iBinder.isBinderAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Logger.warning(TAG, "Binder died for client:" + this.mConnectionConfiguration.getClientName());
        handleRetriableDisconnection(new RemoteException("Binder died"));
    }

    private void tryClearConnection() {
        if (this.mIsServiceBound) {
            try {
                this.mContext.unbindService(this);
            } catch (IllegalArgumentException e) {
                Logger.error(TAG, "Failed to unbind the service. Ignoring and continuing", e);
            }
            this.mIsServiceBound = false;
        }
        IBinder iBinder = this.mBinder;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.mDeathRecipient, 0);
            } catch (NoSuchElementException e2) {
                Logger.error(TAG, "mDeathRecipient not linked", e2);
            }
            this.mBinder = null;
        }
        Logger.debug(TAG, "unbindService called");
    }

    public void clearConnection(Throwable th) {
        tryClearConnection();
        this.mExecutionTracker.cancelPendingFutures(th);
        cancelAllOperationsInQueue(th);
    }

    public boolean clearConnectionIfIdle() {
        if (!this.mOperationQueue.isEmpty() || !this.mRegisteredListeners.isEmpty()) {
            return false;
        }
        tryClearConnection();
        return true;
    }

    public void connect() {
        if (this.mIsServiceBound) {
            return;
        }
        try {
            this.mIsServiceBound = this.mContext.bindService(new Intent().setPackage(getBindPackageName()).setAction(this.mConnectionConfiguration.getBindAction()), this, 129);
            if (this.mIsServiceBound) {
                return;
            }
            Logger.error(TAG, "Connection to service is not available for package '" + this.mConnectionConfiguration.getPackageName() + "' and action '" + this.mConnectionConfiguration.getBindAction() + "'.");
            handleNonRetriableDisconnection(new RemoteException("Binding to service failed"));
        } catch (SecurityException e) {
            Logger.warning(TAG, "Failed to bind connection '" + this.mConnectionConfiguration.getKey() + "', no permission or service not found.", e);
            this.mIsServiceBound = false;
            this.mBinder = null;
            throw e;
        }
    }

    public void enqueue(QueueOperation queueOperation) {
        if (isConnected()) {
            execute(queueOperation);
        } else {
            this.mOperationQueue.add(queueOperation);
            connect();
        }
    }

    public void execute(QueueOperation queueOperation) {
        try {
            queueOperation.trackExecution(this.mExecutionTracker);
            queueOperation.execute((IBinder) Preconditions.checkNotNull(this.mBinder));
        } catch (DeadObjectException e) {
            handleRetriableDisconnection(e);
        } catch (RemoteException e2) {
            e = e2;
            queueOperation.setException(e);
        } catch (RuntimeException e3) {
            e = e3;
            queueOperation.setException(e);
        }
    }

    public void flushQueue() {
        for (QueueOperation queueOperation : new ArrayList(this.mOperationQueue)) {
            if (this.mOperationQueue.remove(queueOperation)) {
                execute(queueOperation);
            }
        }
    }

    public void maybeReconnect() {
        if (this.mRegisteredListeners.isEmpty()) {
            Logger.debug(TAG, "No listeners registered, service " + this.mConnectionConfiguration.getClientName() + " is not automatically reconnected.");
            return;
        }
        this.mServiceConnectionRetry++;
        Logger.debug(TAG, "Listeners for service " + this.mConnectionConfiguration.getClientName() + " are registered, reconnecting.");
        connect();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Logger.error(TAG, "Binding died for client '" + this.mConnectionConfiguration.getClientName() + "'.");
        handleRetriableDisconnection(new RemoteException("Binding died"));
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Logger.error(TAG, "Cannot bind client '" + this.mConnectionConfiguration.getClientName() + "', binder is null");
        handleRetriableDisconnection(new RemoteException("Null binding"));
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger.debug(TAG, "onServiceConnected(), componentName = " + componentName);
        if (iBinder == null) {
            Logger.error(TAG, "Service connected but binder is null.");
            return;
        }
        this.mServiceConnectionRetry = 0;
        cleanOnDeath(iBinder);
        this.mBinder = iBinder;
        this.mCallback.onConnected(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Logger.debug(TAG, "onServiceDisconnected(), componentName = " + componentName);
    }

    public void reRegisterAllListeners() {
        for (Map.Entry<ListenerKey, QueueOperation> entry : this.mRegisteredListeners.entrySet()) {
            Logger.debug(TAG, "Re-registering listener: " + entry.getKey());
            execute(entry.getValue());
        }
    }

    public void refreshServiceVersion() {
        this.mOperationQueue.add(this.mConnectionConfiguration.getRefreshVersionOperation());
    }

    public void registerListener(ListenerKey listenerKey, QueueOperation queueOperation) {
        this.mRegisteredListeners.put(listenerKey, queueOperation);
        if (isConnected()) {
            enqueue(queueOperation);
        } else {
            connect();
        }
    }

    public void unregisterListener(ListenerKey listenerKey, QueueOperation queueOperation) {
        this.mRegisteredListeners.remove(listenerKey);
        enqueue(queueOperation);
    }
}
