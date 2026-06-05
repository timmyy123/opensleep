package com.urbandroid.sleep.addon.stats.model.collector;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractStatCollector implements IStatCollector {
    private Collection<Interval> intervals = new ArrayList();
    private IValueExtractor measureExtractor;
    private String title;

    public AbstractStatCollector(IValueExtractor iValueExtractor, String str) {
        this.title = str;
        this.measureExtractor = iValueExtractor;
    }

    public Collection<Interval> getIntervals() {
        return this.intervals;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<String> getLabels() {
        ArrayList arrayList = new ArrayList();
        Iterator<Interval> it = this.intervals.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getRepresentation());
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getMeasureTitle() {
        return this.measureExtractor.getMeasureName();
    }

    public double getRecordMeasure(IStatRecord iStatRecord) {
        return this.measureExtractor.getValue(iStatRecord);
    }

    public abstract double getRecordValue(IStatRecord iStatRecord);

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getTitle() {
        return this.title;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<Double> getValues() {
        ArrayList arrayList = new ArrayList();
        Iterator<Interval> it = this.intervals.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(it.next().getMeasure()));
        }
        return arrayList;
    }

    public void put(double d, double d2) {
        Iterator<Interval> it = this.intervals.iterator();
        while (it.hasNext() && !it.next().put(d, d2)) {
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.ICollector
    public void put(IStatRecord iStatRecord) {
        if (getRecordMeasure(iStatRecord) > 0.0d) {
            put(getRecordValue(iStatRecord), getRecordMeasure(iStatRecord));
        }
    }
}
