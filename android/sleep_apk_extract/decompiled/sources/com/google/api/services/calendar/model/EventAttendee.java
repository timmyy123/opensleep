package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class EventAttendee extends GenericJson {

    @Key
    private Integer additionalGuests;

    @Key
    private String comment;

    @Key
    private String displayName;

    @Key
    private String email;

    @Key
    private String id;

    @Key
    private Boolean optional;

    @Key
    private Boolean organizer;

    @Key
    private Boolean resource;

    @Key
    private String responseStatus;

    @Key
    private Boolean self;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public EventAttendee clone() {
        return (EventAttendee) super.clone();
    }

    public Integer getAdditionalGuests() {
        return this.additionalGuests;
    }

    public String getComment() {
        return this.comment;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getOptional() {
        return this.optional;
    }

    public Boolean getOrganizer() {
        return this.organizer;
    }

    public Boolean getResource() {
        return this.resource;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }

    public Boolean getSelf() {
        return this.self;
    }

    public boolean isOptional() {
        Boolean bool = this.optional;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isResource() {
        Boolean bool = this.resource;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isSelf() {
        Boolean bool = this.self;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public EventAttendee set(String str, Object obj) {
        return (EventAttendee) super.set(str, obj);
    }

    public EventAttendee setAdditionalGuests(Integer num) {
        this.additionalGuests = num;
        return this;
    }

    public EventAttendee setComment(String str) {
        this.comment = str;
        return this;
    }

    public EventAttendee setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public EventAttendee setEmail(String str) {
        this.email = str;
        return this;
    }

    public EventAttendee setId(String str) {
        this.id = str;
        return this;
    }

    public EventAttendee setOptional(Boolean bool) {
        this.optional = bool;
        return this;
    }

    public EventAttendee setOrganizer(Boolean bool) {
        this.organizer = bool;
        return this;
    }

    public EventAttendee setResource(Boolean bool) {
        this.resource = bool;
        return this;
    }

    public EventAttendee setResponseStatus(String str) {
        this.responseStatus = str;
        return this;
    }

    public EventAttendee setSelf(Boolean bool) {
        this.self = bool;
        return this;
    }
}
