package com.urbandroid.common.os;

import com.urbandroid.common.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class ShellBasedResourceUsageMonitor implements ResourceUsageMonitor {
    private final int samplingPeriod;
    private Thread samplingThread;
    private Set<IResourceUsageUpdatesListener> listeners = new HashSet();
    private final Pattern totalCpuUsagePattern = Pattern.compile(".*User (\\d*)%, System (\\d*)%, IOW (\\d*)%, IRQ (\\d*)%.*");
    private final Pattern processUsagePattern = Pattern.compile("\\s*(\\d*)\\s*\\d?\\s*(\\d+)%\\s*([^\\s]*)\\s*(\\d*)\\s*([\\d]*)K\\s*([\\d]*)K\\s*([^\\s]*)\\s*([^\\s]*)\\s*([^\\s]*)\\s*");
    private final Pattern memoryPattern = Pattern.compile("[^\\d]*(\\d*)[^\\d]*");

    public ShellBasedResourceUsageMonitor(int i) {
        this.samplingPeriod = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public void parseData(int i) throws Throwable {
        Throwable th;
        String line;
        BufferedReader bufferedReader;
        String line2 = "N/A";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("top -n 1 -d " + i).getInputStream()));
                    line = "";
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e) {
                e = e;
                line = "N/A";
            }
        } catch (Exception e2) {
            Logger.logWarning("Failed to close stream.", e2);
        }
        try {
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            line2 = bufferedReader.readLine();
            Matcher matcher = this.totalCpuUsagePattern.matcher(line2);
            if (matcher.matches()) {
                TotalCpuUsage totalCpuUsage = new TotalCpuUsage(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
                Iterator<IResourceUsageUpdatesListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().cpuUsageUpdate(totalCpuUsage);
                }
            }
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            LinkedList linkedList = new LinkedList();
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                Matcher matcher2 = this.processUsagePattern.matcher(line);
                if (matcher2.matches()) {
                    linkedList.add(new ProcessResourceUsage(matcher2.group(9), Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), matcher2.group(3), Integer.parseInt(matcher2.group(5)), Integer.parseInt(matcher2.group(6)), Integer.parseInt(matcher2.group(4))));
                }
            }
            Iterator<IResourceUsageUpdatesListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().procUsageUpdate(linkedList);
            }
            bufferedReader.close();
        } catch (Exception e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            Logger.logWarning("Failed to parse usage data. Overal usage: " + line2 + " Last line: " + line, e);
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                throw th;
            }
            try {
                bufferedReader2.close();
                throw th;
            } catch (Exception e4) {
                Logger.logWarning("Failed to close stream.", e4);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseMemoryData() throws Throwable {
        Throwable th;
        Exception exc;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/meminfo").getInputStream()));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e) {
                exc = e;
            }
        } catch (Exception e2) {
            Logger.logWarning("Failed to close stream.", e2);
        }
        try {
            Matcher matcher = this.memoryPattern.matcher(bufferedReader.readLine());
            matcher.matches();
            int i = Integer.parseInt(matcher.group(1));
            Matcher matcher2 = this.memoryPattern.matcher(bufferedReader.readLine());
            matcher2.matches();
            int i2 = Integer.parseInt(matcher2.group(1));
            Matcher matcher3 = this.memoryPattern.matcher(bufferedReader.readLine());
            matcher3.matches();
            int i3 = Integer.parseInt(matcher3.group(1));
            Matcher matcher4 = this.memoryPattern.matcher(bufferedReader.readLine());
            matcher4.matches();
            int i4 = Integer.parseInt(matcher4.group(1));
            Matcher matcher5 = this.memoryPattern.matcher(bufferedReader.readLine());
            matcher5.matches();
            MemoryUsage memoryUsage = new MemoryUsage(i, i2, i3, i4, Integer.parseInt(matcher5.group(1)));
            Iterator<IResourceUsageUpdatesListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().memoryUpdate(memoryUsage);
            }
            bufferedReader.close();
        } catch (Exception e3) {
            exc = e3;
            bufferedReader2 = bufferedReader;
            Logger.logWarning("Failed to parse memory usage.", exc);
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                throw th;
            }
            try {
                bufferedReader2.close();
                throw th;
            } catch (Exception e4) {
                Logger.logWarning("Failed to close stream.", e4);
                throw th;
            }
        }
    }

    @Override // com.urbandroid.common.os.ResourceUsageMonitor
    public void addListener(IResourceUsageUpdatesListener iResourceUsageUpdatesListener) {
        this.listeners.add(iResourceUsageUpdatesListener);
    }

    public void startMonitoring() {
        Thread thread = new Thread() { // from class: com.urbandroid.common.os.ShellBasedResourceUsageMonitor.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                while (!Thread.currentThread().isInterrupted()) {
                    ShellBasedResourceUsageMonitor.this.parseMemoryData();
                    ShellBasedResourceUsageMonitor shellBasedResourceUsageMonitor = ShellBasedResourceUsageMonitor.this;
                    shellBasedResourceUsageMonitor.parseData(shellBasedResourceUsageMonitor.samplingPeriod);
                }
            }
        };
        this.samplingThread = thread;
        thread.start();
    }

    public void stopMonitoring() {
        Thread thread = this.samplingThread;
        if (thread != null) {
            thread.interrupt();
            this.samplingThread = null;
        }
    }
}
