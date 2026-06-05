package com.urbandroid.sleep.addon.stats.model.collector;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;

/* JADX INFO: loaded from: classes4.dex */
public class DurationCollector extends AbstractStatCollector {
    public DurationCollector(IValueExtractor iValueExtractor, String str) {
        super(iValueExtractor, str);
        getIntervals().add(new Interval(0.0d, 2.0d));
        getIntervals().add(new Interval(2.0d, 4.0d));
        getIntervals().add(new Interval(4.0d, 6.0d));
        getIntervals().add(new Interval(6.0d, 8.0d));
        getIntervals().add(new Interval(8.0d, 10.0d));
        getIntervals().add(new Interval(10.0d, 12.0d));
        getIntervals().add(new Interval(12.0d, 14.0d));
        getIntervals().add(new Interval(14.0d, 16.0d));
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.AbstractStatCollector
    public double getRecordValue(IStatRecord iStatRecord) {
        return iStatRecord.getLengthInHours();
    }
}
