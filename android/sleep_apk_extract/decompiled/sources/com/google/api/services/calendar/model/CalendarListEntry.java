package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarListEntry extends GenericJson {

    @Key
    private String accessRole;

    @Key
    private String backgroundColor;

    @Key
    private String colorId;

    @Key
    private ConferenceProperties conferenceProperties;

    @Key
    private List<EventReminder> defaultReminders;

    @Key
    private Boolean deleted;

    @Key
    private String description;

    @Key
    private String etag;

    @Key
    private String foregroundColor;

    @Key
    private Boolean hidden;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String location;

    @Key
    private NotificationSettings notificationSettings;

    @Key
    private Boolean primary;

    @Key
    private Boolean selected;

    @Key
    private String summary;

    @Key
    private String summaryOverride;

    @Key
    private String timeZone;

    public static final class NotificationSettings extends GenericJson {

        @Key
        private List<CalendarNotification> notifications;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public NotificationSettings clone() {
            return (NotificationSettings) super.clone();
        }

        public List<CalendarNotification> getNotifications() {
            return this.notifications;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public NotificationSettings set(String str, Object obj) {
            return (NotificationSettings) super.set(str, obj);
        }

        public NotificationSettings setNotifications(List<CalendarNotification> list) {
            this.notifications = list;
            return this;
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CalendarListEntry clone() {
        return (CalendarListEntry) super.clone();
    }

    public String getAccessRole() {
        return this.accessRole;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getColorId() {
        return this.colorId;
    }

    public ConferenceProperties getConferenceProperties() {
        return this.conferenceProperties;
    }

    public List<EventReminder> getDefaultReminders() {
        return this.defaultReminders;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getForegroundColor() {
        return this.foregroundColor;
    }

    public Boolean getHidden() {
        return this.hidden;
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

    public NotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public Boolean getPrimary() {
        return this.primary;
    }

    public Boolean getSelected() {
        return this.selected;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getSummaryOverride() {
        return this.summaryOverride;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public boolean isDeleted() {
        Boolean bool = this.deleted;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isHidden() {
        Boolean bool = this.hidden;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPrimary() {
        Boolean bool = this.primary;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isSelected() {
        Boolean bool = this.selected;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CalendarListEntry set(String str, Object obj) {
        return (CalendarListEntry) super.set(str, obj);
    }

    public CalendarListEntry setAccessRole(String str) {
        this.accessRole = str;
        return this;
    }

    public CalendarListEntry setBackgroundColor(String str) {
        this.backgroundColor = str;
        return this;
    }

    public CalendarListEntry setColorId(String str) {
        this.colorId = str;
        return this;
    }

    public CalendarListEntry setConferenceProperties(ConferenceProperties conferenceProperties) {
        this.conferenceProperties = conferenceProperties;
        return this;
    }

    public CalendarListEntry setDefaultReminders(List<EventReminder> list) {
        this.defaultReminders = list;
        return this;
    }

    public CalendarListEntry setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public CalendarListEntry setDescription(String str) {
        this.description = str;
        return this;
    }

    public CalendarListEntry setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CalendarListEntry setForegroundColor(String str) {
        this.foregroundColor = str;
        return this;
    }

    public CalendarListEntry setHidden(Boolean bool) {
        this.hidden = bool;
        return this;
    }

    public CalendarListEntry setId(String str) {
        this.id = str;
        return this;
    }

    public CalendarListEntry setKind(String str) {
        this.kind = str;
        return this;
    }

    public CalendarListEntry setLocation(String str) {
        this.location = str;
        return this;
    }

    public CalendarListEntry setNotificationSettings(NotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
        return this;
    }

    public CalendarListEntry setPrimary(Boolean bool) {
        this.primary = bool;
        return this;
    }

    public CalendarListEntry setSelected(Boolean bool) {
        this.selected = bool;
        return this;
    }

    public CalendarListEntry setSummary(String str) {
        this.summary = str;
        return this;
    }

    public CalendarListEntry setSummaryOverride(String str) {
        this.summaryOverride = str;
        return this;
    }

    public CalendarListEntry setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }
}
