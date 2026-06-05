package com.urbandroid.sleep.autostart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.impl.model.WorkSpecDao_Impl$$ExternalSyntheticLambda10;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeHistoryCalculator;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepStatsUtilKt;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002H\u0086\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b'\u0010\"¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "", "", "start", "end", "", "alarmSet", "margin", "<init>", "(JJZJ)V", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "putInto", "(Landroid/content/Intent;)Landroid/content/Intent;", SDKConstants.PARAM_VALUE, "contains", "(J)Z", "millis", "plus", "(J)Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "", "pretty", "()Ljava/lang/String;", "copy", "(JJZJ)Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", InAppPurchaseConstants.METHOD_TO_STRING, "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getStart", "()J", "getEnd", "Z", "getAlarmSet", "()Z", "getMargin", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ExpectedTrackingRange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = "AutoTracking:Range";
    private final boolean alarmSet;
    private final long end;
    private final long margin;
    private final long start;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007JK\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "NAME_EXPECTED_START_TRACKING_TIME", "", "NAME_EXPECTED_END_TRACKING_TIME", "NAME_EXPECTED_TRACKING_ALARM_SET", "NAME_EXPECTED_TRACKING_RANGE_MARGIN", "tag", "getTag", "()Ljava/lang/String;", "from", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "calculate", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "alarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "after", "", "marginCalculator", "Lkotlin/Function1;", "dayOffset", "", "(Landroid/content/Context;Lcom/urbandroid/sleep/alarmclock/Alarm;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;I)Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExpectedTrackingRange calculate$default(Companion companion, Context context, Alarm alarm, Long l, Function1 function1, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                alarm = Alarms.calculateNextAlert(context);
            }
            Alarm alarm2 = alarm;
            if ((i2 & 4) != 0) {
                l = null;
            }
            Long l2 = l;
            if ((i2 & 8) != 0) {
                function1 = new AiPrompt$$ExternalSyntheticLambda0(7);
            }
            Function1 function12 = function1;
            if ((i2 & 16) != 0) {
                i = 0;
            }
            return companion.calculate(context, alarm2, l2, function12, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long calculate$lambda$0(Context context) {
            context.getClass();
            return ConstantsKt.getDEFAULT_MARGIN_IN_MS();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long calculate$lambda$5(long j, Context context) {
            context.getClass();
            return j;
        }

        public final ExpectedTrackingRange calculate(Context context, Alarm alarm, Long after, Function1<? super Context, Long> marginCalculator, int dayOffset) {
            int measurementLength;
            context.getClass();
            marginCalculator.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(after != null ? after.longValue() : jCurrentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
            calendar2.add(6, dayOffset - 1);
            calendar2.set(11, 20);
            calendar2.clear(12);
            calendar2.clear(13);
            calendar2.clear(14);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(calendar.getTimeInMillis());
            calendar3.add(6, dayOffset);
            calendar3.set(11, 7);
            calendar3.clear(12);
            calendar3.clear(13);
            calendar3.clear(14);
            SleepTimeCalculator.Estimate estimate = new SleepTimeHistoryCalculator(2.0f, 2.0f, SleepStatsUtilKt.getStatRecordsFromRepo(500)).estimate(new SleepTimeCalculator.Estimate(SleepTimeCalculator.Estimate.Type.BASIC, calendar2, calendar3, null, 8, null));
            ExpectedTrackingRange expectedTrackingRange = new ExpectedTrackingRange(estimate.getFrom().getTimeInMillis(), estimate.getTo().getTimeInMillis(), false, 0L);
            long jLongValue = marginCalculator.invoke(context).longValue();
            if (alarm != null) {
                long end = expectedTrackingRange.getEnd() - Utils.getHoursInMillis(4);
                long hoursInMillis = Utils.getHoursInMillis(4) + expectedTrackingRange.getEnd();
                long j = alarm.time;
                if (end <= j && j <= hoursInMillis) {
                    long minutesInMillis = Utils.getMinutesInMillis(ContextExtKt.getSettings(context).getIdealSleepMinutes());
                    long j2 = alarm.time;
                    expectedTrackingRange = new ExpectedTrackingRange((j2 - minutesInMillis) - jLongValue, j2 + jLongValue, true, jLongValue);
                }
            }
            int i = 1;
            boolean z = false;
            if (dayOffset == 0) {
                List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(expectedTrackingRange.getStart() - Utils.getHoursInMillis(1), expectedTrackingRange.getEnd(), false);
                sleepRecords.getClass();
                measurementLength = 0;
                for (SleepRecord sleepRecord : sleepRecords) {
                    measurementLength += sleepRecord.isFinished() ? sleepRecord.getMeasurementLength() : 0;
                }
            } else {
                measurementLength = 0;
            }
            long timeInMillis = calendar.getTimeInMillis();
            boolean z2 = ((long) measurementLength) > ConstantsKt.getSUFFICIENT_TRACKING_DURATION();
            boolean z3 = timeInMillis == jCurrentTimeMillis && expectedTrackingRange.getEnd() < jCurrentTimeMillis;
            if (timeInMillis != jCurrentTimeMillis && timeInMillis > expectedTrackingRange.getStart()) {
                z = true;
            }
            if (dayOffset < 5 && (z2 || z3 || z)) {
                return calculate(context, alarm, after, new WorkSpecDao_Impl$$ExternalSyntheticLambda10(jLongValue, i), 1 + dayOffset);
            }
            String str = "Calculate range " + expectedTrackingRange.pretty() + " dayOffset=" + dayOffset;
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
            return expectedTrackingRange;
        }

        public final ExpectedTrackingRange from(Intent intent) {
            intent.getClass();
            ExpectedTrackingRange expectedTrackingRange = new ExpectedTrackingRange(intent.getLongExtra("expectedStartTrackingTime", 0L), intent.getLongExtra("expectedEndTrackingTime", 0L), intent.getBooleanExtra("expectedTrackingTimeAlarmSet", false), 0L, 8, null);
            if (expectedTrackingRange.getStart() == 0 || expectedTrackingRange.getEnd() == 0) {
                return null;
            }
            return expectedTrackingRange;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return ExpectedTrackingRange.tag;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ExpectedTrackingRange(long j, long j2, boolean z, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z, (i & 8) != 0 ? ConstantsKt.getDEFAULT_MARGIN_IN_MS() : j3);
    }

    public static /* synthetic */ ExpectedTrackingRange copy$default(ExpectedTrackingRange expectedTrackingRange, long j, long j2, boolean z, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = expectedTrackingRange.start;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = expectedTrackingRange.end;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            z = expectedTrackingRange.alarmSet;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j3 = expectedTrackingRange.margin;
        }
        return expectedTrackingRange.copy(j4, j5, z2, j3);
    }

    public static final ExpectedTrackingRange from(Intent intent) {
        return INSTANCE.from(intent);
    }

    public final boolean contains(long value) {
        return value <= this.end && this.start <= value;
    }

    public final ExpectedTrackingRange copy(long start, long end, boolean alarmSet, long margin) {
        return new ExpectedTrackingRange(start, end, alarmSet, margin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpectedTrackingRange)) {
            return false;
        }
        ExpectedTrackingRange expectedTrackingRange = (ExpectedTrackingRange) other;
        return this.start == expectedTrackingRange.start && this.end == expectedTrackingRange.end && this.alarmSet == expectedTrackingRange.alarmSet && this.margin == expectedTrackingRange.margin;
    }

    public final long getEnd() {
        return this.end;
    }

    public final long getMargin() {
        return this.margin;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        return Long.hashCode(this.margin) + FileInsert$$ExternalSyntheticOutline0.m(this.alarmSet, (Long.hashCode(this.end) + (Long.hashCode(this.start) * 31)) * 31, 31);
    }

    public final ExpectedTrackingRange plus(long millis) {
        return copy$default(this, this.start - millis, this.end + millis, false, 0L, 12, null);
    }

    public final String pretty() {
        String prettyDate = Utils.getPrettyDate(this.start);
        String prettyDate2 = Utils.getPrettyDate(this.end);
        boolean z = this.alarmSet;
        long j = this.margin;
        StringBuilder sb = new StringBuilder();
        sb.append(prettyDate);
        sb.append(" - ");
        sb.append(prettyDate2);
        sb.append(" alarmSet: ");
        sb.append(z);
        return zzba$$ExternalSyntheticOutline0.m(j, " margin: ", sb);
    }

    public final Intent putInto(Intent intent) {
        intent.getClass();
        intent.putExtra("expectedStartTrackingTime", this.start);
        intent.putExtra("expectedEndTrackingTime", this.end);
        intent.putExtra("expectedTrackingTimeAlarmSet", this.alarmSet);
        intent.putExtra("expectedTrackingRangeMargin", this.margin);
        return intent;
    }

    public String toString() {
        long j = this.start;
        long j2 = this.end;
        boolean z = this.alarmSet;
        long j3 = this.margin;
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("ExpectedTrackingRange(start=", ", end=", j);
        sbM.append(j2);
        sbM.append(", alarmSet=");
        sbM.append(z);
        sbM.append(", margin=");
        sbM.append(j3);
        sbM.append(")");
        return sbM.toString();
    }

    public ExpectedTrackingRange(long j, long j2, boolean z, long j3) {
        this.start = j;
        this.end = j2;
        this.alarmSet = z;
        this.margin = j3;
    }
}
