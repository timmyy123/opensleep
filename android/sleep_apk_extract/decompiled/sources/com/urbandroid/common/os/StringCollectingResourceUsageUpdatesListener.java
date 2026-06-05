package com.urbandroid.common.os;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StringCollectingResourceUsageUpdatesListener implements IResourceUsageUpdatesListener {
    private final int maxProcs;
    private final IStringCollector stringCollector;

    public StringCollectingResourceUsageUpdatesListener(int i, IStringCollector iStringCollector) {
        this.maxProcs = i;
        this.stringCollector = iStringCollector;
    }

    @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
    public void cpuUsageUpdate(TotalCpuUsage totalCpuUsage) {
        this.stringCollector.newString("[Cpu usage] User: " + totalCpuUsage.getUser() + " System: " + totalCpuUsage.getSystem() + " IOW: " + totalCpuUsage.getIoWrite() + " IRQ: " + totalCpuUsage.getIrq());
    }

    @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
    public void memoryUpdate(MemoryUsage memoryUsage) {
        this.stringCollector.newString("[Mem usage] Total: " + memoryUsage.getTotalMempory() + " Free: " + memoryUsage.getFreeMemory() + " Buff: " + memoryUsage.getBuffersMemory() + " Cache: " + memoryUsage.getCachedMemory() + " Swap: " + memoryUsage.getSwapMemory());
    }

    @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
    public void procUsageUpdate(List<ProcessResourceUsage> list) {
        StringBuilder sb = new StringBuilder("[Proc usage] ");
        int i = 0;
        for (ProcessResourceUsage processResourceUsage : list) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(processResourceUsage.getName() + " - " + processResourceUsage.getCpuUsage());
            i++;
            if (i >= this.maxProcs) {
                break;
            }
        }
        this.stringCollector.newString(sb.toString());
    }
}
