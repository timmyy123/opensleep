package com.google.android.gms.common.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TelemetryLogging {
    public static TelemetryLoggingClient getClient(Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    public static TelemetryLoggingClient getClient(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zat(context, telemetryLoggingOptions);
    }
}
