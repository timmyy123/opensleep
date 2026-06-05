package com.polar.androidcommunications.api.ble.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class BleAttributeError extends Exception {
    private final int error;

    public BleAttributeError(String str, int i) {
        super(str + " failed with error: " + i);
        this.error = i;
    }
}
