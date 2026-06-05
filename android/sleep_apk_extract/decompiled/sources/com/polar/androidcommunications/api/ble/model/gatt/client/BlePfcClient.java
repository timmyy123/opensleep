package com.polar.androidcommunications.api.ble.model.gatt.client;

import android.util.Pair;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class BlePfcClient extends BleGattBase {
    private static final String TAG = "BlePfcClient";
    private final Object mutexFeature;
    private final AtomicInteger pfcCpEnabled;
    private final LinkedBlockingQueue<Pair<byte[], Integer>> pfcCpInputQueue;
    private PfcFeature pfcFeature;
    private final Object pfcMutex;
    private final Scheduler scheduler;
    public static final UUID PFC_SERVICE = UUID.fromString("6217FF4B-FB31-1140-AD5A-A45545D7ECF3");
    public static final UUID PFC_FEATURE = UUID.fromString("6217FF4C-C8EC-B1FB-1380-3AD986708E2D");
    public static final UUID PFC_CP = UUID.fromString("6217FF4D-91BB-91D0-7E2A-7CD3BDA8A1F3");

    public static class PfcFeature implements Cloneable {
        public boolean antSupported;
        public boolean bleModeConfigureSupported;
        public boolean broadcastSupported;
        public boolean khzSupported;
        public boolean multiConnectionSupported;
        public boolean otaUpdateSupported;
        public boolean whisperModeSupported;

        public PfcFeature(byte[] bArr) {
            byte b = bArr[0];
            this.broadcastSupported = (b & 1) == 1;
            this.khzSupported = ((b & 2) >> 1) == 1;
            this.otaUpdateSupported = ((b & 4) >> 2) == 1;
            this.whisperModeSupported = ((b & 16) >> 4) == 1;
            this.bleModeConfigureSupported = ((b & 64) >> 6) == 1;
            this.multiConnectionSupported = ((b & 128) >> 7) == 1;
            this.antSupported = (bArr[1] & 1) == 1;
        }
    }

    public BlePfcClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, PFC_SERVICE);
        this.pfcFeature = null;
        this.mutexFeature = new Object();
        this.pfcCpInputQueue = new LinkedBlockingQueue<>();
        this.scheduler = Schedulers.newThread();
        this.pfcMutex = new Object();
        addCharacteristicRead(PFC_FEATURE);
        UUID uuid = PFC_CP;
        addCharacteristicNotification(uuid);
        this.pfcCpEnabled = getNotificationAtomicInteger(uuid);
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        if (uuid.equals(PFC_CP)) {
            this.pfcCpInputQueue.add(new Pair<>(bArr, Integer.valueOf(i)));
            return;
        }
        if (uuid.equals(PFC_FEATURE)) {
            if (i != 0) {
                BleLogger.w(TAG, "Process service data with status: " + i + ", skipped");
                return;
            }
            synchronized (this.mutexFeature) {
                if (i == 0) {
                    try {
                        this.pfcFeature = new PfcFeature(bArr);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.mutexFeature.notifyAll();
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        this.pfcCpInputQueue.clear();
        synchronized (this.mutexFeature) {
            this.pfcFeature = null;
            this.mutexFeature.notifyAll();
        }
    }

    public String toString() {
        return "PFC service with values broadcast supported: " + this.pfcFeature.broadcastSupported + " 5khz supported: " + this.pfcFeature.khzSupported;
    }
}
