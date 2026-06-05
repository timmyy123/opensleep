package com.urbandroid.sleep.service.google.calendar.alarm;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifier;
import com.urbandroid.sleep.service.google.calendar.alarm.ProcessedCalendarEventMap;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001MB+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0003¢\u0006\u0004\b \u0010!J\u001f\u0010 \u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b \u0010\"J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0010H\u0087@¢\u0006\u0004\b$\u0010%J/\u0010(\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0010H\u0087@¢\u0006\u0004\b*\u0010%J-\u00100\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101J/\u00104\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u0016H\u0007¢\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u00108R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00109R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010:R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010;R\u001a\u0010\u0015\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\b<\u0010=R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u0011\u0010L\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/service/google/calendar/alarm/WorkingDaysPolicy;", "workingDaysPolicy", "", "accountName", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "calendarProvider", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/google/calendar/alarm/WorkingDaysPolicy;Ljava/lang/String;Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;)V", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "event", "formatEvent", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Ljava/lang/String;", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "", "calculateOffset", "(Lcom/urbandroid/sleep/alarmclock/Alarm;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)J", "tag", "", "hasCustomTag", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;Ljava/lang/String;)Z", "Ljava/util/Calendar;", "cal", "", "resetToMidnight", "(Ljava/util/Calendar;)V", "cal1", "cal2", "areSameDate", "(Ljava/util/Calendar;Ljava/util/Calendar;)Z", "(Ljava/util/Calendar;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Z", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result;", "advanceAlarmIfEvent", "(Lcom/urbandroid/sleep/alarmclock/Alarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "offsetMin", "advanceAlarmAndNotify", "(Landroid/content/Context;Lcom/urbandroid/sleep/alarmclock/Alarm;ILcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)V", "skipNextIfHoliday", "Lcom/urbandroid/sleep/service/google/calendar/alarm/ProcessedCalendarEventMap$Type;", "type", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "calendar", "Lcom/urbandroid/sleep/service/google/calendar/alarm/ProcessedCalendarEventMap;", "prepareProcessedEventMap", "(Landroid/content/Context;Ljava/lang/String;Lcom/urbandroid/sleep/service/google/calendar/alarm/ProcessedCalendarEventMap$Type;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;)Lcom/urbandroid/sleep/service/google/calendar/alarm/ProcessedCalendarEventMap;", "holidayEvent", "forceSkip", "notifyHoliday", "(Landroid/content/Context;Lcom/urbandroid/sleep/alarmclock/Alarm;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/sleep/service/google/calendar/alarm/WorkingDaysPolicy;", "Ljava/lang/String;", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "getSettings", "()Lcom/urbandroid/sleep/service/Settings;", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier;", "calendarNotifier", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier;", "Ljava/text/SimpleDateFormat;", "formatDateTime", "Ljava/text/SimpleDateFormat;", "formatDate", "getCurrentTime", "()Ljava/util/Calendar;", "currentTime", "Result", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarAlarmManager implements FeatureLogger {
    private final String accountName;
    private final GoogleCalendarNotifier calendarNotifier;
    private final ProviderApi calendarProvider;
    private final Context context;
    private final SimpleDateFormat formatDate;
    private final SimpleDateFormat formatDateTime;
    private final Settings settings;
    private final String tag;
    private final WorkingDaysPolicy workingDaysPolicy;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager$advanceAlarmIfEvent$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager", f = "GoogleCalendarAlarmManager.kt", l = {65, 84}, m = "advanceAlarmIfEvent", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleCalendarAlarmManager.this.advanceAlarmIfEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager$skipNextIfHoliday$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager", f = "GoogleCalendarAlarmManager.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 210, 222, 234, 261}, m = "skipNextIfHoliday", v = 2)
    public static final class C21401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C21401(Continuation<? super C21401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleCalendarAlarmManager.this.skipNextIfHoliday(null, this);
        }
    }

    public GoogleCalendarAlarmManager(Context context, WorkingDaysPolicy workingDaysPolicy, String str, ProviderApi providerApi) {
        context.getClass();
        workingDaysPolicy.getClass();
        str.getClass();
        providerApi.getClass();
        this.context = context;
        this.workingDaysPolicy = workingDaysPolicy;
        this.accountName = str;
        this.calendarProvider = providerApi;
        this.tag = "calendar:alarm-manager";
        this.settings = ContextExtKt.getSettings(context);
        this.calendarNotifier = new GoogleCalendarNotifier();
        this.formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.formatDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean advanceAlarmIfEvent$lambda$4(GoogleCalendarAlarmManager googleCalendarAlarmManager, long j, GoogleCalendar googleCalendar, GoogleCalendar.Event event) {
        googleCalendar.getClass();
        event.getClass();
        GoogleCalendar.Event.Status status = event.getStatus();
        if (status == null || !(status == GoogleCalendar.Event.Status.CANCELLED || status == GoogleCalendar.Event.Status.TENTATIVE)) {
            return event.getStart() >= j && !event.getIsAllDay();
        }
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleCalendarAlarmManager, new StringBuilder(), ": ", "ignoring attendee status:" + status + " " + event), null);
        return false;
    }

    private final boolean areSameDate(Calendar cal1, Calendar cal2) {
        return cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
    }

    private final long calculateOffset(Alarm alarm, GoogleCalendar.Event event) {
        long timeInMillis = getCurrentTime().getTimeInMillis();
        long j = alarm.time;
        long offset = alarm.getOffset(timeInMillis);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long millis = j - timeUnit.toMillis(offset);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Alarm Time:", this.formatDateTime.format(new Date(alarm.time)))), null);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Alarm Offset Time:", this.formatDateTime.format(new Date(millis)))), null);
        long googleCalendarAlarmAdvanceInMinutes = this.settings.getGoogleCalendarAlarmAdvanceInMinutes();
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", zzba$$ExternalSyntheticOutline0.m(googleCalendarAlarmAdvanceInMinutes, "General Alarm Advance Time:")), null);
        Long l = AdvanceAlarmParser.parse(event);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Custom Alarm Advance Time:" + l), null);
        if (l != null) {
            googleCalendarAlarmAdvanceInMinutes = l.longValue();
        }
        long millis2 = timeUnit.toMillis(googleCalendarAlarmAdvanceInMinutes);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", zzba$$ExternalSyntheticOutline0.m(millis2, "Final Alarm Advance Time:")), null);
        if (millis >= event.getStart()) {
            if (event.getStart() - millis2 < timeInMillis) {
                millis2 = (event.getStart() - timeInMillis) - 60000;
            }
            return -((millis - (event.getStart() - millis2)) / 60000);
        }
        long start = event.getStart() - millis;
        if (start < millis2) {
            return -((millis2 - start) / 60000);
        }
        return 0L;
    }

    private final String formatEvent(GoogleCalendar.Event event) {
        String compositeId = event.getCompositeId();
        String str = this.formatDateTime.format(new Date(event.getStart()));
        return Fragment$$ExternalSyntheticOutline1.m(FileInsert$$ExternalSyntheticOutline0.m6m("CalendarEvent #", compositeId, " ", str, "-"), this.formatDateTime.format(new Date(event.getEnd())), " '", event.getTitle(), "'");
    }

    private final boolean hasCustomTag(GoogleCalendar.Event event, String tag) {
        if (event == null || !event.getIsAllDay()) {
            return false;
        }
        if (event.getTitle() != null) {
            String lowerCase = event.getTitle().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (StringsKt.contains$default(lowerCase, tag)) {
                return true;
            }
        }
        if (event.getDescription() == null) {
            return false;
        }
        String lowerCase2 = event.getDescription().toLowerCase(Locale.ROOT);
        lowerCase2.getClass();
        return StringsKt.contains$default(lowerCase2, tag);
    }

    private final void resetToMidnight(Calendar cal) {
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean skipNextIfHoliday$lambda$2(GoogleCalendarAlarmManager googleCalendarAlarmManager, ProcessedCalendarEventMap processedCalendarEventMap, Alarm alarm, Calendar calendar, GoogleCalendar googleCalendar, GoogleCalendar.Event event) {
        googleCalendar.getClass();
        event.getClass();
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleCalendarAlarmManager, new StringBuilder(), ": ", Fragment$$ExternalSyntheticOutline1.m("[", GoogleCalendarKt.getAnonymousId(googleCalendar), "] ... ", GoogleCalendarKt.pretty(event))), null);
        if (!processedCalendarEventMap.contains(event, Long.valueOf(alarm.time))) {
            if (googleCalendarAlarmManager.hasCustomTag(event, "#holiday")) {
                calendar.getClass();
                if (googleCalendarAlarmManager.areSameDate(calendar, event)) {
                    return true;
                }
            }
            return false;
        }
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleCalendarAlarmManager, new StringBuilder(), ": ", "[" + GoogleCalendarKt.getAnonymousId(googleCalendar) + "] User Holiday " + event + " already processed - skipping further evaluation"), null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence skipNextIfHoliday$lambda$3(GoogleCalendar.Event event) {
        event.getClass();
        return event.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean skipNextIfHoliday$lambda$4(GoogleCalendarAlarmManager googleCalendarAlarmManager, Calendar calendar, GoogleCalendar googleCalendar, GoogleCalendar.Event event) {
        googleCalendar.getClass();
        event.getClass();
        if (!googleCalendarAlarmManager.hasCustomTag(event, "#notholiday")) {
            return false;
        }
        calendar.getClass();
        return googleCalendarAlarmManager.areSameDate(calendar, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean skipNextIfHoliday$lambda$5(GoogleCalendarAlarmManager googleCalendarAlarmManager, ProcessedCalendarEventMap processedCalendarEventMap, Alarm alarm, Calendar calendar, GoogleCalendar googleCalendar, GoogleCalendar.Event event) {
        googleCalendar.getClass();
        event.getClass();
        Logger.logDebug(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleCalendarAlarmManager, new StringBuilder(), ": ", processedCalendarEventMap.toString()), null);
        if (processedCalendarEventMap.contains(event, Long.valueOf(alarm.time))) {
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleCalendarAlarmManager, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Public Holiday ", GoogleCalendarKt.pretty(event), " already processed - skipping further evaluation")), null);
            return false;
        }
        if (event.getIsAllDay()) {
            calendar.getClass();
            if (googleCalendarAlarmManager.areSameDate(calendar, event)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence skipNextIfHoliday$lambda$6$0(GoogleCalendar.Event event) {
        event.getClass();
        return GoogleCalendarKt.pretty(event);
    }

    public final void advanceAlarmAndNotify(Context context, Alarm alarm, int offsetMin, GoogleCalendar.Event event) {
        context.getClass();
        alarm.getClass();
        event.getClass();
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Calendar advanceAlarmAndNotify: offset = " + offsetMin + " alarm: " + Alarm.toDebugString(alarm)), null);
        if (offsetMin == 0) {
            return;
        }
        long timeInMillis = getCurrentTime().getTimeInMillis();
        if ((offsetMin >= 0 || Math.abs(offsetMin) > 180) && offsetMin <= 0) {
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", Fragment$$ExternalSyntheticOutline1.m(offsetMin, "Offset ", " > 180 - only suggestion for rescheduling alarm is shown")), null);
            this.calendarNotifier.notifyCalendar(GoogleCalendarNotifier.Mode.EVENT_RESCHEDULE_ALARM, context, alarm, event, getCurrentTime());
            return;
        }
        long j = alarm.suspendTime;
        if (j <= timeInMillis) {
            j = timeInMillis;
        }
        Alarms.addOffset(context, alarm, offsetMin, j);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Calendar after addOffset: ", Alarm.toDebugString(alarm))), null);
        GoogleCalendarNotifier.Mode mode = GoogleCalendarNotifier.Mode.EVENT;
        String contentText = mode.getContentText(context, alarm, getCurrentTime());
        this.calendarNotifier.notifyCalendar(mode, context, alarm, event, getCurrentTime());
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Calendar after notify: ", contentText)), null);
        Alarms.setAlarm(context, alarm, timeInMillis);
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Calendar after setAlarm: ", Alarm.toDebugString(alarm))), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.urbandroid.common.FeatureLogger, com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.urbandroid.sleep.alarmclock.Alarm, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.urbandroid.sleep.alarmclock.Alarm] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object advanceAlarmIfEvent(Alarm alarm, Continuation<? super Result> continuation) {
        AnonymousClass1 anonymousClass1;
        GoogleCalendar googleCalendar;
        ?? r3;
        ?? r4;
        ProcessedCalendarEventMap processedCalendarEventMap;
        String str;
        Iterator it;
        Object next;
        GoogleCalendar.Event event;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object primaryCalendar = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r32 = anonymousClass12.label;
        try {
        } catch (UserRecoverableAuthException e) {
            e = e;
        }
        if (r32 == 0) {
            ResultKt.throwOnFailure(primaryCalendar);
            if (!this.settings.isGoogleCalendar() || !this.settings.isGoogleCalendarEvent()) {
                return new Result(Result.Code.EVENT_OPTION_DISABLED, null, 0, 6, null);
            }
            try {
                ProviderApi providerApi = this.calendarProvider;
                Alarm alarm2 = alarm;
                anonymousClass12.L$0 = alarm2;
                anonymousClass12.label = 1;
                primaryCalendar = providerApi.getPrimaryCalendar(anonymousClass12);
                r32 = alarm2;
            } catch (UserRecoverableAuthException e2) {
                e = e2;
                r32 = alarm;
                Logger.logWarning(Logger.defaultTag, getTag() + ": failure getting primary calendar", e);
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(this.context, e);
                googleCalendar = null;
                r3 = r32;
            }
            if (primaryCalendar == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (r32 != 1) {
                if (r32 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) anonymousClass12.L$6;
                processedCalendarEventMap = (ProcessedCalendarEventMap) anonymousClass12.L$5;
                Alarm alarm3 = (Alarm) anonymousClass12.L$0;
                ResultKt.throwOnFailure(primaryCalendar);
                r4 = alarm3;
                it = ((List) primaryCalendar).iterator();
                if (it.hasNext()) {
                    next = null;
                } else {
                    next = it.next();
                    if (it.hasNext()) {
                        long start = ((GoogleCalendar.Event) next).getStart();
                        do {
                            Object next2 = it.next();
                            long start2 = ((GoogleCalendar.Event) next2).getStart();
                            if (start > start2) {
                                next = next2;
                                start = start2;
                            }
                        } while (it.hasNext());
                    }
                }
                event = (GoogleCalendar.Event) next;
                if (event != null) {
                    Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("No Calendar Event found: ", str)), null);
                    return new Result(Result.Code.NO_EVENT_FOUND, null, 0, 6, null);
                }
                ProcessedCalendarEventMap.Event event2 = processedCalendarEventMap.get(event.getCompositeId());
                GoogleCalendar.Event event3 = event2 != null ? event2.getEvent() : null;
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", processedCalendarEventMap.toString()), null);
                if (event3 != null && event3.getStart() == event.getStart() && event3.getEnd() == event.getEnd()) {
                    Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m$1(formatEvent(event), " already processed - skipping further evaluation")), null);
                    return new Result(event3.getOffsetInMinutes() != 0 ? Result.Code.ALARM_ALREADY_ADVANCED : Result.Code.EVENT_ALREADY_PROCESSED, null, 0, 6, null);
                }
                if (event3 == null && r4.getOffset() != 0) {
                    return new Result(Result.Code.ALARM_OFFSET_MANUALLY_ALTERED, null, 0, 6, null);
                }
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("Found: ", formatEvent(event))), null);
                int iCalculateOffset = (int) calculateOffset(r4, event);
                boolean zAdd = processedCalendarEventMap.add(new ProcessedCalendarEventMap.Event(event.withOffset(iCalculateOffset), null));
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", "Calculated advance offset: " + iCalculateOffset + " minutes\tevent added to proceessedMap: " + zAdd), null);
                if (iCalculateOffset == 0 || !zAdd) {
                    return new Result(Result.Code.ALARM_NOT_TOUCHED, null, 0, 6, null);
                }
                advanceAlarmAndNotify(this.context, r4, iCalculateOffset, event);
                return new Result(Result.Code.ALARM_ADVANCED, event, iCalculateOffset);
            }
            Alarm alarm4 = (Alarm) anonymousClass12.L$0;
            ResultKt.throwOnFailure(primaryCalendar);
            r32 = alarm4;
        }
        googleCalendar = (GoogleCalendar) primaryCalendar;
        r3 = r32;
        if (googleCalendar == null) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": Main Google Calendar not found", null);
            return new Result(Result.Code.CALENDAR_NOT_FOUND, null, 0, 6, null);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(r3.time);
        Object objClone = calendar.clone();
        objClone.getClass();
        Calendar calendar2 = (Calendar) objClone;
        calendar2.add(12, -180);
        Object objClone2 = calendar2.clone();
        objClone2.getClass();
        Calendar calendar3 = (Calendar) objClone2;
        calendar3.add(6, 1);
        ProcessedCalendarEventMap processedCalendarEventMap2 = new ProcessedCalendarEventMap(this.context, this.accountName, ProcessedCalendarEventMap.Type.EVENT, getCurrentTime().getTimeInMillis() - TimeChart.DAY);
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(this.formatDateTime.format(calendar2.getTime()), " - ", this.formatDateTime.format(calendar3.getTime()));
        Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m((GoogleCalendarAlarmManager) this, new StringBuilder(), ": ", Fragment$$ExternalSyntheticOutline1.m("Checking calendar events ", strM$1, " alarm: ", this.formatDateTime.format(calendar.getTime()))), null);
        final long timeInMillis = getCurrentTime().getTimeInMillis();
        ProviderApi providerApi2 = this.calendarProvider;
        long timeInMillis2 = calendar2.getTimeInMillis();
        long timeInMillis3 = calendar3.getTimeInMillis();
        String id = TimeZone.getDefault().getID();
        id.getClass();
        Function2 function2 = new Function2() { // from class: com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(GoogleCalendarAlarmManager.advanceAlarmIfEvent$lambda$4(this.f$0, timeInMillis, (GoogleCalendar) obj, (GoogleCalendar.Event) obj2));
            }
        };
        anonymousClass12.L$0 = r3;
        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(googleCalendar);
        anonymousClass12.L$2 = SpillingKt.nullOutSpilledVariable(calendar);
        anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(calendar2);
        anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(calendar3);
        anonymousClass12.L$5 = processedCalendarEventMap2;
        anonymousClass12.L$6 = strM$1;
        anonymousClass12.J$0 = timeInMillis;
        anonymousClass12.label = 2;
        GoogleCalendar googleCalendar2 = googleCalendar;
        ?? r0 = r3;
        Object events$default = ProviderApi.getEvents$default(providerApi2, googleCalendar2, timeInMillis2, timeInMillis3, id, false, function2, anonymousClass12, 16, null);
        if (events$default != coroutine_suspended) {
            r4 = r0;
            primaryCalendar = events$default;
            processedCalendarEventMap = processedCalendarEventMap2;
            str = strM$1;
            it = ((List) primaryCalendar).iterator();
            if (it.hasNext()) {
            }
            event = (GoogleCalendar.Event) next;
            if (event != null) {
            }
        }
        return coroutine_suspended;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Calendar getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.getClass();
        return calendar;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void notifyHoliday(Context context, Alarm alarm, GoogleCalendar.Event holidayEvent, boolean forceSkip) {
        context.getClass();
        alarm.getClass();
        holidayEvent.getClass();
        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "notifyHoliday: forceSkip: " + forceSkip + " event: " + holidayEvent), null);
        if (forceSkip) {
            Alarms.suspendNextAlarm(context, alarm);
        }
        this.calendarNotifier.notifyCalendar(forceSkip ? GoogleCalendarNotifier.Mode.HOLIDAY_SKIP : GoogleCalendarNotifier.Mode.HOLIDAY_NOTIFY, context, alarm, holidayEvent, getCurrentTime());
    }

    public final ProcessedCalendarEventMap prepareProcessedEventMap(Context context, String accountName, ProcessedCalendarEventMap.Type type, GoogleCalendar calendar) {
        context.getClass();
        accountName.getClass();
        type.getClass();
        calendar.getClass();
        return new ProcessedCalendarEventMap(context, type, accountName, calendar, getCurrentTime().getTimeInMillis() - TimeChart.DAY);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x04b6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x052d -> B:101:0x0531). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object skipNextIfHoliday(Alarm alarm, Continuation<? super Result> continuation) {
        C21401 c21401;
        GoogleCalendar googleCalendar;
        Calendar calendar;
        Calendar calendar2;
        Calendar calendar3;
        Object primaryCalendar;
        SecurityException e;
        Calendar calendar4;
        final Calendar calendar5;
        Calendar calendar6;
        GoogleCalendar googleCalendar2;
        UserRecoverableAuthException e2;
        String str;
        GoogleCalendar googleCalendar3;
        Calendar calendar7;
        Object obj;
        Alarm alarm2;
        ProcessedCalendarEventMap processedCalendarEventMap;
        Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2;
        List list;
        Alarm alarm3;
        GoogleCalendar googleCalendar4;
        Calendar calendar8;
        Calendar calendar9;
        Calendar calendar10;
        ProcessedCalendarEventMap processedCalendarEventMap2;
        List list2;
        Object obj2;
        Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function22;
        List list3;
        Object holidayCalendars;
        UserRecoverableAuthIOException e3;
        List listEmptyList;
        List list4;
        List list5;
        Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function23;
        ProcessedCalendarEventMap processedCalendarEventMap3;
        String str2;
        final Calendar calendar11;
        final Alarm alarm4;
        GoogleCalendar googleCalendar5;
        C21401 c214012;
        List list6;
        Iterator it;
        Alarm alarm5 = alarm;
        if (continuation instanceof C21401) {
            c21401 = (C21401) continuation;
            int i = c21401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21401.label = i - Integer.MIN_VALUE;
            } else {
                c21401 = new C21401(continuation);
            }
        }
        C21401 c214013 = c21401;
        Object obj3 = c214013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c214013.label;
        if (i2 == 0) {
            googleCalendar = null;
            ResultKt.throwOnFailure(obj3);
            if (!this.settings.isGoogleCalendar()) {
                return new Result(Result.Code.CALENDAR_OPTION_DISABLED, null, 0, 6, null);
            }
            if (!this.settings.isGoogleCalendarHoliday()) {
                return new Result(Result.Code.HOLIDAY_OPTION_DISABLED, null, 0, 6, null);
            }
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(alarm5.time);
            Object objClone = calendar.clone();
            objClone.getClass();
            calendar2 = (Calendar) objClone;
            resetToMidnight(calendar2);
            Object objClone2 = calendar2.clone();
            objClone2.getClass();
            calendar3 = (Calendar) objClone2;
            calendar3.add(6, 2);
            try {
                ProviderApi providerApi = this.calendarProvider;
                c214013.L$0 = alarm5;
                c214013.L$1 = calendar;
                c214013.L$2 = calendar2;
                c214013.L$3 = calendar3;
                c214013.label = 1;
                primaryCalendar = providerApi.getPrimaryCalendar(c214013);
            } catch (UserRecoverableAuthException e4) {
                e2 = e4;
                Logger.logWarning(Logger.defaultTag, getTag() + ": Get Calendar failure", e2);
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(this.context, e2);
                calendar4 = calendar2;
                calendar5 = calendar;
                calendar6 = calendar3;
                googleCalendar2 = googleCalendar;
            } catch (SecurityException e5) {
                e = e5;
                Logger.logWarning(Logger.defaultTag, getTag() + ": Get Calendar failure", e);
                calendar4 = calendar2;
                calendar5 = calendar;
                calendar6 = calendar3;
                googleCalendar2 = googleCalendar;
            }
            if (primaryCalendar == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            googleCalendar = null;
            Calendar calendar12 = (Calendar) c214013.L$3;
            calendar2 = (Calendar) c214013.L$2;
            calendar = (Calendar) c214013.L$1;
            Alarm alarm6 = (Alarm) c214013.L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                calendar3 = calendar12;
                alarm5 = alarm6;
                primaryCalendar = obj3;
            } catch (UserRecoverableAuthException e6) {
                e2 = e6;
                calendar3 = calendar12;
                alarm5 = alarm6;
                Logger.logWarning(Logger.defaultTag, getTag() + ": Get Calendar failure", e2);
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(this.context, e2);
                calendar4 = calendar2;
                calendar5 = calendar;
                calendar6 = calendar3;
                googleCalendar2 = googleCalendar;
            } catch (SecurityException e7) {
                e = e7;
                calendar3 = calendar12;
                alarm5 = alarm6;
                Logger.logWarning(Logger.defaultTag, getTag() + ": Get Calendar failure", e);
                calendar4 = calendar2;
                calendar5 = calendar;
                calendar6 = calendar3;
                googleCalendar2 = googleCalendar;
            }
        } else {
            if (i2 == 2) {
                Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function24 = (Function2) c214013.L$6;
                ProcessedCalendarEventMap processedCalendarEventMap4 = (ProcessedCalendarEventMap) c214013.L$5;
                GoogleCalendar googleCalendar6 = (GoogleCalendar) c214013.L$4;
                Calendar calendar13 = (Calendar) c214013.L$3;
                Calendar calendar14 = (Calendar) c214013.L$2;
                Calendar calendar15 = (Calendar) c214013.L$1;
                Alarm alarm7 = (Alarm) c214013.L$0;
                ResultKt.throwOnFailure(obj3);
                calendar6 = calendar13;
                calendar4 = calendar14;
                calendar7 = calendar15;
                str = ": ";
                alarm2 = alarm7;
                googleCalendar3 = googleCalendar6;
                processedCalendarEventMap = processedCalendarEventMap4;
                function2 = function24;
                obj = obj3;
                list = (List) obj;
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("userHolidayEvents: ", CollectionsKt.joinToString$default(list, "\n", null, null, new AiPrompt$$ExternalSyntheticLambda0(23), 30))), null);
                if (list.isEmpty()) {
                    GoogleCalendar.Event event = (GoogleCalendar.Event) list.iterator().next();
                    boolean zAdd = processedCalendarEventMap.add(new ProcessedCalendarEventMap.Event(event, Boxing.boxLong(alarm2.time)));
                    Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, "User Holiday found: " + GoogleCalendarKt.pretty(event) + " added: " + zAdd), null);
                    if (zAdd) {
                        notifyHoliday(this.context, alarm2, event, true);
                        return new Result(Result.Code.ALARM_SKIPPED, event, 0, 4, null);
                    }
                    return new Result(Result.Code.NO_HOLIDAY_FOUND, null, 0, 6, null);
                }
                ProviderApi providerApi2 = this.calendarProvider;
                long j = alarm2.time;
                CombinedContext$$ExternalSyntheticLambda0 combinedContext$$ExternalSyntheticLambda0 = new CombinedContext$$ExternalSyntheticLambda0(this, calendar7, 1);
                c214013.L$0 = alarm2;
                c214013.L$1 = calendar7;
                c214013.L$2 = calendar4;
                c214013.L$3 = calendar6;
                c214013.L$4 = SpillingKt.nullOutSpilledVariable(googleCalendar3);
                c214013.L$5 = processedCalendarEventMap;
                c214013.L$6 = SpillingKt.nullOutSpilledVariable(function2);
                c214013.L$7 = SpillingKt.nullOutSpilledVariable(list);
                c214013.label = 3;
                Calendar calendar16 = calendar7;
                alarm3 = alarm2;
                Object events = providerApi2.getEvents(googleCalendar3, j, combinedContext$$ExternalSyntheticLambda0, c214013);
                if (events != coroutine_suspended) {
                    googleCalendar4 = googleCalendar3;
                    calendar8 = calendar6;
                    calendar9 = calendar4;
                    calendar10 = calendar16;
                    processedCalendarEventMap2 = processedCalendarEventMap;
                    list2 = list;
                    obj2 = events;
                    function22 = function2;
                    list3 = (List) obj2;
                    if (list3.isEmpty()) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                List list7 = (List) c214013.L$7;
                function2 = (Function2) c214013.L$6;
                ProcessedCalendarEventMap processedCalendarEventMap5 = (ProcessedCalendarEventMap) c214013.L$5;
                GoogleCalendar googleCalendar7 = (GoogleCalendar) c214013.L$4;
                Calendar calendar17 = (Calendar) c214013.L$3;
                Calendar calendar18 = (Calendar) c214013.L$2;
                Calendar calendar19 = (Calendar) c214013.L$1;
                Alarm alarm8 = (Alarm) c214013.L$0;
                ResultKt.throwOnFailure(obj3);
                str = ": ";
                calendar10 = calendar19;
                alarm3 = alarm8;
                calendar8 = calendar17;
                calendar9 = calendar18;
                processedCalendarEventMap2 = processedCalendarEventMap5;
                googleCalendar4 = googleCalendar7;
                list2 = list7;
                obj2 = obj3;
                function22 = function2;
                list3 = (List) obj2;
                if (list3.isEmpty()) {
                    GoogleCalendar.Event event2 = (GoogleCalendar.Event) list3.iterator().next();
                    Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("User Not Holiday found - no alarm skip: ", GoogleCalendarKt.pretty(event2))), null);
                    processedCalendarEventMap2.add(new ProcessedCalendarEventMap.Event(event2, Boxing.boxLong(alarm3.time)));
                    return new Result(Result.Code.NO_HOLIDAY_FOUND, event2, 0, 4, null);
                }
                try {
                    ProviderApi providerApi3 = this.calendarProvider;
                    c214013.L$0 = alarm3;
                    c214013.L$1 = calendar10;
                    c214013.L$2 = calendar9;
                    c214013.L$3 = calendar8;
                    c214013.L$4 = SpillingKt.nullOutSpilledVariable(googleCalendar4);
                    c214013.L$5 = SpillingKt.nullOutSpilledVariable(processedCalendarEventMap2);
                    c214013.L$6 = SpillingKt.nullOutSpilledVariable(function22);
                    c214013.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    c214013.L$8 = SpillingKt.nullOutSpilledVariable(list3);
                    c214013.label = 4;
                    holidayCalendars = providerApi3.getHolidayCalendars(c214013);
                } catch (UserRecoverableAuthIOException e8) {
                    e3 = e8;
                    Logger.logWarning(Logger.defaultTag, getTag() + str, e3);
                    listEmptyList = CollectionsKt.emptyList();
                    list3 = list3;
                    list2 = list2;
                }
                if (holidayCalendars == coroutine_suspended) {
                    return coroutine_suspended;
                }
                listEmptyList = (List) holidayCalendars;
                if (!listEmptyList.isEmpty()) {
                }
            } else {
                if (i2 != 4) {
                    if (i2 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    final ProcessedCalendarEventMap processedCalendarEventMapPrepareProcessedEventMap = (ProcessedCalendarEventMap) c214013.L$13;
                    GoogleCalendar googleCalendar8 = (GoogleCalendar) c214013.L$12;
                    Iterator it2 = (Iterator) c214013.L$11;
                    String str3 = (String) c214013.L$10;
                    List list8 = (List) c214013.L$9;
                    List list9 = (List) c214013.L$8;
                    List list10 = (List) c214013.L$7;
                    Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function25 = (Function2) c214013.L$6;
                    ProcessedCalendarEventMap processedCalendarEventMap6 = (ProcessedCalendarEventMap) c214013.L$5;
                    GoogleCalendar googleCalendar9 = (GoogleCalendar) c214013.L$4;
                    Calendar calendar20 = (Calendar) c214013.L$3;
                    Calendar calendar21 = (Calendar) c214013.L$2;
                    Calendar calendar22 = (Calendar) c214013.L$1;
                    Alarm alarm9 = (Alarm) c214013.L$0;
                    ResultKt.throwOnFailure(obj3);
                    GoogleCalendar googleCalendar10 = googleCalendar8;
                    processedCalendarEventMap3 = processedCalendarEventMap6;
                    calendar8 = calendar20;
                    alarm4 = alarm9;
                    Object events2 = obj3;
                    list4 = list9;
                    c214012 = c214013;
                    list6 = list8;
                    it = it2;
                    calendar11 = calendar22;
                    function23 = function25;
                    googleCalendar5 = googleCalendar9;
                    calendar9 = calendar21;
                    list5 = list10;
                    str = ": ";
                    str2 = str3;
                    List list11 = (List) events2;
                    Calendar calendar23 = calendar11;
                    Logger.logDebug(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("holiday events: \n", CollectionsKt.joinToString$default(list11, "\n", null, null, new AiPrompt$$ExternalSyntheticLambda0(24), 30))), null);
                    if (list11.isEmpty()) {
                        GoogleCalendar.Event event3 = (GoogleCalendar.Event) list11.iterator().next();
                        boolean zAdd2 = processedCalendarEventMapPrepareProcessedEventMap.add(new ProcessedCalendarEventMap.Event(event3, Boxing.boxLong(alarm4.time)));
                        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, googleCalendar10.getOwnerName() + " Public Holiday found: added: " + zAdd2 + " - " + GoogleCalendarKt.pretty(event3)), null);
                        if (zAdd2) {
                            notifyHoliday(this.context, alarm4, event3, false);
                            return new Result(Result.Code.HOLIDAY_FOUND, event3, 0, 4, null);
                        }
                        return new Result(Result.Code.NO_HOLIDAY_FOUND, null, 0, 6, null);
                    }
                    calendar11 = calendar23;
                    if (it.hasNext()) {
                        Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("No Holiday found: ", str2)), null);
                        return new Result(Result.Code.NO_HOLIDAY_FOUND, null, 0, 6, null);
                    }
                    GoogleCalendar googleCalendar11 = (GoogleCalendar) it.next();
                    processedCalendarEventMapPrepareProcessedEventMap = prepareProcessedEventMap(this.context, this.accountName, ProcessedCalendarEventMap.Type.HOLIDAY, googleCalendar11);
                    final int i3 = 1;
                    alarm4 = alarm4;
                    List list12 = list6;
                    Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function26 = new Function2(this) { // from class: com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager$$ExternalSyntheticLambda1
                        public final /* synthetic */ GoogleCalendarAlarmManager f$0;

                        {
                            this.f$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            boolean zSkipNextIfHoliday$lambda$2;
                            switch (i3) {
                                case 0:
                                    zSkipNextIfHoliday$lambda$2 = GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$2(this.f$0, processedCalendarEventMapPrepareProcessedEventMap, alarm4, calendar11, (GoogleCalendar) obj4, (GoogleCalendar.Event) obj5);
                                    break;
                                default:
                                    zSkipNextIfHoliday$lambda$2 = GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$5(this.f$0, processedCalendarEventMapPrepareProcessedEventMap, alarm4, calendar11, (GoogleCalendar) obj4, (GoogleCalendar.Event) obj5);
                                    break;
                            }
                            return Boolean.valueOf(zSkipNextIfHoliday$lambda$2);
                        }
                    };
                    ProviderApi providerApi4 = this.calendarProvider;
                    long timeInMillis = calendar9.getTimeInMillis();
                    long timeInMillis2 = calendar8.getTimeInMillis();
                    c214012.L$0 = alarm4;
                    c214012.L$1 = calendar11;
                    c214012.L$2 = calendar9;
                    c214012.L$3 = calendar8;
                    c214012.L$4 = SpillingKt.nullOutSpilledVariable(googleCalendar5);
                    c214012.L$5 = SpillingKt.nullOutSpilledVariable(processedCalendarEventMap3);
                    c214012.L$6 = SpillingKt.nullOutSpilledVariable(function23);
                    c214012.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                    c214012.L$8 = SpillingKt.nullOutSpilledVariable(list4);
                    c214012.L$9 = SpillingKt.nullOutSpilledVariable(list12);
                    c214012.L$10 = str2;
                    c214012.L$11 = it;
                    c214012.L$12 = googleCalendar11;
                    c214012.L$13 = processedCalendarEventMapPrepareProcessedEventMap;
                    c214012.L$14 = SpillingKt.nullOutSpilledVariable(function26);
                    c214012.label = 5;
                    googleCalendar10 = googleCalendar11;
                    C21401 c214014 = c214012;
                    events2 = providerApi4.getEvents(googleCalendar10, timeInMillis, timeInMillis2, "GMT", false, function26, c214014);
                    if (events2 != coroutine_suspended) {
                        c214012 = c214014;
                        list6 = list12;
                        List list112 = (List) events2;
                        Calendar calendar232 = calendar11;
                        Logger.logDebug(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("holiday events: \n", CollectionsKt.joinToString$default(list112, "\n", null, null, new AiPrompt$$ExternalSyntheticLambda0(24), 30))), null);
                        if (list112.isEmpty()) {
                        }
                    }
                    return coroutine_suspended;
                }
                list3 = (List) c214013.L$8;
                list2 = (List) c214013.L$7;
                function22 = (Function2) c214013.L$6;
                processedCalendarEventMap2 = (ProcessedCalendarEventMap) c214013.L$5;
                googleCalendar4 = (GoogleCalendar) c214013.L$4;
                calendar8 = (Calendar) c214013.L$3;
                calendar9 = (Calendar) c214013.L$2;
                calendar10 = (Calendar) c214013.L$1;
                Alarm alarm10 = (Alarm) c214013.L$0;
                try {
                    ResultKt.throwOnFailure(obj3);
                    alarm3 = alarm10;
                    holidayCalendars = obj3;
                    str = ": ";
                    listEmptyList = (List) holidayCalendars;
                } catch (UserRecoverableAuthIOException e9) {
                    e3 = e9;
                    alarm3 = alarm10;
                    str = ": ";
                    Logger.logWarning(Logger.defaultTag, getTag() + str, e3);
                    listEmptyList = CollectionsKt.emptyList();
                    list3 = list3;
                    list2 = list2;
                }
                if (!listEmptyList.isEmpty()) {
                    Logger.logWarning(Logger.defaultTag, getTag() + ": Google Holiday Calendar not found", null);
                    return new Result(Result.Code.CALENDAR_NOT_FOUND, null, 0, 6, null);
                }
                if (!this.workingDaysPolicy.isWorkingDay(calendar10)) {
                    return new Result(Result.Code.NOT_WORKING_DAY, null, 0, 6, null);
                }
                List list13 = listEmptyList;
                list4 = list3;
                String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(this.formatDateTime.format(calendar9.getTime()), " - ", this.formatDateTime.format(calendar8.getTime()));
                int i4 = alarm3.id;
                list5 = list2;
                String str4 = this.formatDateTime.format(calendar10.getTime());
                function23 = function22;
                processedCalendarEventMap3 = processedCalendarEventMap2;
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i4, "Checking public holidays ", strM$1, " alarm[", "]: ");
                sbM.append(str4);
                Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, sbM.toString()), null);
                str2 = strM$1;
                calendar11 = calendar10;
                alarm4 = alarm3;
                googleCalendar5 = googleCalendar4;
                c214012 = c214013;
                list6 = list13;
                it = list13.iterator();
                if (it.hasNext()) {
                }
            }
        }
        calendar4 = calendar2;
        calendar5 = calendar;
        calendar6 = calendar3;
        googleCalendar2 = (GoogleCalendar) primaryCalendar;
        final Alarm alarm11 = alarm5;
        if (googleCalendar2 == null) {
            return new Result(Result.Code.CALENDAR_NOT_FOUND, null, 0, 6, null);
        }
        final ProcessedCalendarEventMap processedCalendarEventMapPrepareProcessedEventMap2 = prepareProcessedEventMap(this.context, this.accountName, ProcessedCalendarEventMap.Type.HOLIDAY, googleCalendar2);
        final int i5 = 0;
        Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function27 = new Function2(this) { // from class: com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager$$ExternalSyntheticLambda1
            public final /* synthetic */ GoogleCalendarAlarmManager f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj4, Object obj5) {
                boolean zSkipNextIfHoliday$lambda$2;
                switch (i5) {
                    case 0:
                        zSkipNextIfHoliday$lambda$2 = GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$2(this.f$0, processedCalendarEventMapPrepareProcessedEventMap2, alarm11, calendar5, (GoogleCalendar) obj4, (GoogleCalendar.Event) obj5);
                        break;
                    default:
                        zSkipNextIfHoliday$lambda$2 = GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$5(this.f$0, processedCalendarEventMapPrepareProcessedEventMap2, alarm11, calendar5, (GoogleCalendar) obj4, (GoogleCalendar.Event) obj5);
                        break;
                }
                return Boolean.valueOf(zSkipNextIfHoliday$lambda$2);
            }
        };
        Calendar calendar24 = calendar5;
        ProviderApi providerApi5 = this.calendarProvider;
        str = ": ";
        long j2 = alarm11.time;
        c214013.L$0 = alarm11;
        c214013.L$1 = calendar24;
        c214013.L$2 = calendar4;
        c214013.L$3 = calendar6;
        c214013.L$4 = googleCalendar2;
        c214013.L$5 = processedCalendarEventMapPrepareProcessedEventMap2;
        c214013.L$6 = SpillingKt.nullOutSpilledVariable(function27);
        c214013.label = 2;
        googleCalendar3 = googleCalendar2;
        Object events3 = providerApi5.getEvents(googleCalendar3, j2, function27, c214013);
        if (events3 != coroutine_suspended) {
            calendar7 = calendar24;
            obj = events3;
            alarm2 = alarm11;
            processedCalendarEventMap = processedCalendarEventMapPrepareProcessedEventMap2;
            function2 = function27;
            list = (List) obj;
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), str, FileInsert$$ExternalSyntheticOutline0.m("userHolidayEvents: ", CollectionsKt.joinToString$default(list, "\n", null, null, new AiPrompt$$ExternalSyntheticLambda0(23), 30))), null);
            if (list.isEmpty()) {
            }
        }
        return coroutine_suspended;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result;", "", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result$Code;", "code", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "event", "", SpotifyService.OFFSET, "<init>", "(Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result$Code;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;I)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result$Code;", "getCode", "()Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result$Code;", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "getEvent", "()Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "I", "getOffset", "Code", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Result {
        private final Code code;
        private final GoogleCalendar.Event event;
        private final int offset;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result$Code;", "", "<init>", "(Ljava/lang/String;I)V", "CALENDAR_NOT_FOUND", "ALARM_NOT_TOUCHED", "ALARM_SKIPPED", "HOLIDAY_FOUND", "ALARM_ADVANCED", "ALARM_ALREADY_ADVANCED", "ALARM_SUSPENDED_IN_FUTURE", "NO_HOLIDAY_FOUND", "NO_EVENT_FOUND", "NOT_WORKING_DAY", "HOLIDAY_OPTION_DISABLED", "CALENDAR_OPTION_DISABLED", "EVENT_OPTION_DISABLED", "EVENT_ALREADY_PROCESSED", "ALARM_OFFSET_MANUALLY_ALTERED", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Code {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Code[] $VALUES;
            public static final Code CALENDAR_NOT_FOUND = new Code("CALENDAR_NOT_FOUND", 0);
            public static final Code ALARM_NOT_TOUCHED = new Code("ALARM_NOT_TOUCHED", 1);
            public static final Code ALARM_SKIPPED = new Code("ALARM_SKIPPED", 2);
            public static final Code HOLIDAY_FOUND = new Code("HOLIDAY_FOUND", 3);
            public static final Code ALARM_ADVANCED = new Code("ALARM_ADVANCED", 4);
            public static final Code ALARM_ALREADY_ADVANCED = new Code("ALARM_ALREADY_ADVANCED", 5);
            public static final Code ALARM_SUSPENDED_IN_FUTURE = new Code("ALARM_SUSPENDED_IN_FUTURE", 6);
            public static final Code NO_HOLIDAY_FOUND = new Code("NO_HOLIDAY_FOUND", 7);
            public static final Code NO_EVENT_FOUND = new Code("NO_EVENT_FOUND", 8);
            public static final Code NOT_WORKING_DAY = new Code("NOT_WORKING_DAY", 9);
            public static final Code HOLIDAY_OPTION_DISABLED = new Code("HOLIDAY_OPTION_DISABLED", 10);
            public static final Code CALENDAR_OPTION_DISABLED = new Code("CALENDAR_OPTION_DISABLED", 11);
            public static final Code EVENT_OPTION_DISABLED = new Code("EVENT_OPTION_DISABLED", 12);
            public static final Code EVENT_ALREADY_PROCESSED = new Code("EVENT_ALREADY_PROCESSED", 13);
            public static final Code ALARM_OFFSET_MANUALLY_ALTERED = new Code("ALARM_OFFSET_MANUALLY_ALTERED", 14);

            private static final /* synthetic */ Code[] $values() {
                return new Code[]{CALENDAR_NOT_FOUND, ALARM_NOT_TOUCHED, ALARM_SKIPPED, HOLIDAY_FOUND, ALARM_ADVANCED, ALARM_ALREADY_ADVANCED, ALARM_SUSPENDED_IN_FUTURE, NO_HOLIDAY_FOUND, NO_EVENT_FOUND, NOT_WORKING_DAY, HOLIDAY_OPTION_DISABLED, CALENDAR_OPTION_DISABLED, EVENT_OPTION_DISABLED, EVENT_ALREADY_PROCESSED, ALARM_OFFSET_MANUALLY_ALTERED};
            }

            static {
                Code[] codeArr$values = $values();
                $VALUES = codeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(codeArr$values);
            }

            private Code(String str, int i) {
            }

            public static Code valueOf(String str) {
                return (Code) Enum.valueOf(Code.class, str);
            }

            public static Code[] values() {
                return (Code[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Result(Code code, GoogleCalendar.Event event, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(code, (i2 & 2) != 0 ? null : event, (i2 & 4) != 0 ? 0 : i);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.code == result.code && Intrinsics.areEqual(this.event, result.event) && this.offset == result.offset;
        }

        public final Code getCode() {
            return this.code;
        }

        public int hashCode() {
            int iHashCode = this.code.hashCode() * 31;
            GoogleCalendar.Event event = this.event;
            return Integer.hashCode(this.offset) + ((iHashCode + (event == null ? 0 : event.hashCode())) * 31);
        }

        public String toString() {
            Code code = this.code;
            GoogleCalendar.Event event = this.event;
            int i = this.offset;
            StringBuilder sb = new StringBuilder("Result(code=");
            sb.append(code);
            sb.append(", event=");
            sb.append(event);
            sb.append(", offset=");
            return FileInsert$$ExternalSyntheticOutline0.m(i, ")", sb);
        }

        public Result(Code code, GoogleCalendar.Event event, int i) {
            code.getClass();
            this.code = code;
            this.event = event;
            this.offset = i;
        }
    }

    private final boolean areSameDate(Calendar cal, GoogleCalendar.Event event) {
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone(event.getStartTimezone()));
        calendar.setTimeInMillis(event.getStart());
        return areSameDate(cal, calendar);
    }

    public /* synthetic */ GoogleCalendarAlarmManager(Context context, WorkingDaysPolicy workingDaysPolicy, String str, ProviderApi providerApi, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, workingDaysPolicy, str, (i & 8) != 0 ? new CachedCalendarProviderApi(context, new CalendarProviderApi(context, str)) : providerApi);
    }
}
