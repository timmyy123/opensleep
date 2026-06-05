package com.urbandroid.sleep.service.google.calendar.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.service.google.calendar.CalendarKt;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00102\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u0019\u0010\u0015\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\r0\u0019¢\u0006\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001f\u001a\u00020\u001c*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010\"\u001a\u00020\u0005*\u00020\r8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/google/api/services/calendar/model/EventDateTime;", "", "toUtc", "(Lcom/google/api/services/calendar/model/EventDateTime;)J", "Lcom/google/api/services/calendar/model/Event;", "", "calendarId", "defaultTimezone", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "toEvent", "(Lcom/google/api/services/calendar/model/Event;Ljava/lang/String;Ljava/lang/String;)Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Lcom/google/api/services/calendar/model/CalendarListEntry;", "accountName", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "toGoogleCalendar", "(Lcom/google/api/services/calendar/model/CalendarListEntry;Ljava/lang/String;)Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lcom/google/api/services/calendar/model/Calendar;", "(Lcom/google/api/services/calendar/model/Calendar;Ljava/lang/String;)Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "isSleepEvent", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;Landroid/content/Context;)Z", "pretty", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Ljava/lang/String;", "", "anonymousIds", "(Ljava/util/List;)Ljava/lang/String;", "", "getRating", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)I", "rating", "getAnonymousId", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;)Ljava/lang/String;", "anonymousId", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleCalendarKt {
    public static final String anonymousIds(List<GoogleCalendar> list) {
        list.getClass();
        return CollectionsKt.joinToString$default(list, ",", "[", "]", new AiPrompt$$ExternalSyntheticLambda0(28), 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence anonymousIds$lambda$0(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        return getAnonymousId(googleCalendar);
    }

    public static final String getAnonymousId(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m$1(ContextExtKt.cut(googleCalendar.getId(), 6), "...");
    }

    public static final int getRating(GoogleCalendar.Event event) {
        event.getClass();
        String description = event.getDescription();
        if (description == null) {
            return 0;
        }
        if (StringsKt.startsWith$default(description, "★☆☆☆☆")) {
            return 1;
        }
        if (StringsKt.startsWith$default(description, "★★☆☆☆")) {
            return 2;
        }
        if (StringsKt.startsWith$default(description, "★★★☆☆")) {
            return 3;
        }
        if (StringsKt.startsWith$default(description, "★★★★☆")) {
            return 4;
        }
        return StringsKt.startsWith$default(description, "★★★★★") ? 5 : 0;
    }

    public static final boolean isSleepEvent(GoogleCalendar.Event event, Context context) {
        event.getClass();
        context.getClass();
        String title = event.getTitle();
        if (title == null || !Intrinsics.areEqual(title, context.getString(R.string.sleep))) {
            title = null;
        }
        final boolean z = false;
        boolean z2 = title != null;
        if (!z2) {
            final String str = "calendar";
            FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt$isSleepEvent$lambda$1$$inlined$featureLog$default$1
                @Override // com.urbandroid.common.FeatureLogger
                public String getTag() {
                    String str2 = str;
                    boolean z3 = z;
                    StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                    String strConcat = "";
                    if (z3) {
                        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                        if (strM == null) {
                            strConcat = null;
                        } else if (!StringsKt.isBlank(strM)) {
                            strConcat = ":".concat(strM);
                        }
                    }
                    sbM.append(strConcat);
                    return sbM.toString();
                }
            };
            String strM = FileInsert$$ExternalSyntheticOutline0.m("event ", CalendarKt.prettyDate(event.getStart(), event.getStartTimezone()), " [", event.getTitle(), "] is not sleep event");
            Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
        }
        return z2;
    }

    public static final String pretty(GoogleCalendar.Event event) {
        event.getClass();
        String strPrettyDate = CalendarKt.prettyDate(event.getStart(), event.getStartTimezone());
        String strPrettyDate2 = CalendarKt.prettyDate(event.getEnd(), event.getEndTimezone());
        String strCut = ContextExtKt.cut(event.getTitle(), 3);
        String strCut2 = ContextExtKt.cut(event.getDescription(), 3);
        boolean isAllDay = event.getIsAllDay();
        String strCut3 = ContextExtKt.cut(event.getEventId(), 8);
        GoogleCalendar.Event.Status status = event.getStatus();
        long start = event.getStart();
        long end = event.getEnd();
        String startTimezone = event.getStartTimezone();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Event ", strPrettyDate, MqttTopic.TOPIC_LEVEL_SEPARATOR, strPrettyDate2, " title: ");
        FileInsert$$ExternalSyntheticOutline0.m(sbM6m, strCut, " desc: ", strCut2, " allDay: ");
        sbM6m.append(isAllDay);
        sbM6m.append(" ");
        sbM6m.append(strCut3);
        sbM6m.append(" ");
        sbM6m.append(status);
        sbM6m.append(" ");
        sbM6m.append(start);
        zzba$$ExternalSyntheticOutline0.m(sbM6m, MqttTopic.TOPIC_LEVEL_SEPARATOR, end, " ");
        sbM6m.append(startTimezone);
        return sbM6m.toString();
    }

    public static final GoogleCalendar.Event toEvent(Event event, String str, String str2) {
        event.getClass();
        str.getClass();
        str2.getClass();
        String id = event.getId();
        id.getClass();
        String summary = event.getSummary();
        String location = event.getLocation();
        String description = event.getDescription();
        long utc = toUtc(event.getStart());
        long utc2 = toUtc(event.getEnd());
        String timeZone = event.getStart().getTimeZone();
        String str3 = timeZone == null ? str2 : timeZone;
        String timeZone2 = event.getEnd().getTimeZone();
        String str4 = timeZone2 == null ? str2 : timeZone2;
        GoogleCalendar.Event.Status.Companion companion = GoogleCalendar.Event.Status.INSTANCE;
        String status = event.getStatus();
        status.getClass();
        return new GoogleCalendar.Event(id, str, summary, location, description, utc, utc2, str3, str4, companion.find(status), 0L, false, 3072, null);
    }

    public static final GoogleCalendar toGoogleCalendar(CalendarListEntry calendarListEntry, String str) {
        calendarListEntry.getClass();
        str.getClass();
        String strDecode = URLDecoder.decode(calendarListEntry.getId());
        strDecode.getClass();
        String summary = calendarListEntry.getSummary();
        summary.getClass();
        return new GoogleCalendar(strDecode, summary, str, str, calendarListEntry.getTimeZone());
    }

    private static final long toUtc(EventDateTime eventDateTime) {
        if (eventDateTime == null) {
            return -1L;
        }
        DateTime dateTime = eventDateTime.getDateTime();
        return dateTime != null ? dateTime.getValue() : eventDateTime.getDate().getValue();
    }

    public static final GoogleCalendar toGoogleCalendar(Calendar calendar, String str) {
        calendar.getClass();
        str.getClass();
        String strDecode = URLDecoder.decode(calendar.getId());
        strDecode.getClass();
        String summary = calendar.getSummary();
        summary.getClass();
        return new GoogleCalendar(strDecode, summary, str, str, calendar.getTimeZone());
    }
}
