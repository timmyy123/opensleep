package com.urbandroid.sleep.hr.polar.domain;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes.dex */
public enum PmdMeasurementType {
    ECG(0),
    PPG(1),
    ACC(2),
    PPI(3),
    BIOZ(4),
    GYRO(5),
    MAGNETOMETER(6),
    BAROMETER(7),
    AMBIENT(8),
    UNKNOWN_TYPE(PHIpAddressSearchManager.END_IP_SCAN);

    private final int numVal;

    PmdMeasurementType(int i) {
        this.numVal = i;
    }

    public static PmdMeasurementType fromId(byte b) {
        for (PmdMeasurementType pmdMeasurementType : values()) {
            if (pmdMeasurementType.numVal == b) {
                return pmdMeasurementType;
            }
        }
        return UNKNOWN_TYPE;
    }

    public int getNumVal() {
        return this.numVal;
    }
}
