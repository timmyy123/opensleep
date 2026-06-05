package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeviceLookup {

    public interface Predicate {
        boolean test(BluetoothDevice bluetoothDevice);
    }

    private static BluetoothDevice bleScan(BluetoothAdapter bluetoothAdapter, Predicate predicate, long j) {
        return (!Environment.isLollipopOrGreater() || bluetoothAdapter.getBluetoothLeScanner() == null) ? bleScanOld(bluetoothAdapter, predicate, j) : bleScanNew(bluetoothAdapter, predicate, j);
    }

    private static BluetoothDevice bleScanNew(BluetoothAdapter bluetoothAdapter, final Predicate predicate, long j) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        ScanCallback scanCallback = new ScanCallback() { // from class: com.urbandroid.sleep.bluetoothle.DeviceLookup.2
            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i) {
                super.onScanFailed(i);
                Logger.logInfo("DeviceLookup: scan failed");
                countDownLatch.countDown();
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i, ScanResult scanResult) {
                super.onScanResult(i, scanResult);
                BluetoothDevice device = scanResult.getDevice();
                if (predicate.test(device)) {
                    atomicReference.set(device);
                    countDownLatch.countDown();
                }
            }
        };
        try {
            try {
                Logger.logInfo("DeviceLookup: Starting lookup new");
                bluetoothAdapter.getBluetoothLeScanner().startScan(scanCallback);
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
                bluetoothAdapter.getBluetoothLeScanner().stopScan(scanCallback);
                return (BluetoothDevice) atomicReference.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            bluetoothAdapter.getBluetoothLeScanner().stopScan(scanCallback);
            throw th;
        }
    }

    private static BluetoothDevice bleScanOld(BluetoothAdapter bluetoothAdapter, final Predicate predicate, long j) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.urbandroid.sleep.bluetoothle.DeviceLookup.1
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (predicate.test(bluetoothDevice)) {
                    atomicReference.set(bluetoothDevice);
                    countDownLatch.countDown();
                }
            }
        };
        try {
            try {
                Logger.logInfo("DeviceLookup: Starting lookup old");
                bluetoothAdapter.startLeScan(leScanCallback);
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
                bluetoothAdapter.stopLeScan(leScanCallback);
                return (BluetoothDevice) atomicReference.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            bluetoothAdapter.stopLeScan(leScanCallback);
            throw th;
        }
    }

    public static BluetoothDevice find(Context context, Predicate predicate, long j) {
        if (!Environment.isJellyBean43OrGreater()) {
            new BluetoothException("At least API level 18 is required. " + Environment.getAPILevel());
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            Events$$ExternalSyntheticBUOutline0.m("Bluetooth Low Energy not supported");
            return null;
        }
        BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        if (adapter == null || !adapter.isEnabled()) {
            Events$$ExternalSyntheticBUOutline0.m("Bluetooth is not enabled");
            return null;
        }
        BluetoothDevice bluetoothDeviceBleScan = bleScan(adapter, predicate, j);
        Logger.logInfo("DeviceLookup: finished, device ".concat(bluetoothDeviceBleScan == null ? "not found" : "found"));
        return bluetoothDeviceBleScan;
    }
}
