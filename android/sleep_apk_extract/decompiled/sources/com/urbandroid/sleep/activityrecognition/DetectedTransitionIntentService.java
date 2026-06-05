package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.util.Experiments;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/DetectedTransitionIntentService;", "Landroidx/core/app/FixedJobIntentService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$1", "onHandleWork", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DetectedTransitionIntentService extends FixedJobIntentService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final String tag;

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/DetectedTransitionIntentService$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "ACTION_OTHER_ACTIVITY_DETECTED", "", "EXTRA_DURATION", "EXTRA_TIMESTAMP", "EXTRA_IF_STILL_ONLY", "tag", "getTag", "()Ljava/lang/String;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return DetectedTransitionIntentService.tag;
        }

        public final void start(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            JobIntentService.enqueueWork(context, (Class<?>) DetectedTransitionIntentService.class, 668, intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        StringBuilder sb = new StringBuilder("activity");
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        sb.append(strM != null ? StringsKt.isBlank(strM) ? "" : ":".concat(strM) : null);
        tag = sb.toString();
    }

    public DetectedTransitionIntentService() {
        StringBuilder sb = new StringBuilder("activity");
        String strConcat = null;
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        if (strM != null) {
            strConcat = StringsKt.isBlank(strM) ? "" : ":".concat(strM);
        }
        sb.append(strConcat);
        this.tag = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onHandleWork$lambda$0(Intent intent, DetectedTransitionIntentService detectedTransitionIntentService) {
        List listEmptyList;
        ActivityTransitionResult activityTransitionResultExtractResult;
        List<ActivityTransitionEvent> transitionEvents;
        boolean zAreEqual = Intrinsics.areEqual("com.urbandroid.sleep.activityrecognition.ACTION_OTHER_ACTIVITY_DETECTED", intent.getAction());
        if (zAreEqual) {
            long longExtra = intent.getLongExtra("timestamp", SystemClock.elapsedRealtime()) * 1000000;
            listEmptyList = CollectionsKt.listOf((Object[]) new ActivityTransitionEvent[]{new ActivityTransitionEvent(3, 1, longExtra - TimeUnit.MILLISECONDS.toNanos(intent.getLongExtra("duration", 1000L))), new ActivityTransitionEvent(3, 0, longExtra)});
        } else if (!ActivityTransitionResult.hasResult(intent) || (activityTransitionResultExtractResult = ActivityTransitionResult.extractResult(intent)) == null || (transitionEvents = activityTransitionResultExtractResult.getTransitionEvents()) == null || (listEmptyList = CollectionsKt.toMutableList((Collection) transitionEvents)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (!listEmptyList.isEmpty()) {
            Context applicationContext = detectedTransitionIntentService.getApplicationContext();
            applicationContext.getClass();
            ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
            ReentrantLock lock = companion.getLOCK();
            lock.lock();
            try {
                File storageFile = companion.getStorageFile(applicationContext);
                ActivityIntervals activityIntervalsFrom = companion.from(storageFile);
                for (ActivityTransitionEvent activityTransitionEvent : CollectionsKt.sortedWith(listEmptyList, new Comparator() { // from class: com.urbandroid.sleep.activityrecognition.DetectedTransitionIntentService$onHandleWork$lambda$0$0$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((ActivityTransitionEvent) t).getElapsedRealTimeNanos()), Long.valueOf(((ActivityTransitionEvent) t2).getElapsedRealTimeNanos()));
                    }
                })) {
                    String str = ActivitityrecognitionKt.getActivity(activityTransitionEvent) + " time: " + new SimpleDateFormat("EEE HH:mm:ss").format(new Date(ActivitityrecognitionKt.getTimestamp(activityTransitionEvent))) + " transition: " + ActivitityrecognitionKt.getTransition(activityTransitionEvent) + " ";
                    Logger.logDebug(Logger.defaultTag, activityIntervalsFrom.getTag() + ": " + str, null);
                    int size = activityIntervalsFrom.getIntervals().size();
                    activityIntervalsFrom.add(activityTransitionEvent);
                    if (Experiments.getInstance().isOurExperimentalPhone() || size != activityIntervalsFrom.getIntervals().size()) {
                        String str2 = "intervals " + activityIntervalsFrom.toString(true, 5) + " after adding " + ActivitityrecognitionKt.getActivity(activityTransitionEvent) + " " + ActivitityrecognitionKt.getTransition(activityTransitionEvent);
                        Logger.logDebug(Logger.defaultTag, activityIntervalsFrom.getTag() + ": " + str2, null);
                    }
                }
                activityIntervalsFrom.export(storageFile);
                lock.unlock();
                if (!zAreEqual) {
                    ActivityTransitionEvent activityTransitionEvent2 = (ActivityTransitionEvent) CollectionsKt.last(listEmptyList);
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("last transition ", ActivitityrecognitionKt.pretty(activityTransitionEvent2));
                    Logger.logDebug(Logger.defaultTag, detectedTransitionIntentService.getTag() + ": " + strM, null);
                    if (ActivitityrecognitionKt.isDerivedStillEnter(activityTransitionEvent2)) {
                        ExpectedTrackingRange.Companion companion2 = ExpectedTrackingRange.INSTANCE;
                        Context applicationContext2 = detectedTransitionIntentService.getApplicationContext();
                        applicationContext2.getClass();
                        ExpectedTrackingRange expectedTrackingRangeCalculate$default = ExpectedTrackingRange.Companion.calculate$default(companion2, applicationContext2, null, null, null, 0, 30, null);
                        String strM2 = FileInsert$$ExternalSyntheticOutline0.m("range ", expectedTrackingRangeCalculate$default.pretty());
                        Logger.logDebug(Logger.defaultTag, detectedTransitionIntentService.getTag() + ": " + strM2, null);
                        if (expectedTrackingRangeCalculate$default.contains(System.currentTimeMillis())) {
                            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(ActivitityrecognitionKt.pretty(activityTransitionEvent2), " .. starting updates");
                            Logger.logDebug(Logger.defaultTag, detectedTransitionIntentService.getTag() + ": " + strM$1, null);
                            ActivityRecognitionInitializer.Companion companion3 = ActivityRecognitionInitializer.INSTANCE;
                            Context applicationContext3 = detectedTransitionIntentService.getApplicationContext();
                            applicationContext3.getClass();
                            ActivityRecognitionInitializer.Update.reinitialize$default(companion3.updates(applicationContext3), 0, 1, null);
                        }
                    } else if (ActivitityrecognitionKt.isStillExit(activityTransitionEvent2)) {
                        String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(ActivitityrecognitionKt.pretty(activityTransitionEvent2), " .. stopping updates - starting with 30 min period");
                        Logger.logDebug(Logger.defaultTag, detectedTransitionIntentService.getTag() + ": " + strM$12, null);
                        ActivityRecognitionInitializer.Companion companion4 = ActivityRecognitionInitializer.INSTANCE;
                        Context applicationContext4 = detectedTransitionIntentService.getApplicationContext();
                        applicationContext4.getClass();
                        companion4.updates(applicationContext4).reinitialize(30);
                    }
                }
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        ActivitityrecognitionKt.whenActivityRecognitionNeeded(applicationContext, new Url$$ExternalSyntheticLambda1(intent, this, 3));
    }
}
