package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: loaded from: classes3.dex */
public class StatusCallback extends IStatusCallback.Stub {
    private final BaseImplementation$ResultHolder<Status> resultHolder;

    public StatusCallback(BaseImplementation$ResultHolder<Status> baseImplementation$ResultHolder) {
        this.resultHolder = baseImplementation$ResultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public void onResult(Status status) {
        this.resultHolder.setResult(status);
    }
}
