package com.urbandroid.sleep.domain.interval;

import com.urbandroid.sleep.domain.EventLabel;

/* JADX INFO: loaded from: classes4.dex */
public class EventPair {
    private final EventLabel end;
    private final EventLabel start;

    public EventPair(EventLabel eventLabel, EventLabel eventLabel2) {
        this.start = eventLabel;
        this.end = eventLabel2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventPair)) {
            return false;
        }
        EventPair eventPair = (EventPair) obj;
        return this.start == eventPair.start && this.end == eventPair.end;
    }

    public EventLabel getEnd() {
        return this.end;
    }

    public EventLabel getStart() {
        return this.start;
    }

    public int hashCode() {
        EventLabel eventLabel = this.start;
        int iHashCode = (eventLabel != null ? eventLabel.hashCode() : 0) * 31;
        EventLabel eventLabel2 = this.end;
        return iHashCode + (eventLabel2 != null ? eventLabel2.hashCode() : 0);
    }

    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }
}
