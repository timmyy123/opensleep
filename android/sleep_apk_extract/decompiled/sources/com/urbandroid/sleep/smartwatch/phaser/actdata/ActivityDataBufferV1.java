package com.urbandroid.sleep.smartwatch.phaser.actdata;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.util.ScienceUtil;
import com.urbandroid.util.StringBufferPersister;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ActivityDataBufferV1 implements ActivityDataBuffer {
    private int prevIndex;
    private final int rawHistorySize;
    private ArrayList<Float> rawData = new ArrayList<>();
    private ArrayList<Float> aggregatedData = new ArrayList<>();

    public ActivityDataBufferV1(int i) {
        this.rawHistorySize = i;
        reset();
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public synchronized float[] getAndResetAggregatedData() {
        float[] floatArray;
        floatArray = ScienceUtil.toFloatArray(this.aggregatedData);
        this.aggregatedData.clear();
        return floatArray;
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public int getMaxBackfillSize() {
        return 1;
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public synchronized float[] getRawData() {
        return ScienceUtil.toFloatArray(this.rawData);
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public synchronized boolean process(ActigraphyResult actigraphyResult, StringBufferPersister stringBufferPersister) {
        try {
            int i = this.prevIndex;
            int i2 = actigraphyResult.index;
            boolean z = true;
            if (i == i2) {
                return true;
            }
            int i3 = i2 - 1;
            List<Float> listAggregate = ActivityDataUtilKt.aggregate(actigraphyResult);
            ActivityDataUtilKt.persist(stringBufferPersister, actigraphyResult);
            this.rawData.addAll(ScienceUtil.convertArrayToList(actigraphyResult.values));
            if (this.rawData.size() > this.rawHistorySize) {
                ArrayList<Float> arrayList = this.rawData;
                this.rawData = new ArrayList<>(arrayList.subList(arrayList.size() - this.rawHistorySize, this.rawData.size()));
            }
            this.aggregatedData.addAll(listAggregate);
            int i4 = this.prevIndex;
            if (i4 != -1 && i4 != i3) {
                Logger.logInfo("ActivityDataBufferV1: Gap detected: " + this.prevIndex + " " + actigraphyResult.index);
                this.rawData.clear();
                this.rawData.addAll(ScienceUtil.convertArrayToList(actigraphyResult.values));
                z = false;
            }
            this.prevIndex = actigraphyResult.index;
            return z;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void reset() {
        this.rawData.clear();
        this.aggregatedData.clear();
        this.prevIndex = -1;
    }
}
