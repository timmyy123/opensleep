package io.opencensus.contrib.http.util;

import io.opencensus.trace.propagation.TextFormat;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpPropagationUtil {
    public static TextFormat getCloudTraceFormat() {
        return new CloudTraceFormat();
    }
}
