package com.urbandroid.sleep.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.AuthenticationTokenClaims;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.ParcelUtil;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.apnea.WeirdSpo2Guard;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.persistence.SleepRecordCsvMapper;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetectorFactoryKt;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.CollectionUtilKt;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecord implements Parcelable, Serializable, TimeRecord {
    private String comment;
    private int cycles;
    private Events events;
    private boolean finished;
    private Date from;
    private String geo;
    private boolean hideSleepAnalysis;
    private List<Float> history;
    private List<Float> hrHistory;
    private long lastActivityUpdate;
    private float lastEntry;
    private Date lastestTo;
    private int lenAdjust;
    private final transient Set<SleepRecordChangeListener> listeners;
    private List<Float> noiseHistory;
    private float noiseLevel;
    private float quality;
    private float rating;
    private byte[] rawtimestampedEventLabels;
    private boolean rawtimestampedEventLabelsNewFormat;
    private int snore;
    private List<Float> tempHistory;
    private String timezone;
    private Date to;
    private int version;
    public static final int TEMP_HISTORY_SIZE = Fragment$$ExternalSyntheticOutline1.m(SleepService.FRAMERATE, 1000, 100, 1);
    public static final Parcelable.Creator<SleepRecord> CREATOR = new Parcelable.Creator<SleepRecord>() { // from class: com.urbandroid.sleep.domain.SleepRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepRecord createFromParcel(Parcel parcel) {
            return new SleepRecord(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepRecord[] newArray(int i) {
            return new SleepRecord[i];
        }
    };
    public static int AGGREGATION_VALUE_COUNT = 30;
    public static final long MAX_FALL_ASLEEP_DELAY_MS = 7200000;
    public static final long MAX_FALL_ASLEEP_AWAKE_INTERVAL_DELAY_MS = 900000;

    private SleepRecord(Parcel parcel) {
        this.noiseLevel = -1.0f;
        this.lenAdjust = 0;
        this.quality = -2.0f;
        this.cycles = -1;
        this.snore = -1;
        this.history = new ArrayList();
        this.noiseHistory = new ArrayList();
        this.hrHistory = new ArrayList();
        this.events = new Events();
        this.tempHistory = new ArrayList();
        this.rawtimestampedEventLabelsNewFormat = false;
        this.listeners = new HashSet();
        this.hideSleepAnalysis = false;
        Date nullableDate = ParcelUtil.readNullableDate(parcel);
        this.from = nullableDate;
        if (nullableDate == null) {
            Logger.logSevere("From NULL in SleepRecord deparcelization. This record is likely totally broken..");
        }
        this.timezone = parcel.readString();
        this.lastestTo = ParcelUtil.readNullableDate(parcel);
        this.to = ParcelUtil.readNullableDate(parcel);
        this.version = parcel.readInt();
        this.comment = parcel.readString();
        this.rating = parcel.readFloat();
        this.lastEntry = parcel.readFloat();
        parcel.readList(this.history, getClass().getClassLoader());
        this.lenAdjust = parcel.readInt();
        this.quality = parcel.readFloat();
        HashMap map = new HashMap();
        parcel.readMap(map, getClass().getClassLoader());
        if (map.size() > 0) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                map2.put((Long) entry.getKey(), EventLabel.valueOf(((EventLabel) entry.getValue()).name()));
            }
            this.events = new Events(map2);
        }
        try {
            parcel.readList(this.noiseHistory, getClass().getClassLoader());
        } catch (Exception unused) {
            this.noiseHistory = new ArrayList();
        }
        try {
            this.noiseLevel = parcel.readFloat();
            this.cycles = parcel.readInt();
            this.snore = parcel.readInt();
        } catch (Exception e) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e);
        }
        try {
            this.finished = parcel.readByte() == 1;
        } catch (Exception e2) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e2);
        }
        try {
            this.events = EventsAndroidSpecific.readFromParcel(parcel);
        } catch (Exception e3) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e3);
        }
        try {
            this.geo = parcel.readString();
        } catch (Exception e4) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e4);
        }
        try {
            parcel.readList(this.tempHistory, getClass().getClassLoader());
        } catch (Exception e5) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e5);
        }
        try {
            this.hideSleepAnalysis = parcel.readByte() == 1;
        } catch (Exception e6) {
            Logger.logDebug("Ignoring failed deparcelization.. field may not exist temporarily..", e6);
        }
    }

    private void addRecordInternal(float... fArr) {
        for (float f : fArr) {
            this.history.add(Float.valueOf(f));
            this.lastEntry = f;
        }
        this.lastActivityUpdate = Utils.now();
        Iterator<SleepRecordChangeListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDataAdded(this);
        }
    }

    private List<Float> aggregateHistoryNew() {
        return SleepRecordHypnogram.aggregateHistoryNew(getVersion(), getFrom(), getTo(), getHistory(), getEvents(), this.lastActivityUpdate);
    }

    private List<Float> aggregateHistoryOld(List<Float> list) {
        return SleepRecordHypnogram.aggregateHistoryOld(list, getVersion(), getComment());
    }

    private List<Float> checkEvilValuesInAggregatedHistory(List<Float> list) {
        Iterator<Float> it = list.iterator();
        while (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            if (Float.isNaN(fFloatValue) || Float.isInfinite(fFloatValue)) {
                Logger.logWarning("If you see this message, please contact Jan Marek.");
                Logger.logWarning("The aggregated history contains NaN or Infinity.");
                Logger.logWarning("Raw history: " + getHistory());
                Logger.logWarning("Aggregated history: " + list);
                Logger.logWarning("Sleep record: " + SleepRecordCsvMapper.sleepRecordToCsv(this));
                ArrayList arrayList = new ArrayList();
                for (Float f : list) {
                    float fFloatValue2 = f.floatValue();
                    if (Float.isNaN(fFloatValue2) || Float.isInfinite(fFloatValue2)) {
                        arrayList.add(Float.valueOf(0.0f));
                    } else {
                        arrayList.add(f);
                    }
                }
                return arrayList;
            }
        }
        return list;
    }

    public static void clearEventsDHA(Events events, long j, long j2, int i, long j3, long j4, int i2) {
        int i3;
        if (i2 >= i) {
            return;
        }
        BitSet bitSet = EventsRawStorageKt.readBitSet(events, EventLabel.DHA);
        if (bitSet.isEmpty()) {
            return;
        }
        int millisPerPoint = (int) (SleepRecordHypnogram.getMillisPerPoint(10007, j, j2, i) / ((long) SleepService.FRAMERATE));
        if (j == j3) {
            BitSet bitSet2 = new BitSet();
            int i4 = (i - i2) * millisPerPoint;
            i3 = millisPerPoint;
            int i5 = 0;
            for (int i6 = i2 * millisPerPoint; i5 < i6; i6 = i6) {
                bitSet2.set(i5, bitSet.get(i5 + i4));
                i5++;
            }
            EventsRawStorageKt.writeBitSet(events, j4 + 1, EventLabel.DHA, bitSet2);
        } else {
            i3 = millisPerPoint;
        }
        if (j2 == j4) {
            BitSet bitSet3 = (BitSet) bitSet.clone();
            int i7 = i * i3;
            for (int i8 = i2 * i3; i8 < i7; i8++) {
                bitSet3.set(i8, false);
            }
            EventsRawStorageKt.writeBitSet(events, j + 1, EventLabel.DHA, bitSet3);
        }
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("SleepRecord.clearEventsDHA: this should never happen: ", ", ", j);
        sbM.append(j2);
        sbM.append(", ");
        sbM.append(i);
        zzba$$ExternalSyntheticOutline0.m(sbM, ", ", j3, ", ");
        sbM.append(j4);
        sbM.append(", ");
        sbM.append(i2);
        Logger.logWarning(sbM.toString());
    }

    private synchronized void computeAll(boolean z) throws Throwable {
        SleepRecord sleepRecord;
        Throwable th;
        try {
            try {
                Logger.logInfo("Awake computeAll() " + z);
                wrongVersionHack();
                parseRawTimestampedEventLabelsIfRequired();
                if (SharedApplicationContext.getSettings().isAwakeDetectionHr()) {
                    try {
                        computeHighHeartrateEventsAndHeartrateBasedAwake();
                    } catch (Throwable th2) {
                        th = th2;
                        sleepRecord = this;
                        throw th;
                    }
                }
                if (SharedApplicationContext.getSettings().isAwakeDetectionSnooze()) {
                    computeSnoozeAwake();
                }
                if (z) {
                    if (getVersion() >= 10005) {
                        Logger.logInfo(RawActigraphDiagnosticsKt.diagnoseRawActigraph(getHistory()));
                        this.history = checkEvilValuesInAggregatedHistory(aggregateHistoryNew());
                        PairTracking.Companion companion = PairTracking.INSTANCE;
                        companion.logStatus();
                        if (companion.hasSufficientDataForPairTracking()) {
                            Set<String> tags = getTags();
                            Tag tag = Tag.PAIR;
                            if (!tags.contains(tag.getTagName())) {
                                Logger.logInfo("SleepRecord: PairTracking was successful, generated pair actigraph and adding pair tag.");
                                addTag(tag);
                            }
                        }
                        if (getVersion() >= 10007) {
                            Logger.logInfo("highActivityFlags: " + CollectionUtilKt.to10VectorString(EventsRawStorageKt.readBitSet(getEvents(), EventLabel.DHA)));
                        }
                    } else {
                        this.history = aggregateHistoryOld(getHistory());
                    }
                }
                if (hasActigraph()) {
                    SleepRecordHypnogram.computeHypnogramFromActigraph(this);
                } else {
                    SleepRecordHypnogram.computeHypnogramFromImportedEvents(this);
                }
                EventsUtil.compressEventLabel(this, EventLabel.SNORING, 300000L, false);
                EventsUtil.compressEventLabel(this, EventLabel.TALK, 300000L, false);
                EventsUtil.compressEventLabel(this, EventLabel.BABY, 300000L, false);
                EventsUtil.compressEventLabel(this, EventLabel.SICK, 300000L, false);
                EventsUtil.compressEventLabel(this, EventLabel.LAUGH, 300000L, false);
                EventsUtil.compressEventLabel(this, EventLabel.ANTISNORE, 300000L, false);
                RespiratoryDetectorFactoryKt.postProcessRespiratoryEvents(this);
                EventLabel eventLabel = EventLabel.RR;
                EventsUtil.filterRare(this, eventLabel, 300000L);
                EventsUtil.compressEventLabel(this, eventLabel, 300000L, 1200000L, true);
                List<Event> copiedEvents = this.events.getCopiedEvents();
                EventLabel eventLabel2 = EventLabel.AWAKE_START;
                EventLabel eventLabel3 = EventLabel.AWAKE_END;
                EventsUtil.logInterval(copiedEvents, eventLabel2, eventLabel3);
                mergeAwakeOverlaps();
                Logger.logInfo("Interval: AFTER MERGE");
                EventsUtil.logInterval(this.events.getCopiedEvents(), eventLabel2, eventLabel3);
                List<Event> copiedEvents2 = this.events.getCopiedEvents();
                EventLabel eventLabel4 = EventLabel.TRACKING_PAUSED;
                EventLabel eventLabel5 = EventLabel.TRACKING_RESUMED;
                EventsUtil.logInterval(copiedEvents2, eventLabel4, eventLabel5);
                clearIntervalOverlaps(new EventPair(eventLabel4, eventLabel5), new EventPair(eventLabel2, eventLabel3));
                Logger.logInfo("Interval: AFTER OVERLAP");
                EventsUtil.logInterval(this.events.getCopiedEvents(), eventLabel2, eventLabel3);
                SleepRecordHypnogramKt.clearRemAtAwake(this.events);
                computeLenAdjust();
                if (z) {
                    resolveRdi();
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            sleepRecord = this;
            th = th;
            throw th;
        }
    }

    private void computeSnoozeAwake() {
        for (Event event : new ArrayList(getEvents().getCopiedEvents())) {
            if (event.getLabel() == EventLabel.ALARM_SNOOZE) {
                Logger.logInfo("Adding snooze awake " + new Date(event.getTimestamp()));
                addEventLabel(EventLabel.AWAKE_START, event.getTimestamp());
                addEventLabel(EventLabel.AWAKE_END, event.getTimestamp() + 120000);
            }
        }
    }

    private synchronized void deleteSelectionInternal(long j, long j2) {
        long j3;
        long j4;
        try {
            if (j < getFrom().getTime() || j2 > getTo().getTime()) {
                Logger.logWarning(j + " ? " + getFrom().getTime() + " <--> " + j2 + " ? " + getTo().getTime());
                Logger.logWarning(new Date(j) + " - " + new Date(j2) + " times not in record range of: " + getFrom() + " - " + getTo());
                return;
            }
            ArrayList arrayList = new ArrayList(getFilteredHistory());
            long time = getFrom().getTime();
            long time2 = getTo().getTime();
            int size = arrayList.size();
            int iInternalSelectionDelete = internalSelectionDelete(arrayList, j, j2);
            this.history = arrayList;
            clearEventsDHA(getEvents(), time, time2, size, j, j2, arrayList.size());
            List<Float> filteredNoiseHistory = getFilteredNoiseHistory();
            if (filteredNoiseHistory == null || filteredNoiseHistory.size() <= 0) {
                j3 = j;
                j4 = j2;
            } else {
                List<Float> arrayList2 = new ArrayList<>(filteredNoiseHistory);
                j3 = j;
                j4 = j2;
                internalSelectionDelete(arrayList2, j3, j4);
                this.noiseHistory = arrayList2;
            }
            Logger.logInfo("Already removed " + iInternalSelectionDelete);
            int pausingOverlapLength = (int) (getPausingOverlapLength(new com.urbandroid.sleep.domain.interval.Interval(j3, j4)) / 60000);
            Logger.logInfo("Already removed time " + pausingOverlapLength);
            if (getFrom().getTime() == j3) {
                setFrom(new Date(j4));
                setLenAdjust(getLenAdjust() + pausingOverlapLength);
            } else if (getTo().getTime() == j4) {
                setTo(new Date(j3));
                setLenAdjust(getLenAdjust() + pausingOverlapLength);
            } else {
                unionPausing(new com.urbandroid.sleep.domain.interval.Interval(j3, j4));
                setLenAdjust((getLenAdjust() - ((int) ((j4 - j3) / 60000))) + pausingOverlapLength);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int getCurrentSetupVersion() {
        try {
            return Experiments.getInstance().isActigraphyImprovementsExperiment3() ? 10008 : 10007;
        } catch (Exception e) {
            Logger.logSevere(e);
            return 10007;
        }
    }

    private long getMillies(int i, int i2) {
        return Math.round((((double) i) * DateUtil.dateDifference(getFrom(), getTo() == null ? new Date() : getTo())) / ((double) i2));
    }

    private long getMinutes(int i, int i2) {
        if (i == 0) {
            return 0L;
        }
        return Math.round(getMillies(i, i2) / 60000);
    }

    private long getPausingOverlapLength(com.urbandroid.sleep.domain.interval.Interval interval) {
        Iterator<com.urbandroid.sleep.domain.interval.Interval> it = EventsUtil.getIntervals(getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED).iterator();
        long intersectionLength = 0;
        while (it.hasNext()) {
            intersectionLength += interval.getIntersectionLength(it.next());
        }
        return intersectionLength;
    }

    private Date getTimeByPosition(int i, int i2, Date date, int i3) {
        double dDateDifference = (DateUtil.dateDifference(getFrom(), getTo()) / ((double) i2)) * ((double) i);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(14, i3 * ((int) Math.round(dDateDifference)));
        return calendar.getTime();
    }

    private int internalSelectionDelete(List<Float> list, long j, long j2) {
        if (j < getFrom().getTime() || j2 > getTo().getTime()) {
            throw new IllegalArgumentException(j + " - " + j2 + " times not in record range");
        }
        int size = list.size();
        int i = 0;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            long time = getTimeByPosition((size - i2) - 1, size, getTo(), -1).getTime();
            if (time >= j && time <= j2) {
                if (list.get(i2).floatValue() == -0.01f) {
                    i++;
                }
                if (j <= getFrom().getTime()) {
                    list.remove(i2);
                } else if (j2 >= getTo().getTime()) {
                    list.remove(i2);
                } else {
                    list.set(i2, Float.valueOf(-0.01f));
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void mergePausedIntervals() {
        List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED);
        if (intervals.size() > 1) {
            com.urbandroid.sleep.domain.interval.Interval interval = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                com.urbandroid.sleep.domain.interval.Interval interval2 = intervals.get(i);
                if (interval2.getFrom() - interval.getTo() <= 750000) {
                    if (interval.getLength() + interval2.getLength() > 0) {
                        Logger.logInfo("Merging " + interval2 + " GAP " + (interval2.getFrom() - interval.getTo()) + " total len " + (interval.getLength() + interval2.getLength()));
                        deleteSelectionInternal(interval.getFrom() + 1, interval2.getTo() - 1);
                        interval = new com.urbandroid.sleep.domain.interval.Interval(interval.getFrom(), interval2.getTo());
                    } else {
                        interval = interval2;
                    }
                }
            }
        }
    }

    private void parseRawTimestampedEventLabelsIfRequired() {
        byte[] bArr = this.rawtimestampedEventLabels;
        if (bArr != null) {
            this.events = Events.parseNewFormat(bArr);
            this.rawtimestampedEventLabels = null;
        }
    }

    private void unionPausing(com.urbandroid.sleep.domain.interval.Interval interval) {
        EventsUtil.mergeUnionInterval(getEvents(), interval, new EventPair(EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wrongVersionHack() {
        if (isFinished()) {
            int i = this.version;
            int i2 = 10000;
            if (i < 10000 || i > 10008) {
                if ((getFrom() == null || getFrom().getTime() >= 1508976000000L) && !this.history.isEmpty()) {
                    if (getEvents().hasLabel(EventLabel.DHA)) {
                        i2 = 10007;
                    } else if (this.history.size() > 100) {
                        i2 = 10005;
                    } else {
                        float fMax = ScienceUtil.max(ScienceUtil.toFloatArray(this.history));
                        if (fMax > 8.0f && fMax <= 10.0f) {
                        }
                    }
                }
                this.version = i2;
            }
        }
    }

    public synchronized void addEventLabel(EventLabel eventLabel, long j) {
        parseRawTimestampedEventLabelsIfRequired();
        this.events.addEvent(j, eventLabel, 0.0f);
    }

    public synchronized void addListener(SleepRecordChangeListener sleepRecordChangeListener) {
        if (isFinished()) {
            throw new RuntimeException("Cannot add new listener to already finished sleep record");
        }
        this.listeners.add(sleepRecordChangeListener);
    }

    public synchronized void addNoiseRecord(float... fArr) {
        if (fArr == null) {
            return;
        }
        for (float f : fArr) {
            this.noiseHistory.add(Float.valueOf(f));
        }
    }

    public synchronized void addNoiseRecordIfNotFinished(float... fArr) {
        if (!isFinished()) {
            addNoiseRecord(fArr);
        }
    }

    public synchronized void addRecord(float... fArr) {
        if (isFinished()) {
            throw new RuntimeException("Cannot add any records after recording is finished");
        }
        addRecordInternal(fArr);
    }

    public synchronized void addRecordIfNotFinished(float... fArr) {
        if (!isFinished()) {
            addRecordInternal(fArr);
        }
    }

    public synchronized void addSnore(int i) {
        this.snore += i;
    }

    public void addTag(Tag tag, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comment);
        sb.append(" ");
        sb.append(tag.getTagString());
        sb.append(i > 1 ? Fragment$$ExternalSyntheticOutline1.m(i, "_", "x") : "");
        this.comment = sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0013, B:9:0x002a, B:14:0x0043), top: B:19:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void addTempHistory(float f) {
        try {
            if (this.tempHistory.size() < TEMP_HISTORY_SIZE) {
                if (this.tempHistory.size() != 0) {
                    if (this.tempHistory.get(r0.size() - 1).floatValue() >= 0.0f) {
                        if (this.tempHistory.get(r0.size() - 1).floatValue() != f) {
                            this.tempHistory.add(Float.valueOf(f));
                        }
                    } else {
                        this.tempHistory.add(Float.valueOf(f));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void clearIntervalOverlaps(EventPair eventPair, EventPair eventPair2) {
        EventsUtil.clearIntervalOverlaps(getEvents(), eventPair, eventPair2);
    }

    public void clearSleepRecordOverlaps(EventPair eventPair) {
        EventsUtil.clearSleepRecordOverlaps(getFromTime(), getToTime(), getEvents(), eventPair);
    }

    public void computeHighHeartrateEventsAndHeartrateBasedAwake() {
        List<IEvent> list;
        if (getEvents().hasLabel(EventLabel.NO_AWAKE)) {
            Logger.logInfo("SleepRecord: awake removed, not computing HR awake");
            return;
        }
        int awakeDetectionHrSensitivity = SharedApplicationContext.getSettings().getAwakeDetectionHrSensitivity();
        int i = 1;
        float f = awakeDetectionHrSensitivity != 1 ? awakeDetectionHrSensitivity != 2 ? awakeDetectionHrSensitivity != 3 ? Float.POSITIVE_INFINITY : 1.1f : 1.18f : 1.26f;
        Events events = getEvents();
        EventLabel eventLabel = EventLabel.HR_HIGH_START;
        EventLabel eventLabel2 = EventLabel.HR_HIGH_END;
        events.clearLabels(eventLabel, eventLabel2);
        Events events2 = getEvents();
        com.urbandroid.sleep.domain.interval.Interval interval = new com.urbandroid.sleep.domain.interval.Interval(getFromTime(), getToTime());
        EventLabel eventLabel3 = EventLabel.HR;
        events2.clearLabelsOutsideInterval(interval, eventLabel3);
        List<IEvent> events3 = EventsUtil.getEvents(getEvents().getCopiedEvents(), eventLabel3);
        if (events3.size() < 8) {
            return;
        }
        getEvents().clearLabels(eventLabel, eventLabel2);
        int size = events3.size();
        float[] fArr = new float[size];
        FloatFunction floatFunctionQuantilePrecise = Moving.quantilePrecise(12, 0.5f);
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            fArr[i3] = floatFunctionQuantilePrecise.apply(events3.get(i3).getValue()) * f;
        }
        long jMax = -1;
        long j = -1;
        while (i2 < size) {
            IEvent iEvent = events3.get(i2);
            float value = iEvent.getValue();
            long timestamp = iEvent.getTimestamp();
            if (value < 27.0f || value > 150.0f || value == Float.NaN) {
                list = events3;
            } else {
                float f2 = i2 >= 12 ? fArr[i2] : fArr[Math.min(12, size) - i];
                if (value <= f2 || jMax != -1) {
                    if (jMax > -1 && (value < f2 || (j > -1 && timestamp - j > AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED))) {
                        list = events3;
                        long jMin = Math.min(getToTime(), j + 300000);
                        addEventLabel(EventLabel.HR_HIGH_START, jMax);
                        addEventLabel(EventLabel.HR_HIGH_END, jMin);
                        if (jMin - jMax > 2400000) {
                            jMin = jMax + 2400000;
                        }
                        EventsUtil.mergeUnionInterval(getEvents(), new com.urbandroid.sleep.domain.interval.Interval(jMax, jMin), new EventPair(EventLabel.AWAKE_START, EventLabel.AWAKE_END));
                        jMax = -1;
                    }
                    j = timestamp;
                } else {
                    jMax = Math.max(getFromTime(), timestamp - 300000);
                    if (jMax - getFromTime() < 1800000) {
                        jMax = getFromTime();
                    }
                }
                list = events3;
                j = timestamp;
            }
            i2++;
            events3 = list;
            i = 1;
        }
        if (jMax > -1) {
            long toTime = j > getToTime() - 1200000 ? getToTime() : Math.min(getToTime(), j + 300000);
            addEventLabel(EventLabel.HR_HIGH_START, jMax);
            addEventLabel(EventLabel.HR_HIGH_END, toTime);
            com.urbandroid.sleep.domain.interval.Interval interval2 = new com.urbandroid.sleep.domain.interval.Interval(jMax, toTime);
            EventsUtil.mergeUnionInterval(getEvents(), interval2, new EventPair(EventLabel.AWAKE_START, EventLabel.AWAKE_END));
            Logger.logInfo("Adding HR awake interval " + interval2 + " len " + interval2.getLength());
        }
    }

    public synchronized void computeLenAdjust() {
        try {
            Logger.logInfo("computeLenAdjust: length_before=" + getSleepLengthMinutes());
            List<Float> history = getHistory();
            Iterator<Float> it = history.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().floatValue() == -0.01f) {
                    i++;
                }
            }
            int minutes = i > 0 ? (int) getMinutes(i, history.size()) : 0;
            long sum = com.urbandroid.sleep.domain.interval.Interval.getSum(EventsUtil.getIntervals(getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED));
            Logger.logInfo("computeLenAdjust: PAUSED " + sum);
            long sum2 = sum + com.urbandroid.sleep.domain.interval.Interval.getSum(EventsUtil.getIntervals(getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END));
            Logger.logInfo("computeLenAdjust: AWAKE " + sum2);
            long sum3 = sum2 + com.urbandroid.sleep.domain.interval.Interval.getSum(EventsUtil.getIntervals(getEvents().getCopiedEvents(), EventLabel.WALKING_START, EventLabel.WALKING_END));
            Logger.logInfo("computeLenAdjust: WALK " + sum3);
            int iMax = (int) Math.max((long) minutes, sum3 / 60000);
            if (iMax >= 0) {
                setLenAdjust(-iMax);
            }
            Logger.logInfo("computeLenAdjust: adjustment=" + iMax + " negativeValues=" + i + " negativeLength=" + minutes + " length_after=" + getSleepLengthMinutes());
        } catch (Throwable th) {
            throw th;
        }
    }

    public void computeNoiseLevel() {
        Float[] fArr = (Float[]) getFilteredNoiseHistory().toArray(new Float[0]);
        if (fArr == null || fArr.length <= 2) {
            return;
        }
        this.noiseLevel = ScienceUtil.avg(fArr) / 32767.0f;
    }

    public synchronized int computeRdiFromExistingRespiratoryAndApneaEvents() {
        int measurementLength = getMeasurementLength();
        List<Event> copiedEvents = getEvents().getCopiedEvents();
        double size = ((double) EventsUtil.getEvents(copiedEvents, EventLabel.RR).size()) * 2.5d;
        int iRound = (int) Math.round(((double) (EventsUtil.getEvents(copiedEvents, EventLabel.APNEA).size() * 60)) / size);
        if (size < 60.0d) {
            return -1;
        }
        if (size / ((double) measurementLength) < 0.2d) {
            return -1;
        }
        getEvents().addEvent(getToTime(), EventLabel.RDI, iRound);
        return iRound;
    }

    public synchronized void deleteSelection(long j, long j2) {
        EventLabel eventLabel = EventLabel.TRACKING_PAUSED;
        EventLabel eventLabel2 = EventLabel.TRACKING_RESUMED;
        clearSleepRecordOverlaps(new EventPair(eventLabel, eventLabel2));
        EventLabel eventLabel3 = EventLabel.AWAKE_START;
        EventLabel eventLabel4 = EventLabel.AWAKE_END;
        clearSleepRecordOverlaps(new EventPair(eventLabel3, eventLabel4));
        EventLabel eventLabel5 = EventLabel.WALKING_START;
        EventLabel eventLabel6 = EventLabel.WALKING_END;
        clearSleepRecordOverlaps(new EventPair(eventLabel5, eventLabel6));
        deleteSelectionInternal(j, j2);
        clearSleepRecordOverlaps(new EventPair(eventLabel, eventLabel2));
        clearSleepRecordOverlaps(new EventPair(eventLabel3, eventLabel4));
        clearSleepRecordOverlaps(new EventPair(eventLabel5, eventLabel6));
        EventsUtil.clearSleepRecordOverlaps(getFromTime(), getToTime(), this.events, EventLabel.SNORING, EventLabel.APNEA, EventLabel.ALARM_EARLIEST, EventLabel.ALARM_SNOOZE, EventLabel.ALARM_SNOOZE_AFTER_KILL, EventLabel.ALARM_DISMISS, EventLabel.ALARM_STARTED, EventLabel.ANTISNORE, EventLabel.LUCID_CUE, EventLabel.HR, EventLabel.RR, EventLabel.SICK, EventLabel.BABY, EventLabel.LAUGH, EventLabel.LUX, EventLabel.TALK, EventLabel.SPO2, EventLabel.SDNN);
        mergePausedIntervals();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public synchronized void finish(Date date) {
        try {
            Set<SleepRecordChangeListener> set = this.listeners;
            if (set != null) {
                set.clear();
            }
            this.to = new Date(date.getTime());
            this.finished = true;
            clearSleepRecordOverlaps(new EventPair(EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED));
            mergePausedIntervals();
            computeAll(true);
            addEventLabel(EventLabel.DEVICE, getToTime(), EventsRawStorageKt.intToFloatViaBytes(Build.DEVICE.hashCode()));
            Logger.logInfo("finished SleepRecord: " + getFrom() + " -> " + getTo());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01bc A[Catch: all -> 0x0074, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x003d, B:7:0x0045, B:9:0x006d, B:14:0x0077, B:15:0x0087, B:17:0x008d, B:19:0x0095, B:21:0x00a1, B:23:0x00a6, B:24:0x00af, B:28:0x00bb, B:30:0x00c3, B:33:0x00ce, B:35:0x00d4, B:37:0x00e0, B:39:0x00e8, B:42:0x00f8, B:78:0x01c2, B:48:0x010c, B:50:0x0118, B:52:0x0126, B:54:0x0138, B:58:0x0142, B:60:0x015c, B:62:0x0166, B:63:0x0170, B:66:0x0177, B:68:0x0181, B:69:0x0185, B:71:0x018b, B:73:0x0199, B:74:0x01a9, B:76:0x01bc, B:79:0x01cc, B:80:0x01dc, B:85:0x01ed), top: B:90:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int generateNewApneaEventsAndComputeRdiFromSpo2() {
        int iRound;
        boolean z;
        WeirdSpo2Guard weirdSpo2Guard;
        int i;
        WeirdSpo2Guard weirdSpo2Guard2 = new WeirdSpo2Guard(Sensitivity.MEDIUM);
        getEvents().clearLabels(EventLabel.RDI);
        getEvents().clearLabels(EventLabel.APNEA);
        List<IEvent> events = EventsUtil.getEvents(getEvents().getCopiedEvents(), EventLabel.SPO2);
        int i2 = 0;
        if (events.size() < 4 || getMeasurementLength() < 60) {
            iRound = 0;
            z = false;
        } else {
            IEvent iEvent = events.get(0);
            IEvent iEvent2 = events.get(events.size() - 1);
            double timestamp = (iEvent2.getTimestamp() - iEvent.getTimestamp()) / 3600000.0d;
            if (timestamp < 1.0d) {
                Logger.logInfo("SPO2: Measurement not long enough");
                return -1;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ListIterator<IEvent> listIterator = events.listIterator();
            IEvent next = null;
            IEvent iEvent3 = null;
            while (listIterator.hasNext()) {
                IEvent next2 = listIterator.next();
                if (iEvent3 != null && iEvent3.getValue() == next2.getValue()) {
                    listIterator.remove();
                }
                iEvent3 = next2;
            }
            ListIterator<IEvent> listIterator2 = events.listIterator();
            long timestamp2 = iEvent.getTimestamp();
            int i3 = 0;
            while (timestamp2 <= iEvent2.getTimestamp()) {
                int i4 = i2;
                while (true) {
                    if (next != null && (next.getTimestamp() > timestamp2 || !listIterator2.hasNext())) {
                        break;
                    }
                    WeirdSpo2Guard weirdSpo2Guard3 = weirdSpo2Guard2;
                    int i5 = i2;
                    next = listIterator2.next();
                    i2 = i5;
                    weirdSpo2Guard2 = weirdSpo2Guard3;
                    i4 = 1;
                }
                if (listIterator2.previousIndex() >= 0) {
                    iEvent3 = events.get(listIterator2.previousIndex());
                }
                IEvent iEvent4 = (i4 == 0 || listIterator2.previousIndex() + (-1) < 0) ? iEvent3 : events.get(listIterator2.previousIndex() - 1);
                if ((iEvent3 != null && weirdSpo2Guard2.process(iEvent3.getValue())) || iEvent4 == null || iEvent3 == null) {
                    weirdSpo2Guard = weirdSpo2Guard2;
                    i = i2;
                } else if (iEvent4.getValue() != iEvent3.getValue()) {
                    float value = iEvent3.getValue() - iEvent4.getValue();
                    if (value < 0.0f) {
                        arrayList2.add(Float.valueOf(iEvent3.getValue()));
                        if (arrayList2.size() > 3) {
                            arrayList2.remove(i2);
                        }
                    } else {
                        if (value > 0.0f) {
                            Float[] fArr = (Float[]) arrayList.toArray(new Float[i2]);
                            float fPercentile = ScienceUtil.percentile(fArr, 95.0f);
                            weirdSpo2Guard = weirdSpo2Guard2;
                            float f = 0.0f;
                            float fFloatValue = 0.0f;
                            for (Float f2 : fArr) {
                                if (f2.floatValue() >= fPercentile) {
                                    fFloatValue += f2.floatValue();
                                    f += 1.0f;
                                }
                            }
                            float f3 = f > 0.0f ? (fFloatValue / f) * 0.96f : 90.0f;
                            Iterator it = arrayList2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                if (((Float) it.next()).floatValue() < f3) {
                                    i3++;
                                    getEvents().addEvent(timestamp2, EventLabel.APNEA, 0.0f);
                                    arrayList2.clear();
                                    break;
                                }
                            }
                        }
                        arrayList.add(Float.valueOf(iEvent3.getValue()));
                        if (arrayList.size() >= 300) {
                            i = 0;
                            arrayList.remove(0);
                        } else {
                            i = 0;
                        }
                    }
                    weirdSpo2Guard = weirdSpo2Guard2;
                    arrayList.add(Float.valueOf(iEvent3.getValue()));
                    if (arrayList.size() >= 300) {
                    }
                } else {
                    weirdSpo2Guard = weirdSpo2Guard2;
                    arrayList.add(Float.valueOf(iEvent3.getValue()));
                    if (arrayList.size() >= 300) {
                    }
                }
                timestamp2 += 1000;
                i2 = i;
                weirdSpo2Guard2 = weirdSpo2Guard;
            }
            iRound = (int) Math.round(((double) i3) / timestamp);
            z = true;
        }
        int i6 = z ? iRound : -1;
        getEvents().addEvent(getToTime(), EventLabel.RDI, i6);
        return i6;
    }

    public String getComment() {
        return this.comment;
    }

    public int getCycles() {
        return this.cycles;
    }

    public synchronized Events getEvents() {
        parseRawTimestampedEventLabelsIfRequired();
        return this.events;
    }

    public long getFallAsleep() {
        long fromTime = getFromTime();
        new SimpleDateFormat("H:mm");
        EventLabel eventLabel = EventLabel.AWAKE_START;
        EventLabel eventLabel2 = EventLabel.AWAKE_END;
        return Math.min(getFallAsleepForEventInterval(getFallAsleepForEventInterval(getFallAsleepForEventInterval(fromTime, eventLabel, eventLabel2), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED), eventLabel, eventLabel2), getFromTime() + MAX_FALL_ASLEEP_DELAY_MS);
    }

    public long getFallAsleepForEventInterval(long j, EventLabel eventLabel, EventLabel eventLabel2) {
        new SimpleDateFormat("H:mm");
        for (EventInterval eventInterval : EventsUtil.getEventIntervals(getEvents().getCopiedEvents(), eventLabel, eventLabel2)) {
            if (eventInterval.toInterval().getFrom() < MAX_FALL_ASLEEP_AWAKE_INTERVAL_DELAY_MS + j) {
                j = Math.max(j, eventInterval.toInterval().getTo());
            }
        }
        return j;
    }

    public double getFallAsleepHour() {
        Calendar calendar = StatRecord.getCalendar(this);
        calendar.setTimeInMillis(getFallAsleep());
        return (((double) calendar.get(12)) / 60.0d) + ((double) calendar.get(11));
    }

    public List<Float> getFilteredHistory() {
        return getVersion() >= 10005 ? aggregateHistoryNew() : aggregateHistoryOld(getHistory());
    }

    public List<Float> getFilteredHistoryForCharting() {
        return getFilteredHistory();
    }

    public List<Float> getFilteredNoiseHistory() {
        return SleepRecordDataFilter.getPresentationFilter(100).filter(getNoiseHistory());
    }

    public synchronized List<Float> getFilteredTempHistoryForCharting() {
        if (this.tempHistory.isEmpty() || this.tempHistory.size() >= AGGREGATION_VALUE_COUNT) {
            return aggregateHistoryNew();
        }
        return new ArrayList(this.tempHistory);
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getFrom() {
        return this.from;
    }

    public long getFromTime() {
        return this.from.getTime();
    }

    public String getGeo() {
        return this.geo;
    }

    public synchronized List<Float> getHistory() {
        return new ArrayList(this.history);
    }

    public com.urbandroid.sleep.domain.interval.Interval getInterval() {
        return new com.urbandroid.sleep.domain.interval.Interval(getFromTime(), getToTime());
    }

    public float getLastEntry() {
        return this.lastEntry;
    }

    public Date getLastestTo() {
        return this.lastestTo;
    }

    public int getLenAdjust() {
        return this.lenAdjust;
    }

    public int getMeasurementLength() {
        Date date;
        if (this.from == null || (date = this.to) == null) {
            return 0;
        }
        return (int) ((date.getTime() - this.from.getTime()) / 60000);
    }

    public synchronized List<Float> getNoiseHistory() {
        return new ArrayList(this.noiseHistory);
    }

    public float getNoiseLevel() {
        return this.noiseLevel;
    }

    public synchronized int getNoiseRecordCount() {
        return this.noiseHistory.size();
    }

    public Date getNotNullTo() {
        return getTo() == null ? new Date() : getTo();
    }

    public float getQuality() {
        return this.quality;
    }

    public float getRating() {
        return this.rating;
    }

    public synchronized int getRecordCount() {
        return this.history.size();
    }

    public int getSleepLengthMinutes() {
        return getMeasurementLength() + this.lenAdjust;
    }

    public String getSleepLengthString() {
        return DateUtil.formatMinutesPositive(Integer.valueOf(getSleepLengthMinutes()));
    }

    public int getSnoozeTime() {
        if (!getEvents().hasLabel(EventLabel.ALARM_STARTED)) {
            return 0;
        }
        List<IEvent> events = EventsUtil.getEvents(getEvents().getCopiedEvents(), EventLabel.ALARM_SNOOZE);
        if (events.size() <= 0) {
            return 0;
        }
        Collections.sort(events, new Comparator<IEvent>() { // from class: com.urbandroid.sleep.domain.SleepRecord.2
            @Override // java.util.Comparator
            public int compare(IEvent iEvent, IEvent iEvent2) {
                return Long.valueOf(iEvent.getTimestamp()).compareTo(Long.valueOf(iEvent2.getTimestamp()));
            }
        });
        return Math.max(((int) (getToTime() - events.get(0).getTimestamp())) / 60000, 0);
    }

    public synchronized int getSnore() {
        return this.snore;
    }

    public String getTagFilteredComment() {
        return Tag.filterTags(getComment());
    }

    public Set<String> getTags(Pattern pattern) {
        return pattern != null ? Tag.getTags(pattern, getComment()) : Tag.getTags(getComment());
    }

    public TimeZone getTimeZone() {
        String str = this.timezone;
        if (str == null) {
            return TimeZone.getDefault();
        }
        try {
            return DesugarTimeZone.getTimeZone(str);
        } catch (Exception e) {
            Logger.logWarning("Failed to parse timezone: " + this.timezone, e);
            return TimeZone.getDefault();
        }
    }

    public String getTimezone() {
        return this.timezone;
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getTo() {
        return this.to;
    }

    public long getToTime() {
        return getNotNullTo().getTime();
    }

    public int getVersion() {
        wrongVersionHack();
        return this.version;
    }

    public long getWakeUp() {
        long toTime = getToTime();
        EventLabel eventLabel = EventLabel.AWAKE_START;
        long fallAsleepForEventInterval = getFallAsleepForEventInterval(toTime, eventLabel, EventLabel.AWAKE_END);
        EventLabel eventLabel2 = EventLabel.TRACKING_PAUSED;
        EventLabel eventLabel3 = EventLabel.TRACKING_RESUMED;
        return Math.max(getFallAsleepForEventInterval(getFallAsleepForEventInterval(fallAsleepForEventInterval, eventLabel2, eventLabel3), eventLabel, eventLabel3), getToTime() - MAX_FALL_ASLEEP_DELAY_MS);
    }

    public double getWakeUpHour() {
        Calendar calendar = StatRecord.getCalendar(this);
        calendar.setTimeInMillis(getWakeUp());
        return (((double) calendar.get(12)) / 60.0d) + ((double) calendar.get(11));
    }

    public boolean hasActigraph() {
        List<Float> filteredHistory = getFilteredHistory();
        return filteredHistory != null && filteredHistory.size() >= 1;
    }

    public boolean hasHypnogram() {
        return getEvents().hasLabel(EventLabel.DEEP_START, EventLabel.LIGHT_START, EventLabel.TRACKING_PAUSED, EventLabel.REM_START);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean hasNoiseData() {
        boolean z;
        z = true;
        if (getSnore() == -1 && getNoiseLevel() == -1.0f) {
            List<Float> list = this.noiseHistory;
            if (list != null) {
                if (list.size() <= 1) {
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized boolean hasSensorData() {
        return getEvents().hasLabel(EventLabel.HR, EventLabel.SPO2, EventLabel.SDANN, EventLabel.SDNN, EventLabel.RR);
    }

    public boolean hasTag(Tag tag) {
        return getComment().contains(tag.getTagString());
    }

    public Boolean isAlarmRungInSmartPeriod() {
        List<Event> copiedEvents = getEvents().getCopiedEvents();
        List<IEvent> events = EventsUtil.getEvents(copiedEvents, EventLabel.ALARM_LATEST);
        List<IEvent> events2 = EventsUtil.getEvents(copiedEvents, EventLabel.ALARM_STARTED);
        if (events.size() <= 0 || events2.size() <= 0) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(((int) (events.get(0).getTimestamp() - events2.get(0).getTimestamp())) / 60000 > 0);
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isHideSleepAnalysis() {
        return getEvents().hasLabel(EventLabel.T) && hasActigraph();
    }

    public boolean isNiceRecord() {
        Logger.logInfo("Rating: isNice");
        if (!hasHypnogram()) {
            Logger.logInfo("Rating: isNice no hyp");
            return false;
        }
        Logger.logInfo("Rating: isNice cycle " + getCycles());
        if (getCycles() >= 3 && getCycles() <= 11) {
            if (getEvents().hasLabel(EventLabel.BROKEN_START, EventLabel.BROKEN_END)) {
                Logger.logInfo("Rating: isNice hasBroken ");
                return false;
            }
            Logger.logInfo("Rating: isNice dura " + (getSleepLengthMinutes() / 60.0f));
            if (getSleepLengthMinutes() >= 390.0d && getSleepLengthMinutes() <= 600) {
                return true;
            }
        }
        return false;
    }

    public boolean isRdiComputed() {
        return getEvents().hasLabel(EventLabel.RDI) || getEvents().hasLabel(EventLabel.APNEA);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isTooShortToSave() {
        boolean z;
        Date date;
        try {
            if (!this.history.isEmpty() || ((date = this.to) != null && date.getTime() - this.from.getTime() >= 60000)) {
                z = false;
            } else if (!Experiments.getInstance().isOurExperimentalPhone()) {
                z = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public void logLatestValuesReverse(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        List<Float> filteredHistory = z ? getFilteredHistory() : getHistory();
        ListIterator<Float> listIterator = filteredHistory.listIterator(filteredHistory.size());
        for (int i2 = 0; listIterator.hasPrevious() && i2 < i; i2++) {
            sb.append(listIterator.previous());
            sb.append(" ,");
        }
        sb.append("..");
        StringBuilder sb2 = new StringBuilder("Record ");
        sb2.append(z ? "FILTERED" : "RAW");
        sb2.append(" values (reverse): ");
        sb2.append((Object) sb);
        Logger.logInfo(sb2.toString());
    }

    public void mergeAwakeOverlaps() {
        EventLabel eventLabel = EventLabel.AWAKE_START;
        EventLabel eventLabel2 = EventLabel.AWAKE_END;
        clearSleepRecordOverlaps(new EventPair(eventLabel, eventLabel2));
        EventsUtil.mergeOverlaps(this, new EventPair(eventLabel, eventLabel2), 300000L);
    }

    public synchronized void rateAndComment(String str, float f) {
        saveComment(str);
        this.rating = f;
    }

    public synchronized void removeListener(SleepRecordChangeListener sleepRecordChangeListener) {
        this.listeners.remove(sleepRecordChangeListener);
    }

    public int resolveRdi() {
        Events events = getEvents();
        EventLabel eventLabel = EventLabel.RDI;
        if (events.hasLabel(eventLabel)) {
            List<IEvent> events2 = EventsUtil.getEvents(getEvents().getCopiedEvents(), eventLabel);
            if (events2.size() > 0) {
                return Math.round(events2.get(0).getValue());
            }
        }
        if (getEvents().hasLabel(EventLabel.APNEA) || getEvents().hasLabel(EventLabel.RR)) {
            return computeRdiFromExistingRespiratoryAndApneaEvents();
        }
        if (getEvents().hasLabel(EventLabel.SPO2)) {
            return generateNewApneaEventsAndComputeRdiFromSpo2();
        }
        return -1;
    }

    public synchronized void saveComment(String str) {
        if (str == null) {
            str = "";
        }
        try {
            if (str.length() > 10000) {
                str = str.substring(0, 10000);
            }
            this.comment = str;
        } catch (Throwable th) {
            throw th;
        }
    }

    public String serialize() {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        StringBuilder sb = new StringBuilder();
        Iterator<Float> it = this.history.iterator();
        while (it.hasNext()) {
            sb.append(decimalFormat.format(it.next()) + "\n");
        }
        return sb.toString();
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCycles(int i) {
        this.cycles = i;
    }

    public void setFinished(boolean z) {
        this.finished = z;
    }

    public void setFrom(Date date) {
        if (date != null) {
            this.from = date;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
        }
    }

    public void setGeo(String str) {
        this.geo = str;
    }

    public void setHideSleepAnalysis(boolean z) {
        if (!z) {
            getEvents().clearLabels(EventLabel.T);
            return;
        }
        Events events = getEvents();
        EventLabel eventLabel = EventLabel.T;
        if (events.hasLabel(eventLabel)) {
            return;
        }
        getEvents().addEvent(getFromTime(), eventLabel, 1.0f);
    }

    public synchronized void setHistory(List<Float> list) {
        this.history = list;
    }

    public void setLenAdjust(int i) {
        this.lenAdjust = i;
    }

    public void setNoiseLevel(float f) {
        this.noiseLevel = f;
    }

    public synchronized void setOrUpdateAlarmTimeLabels(Alarm alarm) {
        Logger.logDebug("Updating alarm time labels: " + alarm);
        parseRawTimestampedEventLabelsIfRequired();
        for (Event event : this.events.getCopiedEvents()) {
            if (event.getLabel() == EventLabel.ALARM_SNOOZE || event.getLabel() == EventLabel.ALARM_SNOOZE_AFTER_KILL) {
                return;
            }
        }
        Iterator<Event> it = this.events.getCopiedEvents().iterator();
        while (it.hasNext()) {
            Event next = it.next();
            if (next.getLabel() == EventLabel.ALARM_EARLIEST) {
                it.remove();
            } else if (next.getLabel() == EventLabel.ALARM_LATEST) {
                it.remove();
            }
        }
        if (alarm != null && alarm.time > System.currentTimeMillis() && alarm.time - System.currentTimeMillis() < TimeChart.DAY) {
            long earliesWakeTime = alarm.getEarliesWakeTime(CurrentSleepRecord.getInstance().getRecord());
            if (earliesWakeTime < alarm.time) {
                addEventLabel(EventLabel.ALARM_EARLIEST, earliesWakeTime);
            }
            addEventLabel(EventLabel.ALARM_LATEST, alarm.time);
        }
    }

    public void setQuality(float f) {
        this.quality = f;
    }

    public synchronized void setRawTimestampedEventLabels(byte[] bArr, boolean z) {
        this.rawtimestampedEventLabels = bArr;
        this.rawtimestampedEventLabelsNewFormat = z;
    }

    public synchronized void setSnore(int i) {
        this.snore = i;
    }

    public void setTo(Date date) {
        this.to = date;
    }

    public boolean shouldUseExactFitView() {
        return getVersion() >= 10004;
    }

    public String toString() {
        return "SleepRecord: " + getFrom() + " -> " + getTo() + " History length: " + this.history.size() + " Noise history length: " + this.noiseHistory.size() + " cycles " + getCycles() + " snore " + getSnore();
    }

    public synchronized void updateLatestTo(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Latest to date must not be null");
        }
        this.lastestTo = date;
    }

    @Override // android.os.Parcelable
    public synchronized void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.writeNullableDate(parcel, this.from);
        parcel.writeString(this.timezone);
        ParcelUtil.writeNullableDate(parcel, this.lastestTo);
        ParcelUtil.writeNullableDate(parcel, this.to);
        parcel.writeInt(this.version);
        parcel.writeString(this.comment);
        parcel.writeFloat(this.rating);
        parcel.writeFloat(this.lastEntry);
        parcel.writeList(this.history);
        parcel.writeInt(this.lenAdjust);
        parcel.writeFloat(this.quality);
        parcel.writeMap(new HashMap());
        parcel.writeList(this.noiseHistory);
        parcel.writeFloat(this.noiseLevel);
        parcel.writeInt(this.cycles);
        parcel.writeInt(this.snore);
        parcel.writeByte(this.finished ? (byte) 1 : (byte) 0);
        parseRawTimestampedEventLabelsIfRequired();
        EventsAndroidSpecific.writeToParcel(this.events, parcel);
        parcel.writeString(this.geo);
        parcel.writeList(this.tempHistory);
        parcel.writeByte(this.hideSleepAnalysis ? (byte) 1 : (byte) 0);
    }

    public synchronized void addEventLabel(EventLabel eventLabel, long j, float f) {
        parseRawTimestampedEventLabelsIfRequired();
        this.events.addEvent(j, eventLabel, f);
    }

    public Set<String> getTags() {
        return getTags(null);
    }

    public void addTag(Tag tag) {
        addTag(tag, 1);
    }

    public void computeAll() {
        computeAll(false);
    }

    public SleepRecord(String str, Date date, Date date2) {
        this(str, date, date2, getCurrentSetupVersion());
    }

    public SleepRecord(Date date, Date date2, String str) {
        this(str, date, date2);
        this.to = date2;
    }

    public SleepRecord(String str, Date date, Date date2, int i) {
        this.noiseLevel = -1.0f;
        this.lenAdjust = 0;
        this.quality = -2.0f;
        this.cycles = -1;
        this.snore = -1;
        this.history = new ArrayList();
        this.noiseHistory = new ArrayList();
        this.hrHistory = new ArrayList();
        this.events = new Events();
        this.tempHistory = new ArrayList();
        this.rawtimestampedEventLabelsNewFormat = false;
        this.listeners = new HashSet();
        this.hideSleepAnalysis = false;
        if (date2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Latest to date must not be null");
            throw null;
        }
        if (date != null) {
            this.timezone = str;
            this.from = date;
            this.lastestTo = date2;
            this.version = i;
            this.comment = "";
            this.rating = 0.0f;
            this.lenAdjust = 0;
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("From must not be null");
        throw null;
    }

    public SleepRecord(SleepRecord sleepRecord, boolean z) {
        this.noiseLevel = -1.0f;
        this.lenAdjust = 0;
        this.quality = -2.0f;
        this.cycles = -1;
        this.snore = -1;
        this.history = new ArrayList();
        this.noiseHistory = new ArrayList();
        this.hrHistory = new ArrayList();
        this.events = new Events();
        this.tempHistory = new ArrayList();
        this.rawtimestampedEventLabelsNewFormat = false;
        this.listeners = new HashSet();
        this.hideSleepAnalysis = false;
        if (sleepRecord.from != null) {
            this.from = new Date(sleepRecord.from.getTime());
            this.to = sleepRecord.to == null ? null : new Date(sleepRecord.to.getTime());
            this.finished = sleepRecord.finished;
            this.lastestTo = sleepRecord.lastestTo != null ? new Date(sleepRecord.lastestTo.getTime()) : null;
            this.timezone = sleepRecord.timezone;
            this.version = sleepRecord.version;
            this.comment = sleepRecord.comment;
            this.tempHistory = sleepRecord.tempHistory;
            this.rating = sleepRecord.getRating();
            this.lastEntry = sleepRecord.getLastEntry();
            if (z) {
                this.history = sleepRecord.getFilteredHistory();
            } else {
                this.history = sleepRecord.getHistory();
            }
            this.noiseHistory = sleepRecord.getNoiseHistory();
            this.lenAdjust = sleepRecord.getLenAdjust();
            this.quality = sleepRecord.getQuality();
            this.cycles = sleepRecord.getCycles();
            this.snore = sleepRecord.getSnore();
            this.noiseLevel = sleepRecord.getNoiseLevel();
            parseRawTimestampedEventLabelsIfRequired();
            this.events = new Events(sleepRecord.events);
            this.geo = sleepRecord.getGeo();
            this.hideSleepAnalysis = sleepRecord.isHideSleepAnalysis();
            this.lastActivityUpdate = sleepRecord.lastActivityUpdate;
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Original from should never by null.");
        throw null;
    }

    public /* synthetic */ SleepRecord(Parcel parcel, int i) {
        this(parcel);
    }
}
