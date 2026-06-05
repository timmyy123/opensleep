package com.urbandroid.sleep.addon.stats.model.collector;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;

/* JADX INFO: loaded from: classes4.dex */
public class BeforeMidnightCollector extends AbstractStatCollector {
    public BeforeMidnightCollector(IValueExtractor iValueExtractor, String str) {
        super(iValueExtractor, str);
        getIntervals().add(new Interval(16.0d, 18.0d));
        getIntervals().add(new Interval(18.0d, 20.0d));
        getIntervals().add(new Interval(20.0d, 22.0d));
        getIntervals().add(new Interval(22.0d, 24.0d));
        getIntervals().add(new Interval(0.0d, 2.0d));
        getIntervals().add(new Interval(2.0d, 4.0d));
        getIntervals().add(new Interval(4.0d, 6.0d));
        getIntervals().add(new Interval(6.0d, 8.0d));
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.AbstractStatCollector
    public double getRecordValue(IStatRecord iStatRecord) {
        return (float) iStatRecord.getFromHour();
    }
}
