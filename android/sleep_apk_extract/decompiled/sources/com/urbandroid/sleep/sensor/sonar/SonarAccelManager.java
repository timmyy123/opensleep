package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import com.urbandroid.sleep.sensor.IAccelManager;

/* JADX INFO: loaded from: classes4.dex */
public class SonarAccelManager implements IAccelManager {
    private SonarConsumer sonarConsumer;

    public SonarAccelManager(Context context, SonarConsumer sonarConsumer) {
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
        return new float[]{this.sonarConsumer.resetLastActivity()};
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
