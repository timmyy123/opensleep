package com.polar.androidcommunications.api.ble.model.gatt;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public interface BleGattTxInterface {
    void gattClientRequestStopScanning();

    void gattClientResumeScanning();

    boolean isConnected();

    void setCharacteristicNotify(UUID uuid, UUID uuid2, boolean z);

    void transmitMessage(UUID uuid, UUID uuid2, byte[] bArr, boolean z);

    void transmitMessages(UUID uuid, UUID uuid2, List<byte[]> list, boolean z);
}
