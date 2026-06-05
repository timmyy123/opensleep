package com.urbandroid.sleep.activityrecognition.calculator;

import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicFloatKt;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepTimeStats;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B+\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeHistoryCalculator;", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator;", "Lcom/urbandroid/common/FeatureLogger;", "marginStdevs", "", "maxMarginHours", "statRecords", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "<init>", "(FFLjava/util/List;)V", "tag", "", "getTag", "()Ljava/lang/String;", "estimate", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "createEstimate", "initEstimate", "stats", "Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepTimeStats$Record;", "setTime", "", "Ljava/util/Calendar;", "fractionalHour", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeHistoryCalculator implements SleepTimeCalculator, FeatureLogger {
    private final float marginStdevs;
    private final float maxMarginHours;
    private final List<StatRecord> statRecords;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public SleepTimeHistoryCalculator(float f, float f2, List<? extends StatRecord> list) {
        list.getClass();
        this.marginStdevs = f;
        this.maxMarginHours = f2;
        this.statRecords = list;
        this.tag = "activity:estimate";
    }

    private final SleepTimeCalculator.Estimate createEstimate(SleepTimeCalculator.Estimate initEstimate, SleepTimeStats.Record stats) {
        float fNormalize = CyclicFloatKt.normalize(stats.getStartMedian() - Math.min(this.maxMarginHours, stats.getStartStdev() * this.marginStdevs), 24.0f);
        Object objClone = initEstimate.getFrom().clone();
        objClone.getClass();
        Calendar calendar = (Calendar) objClone;
        setTime(calendar, fNormalize);
        float fNormalize2 = CyclicFloatKt.normalize(Math.min(this.maxMarginHours, stats.getEndStdev() * this.marginStdevs) + stats.getEndMedian(), 24.0f);
        Object objClone2 = initEstimate.getTo().clone();
        objClone2.getClass();
        Calendar calendar2 = (Calendar) objClone2;
        setTime(calendar2, fNormalize2);
        while (calendar2.getTimeInMillis() - calendar.getTimeInMillis() > 50400000) {
            calendar.add(5, 1);
        }
        while (calendar2.getTimeInMillis() <= calendar.getTimeInMillis()) {
            calendar.add(5, -1);
        }
        return new SleepTimeCalculator.Estimate(SleepTimeCalculator.Estimate.Type.DB, calendar, calendar2, null, 8, null);
    }

    private final void setTime(Calendar calendar, float f) {
        calendar.set(11, (int) Math.floor(f));
        calendar.set(12, ((int) Math.rint(((f - r2) * 60.0f) / 5.0f)) * 5);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public SleepTimeCalculator.Estimate estimate(SleepTimeCalculator.Estimate estimate) {
        SleepTimeCalculator.Estimate estimateCreateEstimate = estimate;
        estimateCreateEstimate.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("SleepTimeHistoryCalculator: initial estimate = " + estimateCreateEstimate), null);
        SleepTimeStats sleepTimeStats = new SleepTimeStats(this.statRecords, 0, 0, 0.0d, 0.0d, 30, null);
        Date time = estimateCreateEstimate.getTo().getTime();
        time.getClass();
        SleepTimeStats.Record bestEstimate = sleepTimeStats.getBestEstimate(time);
        if (bestEstimate.isValid()) {
            estimateCreateEstimate = createEstimate(estimateCreateEstimate, bestEstimate);
        }
        String str2 = "SleepTimeHistoryCalculator: duration = " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", result = " + estimateCreateEstimate;
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
        return estimateCreateEstimate;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public /* synthetic */ SleepTimeHistoryCalculator(float f, float f2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 2.0f : f2, list);
    }
}
