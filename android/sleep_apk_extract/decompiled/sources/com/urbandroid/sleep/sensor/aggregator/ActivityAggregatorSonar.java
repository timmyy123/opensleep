package com.urbandroid.sleep.sensor.aggregator;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.aggregator.HighActivity;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityAggregatorSonar implements IActivityAggregator {
    private final HighActivity.Detector highActivityDetector = HighActivity.normalizedAmplitudeBased(1.0f);

    public ActivityAggregatorSonar() {
        Logger.logInfo("ActivityAggregatorSonar init");
    }

    @Override // com.urbandroid.sleep.sensor.aggregator.IActivityAggregator
    public IActivityAggregator.Result update(float f) {
        HighActivity.Result resultUpdate = this.highActivityDetector.update(f);
        return new IActivityAggregator.Result(f, f, resultUpdate.isSomeActivity, resultUpdate.isHighActivity);
    }
}
