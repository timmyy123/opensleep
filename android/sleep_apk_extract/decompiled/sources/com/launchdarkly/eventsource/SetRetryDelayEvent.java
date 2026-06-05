package com.launchdarkly.eventsource;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes4.dex */
final class SetRetryDelayEvent implements StreamEvent {
    private final long retryMillis;

    public SetRetryDelayEvent(long j) {
        this.retryMillis = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && SetRetryDelayEvent.class == obj.getClass() && this.retryMillis == ((SetRetryDelayEvent) obj).retryMillis;
    }

    public long getRetryMillis() {
        return this.retryMillis;
    }

    public int hashCode() {
        return (int) this.retryMillis;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.retryMillis, ")", new StringBuilder("SetRetryDelayEvent("));
    }
}
