package com.urbandroid.sleep.service.google.calendar.api.provider;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.accounts.Account;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.service.google.calendar.CalendarKt;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00050\u0005H\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n \t*\u0004\u0018\u00010\f0\fH\u0082@¢\u0006\u0004\b\r\u0010\u000bJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b\u0013\u0010\u000bJ,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0096@¢\u0006\u0004\b\u001a\u0010\u000bJZ\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00152\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0015\u0018\u00010!H\u0096@¢\u0006\u0004\b#\u0010$JB\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001c2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0015\u0018\u00010!H\u0096@¢\u0006\u0004\b#\u0010&JJ\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b,\u0010-J \u0010/\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b/\u00100J\u0018\u0010/\u001a\u00020\u00152\u0006\u00101\u001a\u00020\"H\u0096@¢\u0006\u0004\b/\u00102R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00103R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00104R\u001a\u00105\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010<\u001a\n \t*\u0004\u0018\u00010;0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\n \t*\u0004\u0018\u00010>0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/provider/CalendarProviderApi;", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "accountName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "kotlin.jvm.PlatformType", "token", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/api/services/calendar/Calendar;", "service", "name", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "createCalendar", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateSleepCalendar", "getPrimaryCalendar", "Lkotlin/Function1;", "", "filter", "", "getCalendars", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHolidayCalendars", "calendar", "", "from", "to", "defaultTimeZoneIfNull", "singleEvents", "Lkotlin/Function2;", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "getEvents", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JJLjava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "time", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calendarId", "title", "location", "desc", "timeZoneId", "insertEvent", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventId", "deleteEvent", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "Ljava/lang/String;", "tag", "getTag", "()Ljava/lang/String;", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "credential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "Lcom/google/api/client/http/HttpTransport;", "transport", "Lcom/google/api/client/http/HttpTransport;", "Lcom/google/api/client/json/jackson2/JacksonFactory;", "jsonFactory", "Lcom/google/api/client/json/jackson2/JacksonFactory;", "shift", "J", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CalendarProviderApi implements ProviderApi, FeatureLogger {
    private final String accountName;
    private final Context context;
    private final GoogleAccountCredential credential;
    private final JacksonFactory jsonFactory;
    private final long shift;
    private final String tag;
    private final HttpTransport transport;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$createCalendar$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$createCalendar$2", f = "CalendarProviderApi.kt", l = {268, 271, 289}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GoogleCalendar>, Object> {
        final /* synthetic */ String $name;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new AnonymousClass2(this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GoogleCalendar> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x0157, code lost:
        
            if (com.urbandroid.sleep.service.google.calendar.CalendarKt.recover(r12, r4, r11) != r0) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FeatureLogger featureLogger;
            CalendarProviderApi calendarProviderApi;
            UserRecoverableAuthException userRecoverableAuthException;
            Calendar calendarExecute;
            CalendarProviderApi calendarProviderApi2;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (UserRecoverableAuthException e) {
                int i2 = i;
                calendarProviderApi = calendarProviderApi2;
                try {
                    Context context = calendarProviderApi.context;
                    this.L$0 = calendarProviderApi;
                    this.L$1 = e;
                    this.I$0 = i2;
                    this.label = 2;
                } catch (Exception unused) {
                    userRecoverableAuthException = e;
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi.context, userRecoverableAuthException);
                }
            } catch (UserRecoverableAuthIOException e2) {
                try {
                    e2.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                    calendarProviderApi2.context.startActivity(e2.getIntent());
                } catch (Exception unused2) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi2.context, null);
                }
            } catch (GoogleJsonResponseException e3) {
                String strValueOf = String.valueOf(e3.getStatusCode());
                Logger.logWarning(Logger.defaultTag, calendarProviderApi2.getTag() + ": " + strValueOf, e3);
                if (e3.getStatusCode() == 401) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(e3);
                    this.L$2 = calendarProviderApi2;
                    this.I$0 = i;
                    this.label = 3;
                    obj = calendarProviderApi2.token(this);
                    if (obj != coroutine_suspended) {
                        featureLogger = calendarProviderApi2;
                    }
                    return coroutine_suspended;
                }
            } catch (Exception e4) {
                String str2 = Logger.defaultTag;
                Logger.logSevere(str2, calendarProviderApi2.getTag() + ": " + ("general failure: " + e4), null);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                calendarProviderApi2 = CalendarProviderApi.this;
                String str3 = this.$name;
                i = 0;
                this.L$0 = calendarProviderApi2;
                this.L$1 = str3;
                this.I$0 = 0;
                this.label = 1;
                Object objService = calendarProviderApi2.service(this);
                if (objService == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str3;
                obj = objService;
            } else if (i == 1) {
                i = this.I$0;
                str = (String) this.L$1;
                calendarProviderApi2 = (CalendarProviderApi) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    featureLogger = (FeatureLogger) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    String strM = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj);
                    Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
                    calendarExecute = null;
                    if (calendarExecute == null) {
                        return null;
                    }
                    CalendarProviderApi calendarProviderApi3 = CalendarProviderApi.this;
                    String strM2 = FileInsert$$ExternalSyntheticOutline0.m("calendar created - ", CalendarProviderApiKt.pretty(calendarExecute));
                    Logger.logDebug(Logger.defaultTag, calendarProviderApi3.getTag() + ": " + strM2, null);
                    return GoogleCalendarKt.toGoogleCalendar(calendarExecute, CalendarProviderApi.this.accountName);
                }
                userRecoverableAuthException = (UserRecoverableAuthException) this.L$1;
                calendarProviderApi = (CalendarProviderApi) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused3) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi.context, userRecoverableAuthException);
                }
                calendarExecute = null;
                if (calendarExecute == null) {
                }
            }
            obj.getClass();
            Calendar.Calendars calendars = ((com.google.api.services.calendar.Calendar) obj).calendars();
            com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
            calendar.setSummary(str);
            calendar.setTimeZone(TimeZone.getDefault().getID());
            calendarExecute = calendars.insert(calendar).execute();
            if (calendarExecute == null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$deleteEvent$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$deleteEvent$2", f = "CalendarProviderApi.kt", l = {269, 273, 291}, m = "invokeSuspend", v = 2)
    public static final class C21432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $calendarId;
        final /* synthetic */ String $eventId;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21432(String str, String str2, Continuation<? super C21432> continuation) {
            super(2, continuation);
            this.$eventId = str;
            this.$calendarId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new C21432(this.$eventId, this.$calendarId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C21432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01ca, code lost:
        
            if (com.urbandroid.sleep.service.google.calendar.CalendarKt.recover(r14, r3, r13) == r0) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CalendarProviderApi calendarProviderApi;
            String str;
            String str2;
            CalendarProviderApi calendarProviderApi2;
            int i;
            FeatureLogger featureLogger;
            UserRecoverableAuthException userRecoverableAuthException;
            CalendarProviderApi calendarProviderApi3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            Boolean boolBoxBoolean = null;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CalendarProviderApi calendarProviderApi4 = CalendarProviderApi.this;
                String strM = FileInsert$$ExternalSyntheticOutline0.m("deleteEvent ... ", this.$eventId);
                Logger.logDebug(Logger.defaultTag, calendarProviderApi4.getTag() + ": " + strM, null);
                calendarProviderApi = CalendarProviderApi.this;
                str = this.$calendarId;
                str2 = this.$eventId;
                try {
                    this.L$0 = calendarProviderApi;
                    this.L$1 = str;
                    this.L$2 = str2;
                    this.L$3 = calendarProviderApi;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = calendarProviderApi.service(this);
                    if (obj != coroutine_suspended) {
                        i = 0;
                        calendarProviderApi2 = calendarProviderApi;
                    }
                } catch (UserRecoverableAuthException e) {
                    e = e;
                    i = 0;
                    calendarProviderApi2 = calendarProviderApi;
                    Context context = calendarProviderApi2.context;
                    this.L$0 = calendarProviderApi2;
                    this.L$1 = e;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 2;
                } catch (UserRecoverableAuthIOException e2) {
                    e = e2;
                    calendarProviderApi2 = calendarProviderApi;
                    e.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                    calendarProviderApi2.context.startActivity(e.getIntent());
                } catch (GoogleJsonResponseException e3) {
                    e = e3;
                    i = 0;
                    calendarProviderApi2 = calendarProviderApi;
                    String strValueOf = String.valueOf(e.getStatusCode());
                    Logger.logWarning(Logger.defaultTag, calendarProviderApi2.getTag() + ": " + strValueOf, e);
                    if (e.getStatusCode() == 401) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    calendarProviderApi2 = calendarProviderApi;
                    String str3 = Logger.defaultTag;
                    Logger.logSevere(str3, calendarProviderApi2.getTag() + ": " + ("general failure: " + e), null);
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    userRecoverableAuthException = (UserRecoverableAuthException) this.L$1;
                    calendarProviderApi3 = (CalendarProviderApi) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception unused) {
                        GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, userRecoverableAuthException);
                    }
                    return Boxing.boxBoolean(boolBoxBoolean != null ? boolBoxBoolean.booleanValue() : false);
                }
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                featureLogger = (FeatureLogger) this.L$2;
                ResultKt.throwOnFailure(obj);
                String strM2 = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj);
                Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM2, null);
                return Boxing.boxBoolean(boolBoxBoolean != null ? boolBoxBoolean.booleanValue() : false);
            }
            i = this.I$0;
            calendarProviderApi = (CalendarProviderApi) this.L$3;
            str2 = (String) this.L$2;
            str = (String) this.L$1;
            calendarProviderApi2 = (CalendarProviderApi) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (UserRecoverableAuthException e5) {
                e = e5;
                try {
                    Context context2 = calendarProviderApi2.context;
                    this.L$0 = calendarProviderApi2;
                    this.L$1 = e;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 2;
                } catch (Exception unused2) {
                    userRecoverableAuthException = e;
                    calendarProviderApi3 = calendarProviderApi2;
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, userRecoverableAuthException);
                }
            } catch (UserRecoverableAuthIOException e6) {
                e = e6;
                try {
                    e.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                    calendarProviderApi2.context.startActivity(e.getIntent());
                } catch (Exception unused3) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi2.context, null);
                }
            } catch (GoogleJsonResponseException e7) {
                e = e7;
                String strValueOf2 = String.valueOf(e.getStatusCode());
                Logger.logWarning(Logger.defaultTag, calendarProviderApi2.getTag() + ": " + strValueOf2, e);
                if (e.getStatusCode() == 401) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    this.L$2 = calendarProviderApi2;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 3;
                    obj = calendarProviderApi2.token(this);
                    if (obj != coroutine_suspended) {
                        featureLogger = calendarProviderApi2;
                        String strM22 = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj);
                        Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM22, null);
                    }
                    return coroutine_suspended;
                }
            } catch (Exception e8) {
                e = e8;
                String str32 = Logger.defaultTag;
                Logger.logSevere(str32, calendarProviderApi2.getTag() + ": " + ("general failure: " + e), null);
            }
            obj.getClass();
            ((com.google.api.services.calendar.Calendar) obj).events().delete(str, str2).set("calendarId", (Object) str).set("eventId", (Object) str2).execute();
            String str4 = str + " event id: " + str2 + " deleted ";
            Logger.logInfo(Logger.defaultTag, calendarProviderApi.getTag() + ": " + str4, null);
            boolBoxBoolean = Boxing.boxBoolean(true);
            return Boxing.boxBoolean(boolBoxBoolean != null ? boolBoxBoolean.booleanValue() : false);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getCalendars$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getCalendars$2", f = "CalendarProviderApi.kt", l = {269, 279, 297}, m = "invokeSuspend", v = 2)
    public static final class C21442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GoogleCalendar>>, Object> {
        final /* synthetic */ Function1<GoogleCalendar, Boolean> $filter;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21442(Function1<? super GoogleCalendar, Boolean> function1, Continuation<? super C21442> continuation) {
            super(2, continuation);
            this.$filter = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new C21442(this.$filter, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<GoogleCalendar>> continuation) {
            return ((C21442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:64:0x01d0, code lost:
        
            if (com.urbandroid.sleep.service.google.calendar.CalendarKt.recover(r13, r2, r12) == r0) goto L65;
         */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01de  */
        /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CalendarProviderApi calendarProviderApi;
            int i;
            CalendarProviderApi calendarProviderApi2;
            Function1<GoogleCalendar, Boolean> function1;
            FeatureLogger featureLogger;
            UserRecoverableAuthException userRecoverableAuthException;
            CalendarProviderApi calendarProviderApi3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            ArrayList arrayList = null;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CalendarProviderApi calendarProviderApi4 = CalendarProviderApi.this;
                Logger.logDebug(Logger.defaultTag, calendarProviderApi4.getTag() + ": getCalendars ...", null);
                calendarProviderApi = CalendarProviderApi.this;
                Function1<GoogleCalendar, Boolean> function12 = this.$filter;
                i = 0;
                try {
                    this.L$0 = calendarProviderApi;
                    this.L$1 = calendarProviderApi;
                    this.L$2 = function12;
                    this.I$0 = 0;
                    this.label = 1;
                    Object objService = calendarProviderApi.service(this);
                    if (objService != coroutine_suspended) {
                        function1 = function12;
                        obj = objService;
                        calendarProviderApi2 = calendarProviderApi;
                    }
                } catch (UserRecoverableAuthException e) {
                    e = e;
                    calendarProviderApi2 = calendarProviderApi;
                    Context context = calendarProviderApi2.context;
                    this.L$0 = calendarProviderApi2;
                    this.L$1 = e;
                    this.L$2 = null;
                    this.I$0 = i;
                    this.label = 2;
                } catch (UserRecoverableAuthIOException e2) {
                    e = e2;
                    calendarProviderApi2 = calendarProviderApi;
                    e.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                    calendarProviderApi2.context.startActivity(e.getIntent());
                } catch (GoogleJsonResponseException e3) {
                    e = e3;
                    calendarProviderApi2 = calendarProviderApi;
                    String strValueOf = String.valueOf(e.getStatusCode());
                    Logger.logWarning(Logger.defaultTag, calendarProviderApi2.getTag() + ": " + strValueOf, e);
                    if (e.getStatusCode() == 401) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        this.L$2 = calendarProviderApi2;
                        this.I$0 = i;
                        this.label = 3;
                        obj = calendarProviderApi2.token(this);
                        if (obj != coroutine_suspended) {
                            featureLogger = calendarProviderApi2;
                            String strM = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj);
                            Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
                        }
                        return coroutine_suspended;
                    }
                } catch (Exception e4) {
                    e = e4;
                    calendarProviderApi2 = calendarProviderApi;
                    String str = Logger.defaultTag;
                    Logger.logSevere(str, calendarProviderApi2.getTag() + ": " + ("general failure: " + e), null);
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                i = this.I$0;
                function1 = (Function1) this.L$2;
                calendarProviderApi = (CalendarProviderApi) this.L$1;
                calendarProviderApi2 = (CalendarProviderApi) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (UserRecoverableAuthException e5) {
                    e = e5;
                    try {
                        Context context2 = calendarProviderApi2.context;
                        this.L$0 = calendarProviderApi2;
                        this.L$1 = e;
                        this.L$2 = null;
                        this.I$0 = i;
                        this.label = 2;
                    } catch (Exception unused) {
                        userRecoverableAuthException = e;
                        calendarProviderApi3 = calendarProviderApi2;
                        GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, userRecoverableAuthException);
                    }
                } catch (UserRecoverableAuthIOException e6) {
                    e = e6;
                    try {
                        e.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                        calendarProviderApi2.context.startActivity(e.getIntent());
                    } catch (Exception unused2) {
                        GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi2.context, null);
                    }
                } catch (GoogleJsonResponseException e7) {
                    e = e7;
                    String strValueOf2 = String.valueOf(e.getStatusCode());
                    Logger.logWarning(Logger.defaultTag, calendarProviderApi2.getTag() + ": " + strValueOf2, e);
                    if (e.getStatusCode() == 401) {
                    }
                } catch (Exception e8) {
                    e = e8;
                    String str2 = Logger.defaultTag;
                    Logger.logSevere(str2, calendarProviderApi2.getTag() + ": " + ("general failure: " + e), null);
                }
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    featureLogger = (FeatureLogger) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    String strM2 = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj);
                    Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM2, null);
                    return arrayList == null ? CollectionsKt.emptyList() : arrayList;
                }
                userRecoverableAuthException = (UserRecoverableAuthException) this.L$1;
                calendarProviderApi3 = (CalendarProviderApi) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused3) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, userRecoverableAuthException);
                }
                if (arrayList == null) {
                }
            }
            obj.getClass();
            List<CalendarListEntry> items = ((com.google.api.services.calendar.Calendar) obj).calendarList().list().execute().getItems();
            items.getClass();
            List<CalendarListEntry> list = items;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CalendarListEntry calendarListEntry : list) {
                calendarListEntry.getClass();
                arrayList2.add(GoogleCalendarKt.toGoogleCalendar(calendarListEntry, calendarProviderApi.accountName));
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                GoogleCalendar googleCalendar = (GoogleCalendar) obj2;
                if (function1 == null || function1.invoke(googleCalendar).booleanValue()) {
                    arrayList3.add(obj2);
                }
            }
            arrayList = arrayList3;
            if (arrayList == null) {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends GoogleCalendar>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<GoogleCalendar>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getEvents$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getEvents$2", f = "CalendarProviderApi.kt", l = {269, 280, 298}, m = "invokeSuspend", v = 2)
    public static final class C21452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GoogleCalendar.Event>>, Object> {
        final /* synthetic */ GoogleCalendar $calendar;
        final /* synthetic */ String $defaultTimeZoneIfNull;
        final /* synthetic */ Function2<GoogleCalendar, GoogleCalendar.Event, Boolean> $filter;
        final /* synthetic */ DateTime $max;
        final /* synthetic */ DateTime $min;
        final /* synthetic */ boolean $singleEvents;
        final /* synthetic */ TimeZone $zone;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21452(GoogleCalendar googleCalendar, DateTime dateTime, DateTime dateTime2, TimeZone timeZone, boolean z, String str, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super C21452> continuation) {
            super(2, continuation);
            this.$calendar = googleCalendar;
            this.$min = dateTime;
            this.$max = dateTime2;
            this.$zone = timeZone;
            this.$singleEvents = z;
            this.$defaultTimeZoneIfNull = str;
            this.$filter = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new C21452(this.$calendar, this.$min, this.$max, this.$zone, this.$singleEvents, this.$defaultTimeZoneIfNull, this.$filter, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<GoogleCalendar.Event>> continuation) {
            return ((C21452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x021a, code lost:
        
            if (r0 == r2) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0275, code lost:
        
            if (com.urbandroid.sleep.service.google.calendar.CalendarKt.recover(r0, r3, r16) == r2) goto L63;
         */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0282  */
        /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CalendarProviderApi calendarProviderApi;
            GoogleCalendar googleCalendar;
            boolean z;
            DateTime dateTime;
            DateTime dateTime2;
            String str;
            Function2<GoogleCalendar, GoogleCalendar.Event, Boolean> function2;
            int i;
            Object objService;
            int i2;
            GoogleJsonResponseException e;
            Object obj2;
            UserRecoverableAuthException e2;
            CalendarProviderApi calendarProviderApi2;
            FeatureLogger featureLogger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            List listSortedWith = null;
            try {
            } catch (UserRecoverableAuthIOException e3) {
                try {
                    e3.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                    calendarProviderApi.context.startActivity(e3.getIntent());
                } catch (Exception unused) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi.context, null);
                }
            } catch (Exception e4) {
                String str2 = Logger.defaultTag;
                Logger.logSevere(str2, calendarProviderApi.getTag() + ": " + ("general failure: " + e4), null);
            }
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CalendarProviderApi calendarProviderApi3 = CalendarProviderApi.this;
                String id = this.$calendar.getId();
                String stringRfc3339 = this.$min.toStringRfc3339();
                String stringRfc33392 = this.$max.toStringRfc3339();
                String timezone = this.$calendar.getTimezone();
                String id2 = this.$zone.getID();
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("getEvents ... ", id, " from: ", stringRfc3339, " to: ");
                FileInsert$$ExternalSyntheticOutline0.m(sbM6m, stringRfc33392, " ", timezone, " ");
                sbM6m.append(id2);
                String string = sbM6m.toString();
                Logger.logDebug(Logger.defaultTag, calendarProviderApi3.getTag() + ": " + string, null);
                calendarProviderApi = CalendarProviderApi.this;
                googleCalendar = this.$calendar;
                z = this.$singleEvents;
                dateTime = this.$min;
                dateTime2 = this.$max;
                str = this.$defaultTimeZoneIfNull;
                function2 = this.$filter;
                i = 0;
                try {
                    this.L$0 = calendarProviderApi;
                    this.L$1 = googleCalendar;
                    this.L$2 = dateTime;
                    this.L$3 = dateTime2;
                    this.L$4 = str;
                    this.L$5 = function2;
                    this.Z$0 = z;
                    this.I$0 = 0;
                    this.label = 1;
                    objService = calendarProviderApi.service(this);
                    calendarProviderApi = calendarProviderApi;
                } catch (UserRecoverableAuthException e5) {
                    e2 = e5;
                    i2 = i;
                    Context context = calendarProviderApi.context;
                    this.L$0 = calendarProviderApi;
                    this.L$1 = e2;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = i2;
                    this.label = 2;
                } catch (GoogleJsonResponseException e6) {
                    e = e6;
                    i2 = i;
                    String strValueOf = String.valueOf(e.getStatusCode());
                    Logger.logWarning(Logger.defaultTag, calendarProviderApi.getTag() + ": " + strValueOf, e);
                    if (e.getStatusCode() == 401) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        this.L$2 = calendarProviderApi;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = i2;
                        this.label = 3;
                        obj2 = calendarProviderApi.token(this);
                        featureLogger = calendarProviderApi;
                    }
                }
                if (objService == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                i2 = this.I$0;
                z = this.Z$0;
                function2 = (Function2) this.L$5;
                str = (String) this.L$4;
                dateTime2 = (DateTime) this.L$3;
                dateTime = (DateTime) this.L$2;
                googleCalendar = (GoogleCalendar) this.L$1;
                calendarProviderApi = (CalendarProviderApi) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i2;
                    objService = obj;
                    calendarProviderApi = calendarProviderApi;
                } catch (UserRecoverableAuthException e7) {
                    e2 = e7;
                    try {
                        Context context2 = calendarProviderApi.context;
                        this.L$0 = calendarProviderApi;
                        this.L$1 = e2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = i2;
                        this.label = 2;
                    } catch (Exception unused2) {
                        calendarProviderApi2 = calendarProviderApi;
                        GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi2.context, e2);
                    }
                } catch (GoogleJsonResponseException e8) {
                    e = e8;
                    String strValueOf2 = String.valueOf(e.getStatusCode());
                    Logger.logWarning(Logger.defaultTag, calendarProviderApi.getTag() + ": " + strValueOf2, e);
                    if (e.getStatusCode() == 401) {
                    }
                }
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    FeatureLogger featureLogger2 = (FeatureLogger) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    featureLogger = featureLogger2;
                    obj2 = obj;
                    String strM = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj2);
                    Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
                    return listSortedWith == null ? CollectionsKt.emptyList() : listSortedWith;
                }
                e2 = (UserRecoverableAuthException) this.L$1;
                calendarProviderApi2 = (CalendarProviderApi) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused3) {
                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi2.context, e2);
                }
                if (listSortedWith == null) {
                }
            }
            objService.getClass();
            List<Event> items = ((com.google.api.services.calendar.Calendar) objService).events().list(googleCalendar.getId()).set("calendarId", (Object) googleCalendar.getId()).set("maxResults", (Object) Boxing.boxInt(100)).set("orderBy", (Object) (z ? "startTime" : "updated")).set("singleEvents", (Object) Boxing.boxBoolean(z)).set("timeMin", (Object) dateTime).set("timeMax", (Object) dateTime2).execute().getItems();
            items.getClass();
            List<Event> list = items;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Event event : list) {
                event.getClass();
                arrayList.add(GoogleCalendarKt.toEvent(event, googleCalendar.getId(), str));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                GoogleCalendar.Event event2 = (GoogleCalendar.Event) obj3;
                if (function2 == null || function2.invoke(googleCalendar, event2).booleanValue()) {
                    arrayList2.add(obj3);
                }
            }
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getEvents$2$invokeSuspend$lambda$0$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((GoogleCalendar.Event) t).getStart()), Long.valueOf(((GoogleCalendar.Event) t2).getStart()));
                }
            });
            if (listSortedWith == null) {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends GoogleCalendar.Event>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<GoogleCalendar.Event>>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getOrCreateSleepCalendar$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi", f = "CalendarProviderApi.kt", l = {124, 129}, m = "getOrCreateSleepCalendar", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CalendarProviderApi.this.getOrCreateSleepCalendar(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$getPrimaryCalendar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi", f = "CalendarProviderApi.kt", l = {133}, m = "getPrimaryCalendar", v = 2)
    public static final class C21461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21461(Continuation<? super C21461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CalendarProviderApi.this.getPrimaryCalendar(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$insertEvent$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$insertEvent$2", f = "CalendarProviderApi.kt", l = {269, 273, 291}, m = "invokeSuspend", v = 2)
    public static final class C21472 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $calendarId;
        final /* synthetic */ String $desc;
        final /* synthetic */ long $from;
        final /* synthetic */ String $location;
        final /* synthetic */ String $timeZoneId;
        final /* synthetic */ String $title;
        final /* synthetic */ long $to;
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21472(long j, long j2, String str, String str2, String str3, String str4, String str5, Continuation<? super C21472> continuation) {
            super(2, continuation);
            this.$from = j;
            this.$to = j2;
            this.$title = str;
            this.$location = str2;
            this.$desc = str3;
            this.$calendarId = str4;
            this.$timeZoneId = str5;
        }

        private static final EventDateTime invokeSuspend$toEventDateTime(long j, String str) {
            return new EventDateTime().setDateTime(new DateTime(j)).setTimeZone(str);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new C21472(this.$from, this.$to, this.$title, this.$location, this.$desc, this.$calendarId, this.$timeZoneId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C21472) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x0235, code lost:
        
            if (r0 == r3) goto L71;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x025a A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x029e A[RETURN] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            String str;
            String str2;
            long j;
            long j2;
            String str3;
            String str4;
            String str5;
            int i;
            Object obj3;
            int i2;
            Object objService;
            int i3;
            String str6;
            String str7;
            CalendarProviderApi calendarProviderApi;
            CalendarProviderApi calendarProviderApi2;
            CalendarProviderApi calendarProviderApi3;
            Context context;
            CalendarProviderApi calendarProviderApi4;
            CalendarProviderApi calendarProviderApi5;
            CalendarProviderApi calendarProviderApi6;
            Object obj4;
            CalendarProviderApi calendarProviderApi7;
            CalendarProviderApi calendarProviderApi8;
            FeatureLogger featureLogger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            CalendarProviderApi id = this.label;
            try {
                if (id == 0) {
                    ResultKt.throwOnFailure(obj);
                    CalendarProviderApi calendarProviderApi9 = CalendarProviderApi.this;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("inserting - ", Utils.getPrettyDate(this.$from), " ", Utils.getPrettyDate(this.$to), " ...");
                    Logger.logDebug(Logger.defaultTag, calendarProviderApi9.getTag() + ": " + strM, null);
                    CalendarProviderApi calendarProviderApi10 = CalendarProviderApi.this;
                    String str8 = this.$title;
                    str = this.$location;
                    str2 = this.$desc;
                    j = this.$from;
                    j2 = this.$to;
                    str3 = this.$calendarId;
                    String str9 = this.$timeZoneId;
                    str4 = ": ";
                    try {
                        try {
                            this.L$0 = calendarProviderApi10;
                        } catch (UserRecoverableAuthException e) {
                            e = e;
                            obj3 = null;
                            i2 = 0;
                            calendarProviderApi2 = calendarProviderApi10;
                            context = calendarProviderApi2.context;
                            this.L$0 = calendarProviderApi2;
                            this.L$1 = e;
                            this.L$2 = obj3;
                            this.L$3 = obj3;
                            this.L$4 = obj3;
                            this.L$5 = obj3;
                            this.L$6 = obj3;
                            this.I$0 = i2;
                            this.label = 2;
                            if (CalendarKt.recover(e, context, this) == coroutine_suspended) {
                                return null;
                            }
                        }
                        try {
                            this.L$1 = str8;
                            this.L$2 = str;
                            this.L$3 = str2;
                            this.L$4 = str3;
                            this.L$5 = str9;
                            this.L$6 = calendarProviderApi10;
                            this.J$0 = j;
                            this.J$1 = j2;
                            this.I$0 = 0;
                            this.label = 1;
                            objService = calendarProviderApi10.service(this);
                            if (objService != coroutine_suspended) {
                                CalendarProviderApi calendarProviderApi11 = calendarProviderApi10;
                                i3 = 0;
                                str6 = str8;
                                str7 = str9;
                                calendarProviderApi = calendarProviderApi11;
                                calendarProviderApi8 = calendarProviderApi11;
                                objService.getClass();
                                Event end = new Event().setSummary(str6).setLocation(str).setDescription(str2).setStart(invokeSuspend$toEventDateTime(j, str7)).setEnd(invokeSuspend$toEventDateTime(j2, str7));
                                id = ((com.google.api.services.calendar.Calendar) objService).events().insert(str3, end).set("calendarId", (Object) str3).set("content", (Object) end).execute().getId();
                                String str10 = "inserted newId: " + ((String) id) + " " + Utils.getPrettyDate(j) + MqttTopic.TOPIC_LEVEL_SEPARATOR + Utils.getPrettyDate(j2) + "\t" + j + MqttTopic.TOPIC_LEVEL_SEPARATOR + j2;
                                String str11 = Logger.defaultTag;
                                StringBuilder sb = new StringBuilder();
                                sb.append(calendarProviderApi.getTag());
                                str5 = str4;
                                sb.append(str5);
                                sb.append(str10);
                                Logger.logInfo(str11, sb.toString(), null);
                                return id;
                            }
                        } catch (UserRecoverableAuthException e2) {
                            e = e2;
                            i2 = 0;
                            calendarProviderApi4 = calendarProviderApi10;
                            obj3 = null;
                            calendarProviderApi2 = calendarProviderApi4;
                            context = calendarProviderApi2.context;
                            this.L$0 = calendarProviderApi2;
                            this.L$1 = e;
                            this.L$2 = obj3;
                            this.L$3 = obj3;
                            this.L$4 = obj3;
                            this.L$5 = obj3;
                            this.L$6 = obj3;
                            this.I$0 = i2;
                            this.label = 2;
                            if (CalendarKt.recover(e, context, this) == coroutine_suspended) {
                            }
                        }
                    } catch (GoogleJsonResponseException e3) {
                        e = e3;
                        str5 = str4;
                        i = 0;
                        calendarProviderApi6 = calendarProviderApi10;
                        String strValueOf = String.valueOf(e.getStatusCode());
                        Logger.logWarning(Logger.defaultTag, calendarProviderApi6.getTag() + str5 + strValueOf, e);
                        if (e.getStatusCode() == 401) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi6);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                            this.L$2 = calendarProviderApi6;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i;
                            this.label = 3;
                            obj4 = calendarProviderApi6.token(this);
                            featureLogger = calendarProviderApi6;
                        }
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        str5 = str4;
                        calendarProviderApi5 = calendarProviderApi10;
                        String str12 = Logger.defaultTag;
                        obj2 = null;
                        Logger.logSevere(str12, calendarProviderApi5.getTag() + str5 + ("general failure: " + e), null);
                        return obj2;
                    }
                    return coroutine_suspended;
                }
                if (id == 1) {
                    int i4 = this.I$0;
                    j2 = this.J$1;
                    j = this.J$0;
                    CalendarProviderApi calendarProviderApi12 = (CalendarProviderApi) this.L$6;
                    String str13 = (String) this.L$5;
                    String str14 = (String) this.L$4;
                    String str15 = (String) this.L$3;
                    str = (String) this.L$2;
                    i3 = i4;
                    String str16 = (String) this.L$1;
                    CalendarProviderApi calendarProviderApi13 = (CalendarProviderApi) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objService = obj;
                        calendarProviderApi8 = calendarProviderApi13;
                        str6 = str16;
                        str4 = ": ";
                        str2 = str15;
                        str7 = str13;
                        str3 = str14;
                        calendarProviderApi = calendarProviderApi12;
                        try {
                            try {
                                objService.getClass();
                                Event end2 = new Event().setSummary(str6).setLocation(str).setDescription(str2).setStart(invokeSuspend$toEventDateTime(j, str7)).setEnd(invokeSuspend$toEventDateTime(j2, str7));
                                id = ((com.google.api.services.calendar.Calendar) objService).events().insert(str3, end2).set("calendarId", (Object) str3).set("content", (Object) end2).execute().getId();
                                String str102 = "inserted newId: " + ((String) id) + " " + Utils.getPrettyDate(j) + MqttTopic.TOPIC_LEVEL_SEPARATOR + Utils.getPrettyDate(j2) + "\t" + j + MqttTopic.TOPIC_LEVEL_SEPARATOR + j2;
                                String str112 = Logger.defaultTag;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(calendarProviderApi.getTag());
                                str5 = str4;
                                try {
                                    sb2.append(str5);
                                    sb2.append(str102);
                                    Logger.logInfo(str112, sb2.toString(), null);
                                    return id;
                                } catch (GoogleJsonResponseException e5) {
                                    e = e5;
                                    calendarProviderApi7 = calendarProviderApi8;
                                    i = i3;
                                    calendarProviderApi6 = calendarProviderApi7;
                                    String strValueOf2 = String.valueOf(e.getStatusCode());
                                    Logger.logWarning(Logger.defaultTag, calendarProviderApi6.getTag() + str5 + strValueOf2, e);
                                    if (e.getStatusCode() == 401) {
                                    }
                                    return null;
                                } catch (Exception e6) {
                                    e = e6;
                                    calendarProviderApi5 = calendarProviderApi8;
                                    String str122 = Logger.defaultTag;
                                    obj2 = null;
                                    Logger.logSevere(str122, calendarProviderApi5.getTag() + str5 + ("general failure: " + e), null);
                                    return obj2;
                                }
                            } catch (UserRecoverableAuthException e7) {
                                e = e7;
                                calendarProviderApi13 = calendarProviderApi8;
                                i2 = i3;
                                calendarProviderApi4 = calendarProviderApi13;
                                obj3 = null;
                                calendarProviderApi2 = calendarProviderApi4;
                                try {
                                    context = calendarProviderApi2.context;
                                    this.L$0 = calendarProviderApi2;
                                    this.L$1 = e;
                                    this.L$2 = obj3;
                                    this.L$3 = obj3;
                                    this.L$4 = obj3;
                                    this.L$5 = obj3;
                                    this.L$6 = obj3;
                                    this.I$0 = i2;
                                    this.label = 2;
                                    if (CalendarKt.recover(e, context, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (Exception unused) {
                                    calendarProviderApi3 = calendarProviderApi2;
                                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, e);
                                }
                            } catch (UserRecoverableAuthIOException e8) {
                                e = e8;
                                id = calendarProviderApi8;
                                try {
                                    e.getIntent().addFlags(ClientDefaults.MAX_MSG_SIZE);
                                    id.context.startActivity(e.getIntent());
                                    obj2 = null;
                                } catch (Exception unused2) {
                                    obj2 = null;
                                    GoogleCalendarNotifierKt.calendarPermissionMissingNotification(id.context, null);
                                }
                                return obj2;
                            }
                        } catch (GoogleJsonResponseException e9) {
                            e = e9;
                            str5 = str4;
                        } catch (Exception e10) {
                            e = e10;
                            str5 = str4;
                        }
                    } catch (UserRecoverableAuthException e11) {
                        e = e11;
                        i2 = i3;
                        calendarProviderApi4 = calendarProviderApi13;
                        obj3 = null;
                        calendarProviderApi2 = calendarProviderApi4;
                        context = calendarProviderApi2.context;
                        this.L$0 = calendarProviderApi2;
                        this.L$1 = e;
                        this.L$2 = obj3;
                        this.L$3 = obj3;
                        this.L$4 = obj3;
                        this.L$5 = obj3;
                        this.L$6 = obj3;
                        this.I$0 = i2;
                        this.label = 2;
                        if (CalendarKt.recover(e, context, this) == coroutine_suspended) {
                        }
                    } catch (GoogleJsonResponseException e12) {
                        e = e12;
                        str5 = ": ";
                        calendarProviderApi7 = calendarProviderApi13;
                        i = i3;
                        calendarProviderApi6 = calendarProviderApi7;
                        String strValueOf22 = String.valueOf(e.getStatusCode());
                        Logger.logWarning(Logger.defaultTag, calendarProviderApi6.getTag() + str5 + strValueOf22, e);
                        if (e.getStatusCode() == 401) {
                        }
                        return null;
                    } catch (Exception e13) {
                        e = e13;
                        str5 = ": ";
                        calendarProviderApi5 = calendarProviderApi13;
                        String str1222 = Logger.defaultTag;
                        obj2 = null;
                        Logger.logSevere(str1222, calendarProviderApi5.getTag() + str5 + ("general failure: " + e), null);
                        return obj2;
                    }
                } else if (id == 2) {
                    e = (UserRecoverableAuthException) this.L$1;
                    calendarProviderApi3 = (CalendarProviderApi) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception unused3) {
                        GoogleCalendarNotifierKt.calendarPermissionMissingNotification(calendarProviderApi3.context, e);
                    }
                } else {
                    if (id != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    FeatureLogger featureLogger2 = (FeatureLogger) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    featureLogger = featureLogger2;
                    str5 = ": ";
                    obj4 = obj;
                    String strM2 = Fragment$$ExternalSyntheticOutline1.m("most probably expired token: ", obj4);
                    Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + str5 + strM2, null);
                }
                return null;
            } catch (UserRecoverableAuthIOException e14) {
                e = e14;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$service$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi", f = "CalendarProviderApi.kt", l = {76}, m = "service", v = 2)
    public static final class C21481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C21481(Continuation<? super C21481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CalendarProviderApi.this.service(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$token$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi$token$2", f = "CalendarProviderApi.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C21492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        public C21492(Continuation<? super C21492> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CalendarProviderApi.this.new C21492(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C21492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return CalendarProviderApi.this.credential.getToken();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    public CalendarProviderApi(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.accountName = str;
        this.tag = "calendar:api";
        GoogleAccountCredential backOff = GoogleAccountCredential.usingOAuth2(context, CollectionsKt.listOf((Object[]) new String[]{"https://www.googleapis.com/auth/calendar.events.freebusy", "https://www.googleapis.com/auth/calendar.freebusy", "https://www.googleapis.com/auth/calendar.events.public.readonly", "https://www.googleapis.com/auth/calendar.app.created", "https://www.googleapis.com/auth/calendar.calendarlist.readonly"})).setSelectedAccount(new Account(str, "com.google")).setBackOff(new ExponentialBackOff());
        backOff.getClass();
        this.credential = backOff;
        this.transport = AndroidHttp.newCompatibleTransport();
        this.jsonFactory = JacksonFactory.getDefaultInstance();
        this.shift = 14L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHolidayCalendars$lambda$0(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        return StringsKt__StringsJVMKt.endsWith$default(googleCalendar.getId(), "#holiday@group.v.calendar.google.com", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOrCreateSleepCalendar$lambda$0(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        return Intrinsics.areEqual(googleCalendar.getDisplayName(), "Sleep as Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPrimaryCalendar$lambda$0(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        return Intrinsics.areEqual(googleCalendar.getId(), googleCalendar.getAccountName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object service(Continuation<? super com.google.api.services.calendar.Calendar> continuation) {
        C21481 c21481;
        Context context;
        Calendar.Builder builder;
        String str;
        if (continuation instanceof C21481) {
            c21481 = (C21481) continuation;
            int i = c21481.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21481.label = i - Integer.MIN_VALUE;
            } else {
                c21481 = new C21481(continuation);
            }
        }
        Object obj = c21481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21481.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Calendar.Builder builder2 = new Calendar.Builder(this.transport, this.jsonFactory, this.credential);
            context = this.context;
            String string = StringsKt___StringsKt.reversed("UZCaa4g1krJtiLfN5oI0CiGSn0c3hc4lDySazIA").toString();
            c21481.L$0 = builder2;
            c21481.L$1 = context;
            c21481.L$2 = string;
            c21481.label = 1;
            Object obj2 = token(c21481);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            builder = builder2;
            obj = obj2;
            str = string;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = (String) c21481.L$2;
            context = (Context) c21481.L$1;
            builder = (Calendar.Builder) c21481.L$0;
            ResultKt.throwOnFailure(obj);
        }
        obj.getClass();
        return builder.setCalendarRequestInitializer(new GoogleCalendarRequestInitializer(context, str, (String) obj)).setApplicationName(this.context.getString(R.string.app_name_long)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object token(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C21492(null), continuation);
    }

    public Object createCalendar(String str, Continuation<? super GoogleCalendar> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, null), continuation);
    }

    public Object deleteEvent(String str, String str2, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C21432(str2, str, null), continuation);
    }

    public final Object getCalendars(Function1<? super GoogleCalendar, Boolean> function1, Continuation<? super List<GoogleCalendar>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C21442(function1, null), continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getEvents(GoogleCalendar googleCalendar, long j, long j2, String str, boolean z, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation) {
        String timezone = googleCalendar.getTimezone();
        if (timezone == null) {
            timezone = str;
        }
        TimeZone timeZone = DesugarTimeZone.getTimeZone(timezone);
        return BuildersKt.withContext(Dispatchers.getIO(), new C21452(googleCalendar, new DateTime(j, (timeZone.getOffset(j) / 1000) / 60), new DateTime(j2, (timeZone.getOffset(j2) / 1000) / 60), timeZone, z, str, function2, null), continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getHolidayCalendars(Continuation<? super List<GoogleCalendar>> continuation) {
        return getCalendars(new AiPrompt$$ExternalSyntheticLambda0(26), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
    
        if (r7 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getOrCreateSleepCalendar(Continuation<? super GoogleCalendar> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object calendars = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(calendars);
            Function1<? super GoogleCalendar, Boolean> aiPrompt$$ExternalSyntheticLambda0 = new AiPrompt$$ExternalSyntheticLambda0(27);
            anonymousClass1.label = 1;
            calendars = getCalendars(aiPrompt$$ExternalSyntheticLambda0, anonymousClass1);
            if (calendars != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(calendars);
            return (GoogleCalendar) calendars;
        }
        ResultKt.throwOnFailure(calendars);
        GoogleCalendar googleCalendar = (GoogleCalendar) CollectionsKt.firstOrNull((List) calendars);
        if (googleCalendar != null) {
            String str = Logger.defaultTag;
            Logger.logInfo(str, getTag() + ": " + ("Calendar Sleep as Android found " + googleCalendar), null);
            return googleCalendar;
        }
        Logger.logDebug(Logger.defaultTag, getTag() + ": Calendar Sleep as Android not found - trying to create new one ...", null);
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(this);
        anonymousClass1.I$0 = 0;
        anonymousClass1.label = 2;
        calendars = createCalendar("Sleep as Android", anonymousClass1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPrimaryCalendar(Continuation<? super GoogleCalendar> continuation) {
        C21461 c21461;
        if (continuation instanceof C21461) {
            c21461 = (C21461) continuation;
            int i = c21461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21461.label = i - Integer.MIN_VALUE;
            } else {
                c21461 = new C21461(continuation);
            }
        }
        Object calendars = c21461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21461.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(calendars);
            Function1<? super GoogleCalendar, Boolean> aiPrompt$$ExternalSyntheticLambda0 = new AiPrompt$$ExternalSyntheticLambda0(25);
            c21461.label = 1;
            calendars = getCalendars(aiPrompt$$ExternalSyntheticLambda0, c21461);
            if (calendars == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(calendars);
        }
        return CollectionsKt.firstOrNull((List) calendars);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public Object insertEvent(String str, long j, long j2, String str2, String str3, String str4, String str5, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C21472(j, j2, str2, str3, str4, str, str5, null), continuation);
    }

    public Object deleteEvent(GoogleCalendar.Event event, Continuation<? super Boolean> continuation) {
        return deleteEvent(event.getCalendarId(), event.getEventId(), continuation);
    }

    @Override // com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi
    public Object getEvents(GoogleCalendar googleCalendar, long j, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation) {
        long j2 = this.shift;
        TimeUnit timeUnit = TimeUnit.DAYS;
        return getEvents(googleCalendar, j - timeUnit.toMillis(j2), timeUnit.toMillis(this.shift) + j, CalendarKt.getTIMEZONE_DEFAULT(), false, function2, continuation);
    }
}
