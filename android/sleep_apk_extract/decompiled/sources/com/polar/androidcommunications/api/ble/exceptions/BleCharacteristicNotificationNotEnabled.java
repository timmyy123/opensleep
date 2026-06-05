package com.polar.androidcommunications.api.ble.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class BleCharacteristicNotificationNotEnabled extends Exception {
    public int error;

    public BleCharacteristicNotificationNotEnabled() {
        this.error = -1;
    }

    public BleCharacteristicNotificationNotEnabled(String str) {
        super(str);
        this.error = -1;
    }
}
