package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateConferenceRequest extends GenericJson {

    @Key
    private ConferenceSolutionKey conferenceSolutionKey;

    @Key
    private String requestId;

    @Key
    private ConferenceRequestStatus status;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CreateConferenceRequest clone() {
        return (CreateConferenceRequest) super.clone();
    }

    public ConferenceSolutionKey getConferenceSolutionKey() {
        return this.conferenceSolutionKey;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ConferenceRequestStatus getStatus() {
        return this.status;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CreateConferenceRequest set(String str, Object obj) {
        return (CreateConferenceRequest) super.set(str, obj);
    }

    public CreateConferenceRequest setConferenceSolutionKey(ConferenceSolutionKey conferenceSolutionKey) {
        this.conferenceSolutionKey = conferenceSolutionKey;
        return this;
    }

    public CreateConferenceRequest setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public CreateConferenceRequest setStatus(ConferenceRequestStatus conferenceRequestStatus) {
        this.status = conferenceRequestStatus;
        return this;
    }
}
