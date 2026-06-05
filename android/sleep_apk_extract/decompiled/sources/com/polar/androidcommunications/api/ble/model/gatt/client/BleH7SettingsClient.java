package com.polar.androidcommunications.api.ble.model.gatt.client;

import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public class BleH7SettingsClient extends BleGattBase {
    public static final UUID H7_SETTINGS_CHARACTERISTIC = UUID.fromString("6217FF4A-B07D-5DEB-261E-2586752D942E");
    public static final UUID H7_SETTINGS_SERVICE = UUID.fromString("6217FF49-AC7B-547E-EECF-016A06970BA9");
    private final LinkedBlockingDeque<byte[]> h7InputQueue;
    private final LinkedBlockingDeque<Integer> h7WrittenQueue;
    private final Object mutex;

    public BleH7SettingsClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, H7_SETTINGS_SERVICE);
        this.h7InputQueue = new LinkedBlockingDeque<>();
        this.h7WrittenQueue = new LinkedBlockingDeque<>();
        this.mutex = new Object();
        addCharacteristic(H7_SETTINGS_CHARACTERISTIC);
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        if (i == 0 && uuid.equals(H7_SETTINGS_CHARACTERISTIC)) {
            synchronized (this.h7InputQueue) {
                this.h7InputQueue.push(bArr);
                this.h7InputQueue.notifyAll();
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
        if (uuid.equals(H7_SETTINGS_CHARACTERISTIC)) {
            synchronized (this.h7WrittenQueue) {
                this.h7WrittenQueue.push(Integer.valueOf(i));
                this.h7WrittenQueue.notifyAll();
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        synchronized (this.h7InputQueue) {
            this.h7InputQueue.clear();
            this.h7InputQueue.notifyAll();
        }
        synchronized (this.h7WrittenQueue) {
            this.h7WrittenQueue.clear();
            this.h7WrittenQueue.notifyAll();
        }
    }

    public String toString() {
        return "Legacy H7 settings client";
    }
}
