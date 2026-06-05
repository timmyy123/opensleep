package com.philips.lighting.hue.sdk.data;

/* JADX INFO: loaded from: classes4.dex */
public class BridgeHeader {
    private String ip;
    private long lastHeartbeat;
    private String status;

    public BridgeHeader(String str, String str2, long j) {
        this.ip = str;
        this.status = str2;
        this.lastHeartbeat = j;
    }

    public String getIPAddress() {
        return this.ip;
    }

    public long getLastHeartbeat() {
        return this.lastHeartbeat;
    }

    public String getStatus() {
        return this.status;
    }

    public void setIPAddress(String str) {
        this.ip = str;
    }

    public void setLastHeartbeat(long j) {
        this.lastHeartbeat = j;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
