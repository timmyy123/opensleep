package com.urbandroid.sleep.addon.stats.model.aggregator;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.ICollector;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPeriodCollector implements ICollector {
    private Date from;
    private Date to;

    public AbstractPeriodCollector(Date date, Date date2) {
        this.from = date;
        this.to = date2;
    }

    public boolean accept(IStatRecord iStatRecord) {
        if (this.from == null) {
            return true;
        }
        return this.to == null ? iStatRecord.getToDate().after(this.from) : iStatRecord.getToDate().after(this.from) && iStatRecord.getToDate().before(this.to);
    }

    public abstract void doPut(IStatRecord iStatRecord);

    public Date getFrom() {
        return this.from;
    }

    public Date getTo() {
        return this.to;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.ICollector
    public void put(IStatRecord iStatRecord) {
        if (accept(iStatRecord)) {
            doPut(iStatRecord);
        }
    }
}
