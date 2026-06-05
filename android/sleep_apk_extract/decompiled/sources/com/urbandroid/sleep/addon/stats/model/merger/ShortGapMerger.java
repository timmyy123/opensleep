package com.urbandroid.sleep.addon.stats.model.merger;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ShortGapMerger extends AbstractMerger {
    private boolean isShortGap(StatRecord statRecord, StatRecord statRecord2) {
        return statRecord.getToDate().before(statRecord2.getFromDate()) ? DateUtil.dateDifferenceMin(statRecord.getToDate(), statRecord2.getFromDate()) < 30 : statRecord2.getToDate().before(statRecord.getFromDate()) && DateUtil.dateDifferenceMin(statRecord2.getToDate(), statRecord.getFromDate()) < 30;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.merger.AbstractMerger
    public StatRecord merge(StatRecord statRecord, StatRecord statRecord2) {
        if (!isShortGap(statRecord, statRecord2)) {
            return null;
        }
        StatRecord statRecord3 = new StatRecord();
        if (statRecord.getFromDate().before(statRecord2.getFromDate())) {
            statRecord3.setFromDate(statRecord.getFromDate());
            statRecord3.setToDate(statRecord2.getToDate());
            if (statRecord2.getSmart() > 0) {
                statRecord3.setSmart(statRecord2.getSmart());
            }
            statRecord3.setFromHour(statRecord.getFromHour());
            statRecord3.setToHour(statRecord2.getToHour());
            statRecord3.setTimeZone(statRecord.getTimeZone());
        } else {
            statRecord3.setFromDate(statRecord2.getFromDate());
            statRecord3.setToDate(statRecord.getToDate());
            statRecord3.setTimeZone(statRecord2.getTimeZone());
            if (statRecord.getSmart() > 0) {
                statRecord3.setSmart(statRecord.getSmart());
            }
            statRecord3.setFromHour(statRecord2.getFromHour());
            statRecord3.setToHour(statRecord.getToHour());
        }
        mergeCommons(statRecord, statRecord2, statRecord3);
        return statRecord3;
    }
}
