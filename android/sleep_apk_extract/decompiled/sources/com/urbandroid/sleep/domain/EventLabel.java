package com.urbandroid.sleep.domain;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public enum EventLabel implements Serializable {
    ALARM_EARLIEST,
    ALARM_LATEST,
    ALARM_SNOOZE,
    ALARM_SNOOZE_AFTER_KILL,
    ALARM_DISMISS,
    TRACKING_PAUSED,
    TRACKING_RESUMED,
    TRACKING_STOPPED_BY_USER,
    ALARM_STARTED,
    SNORING,
    LOW_BATTERY,
    DEEP_START,
    DEEP_END,
    LIGHT_START,
    LIGHT_END,
    REM_START,
    REM_END,
    UNKNOWN,
    BROKEN_START,
    BROKEN_END,
    WALKING_START,
    WALKING_END,
    AWAKE_START,
    AWAKE_END,
    HR(true),
    HR_HIGH_START,
    HR_HIGH_END,
    LUCID_CUE,
    SPO2(true),
    APNEA,
    RR(true),
    TALK,
    BABY,
    SICK,
    LAUGH,
    DHA(true),
    FLAGS,
    T,
    LUX(true),
    ANTISNORE,
    NO_AWAKE,
    DEVICE(true),
    SDNN(true),
    SDANN(true),
    RDI(true);

    private final boolean hasValue;

    EventLabel() {
        this.hasValue = false;
    }

    public boolean hasValue() {
        return this.hasValue;
    }

    EventLabel(boolean z) {
        this.hasValue = z;
    }
}
