package com.polar.androidcommunications.api.ble.exceptions;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/exceptions/TimeStampAndFrequencyZeroError;", "Lcom/polar/androidcommunications/api/ble/exceptions/BlePmdTimeStampError;", "", "detailMessage", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getDetailMessage", "()Ljava/lang/String;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimeStampAndFrequencyZeroError extends BlePmdTimeStampError {
    private final String detailMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeStampAndFrequencyZeroError(String str) {
        super(str, null);
        str.getClass();
        this.detailMessage = str;
    }
}
