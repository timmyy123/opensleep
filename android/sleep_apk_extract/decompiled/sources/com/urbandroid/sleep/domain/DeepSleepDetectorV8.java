package com.urbandroid.sleep.domain;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.DeepSleepDetector;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SettingsExtKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public class DeepSleepDetectorV8 implements DeepSleepDetector {
    private final DeepSleepIndicator deepSleepIndicator;
    private final SleepPhaseIntentBroadcast sleepPhaseBroadcast;

    /* JADX INFO: renamed from: -$$Nest$smminutes, reason: not valid java name */
    public static /* bridge */ /* synthetic */ int m1631$$Nest$smminutes() {
        return minutes(5);
    }

    public DeepSleepDetectorV8(boolean z, Function0<Long> function0) {
        int i = 0;
        this.sleepPhaseBroadcast = new SleepPhaseIntentBroadcast(function0, i);
        this.deepSleepIndicator = new DeepSleepIndicator(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSmartWakeupSensitivityChecks() {
        return SettingsExtKt.mapSmartWakeupSensitivityChecks(SharedApplicationContext.getSettings(), 1, 3, 6, 10, 3);
    }

    private static final int minutes(int i) {
        return i * 60000;
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

    public static class DeepSleepIndicator {
        private FloatFunction highActivityCountShortWindow;
        private final boolean isSmartWatch;
        private DeepSleepDetector.SleepPhase lastResult;
        private MissingDataGuard missingDataGuard;
        private int pointsCount;
        private final int smartWakeupSensitivityChecks;
        private FloatFunction someActivityCountLongWindow;

        private DeepSleepIndicator(boolean z) {
            this.isSmartWatch = z;
            this.smartWakeupSensitivityChecks = DeepSleepDetectorV8.getSmartWakeupSensitivityChecks();
            reset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeepSleepDetector.SleepPhase getSleepPhase() {
            return this.lastResult;
        }

        private void reset() {
            this.missingDataGuard = new MissingDataGuard(0);
            this.highActivityCountShortWindow = Moving.sum(this.isSmartWatch ? 12 : 6);
            this.someActivityCountLongWindow = Moving.sum(30);
            this.lastResult = DeepSleepDetector.SleepPhase.UNKNOWN;
            this.pointsCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(IActivityAggregator.Result result) {
            this.missingDataGuard.update(result);
            if (this.missingDataGuard.getMissingDataRatio5min() > 0.9d) {
                Logger.logInfo("DeepSleepDetectorV8: reset - a lot of data missing");
                reset();
            } else {
                if (this.missingDataGuard.isLastDataMissing()) {
                    return;
                }
                float fApply = this.highActivityCountShortWindow.apply(result.isHighActivity ? 1.0f : 0.0f);
                float fApply2 = this.someActivityCountLongWindow.apply(result.isSomeActivity ? 1.0f : 0.0f);
                int i = this.pointsCount + 1;
                this.pointsCount = i;
                if (i < 12) {
                    this.lastResult = DeepSleepDetector.SleepPhase.UNKNOWN;
                } else {
                    this.lastResult = (Math.round(fApply) < 1 || Math.round(fApply2) < this.smartWakeupSensitivityChecks) ? DeepSleepDetector.SleepPhase.DEEP_SLEEP : DeepSleepDetector.SleepPhase.LIGHT_SLEEP;
                }
            }
        }

        public /* synthetic */ DeepSleepIndicator(boolean z, int i) {
            this(z);
        }
    }

    public static class MissingDataGuard {
        private boolean lastDataMissing;
        private final FloatFunction missingDataCount10min;
        private final FloatFunction missingDataCount5min;
        private float missingDataRatio10min;
        private float missingDataRatio5min;

        private MissingDataGuard() {
            this.missingDataCount5min = Moving.sum(30);
            this.missingDataCount10min = Moving.sum(60);
        }

        public float getMissingDataRatio5min() {
            return this.missingDataRatio5min;
        }

        public boolean isLastDataMissing() {
            return this.lastDataMissing;
        }

        public void update(IActivityAggregator.Result result) {
            boolean zHasNoData = result.hasNoData();
            this.lastDataMissing = zHasNoData;
            float f = zHasNoData ? 1.0f : 0.0f;
            float fApply = this.missingDataCount5min.apply(f);
            float fApply2 = this.missingDataCount10min.apply(f);
            this.missingDataRatio5min = fApply / 30.0f;
            this.missingDataRatio10min = fApply2 / 60.0f;
        }

        public /* synthetic */ MissingDataGuard(int i) {
            this();
        }
    }

    public DeepSleepDetectorV8(boolean z) {
        this(z, new Function0<Long>() { // from class: com.urbandroid.sleep.domain.DeepSleepDetectorV8.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public Long invoke() {
                return Long.valueOf(System.currentTimeMillis());
            }
        });
    }

    public static class SleepPhaseIntentBroadcast {
        private final Function0<Long> clock;
        private long deepSleepFrom;
        private boolean deepSleepReported;
        private final FloatFunction highActivityCount;
        private long lastAwake;
        private final MissingDataGuard missingDataGuard;
        private final RemDetector remDetector;
        private final int smartWakeupSensitivityChecks;
        private final FloatFunction someActivityCount;

        private SleepPhaseIntentBroadcast(Function0<Long> function0) {
            this.deepSleepFrom = -1L;
            this.deepSleepReported = false;
            this.lastAwake = 0L;
            this.missingDataGuard = new MissingDataGuard(0);
            this.someActivityCount = Moving.sum(30);
            this.highActivityCount = Moving.sum(30);
            this.clock = function0;
            this.smartWakeupSensitivityChecks = DeepSleepDetectorV8.getSmartWakeupSensitivityChecks();
            this.remDetector = createRemDetector(function0);
        }

        private RemDetector createRemDetector(Function0<Long> function0) {
            if (!Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
                return new RemDetectorV1(function0);
            }
            int lucidSensitivity = SharedApplicationContext.getSettings().getLucidSensitivity();
            if (lucidSensitivity == 1) {
                return RemDetectorV2.INSTANCE.newInstanceLowSensitivity(function0);
            }
            if (lucidSensitivity == 2) {
                return RemDetectorV2.INSTANCE.newInstanceMediumSensitivity(function0);
            }
            if (lucidSensitivity == 3) {
                return RemDetectorV2.INSTANCE.newInstanceHighSensitivity(function0);
            }
            Logger.logWarning("DeepSleepDetectorV8: invalid lucid sensitivity: " + lucidSensitivity);
            return RemDetectorV2.INSTANCE.newInstanceMediumSensitivity(function0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(IActivityAggregator.Result result) {
            this.missingDataGuard.update(result);
            if (this.missingDataGuard.isLastDataMissing()) {
                return;
            }
            long jLongValue = this.clock.invoke().longValue();
            int iRound = Math.round(this.someActivityCount.apply(result.isSomeActivity ? 1.0f : 0.0f));
            if (Math.round(this.highActivityCount.apply(result.isHighActivity ? 1.0f : 0.0f)) < 1 || iRound < this.smartWakeupSensitivityChecks) {
                if (this.deepSleepFrom == -1) {
                    this.deepSleepFrom = jLongValue;
                }
                long j = this.deepSleepFrom;
                if (j > 0 && jLongValue - j > DeepSleepDetectorV8.m1631$$Nest$smminutes()) {
                    if (!this.deepSleepReported) {
                        Logger.logInfo("DeepSleepDetectorV8: Deep sleep");
                        zza$$ExternalSyntheticOutline0.m(SharedApplicationContext.getInstance().getContext(), "com.urbandroid.sleep.TRACKING_DEEP_SLEEP");
                        this.deepSleepReported = true;
                    }
                    this.remDetector.handleDeepSleep();
                }
            } else {
                this.deepSleepFrom = -1L;
                if (this.deepSleepReported) {
                    this.deepSleepReported = false;
                    Logger.logInfo("DeepSleepDetectorV8: Light sleep");
                    zza$$ExternalSyntheticOutline0.m(SharedApplicationContext.getInstance().getContext(), "com.urbandroid.sleep.TRACKING_LIGHT_SLEEP");
                }
                this.remDetector.handleLightSleep();
            }
            if (SleepService.isAwake()) {
                this.lastAwake = jLongValue;
            }
            if (jLongValue - this.lastAwake < 180000) {
                this.remDetector.handleAwake();
            }
        }

        public /* synthetic */ SleepPhaseIntentBroadcast(Function0 function0, int i) {
            this(function0);
        }
    }
}
