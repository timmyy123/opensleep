package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class Setting extends GenericJson {

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String value;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Setting clone() {
        return (Setting) super.clone();
    }

    public String getEtag() {
        return this.etag;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getValue() {
        return this.value;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Setting set(String str, Object obj) {
        return (Setting) super.set(str, obj);
    }

    public Setting setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Setting setId(String str) {
        this.id = str;
        return this;
    }

    public Setting setKind(String str) {
        this.kind = str;
        return this;
    }

    public Setting setValue(String str) {
        this.value = str;
        return this;
    }
}
