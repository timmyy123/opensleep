package com.urbandroid.sleep.sensor.sonar;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.sensor.sonar.ILowLevelActivityAggregator;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;

/* JADX INFO: loaded from: classes4.dex */
public class LowLevelActivityAggregator implements ILowLevelActivityAggregator {
    private final FloatFunction aggregation;
    private final FloatFunction almostMax;
    private final FloatFunction baseline;
    private final FloatFunction deviation;
    private volatile float aggregatedActivity = 0.0f;
    private volatile long lastUpdate = 0;

    public LowLevelActivityAggregator(int i) {
        float f = i / 8192.0f;
        int iMax = (int) Math.max(300.0f, 60.0f * f);
        this.almostMax = Moving.quantileScalable(iMax, 0.995f);
        float f2 = 10.0f * f;
        int iMax2 = (int) Math.max(6.0f, f2);
        this.baseline = Moving.quantilePrecise(iMax2, 0.5f);
        int iMax3 = (int) Math.max(30.0f, f * 30.0f);
        this.deviation = Moving.quantileScalable(iMax3, 0.5f);
        int i2 = (int) f2;
        this.aggregation = Moving.max(i2);
        StringBuilder sb = new StringBuilder("LowLevelActivityAggregator init: ");
        sb.append(f);
        sb.append(", ");
        sb.append(iMax);
        sb.append(", ");
        Fragment$$ExternalSyntheticOutline1.m(sb, iMax2, ", ", iMax3, ", ");
        zza$$ExternalSyntheticOutline0.m(sb, i2);
    }

    @Override // com.urbandroid.sleep.sensor.sonar.ILowLevelActivityAggregator
    public float getAggregatedActivity() {
        if (System.currentTimeMillis() - this.lastUpdate > 10000) {
            return 0.0f;
        }
        return this.aggregatedActivity;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.ILowLevelActivityAggregator
    public ILowLevelActivityAggregator.Result update(float f) {
        this.lastUpdate = System.currentTimeMillis();
        float fMin = Math.min(this.almostMax.apply(f), f);
        float fAbs = Math.abs(fMin - this.baseline.apply(fMin));
        float fApply = this.deviation.apply(fAbs);
        float f2 = fApply == 0.0f ? 1.0f : fAbs / fApply;
        this.aggregatedActivity = this.aggregation.apply(f2);
        return new ILowLevelActivityAggregator.Result(f2, f2 > 24.0f);
    }
}
