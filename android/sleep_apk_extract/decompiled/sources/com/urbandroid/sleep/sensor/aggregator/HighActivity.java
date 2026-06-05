package com.urbandroid.sleep.sensor.aggregator;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SettingsExtKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HighActivity {

    public interface Detector {
        Result update(float f);
    }

    public static class NormalizedAmplitudeBased implements Detector {
        private static final Result RESULT_NONE = new Result(false);
        private volatile int callCount = 0;
        private final float highActivityThreshold;
        private final FloatFunction maximum;
        private final FloatFunction median;
        private final float someActivityThreshold;

        public NormalizedAmplitudeBased(float f) {
            if (Experiments.getInstance().isActigraphyImprovementsExperiment2()) {
                this.someActivityThreshold = 2.5f;
                this.highActivityThreshold = 3.3f;
            } else {
                this.someActivityThreshold = SettingsExtKt.mapDeepSleepSensitivity(SharedApplicationContext.getSettings(), 4.0f, 3.0f, 2.5f, 2.0f, 2.5f) * f;
                this.highActivityThreshold = SettingsExtKt.mapDeepSleepSensitivity(SharedApplicationContext.getSettings(), 6.75f, 4.5f, 3.0f, 2.0f, 3.0f) * f;
            }
            if (Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
                this.maximum = Moving.quantileScalable(720, 0.995f);
            } else {
                this.maximum = Moving.max(720);
            }
            this.median = Moving.quantileScalable(720, 0.5f);
            Logger.logInfo("HighActivity.NormalizedAmplitudeBased init: " + this.someActivityThreshold + ", " + this.highActivityThreshold);
        }

        private Result doUpdate(float f) {
            float fAbs = Math.abs(f);
            float fApply = this.median.apply(fAbs);
            if (fApply != 0.0f) {
                fAbs /= fApply;
            }
            float fApply2 = this.maximum.apply(fAbs);
            if (fApply2 <= 1.0f) {
                return RESULT_NONE;
            }
            if (this.callCount < 360) {
                fApply2 = Math.max(100.0f, fApply2);
            }
            float fPow = (float) Math.pow(Math.min(fApply2, fAbs), 1.0d / Math.log10(fApply2));
            return new Result(fPow > this.someActivityThreshold, fPow > this.highActivityThreshold);
        }

        @Override // com.urbandroid.sleep.sensor.aggregator.HighActivity.Detector
        public Result update(float f) {
            this.callCount++;
            return this.callCount >= 30 ? doUpdate(f) : RESULT_NONE;
        }
    }

    public static Detector normalizedAmplitudeBased(float f) {
        return new NormalizedAmplitudeBased(f);
    }

    public static class Result {
        public final boolean isHighActivity;
        public final boolean isSomeActivity;

        public Result(boolean z, boolean z2) {
            this.isSomeActivity = z;
            this.isHighActivity = z2;
        }

        public String toString() {
            return "HighActivity.Result(" + this.isSomeActivity + "," + this.isHighActivity + ")";
        }

        public Result(boolean z) {
            this(z, z);
        }
    }
}
