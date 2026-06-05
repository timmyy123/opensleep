package com.spotify.android.appremote.internal;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.ResultUtils;
import com.spotify.protocol.types.Types$RequestId;

/* JADX INFO: loaded from: classes4.dex */
public class PendingServiceConnectionResult extends CallResult<Void> {
    public PendingServiceConnectionResult() {
        super(Types$RequestId.NONE);
    }

    public final void deliverFailure(Throwable th) {
        deliverResult(ResultUtils.createErrorResult(th));
    }

    public final void deliverSuccess() {
        deliverResult(ResultUtils.createSuccessfulResult(null));
    }
}
