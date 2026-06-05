package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class ConferenceSolutionKey extends GenericJson {

    @Key
    private String type;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ConferenceSolutionKey clone() {
        return (ConferenceSolutionKey) super.clone();
    }

    public String getType() {
        return this.type;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ConferenceSolutionKey set(String str, Object obj) {
        return (ConferenceSolutionKey) super.set(str, obj);
    }

    public ConferenceSolutionKey setType(String str) {
        this.type = str;
        return this;
    }
}
