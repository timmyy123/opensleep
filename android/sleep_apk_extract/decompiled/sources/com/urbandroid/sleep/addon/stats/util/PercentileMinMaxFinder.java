package com.urbandroid.sleep.addon.stats.util;

import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PercentileMinMaxFinder extends MinMaxFinder {
    private List<Double> values = new ArrayList();

    @Override // com.urbandroid.sleep.addon.stats.util.MinMaxFinder
    public void addValue(double d) {
        this.values.add(Double.valueOf(d));
    }

    @Override // com.urbandroid.sleep.addon.stats.util.MinMaxFinder
    public double getMaxValue() {
        return ScienceUtil.percentile((Double[]) this.values.toArray(new Double[0]), 98.0f) * 1.05d;
    }

    @Override // com.urbandroid.sleep.addon.stats.util.MinMaxFinder
    public double getMinValue() {
        return ScienceUtil.percentile((Double[]) this.values.toArray(new Double[0]), 2.0f) * 0.95d;
    }
}
