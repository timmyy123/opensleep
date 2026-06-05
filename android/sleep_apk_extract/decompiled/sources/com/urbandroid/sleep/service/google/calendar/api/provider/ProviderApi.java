package com.urbandroid.sleep.service.google.calendar.api.provider;

import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H¦@¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0007\u0010\u0004J^\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H¦@¢\u0006\u0004\b\u0013\u0010\u0014JD\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\t2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H¦@¢\u0006\u0004\b\u0013\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "getPrimaryCalendar", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getHolidayCalendars", "getOrCreateSleepCalendar", "calendar", "", "from", "to", "", "defaultTimeZoneIfNull", "", "singleEvents", "Lkotlin/Function2;", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "filter", "getEvents", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JJLjava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "time", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ProviderApi {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object getEvents$default(ProviderApi providerApi, GoogleCalendar googleCalendar, long j, long j2, String str, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            return providerApi.getEvents(googleCalendar, j, j2, str, (i & 16) != 0 ? true : z, (i & 32) != 0 ? null : function2, continuation);
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: getEvents");
        return null;
    }

    Object getEvents(GoogleCalendar googleCalendar, long j, long j2, String str, boolean z, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation);

    Object getEvents(GoogleCalendar googleCalendar, long j, Function2<? super GoogleCalendar, ? super GoogleCalendar.Event, Boolean> function2, Continuation<? super List<GoogleCalendar.Event>> continuation);

    Object getHolidayCalendars(Continuation<? super List<GoogleCalendar>> continuation);

    Object getOrCreateSleepCalendar(Continuation<? super GoogleCalendar> continuation);

    Object getPrimaryCalendar(Continuation<? super GoogleCalendar> continuation);
}
