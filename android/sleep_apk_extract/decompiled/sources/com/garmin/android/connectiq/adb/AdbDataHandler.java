package com.garmin.android.connectiq.adb;

import android.content.Context;
import android.content.Intent;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdbDataHandler {
    public static void handleMessage(Context context, byte[] bArr) {
        Intent intent = new Intent("com.garmin.android.connectiq.INCOMING_MESSAGE");
        intent.putExtra("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE", new IQDevice(12345L, "Simulator"));
        intent.putExtra("com.garmin.android.connectiq.EXTRA_REMOTE_APPLICATION", new IQApp("", "Simulator App", 1));
        intent.putExtra("com.garmin.android.connectiq.EXTRA_PAYLOAD", bArr);
        context.sendBroadcast(intent);
    }
}
