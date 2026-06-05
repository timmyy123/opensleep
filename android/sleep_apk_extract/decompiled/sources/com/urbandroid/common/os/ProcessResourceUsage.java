package com.urbandroid.common.os;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessResourceUsage {
    private final int cpuUsage;
    private final String name;
    private final int pid;
    private final int rss;
    private final int threads;
    private final String uid;
    private final int vss;

    public ProcessResourceUsage(String str, int i, int i2, String str2, int i3, int i4, int i5) {
        this.name = str;
        this.cpuUsage = i2;
        this.pid = i;
        this.uid = str2;
        this.rss = i4;
        this.vss = i3;
        this.threads = i5;
    }

    public int getCpuUsage() {
        return this.cpuUsage;
    }

    public String getName() {
        return this.name;
    }

    public int getPid() {
        return this.pid;
    }
}
