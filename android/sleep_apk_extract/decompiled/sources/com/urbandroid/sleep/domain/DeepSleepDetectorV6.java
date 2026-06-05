package com.urbandroid.sleep.domain;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.DeepSleepDetector;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.SettingsExtKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public class DeepSleepDetectorV6 implements DeepSleepDetector {
    private final DeepSleepIndicator deepSleepIndicator;
    private final SleepPhaseIntentBroadcast sleepPhaseBroadcast;

    public DeepSleepDetectorV6(boolean z) {
        int i = 0;
        this.sleepPhaseBroadcast = new SleepPhaseIntentBroadcast(i);
        this.deepSleepIndicator = new DeepSleepIndicator(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSmartWakeupSensitivityChecks() {
        return SettingsExtKt.mapSmartWakeupSensitivityChecks(SharedApplicationContext.getSettings(), 1, 2, 4, 8, 2);
    }

    @Override // com.urbandroid.sleep.domain.DeepSleepDetector
    public synchronized DeepSleepDetector.SleepPhase getSleepPhase() {
        return this.deepSleepIndicator.getSleepPhase();
    }

    @Override // com.urbandroid.sleep.domain.DeepSleepDetector
    public synchronized void update(IActivityAggregator.Result result) {
        this.sleepPhaseBroadcast.update(result);
        this.deepSleepIndicator.update(result);
    }

    public static class MissingDataGuard {
        private boolean lastDataMissing;
        private boolean lotOfDataMissing;
        private final FloatFunction missingDataCount;

        private MissingDataGuard() {
            this.missingDataCount = Moving.sum(60);
        }

        public boolean isLastDataMissing() {
            return this.lastDataMissing;
        }

        public boolean isLotOfDataMissing() {
            return this.lotOfDataMissing;
        }

        public void update(IActivityAggregator.Result result) {
            this.lastDataMissing = result.hasNoData();
            this.lotOfDataMissing = this.missingDataCount.apply(result.hasNoData() ? 1.0f : 0.0f) == 60.0f;
        }

        public /* synthetic */ MissingDataGuard(int i) {
            this();
        }
    }

    public static class DeepSleepIndicator {
        private FloatFunction highActivityCountLongWindow;
        private FloatFunction highActivityCountShortWindow;
        private final int lastPeakWindow;
        private DeepSleepDetector.SleepPhase lastResult;
        private MissingDataGuard missingDataGuard;
        private int pointsCount;
        private final int smartWakeupSensitivityChecks;

        private DeepSleepIndicator(boolean z) {
            this.lastPeakWindow = z ? 12 : 6;
            this.smartWakeupSensitivityChecks = DeepSleepDetectorV6.getSmartWakeupSensitivityChecks();
            reset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeepSleepDetector.SleepPhase getSleepPhase() {
            return this.lastResult;
        }

        private void reset() {
            this.missingDataGuard = new MissingDataGuard(0);
            this.highActivityCountShortWindow = Moving.sum(this.lastPeakWindow);
            this.highActivityCountLongWindow = Moving.sum(60);
            this.lastResult = DeepSleepDetector.SleepPhase.UNKNOWN;
            this.pointsCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(IActivityAggregator.Result result) {
            this.missingDataGuard.update(result);
            if (this.missingDataGuard.isLotOfDataMissing()) {
                Logger.logInfo("DeepSleepDetectorV6: reset - a lot of data missing");
                reset();
                return;
            }
            if (this.missingDataGuard.isLastDataMissing()) {
                return;
            }
            float f = result.isHighActivity ? 1.0f : 0.0f;
            float fApply = this.highActivityCountShortWindow.apply(f);
            float fApply2 = this.highActivityCountLongWindow.apply(f);
            int i = this.pointsCount + 1;
            this.pointsCount = i;
            if (i < 12) {
                this.lastResult = DeepSleepDetector.SleepPhase.UNKNOWN;
            } else {
                this.lastResult = (Math.round(fApply) == 0 || Math.round(fApply2) < this.smartWakeupSensitivityChecks) ? DeepSleepDetector.SleepPhase.DEEP_SLEEP : DeepSleepDetector.SleepPhase.LIGHT_SLEEP;
            }
        }

        public /* synthetic */ DeepSleepIndicator(boolean z, int i) {
            this(z);
        }
    }

    public static class SleepPhaseIntentBroadcast {
        private long deepSleepFrom;
        private boolean deepSleepReported;
        private long lastAwake;
        private final MissingDataGuard missingDataGuard;
        private final RemDetector remDetector;

        private SleepPhaseIntentBroadcast() {
            this.deepSleepFrom = -1L;
            this.deepSleepReported = false;
            this.lastAwake = 0L;
            this.missingDataGuard = new MissingDataGuard(0);
            this.remDetector = new RemDetectorV1(new Function0<Long>() { // from class: com.urbandroid.sleep.domain.DeepSleepDetectorV6.SleepPhaseIntentBroadcast.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public Long invoke() {
                    return Long.valueOf(System.currentTimeMillis());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(IActivityAggregator.Result result) {
            this.missingDataGuard.update(result);
            if (this.missingDataGuard.isLastDataMissing()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (result.isHighActivity) {
                this.deepSleepFrom = -1L;
                if (this.deepSleepReported) {
                    this.deepSleepReported = false;
                    Logger.logInfo("DeepSleepDetectorV6: Light sleep");
                    zza$$ExternalSyntheticOutline0.m(SharedApplicationContext.getInstance().getContext(), "com.urbandroid.sleep.TRACKING_LIGHT_SLEEP");
                }
                this.remDetector.handleLightSleep();
            } else {
                if (this.deepSleepFrom == -1) {
                    this.deepSleepFrom = jCurrentTimeMillis;
                }
                long j = this.deepSleepFrom;
                if (j > 0 && jCurrentTimeMillis - j > 360000) {
                    if (!this.deepSleepReported) {
                        Logger.logInfo("DeepSleepDetectorV6: Deep sleep");
                        zza$$ExternalSyntheticOutline0.m(SharedApplicationContext.getInstance().getContext(), "com.urbandroid.sleep.TRACKING_DEEP_SLEEP");
                        this.deepSleepReported = true;
                    }
                    this.remDetector.handleDeepSleep();
                }
            }
            if (SleepService.isAwake()) {
                this.lastAwake = jCurrentTimeMillis;
            }
            if (jCurrentTimeMillis - this.lastAwake < 180000) {
                this.remDetector.handleAwake();
            }
        }

        public /* synthetic */ SleepPhaseIntentBroadcast(int i) {
            this();
        }
    }
}
