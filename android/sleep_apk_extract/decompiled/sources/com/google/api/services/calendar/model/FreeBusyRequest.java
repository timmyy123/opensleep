package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class FreeBusyRequest extends GenericJson {

    @Key
    private Integer calendarExpansionMax;

    @Key
    private Integer groupExpansionMax;

    @Key
    private List<FreeBusyRequestItem> items;

    @Key
    private DateTime timeMax;

    @Key
    private DateTime timeMin;

    @Key
    private String timeZone;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FreeBusyRequest clone() {
        return (FreeBusyRequest) super.clone();
    }

    public Integer getCalendarExpansionMax() {
        return this.calendarExpansionMax;
    }

    public Integer getGroupExpansionMax() {
        return this.groupExpansionMax;
    }

    public List<FreeBusyRequestItem> getItems() {
        return this.items;
    }

    public DateTime getTimeMax() {
        return this.timeMax;
    }

    public DateTime getTimeMin() {
        return this.timeMin;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FreeBusyRequest set(String str, Object obj) {
        return (FreeBusyRequest) super.set(str, obj);
    }

    public FreeBusyRequest setCalendarExpansionMax(Integer num) {
        this.calendarExpansionMax = num;
        return this;
    }

    public FreeBusyRequest setGroupExpansionMax(Integer num) {
        this.groupExpansionMax = num;
        return this;
    }

    public FreeBusyRequest setItems(List<FreeBusyRequestItem> list) {
        this.items = list;
        return this;
    }

    public FreeBusyRequest setTimeMax(DateTime dateTime) {
        this.timeMax = dateTime;
        return this;
    }

    public FreeBusyRequest setTimeMin(DateTime dateTime) {
        this.timeMin = dateTime;
        return this;
    }

    public FreeBusyRequest setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }
}
