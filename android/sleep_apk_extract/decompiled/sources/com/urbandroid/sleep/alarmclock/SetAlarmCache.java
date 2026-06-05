package com.urbandroid.sleep.alarmclock;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.Md5Util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SetAlarmCache {
    private Map<SetAlarmType, SetAlarmData> cache = new HashMap();

    public class SetAlarmData {
        private boolean canScheduleExactAlarm;
        private String lastScheduledAlarmFingerprint;
        private long lastScheduledAlarmSetAlertTime;
        private long lastScheduledAlarmTime;

        public SetAlarmData(long j, String str, long j2, boolean z) {
            this.lastScheduledAlarmTime = j;
            this.lastScheduledAlarmFingerprint = str;
            this.lastScheduledAlarmSetAlertTime = j2;
            this.canScheduleExactAlarm = z;
        }
    }

    public enum SetAlarmType {
        ALARM,
        TIME_TO_BED,
        AUTO_START,
        SHOW_SKIP,
        AUTO_START_BEDTIME
    }

    private String getAlarmFingerprint(Alarm alarm) {
        return String.valueOf(alarm.id) + "-" + Md5Util.md5(alarm.serializeToArray());
    }

    public void reset(SetAlarmType setAlarmType) {
        Logger.logInfo("SetAlarmCache:Resetting cache for: " + setAlarmType);
        this.cache.remove(setAlarmType);
    }

    public boolean shouldSetAlarmNow(SetAlarmType setAlarmType, Alarm alarm, long j, boolean z) {
        SetAlarmData setAlarmData = this.cache.get(setAlarmType);
        String alarmFingerprint = getAlarmFingerprint(alarm);
        if (setAlarmData != null && setAlarmData.lastScheduledAlarmFingerprint.equals(alarmFingerprint) && setAlarmData.lastScheduledAlarmTime == j && setAlarmData.canScheduleExactAlarm == z) {
            Logger.logInfo("SetAlarmCache:Reject firing of (" + setAlarmType + ") for: " + alarmFingerprint + " - " + j + " (" + new Date(j) + ")");
            return false;
        }
        Logger.logInfo("SetAlarmCache:Setting in memory last scheduled alarm (" + setAlarmType + ") to: " + alarmFingerprint + " - " + j + " (" + new Date(j) + ")");
        this.cache.put(setAlarmType, new SetAlarmData(j, alarmFingerprint, System.currentTimeMillis(), z));
        return true;
    }

    public void reset() {
        Logger.logInfo("SetAlarmCache:Resetting all SetAlarm cache");
        this.cache.clear();
    }
}
