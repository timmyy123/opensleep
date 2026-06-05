package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.achartengine.chart.TimeChart;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0017\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0002\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepRegularityIndexUtil2;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "", "Lcom/urbandroid/sleep/domain/SleepRecord;", "records", "(Ljava/util/List;)V", "", SDKConstants.PARAM_END_TIME, "currentTime", "", "getIndex", "(JJ)I", "Ljava/util/BitSet;", "bitSet", "startSplitIndex", "numberOfSplits", "(Ljava/util/BitSet;I)I", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "record", "", "fillSleepRegularityIndex", "(Lcom/urbandroid/sleep/addon/stats/model/StatRecord;)V", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "UTC", "Ljava/util/TimeZone;", "getUTC", "()Ljava/util/TimeZone;", "Ljava/util/BitSet;", "splitIndex", "I", "J", "", "getTag", "()Ljava/lang/String;", "tag", "SplitIndexCandidate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepRegularityIndexUtil2 implements FeatureLogger {
    private final TimeZone UTC;
    private final BitSet bitSet;
    private long endTime;
    private int splitIndex;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/SleepRegularityIndexUtil2$SplitIndexCandidate;", "", "", "index", "splits", "distance", "<init>", "(III)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "getSplits", "getDistance", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SplitIndexCandidate {
        private final int distance;
        private final int index;
        private final int splits;

        public SplitIndexCandidate(int i, int i2, int i3) {
            this.index = i;
            this.splits = i2;
            this.distance = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SplitIndexCandidate)) {
                return false;
            }
            SplitIndexCandidate splitIndexCandidate = (SplitIndexCandidate) other;
            return this.index == splitIndexCandidate.index && this.splits == splitIndexCandidate.splits && this.distance == splitIndexCandidate.distance;
        }

        public final int getDistance() {
            return this.distance;
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getSplits() {
            return this.splits;
        }

        public int hashCode() {
            return Integer.hashCode(this.distance) + FileInsert$$ExternalSyntheticOutline0.m(this.splits, Integer.hashCode(this.index) * 31, 31);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(this.distance, ")", Fragment$$ExternalSyntheticOutline1.m(this.index, this.splits, "SplitIndexCandidate(index=", ", splits=", ", distance="));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SleepRegularityIndexUtil2(List<? extends SleepRecord> list) {
        this();
        list.getClass();
        List<? extends SleepRecord> list2 = list;
        Iterator<T> it = list2.iterator();
        if (!it.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        long toTime = ((SleepRecord) it.next()).getToTime();
        while (it.hasNext()) {
            long toTime2 = ((SleepRecord) it.next()).getToTime();
            if (toTime < toTime2) {
                toTime = toTime2;
            }
        }
        Calendar calendar = Calendar.getInstance(this.UTC);
        calendar.setTimeInMillis(toTime);
        calendar.add(5, 1);
        this.endTime = DateUtil.getDayEnd(calendar.getTimeInMillis(), this.UTC);
        for (SleepRecord sleepRecord : list2) {
            try {
                int index = getIndex(this.endTime, sleepRecord.getToTime());
                int index2 = getIndex(this.endTime, sleepRecord.getFromTime());
                RangesKt.coerceAtLeast(index, index2);
                this.bitSet.set(index, index2, true);
                for (EventInterval eventInterval : EventsUtil.getEventIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END)) {
                    try {
                        this.bitSet.set(getIndex(this.endTime, eventInterval.toInterval().getTo()), getIndex(this.endTime, eventInterval.toInterval().getFrom()), false);
                    } catch (Exception e) {
                        String str = "awake To before From " + eventInterval.toInterval();
                        Logger.logWarning(Logger.defaultTag, getTag() + ": " + str, e);
                    }
                }
            } catch (Exception e2) {
                String str2 = Logger.defaultTag;
                Logger.logWarning(str2, getTag() + ": " + ("record To before From " + sleepRecord), e2);
            }
        }
        long midDay = DateUtil.getMidDay(this.endTime, TimeZone.getDefault());
        midDay = midDay > this.endTime ? midDay - TimeChart.DAY : midDay;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = CollectionsKt.toList(new IntRange(-10, 10)).iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Number) it2.next()).intValue();
            int index3 = getIndex(this.endTime, (((long) iIntValue) * 3600000) + midDay);
            if (index3 >= 0) {
                arrayList.add(new SplitIndexCandidate(index3, numberOfSplits(this.bitSet, index3), Math.abs(iIntValue)));
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2$special$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((SleepRegularityIndexUtil2.SplitIndexCandidate) t).getSplits()), Integer.valueOf(((SleepRegularityIndexUtil2.SplitIndexCandidate) t2).getSplits()));
            }
        };
        this.splitIndex = ((SplitIndexCandidate) CollectionsKt.first(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2$special$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Integer.valueOf(((SleepRegularityIndexUtil2.SplitIndexCandidate) t).getDistance()), Integer.valueOf(((SleepRegularityIndexUtil2.SplitIndexCandidate) t2).getDistance()));
            }
        }))).getIndex();
    }

    private final int getIndex(long endTime, long currentTime) {
        return (int) ((endTime - currentTime) / 60000);
    }

    private final int numberOfSplits(BitSet bitSet, int startSplitIndex) {
        int i = 0;
        while (startSplitIndex < bitSet.size()) {
            if (bitSet.get(startSplitIndex)) {
                i++;
            }
            startSplitIndex += 1440;
        }
        return i;
    }

    public final void fillSleepRegularityIndex(StatRecord record) {
        record.getClass();
        try {
            int index = getIndex(this.endTime, record.getToDate().getTime());
            int i = index - ((index - this.splitIndex) % 1440);
            int i2 = i + 1440;
            int i3 = i + 2880;
            BitSet bitSet = this.bitSet.get(i, i2);
            BitSet bitSet2 = this.bitSet.get(i2, i3);
            if (bitSet.cardinality() != 0 && bitSet2.cardinality() != 0) {
                bitSet.xor(bitSet2);
                record.setIrregularityIndex(1.0f - (bitSet.cardinality() / 1440.0f));
                return;
            }
            record.setIrregularityIndex(-1.0f);
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, getTag() + ": wrong index ", e);
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "SRI2";
    }

    public SleepRegularityIndexUtil2() {
        this.UTC = DesugarTimeZone.getTimeZone("UTC");
        this.bitSet = new BitSet();
        this.splitIndex = -1;
        this.endTime = -1L;
    }
}
