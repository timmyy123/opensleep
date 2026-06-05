package com.google.api.services.calendar.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Event extends GenericJson {

    @Key
    private Boolean anyoneCanAddSelf;

    @Key
    private List<EventAttachment> attachments;

    @Key
    private List<EventAttendee> attendees;

    @Key
    private Boolean attendeesOmitted;

    @Key
    private String colorId;

    @Key
    private ConferenceData conferenceData;

    @Key
    private DateTime created;

    @Key
    private Creator creator;

    @Key
    private String description;

    @Key
    private EventDateTime end;

    @Key
    private Boolean endTimeUnspecified;

    @Key
    private String etag;

    @Key
    private ExtendedProperties extendedProperties;

    @Key
    private Gadget gadget;

    @Key
    private Boolean guestsCanInviteOthers;

    @Key
    private Boolean guestsCanModify;

    @Key
    private Boolean guestsCanSeeOtherGuests;

    @Key
    private String hangoutLink;

    @Key
    private String htmlLink;

    @Key
    private String iCalUID;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String location;

    @Key
    private Boolean locked;

    @Key
    private Organizer organizer;

    @Key
    private EventDateTime originalStartTime;

    @Key
    private Boolean privateCopy;

    @Key
    private List<String> recurrence;

    @Key
    private String recurringEventId;

    @Key
    private Reminders reminders;

    @Key
    private Integer sequence;

    @Key
    private Source source;

    @Key
    private EventDateTime start;

    @Key
    private String status;

    @Key
    private String summary;

    @Key
    private String transparency;

    @Key
    private DateTime updated;

    @Key
    private String visibility;

    public static final class Creator extends GenericJson {

        @Key
        private String displayName;

        @Key
        private String email;

        @Key
        private String id;

        @Key
        private Boolean self;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Creator clone() {
            return (Creator) super.clone();
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

        public Boolean getSelf() {
            return this.self;
        }

        public boolean isSelf() {
            Boolean bool = this.self;
            if (bool == null || bool == Data.NULL_BOOLEAN) {
                return false;
            }
            return bool.booleanValue();
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Creator set(String str, Object obj) {
            return (Creator) super.set(str, obj);
        }

        public Creator setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public Creator setEmail(String str) {
            this.email = str;
            return this;
        }

        public Creator setId(String str) {
            this.id = str;
            return this;
        }

        public Creator setSelf(Boolean bool) {
            this.self = bool;
            return this;
        }
    }

    public static final class ExtendedProperties extends GenericJson {

        @Key("private")
        private Map<String, String> private__;

        @Key
        private Map<String, String> shared;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public ExtendedProperties clone() {
            return (ExtendedProperties) super.clone();
        }

        public Map<String, String> getPrivate() {
            return this.private__;
        }

        public Map<String, String> getShared() {
            return this.shared;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public ExtendedProperties set(String str, Object obj) {
            return (ExtendedProperties) super.set(str, obj);
        }

        public ExtendedProperties setPrivate(Map<String, String> map) {
            this.private__ = map;
            return this;
        }

        public ExtendedProperties setShared(Map<String, String> map) {
            this.shared = map;
            return this;
        }
    }

    public static final class Gadget extends GenericJson {

        @Key
        private String display;

        @Key
        private Integer height;

        @Key
        private String iconLink;

        @Key
        private String link;

        @Key
        private Map<String, String> preferences;

        @Key
        private String title;

        @Key
        private String type;

        @Key
        private Integer width;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Gadget clone() {
            return (Gadget) super.clone();
        }

        public String getDisplay() {
            return this.display;
        }

        public Integer getHeight() {
            return this.height;
        }

        public String getIconLink() {
            return this.iconLink;
        }

        public String getLink() {
            return this.link;
        }

        public Map<String, String> getPreferences() {
            return this.preferences;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public Integer getWidth() {
            return this.width;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Gadget set(String str, Object obj) {
            return (Gadget) super.set(str, obj);
        }

        public Gadget setDisplay(String str) {
            this.display = str;
            return this;
        }

        public Gadget setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public Gadget setIconLink(String str) {
            this.iconLink = str;
            return this;
        }

        public Gadget setLink(String str) {
            this.link = str;
            return this;
        }

        public Gadget setPreferences(Map<String, String> map) {
            this.preferences = map;
            return this;
        }

        public Gadget setTitle(String str) {
            this.title = str;
            return this;
        }

        public Gadget setType(String str) {
            this.type = str;
            return this;
        }

        public Gadget setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static final class Organizer extends GenericJson {

        @Key
        private String displayName;

        @Key
        private String email;

        @Key
        private String id;

        @Key
        private Boolean self;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Organizer clone() {
            return (Organizer) super.clone();
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

        public Boolean getSelf() {
            return this.self;
        }

        public boolean isSelf() {
            Boolean bool = this.self;
            if (bool == null || bool == Data.NULL_BOOLEAN) {
                return false;
            }
            return bool.booleanValue();
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Organizer set(String str, Object obj) {
            return (Organizer) super.set(str, obj);
        }

        public Organizer setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public Organizer setEmail(String str) {
            this.email = str;
            return this;
        }

        public Organizer setId(String str) {
            this.id = str;
            return this;
        }

        public Organizer setSelf(Boolean bool) {
            this.self = bool;
            return this;
        }
    }

    public static final class Reminders extends GenericJson {

        @Key
        private List<EventReminder> overrides;

        @Key
        private Boolean useDefault;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Reminders clone() {
            return (Reminders) super.clone();
        }

        public List<EventReminder> getOverrides() {
            return this.overrides;
        }

        public Boolean getUseDefault() {
            return this.useDefault;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Reminders set(String str, Object obj) {
            return (Reminders) super.set(str, obj);
        }

        public Reminders setOverrides(List<EventReminder> list) {
            this.overrides = list;
            return this;
        }

        public Reminders setUseDefault(Boolean bool) {
            this.useDefault = bool;
            return this;
        }
    }

    public static final class Source extends GenericJson {

        @Key
        private String title;

        @Key
        private String url;

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Source clone() {
            return (Source) super.clone();
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Source set(String str, Object obj) {
            return (Source) super.set(str, obj);
        }

        public Source setTitle(String str) {
            this.title = str;
            return this;
        }

        public Source setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Event clone() {
        return (Event) super.clone();
    }

    public Boolean getAnyoneCanAddSelf() {
        return this.anyoneCanAddSelf;
    }

    public List<EventAttachment> getAttachments() {
        return this.attachments;
    }

    public List<EventAttendee> getAttendees() {
        return this.attendees;
    }

    public Boolean getAttendeesOmitted() {
        return this.attendeesOmitted;
    }

    public String getColorId() {
        return this.colorId;
    }

    public ConferenceData getConferenceData() {
        return this.conferenceData;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public Creator getCreator() {
        return this.creator;
    }

    public String getDescription() {
        return this.description;
    }

    public EventDateTime getEnd() {
        return this.end;
    }

    public Boolean getEndTimeUnspecified() {
        return this.endTimeUnspecified;
    }

    public String getEtag() {
        return this.etag;
    }

    public ExtendedProperties getExtendedProperties() {
        return this.extendedProperties;
    }

    public Gadget getGadget() {
        return this.gadget;
    }

    public Boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    public Boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    public Boolean getGuestsCanSeeOtherGuests() {
        return this.guestsCanSeeOtherGuests;
    }

    public String getHangoutLink() {
        return this.hangoutLink;
    }

    public String getHtmlLink() {
        return this.htmlLink;
    }

    public String getICalUID() {
        return this.iCalUID;
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

    public Boolean getLocked() {
        return this.locked;
    }

    public Organizer getOrganizer() {
        return this.organizer;
    }

    public EventDateTime getOriginalStartTime() {
        return this.originalStartTime;
    }

    public Boolean getPrivateCopy() {
        return this.privateCopy;
    }

    public List<String> getRecurrence() {
        return this.recurrence;
    }

    public String getRecurringEventId() {
        return this.recurringEventId;
    }

    public Reminders getReminders() {
        return this.reminders;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public Source getSource() {
        return this.source;
    }

    public EventDateTime getStart() {
        return this.start;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTransparency() {
        return this.transparency;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public boolean isAnyoneCanAddSelf() {
        Boolean bool = this.anyoneCanAddSelf;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isAttendeesOmitted() {
        Boolean bool = this.attendeesOmitted;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isEndTimeUnspecified() {
        Boolean bool = this.endTimeUnspecified;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isGuestsCanInviteOthers() {
        Boolean bool = this.guestsCanInviteOthers;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean isGuestsCanModify() {
        Boolean bool = this.guestsCanModify;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isGuestsCanSeeOtherGuests() {
        Boolean bool = this.guestsCanSeeOtherGuests;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean isLocked() {
        Boolean bool = this.locked;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPrivateCopy() {
        Boolean bool = this.privateCopy;
        if (bool == null || bool == Data.NULL_BOOLEAN) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Event set(String str, Object obj) {
        return (Event) super.set(str, obj);
    }

    public Event setAnyoneCanAddSelf(Boolean bool) {
        this.anyoneCanAddSelf = bool;
        return this;
    }

    public Event setAttachments(List<EventAttachment> list) {
        this.attachments = list;
        return this;
    }

    public Event setAttendees(List<EventAttendee> list) {
        this.attendees = list;
        return this;
    }

    public Event setAttendeesOmitted(Boolean bool) {
        this.attendeesOmitted = bool;
        return this;
    }

    public Event setColorId(String str) {
        this.colorId = str;
        return this;
    }

    public Event setConferenceData(ConferenceData conferenceData) {
        this.conferenceData = conferenceData;
        return this;
    }

    public Event setCreated(DateTime dateTime) {
        this.created = dateTime;
        return this;
    }

    public Event setCreator(Creator creator) {
        this.creator = creator;
        return this;
    }

    public Event setDescription(String str) {
        this.description = str;
        return this;
    }

    public Event setEnd(EventDateTime eventDateTime) {
        this.end = eventDateTime;
        return this;
    }

    public Event setEndTimeUnspecified(Boolean bool) {
        this.endTimeUnspecified = bool;
        return this;
    }

    public Event setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Event setExtendedProperties(ExtendedProperties extendedProperties) {
        this.extendedProperties = extendedProperties;
        return this;
    }

    public Event setGadget(Gadget gadget) {
        this.gadget = gadget;
        return this;
    }

    public Event setGuestsCanInviteOthers(Boolean bool) {
        this.guestsCanInviteOthers = bool;
        return this;
    }

    public Event setGuestsCanModify(Boolean bool) {
        this.guestsCanModify = bool;
        return this;
    }

    public Event setGuestsCanSeeOtherGuests(Boolean bool) {
        this.guestsCanSeeOtherGuests = bool;
        return this;
    }

    public Event setHangoutLink(String str) {
        this.hangoutLink = str;
        return this;
    }

    public Event setHtmlLink(String str) {
        this.htmlLink = str;
        return this;
    }

    public Event setICalUID(String str) {
        this.iCalUID = str;
        return this;
    }

    public Event setId(String str) {
        this.id = str;
        return this;
    }

    public Event setKind(String str) {
        this.kind = str;
        return this;
    }

    public Event setLocation(String str) {
        this.location = str;
        return this;
    }

    public Event setLocked(Boolean bool) {
        this.locked = bool;
        return this;
    }

    public Event setOrganizer(Organizer organizer) {
        this.organizer = organizer;
        return this;
    }

    public Event setOriginalStartTime(EventDateTime eventDateTime) {
        this.originalStartTime = eventDateTime;
        return this;
    }

    public Event setPrivateCopy(Boolean bool) {
        this.privateCopy = bool;
        return this;
    }

    public Event setRecurrence(List<String> list) {
        this.recurrence = list;
        return this;
    }

    public Event setRecurringEventId(String str) {
        this.recurringEventId = str;
        return this;
    }

    public Event setReminders(Reminders reminders) {
        this.reminders = reminders;
        return this;
    }

    public Event setSequence(Integer num) {
        this.sequence = num;
        return this;
    }

    public Event setSource(Source source) {
        this.source = source;
        return this;
    }

    public Event setStart(EventDateTime eventDateTime) {
        this.start = eventDateTime;
        return this;
    }

    public Event setStatus(String str) {
        this.status = str;
        return this;
    }

    public Event setSummary(String str) {
        this.summary = str;
        return this;
    }

    public Event setTransparency(String str) {
        this.transparency = str;
        return this;
    }

    public Event setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    public Event setVisibility(String str) {
        this.visibility = str;
        return this;
    }
}
