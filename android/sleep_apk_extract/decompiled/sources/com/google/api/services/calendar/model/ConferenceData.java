package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ConferenceData extends GenericJson {

    @Key
    private String conferenceId;

    @Key
    private ConferenceSolution conferenceSolution;

    @Key
    private CreateConferenceRequest createRequest;

    @Key
    private List<EntryPoint> entryPoints;

    @Key
    private String notes;

    @Key
    private ConferenceParameters parameters;

    @Key
    private String signature;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ConferenceData clone() {
        return (ConferenceData) super.clone();
    }

    public String getConferenceId() {
        return this.conferenceId;
    }

    public ConferenceSolution getConferenceSolution() {
        return this.conferenceSolution;
    }

    public CreateConferenceRequest getCreateRequest() {
        return this.createRequest;
    }

    public List<EntryPoint> getEntryPoints() {
        return this.entryPoints;
    }

    public String getNotes() {
        return this.notes;
    }

    public ConferenceParameters getParameters() {
        return this.parameters;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ConferenceData set(String str, Object obj) {
        return (ConferenceData) super.set(str, obj);
    }

    public ConferenceData setConferenceId(String str) {
        this.conferenceId = str;
        return this;
    }

    public ConferenceData setConferenceSolution(ConferenceSolution conferenceSolution) {
        this.conferenceSolution = conferenceSolution;
        return this;
    }

    public ConferenceData setCreateRequest(CreateConferenceRequest createConferenceRequest) {
        this.createRequest = createConferenceRequest;
        return this;
    }

    public ConferenceData setEntryPoints(List<EntryPoint> list) {
        this.entryPoints = list;
        return this;
    }

    public ConferenceData setNotes(String str) {
        this.notes = str;
        return this;
    }

    public ConferenceData setParameters(ConferenceParameters conferenceParameters) {
        this.parameters = conferenceParameters;
        return this;
    }

    public ConferenceData setSignature(String str) {
        this.signature = str;
        return this;
    }
}
