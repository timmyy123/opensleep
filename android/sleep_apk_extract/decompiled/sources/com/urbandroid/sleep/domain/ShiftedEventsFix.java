package com.urbandroid.sleep.domain;

import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/domain/ShiftedEventsFix;", "", "<init>", "()V", "BROKEN_RECORDS_START", "Ljava/util/Date;", "fixShiftedEvents", "", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "looksLikeShifted", "", "events", "", "Lcom/urbandroid/sleep/domain/Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShiftedEventsFix {
    private static final Date BROKEN_RECORDS_START;
    public static final ShiftedEventsFix INSTANCE = new ShiftedEventsFix();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventLabel.values().length];
            try {
                iArr[EventLabel.DHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventLabel.FLAGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventLabel.ANTISNORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventLabel.T.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventLabel.LUX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventLabel.NO_AWAKE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("Event labels look like shifted"), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
        Date time = Utils.toCalendar("2019-09-06", "yyyy-MM-dd").getTime();
        time.getClass();
        BROKEN_RECORDS_START = time;
    }

    private ShiftedEventsFix() {
    }

    private final List<Event> fixShiftedEvents(List<? extends Event> events) {
        Event event;
        List<? extends Event> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Event event2 : list) {
            EventLabel label = event2.getLabel();
            switch (label == null ? -1 : WhenMappings.$EnumSwitchMapping$0[label.ordinal()]) {
                case 1:
                    event = new Event(event2.getTimestamp(), EventLabel.LAUGH, event2.getValue());
                    event2 = event;
                    break;
                case 2:
                    event = new Event(event2.getTimestamp(), EventLabel.DHA, event2.getValue());
                    event2 = event;
                    break;
                case 3:
                    event = new Event(event2.getTimestamp(), EventLabel.LUX, event2.getValue());
                    event2 = event;
                    break;
                case 4:
                    event = new Event(event2.getTimestamp(), EventLabel.FLAGS, event2.getValue());
                    event2 = event;
                    break;
                case 5:
                    event = new Event(event2.getTimestamp(), EventLabel.T, event2.getValue());
                    event2 = event;
                    break;
                case 6:
                    event = new Event(event2.getTimestamp(), EventLabel.ANTISNORE, event2.getValue());
                    event2 = event;
                    break;
            }
            arrayList.add(event2);
        }
        return arrayList;
    }

    private final boolean looksLikeShifted(List<? extends Event> events) {
        Long lValueOf = null;
        Long lValueOf2 = null;
        for (Event event : events) {
            EventLabel label = event.getLabel();
            int i = label == null ? -1 : WhenMappings.$EnumSwitchMapping$0[label.ordinal()];
            if (i == 1) {
                if (lValueOf != null) {
                    if (event.getTimestamp() - lValueOf.longValue() != 1) {
                        return true;
                    }
                }
                lValueOf = Long.valueOf(event.getTimestamp());
            } else if (i == 2) {
                if (lValueOf2 != null) {
                    if (event.getTimestamp() - lValueOf2.longValue() == 1) {
                        return true;
                    }
                }
                lValueOf2 = Long.valueOf(event.getTimestamp());
            } else {
                if (i != 3) {
                    return false;
                }
                if (event.getValue() > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void fixShiftedEvents(SleepRecord record) {
        record.getClass();
        if (record.getFrom() == null || record.getFrom().before(BROKEN_RECORDS_START)) {
            return;
        }
        List<Event> copiedEvents = record.getEvents().getCopiedEvents();
        copiedEvents.getClass();
        if (looksLikeShifted(copiedEvents)) {
            Logger.logWarning("Event labels look like shifted, fixing. " + record.getFrom());
            record.getEvents().clearAll();
            Iterator<T> it = fixShiftedEvents(copiedEvents).iterator();
            while (it.hasNext()) {
                record.getEvents().addEventDirect((Event) it.next());
            }
        }
    }
}
