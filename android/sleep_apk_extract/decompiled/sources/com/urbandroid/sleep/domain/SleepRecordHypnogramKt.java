package com.urbandroid.sleep.domain;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001aJ\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001aB\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f\u001a*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u0014\u0010\u001e\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010\u001a\u000e\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u0016H\u0002\u001a$\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00052\u0006\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u0005H\u0000¨\u0006*"}, d2 = {"computeHypnogramFromActigraphNew", "", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "computeHypnogramNew", "", "Lcom/urbandroid/sleep/domain/Event;", "history", "", "highActivityFreq", "", "from", "", "to", "millisPerPoint", "version", "", "tags", "", "classifyActivitySegments", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", "postProcessDeepIntervals", "", "deepLightBrokenPhases", "detectREM", "deepLightBrokenEvents", "events", "Lcom/urbandroid/sleep/domain/Events;", "minutes", "getDeepSleepRatio", "getNoOfDeepSleepCycles", "getHighActivityFrequency", "highActivityFlags", "Ljava/util/BitSet;", "targetSize", "aggregation", "clearRemAtAwake", "clearRemAtAwakeOld", "Lcom/urbandroid/sleep/domain/interval/Interval;", "rem", "awakes", "clearRemAtAwakeNew", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SleepRecordHypnogramKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<EventInterval> classifyActivitySegments(List<Float> list, float[] fArr, int i, long j, long j2, long j3) {
        ArrayList arrayList;
        EventPair eventPair;
        list.getClass();
        fArr.getClass();
        if (list.size() != fArr.length) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(list.size(), fArr.length, "history.size != highActivityFreq.size: ", " != "));
            return null;
        }
        float deepSleepThreshold = SleepRecordHypnogram.getDeepSleepThreshold(list, i);
        float fMin = Math.min(3 / ((int) (j3 / ((long) SleepService.FRAMERATE))), 0.1f);
        EventPair eventPair2 = new EventPair(EventLabel.DEEP_START, EventLabel.DEEP_END);
        EventPair eventPair3 = new EventPair(EventLabel.LIGHT_START, EventLabel.LIGHT_END);
        EventPair eventPair4 = new EventPair(EventLabel.BROKEN_START, EventLabel.BROKEN_END);
        IntRange intRangeUntil = RangesKt.until(0, list.size());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (list.get(iNextInt).floatValue() < 0.0f) {
                eventPair = eventPair4;
            } else if (list.get(iNextInt).floatValue() >= deepSleepThreshold) {
                float f = fArr[iNextInt];
                eventPair = (f <= 0.0f || f >= fMin) ? eventPair3 : eventPair2;
            }
            arrayList2.add(eventPair);
        }
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            EventPair eventPair5 = (EventPair) arrayList2.get(i2);
            EventPair eventPair6 = i2 == 0 ? null : (EventPair) arrayList2.get(i2 - 1);
            EventPair eventPair7 = i2 == CollectionsKt.getLastIndex(list) ? null : (EventPair) arrayList2.get(i2 + 1);
            if (Intrinsics.areEqual(eventPair6, eventPair5)) {
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                arrayList3.add(new Event((((long) i2) * j3) + j, eventPair5.getStart(), 0.0f));
            }
            if (!Intrinsics.areEqual(eventPair7, eventPair5)) {
                arrayList3.add(new Event((((long) (i2 + 1)) * j3) + j, eventPair5.getEnd(), 0.0f));
            }
            i2++;
            arrayList2 = arrayList;
        }
        if (!arrayList3.isEmpty() && ((Event) CollectionsKt.last((List) arrayList3)).getTimestamp() < j2) {
            int lastIndex = CollectionsKt.getLastIndex(arrayList3);
            Event eventWithTimestamp = ((Event) CollectionsKt.last((List) arrayList3)).withTimestamp(j2);
            eventWithTimestamp.getClass();
            arrayList3.set(lastIndex, eventWithTimestamp);
        }
        List<List> listChunked = CollectionsKt.chunked(arrayList3, 2);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
        for (List list2 : listChunked) {
            arrayList4.add(new EventInterval((Event) list2.get(0), (Event) list2.get(1)));
        }
        return arrayList4;
    }

    public static final void clearRemAtAwake(Events events) {
        ArrayList<com.urbandroid.sleep.domain.interval.Interval> arrayList;
        events.getClass();
        long jMinutes = minutes(5);
        List<Event> copiedEvents = events.getCopiedEvents();
        EventLabel eventLabel = EventLabel.REM_START;
        EventLabel eventLabel2 = EventLabel.REM_END;
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(copiedEvents, eventLabel, eventLabel2);
        List<com.urbandroid.sleep.domain.interval.Interval> intervals2 = EventsUtil.getIntervals(copiedEvents, EventLabel.AWAKE_START, EventLabel.AWAKE_END);
        events.clearLabels(eventLabel, eventLabel2);
        if (Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
            intervals.getClass();
            ArrayList arrayList2 = new ArrayList();
            for (com.urbandroid.sleep.domain.interval.Interval interval : intervals) {
                interval.getClass();
                intervals2.getClass();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, clearRemAtAwakeNew(interval, intervals2));
            }
            arrayList = new ArrayList();
            for (Object obj : arrayList2) {
                if (((com.urbandroid.sleep.domain.interval.Interval) obj).getLength() >= jMinutes) {
                    arrayList.add(obj);
                }
            }
        } else {
            intervals.getClass();
            List<com.urbandroid.sleep.domain.interval.Interval> list = intervals;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (com.urbandroid.sleep.domain.interval.Interval interval2 : list) {
                interval2.getClass();
                intervals2.getClass();
                arrayList3.add(clearRemAtAwakeOld(interval2, intervals2));
            }
            arrayList = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (((com.urbandroid.sleep.domain.interval.Interval) obj2).getLength() >= jMinutes) {
                    arrayList.add(obj2);
                }
            }
        }
        for (com.urbandroid.sleep.domain.interval.Interval interval3 : arrayList) {
            events.addEvent(interval3.getFrom(), EventLabel.REM_START);
            events.addEvent(interval3.getTo(), EventLabel.REM_END);
        }
    }

    public static final List<com.urbandroid.sleep.domain.interval.Interval> clearRemAtAwakeNew(com.urbandroid.sleep.domain.interval.Interval interval, List<? extends com.urbandroid.sleep.domain.interval.Interval> list) {
        com.urbandroid.sleep.domain.interval.Interval interval2;
        interval.getClass();
        list.getClass();
        com.urbandroid.sleep.domain.interval.Interval interval3 = new com.urbandroid.sleep.domain.interval.Interval(0L, 0L);
        ArrayList arrayList = new ArrayList();
        for (com.urbandroid.sleep.domain.interval.Interval interval4 : list) {
            if (interval.getTo() <= interval4.getFrom()) {
                break;
            }
            if (interval4.getIntersection(interval) != null) {
                if (interval4.getFrom() <= interval.getFrom() && interval4.getTo() >= interval.getTo()) {
                    break;
                }
                if (interval4.getFrom() > interval.getFrom()) {
                    if (interval4.getTo() >= interval.getTo()) {
                        interval3 = new com.urbandroid.sleep.domain.interval.Interval(interval.getFrom(), interval4.getFrom());
                        break;
                    }
                    arrayList.add(new com.urbandroid.sleep.domain.interval.Interval(interval.getFrom(), interval4.getFrom()));
                    if (interval4.getLength() >= 360000) {
                        break;
                    }
                    interval2 = new com.urbandroid.sleep.domain.interval.Interval(interval4.getTo(), interval.getTo());
                    interval = interval2;
                } else {
                    if (interval4.getLength() >= 360000) {
                        break;
                    }
                    interval2 = new com.urbandroid.sleep.domain.interval.Interval(interval4.getTo(), interval.getTo());
                    interval = interval2;
                }
            }
        }
        interval3 = interval;
        if (interval3.getLength() > 0) {
            arrayList.add(interval3);
        }
        return arrayList;
    }

    private static final com.urbandroid.sleep.domain.interval.Interval clearRemAtAwakeOld(com.urbandroid.sleep.domain.interval.Interval interval, List<com.urbandroid.sleep.domain.interval.Interval> list) {
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = list.iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            com.urbandroid.sleep.domain.interval.Interval intersection = it.next().getIntersection(interval);
            if (intersection != null) {
                jMin = Math.min(jMin, intersection.getFrom());
            }
        }
        return (jMin < interval.getFrom() || jMin >= interval.getTo()) ? interval : new com.urbandroid.sleep.domain.interval.Interval(interval.getFrom(), jMin);
    }

    public static final void computeHypnogramFromActigraphNew(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Logger.logInfo("Compute hypnogram new");
        int version = sleepRecord.getVersion();
        if (version < 10007) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(Fragment$$ExternalSyntheticOutline1.m(version, "version < V8: ", " < 10007"));
            return;
        }
        long fromTime = sleepRecord.getFromTime();
        long toTime = sleepRecord.getToTime();
        List<Float> filteredHistory = sleepRecord.getFilteredHistory();
        long millisPerPoint = SleepRecordHypnogram.getMillisPerPoint(version, fromTime, toTime, filteredHistory.size());
        int i = (int) (millisPerPoint / ((long) SleepService.FRAMERATE));
        Events events = sleepRecord.getEvents();
        events.getClass();
        float[] highActivityFrequency = getHighActivityFrequency(EventsRawStorageKt.readBitSet(events, EventLabel.DHA), filteredHistory.size(), i);
        String comment = sleepRecord.getComment();
        comment.getClass();
        List<Event> listComputeHypnogramNew = computeHypnogramNew(filteredHistory, highActivityFrequency, fromTime, toTime, millisPerPoint, version, comment);
        sleepRecord.getEvents().clearLabels(EventLabel.DEEP_START, EventLabel.DEEP_END, EventLabel.LIGHT_START, EventLabel.LIGHT_END, EventLabel.REM_START, EventLabel.REM_END, EventLabel.BROKEN_START, EventLabel.BROKEN_END);
        Iterator<T> it = listComputeHypnogramNew.iterator();
        while (it.hasNext()) {
            sleepRecord.getEvents().addEvent((Event) it.next());
        }
        sleepRecord.setQuality(getDeepSleepRatio(listComputeHypnogramNew));
        sleepRecord.setCycles(getNoOfDeepSleepCycles(listComputeHypnogramNew));
    }

    public static final List<Event> computeHypnogramNew(List<Float> list, float[] fArr, long j, long j2, long j3, int i, String str) {
        list.getClass();
        fArr.getClass();
        str.getClass();
        if (((long) list.size()) * j3 <= 1200000) {
            return CollectionsKt.emptyList();
        }
        List<EventInterval> listPostProcessDeepIntervals = postProcessDeepIntervals(classifyActivitySegments(list, fArr, i, j, j2, j3), i, str);
        List<EventInterval> listPlus = CollectionsKt.plus((Collection) listPostProcessDeepIntervals, (Iterable) detectREM(listPostProcessDeepIntervals));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        for (EventInterval eventInterval : listPlus) {
            arrayList.add(CollectionsKt.listOf((Object[]) new Event[]{eventInterval.getFrom(), eventInterval.getTo()}));
        }
        return CollectionsKt.flatten(arrayList);
    }

    public static final List<EventInterval> detectREM(List<EventInterval> list) {
        long j;
        long j2;
        long j3;
        list.getClass();
        long jMinutes = minutes(10);
        long jMinutes2 = minutes(15);
        long jMinutes3 = minutes(10);
        long jMinutes4 = minutes(5);
        int i = 50;
        long jMinutes5 = minutes(50);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 1;
        while (i2 < size) {
            EventInterval eventInterval = list.get(i2 - 1);
            long length = eventInterval.toInterval().getLength();
            int i3 = i;
            if (eventInterval.getFrom().getLabel() != EventLabel.DEEP_START || length < jMinutes) {
                j = jMinutes;
            } else {
                EventInterval eventInterval2 = list.get(i2);
                long length2 = eventInterval2.toInterval().getLength();
                j = jMinutes;
                if (eventInterval2.getFrom().getLabel() == EventLabel.LIGHT_START && length2 >= jMinutes2) {
                    long timestamp = eventInterval2.getFrom().getTimestamp() + jMinutes3;
                    j2 = jMinutes2;
                    long j4 = length2 - jMinutes3;
                    j3 = jMinutes3;
                    long jMin = Math.min(j4, Math.min(jMinutes5, Math.max(jMinutes4, (((j4 / jMinutes4) + 1) / 2) * jMinutes4))) + timestamp;
                    long timestamp2 = list.get(0).getFrom().getTimestamp() + minutes(i3);
                    if (timestamp2 <= timestamp) {
                        arrayList.add(new EventInterval(new Event(timestamp, EventLabel.REM_START, 0.0f), new Event(jMin, EventLabel.REM_END, 0.0f)));
                    } else if (jMin - timestamp2 >= jMinutes4) {
                        arrayList.add(new EventInterval(new Event(timestamp2, EventLabel.REM_START, 0.0f), new Event(jMin, EventLabel.REM_END, 0.0f)));
                    }
                }
                i2++;
                i = i3;
                jMinutes = j;
                jMinutes2 = j2;
                jMinutes3 = j3;
            }
            j2 = jMinutes2;
            j3 = jMinutes3;
            i2++;
            i = i3;
            jMinutes = j;
            jMinutes2 = j2;
            jMinutes3 = j3;
        }
        return arrayList;
    }

    public static final float getDeepSleepRatio(List<? extends Event> list) {
        list.getClass();
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(list, EventLabel.DEEP_START, EventLabel.DEEP_END);
        intervals.getClass();
        List<com.urbandroid.sleep.domain.interval.Interval> list2 = intervals;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (com.urbandroid.sleep.domain.interval.Interval interval : list2) {
            arrayList.add(Long.valueOf(interval.getTo() - interval.getFrom()));
        }
        long jSumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
        List<com.urbandroid.sleep.domain.interval.Interval> intervals2 = EventsUtil.getIntervals(list, EventLabel.LIGHT_START, EventLabel.LIGHT_END);
        intervals2.getClass();
        List<com.urbandroid.sleep.domain.interval.Interval> list3 = intervals2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (com.urbandroid.sleep.domain.interval.Interval interval2 : list3) {
            arrayList2.add(Long.valueOf(interval2.getTo() - interval2.getFrom()));
        }
        long jSumOfLong2 = CollectionsKt___CollectionsKt.sumOfLong(arrayList2);
        if (jSumOfLong + jSumOfLong2 <= 0) {
            return -1.0f;
        }
        float f = jSumOfLong;
        return f / (jSumOfLong2 + f);
    }

    public static final float[] getHighActivityFrequency(BitSet bitSet, int i, int i2) {
        bitSet.getClass();
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "targetSize: ", " < 0"));
            return null;
        }
        if (i2 <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i2, "aggregation: ", " <= 0"));
            return null;
        }
        int i3 = i * i2;
        float[] fArr = new float[i3];
        int iMin = Math.min(bitSet.length(), i3);
        for (int i4 = 0; i4 < iMin; i4++) {
            if (bitSet.get(i4)) {
                fArr[i4] = 1.0f;
            }
        }
        float[] fArrDecimate = ScienceUtil.decimate(ScienceUtil.movingAverage(fArr, i2), i2);
        fArrDecimate.getClass();
        return fArrDecimate;
    }

    public static final int getNoOfDeepSleepCycles(List<? extends Event> list) {
        list.getClass();
        return EventsUtil.getIntervals(list, EventLabel.DEEP_START, EventLabel.DEEP_END).size();
    }

    private static final long minutes(int i) {
        return ((long) i) * 60000;
    }

    public static final List<EventInterval> postProcessDeepIntervals(List<EventInterval> list, int i, String str) {
        list.getClass();
        str.getClass();
        int minDeepSleepLength = SleepRecordHypnogram.getMinDeepSleepLength(i, str);
        List<EventInterval> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (EventInterval eventInterval : list2) {
            if (eventInterval.getFrom().getLabel() == EventLabel.DEEP_START && eventInterval.toInterval().getLength() < minDeepSleepLength) {
                Event eventWithLabel = eventInterval.getFrom().withLabel(EventLabel.LIGHT_START);
                eventWithLabel.getClass();
                Event eventWithLabel2 = eventInterval.getTo().withLabel(EventLabel.LIGHT_END);
                eventWithLabel2.getClass();
                eventInterval = new EventInterval(eventWithLabel, eventWithLabel2);
            }
            arrayList.add(eventInterval);
        }
        Event event = new Event();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            EventInterval eventInterval2 = (EventInterval) arrayList.get(i2);
            EventLabel label = eventInterval2.getFrom().getLabel();
            EventLabel eventLabel = EventLabel.LIGHT_START;
            if (label == eventLabel) {
                EventInterval eventInterval3 = i2 == 0 ? null : (EventInterval) arrayList.get(i2 - 1);
                EventInterval eventInterval4 = i2 != CollectionsKt.getLastIndex(arrayList) ? (EventInterval) arrayList.get(i2 + 1) : null;
                if (eventInterval3 == null || eventInterval3.getFrom().getLabel() != eventLabel) {
                    event = eventInterval2.getFrom();
                }
                if (eventInterval4 == null || eventInterval4.getFrom().getLabel() != eventLabel) {
                    arrayList2.add(new EventInterval(event, eventInterval2.getTo()));
                }
            } else {
                arrayList2.add(eventInterval2);
            }
            i2++;
        }
        return arrayList2;
    }

    public static final List<EventInterval> detectREM(Events events) {
        events.getClass();
        ArrayList arrayList = new ArrayList();
        List<Event> copiedEvents = events.getCopiedEvents();
        List<EventInterval> eventIntervals = EventsUtil.getEventIntervals(copiedEvents, EventLabel.DEEP_START, EventLabel.DEEP_END);
        eventIntervals.getClass();
        arrayList.addAll(eventIntervals);
        List<EventInterval> eventIntervals2 = EventsUtil.getEventIntervals(copiedEvents, EventLabel.LIGHT_START, EventLabel.LIGHT_END);
        eventIntervals2.getClass();
        arrayList.addAll(eventIntervals2);
        List<EventInterval> eventIntervals3 = EventsUtil.getEventIntervals(copiedEvents, EventLabel.BROKEN_START, EventLabel.BROKEN_END);
        eventIntervals3.getClass();
        arrayList.addAll(eventIntervals3);
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.urbandroid.sleep.domain.SleepRecordHypnogramKt$detectREM$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((EventInterval) t).getFrom().getTimestamp()), Long.valueOf(((EventInterval) t2).getFrom().getTimestamp()));
                }
            });
        }
        return detectREM(arrayList);
    }
}
