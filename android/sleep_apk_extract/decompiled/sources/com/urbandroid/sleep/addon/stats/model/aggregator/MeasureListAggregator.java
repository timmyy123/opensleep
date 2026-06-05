package com.urbandroid.sleep.addon.stats.model.aggregator;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureListAggregator implements IListAggregator {
    private IAggregatingCollector aggregator;

    public MeasureListAggregator(IAggregatingCollector iAggregatingCollector) {
        this.aggregator = iAggregatingCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.aggregator.IListAggregator
    public double aggregate(List<StatRecord> list) {
        Iterator<StatRecord> it = list.iterator();
        while (it.hasNext()) {
            this.aggregator.put(it.next());
        }
        return this.aggregator.getMeasure();
    }
}
