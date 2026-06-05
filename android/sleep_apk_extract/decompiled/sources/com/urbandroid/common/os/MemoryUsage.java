package com.urbandroid.common.os;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryUsage {
    private int buffersMemory;
    private int cachedMemory;
    private int freeMemory;
    private int swapMemory;
    private int totalMempory;

    public MemoryUsage(int i, int i2, int i3, int i4, int i5) {
        this.totalMempory = i;
        this.freeMemory = i2;
        this.buffersMemory = i3;
        this.cachedMemory = i4;
        this.swapMemory = i5;
    }

    public int getBuffersMemory() {
        return this.buffersMemory;
    }

    public int getCachedMemory() {
        return this.cachedMemory;
    }

    public int getFreeMemory() {
        return this.freeMemory;
    }

    public int getSwapMemory() {
        return this.swapMemory;
    }

    public int getTotalMempory() {
        return this.totalMempory;
    }
}
