package com.urbandroid.sleep.activityrecognition;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.SleepClassifyEvent;
import com.google.android.gms.location.SleepSegmentEvent;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeOverlapCalculator;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeSuggestion;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.Experiments;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0014\u0010\u000e\u001a\u00020\u000b*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013*\u00020\u0015H\u0002R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepSegmentsUpdateIntentService;", "Landroidx/core/app/FixedJobIntentService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$1", "onHandleWork", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "notify", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "notificationId", "", "toCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepSegmentsUpdateIntentService extends FixedJobIntentService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final String tag;

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepSegmentsUpdateIntentService$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "CONFIDENCE_THRESHOLD", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return SleepSegmentsUpdateIntentService.tag;
        }

        public final void start(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            JobIntentService.enqueueWork(context, (Class<?>) SleepSegmentsUpdateIntentService.class, 1018, intent);
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

    public SleepSegmentsUpdateIntentService() {
        StringBuilder sb = new StringBuilder("activity");
        String strConcat = null;
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        if (strM != null) {
            strConcat = StringsKt.isBlank(strM) ? "" : ":".concat(strM);
        }
        sb.append(strConcat);
        this.tag = sb.toString();
    }

    private final void notify(SleepTimeCalculator.Estimate estimate, int i) {
        SleepTimeSuggestionManager sleepTimeSuggestionManager = new SleepTimeSuggestionManager(this, null, 2, null);
        SleepTimeSuggestionManager.Mode sleepTimeSuggestionMode = ContextExtKt.getSettings(this).getSleepTimeSuggestionMode();
        sleepTimeSuggestionMode.getClass();
        sleepTimeSuggestionManager.suggestNotification(sleepTimeSuggestionMode, estimate, i, true);
    }

    private final Calendar toCalendar(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6  */
    @Override // androidx.core.app.JobIntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onHandleWork(Intent intent) {
        Interval interval;
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Settings settings = new Settings(this);
        if (!SleepSegmentEvent.hasEvents(intent)) {
            if (SleepClassifyEvent.hasEvents(intent)) {
                List<SleepClassifyEvent> listExtractEvents = SleepClassifyEvent.extractEvents(intent);
                listExtractEvents.getClass();
                for (SleepClassifyEvent sleepClassifyEvent : CollectionsKt.sortedWith(listExtractEvents, new Comparator() { // from class: com.urbandroid.sleep.activityrecognition.SleepSegmentsUpdateIntentService$onHandleWork$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((SleepClassifyEvent) t).getTimestampMillis()), Long.valueOf(((SleepClassifyEvent) t2).getTimestampMillis()));
                    }
                })) {
                    String str = " Sleep API SleepClassifyEvent Confidence=" + sleepClassifyEvent.getConfidence() + " ts " + Utils.getPrettyDate(sleepClassifyEvent.getTimestampMillis()) + " light " + sleepClassifyEvent.getLight() + " motion " + sleepClassifyEvent.getMotion();
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                    int i = 69 - ((sleepClassifyEvent.getLight() < 2 || sleepClassifyEvent.getMotion() < 2) ? 9 : 0);
                    Context applicationContext = getApplicationContext();
                    applicationContext.getClass();
                    ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
                    ReentrantLock lock = companion.getLOCK();
                    lock.lock();
                    try {
                        File storageFile = companion.getStorageFile(applicationContext);
                        ActivityIntervals activityIntervalsFrom = companion.from(storageFile);
                        activityIntervalsFrom.add(new DetectedActivity(sleepClassifyEvent.getConfidence() >= i ? 3 : 5, 100), sleepClassifyEvent.getTimestampMillis());
                        activityIntervalsFrom.export(storageFile);
                    } finally {
                        lock.unlock();
                    }
                }
                return;
            }
            return;
        }
        long sleepTimeSuggestionLastNotificationTime = settings.getSleepTimeSuggestionLastNotificationTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<SleepSegmentEvent> listExtractEvents2 = SleepSegmentEvent.extractEvents(intent);
        listExtractEvents2.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listExtractEvents2) {
            if (((SleepSegmentEvent) obj).getStatus() != 2) {
                arrayList.add(obj);
            }
        }
        List<SleepSegmentEvent> listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.urbandroid.sleep.activityrecognition.SleepSegmentsUpdateIntentService$onHandleWork$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SleepSegmentEvent) t2).getSegmentDurationMillis()), Long.valueOf(((SleepSegmentEvent) t).getSegmentDurationMillis()));
            }
        });
        for (SleepSegmentEvent sleepSegmentEvent : listSortedWith) {
            String strM = Fragment$$ExternalSyntheticOutline1.m(" Sleep API SleepSegmentEvent from ", Utils.getPrettyDate(sleepSegmentEvent.getStartTimeMillis()), " to ", Utils.getPrettyDate(sleepSegmentEvent.getEndTimeMillis()));
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        }
        if (sleepTimeSuggestionLastNotificationTime != -1 && jCurrentTimeMillis - Utils.getHoursInMillis(4) <= sleepTimeSuggestionLastNotificationTime && sleepTimeSuggestionLastNotificationTime <= jCurrentTimeMillis) {
            String strM2 = zzba$$ExternalSyntheticOutline0.m(sleepTimeSuggestionLastNotificationTime, "Sleep API notification already shown at ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
            return;
        }
        SleepTimeSuggestion sleepTimeSuggestion = new SleepTimeSuggestion();
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        SleepTimeCalculator.Estimate estimateCalculate = sleepTimeSuggestion.calculate(applicationContext2, SleepTimeCalculator.Companion.lastNightBasicEstimate$default(SleepTimeCalculator.INSTANCE, null, 1, null), null);
        if (estimateCalculate == null) {
            interval = null;
        } else {
            if (estimateCalculate.getType() != SleepTimeCalculator.Estimate.Type.DB) {
                estimateCalculate = null;
            }
            if (estimateCalculate != null) {
                interval = estimateCalculate.toInterval();
            }
        }
        String str2 = Logger.defaultTag;
        Logger.logInfo(str2, getTag() + ": " + (" Sleep API safety range=" + interval), null);
        ArrayList arrayList2 = new ArrayList();
        for (SleepSegmentEvent sleepSegmentEvent2 : listSortedWith) {
            SleepTimeOverlapCalculator sleepTimeOverlapCalculator = new SleepTimeOverlapCalculator(!Experiments.getInstance().isShowEstimateEvenTracking(), 0, null, 6, null);
            SleepTimeCalculator.Estimate.Type type = SleepTimeCalculator.Estimate.Type.ACTIVITY;
            Calendar calendar = toCalendar(sleepSegmentEvent2.getStartTimeMillis());
            calendar.getClass();
            Calendar calendar2 = toCalendar(sleepSegmentEvent2.getEndTimeMillis());
            calendar2.getClass();
            SleepTimeCalculator.Estimate estimate = sleepTimeOverlapCalculator.estimate(new SleepTimeCalculator.Estimate(type, calendar, calendar2, CollectionsKt.emptyList()));
            if (estimate != null) {
                arrayList2.add(estimate);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            SleepTimeCalculator.Estimate estimate2 = (SleepTimeCalculator.Estimate) obj2;
            if (interval == null || estimate2.toInterval().hasIntersection(interval)) {
                arrayList3.add(obj2);
            }
        }
        List listSortedWith2 = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.urbandroid.sleep.activityrecognition.SleepSegmentsUpdateIntentService$onHandleWork$$inlined$sortedByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SleepTimeCalculator.Estimate) t2).toInterval().getLength()), Long.valueOf(((SleepTimeCalculator.Estimate) t).toInterval().getLength()));
            }
        });
        SleepTimeCalculator.Estimate estimate3 = (SleepTimeCalculator.Estimate) CollectionsKt.firstOrNull(listSortedWith2);
        if (estimate3 != null) {
            if (estimate3.getTo().getTimeInMillis() == settings.getSleepApiLastSuggestion()) {
                String str3 = " Sleep API NOT showing estimate, already shown for " + estimate3.toInterval();
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str3, null);
                return;
            }
            settings.setSleepApiLastSuggestion(estimate3.getTo().getTimeInMillis());
            String str4 = " Sleep API showing notification " + estimate3.toInterval();
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str4, null);
            notify(estimate3, 2442);
        }
        if (listSortedWith2.size() > 1) {
            notify((SleepTimeCalculator.Estimate) listSortedWith2.get(1), 2443);
        }
    }
}
