package com.urbandroid.sleep.sensor;

/* JADX INFO: loaded from: classes4.dex */
public interface IAccelManager {
    int getCountOfZeroValuesInRow();

    int getMaxBatchSize();

    int getMaxDelayedPoints();

    float[] resetChanges(boolean z);

    void resetZerosCount();

    void start();

    void start(int i);

    void stop();
}
