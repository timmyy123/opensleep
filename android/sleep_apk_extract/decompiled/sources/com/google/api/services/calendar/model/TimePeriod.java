package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class TimePeriod extends GenericJson {

    @Key
    private DateTime end;

    @Key
    private DateTime start;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TimePeriod clone() {
        return (TimePeriod) super.clone();
    }

    public DateTime getEnd() {
        return this.end;
    }

    public DateTime getStart() {
        return this.start;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TimePeriod set(String str, Object obj) {
        return (TimePeriod) super.set(str, obj);
    }

    public TimePeriod setEnd(DateTime dateTime) {
        this.end = dateTime;
        return this;
    }

    public TimePeriod setStart(DateTime dateTime) {
        this.start = dateTime;
        return this;
    }
}
