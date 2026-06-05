package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarNotification extends GenericJson {

    @Key
    private String method;

    @Key
    private String type;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CalendarNotification clone() {
        return (CalendarNotification) super.clone();
    }

    public String getMethod() {
        return this.method;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CalendarNotification set(String str, Object obj) {
        return (CalendarNotification) super.set(str, obj);
    }

    public CalendarNotification setMethod(String str) {
        this.method = str;
        return this;
    }

    public CalendarNotification setType(String str) {
        this.type = str;
        return this;
    }
}
