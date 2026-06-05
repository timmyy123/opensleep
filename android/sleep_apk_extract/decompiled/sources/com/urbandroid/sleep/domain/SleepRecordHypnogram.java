package com.urbandroid.sleep.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.AdaptiveNormalizationFilter;
import com.urbandroid.sleep.domain.SleepRecordDataFilter;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepRecordHypnogram {
    public static List<Float> aggregateHistoryNew(int i, Date date, Date date2, List<Float> list, Events events, long j) {
        if (i < 10005) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m(i, "version < V6: ", " < 10005"));
            return null;
        }
        int size = list.size();
        if (size == 0 || ((date != null && date2 != null && (date2.getTime() - date.getTime()) / ((long) size) > 15000) || size < 12)) {
            return list;
        }
        int i2 = size < 90 ? 3 : size < 360 ? 6 : 30;
        BitSet bitSetComputeExcludedIndices = computeExcludedIndices(events, i, size, j);
        PairTracking.Companion companion = PairTracking.INSTANCE;
        if (companion.hasSufficientDataForPairTracking()) {
            EventsRawStorageKt.writeBitSet(events, date.getTime(), EventLabel.DHA, new BitSet());
            return ScienceUtil.convertArrayToList(companion.getAggregatedActigraph(bitSetComputeExcludedIndices));
        }
        AdaptiveNormalizationFilter.ANFResult aNFResultNormalizeAmplitudes = AdaptiveNormalizationFilter.normalizeAmplitudes(ScienceUtil.toFloatArray(list), bitSetComputeExcludedIndices);
        if (i >= 10007) {
            EventsRawStorageKt.writeBitSet(events, date.getTime(), EventLabel.DHA, aNFResultNormalizeAmplitudes.getHighActivityFlags(2.5f));
        }
        return ScienceUtil.convertArrayToList(aNFResultNormalizeAmplitudes.aggregateOutput(i2));
    }

    public static List<Float> aggregateHistoryOld(List<Float> list, int i, String str) {
        if (i < 10005) {
            return SleepRecordDataFilter.getPresentationFilter(100, i >= 10003 ? SleepRecordDataFilter.FilterType.SONAR : Tag.hasTag(str, Tag.WATCH) ? SleepRecordDataFilter.FilterType.WATCH : SleepRecordDataFilter.FilterType.ACCEL).filter(list);
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }

    public static BitSet computeExcludedIndices(Events events, int i, int i2, long j) {
        if (i < 10007 || !Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
            return new BitSet();
        }
        BitSet bitSet = new BitSet();
        List<Event> copiedEvents = events.getCopiedEvents();
        setForIntervals(bitSet, EventsUtil.getIntervals(copiedEvents, EventLabel.AWAKE_START, EventLabel.AWAKE_END), i2, j, 60000L);
        setForIntervals(bitSet, EventsUtil.getIntervals(copiedEvents, EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED), i2, j, 60000L);
        setForIntervals(bitSet, EventsUtil.getIntervals(copiedEvents, EventLabel.WALKING_START, EventLabel.WALKING_END), i2, j, 60000L);
        List<IEvent> events2 = EventsUtil.getEvents(copiedEvents, EventLabel.ALARM_STARTED);
        if (!events2.isEmpty()) {
            long timestamp = events2.get(0).getTimestamp();
            if (timestamp <= j) {
                setForInterval(bitSet, new com.urbandroid.sleep.domain.interval.Interval(timestamp, j), i2, j, 1000L);
            }
        }
        bitSet.set(0, Math.min(i2 / 5, 60));
        if (bitSet.cardinality() > ((double) i2) * 0.66d) {
            bitSet.clear();
        }
        return bitSet;
    }

    public static void computeHypnogramFromActigraph(SleepRecord sleepRecord) {
        if (sleepRecord.getVersion() < 10007 || !sleepRecord.getEvents().hasLabel(EventLabel.DHA)) {
            computeHypnogramFromActigraphOld(sleepRecord);
        } else {
            SleepRecordHypnogramKt.computeHypnogramFromActigraphNew(sleepRecord);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void computeHypnogramFromActigraphOld(SleepRecord sleepRecord) {
        int i;
        int i2;
        boolean z;
        float f;
        int i3;
        int i4;
        Logger.logInfo("Compute hypnogram old");
        List<Float> filteredHistory = sleepRecord.getFilteredHistory();
        Events events = sleepRecord.getEvents();
        events.clearLabels(EventLabel.DEEP_START, EventLabel.DEEP_END, EventLabel.LIGHT_START, EventLabel.LIGHT_END, EventLabel.REM_START, EventLabel.REM_END, EventLabel.BROKEN_START, EventLabel.BROKEN_END);
        long fromTime = sleepRecord.getFromTime();
        long toTime = sleepRecord.getToTime();
        int size = filteredHistory.size();
        int version = sleepRecord.getVersion();
        boolean z2 = version >= 10007;
        long millisPerPoint = getMillisPerPoint(version, fromTime, toTime, size);
        if (((long) size) * millisPerPoint > 1200000) {
            int minDeepSleepLength = getMinDeepSleepLength(version, sleepRecord.getComment());
            float deepSleepThreshold = getDeepSleepThreshold(filteredHistory, version);
            Logger.logInfo("SleepRecord: GraphView deep sleep threshold " + deepSleepThreshold);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (Float f2 : filteredHistory) {
                long j = millisPerPoint;
                long j2 = (((long) i5) * j) + fromTime;
                if (f2 == null || (f2.floatValue() <= deepSleepThreshold && f2.floatValue() >= 0.0f)) {
                    z = z2;
                    f = deepSleepThreshold;
                    i3 = size;
                    i4 = i5;
                    i6++;
                    i8++;
                    if (i10 > 0) {
                        sleepRecord.addEventLabel(EventLabel.BROKEN_END, j2);
                        i10 = 0;
                    }
                } else {
                    if (f2.floatValue() >= 0.0f) {
                        i9++;
                        if (i10 > 0) {
                            sleepRecord.addEventLabel(EventLabel.BROKEN_END, j2);
                            i10 = 0;
                        }
                    } else {
                        if (i10 == 0) {
                            sleepRecord.addEventLabel(EventLabel.BROKEN_START, j2);
                        }
                        i10++;
                    }
                    z = z2;
                    f = deepSleepThreshold;
                    if (i6 > 0) {
                        long j3 = ((long) i6) * j;
                        if (j3 < minDeepSleepLength) {
                            i8 -= i6;
                            i9 += i6;
                            i3 = size;
                            i4 = i5;
                            i6 = 0;
                        } else {
                            long j4 = (((long) (i5 - i6)) * j) + fromTime;
                            if (i5 == size - 1) {
                                j2 = toTime;
                            }
                            sleepRecord.addEventLabel(EventLabel.DEEP_START, j4);
                            sleepRecord.addEventLabel(EventLabel.DEEP_END, j2);
                            if (z || j3 <= 2400000) {
                                i3 = size;
                                i4 = i5;
                            } else {
                                i3 = size;
                                i4 = i5;
                                sleepRecord.addEventLabel(EventLabel.REM_START, j2 - 1200000);
                                sleepRecord.addEventLabel(EventLabel.REM_END, j2);
                            }
                            i7++;
                            i6 = 0;
                        }
                    } else {
                        i3 = size;
                        i4 = i5;
                        i6 = 0;
                    }
                }
                i5 = i4 + 1;
                size = i3;
                z2 = z;
                deepSleepThreshold = f;
                millisPerPoint = j;
            }
            int i11 = i5;
            long j5 = millisPerPoint;
            boolean z3 = z2;
            if (i6 > 0 && ((long) i6) * j5 < minDeepSleepLength) {
                i8 -= i6;
                i9 += i6;
            } else if (i6 > 0) {
                i7++;
                sleepRecord.addEventLabel(EventLabel.DEEP_START, (((long) (i11 - i6)) * j5) + fromTime);
                sleepRecord.addEventLabel(EventLabel.DEEP_END, toTime);
            }
            int i12 = i7;
            int i13 = i8;
            if (i10 > 0) {
                sleepRecord.addEventLabel(EventLabel.BROKEN_END, toTime);
            }
            float f3 = i13 / (i13 + i9);
            Logger.logInfo("Deep sleep % " + f3);
            if (f3 <= 0.0f || f3 >= 1.0f) {
                sleepRecord.setQuality(-1.0f);
            } else {
                sleepRecord.setQuality(f3);
                sleepRecord.setCycles(i12);
                List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(events.getCopiedEvents(), EventLabel.BROKEN_START, EventLabel.BROKEN_END);
                List<com.urbandroid.sleep.domain.interval.Interval> intervals2 = EventsUtil.getIntervals(events.getCopiedEvents(), EventLabel.DEEP_START, EventLabel.DEEP_END);
                if (intervals.size() > 0) {
                    intervals2.addAll(intervals);
                    Collections.sort(intervals2, new Comparator<com.urbandroid.sleep.domain.interval.Interval>() { // from class: com.urbandroid.sleep.domain.SleepRecordHypnogram.1
                        @Override // java.util.Comparator
                        public int compare(com.urbandroid.sleep.domain.interval.Interval interval, com.urbandroid.sleep.domain.interval.Interval interval2) {
                            return new Long(interval.getFrom()).compareTo(Long.valueOf(interval2.getFrom()));
                        }
                    });
                }
                if (intervals2.size() != 0) {
                    if (intervals2.size() > 0) {
                        i = 0;
                        if (intervals2.get(0).getFrom() != fromTime) {
                        }
                    } else {
                        i = 0;
                    }
                    if (intervals2.size() != 0 || (intervals2.size() > 0 && ((com.urbandroid.sleep.domain.interval.Interval) FileInsert$$ExternalSyntheticOutline0.m(intervals2, 1)).getTo() != toTime)) {
                        intervals2.add(new com.urbandroid.sleep.domain.interval.Interval(toTime, toTime));
                    }
                    i2 = i;
                    while (i2 < intervals2.size() - 1) {
                        com.urbandroid.sleep.domain.interval.Interval interval = intervals2.get(i2);
                        i2++;
                        com.urbandroid.sleep.domain.interval.Interval interval2 = intervals2.get(i2);
                        if (interval2.getFrom() > interval.getTo()) {
                            sleepRecord.addEventLabel(EventLabel.LIGHT_START, interval.getTo());
                            sleepRecord.addEventLabel(EventLabel.LIGHT_END, interval2.getFrom());
                        }
                    }
                } else {
                    i = 0;
                }
                intervals2.add(i, new com.urbandroid.sleep.domain.interval.Interval(fromTime, fromTime));
                if (intervals2.size() != 0) {
                    intervals2.add(new com.urbandroid.sleep.domain.interval.Interval(toTime, toTime));
                    i2 = i;
                    while (i2 < intervals2.size() - 1) {
                    }
                }
            }
            if (z3) {
                for (EventInterval eventInterval : SleepRecordHypnogramKt.detectREM(events)) {
                    events.addEvent(eventInterval.getFrom());
                    events.addEvent(eventInterval.getTo());
                }
            }
        }
    }

    public static void computeHypnogramFromImportedEvents(SleepRecord sleepRecord) {
        int i = 0;
        List<Event> copiedEvents = new SleepRecordHealthSession(new SleepRecord(sleepRecord, false), new Events$$ExternalSyntheticBUOutline0(5)).toSegmentedSleepRecord().getEvents().getCopiedEvents();
        SleepSegmentType sleepSegmentType = SleepSegmentType.DEEP;
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(copiedEvents, sleepSegmentType.getStartLabel(), sleepSegmentType.getEndLabel());
        SleepSegmentType sleepSegmentType2 = SleepSegmentType.REM;
        List<com.urbandroid.sleep.domain.interval.Interval> intervals2 = EventsUtil.getIntervals(copiedEvents, sleepSegmentType2.getStartLabel(), sleepSegmentType2.getEndLabel());
        SleepSegmentType sleepSegmentType3 = SleepSegmentType.LIGHT;
        List<com.urbandroid.sleep.domain.interval.Interval> intervals3 = EventsUtil.getIntervals(copiedEvents, sleepSegmentType3.getStartLabel(), sleepSegmentType3.getEndLabel());
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = intervals.iterator();
        long length = 0;
        long length2 = 0;
        while (it.hasNext()) {
            length2 += it.next().getLength();
            i++;
        }
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it2 = intervals2.iterator();
        while (it2.hasNext()) {
            length += it2.next().getLength();
        }
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it3 = intervals3.iterator();
        while (it3.hasNext()) {
            length += it3.next().getLength();
        }
        float f = length2;
        float f2 = f / (length + f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            sleepRecord.setQuality(-1.0f);
        } else {
            sleepRecord.setQuality(f2);
            sleepRecord.setCycles(i);
        }
    }

    private static float getAverageOfNonNegativeValues(List<Float> list) {
        int i = 0;
        float fFloatValue = 0.0f;
        for (Float f : list) {
            if (f != null && f.floatValue() >= 0.0f) {
                fFloatValue += f.floatValue();
                i++;
            }
        }
        return fFloatValue / i;
    }

    public static float getDeepSleepThreshold(List<Float> list, int i) {
        if (i >= 10008) {
            return 3.1f;
        }
        if (i >= 10005) {
            return 3.3f;
        }
        return i > 10001 ? ScienceUtil.percentile((Float[]) list.toArray(new Float[0]), 65.0f) : getAverageOfNonNegativeValues(list);
    }

    public static long getMillisPerPoint(int i, long j, long j2, int i2) {
        if (i < 10005) {
            return (j2 - j) / ((long) i2);
        }
        long j3 = (j2 - j) / ((long) i2);
        if (j3 <= 25000) {
            return 10000L;
        }
        if (j3 <= 50000) {
            return 30000L;
        }
        return j3 <= 100000 ? 60000L : 300000L;
    }

    public static int getMinDeepSleepLength(int i, String str) {
        switch (i) {
            case 10000:
            case 10001:
            case 10002:
                return Tag.hasTag(str, Tag.WATCH) ? 960000 : 1190000;
            case 10003:
            case 10004:
                return 960000;
            case 10005:
            case 10006:
            case 10007:
                return (Tag.hasTag(str, Tag.WATCH) || Tag.hasTag(str, Tag.SONAR) || Tag.hasTag(str, Tag.PHASER)) ? 600000 : 900000;
            case 10008:
                return 900000;
            default:
                return Tag.hasTag(str, Tag.WATCH) ? 960000 : 1190000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$computeHypnogramFromImportedEvents$0(SleepRecord sleepRecord) {
        return "";
    }

    public static void setForInterval(BitSet bitSet, com.urbandroid.sleep.domain.interval.Interval interval, int i, long j, long j2) {
        int iMin = Math.min(timeStampToHistoryIndex(interval.getTo() + j2, i, j), i - 1);
        if (iMin < 0) {
            return;
        }
        for (int iMax = Math.max(timeStampToHistoryIndex(interval.getFrom() - j2, i, j), 0); iMax <= iMin; iMax++) {
            bitSet.set(iMax);
        }
    }

    public static void setForIntervals(BitSet bitSet, List<com.urbandroid.sleep.domain.interval.Interval> list, int i, long j, long j2) {
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = list.iterator();
        while (it.hasNext()) {
            setForInterval(bitSet, it.next(), i, j, j2);
        }
    }

    public static int timeStampToHistoryIndex(long j, int i, long j2) {
        return (i - 1) - ((int) ((j2 - j) / ((long) SleepService.FRAMERATE)));
    }
}
