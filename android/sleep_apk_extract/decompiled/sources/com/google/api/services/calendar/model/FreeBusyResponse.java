package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class FreeBusyResponse extends GenericJson {

    @Key
    private Map<String, FreeBusyCalendar> calendars;

    @Key
    private Map<String, FreeBusyGroup> groups;

    @Key
    private String kind;

    @Key
    private DateTime timeMax;

    @Key
    private DateTime timeMin;

    static {
        Data.nullOf(FreeBusyCalendar.class);
        Data.nullOf(FreeBusyGroup.class);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FreeBusyResponse clone() {
        return (FreeBusyResponse) super.clone();
    }

    public Map<String, FreeBusyCalendar> getCalendars() {
        return this.calendars;
    }

    public Map<String, FreeBusyGroup> getGroups() {
        return this.groups;
    }

    public String getKind() {
        return this.kind;
    }

    public DateTime getTimeMax() {
        return this.timeMax;
    }

    public DateTime getTimeMin() {
        return this.timeMin;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FreeBusyResponse set(String str, Object obj) {
        return (FreeBusyResponse) super.set(str, obj);
    }

    public FreeBusyResponse setCalendars(Map<String, FreeBusyCalendar> map) {
        this.calendars = map;
        return this;
    }

    public FreeBusyResponse setGroups(Map<String, FreeBusyGroup> map) {
        this.groups = map;
        return this;
    }

    public FreeBusyResponse setKind(String str) {
        this.kind = str;
        return this;
    }

    public FreeBusyResponse setTimeMax(DateTime dateTime) {
        this.timeMax = dateTime;
        return this;
    }

    public FreeBusyResponse setTimeMin(DateTime dateTime) {
        this.timeMin = dateTime;
        return this;
    }
}
