package com.urbandroid.common.os;

import com.urbandroid.common.logging.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GatherDataAndReportExcessAction implements Runnable {
    private String reportText;
    private ShellBasedResourceUsageMonitor usageMonitor;

    public class UsageDataListener implements IResourceUsageUpdatesListener {
        private int counter;
        private final int gatherCount;
        private StringBuilder message = new StringBuilder();

        public UsageDataListener(int i) {
            this.gatherCount = i;
        }

        @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
        public void cpuUsageUpdate(TotalCpuUsage totalCpuUsage) {
            if (this.gatherCount <= this.counter) {
                Logger.logInfo("Gather thread done.");
                GatherDataAndReportExcessAction.this.usageMonitor.stopMonitoring();
                GatherDataAndReportExcessAction.this.reportText = this.message.toString();
                return;
            }
            StringBuilder sb = this.message;
            sb.append("System: " + totalCpuUsage.getSystem() + " User: " + totalCpuUsage.getUser() + " IRQ: " + totalCpuUsage.getIrq() + " IO write: " + totalCpuUsage.getIoWrite() + " Total: " + totalCpuUsage.getTotal());
            sb.append("\n");
            this.counter = this.counter + 1;
        }

        @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
        public void memoryUpdate(MemoryUsage memoryUsage) {
        }

        @Override // com.urbandroid.common.os.IResourceUsageUpdatesListener
        public void procUsageUpdate(List<ProcessResourceUsage> list) {
            int i = 0;
            for (ProcessResourceUsage processResourceUsage : list) {
                StringBuilder sb = this.message;
                sb.append(processResourceUsage.getName() + "[" + processResourceUsage.getPid() + "] - " + processResourceUsage.getCpuUsage() + " ");
                sb.append("\n");
                i++;
                if (i > 10 || processResourceUsage.getCpuUsage() == 0) {
                    break;
                }
            }
            this.message.append("\n");
        }
    }

    public GatherDataAndReportExcessAction() {
        ShellBasedResourceUsageMonitor shellBasedResourceUsageMonitor = new ShellBasedResourceUsageMonitor(5);
        this.usageMonitor = shellBasedResourceUsageMonitor;
        shellBasedResourceUsageMonitor.addListener(new UsageDataListener(10));
    }

    public String getReportText() {
        return this.reportText;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger.logInfo("Starting gather thread.");
        this.usageMonitor.startMonitoring();
    }
}
