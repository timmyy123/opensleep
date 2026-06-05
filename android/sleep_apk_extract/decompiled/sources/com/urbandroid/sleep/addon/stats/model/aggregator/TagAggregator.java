package com.urbandroid.sleep.addon.stats.model.aggregator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.ICollector;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class TagAggregator extends AbstractPeriodCollector implements ICollector {
    private int count;
    private Map<String, Integer> tagMap;

    public TagAggregator(Date date, Date date2) {
        super(date, date2);
        this.tagMap = new HashMap();
        this.count = 0;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.aggregator.AbstractPeriodCollector
    public void doPut(IStatRecord iStatRecord) {
        this.count++;
        for (String str : iStatRecord.getTags()) {
            Integer num = this.tagMap.get(str);
            if (num == null) {
                num = 0;
            }
            this.tagMap.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public float getRelativeOccurrence(String str) {
        if (this.tagMap.get(str) == null) {
            return 0.0f;
        }
        return r2.intValue() / this.count;
    }

    public Set<String> getTags() {
        return this.tagMap.keySet();
    }

    public float getTotalOccurrence(String str) {
        if (this.tagMap.get(str) == null) {
            return 0.0f;
        }
        return r0.intValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.tagMap.keySet()) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("tag \t ", str, " = ");
            sbM5m.append(this.tagMap.get(str));
            sbM5m.append("x\n");
            sb.append(sbM5m.toString());
        }
        return sb.toString();
    }
}
