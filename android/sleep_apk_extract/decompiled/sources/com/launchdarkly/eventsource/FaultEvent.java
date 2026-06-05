package com.launchdarkly.eventsource;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class FaultEvent implements StreamEvent {
    private final StreamException cause;
    private final ResponseHeaders headers;

    public FaultEvent(StreamException streamException, ResponseHeaders responseHeaders) {
        this.cause = streamException;
        this.headers = responseHeaders;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FaultEvent.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.cause, ((FaultEvent) obj).cause);
    }

    public StreamException getCause() {
        return this.cause;
    }

    public int hashCode() {
        return Objects.hash(this.cause);
    }

    public String toString() {
        return "FaultEvent(" + this.cause + ")";
    }

    public FaultEvent(StreamException streamException) {
        this(streamException, null);
    }
}
