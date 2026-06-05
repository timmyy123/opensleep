package com.urbandroid.sleep.smartwatch.pebble;

import android.content.Context;
import com.urbandroid.sleep.smartwatch.BaseWatchAccelManager;

/* JADX INFO: loaded from: classes5.dex */
public class PebbleAccelManager extends BaseWatchAccelManager {
    public PebbleAccelManager(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.smartwatch.BaseWatchAccelManager
    public float transformValue(float f) {
        return f <= 1.0f ? f / 1000.0f : (f * 9.806f) / 1000.0f;
    }
}
