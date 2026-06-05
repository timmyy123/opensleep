package com.urbandroid.sleep.addon.stats.model;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.HrvUtilKt;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.util.HeartRateUtilKt;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class StatRecord implements IStatRecord {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private float[] f61data;
    private long fallAsleep;
    private double fallAsleepHour;
    private Date fromDate;
    private double fromHour;
    private float lengthInHours;
    private TimeZone timeZone;
    private Date toDate;
    private double toHour;
    private float trackLengthInHours;
    private long wakeUp;
    private double wakeUpHour;
    private float hrv = -1.0f;
    private float hr = -1.0f;
    private float minHr = -1.0f;
    private float hrvAfter = -1.0f;
    private float hrvBefore = -1.0f;
    private float hrvGain = -1.0E21f;
    private float irregularity = -1.0f;
    private float irregularityIndex = -1.0f;
    private float rating = -1.0f;
    private float quality = -2.0f;
    private float noiseLevel = -1.0f;
    private int snore = -1;
    private int count = 1;
    private int smart = -1;
    private int rdi = -1;
    private double cycles = 0.0d;
    private int snooze = -1;
    private Set<String> tags = new HashSet();

    public StatRecord(Date date, Date date2, TimeZone timeZone, double d, double d2) {
        this.toDate = date2;
        this.fromDate = date;
        this.timeZone = timeZone;
        this.fromHour = d;
        this.toHour = d2;
    }

    public static StatRecord fromSleepRecord(SleepRecord sleepRecord) {
        int timestamp;
        StatRecord statRecord = new StatRecord();
        statRecord.setToDate(sleepRecord.getTo());
        statRecord.setFromDate(sleepRecord.getFrom());
        statRecord.setTimeZone(sleepRecord.getTimeZone());
        Calendar calendar = getCalendar(sleepRecord);
        calendar.setTime(sleepRecord.getFrom());
        statRecord.setFromHour((((double) calendar.get(12)) / 60.0d) + ((double) calendar.get(11)));
        calendar.setTime(sleepRecord.getTo());
        statRecord.setToHour((((double) calendar.get(12)) / 60.0d) + ((double) calendar.get(11)));
        statRecord.setFallAsleepHour(sleepRecord.getFallAsleepHour());
        statRecord.setFallAsleep(sleepRecord.getFallAsleep());
        statRecord.setWakeUpHour(sleepRecord.getWakeUpHour());
        statRecord.setWakeUp(sleepRecord.getWakeUp());
        statRecord.setRating(sleepRecord.getRating());
        statRecord.setQuality(sleepRecord.getQuality());
        statRecord.setSnore(sleepRecord.getSnore());
        statRecord.setSnooze(sleepRecord.getSnoozeTime());
        statRecord.setHr(HeartRateUtilKt.getHr(sleepRecord));
        statRecord.setMinHr(HeartRateUtilKt.getMinHr(sleepRecord));
        statRecord.getTags().addAll(Tag.getTags(sleepRecord.getComment()));
        float time = sleepRecord.getTo().getTime() - sleepRecord.getFrom().getTime();
        statRecord.setLengthInHours(((time / 60000.0f) + sleepRecord.getLenAdjust()) / 60.0f);
        statRecord.setTrackLengthInHours(time / 3600000.0f);
        Float wholeNightHRV = HrvUtilKt.getWholeNightHRV(sleepRecord);
        if (wholeNightHRV != null) {
            statRecord.setHrv(wholeNightHRV.floatValue());
        }
        Float restingHrvAtEndOfSleep = HrvUtilKt.getRestingHrvAtEndOfSleep(sleepRecord);
        if (restingHrvAtEndOfSleep != null) {
            statRecord.setHrvAfter(restingHrvAtEndOfSleep.floatValue());
        }
        Float restingHrvAtStartOfSleep = HrvUtilKt.getRestingHrvAtStartOfSleep(sleepRecord);
        if (restingHrvAtStartOfSleep != null) {
            statRecord.setHrvBefore(restingHrvAtStartOfSleep.floatValue());
        }
        if (statRecord.getHrvAfter() > 0.0f && statRecord.getHrvBefore() > 0.0f) {
            statRecord.setHrvGain(statRecord.getHrvAfter() - statRecord.getHrvBefore());
        }
        System.currentTimeMillis();
        statRecord.setRdi(sleepRecord.isRdiComputed() ? sleepRecord.resolveRdi() : -1);
        statRecord.setCycles(sleepRecord.getCycles());
        statRecord.setNoiseLevel(sleepRecord.getNoiseLevel());
        List<Event> copiedEvents = sleepRecord.getEvents().getCopiedEvents();
        List<IEvent> events = EventsUtil.getEvents(copiedEvents, EventLabel.ALARM_LATEST);
        List<IEvent> events2 = EventsUtil.getEvents(copiedEvents, EventLabel.ALARM_STARTED);
        if (events.size() > 0 && events2.size() > 0 && (timestamp = ((int) (events.get(0).getTimestamp() - events2.get(0).getTimestamp())) / 60000) > 0) {
            statRecord.setSmart(timestamp);
        }
        return statRecord;
    }

    public static Calendar getCalendar(SleepRecord sleepRecord) {
        Calendar calendar = Calendar.getInstance();
        if (sleepRecord.getTimezone() != null && !sleepRecord.getTimezone().isEmpty()) {
            try {
                calendar.setTimeZone(DesugarTimeZone.getTimeZone(sleepRecord.getTimezone()));
                return calendar;
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return calendar;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRecord
    public int getCount() {
        return this.count;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public double getCycles() {
        return this.cycles;
    }

    public float[] getData() {
        return this.f61data;
    }

    public long getFallAsleep() {
        return this.fallAsleep;
    }

    public double getFallAsleepHour() {
        return this.fallAsleepHour;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRecord
    public double getFromHour() {
        return this.fromHour;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHr() {
        return this.hr;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrv() {
        return this.hrv;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvAfter() {
        return this.hrvAfter;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getHrvBefore() {
        return this.hrvBefore;
    }

    public float getHrvGain() {
        return this.hrvGain;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityInMinutes() {
        return this.irregularity;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getIrregularityIndex() {
        return this.irregularityIndex;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getLengthInHours() {
        return this.lengthInHours;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getMinHr() {
        return this.minHr;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getNoiseLevel() {
        return this.noiseLevel;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getQuality() {
        return this.quality;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getRating() {
        return this.rating;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getRdi() {
        return this.rdi;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSmart() {
        return this.smart;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnooze() {
        return this.snooze;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public int getSnore() {
        return this.snore;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRecord
    public Set<String> getTags() {
        return this.tags;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IStatRecord
    public Date getToDate() {
        return this.toDate;
    }

    public double getToHour() {
        return this.toHour;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasureRecord
    public float getTrackLengthInHours() {
        return this.trackLengthInHours;
    }

    public long getWakeUp() {
        return this.wakeUp;
    }

    public double getWakeUpHour() {
        return this.wakeUpHour;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCycles(double d) {
        this.cycles = d;
    }

    public void setData(float[] fArr) {
        this.f61data = fArr;
    }

    public void setFallAsleep(long j) {
        this.fallAsleep = j;
    }

    public void setFallAsleepHour(double d) {
        this.fallAsleepHour = d;
    }

    public void setFromDate(Date date) {
        this.fromDate = date;
    }

    public void setFromHour(double d) {
        this.fromHour = d;
    }

    public void setHr(float f) {
        this.hr = f;
    }

    public void setHrv(float f) {
        this.hrv = f;
    }

    public void setHrvAfter(float f) {
        this.hrvAfter = f;
    }

    public void setHrvBefore(float f) {
        this.hrvBefore = f;
    }

    public void setHrvGain(float f) {
        this.hrvGain = f;
    }

    public void setIrregularity(float f) {
        this.irregularity = f;
    }

    public void setIrregularityIndex(float f) {
        this.irregularityIndex = f;
    }

    public void setLengthInHours(float f) {
        this.lengthInHours = f;
    }

    public void setMinHr(float f) {
        this.minHr = f;
    }

    public void setNoiseLevel(float f) {
        this.noiseLevel = f;
    }

    public void setQuality(float f) {
        this.quality = f;
    }

    public void setRating(float f) {
        this.rating = f;
    }

    public void setRdi(int i) {
        this.rdi = i;
    }

    public void setSmart(int i) {
        this.smart = i;
    }

    public void setSnooze(int i) {
        this.snooze = i;
    }

    public void setSnore(int i) {
        this.snore = i;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToDate(Date date) {
        this.toDate = date;
    }

    public void setToHour(double d) {
        this.toHour = d;
    }

    public void setTrackLengthInHours(float f) {
        this.trackLengthInHours = f;
    }

    public void setWakeUp(long j) {
        this.wakeUp = j;
    }

    public void setWakeUpHour(double d) {
        this.wakeUpHour = d;
    }

    public String toString() {
        return "(SLEEP from " + this.fromDate + " to " + this.toDate + ")";
    }

    public StatRecord() {
    }
}
