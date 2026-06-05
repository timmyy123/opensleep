package com.urbandroid.sleep.alarmclock;

import com.urbandroid.common.logging.Logger;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmExtendedConfig implements Serializable {
    static final long serialVersionUID = 4242;
    private Integer gradualVolumeIncrease;
    private Integer offsetInMinutes;
    private Long offsetValidTill;
    private String ringtoneName;
    private Integer soundDelay;
    private Boolean terminatesTracking;
    private Integer vibrationStart;
    private Integer vibrationStartSmartWatch;
    private int timeToBed = -2;
    private Integer snoozeAfterAlarm = -2;
    private Boolean isSelfDisposable = Boolean.FALSE;
    private Integer snoozeDuration = -2;
    private Integer snoozeLimit = -2;
    private Integer weekRepeat = 0;
    private Long lastEnableTimestamp = 0L;
    private Long realNextTime = 0L;
    private Set<String> selectedPlaylists = new HashSet();
    private Integer snoozeTotalTimeLimit = -2;
    private Integer idealSleepMinutes = null;
    private Long nonWeeklyFrom = null;
    private Integer nonWeeklyRepeat = null;
    private Integer wakeUpCheck = -2;

    public Integer getGradualVolumeIncrease() {
        return this.gradualVolumeIncrease;
    }

    public Integer getIdealSleepMinutes() {
        return this.idealSleepMinutes;
    }

    public Long getLastEnableTimestamp() {
        return this.lastEnableTimestamp;
    }

    public Long getNonWeeklyFrom() {
        return this.nonWeeklyFrom;
    }

    public Integer getNonWeeklyRepeat() {
        return this.nonWeeklyRepeat;
    }

    public Integer getOffsetInMinutes() {
        return this.offsetInMinutes;
    }

    public Long getOffsetValidTill() {
        return this.offsetValidTill;
    }

    public String getRingtoneName() {
        return this.ringtoneName;
    }

    public Set<String> getSelectedPlaylists() {
        Set<String> set = this.selectedPlaylists;
        return set != null ? set : new HashSet();
    }

    public int getSnoozeAfterAlarm() {
        Integer num = this.snoozeAfterAlarm;
        if (num == null) {
            return -2;
        }
        return num.intValue();
    }

    public Integer getSnoozeDuration() {
        Integer num = this.snoozeDuration;
        return Integer.valueOf(num != null ? num.intValue() : -2);
    }

    public Integer getSnoozeLimit() {
        Integer num = this.snoozeLimit;
        return Integer.valueOf(num != null ? num.intValue() : -2);
    }

    public Integer getSnoozeTotalTimeLimit() {
        Integer num = this.snoozeTotalTimeLimit;
        return Integer.valueOf(num != null ? num.intValue() : -2);
    }

    public Integer getSoundDelay() {
        Integer num;
        Integer num2 = this.soundDelay;
        if (num2 != null) {
            return num2;
        }
        Integer num3 = this.vibrationStart;
        return ((num3 == null || ((long) num3.intValue()) != -20000) && ((num = this.vibrationStartSmartWatch) == null || ((long) num.intValue()) != -20000)) ? -2 : 60000;
    }

    public int getTimeToBed() {
        return this.timeToBed;
    }

    public Integer getVibrationStart() {
        if (this.vibrationStart == null || r0.intValue() != -20000) {
            return this.vibrationStart;
        }
        return 0;
    }

    public Integer getVibrationStartSmartWatch() {
        if (this.vibrationStartSmartWatch == null || r0.intValue() != -20000) {
            return this.vibrationStartSmartWatch;
        }
        return 0;
    }

    public Integer getWakeUpCheck() {
        Integer num = this.wakeUpCheck;
        if (num == null || num.intValue() == -1) {
            return -2;
        }
        return this.wakeUpCheck;
    }

    public Integer getWeekRepeat() {
        return this.weekRepeat;
    }

    public boolean hasOffset() {
        Integer num = this.offsetInMinutes;
        return (num == null || num.intValue() == 0) ? false : true;
    }

    public boolean isNonWeekly() {
        Integer num;
        return (this.nonWeeklyFrom == null || (num = this.nonWeeklyRepeat) == null || num.intValue() <= 0) ? false : true;
    }

    public Boolean isSelfDisposable() {
        Boolean bool = this.isSelfDisposable;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Boolean isTerminatesTracking() {
        Boolean bool = this.terminatesTracking;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public void resetOffset() {
        this.offsetInMinutes = null;
        this.offsetValidTill = null;
    }

    public void setGradualVolumeIncrease(Integer num) {
        this.gradualVolumeIncrease = num;
    }

    public void setIdealSleepMinutes(Integer num) {
        Logger.logInfo("Ideal " + num);
        this.idealSleepMinutes = num;
    }

    public void setLastEnableTimestamp(Long l) {
        this.lastEnableTimestamp = l;
    }

    public void setNonWeeklyFrom(Long l) {
        this.nonWeeklyFrom = l;
    }

    public void setNonWeeklyRepeat(Integer num) {
        this.nonWeeklyRepeat = num;
    }

    public void setOffsetInMinutes(Integer num) {
        this.offsetInMinutes = num;
    }

    public void setOffsetValidTill(Long l) {
        this.offsetValidTill = l;
    }

    public void setRingtoneName(String str) {
        this.ringtoneName = str;
    }

    public void setSelectedPlaylists(Set<String> set) {
        this.selectedPlaylists = set;
    }

    public void setSelfDisposable(Boolean bool) {
        this.isSelfDisposable = bool;
    }

    public void setSnoozeAfterAlarm(int i) {
        this.snoozeAfterAlarm = Integer.valueOf(i);
    }

    public void setSnoozeDuration(Integer num) {
        this.snoozeDuration = num;
    }

    public void setSnoozeLimit(Integer num) {
        this.snoozeLimit = num;
    }

    public void setSnoozeTotalTimeLimit(Integer num) {
        this.snoozeTotalTimeLimit = num;
    }

    public void setSoundDelay(Integer num) {
        this.soundDelay = num;
    }

    public void setTerminatesTracking(Boolean bool) {
        this.terminatesTracking = bool;
    }

    public void setTimeToBed(int i) {
        this.timeToBed = i;
    }

    public void setVibrationStart(Integer num) {
        this.vibrationStart = num;
    }

    public void setVibrationStartSmartWatch(Integer num) {
        this.vibrationStartSmartWatch = num;
    }

    public void setWakeUpCheck(Integer num) {
        this.wakeUpCheck = num;
    }

    public void setWeekRepeat(Integer num) {
        this.weekRepeat = num;
    }
}
