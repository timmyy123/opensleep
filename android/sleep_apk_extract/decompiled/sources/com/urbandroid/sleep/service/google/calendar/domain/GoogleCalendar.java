package com.urbandroid.sleep.service.google.calendar.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u0019B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "", "", "id", "displayName", "accountName", "ownerName", "timezone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getDisplayName", "getAccountName", "getOwnerName", "getTimezone", "Companion", "Event", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class GoogleCalendar {
    private final String accountName;
    private final String displayName;
    private final String id;
    private final String ownerName;
    private final String timezone;

    public GoogleCalendar(String str, String str2, String str3, String str4, String str5) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.id = str;
        this.displayName = str2;
        this.accountName = str3;
        this.ownerName = str4;
        this.timezone = str5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleCalendar)) {
            return false;
        }
        GoogleCalendar googleCalendar = (GoogleCalendar) other;
        return Intrinsics.areEqual(this.id, googleCalendar.id) && Intrinsics.areEqual(this.displayName, googleCalendar.displayName) && Intrinsics.areEqual(this.accountName, googleCalendar.accountName) && Intrinsics.areEqual(this.ownerName, googleCalendar.ownerName) && Intrinsics.areEqual(this.timezone, googleCalendar.timezone);
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.displayName), 31, this.accountName), 31, this.ownerName);
        String str = this.timezone;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.id;
        String str2 = this.displayName;
        String str3 = this.accountName;
        String str4 = this.ownerName;
        String str5 = this.timezone;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("GoogleCalendar(id=", str, ", displayName=", str2, ", accountName=");
        FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str3, ", ownerName=", str4, ", timezone=");
        return FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str5, ")");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 42\u00020\u0001:\u000254B\u0081\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0090\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b%\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b)\u0010(R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b*\u0010\u001fR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b+\u0010\u001fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u000f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b/\u0010(R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00100\u001a\u0004\b\u0011\u00101R\u0017\u00102\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\u001f¨\u00066"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "", "", "eventId", "calendarId", "title", "location", "description", "", "start", "end", "startTimezone", "endTimezone", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "offsetInMinutes", "", "isAllDay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;JZ)V", "withOffset", "(J)Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;JZ)Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/String;", "getEventId", "getCalendarId", "getTitle", "getLocation", "getDescription", "J", "getStart", "()J", "getEnd", "getStartTimezone", "getEndTimezone", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;", "getStatus", "()Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;", "getOffsetInMinutes", "Z", "()Z", "compositeId", "getCompositeId", "Companion", "Status", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Event {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String tag = "google-calendar";
        private final String calendarId;
        private final String compositeId;
        private final String description;
        private final long end;
        private final String endTimezone;
        private final String eventId;
        private final boolean isAllDay;
        private final String location;
        private final long offsetInMinutes;
        private final long start;
        private final String startTimezone;
        private final Status status;
        private final String title;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "deserialize", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "event", "serialize", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion implements FeatureLogger {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Event deserialize(String event) {
                event.getClass();
                String[] strArrSplit = TextUtils.split(event, ",");
                if (strArrSplit == null || strArrSplit.length == 0 || !(strArrSplit.length == 3 || strArrSplit.length == 4)) {
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("Invalid GoogleCalendarEvent record: ", event);
                    Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, null);
                    return null;
                }
                try {
                    String str = strArrSplit[0];
                    String str2 = "";
                    String[] strArrSplit2 = TextUtils.split(str, "::");
                    if (strArrSplit2.length == 2) {
                        str = strArrSplit2[0];
                        str2 = strArrSplit2[1];
                        str2.getClass();
                    }
                    String str3 = str;
                    String str4 = str2;
                    long j = Long.parseLong(strArrSplit[1]);
                    long j2 = Long.parseLong(strArrSplit[2]);
                    long j3 = strArrSplit.length == 4 ? Long.parseLong(strArrSplit[3]) : 0L;
                    str3.getClass();
                    return new Event(str3, str4, null, null, null, j, j2, null, null, null, 0L, false, 3996, null).withOffset(j3);
                } catch (Exception unused) {
                    String strM2 = FileInsert$$ExternalSyntheticOutline0.m("Invalid CalendarEvent record in preferences: ", event);
                    Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM2, null);
                    return null;
                }
            }

            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                return Event.tag;
            }

            public final String serialize(Event event) {
                event.getClass();
                String compositeId = event.getCompositeId();
                long start = event.getStart();
                long end = event.getEnd();
                String strM = event.getOffsetInMinutes() != 0 ? zzba$$ExternalSyntheticOutline0.m(event.getOffsetInMinutes(), ",") : "";
                StringBuilder sb = new StringBuilder();
                sb.append(compositeId);
                sb.append(",");
                sb.append(start);
                sb.append(",");
                return FileInsert$$ExternalSyntheticOutline0.m(end, strM, sb);
            }

            private Companion() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRMED", "TENTATIVE", "CANCELLED", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Status {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Status[] $VALUES;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            public static final Status CONFIRMED = new Status("CONFIRMED", 0);
            public static final Status TENTATIVE = new Status("TENTATIVE", 1);
            public static final Status CANCELLED = new Status("CANCELLED", 2);

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status$Companion;", "", "<init>", "()V", "find", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Status find(String status) {
                    status.getClass();
                    for (Status status2 : Status.values()) {
                        String strName = status2.name();
                        Locale locale = Locale.ROOT;
                        String lowerCase = strName.toLowerCase(locale);
                        lowerCase.getClass();
                        String lowerCase2 = status.toLowerCase(locale);
                        lowerCase2.getClass();
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                            return status2;
                        }
                    }
                    return null;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ Status[] $values() {
                return new Status[]{CONFIRMED, TENTATIVE, CANCELLED};
            }

            static {
                Status[] statusArr$values = $values();
                $VALUES = statusArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
                INSTANCE = new Companion(null);
            }

            private Status(String str, int i) {
            }

            public static Status valueOf(String str) {
                return (Status) Enum.valueOf(Status.class, str);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Event(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, Status status, long j3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            String str9;
            boolean z2;
            String str10 = (i & 4) != 0 ? null : str3;
            String str11 = (i & 8) != 0 ? null : str4;
            String str12 = (i & 16) != 0 ? null : str5;
            if ((i & 128) != 0) {
                String id = TimeZone.getDefault().getID();
                id.getClass();
                str8 = id;
            } else {
                str8 = str6;
            }
            if ((i & 256) != 0) {
                String id2 = TimeZone.getDefault().getID();
                id2.getClass();
                str9 = id2;
            } else {
                str9 = str7;
            }
            Status status2 = (i & 512) != 0 ? null : status;
            long j4 = (i & 1024) != 0 ? 0L : j3;
            if ((i & 2048) != 0) {
                z2 = (j2 - j) / 3600000 == 24;
            } else {
                z2 = z;
            }
            this(str, str2, str10, str11, str12, j, j2, str8, str9, status2, j4, z2);
        }

        public static /* synthetic */ Event copy$default(Event event, String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, Status status, long j3, boolean z, int i, Object obj) {
            return event.copy((i & 1) != 0 ? event.eventId : str, (i & 2) != 0 ? event.calendarId : str2, (i & 4) != 0 ? event.title : str3, (i & 8) != 0 ? event.location : str4, (i & 16) != 0 ? event.description : str5, (i & 32) != 0 ? event.start : j, (i & 64) != 0 ? event.end : j2, (i & 128) != 0 ? event.startTimezone : str6, (i & 256) != 0 ? event.endTimezone : str7, (i & 512) != 0 ? event.status : status, (i & 1024) != 0 ? event.offsetInMinutes : j3, (i & 2048) != 0 ? event.isAllDay : z);
        }

        public final Event copy(String eventId, String calendarId, String title, String location, String description, long start, long end, String startTimezone, String endTimezone, Status status, long offsetInMinutes, boolean isAllDay) {
            eventId.getClass();
            calendarId.getClass();
            startTimezone.getClass();
            endTimezone.getClass();
            return new Event(eventId, calendarId, title, location, description, start, end, startTimezone, endTimezone, status, offsetInMinutes, isAllDay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics.areEqual(this.eventId, event.eventId) && (Intrinsics.areEqual(this.calendarId, "") || Intrinsics.areEqual(event.calendarId, "") || Intrinsics.areEqual(this.calendarId, event.calendarId));
        }

        public final String getCalendarId() {
            return this.calendarId;
        }

        public final String getCompositeId() {
            return this.compositeId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final long getEnd() {
            return this.end;
        }

        public final String getEndTimezone() {
            return this.endTimezone;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final long getOffsetInMinutes() {
            return this.offsetInMinutes;
        }

        public final long getStart() {
            return this.start;
        }

        public final String getStartTimezone() {
            return this.startTimezone;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return this.eventId.hashCode();
        }

        /* JADX INFO: renamed from: isAllDay, reason: from getter */
        public final boolean getIsAllDay() {
            return this.isAllDay;
        }

        public String toString() {
            String str = this.eventId;
            String str2 = this.calendarId;
            String str3 = this.title;
            String str4 = this.location;
            String str5 = this.description;
            long j = this.start;
            long j2 = this.end;
            String str6 = this.startTimezone;
            String str7 = this.endTimezone;
            Status status = this.status;
            long j3 = this.offsetInMinutes;
            boolean z = this.isAllDay;
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Event(eventId=", str, ", calendarId=", str2, ", title=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str3, ", location=", str4, ", description=");
            sbM6m.append(str5);
            sbM6m.append(", start=");
            sbM6m.append(j);
            zzba$$ExternalSyntheticOutline0.m(sbM6m, ", end=", j2, ", startTimezone=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str6, ", endTimezone=", str7, ", status=");
            sbM6m.append(status);
            sbM6m.append(", offsetInMinutes=");
            sbM6m.append(j3);
            sbM6m.append(", isAllDay=");
            sbM6m.append(z);
            sbM6m.append(")");
            return sbM6m.toString();
        }

        public final Event withOffset(long offsetInMinutes) {
            return copy$default(this, null, null, null, null, null, 0L, 0L, null, null, null, offsetInMinutes, false, 3071, null);
        }

        public Event(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, Status status, long j3, boolean z) {
            String strM;
            str.getClass();
            str2.getClass();
            str6.getClass();
            str7.getClass();
            this.eventId = str;
            this.calendarId = str2;
            this.title = str3;
            this.location = str4;
            this.description = str5;
            this.start = j;
            this.end = j2;
            this.startTimezone = str6;
            this.endTimezone = str7;
            this.status = status;
            this.offsetInMinutes = j3;
            this.isAllDay = z;
            if (str2.length() > 0) {
                strM = FileInsert$$ExternalSyntheticOutline0.m("::", str2);
            } else {
                strM = "";
            }
            this.compositeId = FileInsert$$ExternalSyntheticOutline0.m$1(str, strM);
        }
    }
}
