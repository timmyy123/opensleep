package com.urbandroid.common.os;

/* JADX INFO: loaded from: classes4.dex */
public class TotalCpuUsage {
    private final int ioWrite;
    private final int irq;
    private final int system;
    private final int user;

    public TotalCpuUsage(int i, int i2, int i3, int i4) {
        this.user = i;
        this.system = i2;
        this.ioWrite = i3;
        this.irq = i4;
    }

    public int getIoWrite() {
        return this.ioWrite;
    }

    public int getIrq() {
        return this.irq;
    }

    public int getSystem() {
        return this.system;
    }

    public int getTotal() {
        return this.user + this.system + this.ioWrite + this.irq;
    }

    public int getUser() {
        return this.user;
    }
}
