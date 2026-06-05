package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Colors extends GenericJson {

    @Key
    private Map<String, ColorDefinition> calendar;

    @Key
    private Map<String, ColorDefinition> event;

    @Key
    private String kind;

    @Key
    private DateTime updated;

    static {
        Data.nullOf(ColorDefinition.class);
        Data.nullOf(ColorDefinition.class);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Colors clone() {
        return (Colors) super.clone();
    }

    public Map<String, ColorDefinition> getCalendar() {
        return this.calendar;
    }

    public Map<String, ColorDefinition> getEvent() {
        return this.event;
    }

    public String getKind() {
        return this.kind;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Colors set(String str, Object obj) {
        return (Colors) super.set(str, obj);
    }

    public Colors setCalendar(Map<String, ColorDefinition> map) {
        this.calendar = map;
        return this;
    }

    public Colors setEvent(Map<String, ColorDefinition> map) {
        this.event = map;
        return this;
    }

    public Colors setKind(String str) {
        this.kind = str;
        return this;
    }

    public Colors setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }
}
