package com.launchdarkly.eventsource;

/* JADX INFO: loaded from: classes4.dex */
public class StreamClosedByServerException extends StreamException {
    public StreamClosedByServerException() {
        super("Stream closed by server");
    }

    @Override // com.launchdarkly.eventsource.StreamException
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override // com.launchdarkly.eventsource.StreamException
    public int hashCode() {
        return 0;
    }
}
