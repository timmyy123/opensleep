package com.urbandroid.sleep;

import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecordKt;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicFloatKt;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0016\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001d\u001a\u00020\u0014*\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0019\u0010!\u001a\u00020\u0014*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/domain/SleepRecord;", "", "toAsciiRating", "(Lcom/urbandroid/sleep/domain/SleepRecord;)Ljava/lang/String;", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", "", "timestamp", "", "contains", "(Lcom/urbandroid/sleep/domain/interval/EventInterval;J)Z", "length", "(Lcom/urbandroid/sleep/domain/interval/EventInterval;)J", "Lcom/urbandroid/sleep/domain/EventLabel;", "toAscii", "(Lcom/urbandroid/sleep/domain/EventLabel;)Ljava/lang/String;", "start", "end", "slice", "(Lcom/urbandroid/sleep/domain/interval/EventInterval;JJ)Lcom/urbandroid/sleep/domain/interval/EventInterval;", "Lcom/urbandroid/sleep/EventLabelLength;", "", "factor", "expand", "(Lcom/urbandroid/sleep/EventLabelLength;F)Lcom/urbandroid/sleep/EventLabelLength;", "", "windowInMinutes", "toAsciiHypnogram", "(Lcom/urbandroid/sleep/domain/SleepRecord;ILjava/lang/Integer;)Ljava/lang/String;", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "getSleepIrregularityAgainstSettings", "(Lcom/urbandroid/sleep/addon/stats/model/StatRecord;)F", "Lcom/urbandroid/sleep/domain/interval/EventPair;", "pair", "getEventLabelPercentage", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/domain/interval/EventPair;)F", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SleeprecordExtKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventLabel.values().length];
            try {
                iArr[EventLabel.AWAKE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventLabel.LIGHT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventLabel.REM_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventLabel.DEEP_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventLabel.BROKEN_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final boolean contains(EventInterval eventInterval, long j) {
        eventInterval.getClass();
        return j <= eventInterval.getTo().getTimestamp() && eventInterval.getFrom().getTimestamp() <= j;
    }

    private static final EventLabelLength expand(EventLabelLength eventLabelLength, float f) {
        return EventLabelLength.copy$default(eventLabelLength, null, (long) (eventLabelLength.getLength() * f), 1, null);
    }

    public static final float getEventLabelPercentage(SleepRecord sleepRecord, EventPair eventPair) {
        sleepRecord.getClass();
        eventPair.getClass();
        List<EventInterval> eventIntervals = EventsUtil.getEventIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.BROKEN_START, EventLabel.BROKEN_END);
        eventIntervals.getClass();
        for (EventInterval eventInterval : eventIntervals) {
            eventInterval.getClass();
            length(eventInterval);
        }
        List<EventInterval> eventIntervals2 = EventsUtil.getEventIntervals(sleepRecord.getEvents().getCopiedEvents(), eventPair.getStart(), eventPair.getEnd());
        eventIntervals2.getClass();
        long length = 0;
        for (EventInterval eventInterval2 : eventIntervals2) {
            eventInterval2.getClass();
            length += length(eventInterval2);
        }
        return length / ((sleepRecord.getMeasurementLength() * 60000.0f) - 0.0f);
    }

    public static final float getSleepIrregularityAgainstSettings(StatRecord statRecord) {
        statRecord.getClass();
        Settings settings = SharedApplicationContext.getSettings();
        float currentAvgMidSleep = settings.getCurrentAvgMidSleep();
        float currentAvgSleepLength = settings.getCurrentAvgSleepLength();
        if (currentAvgMidSleep < 0.0f || currentAvgSleepLength < 0.0f) {
            return -1.0f;
        }
        boolean zIsUseLocalTimeForSleepIrregularity = settings.isUseLocalTimeForSleepIrregularity();
        ChronoRecord chronoRecord = ChronoRecordKt.toChronoRecord(statRecord);
        if (chronoRecord == null) {
            return -1.0f;
        }
        return (Math.abs(chronoRecord.getLength() - currentAvgSleepLength) + CyclicFloatKt.distance(currentAvgMidSleep, !zIsUseLocalTimeForSleepIrregularity ? chronoRecord.getMidSleepUTC() : chronoRecord.getMidSleep(), 24.0f)) / 2.0f;
    }

    private static final long length(EventInterval eventInterval) {
        return eventInterval.getTo().getTimestamp() - eventInterval.getFrom().getTimestamp();
    }

    public static final EventInterval slice(EventInterval eventInterval, long j, long j2) {
        eventInterval.getClass();
        if (eventInterval.getFrom().getTimestamp() >= j && eventInterval.getTo().getTimestamp() <= j2) {
            return eventInterval;
        }
        if (j >= eventInterval.getFrom().getTimestamp() && j2 <= eventInterval.getTo().getTimestamp()) {
            Event eventWithTimestamp = eventInterval.getFrom().withTimestamp(j);
            eventWithTimestamp.getClass();
            Event eventWithTimestamp2 = eventInterval.getTo().withTimestamp(j2);
            eventWithTimestamp2.getClass();
            return eventInterval.copy(eventWithTimestamp, eventWithTimestamp2);
        }
        long timestamp = eventInterval.getFrom().getTimestamp();
        if (j <= timestamp && timestamp <= j2) {
            Event eventWithTimestamp3 = eventInterval.getTo().withTimestamp(j2);
            eventWithTimestamp3.getClass();
            return EventInterval.copy$default(eventInterval, null, eventWithTimestamp3, 1, null);
        }
        long timestamp2 = eventInterval.getFrom().getTimestamp();
        if (j > eventInterval.getTo().getTimestamp() || timestamp2 > j) {
            return null;
        }
        Event eventWithTimestamp4 = eventInterval.getFrom().withTimestamp(j);
        eventWithTimestamp4.getClass();
        return EventInterval.copy$default(eventInterval, eventWithTimestamp4, null, 2, null);
    }

    private static final String toAscii(EventLabel eventLabel) {
        int i = eventLabel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventLabel.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "░" : "▁" : "▅" : "▂" : "▇";
    }

    public static final String toAsciiHypnogram(SleepRecord sleepRecord, int i, Integer num) {
        sleepRecord.getClass();
        if (num != null && num.intValue() < 1) {
            Logger.logWarning("toAsciiHypnogram - length argument must be >= 1", null);
            return null;
        }
        List listSortedWith = CollectionsKt.sortedWith(CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{toAsciiHypnogram$getIntervals(sleepRecord, EventLabel.LIGHT_START, EventLabel.LIGHT_END), toAsciiHypnogram$getIntervals(sleepRecord, EventLabel.AWAKE_START, EventLabel.AWAKE_END), toAsciiHypnogram$getIntervals(sleepRecord, EventLabel.REM_START, EventLabel.REM_END), toAsciiHypnogram$getIntervals(sleepRecord, EventLabel.DEEP_START, EventLabel.DEEP_END), toAsciiHypnogram$getIntervals(sleepRecord, EventLabel.BROKEN_START, EventLabel.BROKEN_END)})), new Comparator() { // from class: com.urbandroid.sleep.SleeprecordExtKt$toAsciiHypnogram$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((EventInterval) t).getFrom().getTimestamp()), Long.valueOf(((EventInterval) t2).getFrom().getTimestamp()));
            }
        });
        if (listSortedWith.isEmpty()) {
            return null;
        }
        long timestamp = ((EventInterval) CollectionsKt.first(listSortedWith)).getFrom().getTimestamp();
        long timestamp2 = ((EventInterval) CollectionsKt.last(listSortedWith)).getTo().getTimestamp();
        int iIntValue = num != null ? (int) (((timestamp2 - timestamp) / 60000) / ((long) num.intValue())) : i;
        if (Utils.getMinutesInMillis(iIntValue) == 0) {
            return null;
        }
        long minutesInMillis = (timestamp2 - timestamp) / Utils.getMinutesInMillis(iIntValue);
        StringBuilder sb = new StringBuilder();
        EventLabel asciiHypnogram$stage = null;
        for (long j = 0; j < minutesInMillis; j++) {
            long minutesInMillis2 = (Utils.getMinutesInMillis(iIntValue) * j) + timestamp;
            asciiHypnogram$stage = toAsciiHypnogram$stage(listSortedWith, minutesInMillis2, (Utils.getMinutesInMillis(iIntValue) + minutesInMillis2) - 1, asciiHypnogram$stage);
            sb.append(toAscii(asciiHypnogram$stage));
        }
        return sb.toString();
    }

    public static /* synthetic */ String toAsciiHypnogram$default(SleepRecord sleepRecord, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 15;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        return toAsciiHypnogram(sleepRecord, i, num);
    }

    private static final List<EventInterval> toAsciiHypnogram$getIntervals(SleepRecord sleepRecord, EventLabel eventLabel, EventLabel eventLabel2) {
        List<EventInterval> eventIntervals = EventsUtil.getEventIntervals(sleepRecord.getEvents().getCopiedEvents(), eventLabel, eventLabel2);
        eventIntervals.getClass();
        return eventIntervals;
    }

    private static final int toAsciiHypnogram$priority(EventLabel eventLabel) {
        int i = WhenMappings.$EnumSwitchMapping$0[eventLabel.ordinal()];
        return (i == 1 || i == 3) ? 1 : 2;
    }

    private static final EventLabel toAsciiHypnogram$stage(List<EventInterval> list, long j, long j2, EventLabel eventLabel) {
        Object next;
        List list2;
        Object next2;
        EventLabelLength eventLabelLength;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            EventInterval eventInterval = (EventInterval) obj;
            if (contains(eventInterval, j) || contains(eventInterval, j2)) {
                arrayList.add(obj);
            }
        }
        ArrayList<EventInterval> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            EventInterval eventInterval2 = null;
            if (!it.hasNext()) {
                break;
            }
            EventInterval eventIntervalSlice = slice((EventInterval) it.next(), j, j2);
            if (eventIntervalSlice != null && length(eventIntervalSlice) > 0) {
                eventInterval2 = eventIntervalSlice;
            }
            if (eventInterval2 != null) {
                arrayList2.add(eventInterval2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (EventInterval eventInterval3 : arrayList2) {
            EventLabel label = eventInterval3.getFrom().getLabel();
            if (label == null) {
                eventLabelLength = null;
            } else {
                eventLabelLength = new EventLabelLength(label, length(eventInterval3));
                if (eventLabel != null && label != eventLabel) {
                    eventLabelLength = expand(eventLabelLength, 2.0f);
                }
            }
            if (eventLabelLength != null) {
                arrayList3.add(eventLabelLength);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            Long lValueOf = Long.valueOf(((EventLabelLength) obj2).getLength());
            Object arrayList4 = linkedHashMap.get(lValueOf);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long jLongValue = ((Number) ((Map.Entry) next).getKey()).longValue();
                do {
                    Object next3 = it2.next();
                    long jLongValue2 = ((Number) ((Map.Entry) next3).getKey()).longValue();
                    if (jLongValue < jLongValue2) {
                        next = next3;
                        jLongValue = jLongValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null && (list2 = (List) entry.getValue()) != null) {
            Iterator it3 = list2.iterator();
            if (it3.hasNext()) {
                next2 = it3.next();
                if (it3.hasNext()) {
                    int asciiHypnogram$priority = toAsciiHypnogram$priority(((EventLabelLength) next2).getLabel());
                    do {
                        Object next4 = it3.next();
                        int asciiHypnogram$priority2 = toAsciiHypnogram$priority(((EventLabelLength) next4).getLabel());
                        if (asciiHypnogram$priority > asciiHypnogram$priority2) {
                            next2 = next4;
                            asciiHypnogram$priority = asciiHypnogram$priority2;
                        }
                    } while (it3.hasNext());
                }
            } else {
                next2 = null;
            }
            EventLabelLength eventLabelLength2 = (EventLabelLength) next2;
            if (eventLabelLength2 != null) {
                return eventLabelLength2.getLabel();
            }
        }
        return null;
    }

    public static final String toAsciiRating(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        return CollectionsKt.joinToString$default(new IntRange(1, 5), "", null, null, new SleeprecordExtKt$$ExternalSyntheticLambda0(MathKt.roundToInt(sleepRecord.getRating()), 0), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toAsciiRating$lambda$0$0(int i, int i2) {
        return i2 <= i ? "★" : "☆";
    }

    public static final String toAsciiHypnogram(SleepRecord sleepRecord, int i) {
        sleepRecord.getClass();
        return toAsciiHypnogram$default(sleepRecord, i, null, 2, null);
    }
}
