package com.urbandroid.common.error;

import com.urbandroid.common.os.ResourceUsageMonitor;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorReporterConfiguration {
    private IErrorDispatcher dispatcher;
    private final IErrorReportGenerator generator;
    private boolean lockupDetectionEnabled = true;
    private ResourceUsageMonitor resourceUsageMonitor;

    public ErrorReporterConfiguration(IErrorReportGenerator iErrorReportGenerator, IErrorDispatcher iErrorDispatcher) {
        this.generator = iErrorReportGenerator;
        setDispatcher(iErrorDispatcher);
    }

    public IErrorDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public IErrorReportGenerator getGenerator() {
        return this.generator;
    }

    public ResourceUsageMonitor getResourceUsageMonitor() {
        return this.resourceUsageMonitor;
    }

    public void setDispatcher(IErrorDispatcher iErrorDispatcher) {
        if (iErrorDispatcher != null) {
            this.dispatcher = iErrorDispatcher;
        } else {
            this.dispatcher = new EmptyErrorDispatcher();
        }
    }

    public void setLockupDetectionEnabled(boolean z) {
        this.lockupDetectionEnabled = z;
    }

    public void setResourceUsageMonitor(ResourceUsageMonitor resourceUsageMonitor) {
        this.resourceUsageMonitor = resourceUsageMonitor;
    }
}
