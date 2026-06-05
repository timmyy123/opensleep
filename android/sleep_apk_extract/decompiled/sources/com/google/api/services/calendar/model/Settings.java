package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Settings extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Setting> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private String nextSyncToken;

    static {
        Data.nullOf(Setting.class);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Settings clone() {
        return (Settings) super.clone();
    }

    public String getEtag() {
        return this.etag;
    }

    public List<Setting> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public String getNextSyncToken() {
        return this.nextSyncToken;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Settings set(String str, Object obj) {
        return (Settings) super.set(str, obj);
    }

    public Settings setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Settings setItems(List<Setting> list) {
        this.items = list;
        return this;
    }

    public Settings setKind(String str) {
        this.kind = str;
        return this;
    }

    public Settings setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public Settings setNextSyncToken(String str) {
        this.nextSyncToken = str;
        return this;
    }
}
