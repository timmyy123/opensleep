package com.urbandroid.sleep.sensor.aggregator;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.SensorType;
import com.urbandroid.sleep.sensor.aggregator.HighActivity;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityAggregatorAccel implements IActivityAggregator {
    private final FloatFunction baseline = Moving.quantilePrecise(6, 0.5f);
    private final HighActivity.Detector highActivityDetector;

    public ActivityAggregatorAccel(SensorType sensorType) {
        this.highActivityDetector = sensorType == SensorType.SLEEPPHASER ? HighActivity.normalizedAmplitudeBased(0.9f) : HighActivity.normalizedAmplitudeBased(1.1f);
        Logger.logInfo("ActivityAggregatorAccel init: " + sensorType + ", 6");
    }

    @Override // com.urbandroid.sleep.sensor.aggregator.IActivityAggregator
    public IActivityAggregator.Result update(float f) {
        float fAbs = Math.abs(f - this.baseline.apply(f));
        HighActivity.Result resultUpdate = this.highActivityDetector.update(fAbs);
        return new IActivityAggregator.Result(f, fAbs, resultUpdate.isSomeActivity, resultUpdate.isHighActivity);
    }
}
