package com.urbandroid.sleep.activityrecognition.calculator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.domain.interval.Interval;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator;", "Lcom/urbandroid/common/FeatureLogger;", "Companion", "Estimate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SleepTimeCalculator extends FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J>\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b#\u0010\"R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;", "type", "Ljava/util/Calendar;", "from", "to", "", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "intervals", "<init>", "(Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;Ljava/util/Calendar;Ljava/util/Calendar;Ljava/util/List;)V", "Lcom/urbandroid/sleep/domain/interval/Interval;", "toInterval", "()Lcom/urbandroid/sleep/domain/interval/Interval;", "plusDay", "()Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "copy", "(Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;Ljava/util/Calendar;Ljava/util/Calendar;Ljava/util/List;)Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;", "getType", "()Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;", "Ljava/util/Calendar;", "getFrom", "()Ljava/util/Calendar;", "getTo", "Ljava/util/List;", "getIntervals", "()Ljava/util/List;", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Estimate {
        private final Calendar from;
        private final List<ActivityIntervals.Interval> intervals;
        private final Calendar to;
        private final Type type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate$Type;", "", "<init>", "(Ljava/lang/String;I)V", "BASIC", "DB", "ACTIVITY", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;
            public static final Type BASIC = new Type("BASIC", 0);
            public static final Type DB = new Type("DB", 1);
            public static final Type ACTIVITY = new Type("ACTIVITY", 2);

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{BASIC, DB, ACTIVITY};
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            }

            private Type(String str, int i) {
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }
        }

        public Estimate(Type type, Calendar calendar, Calendar calendar2, List<ActivityIntervals.Interval> list) {
            type.getClass();
            calendar.getClass();
            calendar2.getClass();
            list.getClass();
            this.type = type;
            this.from = calendar;
            this.to = calendar2;
            this.intervals = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Estimate copy$default(Estimate estimate, Type type, Calendar calendar, Calendar calendar2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                type = estimate.type;
            }
            if ((i & 2) != 0) {
                calendar = estimate.from;
            }
            if ((i & 4) != 0) {
                calendar2 = estimate.to;
            }
            if ((i & 8) != 0) {
                list = estimate.intervals;
            }
            return estimate.copy(type, calendar, calendar2, list);
        }

        public final Estimate copy(Type type, Calendar from, Calendar to, List<ActivityIntervals.Interval> intervals) {
            type.getClass();
            from.getClass();
            to.getClass();
            intervals.getClass();
            return new Estimate(type, from, to, intervals);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Estimate)) {
                return false;
            }
            Estimate estimate = (Estimate) other;
            return this.type == estimate.type && Intrinsics.areEqual(this.from, estimate.from) && Intrinsics.areEqual(this.to, estimate.to) && Intrinsics.areEqual(this.intervals, estimate.intervals);
        }

        public final Calendar getFrom() {
            return this.from;
        }

        public final Calendar getTo() {
            return this.to;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            return this.intervals.hashCode() + ((this.to.hashCode() + ((this.from.hashCode() + (this.type.hashCode() * 31)) * 31)) * 31);
        }

        public final Estimate plusDay() {
            return new Estimate(this.type, Utils.plusDays(this.from, 1), Utils.plusDays(this.to, 1), null, 8, null);
        }

        public final Interval toInterval() {
            return new Interval(this.from.getTime(), this.to.getTime());
        }

        public String toString() {
            Type type = this.type;
            ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
            String str = ActivityIntervals.Companion.format$default(companion, this.from.getTimeInMillis(), 0L, false, 6, null);
            String str2 = ActivityIntervals.Companion.format$default(companion, this.to.getTimeInMillis(), 0L, false, 6, null);
            String strM = this.intervals.isEmpty() ? "" : FileInsert$$ExternalSyntheticOutline0.m(" intervals: ", ActivityIntervals.toString$default(companion.from(this.intervals), true, null, 2, null));
            StringBuilder sb = new StringBuilder("Estimate ");
            sb.append(type);
            sb.append(" [");
            sb.append(str);
            sb.append(", ");
            return Fragment$$ExternalSyntheticOutline1.m(sb, str2, "]", strM);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Estimate(Type type, Calendar calendar, Calendar calendar2) {
            this(type, calendar, calendar2, null, 8, null);
            type.getClass();
            calendar.getClass();
            calendar2.getClass();
        }

        public /* synthetic */ Estimate(Type type, Calendar calendar, Calendar calendar2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, calendar, calendar2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b*\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Companion;", "", "<init>", "()V", "", "Lkotlin/Function0;", "", "currentTimeInMs", "Ljava/util/Calendar;", "hoursAsCalendar", "(ILkotlin/jvm/functions/Function0;)Ljava/util/Calendar;", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "lastNightBasicEstimate", "(Lkotlin/jvm/functions/Function0;)Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "nextNightBasicEstimate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final Calendar hoursAsCalendar(int i, Function0<Long> function0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(function0.invoke().longValue());
            calendar.set(11, i);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Estimate lastNightBasicEstimate$default(Companion companion, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = new Tool$$ExternalSyntheticLambda0(23);
            }
            return companion.lastNightBasicEstimate(function0);
        }

        public final Estimate lastNightBasicEstimate(Function0<Long> currentTimeInMs) {
            currentTimeInMs.getClass();
            Estimate.Type type = Estimate.Type.BASIC;
            Calendar calendarHoursAsCalendar = hoursAsCalendar(20, currentTimeInMs);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(calendarHoursAsCalendar.getTimeInMillis());
            calendar.add(6, -1);
            return new Estimate(type, calendar, hoursAsCalendar(7, currentTimeInMs), null, 8, null);
        }

        public final Estimate nextNightBasicEstimate(Function0<Long> currentTimeInMs) {
            currentTimeInMs.getClass();
            Estimate estimateLastNightBasicEstimate = lastNightBasicEstimate(currentTimeInMs);
            if (estimateLastNightBasicEstimate.getTo().getTime().before(new Date(currentTimeInMs.invoke().longValue()))) {
                Logger.logInfo("nextNightBasicEstimate +1 day " + estimateLastNightBasicEstimate, null);
                return estimateLastNightBasicEstimate.plusDay();
            }
            Logger.logInfo("nextNightBasicEstimate " + estimateLastNightBasicEstimate, null);
            return estimateLastNightBasicEstimate;
        }

        public final Estimate lastNightBasicEstimate() {
            return lastNightBasicEstimate$default(this, null, 1, null);
        }
    }
}
