package com.urbandroid.sleep.autostart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.AsyncContext;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.autostart.AutoTrackingScheduler;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingScheduler;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "scheduleNextAlarm", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "expectedTrackingRange", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "afterMinutes", "", "cancelNextAlarm", "prepareIntent", "Lcom/urbandroid/sleep/PendingIntentBuilder;", "cancelSchedule", "schedule", "after", "(Landroid/content/Context;Ljava/lang/Long;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoTrackingScheduler implements FeatureLogger {
    public static final AutoTrackingScheduler INSTANCE = new AutoTrackingScheduler();
    private static final String tag = "AutoTracking:Scheduler";

    /* JADX INFO: renamed from: com.urbandroid.sleep.autostart.AutoTrackingScheduler$schedule$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/autostart/AutoTrackingScheduler;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.autostart.AutoTrackingScheduler$schedule$1", f = "AutoTrackingScheduler.kt", l = {68}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AsyncContext<AutoTrackingScheduler>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $after;
        final /* synthetic */ Context $context;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Long l, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$after = l;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit invokeSuspend$lambda$0(Ref$ObjectRef ref$ObjectRef, long j, Context context, Long l, AutoTrackingScheduler autoTrackingScheduler) {
            boolean zContains = ((ExpectedTrackingRange) ref$ObjectRef.element).contains(j);
            T t = ref$ObjectRef.element;
            if (zContains) {
                if (j > ((ExpectedTrackingRange) t).getEnd() - Utils.getHoursInMillis(2) || SleepService.isRunning()) {
                    AutoTrackingScheduler.schedule(context, Long.valueOf(Utils.getHoursInMillis(2) + ((ExpectedTrackingRange) ref$ObjectRef.element).getEnd()));
                } else if (!AutoTrackingService.INSTANCE.start(context, (ExpectedTrackingRange) ref$ObjectRef.element)) {
                    Intent intent = new Intent(context, (Class<?>) AutoTrackingService.class);
                    ((ExpectedTrackingRange) ref$ObjectRef.element).putInto(intent);
                    PendingIntent foregroundService = new PendingIntentBuilder(context, 0, intent, 134217728).getForegroundService();
                    AlarmManager alarmManager = ContextExtKt.getAlarmManager(context);
                    long jCurrentTimeMillis = System.currentTimeMillis() + 500;
                    alarmManager.cancel(foregroundService);
                    if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                        alarmManager.setExactAndAllowWhileIdle(1, jCurrentTimeMillis, foregroundService);
                    } else {
                        Logger.logSevere("Cannot set EXACT alarms");
                        alarmManager.setAndAllowWhileIdle(1, jCurrentTimeMillis, foregroundService);
                    }
                }
            } else {
                if (j >= ((ExpectedTrackingRange) t).getEnd()) {
                    AutoTrackingScheduler autoTrackingScheduler2 = AutoTrackingScheduler.INSTANCE;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("scheduled time in past range=", ((ExpectedTrackingRange) ref$ObjectRef.element).pretty());
                    Logger.logSevere(Logger.defaultTag, autoTrackingScheduler2.getTag() + ": " + strM, null);
                    return Unit.INSTANCE;
                }
                Intent intent2 = new Intent(context, (Class<?>) AutoTrackingService.class);
                ((ExpectedTrackingRange) ref$ObjectRef.element).putInto(intent2);
                PendingIntent foregroundService2 = new PendingIntentBuilder(context, 0, intent2, 134217728).getForegroundService();
                AlarmManager alarmManager2 = ContextExtKt.getAlarmManager(context);
                long start = ((ExpectedTrackingRange) ref$ObjectRef.element).getStart();
                alarmManager2.cancel(foregroundService2);
                if (Build.VERSION.SDK_INT < 31 || alarmManager2.canScheduleExactAlarms()) {
                    alarmManager2.setExactAndAllowWhileIdle(1, start, foregroundService2);
                } else {
                    Logger.logSevere("Cannot set EXACT alarms");
                    alarmManager2.setAndAllowWhileIdle(1, start, foregroundService2);
                }
                if (l != null) {
                    ActivityRecognitionInitializer.INSTANCE.updates(context).destroy();
                }
                AutoTrackingScheduler autoTrackingScheduler3 = AutoTrackingScheduler.INSTANCE;
                String str = "schedule launch for smart autostart at " + ((ExpectedTrackingRange) ref$ObjectRef.element).getStart() + " " + Utils.getPrettyDate(((ExpectedTrackingRange) ref$ObjectRef.element).getStart());
                Logger.logDebug(Logger.defaultTag, autoTrackingScheduler3.getTag() + ": " + str, null);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$after, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<AutoTrackingScheduler> asyncContext, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, com.urbandroid.sleep.autostart.ExpectedTrackingRange] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncContext asyncContext = (AsyncContext) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = ExpectedTrackingRange.Companion.calculate$default(ExpectedTrackingRange.INSTANCE, this.$context, null, this.$after, null, 0, 26, null);
                final Context context = this.$context;
                final Long l = this.$after;
                Function1 function1 = new Function1() { // from class: com.urbandroid.sleep.autostart.AutoTrackingScheduler$schedule$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AutoTrackingScheduler.AnonymousClass1.invokeSuspend$lambda$0(ref$ObjectRef, jCurrentTimeMillis, context, l, (AutoTrackingScheduler) obj2);
                    }
                };
                this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
                this.L$1 = SpillingKt.nullOutSpilledVariable(ref$ObjectRef);
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                if (Utils.uiThread(asyncContext, function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private AutoTrackingScheduler() {
    }

    public static final void cancelNextAlarm(Context context) {
        context.getClass();
        AutoTrackingScheduler autoTrackingScheduler = INSTANCE;
        Logger.logInfo(Logger.defaultTag, autoTrackingScheduler.getTag() + ": cancelNextAlarm", null);
        ContextExtKt.getAlarmManager(context).cancel(autoTrackingScheduler.prepareIntent(context, null).getForegroundService());
    }

    public static final void cancelSchedule(Context context) {
        context.getClass();
        AutoTrackingScheduler autoTrackingScheduler = INSTANCE;
        Logger.logInfo(Logger.defaultTag, autoTrackingScheduler.getTag() + ": cancelSchedule", null);
        ContextExtKt.getAlarmManager(context).cancel(new PendingIntentBuilder(context, 0, new Intent(context, (Class<?>) AutoTrackingReceiver.class), 134217728).getBroadcast());
        ContextExtKt.getAlarmManager(context).cancel(new PendingIntentBuilder(context, 0, new Intent(context, (Class<?>) AutoTrackingService.class), 134217728).getForegroundService());
    }

    private final PendingIntentBuilder prepareIntent(Context context, ExpectedTrackingRange expectedTrackingRange) {
        Intent intent = new Intent(context, (Class<?>) AutoTrackingService.class);
        if (expectedTrackingRange != null) {
            expectedTrackingRange.putInto(intent);
        }
        return new PendingIntentBuilder(context, 0, intent, 134217728);
    }

    public static final void schedule(Context context, Long after) {
        context.getClass();
        AutoTrackingScheduler autoTrackingScheduler = INSTANCE;
        String strM = FileInsert$$ExternalSyntheticOutline0.m("schedule: after ", after != null ? Utils.getPrettyDate(after.longValue()) : null);
        Logger.logInfo(Logger.defaultTag, autoTrackingScheduler.getTag() + ": " + strM, null);
        Utils.doAsyncThrowOnUI(autoTrackingScheduler, new AnonymousClass1(context, after, null));
    }

    public static /* synthetic */ void schedule$default(Context context, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        schedule(context, l);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return tag;
    }

    public final void scheduleNextAlarm(Context context, ExpectedTrackingRange expectedTrackingRange, long afterMinutes) {
        context.getClass();
        expectedTrackingRange.getClass();
        long minutesInMillis = Utils.getMinutesInMillis(afterMinutes) + System.currentTimeMillis();
        String strM = FileInsert$$ExternalSyntheticOutline0.m("scheduling next check: ", Utils.getPrettyDate(minutesInMillis));
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        PendingIntent foregroundService = prepareIntent(context, expectedTrackingRange).getForegroundService();
        AlarmManager alarmManager = ContextExtKt.getAlarmManager(context);
        alarmManager.cancel(foregroundService);
        if (Build.VERSION.SDK_INT < 31) {
            alarmManager.setExactAndAllowWhileIdle(1, minutesInMillis, foregroundService);
        } else if (alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(1, minutesInMillis, foregroundService);
        } else {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(1, minutesInMillis, foregroundService);
        }
    }

    public static final void schedule(Context context) {
        context.getClass();
        schedule$default(context, null, 2, null);
    }
}
