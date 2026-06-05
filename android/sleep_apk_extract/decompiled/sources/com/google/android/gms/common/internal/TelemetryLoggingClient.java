package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public interface TelemetryLoggingClient {
    Task<Void> log(TelemetryData telemetryData);
}
