package com.urbandroid.sleep.addon.stats.model.aggregator;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class SleepIrregularityMeasureAggregator extends AbstractPeriodCollector implements IAggregatingCollector {
    private final Context context;
    private SocialJetlagStats jetLagStats;
    private Collection<StatRecord> records;

    public SleepIrregularityMeasureAggregator(Date date, Date date2, Context context) {
        super(date, date2);
        this.records = new ArrayList();
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public void addValue(double d) {
        throw new IllegalArgumentException("Not supported!");
    }

    @Override // com.urbandroid.sleep.addon.stats.model.aggregator.AbstractPeriodCollector
    public void doPut(IStatRecord iStatRecord) {
        this.records.add((StatRecord) iStatRecord);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public double getMeasure() {
        if (this.jetLagStats == null) {
            this.jetLagStats = SocialJetlagStats.create(this.records, this.context);
            if (getFrom() != null && getTo() != null) {
                this.jetLagStats.narrow(getFrom(), getTo());
            }
        }
        return this.jetLagStats.getSleepIrregularity() * 60.0f;
    }
}
