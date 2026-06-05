package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/JavaGoogleCalendarAlarmManager;", "Lcom/urbandroid/common/FeatureLogger;", "manager", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager;", "<init>", "(Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager;)V", "tag", "", "getTag", "()Ljava/lang/String;", "check", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarAlarmManager$Result;", "alarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "(Lcom/urbandroid/sleep/alarmclock/Alarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaGoogleCalendarAlarmManager implements FeatureLogger {
    private final GoogleCalendarAlarmManager manager;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.JavaGoogleCalendarAlarmManager$check$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.JavaGoogleCalendarAlarmManager", f = "javahelpers.kt", l = {62, 66}, m = "check", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JavaGoogleCalendarAlarmManager.this.check(null, this);
        }
    }

    public JavaGoogleCalendarAlarmManager(GoogleCalendarAlarmManager googleCalendarAlarmManager) {
        googleCalendarAlarmManager.getClass();
        this.manager = googleCalendarAlarmManager;
        this.tag = "calendar:check";
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c0, code lost:
    
        if (r11 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x012a, code lost:
    
        if (r11 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x012c, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object check(Alarm alarm, Continuation<? super GoogleCalendarAlarmManager.Result> continuation) {
        AnonymousClass1 anonymousClass1;
        GoogleCalendarAlarmManager.Result result;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAdvanceAlarmIfEvent = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAdvanceAlarmIfEvent);
            String str = "Checking events for alarm " + alarm.id + " " + CalendarKt.prettyDate$default(alarm.time, null, 1, null);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            if (!ContextExtKt.hasConnectivity(this.manager.getContext())) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": no connectivity", null);
                return null;
            }
            if (this.manager.getSettings().isGoogleCalendarEvent()) {
                GoogleCalendarAlarmManager googleCalendarAlarmManager = this.manager;
                anonymousClass1.L$0 = alarm;
                anonymousClass1.label = 1;
                objAdvanceAlarmIfEvent = googleCalendarAlarmManager.advanceAlarmIfEvent(alarm, anonymousClass1);
            } else {
                result = null;
                if (alarm.getDaysOfWeek().isRepeatSet()) {
                    return result;
                }
                if (result != null && !CollectionsKt.listOf((Object[]) new GoogleCalendarAlarmManager.Result.Code[]{GoogleCalendarAlarmManager.Result.Code.ALARM_NOT_TOUCHED, GoogleCalendarAlarmManager.Result.Code.EVENT_ALREADY_PROCESSED, GoogleCalendarAlarmManager.Result.Code.NO_EVENT_FOUND, GoogleCalendarAlarmManager.Result.Code.CALENDAR_NOT_FOUND}).contains(result.getCode())) {
                    return result;
                }
                GoogleCalendarAlarmManager googleCalendarAlarmManager2 = this.manager;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(alarm);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.label = 2;
                objAdvanceAlarmIfEvent = googleCalendarAlarmManager2.skipNextIfHoliday(alarm, anonymousClass1);
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAdvanceAlarmIfEvent);
                GoogleCalendarAlarmManager.Result result2 = (GoogleCalendarAlarmManager.Result) objAdvanceAlarmIfEvent;
                String str2 = Logger.defaultTag;
                Logger.logInfo(str2, getTag() + ": " + ("Calendar Holiday check: " + result2), null);
                return result2;
            }
            alarm = (Alarm) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAdvanceAlarmIfEvent);
        }
        result = (GoogleCalendarAlarmManager.Result) objAdvanceAlarmIfEvent;
        String str3 = Logger.defaultTag;
        Logger.logInfo(str3, getTag() + ": " + ("Main Calendar event check: " + result), null);
        if (alarm.getDaysOfWeek().isRepeatSet()) {
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
