package com.urbandroid.sleep.smartwatch.phaser.protocol;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class SleepPhaserInfo {
    private final String deviceAddress;
    private final int firmwareVersion;
    private final long serialNumber;

    public SleepPhaserInfo(String str, long j, int i) {
        this.deviceAddress = str;
        this.serialNumber = j;
        this.firmwareVersion = i;
    }

    public int getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public boolean isComplete() {
        return this.serialNumber >= 0 && this.firmwareVersion >= 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("SleepPhaserInfo{deviceAddress=");
        sb.append(this.deviceAddress);
        sb.append(", serialNumber=");
        String str2 = "N/A";
        if (this.serialNumber < 0) {
            str = "N/A";
        } else {
            str = "" + this.serialNumber;
        }
        sb.append(str);
        sb.append(", firmwareVersion=");
        if (this.firmwareVersion >= 0) {
            str2 = "" + this.firmwareVersion;
        }
        return FileInsert$$ExternalSyntheticOutline0.m(sb, str2, '}');
    }

    public SleepPhaserInfo withDetails(long j, int i) {
        return new SleepPhaserInfo(this.deviceAddress, j, i);
    }

    public SleepPhaserInfo(String str) {
        this(str, -1L, -1);
    }
}
