package com.urbandroid.sleep.service.google.calendar.api.provider;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.gson.reflect.TypeToken;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.JsonSharedPreferences;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0096@¢\u0006\u0004\b\u000e\u0010\u000bJZ\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0096A¢\u0006\u0004\b\u001a\u0010\u001bJB\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00102\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0096A¢\u0006\u0004\b\u001a\u0010\u001dJJ\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0096A¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0018H\u0096A¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010)R\u001a\u0010*\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/provider/CachedCalendarProviderApi;", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/service/google/calendar/api/provider/CalendarProviderApi;", "providerApi", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/google/calendar/api/provider/CalendarProviderApi;)V", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "getOrCreateSleepCalendar", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrimaryCalendar", "", "getHolidayCalendars", "calendar", "", "from", "to", "", "defaultTimeZoneIfNull", "", "singleEvents", "Lkotlin/Function2;", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "filter", "getEvents", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JJLjava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "time", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calendarId", "title", "location", "desc", "timeZoneId", "insertEvent", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "deleteEvent", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/CalendarProviderApi;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CachedCalendarProviderApi implements ProviderApi, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final CalendarProviderApi providerApi;
    private final String tag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/provider/CachedCalendarProviderApi$Companion;", "", "<init>", "()V", "clean", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object clean(Context context, Continuation<? super Unit> continuation) {
            Object objWithJsonPrefs = ContextExtKt.withJsonPrefs(context, new CachedCalendarProviderApi$Companion$clean$2(null), continuation);
            return objWithJsonPrefs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithJsonPrefs : Unit.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getHolidayCalendars$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lcom/urbandroid/sleep/JsonSharedPreferences;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getHolidayCalendars$2", f = "CachedCalendarProviderApi.kt", l = {66}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<JsonSharedPreferences, Continuation<? super List<? extends GoogleCalendar>>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = CachedCalendarProviderApi.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(JsonSharedPreferences jsonSharedPreferences, Continuation<? super List<GoogleCalendar>> continuation) {
            return ((AnonymousClass2) create(jsonSharedPreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            JsonSharedPreferences jsonSharedPreferences = (JsonSharedPreferences) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Type type = new TypeToken<List<? extends GoogleCalendar>>() { // from class: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getHolidayCalendars$2$invokeSuspend$$inlined$genericType$1
                }.getType();
                CachedCalendarProviderApi cachedCalendarProviderApi = CachedCalendarProviderApi.this;
                type.getClass();
                String string = jsonSharedPreferences.getPrefs().getString("google_calendar_holiday_calendars", null);
                List list = (List) (string != null ? jsonSharedPreferences.getGson().fromJson(string, type) : null);
                if (list != null) {
                    String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(GoogleCalendarKt.anonymousIds(list), " - holiday calendars loaded from prefs");
                    Logger.logInfo(Logger.defaultTag, jsonSharedPreferences.getTag() + ": " + strM$1, null);
                    return list;
                }
                CalendarProviderApi calendarProviderApi = cachedCalendarProviderApi.providerApi;
                this.L$0 = jsonSharedPreferences;
                this.L$1 = SpillingKt.nullOutSpilledVariable(type);
                this.L$2 = "google_calendar_holiday_calendars";
                this.I$0 = 0;
                this.label = 1;
                obj = calendarProviderApi.getHolidayCalendars(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "google_calendar_holiday_calendars";
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            List list2 = (List) obj;
            jsonSharedPreferences.save(str, list2);
            String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(GoogleCalendarKt.anonymousIds(list2), " holiday calendars stored into prefs");
            Logger.logDebug(Logger.defaultTag, jsonSharedPreferences.getTag() + ": " + strM$12, null);
            return list2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(JsonSharedPreferences jsonSharedPreferences, Continuation<? super List<? extends GoogleCalendar>> continuation) {
            return invoke2(jsonSharedPreferences, (Continuation<? super List<GoogleCalendar>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getOrCreateSleepCalendar$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lcom/urbandroid/sleep/JsonSharedPreferences;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getOrCreateSleepCalendar$2", f = "CachedCalendarProviderApi.kt", l = {41}, m = "invokeSuspend", v = 2)
    public static final class C21412 extends SuspendLambda implements Function2<JsonSharedPreferences, Continuation<? super GoogleCalendar>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C21412(Continuation<? super C21412> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C21412 c21412 = CachedCalendarProviderApi.this.new C21412(continuation);
            c21412.L$0 = obj;
            return c21412;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(JsonSharedPreferences jsonSharedPreferences, Continuation<? super GoogleCalendar> continuation) {
            return ((C21412) create(jsonSharedPreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            JsonSharedPreferences jsonSharedPreferences = (JsonSharedPreferences) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Type type = new TypeToken<GoogleCalendar>() { // from class: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getOrCreateSleepCalendar$2$invokeSuspend$$inlined$genericType$1
                }.getType();
                CachedCalendarProviderApi cachedCalendarProviderApi = CachedCalendarProviderApi.this;
                type.getClass();
                String string = jsonSharedPreferences.getPrefs().getString("google_calendar_sleep_calendars_2", null);
                GoogleCalendar googleCalendar = (GoogleCalendar) (string != null ? jsonSharedPreferences.getGson().fromJson(string, type) : null);
                if (googleCalendar != null) {
                    String str2 = Logger.defaultTag;
                    Logger.logDebug(str2, jsonSharedPreferences.getTag() + ": " + (googleCalendar + " sleep calendar loaded from prefs"), null);
                    return googleCalendar;
                }
                CalendarProviderApi calendarProviderApi = cachedCalendarProviderApi.providerApi;
                this.L$0 = jsonSharedPreferences;
                this.L$1 = SpillingKt.nullOutSpilledVariable(type);
                this.L$2 = "google_calendar_sleep_calendars_2";
                this.I$0 = 0;
                this.label = 1;
                obj = calendarProviderApi.getOrCreateSleepCalendar(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "google_calendar_sleep_calendars_2";
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            GoogleCalendar googleCalendar2 = (GoogleCalendar) obj;
            if (googleCalendar2 == null) {
                return null;
            }
            jsonSharedPreferences.save(str, googleCalendar2);
            String str3 = Logger.defaultTag;
            Logger.logDebug(str3, jsonSharedPreferences.getTag() + ": " + (googleCalendar2 + " sleep calendar stored into prefs"), null);
            return googleCalendar2;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getPrimaryCalendar$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lcom/urbandroid/sleep/JsonSharedPreferences;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$getPrimaryCalendar$2", f = "CachedCalendarProviderApi.kt", l = {53}, m = "invokeSuspend", v = 2)
    public static final class C21422 extends SuspendLambda implements Function2<JsonSharedPreferences, Continuation<? super GoogleCalendar>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C21422(Continuation<? super C21422> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C21422 c21422 = CachedCalendarProviderApi.this.new C21422(continuation);
            c21422.L$0 = obj;
            return c21422;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(JsonSharedPreferences jsonSharedPreferences, Continuation<? super GoogleCalendar> continuation) {
            return ((C21422) create(jsonSharedPreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String anonymousId;
            JsonSharedPreferences jsonSharedPreferences = (JsonSharedPreferences) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CachedCalendarProviderApi cachedCalendarProviderApi = CachedCalendarProviderApi.this;
                String string = jsonSharedPreferences.getPrefs().getString("google_calendar_primary_calendar", null);
                GoogleCalendar googleCalendar = (GoogleCalendar) (string != null ? jsonSharedPreferences.getGson().fromJson(string, GoogleCalendar.class) : null);
                if (googleCalendar != null) {
                    String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(GoogleCalendarKt.getAnonymousId(googleCalendar), " primary calendar loaded from cache");
                    Logger.logInfo(Logger.defaultTag, jsonSharedPreferences.getTag() + ": " + strM$1, null);
                    return googleCalendar;
                }
                CalendarProviderApi calendarProviderApi = cachedCalendarProviderApi.providerApi;
                this.L$0 = jsonSharedPreferences;
                this.L$1 = "google_calendar_primary_calendar";
                this.I$0 = 0;
                this.label = 1;
                obj = calendarProviderApi.getPrimaryCalendar(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "google_calendar_primary_calendar";
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            GoogleCalendar googleCalendar2 = (GoogleCalendar) obj;
            jsonSharedPreferences.save(str, googleCalendar2);
            if (googleCalendar2 != null && (anonymousId = GoogleCalendarKt.getAnonymousId(googleCalendar2)) != null) {
                String strConcat = anonymousId.concat(" primary calendar stored into prefs");
                Logger.logDebug(Logger.defaultTag, jsonSharedPreferences.getTag() + ": " + strConcat, null);
            }
            return googleCalendar2;
        }
    }

    public CachedCalendarProviderApi(Context context, CalendarProviderApi calendarProviderApi) {
        context.getClass();
        calendarProviderApi.getClass();
        this.context = context;
        this.providerApi = calendarProviderApi;
        this.tag = "calendar:cache-provider";
    }

    public Object deleteEvent(GoogleCalendar.Event event, Continuation<? super Boolean> continuation) {
        return this.providerApi.deleteEvent(event, continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getEvents(GoogleCalendar googleCalendar, long j, long j2, String str, boolean z, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation) {
        return this.providerApi.getEvents(googleCalendar, j, j2, str, z, function2, continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getHolidayCalendars(Continuation<? super List<GoogleCalendar>> continuation) {
        return ContextExtKt.withJsonPrefs(this.context, new AnonymousClass2(null), continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getOrCreateSleepCalendar(Continuation<? super GoogleCalendar> continuation) {
        return ContextExtKt.withJsonPrefs(this.context, new C21412(null), continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getPrimaryCalendar(Continuation<? super GoogleCalendar> continuation) {
        return ContextExtKt.withJsonPrefs(this.context, new C21422(null), continuation);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public Object insertEvent(String str, long j, long j2, String str2, String str3, String str4, String str5, Continuation<? super String> continuation) {
        return this.providerApi.insertEvent(str, j, j2, str2, str3, str4, str5, continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getEvents(GoogleCalendar googleCalendar, long j, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation) {
        return this.providerApi.getEvents(googleCalendar, j, function2, continuation);
    }
}
