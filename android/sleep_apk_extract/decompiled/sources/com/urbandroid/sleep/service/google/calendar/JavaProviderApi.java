package com.urbandroid.sleep.service.google.calendar;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/JavaProviderApi;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "api", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;)V", "getEvents", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "calendar", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "from", "", "to", "filter", "Lcom/urbandroid/sleep/service/google/calendar/JavaProviderApi$EventFilter;", "EventFilter", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaProviderApi {
    private final ProviderApi api;
    private final Context context;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/JavaProviderApi$EventFilter;", "", "apply", "", "calendar", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface EventFilter {
        boolean apply(GoogleCalendar calendar, GoogleCalendar.Event event);
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.JavaProviderApi$getEvents$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.JavaProviderApi$getEvents$1", f = "javahelpers.kt", l = {37}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GoogleCalendar.Event>>, Object> {
        final /* synthetic */ GoogleCalendar $calendar;
        final /* synthetic */ long $from;
        final /* synthetic */ long $to;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GoogleCalendar googleCalendar, long j, long j2, EventFilter eventFilter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$calendar = googleCalendar;
            this.$from = j;
            this.$to = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(EventFilter eventFilter, GoogleCalendar googleCalendar, GoogleCalendar.Event event) {
            return eventFilter == null || eventFilter.apply(googleCalendar, event);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaProviderApi.this.new AnonymousClass1(this.$calendar, this.$from, this.$to, null, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<GoogleCalendar.Event>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object events$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProviderApi providerApi = JavaProviderApi.this.api;
                    GoogleCalendar googleCalendar = this.$calendar;
                    long j = this.$from;
                    long j2 = this.$to;
                    String timezone_default = CalendarKt.getTIMEZONE_DEFAULT();
                    JavaProviderApi$getEvents$1$$ExternalSyntheticLambda0 javaProviderApi$getEvents$1$$ExternalSyntheticLambda0 = new JavaProviderApi$getEvents$1$$ExternalSyntheticLambda0();
                    this.label = 1;
                    events$default = ProviderApi.getEvents$default(providerApi, googleCalendar, j, j2, timezone_default, false, javaProviderApi$getEvents$1$$ExternalSyntheticLambda0, this, 16, null);
                    if (events$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    events$default = obj;
                }
                return (List) events$default;
            } catch (UserRecoverableAuthException e) {
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(JavaProviderApi.this.context, e);
                return CollectionsKt.emptyList();
            } catch (Exception e2) {
                Logger.logSevere("getEvents failure", e2);
                return CollectionsKt.emptyList();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends GoogleCalendar.Event>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<GoogleCalendar.Event>>) continuation);
        }
    }

    public JavaProviderApi(Context context, ProviderApi providerApi) {
        context.getClass();
        providerApi.getClass();
        this.context = context;
        this.api = providerApi;
    }

    public final List<GoogleCalendar.Event> getEvents(GoogleCalendar calendar, long from, long to, EventFilter filter) {
        calendar.getClass();
        return (List) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass1(calendar, from, to, filter, null), 1, null);
    }
}
