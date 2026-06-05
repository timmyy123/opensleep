package com.urbandroid.sleep.smartwatch.phaser;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepPhaserProvider {
    private static SleepPhaser sleepPhaser;

    public static synchronized void discardSleepPhaser() {
        SleepPhaser sleepPhaser2 = sleepPhaser;
        if (sleepPhaser2 != null) {
            sleepPhaser2.shutdown();
            sleepPhaser = null;
        }
    }

    public static synchronized SleepPhaser getSleepPhaser(Context context) {
        try {
            if (sleepPhaser == null) {
                String sleepPhaserAddress = new Settings(context).getSleepPhaserAddress();
                Logger.logInfo("SleepPhaser: GET address " + sleepPhaserAddress);
                if (sleepPhaserAddress != null) {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    Logger.logInfo("SleepPhaser: GET adapter " + defaultAdapter);
                    if (defaultAdapter != null) {
                        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(sleepPhaserAddress);
                        Logger.logInfo("SleepPhaser: GET device " + remoteDevice);
                        if (remoteDevice != null) {
                            sleepPhaser = new SleepPhaser(context, remoteDevice);
                        }
                    }
                } else {
                    String sleepMaskBtAddress = new Settings(context).getSleepMaskBtAddress();
                    Logger.logInfo("SleepMaskBt: GET address " + sleepMaskBtAddress);
                    if (sleepMaskBtAddress != null) {
                        BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
                        Logger.logInfo("SleepMaskBt: GET adapter " + defaultAdapter2);
                        if (defaultAdapter2 != null) {
                            BluetoothDevice remoteDevice2 = defaultAdapter2.getRemoteDevice(sleepMaskBtAddress);
                            Logger.logInfo("SleepMaskBt: GET device " + remoteDevice2);
                            if (remoteDevice2 != null) {
                                sleepPhaser = new SleepPhaser(context, remoteDevice2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return sleepPhaser;
    }
}
