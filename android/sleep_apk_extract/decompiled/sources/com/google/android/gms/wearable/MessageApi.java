package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface MessageApi {

    @Deprecated
    public interface MessageListener {
        void onMessageReceived(MessageEvent messageEvent);
    }

    @Deprecated
    public interface SendMessageResult extends Result {
        int getRequestId();
    }

    PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener);

    PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageListener messageListener);
}
