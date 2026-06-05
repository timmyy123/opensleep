package com.urbandroid.sleep.addon.stats.model.merger;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class SameDateMerger extends AbstractMerger {
    private void copyTimes(StatRecord statRecord, StatRecord statRecord2) {
        statRecord2.setFromDate(statRecord.getFromDate());
        statRecord2.setToDate(statRecord.getToDate());
        statRecord2.setTimeZone(statRecord.getTimeZone());
        statRecord2.setFromHour(statRecord.getFromHour());
        statRecord2.setToHour(statRecord.getToHour());
    }

    @Override // com.urbandroid.sleep.addon.stats.model.merger.AbstractMerger
    public StatRecord merge(StatRecord statRecord, StatRecord statRecord2) {
        if (!DateUtil.isSameDate(statRecord.getToDate(), statRecord.getTimeZone(), statRecord2.getToDate(), statRecord2.getTimeZone(), SharedApplicationContext.getSettings().getDayCutOffHour())) {
            return null;
        }
        StatRecord statRecord3 = new StatRecord();
        if (statRecord.getLengthInHours() > statRecord2.getLengthInHours()) {
            copyTimes(statRecord, statRecord3);
            statRecord3.setSmart(Math.max(statRecord.getSmart(), 0));
        } else {
            copyTimes(statRecord2, statRecord3);
            statRecord3.setSmart(Math.max(statRecord2.getSmart(), 0));
        }
        mergeCommons(statRecord, statRecord2, statRecord3);
        return statRecord3;
    }
}
