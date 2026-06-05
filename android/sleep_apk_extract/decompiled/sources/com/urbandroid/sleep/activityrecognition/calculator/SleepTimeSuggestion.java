package com.urbandroid.sleep.activityrecognition.calculator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepStatsUtilKt;
import com.urbandroid.util.Experiments;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeSuggestion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "calculate", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "estimate", "activityIntervals", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeSuggestion implements FeatureLogger {
    private final String tag = "activity:estimate";

    public static /* synthetic */ SleepTimeCalculator.Estimate calculate$default(SleepTimeSuggestion sleepTimeSuggestion, Context context, SleepTimeCalculator.Estimate estimate, ActivityIntervals activityIntervals, int i, Object obj) {
        if ((i & 4) != 0) {
            ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
            activityIntervals = companion.from(companion.getStorageFile(context));
        }
        return sleepTimeSuggestion.calculate(context, estimate, activityIntervals);
    }

    public final SleepTimeCalculator.Estimate calculate(Context context, SleepTimeCalculator.Estimate estimate, ActivityIntervals activityIntervals) {
        context.getClass();
        estimate.getClass();
        Calendar from = estimate.getFrom();
        Calendar to = estimate.getTo();
        String str = "start interval:  " + from.getTime() + " " + to.getTime();
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
        if (activityIntervals != null) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("all intervals: ", ActivityIntervals.toString$default(activityIntervals, true, null, 2, null));
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        }
        List<StatRecord> statRecordsFromRepo = SleepStatsUtilKt.getStatRecordsFromRepo(500);
        SleepTimeCalculator.Estimate estimate2 = new SleepTimeHistoryCalculator(2.0f, 2.0f, statRecordsFromRepo).estimate(estimate);
        SleepTimeCalculator.Estimate estimate3 = new SleepTimeHistoryCalculator(0.0f, 0.0f, statRecordsFromRepo, 2, null).estimate(estimate);
        String str2 = Logger.defaultTag;
        Logger.logDebug(str2, getTag() + ": " + ("estimate from history: " + estimate3 + ", " + estimate2), null);
        if (activityIntervals == null) {
            return estimate2;
        }
        SleepTimeCalculator.Estimate estimate4 = new SleepTimeDetectedActivityCalculator(activityIntervals.getIntervals()).estimate(estimate2);
        String str3 = Logger.defaultTag;
        Logger.logDebug(str3, getTag() + ": " + ("estimate from activity: " + estimate4), null);
        if (estimate4.getType() == SleepTimeCalculator.Estimate.Type.ACTIVITY) {
            estimate3 = estimate4;
        }
        String str4 = Logger.defaultTag;
        Logger.logDebug(str4, getTag() + ": " + ("final result before overlaps: " + estimate3), null);
        SleepTimeCalculator.Estimate estimate5 = new SleepTimeOverlapCalculator(Experiments.getInstance().isShowEstimateEvenTracking() ^ true, 0, null, 6, null).estimate(estimate3);
        StringBuilder sb = new StringBuilder("final result after overlaps: ");
        sb.append(estimate5);
        String string = sb.toString();
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + string, null);
        return estimate5;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
