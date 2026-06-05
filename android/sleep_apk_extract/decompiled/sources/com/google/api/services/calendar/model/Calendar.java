package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class Calendar extends GenericJson {

    @Key
    private ConferenceProperties conferenceProperties;

    @Key
    private String description;

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String location;

    @Key
    private String summary;

    @Key
    private String timeZone;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Calendar clone() {
        return (Calendar) super.clone();
    }

    public ConferenceProperties getConferenceProperties() {
        return this.conferenceProperties;
    }

    public String getDescription() {
        return this.description;
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

    public String getLocation() {
        return this.location;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Calendar set(String str, Object obj) {
        return (Calendar) super.set(str, obj);
    }

    public Calendar setConferenceProperties(ConferenceProperties conferenceProperties) {
        this.conferenceProperties = conferenceProperties;
        return this;
    }

    public Calendar setDescription(String str) {
        this.description = str;
        return this;
    }

    public Calendar setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Calendar setId(String str) {
        this.id = str;
        return this;
    }

    public Calendar setKind(String str) {
        this.kind = str;
        return this;
    }

    public Calendar setLocation(String str) {
        this.location = str;
        return this;
    }

    public Calendar setSummary(String str) {
        this.summary = str;
        return this;
    }

    public Calendar setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }
}
