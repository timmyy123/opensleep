package com.urbandroid.sleep.domain;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.util.ScienceUtil;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventsUtil {
    public static void clearIntervalOverlaps(Events events, EventPair eventPair, EventPair eventPair2) {
        List<Event> copiedEvents = events.getCopiedEvents();
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = getIntervals(copiedEvents, eventPair.getStart(), eventPair.getEnd());
        List<com.urbandroid.sleep.domain.interval.Interval> intervals2 = getIntervals(copiedEvents, eventPair2.getStart(), eventPair2.getEnd());
        for (com.urbandroid.sleep.domain.interval.Interval interval : intervals) {
            ArrayList arrayList = new ArrayList();
            for (com.urbandroid.sleep.domain.interval.Interval interval2 : intervals2) {
                if (interval2.hasIntersection(interval)) {
                    Collection<com.urbandroid.sleep.domain.interval.Interval> collectionSubtract = interval2.subtract(interval);
                    if (collectionSubtract != null) {
                        arrayList.addAll(collectionSubtract);
                    }
                } else {
                    arrayList.add(interval2);
                }
            }
            intervals2 = arrayList;
        }
        events.clearLabels(eventPair2.getStart(), eventPair2.getEnd());
        for (com.urbandroid.sleep.domain.interval.Interval interval3 : intervals2) {
            events.addEvent(interval3.getFrom(), eventPair2.getStart());
            events.addEvent(interval3.getTo(), eventPair2.getEnd());
        }
    }

    public static void clearSleepRecordOverlaps(long j, long j2, Events events, EventPair eventPair) {
        Logger.logInfo("Awake clearOverlap adding " + eventPair);
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = getIntervals(events.getCopiedEvents(), eventPair.getStart(), eventPair.getEnd());
        events.clearLabels(eventPair.getStart(), eventPair.getEnd());
        com.urbandroid.sleep.domain.interval.Interval interval = new com.urbandroid.sleep.domain.interval.Interval(j, j2);
        for (com.urbandroid.sleep.domain.interval.Interval interval2 : intervals) {
            com.urbandroid.sleep.domain.interval.Interval intersection = interval.getIntersection(interval2);
            if (intersection != null) {
                if (eventPair.getStart() == EventLabel.AWAKE_START) {
                    Logger.logInfo("Awake clearOverlap adding " + eventPair + " is" + intersection + " i" + interval2);
                }
                events.addEvent(intersection.getFrom(), eventPair.getStart());
                events.addEvent(intersection.getTo(), eventPair.getEnd());
            } else {
                Logger.logInfo("clearOverlap no interval " + eventPair + " i" + interval2);
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder("Awake no intersection ");
                sb.append(interval2);
                printStream.println(sb.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void compressEventLabel(SleepRecord sleepRecord, EventLabel eventLabel, long j, long j2, boolean z) {
        long j3 = j / 2;
        long j4 = z ? j3 : j;
        long fromTime = sleepRecord.getFromTime();
        long toTime = sleepRecord.getToTime();
        List<Event> copiedEvents = sleepRecord.getEvents().getCopiedEvents();
        List<IEvent> events = getEvents(copiedEvents, eventLabel);
        long j5 = toTime - fromTime;
        long jAbs = Math.abs(j - j2) / 2;
        if (events.size() < 20) {
            return;
        }
        int i = 1;
        long j6 = -1;
        while (i < events.size() - 1) {
            int i2 = i + 1;
            long timestamp = events.get(i2).getTimestamp() - events.get(i).getTimestamp();
            long timestamp2 = events.get(i).getTimestamp() - events.get(i - 1).getTimestamp();
            if (j6 != -1) {
                if (timestamp < j6) {
                    j6 = timestamp;
                } else if (timestamp2 < j6) {
                    j6 = timestamp2;
                }
            }
            i = i2;
        }
        if (j6 == -1 || j6 >= j4 - 1) {
            Logger.logInfo("SleepRecord: not doing compression " + j6);
            return;
        }
        if (j5 <= 3600000 || j5 / j >= 200) {
            return;
        }
        Logger.logInfo("SleepRecord: compression " + eventLabel + " minDiff " + j6);
        sleepRecord.getEvents().clearLabels(eventLabel);
        while (fromTime <= toTime) {
            List<IEvent> events2 = getEvents(copiedEvents, (fromTime - jAbs) + 1, fromTime + j + jAbs, eventLabel);
            if (events2 != null && events2.size() > 0) {
                if (eventLabel.hasValue()) {
                    int size = events2.size();
                    float[] fArr = new float[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        fArr[i3] = events2.get(i3).getValue();
                    }
                    sleepRecord.getEvents().addEvent(fromTime + j3, eventLabel, ScienceUtil.avg(fArr));
                } else {
                    sleepRecord.getEvents().addEvent(fromTime + j3, eventLabel);
                }
            }
            fromTime += j4;
        }
    }

    public static void filterRare(SleepRecord sleepRecord, EventLabel eventLabel, long j) {
        List<IEvent> events = getEvents(sleepRecord.getEvents().getCopiedEvents(), eventLabel);
        sleepRecord.getEvents().clearLabels(eventLabel);
        int i = 0;
        while (i < events.size()) {
            int i2 = i + 1;
            long timestamp = events.get(Math.min(i2, events.size() - 1)).getTimestamp() - events.get(i).getTimestamp();
            long timestamp2 = events.get(i).getTimestamp() - events.get(Math.max(0, i - 1)).getTimestamp();
            long jMin = Math.min(timestamp, timestamp2);
            if (jMin == 0) {
                jMin = Math.max(timestamp, timestamp2);
            }
            if (jMin < j) {
                sleepRecord.getEvents().addEvent(events.get(i));
            }
            i = i2;
        }
    }

    public static List<EventInterval> getEventIntervals(List<? extends Event> list, EventLabel eventLabel, EventLabel eventLabel2) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (Event event : list) {
            if (event.getLabel() == eventLabel) {
                linkedList.add(event);
            } else if (event.getLabel() == eventLabel2 && !linkedList.isEmpty()) {
                arrayList.add(new EventInterval((Event) linkedList.removeFirst(), event));
            }
        }
        return arrayList;
    }

    public static List<IEvent> getEvents(List<? extends IEvent> list, long j, long j2, EventLabel... eventLabelArr) {
        ArrayList arrayList = new ArrayList();
        for (IEvent iEvent : list) {
            for (EventLabel eventLabel : eventLabelArr) {
                if (eventLabel == iEvent.getLabel() && iEvent.getTimestamp() >= j && iEvent.getTimestamp() <= j2) {
                    arrayList.add(iEvent);
                }
            }
        }
        return arrayList;
    }

    public static List<com.urbandroid.sleep.domain.interval.Interval> getIntervals(List<? extends IEvent> list, EventLabel eventLabel, EventLabel eventLabel2) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (IEvent iEvent : list) {
            if (iEvent.getLabel() == eventLabel) {
                linkedList.add(Long.valueOf(iEvent.getTimestamp()));
            } else if (iEvent.getLabel() == eventLabel2 && linkedList.size() > 0) {
                arrayList.add(new com.urbandroid.sleep.domain.interval.Interval(((Long) linkedList.removeLast()).longValue(), iEvent.getTimestamp()));
            }
        }
        return arrayList;
    }

    public static com.urbandroid.sleep.domain.interval.Interval getUnionInterval(Events events, com.urbandroid.sleep.domain.interval.Interval interval, EventPair eventPair) {
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = getIntervals(events.getCopiedEvents(), eventPair.getStart(), eventPair.getEnd());
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = intervals.iterator();
        while (it.hasNext()) {
            com.urbandroid.sleep.domain.interval.Interval union = interval.getUnion(it.next());
            if (union != null) {
                interval = union;
            }
        }
        Collections.reverse(intervals);
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it2 = intervals.iterator();
        while (it2.hasNext()) {
            com.urbandroid.sleep.domain.interval.Interval union2 = interval.getUnion(it2.next());
            if (union2 != null) {
                interval = union2;
            }
        }
        return interval;
    }

    public static void logInterval(List<? extends IEvent> list, EventLabel eventLabel, EventLabel eventLabel2) {
        new SimpleDateFormat("H:mm");
        for (com.urbandroid.sleep.domain.interval.Interval interval : getIntervals(list, eventLabel, eventLabel2)) {
            Logger.logInfo("SleepRecord: interval " + eventLabel.name() + ":" + eventLabel2.name() + ":" + interval + " l=" + (interval.getLength() / 60000));
        }
    }

    public static void mergeOverlaps(SleepRecord sleepRecord, EventPair eventPair, long j, long j2) {
        Logger.logInfo("Event: merge " + eventPair);
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = getIntervals(sleepRecord.getEvents().getCopiedEvents(), eventPair);
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = intervals.iterator();
        while (it.hasNext()) {
            Logger.logInfo("Event: merge Before " + it.next());
        }
        if (intervals.size() > 1) {
            sleepRecord.getEvents().clearLabels(eventPair.getStart(), eventPair.getEnd());
            ArrayList<EventInterval> arrayList = new ArrayList();
            com.urbandroid.sleep.domain.interval.Interval interval = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                com.urbandroid.sleep.domain.interval.Interval interval2 = intervals.get(i);
                if (interval2.getFrom() - interval.getTo() <= j) {
                    interval = new com.urbandroid.sleep.domain.interval.Interval(interval.getFrom(), interval2.getTo());
                } else {
                    long from = interval.getFrom();
                    long to = interval.getTo();
                    if (j2 > 0 && interval.getLength() < j2) {
                        from = Math.max(to - j2, sleepRecord.getFromTime());
                    }
                    arrayList.add(new EventInterval(new Event(from, eventPair.getStart(), 0.0f), new Event(to, eventPair.getEnd(), 0.0f)));
                    interval = interval2;
                }
            }
            long from2 = interval.getFrom();
            long to2 = interval.getTo();
            if (j2 > 0 && interval.getLength() < j2) {
                from2 = Math.max(to2 - j2, sleepRecord.getFromTime());
            }
            arrayList.add(new EventInterval(new Event(from2, eventPair.getStart(), 0.0f), new Event(to2, eventPair.getEnd(), 0.0f)));
            for (EventInterval eventInterval : arrayList) {
                Logger.logInfo("Event: merge After " + eventInterval.toInterval());
                sleepRecord.getEvents().addEvent(eventInterval);
            }
        }
    }

    public static void mergeUnionInterval(Events events, com.urbandroid.sleep.domain.interval.Interval interval, EventPair eventPair) {
        com.urbandroid.sleep.domain.interval.Interval unionInterval = getUnionInterval(events, interval, eventPair);
        Logger.logInfo("Union, clear: " + unionInterval + " " + eventPair.getStart() + " <-> " + eventPair.getEnd());
        events.clearLabels(unionInterval.getFrom(), unionInterval.getTo(), eventPair.getStart(), eventPair.getEnd());
        events.addEvent(unionInterval.getFrom(), eventPair.getStart());
        events.addEvent(unionInterval.getTo(), eventPair.getEnd());
    }

    public static Event unmarshal(String str) {
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length == 3) {
            return new Event(Long.parseLong(strArrSplit[0]), EventLabel.valueOf(strArrSplit[1]), Float.parseFloat(strArrSplit[2]));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
        return null;
    }

    public static List<IEvent> getEvents(List<? extends IEvent> list, EventLabel... eventLabelArr) {
        ArrayList arrayList = new ArrayList();
        for (IEvent iEvent : list) {
            if (iEvent != null) {
                for (EventLabel eventLabel : eventLabelArr) {
                    if (iEvent.getLabel() == eventLabel) {
                        arrayList.add(iEvent);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<com.urbandroid.sleep.domain.interval.Interval> getIntervals(List<? extends IEvent> list, EventPair eventPair) {
        return getIntervals(list, eventPair.getStart(), eventPair.getEnd());
    }

    public static List<com.urbandroid.sleep.domain.interval.Interval> getIntervals(List<? extends IEvent> list, EventLabel eventLabel) {
        ArrayList arrayList = new ArrayList();
        for (IEvent iEvent : list) {
            if (iEvent.getLabel() == eventLabel) {
                arrayList.add(new com.urbandroid.sleep.domain.interval.Interval(iEvent.getTimestamp(), iEvent.getTimestamp()));
            }
        }
        return arrayList;
    }

    public static void clearSleepRecordOverlaps(long j, long j2, Events events, EventLabel... eventLabelArr) {
        List<IEvent> events2 = getEvents(events.getCopiedEvents(), eventLabelArr);
        events.clearLabels(eventLabelArr);
        com.urbandroid.sleep.domain.interval.Interval interval = new com.urbandroid.sleep.domain.interval.Interval(j, j2);
        for (IEvent iEvent : events2) {
            if (interval.isIn(iEvent.getTimestamp())) {
                events.addEvent(iEvent.getTimestamp(), iEvent.getLabel(), iEvent.getValue());
            }
        }
    }

    public static void mergeOverlaps(SleepRecord sleepRecord, EventPair eventPair, long j) {
        mergeOverlaps(sleepRecord, eventPair, j, -1L);
    }

    public static void compressEventLabel(SleepRecord sleepRecord, EventLabel eventLabel, long j, boolean z) {
        compressEventLabel(sleepRecord, eventLabel, j, j, false);
    }
}
