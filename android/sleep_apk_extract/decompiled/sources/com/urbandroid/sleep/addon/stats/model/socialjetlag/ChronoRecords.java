package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class ChronoRecords {
    private final Date from;
    private final TreeMap<Date, ChronoRecord> records;
    private final Date to;

    public interface RecordToBool {
    }

    public interface RecordToFloat {
        float apply(ChronoRecord chronoRecord);
    }

    public interface RecordsToFloat {
        float apply(ChronoRecords chronoRecords);
    }

    public ChronoRecords(Collection<? extends ChronoRecord> collection, Date date, Date date2) {
        this.records = new TreeMap<>();
        for (ChronoRecord chronoRecord : collection) {
            this.records.put(chronoRecord.getTo(), chronoRecord);
        }
        TreeMap<Date, ChronoRecord> treeMap = this.records;
        if (date != null) {
            if (!treeMap.isEmpty() && this.records.firstKey().before(date)) {
                OggIO$$ExternalSyntheticBUOutline0.m(this.records.firstKey(), " ", date);
                throw null;
            }
            this.from = date;
        } else if (treeMap.isEmpty()) {
            this.from = new Date();
        } else {
            this.from = this.records.firstKey();
        }
        TreeMap<Date, ChronoRecord> treeMap2 = this.records;
        if (date2 != null) {
            if (!treeMap2.isEmpty() && this.records.lastKey().after(date2)) {
                OggIO$$ExternalSyntheticBUOutline0.m(this.records.lastKey(), " ", date2);
                throw null;
            }
            this.to = date2;
        } else if (treeMap2.isEmpty()) {
            this.to = this.from;
        } else {
            this.to = this.records.lastKey();
        }
        if (this.to.before(this.from)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.from);
            Home$$ExternalSyntheticBUOutline0.m(sb, " ", this.to);
            throw null;
        }
    }

    public ChronoRecords filterByDayOfWeek(int i) {
        ArrayList arrayList = new ArrayList();
        for (ChronoRecord chronoRecord : this.records.values()) {
            if (chronoRecord.getEndDayOfWeek() == i) {
                arrayList.add(chronoRecord);
            }
        }
        return new ChronoRecords(arrayList);
    }

    public float[] getFromHours() {
        return toFloats(new Home$$ExternalSyntheticBUOutline0(28));
    }

    public float[] getLengths() {
        return toFloats(new Home$$ExternalSyntheticBUOutline0(26));
    }

    public float[] getMidSleepUTC() {
        return toFloats(new Home$$ExternalSyntheticBUOutline0(25));
    }

    public float[] getMidSleeps() {
        return toFloats(new Home$$ExternalSyntheticBUOutline0(24));
    }

    public TreeMap<Date, ChronoRecord> getRecords() {
        return new TreeMap<>((SortedMap) this.records);
    }

    public Date getTo() {
        return this.to;
    }

    public float[] getToHours() {
        return toFloats(new Home$$ExternalSyntheticBUOutline0(27));
    }

    public ChronoRecords narrow(Date date, Date date2) {
        return new ChronoRecords(this.records.subMap(date, date2).values(), date, date2);
    }

    public int size() {
        return this.records.size();
    }

    public Pair<ChronoRecords, ChronoRecords> split(RecordToBool recordToBool) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChronoRecord chronoRecord : this.records.values()) {
            ((Home$$ExternalSyntheticBUOutline0) recordToBool).getClass();
            if (SocialJetlagStats.lambda$weekendFilter$3(chronoRecord)) {
                arrayList.add(chronoRecord);
            } else {
                arrayList2.add(chronoRecord);
            }
        }
        return Pair.create(new ChronoRecords(arrayList, this.from, this.to), new ChronoRecords(arrayList2, this.from, this.to));
    }

    public List<ChronoRecords> splitByDays(int i, int i2) {
        Date time;
        ArrayList arrayList = new ArrayList();
        if (!this.records.isEmpty()) {
            Date dateFirstKey = this.records.firstKey();
            Date date = new Date(this.records.lastKey().getTime() + 1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFirstKey);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            do {
                Date time2 = calendar.getTime();
                calendar.add(6, i);
                time = calendar.getTime();
                arrayList.add(narrow(time2, time));
                calendar.add(6, i2 - i);
            } while (time.before(date));
        }
        return arrayList;
    }

    public List<ChronoRecords> splitByMonth(int i, int i2) {
        Date time;
        ArrayList arrayList = new ArrayList();
        Date dateFirstKey = this.records.firstKey();
        Date date = new Date(this.records.lastKey().getTime() + 1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFirstKey);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        do {
            Date time2 = calendar.getTime();
            calendar.add(2, i);
            time = calendar.getTime();
            arrayList.add(narrow(time2, time));
            calendar.add(2, i2 - i);
        } while (time.before(date));
        return arrayList;
    }

    public float[] toFloats(RecordToFloat recordToFloat) {
        float[] fArr = new float[this.records.size()];
        Iterator<ChronoRecord> it = this.records.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = recordToFloat.apply(it.next());
            i++;
        }
        return fArr;
    }

    public ChronoRecords(Collection<? extends ChronoRecord> collection) {
        this(collection, null, null);
    }

    public ChronoRecords() {
        this(Collections.EMPTY_LIST);
    }
}
