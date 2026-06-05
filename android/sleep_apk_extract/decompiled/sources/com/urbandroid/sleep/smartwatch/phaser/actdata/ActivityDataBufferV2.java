package com.urbandroid.sleep.smartwatch.phaser.actdata;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.util.ScienceUtil;
import com.urbandroid.util.StringBufferPersister;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public class ActivityDataBufferV2 implements ActivityDataBuffer {
    private BackfillBuffer backfillBuffer;
    private final Callable<ActigraphyResult> fetchAggregatedData;
    private int prevIndex;
    private final int rawHistorySize;
    private ArrayList<Float> rawData = new ArrayList<>();
    private ArrayList<Float> aggregatedData = new ArrayList<>();

    public static class BackfillBuffer {
        private final TreeMap<Integer, List<Float>> incomingValues;
        private final int lastKnownIndex;
        private final int nextBufferStart;

        public BackfillBuffer(int i, int i2) {
            this.lastKnownIndex = i;
            int i3 = (((i2 + 1) / 25) + 1) * 25;
            this.nextBufferStart = i3;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "ActivityDataBufferV2: BackfillBuffer: lastKnownIndex=", ", recentMissingIndex=", ", nextBufferStart=");
            sbM.append(i3);
            Logger.logInfo(sbM.toString());
            this.incomingValues = new TreeMap<>();
        }

        public List<Float> getValues() {
            ArrayList arrayList = new ArrayList();
            Iterator<List<Float>> it = this.incomingValues.values().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
            return arrayList.size() > 52 ? new ArrayList(arrayList.subList(arrayList.size() - 52, arrayList.size())) : arrayList;
        }

        public void merge(ActigraphyResult actigraphyResult) {
            for (int i = 0; i < 25; i++) {
                int iMax = (Math.max(0, actigraphyResult.index - 1) * 25) + i + 1;
                float[] fArr = actigraphyResult.values;
                int i2 = i * 2;
                float f = fArr[i2];
                float f2 = fArr[i2 + 1];
                if (iMax > this.lastKnownIndex && (f > 0.0f || f2 > 0.0f)) {
                    put(iMax, Arrays.asList(Float.valueOf(f), Float.valueOf(f2)));
                }
            }
        }

        public void put(int i, List<Float> list) {
            ActivityDataBufferV2.logMinor("ActivityDataBufferV2: BackfillBuffer.put(" + i + ", " + list + ")");
            if (list.size() == 2) {
                this.incomingValues.put(Integer.valueOf(i), list);
            } else {
                Gson$$ExternalSyntheticBUOutline0.m("", list);
            }
        }
    }

    public ActivityDataBufferV2(int i, Callable<ActigraphyResult> callable) {
        this.rawHistorySize = i;
        this.fetchAggregatedData = callable;
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logMinor(String str) {
        Logger.logInfo(str);
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
        return 52;
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
            int i4 = this.prevIndex;
            if (i4 == -1 || i4 == i3) {
                ActivityDataUtilKt.persist(stringBufferPersister, actigraphyResult);
                this.rawData.addAll(ScienceUtil.convertArrayToList(actigraphyResult.values));
                if (this.rawData.size() > this.rawHistorySize) {
                    ArrayList<Float> arrayList = this.rawData;
                    this.rawData = new ArrayList<>(arrayList.subList(arrayList.size() - this.rawHistorySize, this.rawData.size()));
                }
                BackfillBuffer backfillBuffer = this.backfillBuffer;
                if (backfillBuffer == null) {
                    this.aggregatedData.addAll(listAggregate);
                } else {
                    backfillBuffer.put(actigraphyResult.index, listAggregate);
                }
                this.prevIndex = actigraphyResult.index;
            } else {
                Logger.logInfo("ActivityDataBufferV2: Gap detected: " + this.prevIndex + " " + actigraphyResult.index);
                this.rawData.clear();
                this.rawData.addAll(ScienceUtil.convertArrayToList(actigraphyResult.values));
                if (actigraphyResult.index < this.prevIndex) {
                    this.prevIndex = -1;
                    this.backfillBuffer = null;
                }
                if (this.backfillBuffer == null) {
                    try {
                        ActigraphyResult actigraphyResultCall = this.fetchAggregatedData.call();
                        for (int i5 = 0; i5 < 25; i5++) {
                            int iMax = (Math.max(0, actigraphyResultCall.index - 1) * 25) + i5 + 1;
                            float[] fArr = actigraphyResultCall.values;
                            int i6 = i5 * 2;
                            float f = fArr[i6];
                            float f2 = fArr[i6 + 1];
                            if (iMax > this.prevIndex && iMax <= actigraphyResult.index && (f > 0.0f || f2 > 0.0f)) {
                                logMinor("ActivityDataBufferV2: adding directly to aggregated data: " + iMax + ", " + f + ", " + f2);
                                this.aggregatedData.add(Float.valueOf(f));
                                this.aggregatedData.add(Float.valueOf(f2));
                                this.prevIndex = iMax;
                            }
                        }
                    } catch (Exception e) {
                        Logger.logInfo("ActivityDataBufferV2", e);
                    }
                    if (this.prevIndex == i3) {
                        logMinor("ActivityDataBufferV2: adding directly to aggregated data: " + i3 + ", " + listAggregate);
                        this.aggregatedData.addAll(listAggregate);
                    }
                    int i7 = this.prevIndex;
                    if (i7 < i3) {
                        BackfillBuffer backfillBuffer2 = new BackfillBuffer(i7, i3);
                        this.backfillBuffer = backfillBuffer2;
                        backfillBuffer2.put(actigraphyResult.index, listAggregate);
                    }
                }
                this.prevIndex = actigraphyResult.index;
                z = false;
            }
            BackfillBuffer backfillBuffer3 = this.backfillBuffer;
            if (backfillBuffer3 != null && backfillBuffer3.nextBufferStart <= actigraphyResult.index) {
                try {
                    this.backfillBuffer.merge(this.fetchAggregatedData.call());
                } catch (Exception e2) {
                    Logger.logInfo("ActivityDataBufferV2", e2);
                }
                List<Float> values = this.backfillBuffer.getValues();
                Logger.logInfo("ActivityDataBufferV2: Backfill buffer merged: " + values);
                this.aggregatedData.addAll(values);
                this.backfillBuffer = null;
            }
            return z;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void reset() {
        this.rawData.clear();
        this.aggregatedData.clear();
        this.backfillBuffer = null;
        this.prevIndex = -1;
    }
}
