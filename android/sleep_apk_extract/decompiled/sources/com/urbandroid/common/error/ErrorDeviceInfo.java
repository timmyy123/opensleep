package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorDeviceInfo {
    private final String cpuAbi;
    private final String fingerprint;
    private final String manufacturer;
    private final String model;
    private final String product;
    private final String rooted;

    public ErrorDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fingerprint = str;
        this.manufacturer = str2;
        this.model = str3;
        this.product = str4;
        this.cpuAbi = str5;
        this.rooted = str6;
    }

    public String getCpuAbi() {
        return this.cpuAbi;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getProduct() {
        return this.product;
    }

    public String getRooted() {
        return this.rooted;
    }
}
