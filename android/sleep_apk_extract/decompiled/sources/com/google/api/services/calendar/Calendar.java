package com.google.api.services.calendar;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.calendar.model.Event;

/* JADX INFO: loaded from: classes4.dex */
public class Calendar extends AbstractGoogleJsonClient {

    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://www.googleapis.com/", "calendar/v3/", httpRequestInitializer, false);
            setBatchPath("batch/calendar/v3");
        }

        public Calendar build() {
            return new Calendar(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        public Builder setCalendarRequestInitializer(CalendarRequestInitializer calendarRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) calendarRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }
    }

    public class CalendarList {

        public class List extends CalendarRequest<com.google.api.services.calendar.model.CalendarList> {

            @Key
            private Integer maxResults;

            @Key
            private String minAccessRole;

            @Key
            private String pageToken;

            @Key
            private Boolean showDeleted;

            @Key
            private Boolean showHidden;

            @Key
            private String syncToken;

            public List() {
                super(Calendar.this, "GET", "users/me/calendarList", null, com.google.api.services.calendar.model.CalendarList.class);
            }

            @Override // com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setKey, reason: merged with bridge method [inline-methods] */
            public CalendarRequest<com.google.api.services.calendar.model.CalendarList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setOauthToken, reason: merged with bridge method [inline-methods] */
            public CalendarRequest<com.google.api.services.calendar.model.CalendarList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }
        }

        public CalendarList() {
        }

        public List list() {
            List list = new List();
            Calendar.this.initialize(list);
            return list;
        }
    }

    public class Calendars {

        public class Insert extends CalendarRequest<com.google.api.services.calendar.model.Calendar> {
            public Insert(com.google.api.services.calendar.model.Calendar calendar) {
                super(Calendar.this, "POST", "calendars", calendar, com.google.api.services.calendar.model.Calendar.class);
                checkRequiredParameter(calendar, "content");
                checkRequiredParameter(calendar.getSummary(), "Calendar.getSummary()");
            }

            @Override // com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setKey */
            public CalendarRequest<com.google.api.services.calendar.model.Calendar> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setOauthToken */
            public CalendarRequest<com.google.api.services.calendar.model.Calendar> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }
        }

        public Calendars() {
        }

        public Insert insert(com.google.api.services.calendar.model.Calendar calendar) {
            Insert insert = new Insert(calendar);
            Calendar.this.initialize(insert);
            return insert;
        }
    }

    public class Events {

        public class Delete extends CalendarRequest<Void> {

            @Key
            private String calendarId;

            @Key
            private String eventId;

            @Key
            private Boolean sendNotifications;

            @Key
            private String sendUpdates;

            public Delete(String str, String str2) {
                super(Calendar.this, "DELETE", "calendars/{calendarId}/events/{eventId}", null, Void.class);
                this.calendarId = (String) Preconditions.checkNotNull(str, "Required parameter calendarId must be specified.");
                this.eventId = (String) Preconditions.checkNotNull(str2, "Required parameter eventId must be specified.");
            }

            @Override // com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setKey */
            public CalendarRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setOauthToken */
            public CalendarRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }
        }

        public class Insert extends CalendarRequest<Event> {

            @Key
            private String calendarId;

            @Key
            private Integer conferenceDataVersion;

            @Key
            private Integer maxAttendees;

            @Key
            private Boolean sendNotifications;

            @Key
            private String sendUpdates;

            @Key
            private Boolean supportsAttachments;

            public Insert(String str, Event event) {
                super(Calendar.this, "POST", "calendars/{calendarId}/events", event, Event.class);
                this.calendarId = (String) Preconditions.checkNotNull(str, "Required parameter calendarId must be specified.");
            }

            @Override // com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setKey */
            public CalendarRequest<Event> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setOauthToken */
            public CalendarRequest<Event> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }
        }

        public class List extends CalendarRequest<com.google.api.services.calendar.model.Events> {

            @Key
            private Boolean alwaysIncludeEmail;

            @Key
            private String calendarId;

            @Key
            private String iCalUID;

            @Key
            private Integer maxAttendees;

            @Key
            private Integer maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private java.util.List<String> privateExtendedProperty;

            @Key
            private String q;

            @Key
            private java.util.List<String> sharedExtendedProperty;

            @Key
            private Boolean showDeleted;

            @Key
            private Boolean showHiddenInvitations;

            @Key
            private Boolean singleEvents;

            @Key
            private String syncToken;

            @Key
            private DateTime timeMax;

            @Key
            private DateTime timeMin;

            @Key
            private String timeZone;

            @Key
            private DateTime updatedMin;

            public List(String str) {
                super(Calendar.this, "GET", "calendars/{calendarId}/events", null, com.google.api.services.calendar.model.Events.class);
                this.calendarId = (String) Preconditions.checkNotNull(str, "Required parameter calendarId must be specified.");
            }

            @Override // com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setKey */
            public CalendarRequest<com.google.api.services.calendar.model.Events> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.calendar.CalendarRequest
            /* JADX INFO: renamed from: setOauthToken */
            public CalendarRequest<com.google.api.services.calendar.model.Events> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }
        }

        public Events() {
        }

        public Delete delete(String str, String str2) {
            Delete delete = new Delete(str, str2);
            Calendar.this.initialize(delete);
            return delete;
        }

        public Insert insert(String str, Event event) {
            Insert insert = new Insert(str, event);
            Calendar.this.initialize(insert);
            return insert;
        }

        public List list(String str) {
            List list = new List(str);
            Calendar.this.initialize(list);
            return list;
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the Calendar API library.", GoogleUtils.VERSION);
    }

    public Calendar(Builder builder) {
        super(builder);
    }

    public CalendarList calendarList() {
        return new CalendarList();
    }

    public Calendars calendars() {
        return new Calendars();
    }

    public Events events() {
        return new Events();
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        super.initialize(abstractGoogleClientRequest);
    }
}
