package com.urbandroid.sleep.domain;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.interval.EventInterval;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Events implements Serializable {
    private final List<Event> events;
    private final Object sync;

    @Deprecated
    public Events(Map<Long, EventLabel> map) {
        this.sync = new Object();
        this.events = new ArrayList();
        for (Map.Entry entry : (map == null ? new TreeMap() : new TreeMap(map)).entrySet()) {
            this.events.add(new Event(((Long) entry.getKey()).longValue(), (EventLabel) entry.getValue()));
        }
    }

    public static Event deserializeEvent(long j, int i, String str, float f) {
        EventLabel eventLabelFromString = getEventLabelFromString(str);
        if (eventLabelFromString == null) {
            try {
                eventLabelFromString = EventLabel.values()[i];
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("Unknown label ordinal: " + i);
            }
        }
        if (eventLabelFromString == null) {
            eventLabelFromString = EventLabel.UNKNOWN;
        }
        EventLabel eventLabel = eventLabelFromString;
        if (eventLabel != EventLabel.UNKNOWN) {
            str = null;
        }
        return new Event(j, eventLabel, str, f);
    }

    public static EventLabel getEventLabelFromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return EventLabel.valueOf(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Events parseNewFormat(byte[] bArr) {
        Events events = new Events();
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            dataInputStream.readByte();
            int i = dataInputStream.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                events.addEventDirect(deserializeEvent(dataInputStream.readLong(), dataInputStream.readByte(), dataInputStream.readBoolean() ? dataInputStream.readUTF() : null, dataInputStream.readFloat()));
            }
            return events;
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public void addEvent(long j, EventLabel eventLabel, float f, int i) {
        synchronized (this.sync) {
            if (eventLabel == null) {
                try {
                    eventLabel = EventLabel.UNKNOWN;
                } catch (Throwable th) {
                    throw th;
                }
            }
            EventLabel eventLabel2 = eventLabel;
            if (this.events.size() > 0) {
                List<Event> list = this.events;
                ListIterator<Event> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    Event eventPrevious = listIterator.previous();
                    EventLabel label = eventPrevious.getLabel() == null ? EventLabel.UNKNOWN : eventPrevious.getLabel();
                    if (label.ordinal() != eventLabel2.ordinal() || eventPrevious.getTimestamp() != j) {
                        float f2 = f;
                        if (eventPrevious.getTimestamp() >= j && (eventPrevious.getTimestamp() != j || label.ordinal() <= eventLabel2.ordinal())) {
                            f = f2;
                        }
                        listIterator.next();
                        listIterator.add(new Event(j, eventLabel2, f2));
                        return;
                    }
                    if (eventLabel2 == EventLabel.AWAKE_START || eventLabel2 == EventLabel.AWAKE_END || eventLabel2 == EventLabel.TRACKING_PAUSED || eventLabel2 == EventLabel.TRACKING_RESUMED) {
                        if (i < 30) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Awake: Same timestamp elements, fixing ts=");
                            long j2 = j + 1;
                            sb.append(j2);
                            sb.append(" retry=");
                            sb.append(i);
                            Logger.logInfo(sb.toString());
                            addEvent(j2, eventLabel2, f, i + 1);
                        } else {
                            listIterator.next();
                            listIterator.add(new Event(j, eventLabel2, f));
                        }
                    }
                    return;
                }
            }
            this.events.add(0, new Event(j, eventLabel2, f));
        }
    }

    public void addEventDirect(Event event) {
        synchronized (this.sync) {
            this.events.add(event);
        }
    }

    public void clearAll() {
        synchronized (this.sync) {
            this.events.clear();
        }
    }

    public void clearLabels(long j, long j2, EventLabel... eventLabelArr) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (it.hasNext()) {
                    Event next = it.next();
                    int length = eventLabelArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        EventLabel eventLabel = eventLabelArr[i];
                        if (eventLabel != next.getLabel() || next.getTimestamp() < j || next.getTimestamp() > j2) {
                            i++;
                        } else {
                            if (eventLabel == EventLabel.HR) {
                                Logger.logInfo("Delete HR event: " + next);
                            }
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearLabelsOutsideInterval(final com.urbandroid.sleep.domain.interval.Interval interval, EventLabel... eventLabelArr) {
        synchronized (this.sync) {
            clearLabelsWithFilter(new EventFilter() { // from class: com.urbandroid.sleep.domain.Events.1
                @Override // com.urbandroid.sleep.domain.EventFilter
                public boolean apply(IEvent iEvent) {
                    return !interval.isIn(iEvent.getTimestamp());
                }
            }, eventLabelArr);
        }
    }

    public void clearLabelsWithFilter(EventFilter eventFilter, EventLabel... eventLabelArr) {
        int i;
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (it.hasNext()) {
                    Event next = it.next();
                    int length = eventLabelArr.length;
                    while (i < length) {
                        i = (eventLabelArr[i] == next.getLabel() && (eventFilter == null || eventFilter.apply(next))) ? 0 : i + 1;
                        it.remove();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<Event> getCopiedEvents() {
        ArrayList arrayList;
        synchronized (this.sync) {
            arrayList = new ArrayList(this.events);
        }
        return arrayList;
    }

    public boolean hasLabel(long j, long j2, EventLabel... eventLabelArr) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    Event next = it.next();
                    for (EventLabel eventLabel : eventLabelArr) {
                        if (eventLabel == next.getLabel() && next.getTimestamp() >= j && next.getTimestamp() <= j2) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.sync) {
            zIsEmpty = this.events.isEmpty();
        }
        return zIsEmpty;
    }

    public int labelSize(EventLabel eventLabel) {
        int i;
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (eventLabel == it.next().getLabel()) {
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public byte[] serializeToBytes() {
        byte[] byteArray;
        synchronized (this.sync) {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeInt(this.events.size());
                    for (Event event : this.events) {
                        EventLabel label = event.getLabel() == null ? EventLabel.UNKNOWN : event.getLabel();
                        dataOutputStream.writeLong(event.getTimestamp());
                        dataOutputStream.writeByte(label.ordinal());
                        dataOutputStream.writeBoolean(true);
                        dataOutputStream.writeUTF(event.getLabelString() != null ? event.getLabelString() : label.name());
                        dataOutputStream.writeFloat(event.getValue());
                    }
                    dataOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArray;
    }

    public int size() {
        int size;
        synchronized (this.sync) {
            size = this.events.size();
        }
        return size;
    }

    public String toString() {
        String string;
        synchronized (this.sync) {
            try {
                StringBuilder sb = new StringBuilder();
                for (Event event : this.events) {
                    EventLabel label = event.getLabel() == null ? EventLabel.UNKNOWN : event.getLabel();
                    sb.append(label);
                    sb.append(":");
                    sb.append(new Date(event.getTimestamp()));
                    sb.append(label.hasValue() ? ":" + event.getValue() : "");
                    sb.append(";");
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public boolean hasLabel(EventLabel... eventLabelArr) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    Event next = it.next();
                    for (EventLabel eventLabel : eventLabelArr) {
                        if (eventLabel == next.getLabel()) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasLabel(EventLabel eventLabel, long j, float f) {
        synchronized (this.sync) {
            try {
                for (Event event : this.events) {
                    if (event.getLabel() == eventLabel && event.getTimestamp() == j && event.getValue() == f) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasLabel(EventLabel eventLabel, int i) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (eventLabel == it.next().getLabel()) {
                        i2++;
                    }
                    if (i2 >= i) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Events(Events events) {
        this.sync = new Object();
        ArrayList arrayList = new ArrayList();
        this.events = arrayList;
        arrayList.addAll(events.getCopiedEvents());
    }

    public boolean hasLabel(EventLabel eventLabel) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (it.hasNext()) {
                    if (eventLabel == it.next().getLabel()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Events() {
        this.sync = new Object();
        this.events = new ArrayList();
    }

    public void clearLabels(EventLabel... eventLabelArr) {
        synchronized (this.sync) {
            try {
                Iterator<Event> it = this.events.iterator();
                while (it.hasNext()) {
                    Event next = it.next();
                    int length = eventLabelArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (eventLabelArr[i] == next.getLabel()) {
                            it.remove();
                            break;
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addEvent(EventInterval eventInterval) {
        synchronized (this.sync) {
            addEvent(eventInterval.getFrom().getTimestamp(), eventInterval.getFrom().getLabel(), eventInterval.getFrom().getValue());
            addEvent(eventInterval.getTo().getTimestamp(), eventInterval.getTo().getLabel(), eventInterval.getTo().getValue());
        }
    }

    public void addEvent(long j, EventLabel eventLabel) {
        synchronized (this.sync) {
            addEvent(j, eventLabel, 0.0f);
        }
    }

    public void addEvent(long j, EventLabel eventLabel, float f) {
        addEvent(j, eventLabel, f, 0);
    }

    public void addEvent(IEvent iEvent) {
        synchronized (this.sync) {
            addEvent(iEvent.getTimestamp(), iEvent.getLabel(), iEvent.getValue());
        }
    }
}
