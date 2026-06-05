package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001$B?\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u001c\u0010 \u001a\n !*\u0004\u0018\u00010\u00120\u0012*\u00020\u00122\u0006\u0010\"\u001a\u00020\u0006H\u0002J\f\u0010#\u001a\u00020\u0006*\u00020\u0012H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepTimeStats;", "", "statRecords", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "allDaysLookback", "", "weekDayLookback", "minSleepLenHours", "", "maxSleepLenHours", "<init>", "(Ljava/util/List;IIDD)V", "chronoRecords", "Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/ChronoRecords;", "getBestEstimate", "Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepTimeStats$Record;", "sleepEnd", "Ljava/util/Date;", "getAllDaysEstimate", "lookback", "getDayOfWeekEstimate", "compute", "recs", "type", "", "nanTo0", "", "f", "createInvalidRecord", "rate", "r", "addDays", "kotlin.jvm.PlatformType", "days", "getDayOfWeek", "Record", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeStats {
    private final int allDaysLookback;
    private final ChronoRecords chronoRecords;
    private final double maxSleepLenHours;
    private final double minSleepLenHours;
    private final List<StatRecord> statRecords;
    private final int weekDayLookback;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepTimeStats$Record;", "", "", "startMedian", "startStdev", "endMedian", "endStdev", "", "type", "<init>", "(FFFFLjava/lang/String;)V", "", "isValid", "()Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getStartMedian", "()F", "getStartStdev", "getEndMedian", "getEndStdev", "Ljava/lang/String;", "getType", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Record {
        private final float endMedian;
        private final float endStdev;
        private final float startMedian;
        private final float startStdev;
        private final String type;

        public Record(float f, float f2, float f3, float f4, String str) {
            str.getClass();
            this.startMedian = f;
            this.startStdev = f2;
            this.endMedian = f3;
            this.endStdev = f4;
            this.type = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Record)) {
                return false;
            }
            Record record = (Record) other;
            return Float.compare(this.startMedian, record.startMedian) == 0 && Float.compare(this.startStdev, record.startStdev) == 0 && Float.compare(this.endMedian, record.endMedian) == 0 && Float.compare(this.endStdev, record.endStdev) == 0 && Intrinsics.areEqual(this.type, record.type);
        }

        public final float getEndMedian() {
            return this.endMedian;
        }

        public final float getEndStdev() {
            return this.endStdev;
        }

        public final float getStartMedian() {
            return this.startMedian;
        }

        public final float getStartStdev() {
            return this.startStdev;
        }

        public int hashCode() {
            return this.type.hashCode() + Fragment$$ExternalSyntheticOutline1.m(this.endStdev, Fragment$$ExternalSyntheticOutline1.m(this.endMedian, Fragment$$ExternalSyntheticOutline1.m(this.startStdev, Float.hashCode(this.startMedian) * 31, 31), 31), 31);
        }

        public final boolean isValid() {
            if (Math.abs(this.startMedian) > Float.MAX_VALUE || Math.abs(this.startStdev) > Float.MAX_VALUE || Math.abs(this.endMedian) > Float.MAX_VALUE || Math.abs(this.endStdev) > Float.MAX_VALUE) {
                return false;
            }
            float f = this.startMedian;
            if (f < 0.0f || f > 24.0f) {
                return false;
            }
            float f2 = this.endMedian;
            if (f2 < 0.0f || f2 > 24.0f) {
                return false;
            }
            float f3 = this.startStdev;
            if (f3 < 0.0f || f3 > 8.0f) {
                return false;
            }
            float f4 = this.endStdev;
            return f4 >= 0.0f && f4 <= 8.0f;
        }

        public String toString() {
            float f = this.startMedian;
            float f2 = this.startStdev;
            float f3 = this.endMedian;
            float f4 = this.endStdev;
            String str = this.type;
            StringBuilder sb = new StringBuilder("Record(startMedian=");
            sb.append(f);
            sb.append(", startStdev=");
            sb.append(f2);
            sb.append(", endMedian=");
            sb.append(f3);
            sb.append(", endStdev=");
            sb.append(f4);
            sb.append(", type=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, str, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SleepTimeStats(List<? extends StatRecord> list, int i, int i2, double d, double d2) {
        list.getClass();
        this.statRecords = list;
        this.allDaysLookback = i;
        this.weekDayLookback = i2;
        this.minSleepLenHours = d;
        this.maxSleepLenHours = d2;
        List<StatRecord> listFilterByGrossLength = SleepStatsUtilKt.filterByGrossLength(list, d, d2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterByGrossLength, 10));
        Iterator<T> it = listFilterByGrossLength.iterator();
        while (it.hasNext()) {
            arrayList.add(ChronoRecordKt.toChronoRecord((StatRecord) it.next()));
        }
        this.chronoRecords = new ChronoRecords(CollectionsKt.filterNotNull(arrayList));
    }

    private final Date addDays(Date date, int i) {
        Calendar calendar = Utils.toCalendar(date);
        calendar.add(6, i);
        return calendar.getTime();
    }

    private final Record createInvalidRecord(String type) {
        return new Record(0.0f, Float.POSITIVE_INFINITY, 0.0f, Float.POSITIVE_INFINITY, type);
    }

    private final int getDayOfWeek(Date date) {
        return Utils.toCalendar(date).get(7);
    }

    private final float nanTo0(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        return f;
    }

    private final float rate(Record r) {
        return (r.getEndStdev() * r.getEndStdev()) + (r.getStartStdev() * r.getStartStdev());
    }

    public final Record compute(ChronoRecords recs, String type) {
        recs.getClass();
        type.getClass();
        if (recs.size() < 5) {
            return createInvalidRecord(type);
        }
        float[] fromHours = recs.getFromHours();
        fromHours.getClass();
        float fMedian = CyclicFloatKt.median(fromHours, 24.0f);
        float fHalfStdevAnticlockwise = CyclicFloatKt.halfStdevAnticlockwise(fromHours, fMedian, 24.0f);
        float[] toHours = recs.getToHours();
        toHours.getClass();
        float fMedian2 = CyclicFloatKt.median(toHours, 24.0f);
        return new Record(fMedian, nanTo0(fHalfStdevAnticlockwise), fMedian2, nanTo0(CyclicFloatKt.halfStdevClockwise(toHours, fMedian2, 24.0f)), type);
    }

    public final Record getAllDaysEstimate(Date sleepEnd) {
        sleepEnd.getClass();
        Record allDaysEstimate = getAllDaysEstimate(sleepEnd, this.allDaysLookback);
        if (allDaysEstimate.isValid()) {
            return allDaysEstimate;
        }
        Record allDaysEstimate2 = getAllDaysEstimate(sleepEnd, this.allDaysLookback * 2);
        return allDaysEstimate2.isValid() ? allDaysEstimate2 : getAllDaysEstimate(sleepEnd, this.allDaysLookback * 4);
    }

    public final Record getBestEstimate(Date sleepEnd) {
        sleepEnd.getClass();
        Record[] recordArr = {getAllDaysEstimate(sleepEnd), getDayOfWeekEstimate(sleepEnd)};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            arrayList.add(Float.valueOf(rate(recordArr[i])));
        }
        int iArgmin = ScienceUtil.argmin(CollectionsKt.toFloatArray(arrayList));
        return iArgmin < 0 ? createInvalidRecord(IntegrityManager.INTEGRITY_TYPE_NONE) : recordArr[iArgmin];
    }

    public final Record getDayOfWeekEstimate(Date sleepEnd) {
        sleepEnd.getClass();
        Record dayOfWeekEstimate = getDayOfWeekEstimate(sleepEnd, this.weekDayLookback);
        if (dayOfWeekEstimate.isValid()) {
            return dayOfWeekEstimate;
        }
        Record dayOfWeekEstimate2 = getDayOfWeekEstimate(sleepEnd, this.weekDayLookback * 2);
        return dayOfWeekEstimate2.isValid() ? dayOfWeekEstimate2 : getDayOfWeekEstimate(sleepEnd, this.weekDayLookback * 4);
    }

    private final Record getAllDaysEstimate(Date sleepEnd, int lookback) {
        ChronoRecords chronoRecordsNarrow = this.chronoRecords.narrow(addDays(sleepEnd, -lookback), sleepEnd);
        chronoRecordsNarrow.getClass();
        return compute(chronoRecordsNarrow, "all days");
    }

    private final Record getDayOfWeekEstimate(Date sleepEnd, int lookback) {
        ChronoRecords chronoRecordsFilterByDayOfWeek = this.chronoRecords.narrow(addDays(sleepEnd, -lookback), sleepEnd).filterByDayOfWeek(getDayOfWeek(sleepEnd));
        chronoRecordsFilterByDayOfWeek.getClass();
        return compute(chronoRecordsFilterByDayOfWeek, "week day");
    }

    public /* synthetic */ SleepTimeStats(List list, int i, int i2, double d, double d2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? 30 : i, (i3 & 4) != 0 ? 210 : i2, (i3 & 8) != 0 ? 2.0d : d, (i3 & 16) != 0 ? 16.0d : d2);
    }
}
