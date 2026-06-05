package com.urbandroid.sleep.domain;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepRecordTemporaryPersister;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Date;
import java.util.TimeZone;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class CurrentSleepRecord {
    private static final CurrentSleepRecord ourInstance = new CurrentSleepRecord();
    private volatile SleepRecord record;
    private volatile boolean recordRestored = false;

    private CurrentSleepRecord() {
    }

    public static CurrentSleepRecord getInstance() {
        return ourInstance;
    }

    public static SleepRecord getLastRecoverableRecord() {
        SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
        if (lastSleepRecord != null && !lastSleepRecord.isFinished() && lastSleepRecord.getTo() != null) {
            if (lastSleepRecord.getTo().getTime() + 1800000 < System.currentTimeMillis()) {
                Logger.logInfo("Ignoring too old unfinished record on recovery: " + lastSleepRecord.getFrom());
                return null;
            }
            SleepRecord lastTemporaryRecord = SleepRecordTemporaryPersister.getLastTemporaryRecord();
            if (lastTemporaryRecord == null) {
                Logger.logInfo("No last record");
                return null;
            }
            if (lastTemporaryRecord.getFrom() != null && lastSleepRecord.getFrom() != null) {
                if (lastTemporaryRecord.getFrom().getTime() == lastSleepRecord.getFrom().getTime()) {
                    return lastTemporaryRecord;
                }
                Logger.logInfo("No last temp record or it is different from last db record.");
                return null;
            }
            Logger.logInfo("Ignored due to null from date..");
        }
        return null;
    }

    public SleepRecord getRecord() {
        return this.record;
    }

    public SleepRecord initRecord(Date date) {
        if (this.record == null || this.record.getTo() != null) {
            Logger.logInfo("Initialized new sleep record with end data: " + date);
            this.record = new SleepRecord(TimeZone.getDefault().getID(), new Date(), date);
            this.recordRestored = false;
            this.record.addListener(new SleepRecordTemporaryPersister());
        }
        return this.record;
    }

    public void invalidate() {
        this.record = null;
    }

    public boolean isInProcessTracking() {
        return (this.record == null || this.record.isFinished()) ? false : true;
    }

    public boolean isRecordRestored() {
        return this.recordRestored;
    }

    public void restoreRecord(SleepRecord sleepRecord) {
        if (this.record != null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Cannot restore record while another record is active");
            return;
        }
        if (sleepRecord.getTo() == null) {
            sleepRecord.setTo(new Date());
        }
        this.recordRestored = true;
        this.record = sleepRecord;
        this.record.addListener(new SleepRecordTemporaryPersister());
    }

    public SleepRecord initRecord(Alarm alarm) {
        if (alarm != null) {
            SleepRecord sleepRecordInitRecord = initRecord(new Date(alarm.time));
            sleepRecordInitRecord.setOrUpdateAlarmTimeLabels(alarm);
            return sleepRecordInitRecord;
        }
        return initRecord(SleepStarter.FAR_FAR_DATE);
    }
}
