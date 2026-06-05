package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
public final class EventAttachment extends GenericJson {

    @Key
    private String fileId;

    @Key
    private String fileUrl;

    @Key
    private String iconLink;

    @Key
    private String mimeType;

    @Key
    private String title;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public EventAttachment clone() {
        return (EventAttachment) super.clone();
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getIconLink() {
        return this.iconLink;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public EventAttachment set(String str, Object obj) {
        return (EventAttachment) super.set(str, obj);
    }

    public EventAttachment setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public EventAttachment setFileUrl(String str) {
        this.fileUrl = str;
        return this;
    }

    public EventAttachment setIconLink(String str) {
        this.iconLink = str;
        return this;
    }

    public EventAttachment setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public EventAttachment setTitle(String str) {
        this.title = str;
        return this;
    }
}
