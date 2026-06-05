package com.urbandroid.sleep.activityrecognition.calculator;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeDetectedActivityCalculator;", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator;", "Lcom/urbandroid/common/FeatureLogger;", "intervals", "", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "<init>", "(Ljava/util/List;)V", "tag", "", "getTag", "()Ljava/lang/String;", "estimate", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeDetectedActivityCalculator implements SleepTimeCalculator, FeatureLogger {
    private final List<ActivityIntervals.Interval> intervals;
    private final String tag;

    public SleepTimeDetectedActivityCalculator(List<ActivityIntervals.Interval> list) {
        list.getClass();
        this.intervals = list;
        this.tag = "activity:estimate";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean estimate$lambda$0(ActivityIntervals.Interval interval) {
        interval.getClass();
        return interval.isOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean estimate$lambda$1(Calendar calendar, Calendar calendar2, ActivityIntervals.Interval interval) {
        interval.getClass();
        return (interval.getFrom() > calendar.getTimeInMillis() && interval.getTo() < calendar2.getTimeInMillis()) || interval.contains(calendar.getTimeInMillis()) || interval.contains(calendar2.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean estimate$lambda$2(ActivityIntervals.Interval interval) {
        interval.getClass();
        long jLength$default = ActivityIntervals.Interval.length$default(interval, null, 1, null);
        return 2 <= jLength$default && jLength$default < 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean estimate$lambda$3(ActivityIntervals.Interval interval, ActivityIntervals.Interval interval2) {
        interval2.getClass();
        ActivityIntervals.Interval intervalIntersection = interval2.intersection(interval);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return (intervalIntersection != null ? intervalIntersection.length(timeUnit) : 0L) > interval.length(timeUnit) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean estimate$lambda$4(ActivityIntervals.Interval interval, ActivityIntervals.Interval interval2) {
        interval2.getClass();
        return (interval.getFrom() - interval2.getFrom()) / 3600000 < 4 && (interval2.getTo() - interval.getTo()) / 3600000 < 4;
    }

    public SleepTimeCalculator.Estimate estimate(SleepTimeCalculator.Estimate estimate) {
        estimate.getClass();
        Calendar from = estimate.getFrom();
        Calendar to = estimate.getTo();
        final ActivityIntervals.Interval interval = new ActivityIntervals.Interval(from.getTimeInMillis(), to.getTimeInMillis());
        final int length = 0;
        final int i = 1;
        List<ActivityIntervals.Interval> list = SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.filterNot(CollectionsKt.asSequence(this.intervals), new Data$$ExternalSyntheticLambda0(27)), new FunSpec$$ExternalSyntheticLambda1(from, to, 14)), new Data$$ExternalSyntheticLambda0(28)), new Function1() { // from class: com.urbandroid.sleep.activityrecognition.calculator.SleepTimeDetectedActivityCalculator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean zEstimate$lambda$3;
                int i2 = length;
                ActivityIntervals.Interval interval2 = interval;
                ActivityIntervals.Interval interval3 = (ActivityIntervals.Interval) obj;
                switch (i2) {
                    case 0:
                        zEstimate$lambda$3 = SleepTimeDetectedActivityCalculator.estimate$lambda$3(interval2, interval3);
                        break;
                    default:
                        zEstimate$lambda$3 = SleepTimeDetectedActivityCalculator.estimate$lambda$4(interval2, interval3);
                        break;
                }
                return Boolean.valueOf(zEstimate$lambda$3);
            }
        }), new Function1() { // from class: com.urbandroid.sleep.activityrecognition.calculator.SleepTimeDetectedActivityCalculator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean zEstimate$lambda$3;
                int i2 = i;
                ActivityIntervals.Interval interval2 = interval;
                ActivityIntervals.Interval interval3 = (ActivityIntervals.Interval) obj;
                switch (i2) {
                    case 0:
                        zEstimate$lambda$3 = SleepTimeDetectedActivityCalculator.estimate$lambda$3(interval2, interval3);
                        break;
                    default:
                        zEstimate$lambda$3 = SleepTimeDetectedActivityCalculator.estimate$lambda$4(interval2, interval3);
                        break;
                }
                return Boolean.valueOf(zEstimate$lambda$3);
            }
        }));
        String str = estimate + " longStillIntervals: " + ActivityIntervals.toString$default(ActivityIntervals.INSTANCE.from(list), true, null, 2, null);
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
        if (list.isEmpty()) {
            return new SleepTimeCalculator.Estimate(estimate.getType(), from, to, list);
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            length += (int) ((ActivityIntervals.Interval) it.next()).length(TimeUnit.MINUTES);
        }
        if (length < 180) {
            return new SleepTimeCalculator.Estimate(estimate.getType(), from, to, list);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(((ActivityIntervals.Interval) CollectionsKt.first((List) list)).getFrom());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(((ActivityIntervals.Interval) (ActivityIntervals.Interval.length$default((ActivityIntervals.Interval) CollectionsKt.first((List) list), null, 1, null) > 5 ? CollectionsKt.first((List) list) : CollectionsKt.last((List) list))).getTo());
        ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
        String strM = Fragment$$ExternalSyntheticOutline1.m("Suggested sleep time: ", ActivityIntervals.Companion.format$default(companion, calendar.getTimeInMillis(), 0L, false, 6, null), " to: ", ActivityIntervals.Companion.format$default(companion, calendar2.getTimeInMillis(), 0L, false, 6, null));
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        return new SleepTimeCalculator.Estimate(SleepTimeCalculator.Estimate.Type.ACTIVITY, calendar, calendar2, list);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
