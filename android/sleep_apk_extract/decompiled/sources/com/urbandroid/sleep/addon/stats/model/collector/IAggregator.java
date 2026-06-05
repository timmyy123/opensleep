package com.urbandroid.sleep.addon.stats.model.collector;

/* JADX INFO: loaded from: classes4.dex */
public interface IAggregator {
    void addValue(double d);

    double getMeasure();
}
