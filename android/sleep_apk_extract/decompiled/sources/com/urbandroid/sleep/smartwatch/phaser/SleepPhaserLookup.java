package com.urbandroid.sleep.smartwatch.phaser;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.bluetoothle.DeviceLookup;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepPhaserLookup {
    public static BluetoothDevice find(Context context, long j) {
        return DeviceLookup.find(context, new DeviceLookup.Predicate() { // from class: com.urbandroid.sleep.smartwatch.phaser.SleepPhaserLookup.1
            @Override // com.urbandroid.sleep.bluetoothle.DeviceLookup.Predicate
            public boolean test(BluetoothDevice bluetoothDevice) {
                String name = bluetoothDevice.getName();
                if (name != null) {
                    name = name.replaceAll("(\\r|\\n)", "");
                }
                Logger.logInfo("SleepPhaserLookup: testing: '" + bluetoothDevice.getAddress() + "' '" + name + "'");
                if (name == null) {
                    return false;
                }
                if (!name.equals("HC-08") && !name.trim().matches("SP\\d+")) {
                    return false;
                }
                Logger.logInfo("SleepPhaserLookup: The device looks like a SleepPhaser.");
                return true;
            }
        }, j);
    }
}
