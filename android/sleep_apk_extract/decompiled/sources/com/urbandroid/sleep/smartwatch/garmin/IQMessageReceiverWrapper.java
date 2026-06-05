package com.urbandroid.sleep.smartwatch.garmin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.garmin.android.connectiq.IQDevice;
import com.urbandroid.common.logging.Logger;
import java.nio.BufferUnderflowException;

/* JADX INFO: loaded from: classes3.dex */
public class IQMessageReceiverWrapper extends BroadcastReceiver {
    private static String TAG = "IQMessageReceiverWrapper: ";
    private final BroadcastReceiver receiver;

    public IQMessageReceiverWrapper(BroadcastReceiver broadcastReceiver) {
        this.receiver = broadcastReceiver;
    }

    private static void replaceIQDeviceById(Intent intent, String str) {
        try {
            IQDevice iQDevice = (IQDevice) intent.getParcelableExtra(str);
            if (iQDevice != null) {
                intent.putExtra(str, iQDevice.getDeviceIdentifier());
            }
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.logDebug(TAG + "onReceive intent " + intent.getAction());
        if ("com.garmin.android.connectiq.SEND_MESSAGE_STATUS".equals(intent.getAction())) {
            replaceIQDeviceById(intent, "com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
        } else if ("com.garmin.android.connectiq.OPEN_APPLICATION".equals(intent.getAction())) {
            replaceIQDeviceById(intent, "com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_DEVICE");
        } else if ("com.garmin.android.connectiq.DEVICE_STATUS".equals(intent.getAction())) {
            replaceIQDeviceById(intent, "com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
        }
        try {
            this.receiver.onReceive(context, intent);
        } catch (IllegalArgumentException | BufferUnderflowException e) {
            Logger.logDebug(TAG, e);
        }
    }
}
