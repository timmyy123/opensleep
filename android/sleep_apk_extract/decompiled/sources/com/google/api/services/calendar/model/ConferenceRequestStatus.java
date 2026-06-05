package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class ConferenceRequestStatus extends GenericJson {

    @Key
    private String statusCode;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ConferenceRequestStatus clone() {
        return (ConferenceRequestStatus) super.clone();
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ConferenceRequestStatus set(String str, Object obj) {
        return (ConferenceRequestStatus) super.set(str, obj);
    }

    public ConferenceRequestStatus setStatusCode(String str) {
        this.statusCode = str;
        return this;
    }
}
