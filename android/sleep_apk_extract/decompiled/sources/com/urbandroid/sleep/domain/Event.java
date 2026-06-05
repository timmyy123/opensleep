package com.urbandroid.sleep.domain;

import com.urbandroid.common.util.DateUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class Event implements IEvent, Serializable {
    private EventLabel label;
    private String labelString;
    private long timestamp;
    private float value;

    @Deprecated
    public Event(long j, EventLabel eventLabel) {
        this.timestamp = j;
        this.label = eventLabel;
        this.labelString = null;
        this.value = 0.0f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return event.timestamp == this.timestamp && event.label == this.label && event.value == this.value;
    }

    @Override // com.urbandroid.sleep.domain.IEvent
    public EventLabel getLabel() {
        return this.label;
    }

    public String getLabelOrLabelString() {
        EventLabel eventLabel = this.label;
        return eventLabel != EventLabel.UNKNOWN ? eventLabel.name() : this.labelString;
    }

    public String getLabelString() {
        return this.labelString;
    }

    @Override // com.urbandroid.sleep.domain.IEvent
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.urbandroid.sleep.domain.IEvent
    public float getValue() {
        return this.value;
    }

    public int hashCode() {
        return new Long(this.timestamp + ((long) this.label.ordinal())).hashCode();
    }

    public String toString() {
        return "E(" + this.label + ")@" + DateUtil.formatTimeShortSec(this.timestamp) + "=" + this.value;
    }

    public Event withLabel(EventLabel eventLabel) {
        return new Event(this.timestamp, eventLabel, this.value);
    }

    public Event withTimestamp(long j) {
        return new Event(j, this.label, this.value);
    }

    public Event() {
    }

    public Event(long j, EventLabel eventLabel, float f) {
        this.timestamp = j;
        this.label = eventLabel;
        this.labelString = null;
        this.value = f;
    }

    public Event(long j, EventLabel eventLabel, String str, float f) {
        this.timestamp = j;
        this.label = eventLabel;
        this.labelString = str;
        this.value = f;
    }
}
