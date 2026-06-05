package com.urbandroid.common.os;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IResourceUsageUpdatesListener {
    void cpuUsageUpdate(TotalCpuUsage totalCpuUsage);

    void memoryUpdate(MemoryUsage memoryUsage);

    void procUsageUpdate(List<ProcessResourceUsage> list);
}
