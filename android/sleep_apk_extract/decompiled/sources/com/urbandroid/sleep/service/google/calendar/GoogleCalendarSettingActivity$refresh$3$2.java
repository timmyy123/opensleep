package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.google.calendar.alarm.ProcessedCalendarEventMap;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$3$2", f = "GoogleCalendarSettingActivity.kt", l = {174, 182}, m = "invokeSuspend", v = 2)
public final class GoogleCalendarSettingActivity$refresh$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GoogleCalendarSettingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSettingActivity$refresh$3$2(GoogleCalendarSettingActivity googleCalendarSettingActivity, Continuation<? super GoogleCalendarSettingActivity$refresh$3$2> continuation) {
        super(2, continuation);
        this.this$0 = googleCalendarSettingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleCalendarSettingActivity$refresh$3$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleCalendarSettingActivity$refresh$3$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        if (r8 == r0) goto L35;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        CachedCalendarProviderApi cachedCalendarProviderApi = null;
        try {
            try {
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
            }
        } catch (Exception e2) {
            Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e2);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CachedCalendarProviderApi cachedCalendarProviderApi2 = this.this$0.calendarProvider;
            if (cachedCalendarProviderApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarProvider");
                cachedCalendarProviderApi2 = null;
            }
            this.label = 1;
            obj = cachedCalendarProviderApi2.getHolidayCalendars(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                GoogleCalendar googleCalendar = (GoogleCalendar) obj;
                if (googleCalendar != null) {
                    ProcessedCalendarEventMap.reset(this.this$0.getApplicationContext(), ProcessedCalendarEventMap.Type.HOLIDAY, googleCalendar);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            ProcessedCalendarEventMap.reset(this.this$0.getApplicationContext(), ProcessedCalendarEventMap.Type.HOLIDAY, (GoogleCalendar) it.next());
        }
        CachedCalendarProviderApi cachedCalendarProviderApi3 = this.this$0.calendarProvider;
        if (cachedCalendarProviderApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarProvider");
        } else {
            cachedCalendarProviderApi = cachedCalendarProviderApi3;
        }
        this.label = 2;
        obj = cachedCalendarProviderApi.getPrimaryCalendar(this);
    }
}
