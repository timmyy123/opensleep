package com.polar.androidcommunications.api.ble.exceptions;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/polar/androidcommunications/api/ble/exceptions/SampleSizeMissingError;", "Lcom/polar/androidcommunications/api/ble/exceptions/BlePmdTimeStampError;", "()V", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SampleSizeMissingError extends BlePmdTimeStampError {
    public static final SampleSizeMissingError INSTANCE = new SampleSizeMissingError();

    private SampleSizeMissingError() {
        super("", null);
    }
}
