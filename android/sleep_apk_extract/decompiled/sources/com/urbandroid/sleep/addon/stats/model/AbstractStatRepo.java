package com.urbandroid.sleep.addon.stats.model;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.addon.stats.filter.IFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractStatRepo implements IStatRepo {
    private List<StatRecord> mergedStatRecords = new ArrayList();
    private List<StatRecord> rawStatRecords = new ArrayList();

    private synchronized List<StatRecord> getMergedStatRecords(Date date, Date date2, int i, IFilter iFilter) {
        try {
            ArrayList arrayList = new ArrayList(this.mergedStatRecords);
            int size = arrayList.size();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                StatRecord statRecord = (StatRecord) it.next();
                if (statRecord.getFromDate() != null && statRecord.getToDate() != null && (!statRecord.getToDate().after(date) || !statRecord.getToDate().before(date2) || !iFilter.filter(statRecord))) {
                    if (size <= i) {
                        return arrayList;
                    }
                    it.remove();
                    size--;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<StatRecord> getRawStatRecords() {
        return this.rawStatRecords;
    }

    public void updateMergedStatRecords(List<StatRecord> list) {
        Logger.logInfo("Merged records " + list.size());
        this.mergedStatRecords.clear();
        this.mergedStatRecords.addAll(list);
    }

    public void updateRawStatRecords(List<StatRecord> list) {
        this.rawStatRecords.clear();
        this.rawStatRecords.addAll(list);
    }

    public List<StatRecord> getMergedStatRecords() {
        return this.mergedStatRecords;
    }

    public synchronized List<StatRecord> getMergedStatRecords(Date date, Date date2, IFilter iFilter) {
        return getMergedStatRecords(date, date2, 0, iFilter);
    }
}
