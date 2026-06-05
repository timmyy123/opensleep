package com.urbandroid.sleep.sensor.sonar;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.IAccelManager;

/* JADX INFO: loaded from: classes4.dex */
public class SonarTestAccelManager implements IAccelManager {
    private SonarConsumer sonarConsumer;

    public SonarTestAccelManager(SonarConsumer sonarConsumer) {
        this.sonarConsumer = sonarConsumer;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getCountOfZeroValuesInRow() {
        return 0;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return 1;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 0;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public float[] resetChanges(boolean z) {
        float fResetLastMax = this.sonarConsumer.resetLastMax();
        Logger.logInfo("Sonar: " + fResetLastMax);
        return new float[]{fResetLastMax};
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void resetZerosCount() {
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start(int i) {
        start();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void stop() {
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start() {
    }
}
