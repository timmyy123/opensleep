package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Acl extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<AclRule> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private String nextSyncToken;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Acl clone() {
        return (Acl) super.clone();
    }

    public String getEtag() {
        return this.etag;
    }

    public List<AclRule> getItems() {
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
    public Acl set(String str, Object obj) {
        return (Acl) super.set(str, obj);
    }

    public Acl setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Acl setItems(List<AclRule> list) {
        this.items = list;
        return this;
    }

    public Acl setKind(String str) {
        this.kind = str;
        return this;
    }

    public Acl setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public Acl setNextSyncToken(String str) {
        this.nextSyncToken = str;
        return this;
    }
}
