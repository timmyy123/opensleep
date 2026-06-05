package androidx.health.platform.client.impl.ipc.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.health.platform.client.impl.ipc.internal.ServiceConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionManager implements Handler.Callback, ServiceConnection.Callback {
    private static final int MSG_CONNECTED = 1;
    private static final int MSG_DISCONNECTED = 2;
    private static final int MSG_EXECUTE = 3;
    private static final int MSG_REGISTER_LISTENER = 4;
    private static final int MSG_UNBIND = 6;
    private static final int MSG_UNREGISTER_LISTENER = 5;
    private static final String TAG = "ConnectionManager";
    static final int UNBIND_IDLE_DELAY_MILLISECONDS = 15000;
    private boolean mBindToSelfEnabled;
    private final Context mContext;
    private final Handler mHandler;
    private final Map<String, ServiceConnection> mServiceConnectionMap = new HashMap();

    public static class ListenerHolder {
        private final ListenerKey mListenerKey;
        private final QueueOperation mListenerOperation;

        public ListenerHolder(ListenerKey listenerKey, QueueOperation queueOperation) {
            this.mListenerKey = listenerKey;
            this.mListenerOperation = queueOperation;
        }

        public ListenerKey getListenerKey() {
            return this.mListenerKey;
        }

        public QueueOperation getListenerOperation() {
            return this.mListenerOperation;
        }
    }

    public ConnectionManager(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
    }

    public void delayIdleServiceUnbindCheck(ServiceConnection serviceConnection) {
        this.mHandler.removeMessages(6, serviceConnection);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(6, serviceConnection), 15000L);
    }

    public ServiceConnection getConnection(ConnectionConfiguration connectionConfiguration) {
        String key = connectionConfiguration.getKey();
        ServiceConnection serviceConnection = this.mServiceConnectionMap.get(key);
        if (serviceConnection != null) {
            return serviceConnection;
        }
        ServiceConnection serviceConnection2 = new ServiceConnection(this.mContext, connectionConfiguration, new DefaultExecutionTracker(), this);
        this.mServiceConnectionMap.put(key, serviceConnection2);
        return serviceConnection2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ServiceConnection serviceConnection = (ServiceConnection) message.obj;
                serviceConnection.reRegisterAllListeners();
                serviceConnection.refreshServiceVersion();
                serviceConnection.flushQueue();
                delayIdleServiceUnbindCheck(serviceConnection);
                return true;
            case 2:
                ((ServiceConnection) message.obj).maybeReconnect();
                return true;
            case 3:
                QueueOperation queueOperation = (QueueOperation) message.obj;
                ServiceConnection connection = getConnection(queueOperation.getConnectionConfiguration());
                connection.enqueue(queueOperation);
                delayIdleServiceUnbindCheck(connection);
                return true;
            case 4:
                ListenerHolder listenerHolder = (ListenerHolder) message.obj;
                ServiceConnection connection2 = getConnection(listenerHolder.getListenerOperation().getConnectionConfiguration());
                connection2.registerListener(listenerHolder.getListenerKey(), listenerHolder.getListenerOperation());
                delayIdleServiceUnbindCheck(connection2);
                return true;
            case 5:
                ListenerHolder listenerHolder2 = (ListenerHolder) message.obj;
                ServiceConnection connection3 = getConnection(listenerHolder2.getListenerOperation().getConnectionConfiguration());
                connection3.unregisterListener(listenerHolder2.getListenerKey(), listenerHolder2.getListenerOperation());
                delayIdleServiceUnbindCheck(connection3);
                return true;
            case 6:
                ServiceConnection serviceConnection2 = (ServiceConnection) message.obj;
                if (!this.mHandler.hasMessages(3) && !this.mHandler.hasMessages(4) && !this.mHandler.hasMessages(5) && !serviceConnection2.clearConnectionIfIdle()) {
                    delayIdleServiceUnbindCheck(serviceConnection2);
                }
                return true;
            default:
                Log.e(TAG, "Received unknown message: " + message.what);
                return false;
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public boolean isBindToSelfEnabled() {
        return this.mBindToSelfEnabled;
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public void onConnected(ServiceConnection serviceConnection) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, serviceConnection));
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public void onDisconnected(ServiceConnection serviceConnection, long j) {
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(2, serviceConnection), j);
    }

    public void registerListener(ListenerKey listenerKey, QueueOperation queueOperation) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, new ListenerHolder(listenerKey, queueOperation)));
    }

    public void scheduleForExecution(QueueOperation queueOperation) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, queueOperation));
    }

    public void setBindToSelf(boolean z) {
        this.mBindToSelfEnabled = z;
    }

    public void unregisterListener(ListenerKey listenerKey, QueueOperation queueOperation) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(5, new ListenerHolder(listenerKey, queueOperation)));
    }
}
