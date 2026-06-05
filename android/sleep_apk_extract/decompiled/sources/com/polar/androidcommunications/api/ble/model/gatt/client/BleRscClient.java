package com.polar.androidcommunications.api.ble.model.gatt.client;

import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import io.reactivex.rxjava3.core.FlowableEmitter;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class BleRscClient extends BleGattBase {
    public static final UUID RSC_FEATURE = UUID.fromString("00002a54-0000-1000-8000-00805f9b34fb");
    public static final UUID RSC_MEASUREMENT = UUID.fromString("00002a53-0000-1000-8000-00805f9b34fb");
    public static final UUID RSC_SERVICE = UUID.fromString("00001814-0000-1000-8000-00805f9b34fb");
    private static final String TAG = "BleRscClient";
    private final AtomicSet<FlowableEmitter<? super RscNotificationData>> observers;

    public static class RscNotificationData {
        public long Cadence;
        public boolean Running;
        public long Speed;
        public long StrideLength;
        public boolean StrideLengthPresent;
        public boolean TotaDistancePresent;
        public long TotalDistance;

        public RscNotificationData(boolean z, boolean z2, boolean z3, long j, long j2, long j3, long j4) {
            this.StrideLengthPresent = z;
            this.TotaDistancePresent = z2;
            this.Running = z3;
            this.Speed = j;
            this.Cadence = j2;
            this.StrideLength = j3;
            this.TotalDistance = j4;
        }
    }

    public BleRscClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, RSC_SERVICE);
        this.observers = new AtomicSet<>();
        addCharacteristicNotification(RSC_MEASUREMENT);
        addCharacteristicRead(RSC_FEATURE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processServiceData$0(boolean z, boolean z2, boolean z3, long j, long j2, long j3, long j4, FlowableEmitter flowableEmitter) {
        flowableEmitter.onNext(new RscNotificationData(z, z2, z3, j, j2, j3, j4));
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        final long j;
        if (i != 0) {
            BleLogger.w(TAG, "Process service data with status " + i + ", skipped");
            return;
        }
        if (!uuid.equals(RSC_MEASUREMENT)) {
            if (uuid.equals(RSC_FEATURE)) {
                long j2 = bArr[0] | (bArr[1] << 8);
                BleLogger.d(TAG, "RSC Feature Characteristic read: " + j2);
                return;
            }
            return;
        }
        long j3 = bArr[0];
        final boolean z2 = (j3 & 1) == 1;
        final boolean z3 = (j3 & 2) == 2;
        final boolean z4 = (j3 & 4) == 4;
        final long j4 = bArr[1] | (bArr[2] << 8);
        final long j5 = bArr[3];
        long j6 = 0;
        int i2 = 4;
        if (z2) {
            j = bArr[4] | (bArr[5] << 8);
            i2 = 6;
        } else {
            j = 0;
        }
        if (z3) {
            j6 = (bArr[i2 + 2] << 16) | (bArr[i2 + 1] << 8) | bArr[i2] | (bArr[i2 + 3] << 24);
        }
        final long j7 = j6;
        RxUtils.emitNext(this.observers, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleRscClient$$ExternalSyntheticLambda0
            @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
            public final void item(Object obj) {
                BleRscClient.lambda$processServiceData$0(z2, z3, z4, j4, j5, j, j7, (FlowableEmitter) obj);
            }
        });
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        RxUtils.postDisconnectedAndClearList(this.observers);
    }

    public String toString() {
        return "RSC service ";
    }
}
