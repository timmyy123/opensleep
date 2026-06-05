package com.urbandroid.sleep.smartwatch.wear;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.BaseWatchAccelManager;

/* JADX INFO: loaded from: classes5.dex */
public class WearAccelManager extends BaseWatchAccelManager {
    public WearAccelManager(Context context) {
        super(context);
        Logger.logInfo("Using WearAccelManager");
    }

    @Override // com.urbandroid.sleep.smartwatch.BaseWatchAccelManager, com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return 14;
    }

    @Override // com.urbandroid.sleep.smartwatch.BaseWatchAccelManager, com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 120;
    }
}
