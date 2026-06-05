package com.urbandroid.sleep.smartwatch;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.IAccelManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BaseWatchAccelManager implements IAccelManager {
    private int countOfZeroValuesInRow = 0;
    private List<Float> accumulatedChanges = new LinkedList();

    public BaseWatchAccelManager(Context context) {
        Logger.logInfo("Using watch accel: ".concat(getClass().getSimpleName()));
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getCountOfZeroValuesInRow() {
        return this.countOfZeroValuesInRow;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return 12;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 1;
    }

    public void pushNewData(float f) {
        if (f == 0.0f) {
            this.countOfZeroValuesInRow++;
        } else {
            this.countOfZeroValuesInRow = 0;
        }
        this.accumulatedChanges.add(Float.valueOf(transformValue(f)));
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public float[] resetChanges(boolean z) {
        float[] fArr = new float[this.accumulatedChanges.size()];
        Iterator<Float> it = this.accumulatedChanges.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = it.next().floatValue();
            i++;
        }
        this.accumulatedChanges.clear();
        return fArr;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void resetZerosCount() {
        this.countOfZeroValuesInRow = 0;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start() {
        start(3);
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void stop() {
    }

    public float transformValue(float f) {
        return f;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start(int i) {
    }
}
