package com.urbandroid.sleep.addon.stats.model.aggregator;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.Average;
import com.urbandroid.sleep.addon.stats.model.collector.IAggregator;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureAverageAggregator extends AbstractPeriodCollector implements IAggregatingCollector {
    private IAggregator aggregator;
    private long count;
    private IValueExtractor extractor;

    public MeasureAverageAggregator(Date date, Date date2, IValueExtractor iValueExtractor) {
        super(date, date2);
        this.aggregator = new Average();
        this.extractor = iValueExtractor;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public void addValue(double d) {
        this.aggregator.addValue(d);
        this.count++;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.aggregator.AbstractPeriodCollector
    public void doPut(IStatRecord iStatRecord) {
        addValue(this.extractor.getValue(iStatRecord));
    }

    public long getCount() {
        return this.count;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public double getMeasure() {
        return this.aggregator.getMeasure();
    }

    public MeasureAverageAggregator(IValueExtractor iValueExtractor) {
        this(null, null, iValueExtractor);
    }
}
