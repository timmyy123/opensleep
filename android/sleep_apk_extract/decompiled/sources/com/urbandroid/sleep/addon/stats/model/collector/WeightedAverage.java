package com.urbandroid.sleep.addon.stats.model.collector;

/* JADX INFO: loaded from: classes4.dex */
public class WeightedAverage extends Average {
    @Override // com.urbandroid.sleep.addon.stats.model.collector.Average
    public void addValue(double d, double d2, int i) {
        if (d <= 0.0d) {
            return;
        }
        this.sum = (d * d2) + this.sum;
        if (Double.isNaN(this.lengthSum)) {
            this.lengthSum = 0.0d;
        }
        this.count += i;
        this.lengthSum += d2;
        this.days++;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.Average, com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public double getMeasure() {
        double d = this.sum;
        return d == 0.0d ? d : d / this.lengthSum;
    }
}
