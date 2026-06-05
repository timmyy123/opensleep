package com.spotify.protocol.client;

import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.Types$RequestId;
import com.urbandroid.sleep.media.spotify.SpotifySdk;

/* JADX INFO: loaded from: classes4.dex */
public class CallResult<T> extends PendingResultBase<T> {
    private final Types$RequestId mRequestId;
    private ResultCallback<T> mResultCallback;

    public interface ResultCallback<T> {
    }

    public CallResult(Types$RequestId types$RequestId) {
        this.mRequestId = types$RequestId;
    }

    @Override // com.spotify.protocol.client.PendingResultBase
    public void onResultDelivered() {
        ResultCallback<T> resultCallback;
        if (isCanceled() || (resultCallback = this.mResultCallback) == null) {
            return;
        }
        SpotifySdk.disconnect$lambda$0((SpotifySdk) ((LoginFragment$$ExternalSyntheticLambda0) resultCallback).f$0, (Empty) this.mRecentResult.getData());
    }

    public CallResult<T> setResultCallback(ResultCallback<T> resultCallback) {
        this.mResultCallback = resultCallback;
        if (this.mRecentResult != null && this.mRecentResult.isSuccessful()) {
            onResultDelivered();
        }
        return this;
    }
}
