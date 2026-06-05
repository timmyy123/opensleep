package com.urbandroid.sleep.service.google.calendar;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.google.calendar.alarm.MondayFridayWorkingDaysPolicy;
import com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, d2 = {"resolveSleepCalendar", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/ProviderApi;", "checkCalendarEvents", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "calendarAccount", "", "alarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "googleCalendarAlarmManager", "Lcom/urbandroid/sleep/service/google/calendar/JavaGoogleCalendarAlarmManager;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class JavahelpersKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.JavahelpersKt$checkCalendarEvents$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.JavahelpersKt$checkCalendarEvents$1", f = "javahelpers.kt", l = {76}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Alarm $alarm;
        final /* synthetic */ String $calendarAccount;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, String str, Alarm alarm, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$calendarAccount = str;
            this.$alarm = alarm;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$calendarAccount, this.$alarm, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    JavaGoogleCalendarAlarmManager javaGoogleCalendarAlarmManagerGoogleCalendarAlarmManager = JavahelpersKt.googleCalendarAlarmManager(this.$context, this.$calendarAccount);
                    Alarm alarm = this.$alarm;
                    this.label = 1;
                    Object objCheck = javaGoogleCalendarAlarmManagerGoogleCalendarAlarmManager.check(alarm, this);
                    this = objCheck;
                    if (objCheck == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (UserRecoverableAuthException e) {
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(this.$context, e);
            } catch (Exception e2) {
                Logger.logSevere("checkCalendarEvents failure", e2);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.JavahelpersKt$resolveSleepCalendar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.JavahelpersKt$resolveSleepCalendar$1", f = "javahelpers.kt", l = {21}, m = "invokeSuspend", v = 2)
    public static final class C21391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GoogleCalendar>, Object> {
        final /* synthetic */ ProviderApi $this_resolveSleepCalendar;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21391(ProviderApi providerApi, Continuation<? super C21391> continuation) {
            super(2, continuation);
            this.$this_resolveSleepCalendar = providerApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21391(this.$this_resolveSleepCalendar, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GoogleCalendar> continuation) {
            return ((C21391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ProviderApi providerApi = this.$this_resolveSleepCalendar;
            this.label = 1;
            Object orCreateSleepCalendar = providerApi.getOrCreateSleepCalendar(this);
            return orCreateSleepCalendar == coroutine_suspended ? coroutine_suspended : orCreateSleepCalendar;
        }
    }

    public static final void checkCalendarEvents(Context context, String str, Alarm alarm) {
        context.getClass();
        str.getClass();
        alarm.getClass();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(context, str, alarm, null), 3, null);
    }

    public static final JavaGoogleCalendarAlarmManager googleCalendarAlarmManager(Context context, String str) {
        context.getClass();
        str.getClass();
        return new JavaGoogleCalendarAlarmManager(new GoogleCalendarAlarmManager(context, new MondayFridayWorkingDaysPolicy(), str, null, 8, null));
    }

    public static final GoogleCalendar resolveSleepCalendar(ProviderApi providerApi) {
        providerApi.getClass();
        return (GoogleCalendar) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21391(providerApi, null), 1, null);
    }
}
