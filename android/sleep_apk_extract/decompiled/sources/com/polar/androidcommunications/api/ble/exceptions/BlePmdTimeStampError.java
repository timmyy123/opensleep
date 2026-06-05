package com.polar.androidcommunications.api.ble.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/exceptions/BlePmdTimeStampError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detailMessage", "", "(Ljava/lang/String;)V", "Lcom/polar/androidcommunications/api/ble/exceptions/NegativeTimeStampError;", "Lcom/polar/androidcommunications/api/ble/exceptions/SampleSizeMissingError;", "Lcom/polar/androidcommunications/api/ble/exceptions/TimeStampAndFrequencyZeroError;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BlePmdTimeStampError extends Exception {
    public /* synthetic */ BlePmdTimeStampError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private BlePmdTimeStampError(String str) {
        super(str);
    }
}
