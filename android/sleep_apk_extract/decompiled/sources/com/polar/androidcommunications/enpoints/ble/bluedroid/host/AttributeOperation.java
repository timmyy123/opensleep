package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes4.dex */
public class AttributeOperation implements Comparable<AttributeOperation> {
    private final AttributeOperationCommand attributeOperation;
    private final BluetoothGattCharacteristic characteristic;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private byte[] f55data;
    private boolean enable;
    private boolean isPartOfPrimaryService;
    private boolean withResponse;

    public enum AttributeOperationCommand {
        CHARACTERISTIC_READ,
        CHARACTERISTIC_WRITE,
        DESCRIPTOR_WRITE,
        CHARACTERISTIC_NOTIFY
    }

    public AttributeOperation(AttributeOperationCommand attributeOperationCommand, byte[] bArr, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        this.isPartOfPrimaryService = false;
        this.enable = false;
        this.attributeOperation = attributeOperationCommand;
        this.f55data = bArr;
        this.characteristic = bluetoothGattCharacteristic;
        this.withResponse = z;
    }

    private boolean isPartOfPrimaryService() {
        return this.isPartOfPrimaryService;
    }

    @Override // java.lang.Comparable
    public int compareTo(AttributeOperation attributeOperation) {
        AttributeOperationCommand attributeOperation2 = attributeOperation.getAttributeOperation();
        AttributeOperationCommand attributeOperationCommand = AttributeOperationCommand.DESCRIPTOR_WRITE;
        if (attributeOperation2 == attributeOperationCommand && attributeOperation.isPartOfPrimaryService()) {
            return 1;
        }
        return attributeOperation.getAttributeOperation() == attributeOperationCommand ? 0 : -1;
    }

    public AttributeOperationCommand getAttributeOperation() {
        return this.attributeOperation;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    public byte[] getData() {
        return this.f55data;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isWithResponse() {
        return this.withResponse;
    }

    public void setIsPartOfPrimaryService(boolean z) {
        this.isPartOfPrimaryService = z;
    }

    public AttributeOperation(AttributeOperationCommand attributeOperationCommand, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        this.isPartOfPrimaryService = false;
        this.withResponse = false;
        this.attributeOperation = attributeOperationCommand;
        this.characteristic = bluetoothGattCharacteristic;
        this.enable = z;
    }

    public AttributeOperation(AttributeOperationCommand attributeOperationCommand, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.isPartOfPrimaryService = false;
        this.enable = false;
        this.withResponse = false;
        this.attributeOperation = attributeOperationCommand;
        this.characteristic = bluetoothGattCharacteristic;
    }
}
