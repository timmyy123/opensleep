package com.urbandroid.sleep.smartwatch.polar;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.BaseWatchAccelManager;

/* JADX INFO: loaded from: classes5.dex */
public class PolarAccelManager extends BaseWatchAccelManager {
    public PolarAccelManager(Context context) {
        super(context);
        Logger.logInfo("Using PolarAccelManager");
    }

    @Override // com.urbandroid.sleep.smartwatch.BaseWatchAccelManager, com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return 1;
    }

    @Override // com.urbandroid.sleep.smartwatch.BaseWatchAccelManager, com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 120;
    }
}
