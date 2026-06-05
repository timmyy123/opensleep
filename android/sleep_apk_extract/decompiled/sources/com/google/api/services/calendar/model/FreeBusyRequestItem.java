package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class FreeBusyRequestItem extends GenericJson {

    @Key
    private String id;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FreeBusyRequestItem clone() {
        return (FreeBusyRequestItem) super.clone();
    }

    public String getId() {
        return this.id;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FreeBusyRequestItem set(String str, Object obj) {
        return (FreeBusyRequestItem) super.set(str, obj);
    }

    public FreeBusyRequestItem setId(String str) {
        this.id = str;
        return this;
    }
}
