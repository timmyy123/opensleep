package com.spotify.protocol.client;

import com.spotify.protocol.types.Types$RequestId;

/* JADX INFO: loaded from: classes4.dex */
public class Subscription<T> extends PendingResultBase<T> {
    private volatile EventCallback<T> mEventCallback;
    private final RemoteClient mRemoteWampClient;
    private final Types$RequestId mRequestId;

    public interface EventCallback<T> {
        void onEvent(T t);
    }

    public Subscription(Types$RequestId types$RequestId, RemoteClient remoteClient) {
        this.mRequestId = types$RequestId;
        this.mRemoteWampClient = remoteClient;
    }

    @Override // com.spotify.protocol.client.PendingResultBase
    public void cancel() {
        if (isCanceled()) {
            return;
        }
        super.cancel();
        this.mRemoteWampClient.unsubscribe(this);
    }

    public final void deliverStart() {
        isCanceled();
    }

    public Types$RequestId getRequestId() {
        return this.mRequestId;
    }

    @Override // com.spotify.protocol.client.PendingResultBase
    public void onResultDelivered() {
        if (isCanceled() || this.mEventCallback == null) {
            return;
        }
        this.mEventCallback.onEvent(this.mRecentResult.getData());
    }

    public Subscription<T> setEventCallback(EventCallback<T> eventCallback) {
        this.mEventCallback = eventCallback;
        if (this.mRecentResult != null && this.mRecentResult.isSuccessful()) {
            onResultDelivered();
        }
        return this;
    }
}
