package com.urbandroid.sleep.domain;

import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;

/* JADX INFO: loaded from: classes4.dex */
public interface DeepSleepDetector {

    public enum SleepPhase {
        DEEP_SLEEP,
        LIGHT_SLEEP,
        UNKNOWN;

        public boolean isDeepSleep() {
            return this == DEEP_SLEEP;
        }

        public boolean isLightSleep() {
            return this == LIGHT_SLEEP;
        }
    }

    SleepPhase getSleepPhase();

    void update(IActivityAggregator.Result result);
}
