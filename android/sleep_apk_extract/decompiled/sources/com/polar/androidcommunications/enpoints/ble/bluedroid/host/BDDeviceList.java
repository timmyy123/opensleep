package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.common.ble.AtomicSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class BDDeviceList {
    private static final String TAG = "BDDeviceList";
    private final AtomicSet<BDDeviceSessionImpl> sessions = new AtomicSet<>();

    public interface CompareFunction {
        boolean compare(BDDeviceSessionImpl bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSession$0(BluetoothDevice bluetoothDevice, BDDeviceSessionImpl bDDeviceSessionImpl) {
        return bDDeviceSessionImpl.getBluetoothDevice().getAddress().equals(bluetoothDevice.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSession$1(BluetoothGatt bluetoothGatt, BDDeviceSessionImpl bDDeviceSessionImpl) {
        boolean z;
        synchronized (bDDeviceSessionImpl.getGattMutex()) {
            try {
                z = bDDeviceSessionImpl.getGatt() != null && bDDeviceSessionImpl.getGatt().equals(bluetoothGatt);
            } finally {
            }
        }
        return z;
    }

    public void addSession(BDDeviceSessionImpl bDDeviceSessionImpl) {
        BleLogger.d(TAG, "new session added: " + bDDeviceSessionImpl.getAdvertisementContent().getName());
        this.sessions.add(bDDeviceSessionImpl);
    }

    public Set<BleDeviceSession> copyDeviceList() {
        return new HashSet(this.sessions.objects());
    }

    public BDDeviceSessionImpl fetch(CompareFunction compareFunction) {
        AtomicSet<BDDeviceSessionImpl> atomicSet = this.sessions;
        Objects.requireNonNull(compareFunction);
        return atomicSet.fetch(new BDDeviceList$$ExternalSyntheticLambda0(compareFunction, 1));
    }

    public BDDeviceSessionImpl getSession(BluetoothDevice bluetoothDevice) {
        return this.sessions.fetch(new BDDeviceList$$ExternalSyntheticLambda2(bluetoothDevice, 0));
    }

    public AtomicSet<BDDeviceSessionImpl> getSessions() {
        return this.sessions;
    }

    public BDDeviceSessionImpl getSession(BluetoothGatt bluetoothGatt) {
        return this.sessions.fetch(new BDDeviceList$$ExternalSyntheticLambda0(bluetoothGatt, 0));
    }
}
