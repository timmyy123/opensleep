package com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering;

import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecord;
import org.apache.commons.math3.ml.clustering.Clusterable;

/* JADX INFO: loaded from: classes4.dex */
public class ChronoRecordClusterable implements Clusterable {
    private final double[] point;
    private final ChronoRecord record;

    public ChronoRecordClusterable(ChronoRecord chronoRecord) {
        this.record = chronoRecord;
        this.point = new double[]{chronoRecord.getToHour(), chronoRecord.getLength()};
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterable
    public double[] getPoint() {
        return this.point;
    }

    public ChronoRecord getRecord() {
        return this.record;
    }
}
