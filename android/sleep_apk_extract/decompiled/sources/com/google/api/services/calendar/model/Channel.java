package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Channel extends GenericJson {

    @Key
    private String address;

    @JsonString
    @Key
    private Long expiration;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private Map<String, String> params;

    @Key
    private Boolean payload;

    @Key
    private String resourceId;

    @Key
    private String resourceUri;

    @Key
    private String token;

    @Key
    private String type;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Channel clone() {
        return (Channel) super.clone();
    }

    public String getAddress() {
        return this.address;
    }

    public Long getExpiration() {
        return this.expiration;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public Boolean getPayload() {
        return this.payload;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceUri() {
        return this.resourceUri;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Channel set(String str, Object obj) {
        return (Channel) super.set(str, obj);
    }

    public Channel setAddress(String str) {
        this.address = str;
        return this;
    }

    public Channel setExpiration(Long l) {
        this.expiration = l;
        return this;
    }

    public Channel setId(String str) {
        this.id = str;
        return this;
    }

    public Channel setKind(String str) {
        this.kind = str;
        return this;
    }

    public Channel setParams(Map<String, String> map) {
        this.params = map;
        return this;
    }

    public Channel setPayload(Boolean bool) {
        this.payload = bool;
        return this;
    }

    public Channel setResourceId(String str) {
        this.resourceId = str;
        return this;
    }

    public Channel setResourceUri(String str) {
        this.resourceUri = str;
        return this;
    }

    public Channel setToken(String str) {
        this.token = str;
        return this;
    }

    public Channel setType(String str) {
        this.type = str;
        return this;
    }
}
