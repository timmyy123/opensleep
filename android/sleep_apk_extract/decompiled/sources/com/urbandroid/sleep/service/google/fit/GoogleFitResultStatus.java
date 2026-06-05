package com.urbandroid.sleep.service.google.fit;

import com.google.android.gms.common.api.Status;
import com.urbandroid.sleep.service.health.ResultStatus;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleFitResultStatus implements ResultStatus {
    private final Status result;

    public GoogleFitResultStatus(Status status) {
        this.result = status;
    }

    @Override // com.urbandroid.sleep.service.health.ResultStatus
    public boolean isSuccess() {
        return this.result.isSuccess();
    }

    public String toString() {
        return this.result.toString();
    }
}
