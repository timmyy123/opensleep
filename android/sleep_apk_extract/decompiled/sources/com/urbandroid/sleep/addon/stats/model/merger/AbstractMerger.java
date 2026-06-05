package com.urbandroid.sleep.addon.stats.model.merger;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMerger {
    public abstract StatRecord merge(StatRecord statRecord, StatRecord statRecord2);

    public List<StatRecord> merge(List<StatRecord> list) {
        LinkedList linkedList = new LinkedList();
        StatRecord statRecord = null;
        for (StatRecord statRecord2 : list) {
            if (statRecord != null) {
                StatRecord statRecordMerge = merge(statRecord, statRecord2);
                if (statRecordMerge == null) {
                    linkedList.add(statRecord);
                } else {
                    statRecord = statRecordMerge;
                }
            }
            statRecord = statRecord2;
        }
        if (statRecord != null) {
            linkedList.add(statRecord);
        }
        return linkedList;
    }

    public void mergeCommons(StatRecord statRecord, StatRecord statRecord2, StatRecord statRecord3) {
        statRecord3.setRating((float) weightedAverage(statRecord.getRating(), statRecord.getLengthInHours(), statRecord2.getRating(), statRecord2.getLengthInHours()));
        statRecord3.setHr((float) weightedAverage(statRecord.getHr(), statRecord.getLengthInHours(), statRecord2.getHr(), statRecord2.getLengthInHours()));
        statRecord3.setMinHr((float) weightedAverage(statRecord.getMinHr(), statRecord.getLengthInHours(), statRecord2.getMinHr(), statRecord2.getLengthInHours()));
        statRecord3.setLengthInHours(statRecord2.getLengthInHours() + statRecord.getLengthInHours());
        statRecord3.setTrackLengthInHours(statRecord2.getTrackLengthInHours() + statRecord.getTrackLengthInHours());
        if (statRecord.getSnooze() >= 0 || statRecord2.getSnooze() >= 0) {
            statRecord3.setSnooze(Math.max(0, statRecord2.getSnooze()) + Math.max(0, statRecord.getSnooze()));
        } else {
            statRecord3.setSnooze(-1);
        }
        statRecord3.setQuality((float) weightedAverage(statRecord.getQuality(), statRecord.getLengthInHours(), statRecord2.getQuality(), statRecord2.getLengthInHours()));
        statRecord3.setRdi(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getRdi() : statRecord2.getRdi());
        statRecord3.setHrvBefore(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getHrvBefore() : statRecord2.getHrvBefore());
        statRecord3.setHrvAfter(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getHrvAfter() : statRecord2.getHrvAfter());
        statRecord3.setHrvGain(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getHrvGain() : statRecord2.getHrvGain());
        statRecord3.setHrv(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getHrv() : statRecord2.getHrv());
        statRecord3.setFallAsleepHour(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getFallAsleepHour() : statRecord2.getFallAsleepHour());
        statRecord3.setFallAsleep(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getFallAsleep() : statRecord2.getFallAsleep());
        statRecord3.setWakeUpHour(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getWakeUpHour() : statRecord2.getWakeUpHour());
        statRecord3.setWakeUp(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getWakeUp() : statRecord2.getWakeUp());
        if (statRecord.getSnore() >= 0 || statRecord2.getSnore() >= 0) {
            statRecord3.setSnore(Math.max(0, statRecord2.getSnore()) + Math.max(0, statRecord.getSnore()));
        } else {
            statRecord3.setSnore(-1);
        }
        statRecord3.setCount(statRecord2.getCount() + statRecord.getCount());
        statRecord3.getTags().addAll(statRecord.getTags());
        statRecord3.getTags().addAll(statRecord2.getTags());
        statRecord3.setCycles(statRecord2.getCycles() + statRecord.getCycles());
        statRecord3.setNoiseLevel((float) weightedAverage(statRecord.getNoiseLevel(), statRecord.getLengthInHours(), statRecord2.getNoiseLevel(), statRecord2.getLengthInHours()));
        statRecord3.setIrregularity(statRecord.getLengthInHours() > statRecord2.getLengthInHours() ? statRecord.getIrregularityInMinutes() : statRecord2.getIrregularityInMinutes());
    }

    public double weightedAverage(double d, double d2, double d3, double d4) {
        if (d <= 0.0d && d3 > 0.0d) {
            return d3;
        }
        if (d3 <= 0.0d && d > 0.0d) {
            return d;
        }
        return (Math.max(0.0d, d3 * d4) + Math.max(0.0d, d * d2)) / Math.max(9.999999747378752E-5d, d2 + d4);
    }
}
