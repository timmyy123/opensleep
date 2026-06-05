package com.launchdarkly.eventsource;

/* JADX INFO: loaded from: classes4.dex */
public final class StartedEvent implements StreamEvent {
    public boolean equals(Object obj) {
        return obj instanceof StartedEvent;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "StartedEvent";
    }
}
