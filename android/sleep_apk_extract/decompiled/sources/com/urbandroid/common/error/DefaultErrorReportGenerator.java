package com.urbandroid.common.error;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.StringBuilderPrinter;
import com.urbandroid.common.emulator.EmulatorDetector;
import com.urbandroid.common.error.ErrorReport;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.os.BoundedInMemoryStringCollector;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.RootUtil;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultErrorReportGenerator implements IErrorReportGenerator {
    private final Context activity;
    private final IAdditionalDataProvider additionalDataProvider;
    private final List<Logger.LogConfig> additionalLogConfigs;
    private Handler handler;
    private int maximumDebugOutputIncluded = 1000;
    private int maximumLogcatOutputIncluded = 500;
    private int maximumLogcatOutputIncludedError = 2500;
    private final BoundedInMemoryStringCollector usageCollector;

    public DefaultErrorReportGenerator(Context context, Handler handler, IAdditionalDataProvider iAdditionalDataProvider, BoundedInMemoryStringCollector boundedInMemoryStringCollector) {
        LinkedList linkedList = new LinkedList();
        this.additionalLogConfigs = linkedList;
        if (context == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Activity must be non-null.");
            throw null;
        }
        this.activity = context;
        this.additionalDataProvider = iAdditionalDataProvider;
        if (iAdditionalDataProvider != null && iAdditionalDataProvider.getAdditionalLogs() != null) {
            linkedList.addAll(iAdditionalDataProvider.getAdditionalLogs());
        }
        this.usageCollector = boundedInMemoryStringCollector;
        this.handler = handler;
        if (handler == null) {
            Logger.logWarning("No handler in error report initializer.", new Exception("Marker"));
        }
    }

    private ErrorApplicationInfo generateApplicationInfo() {
        return new ErrorApplicationInfo(this.activity.getPackageName(), new ApplicationVersionExtractor().getCurrentVersion(this.activity));
    }

    private ErrorReport generateCoreErrorReport(String str, String str2, ErrorReport.Type type, Thread thread, Throwable th) {
        ErrorReport errorReport = new ErrorReport(System.currentTimeMillis(), type, str, str2, generateExceptionInfo(thread, th), generateEnvironmentInfo(), generateApplicationInfo(), generateDeviceInfo(), generateLogRecordOutput(), Logger.getPersistentBufferFiles(this.activity), getLogcatOutput(), getResourceUsage());
        addAdditionalData(errorReport, th);
        for (Logger.LogConfig logConfig : this.additionalLogConfigs) {
            errorReport.addAdditionalLogData(logConfig, Logger.getLogBufferIncluingWriteBuffer(logConfig), Logger.getPersistentBufferFiles(this.activity, logConfig));
        }
        return errorReport;
    }

    private ErrorDeviceInfo generateDeviceInfo() {
        boolean zIsDeviceRooted;
        String manufacturer = Environment.getManufacturer();
        try {
            zIsDeviceRooted = new RootUtil().isDeviceRooted();
        } catch (Exception unused) {
            zIsDeviceRooted = false;
        }
        return new ErrorDeviceInfo(Build.FINGERPRINT, manufacturer, Build.MODEL, Build.PRODUCT, Environment.getCpuAbi(), zIsDeviceRooted ? "ROOTED" : "");
    }

    private ErrorEnvironmentInfo generateEnvironmentInfo() {
        return new ErrorEnvironmentInfo(this.activity.getResources().getConfiguration().locale.getDisplayName(), this.activity.getResources().getConfiguration().orientation, this.activity.getResources().getConfiguration().keyboardHidden, this.activity.getResources().getConfiguration().hardKeyboardHidden, this.activity.getResources().getConfiguration().mnc, this.activity.getResources().getConfiguration().mcc, getMessageQueue(), EmulatorDetector.isEmulator(this.activity));
    }

    private ErrorExceptionInfo generateExceptionInfo(Thread thread, Throwable th) {
        return new ErrorExceptionInfo(thread != null ? thread.getName() : null, th, Thread.getAllStackTraces());
    }

    private List<Logger.LogRecord> generateLogRecordOutput() {
        List<Logger.LogRecord> logBufferIncluingWriteBuffer = Logger.getLogBufferIncluingWriteBuffer();
        int size = logBufferIncluingWriteBuffer.size();
        int i = this.maximumDebugOutputIncluded;
        return size > i ? logBufferIncluingWriteBuffer.subList(0, Math.max(0, i)) : logBufferIncluingWriteBuffer;
    }

    private List<String> getLogcatOutput() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("************* INFO *************\n");
        linkedList.addAll(LogCatExtractor.getLogcatOutput(this.maximumLogcatOutputIncluded, "Info"));
        linkedList.add("************* ERROR *************\n");
        linkedList.addAll(LogCatExtractor.getLogcatOutput(this.maximumLogcatOutputIncludedError, "Warn"));
        return linkedList;
    }

    private String getMessageQueue() {
        if (this.handler == null) {
            try {
                this.handler = new Handler();
            } catch (Exception unused) {
                Logger.logSevere("No handler");
                return "";
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            this.handler.dump(new StringBuilderPrinter(sb), "");
            return sb.toString();
        } catch (Exception e) {
            return "Failed to obtain handler dump: " + e.getMessage() + "\n";
        }
    }

    private Collection<String> getResourceUsage() {
        return this.usageCollector.getStrings();
    }

    public void addAdditionalData(ErrorReport errorReport, Throwable th) {
        IAdditionalDataProvider iAdditionalDataProvider = this.additionalDataProvider;
        if (iAdditionalDataProvider != null) {
            iAdditionalDataProvider.logThrowable(th);
            errorReport.addAdditionalData(this.additionalDataProvider.getAdditionalData());
        }
    }

    @Override // com.urbandroid.common.error.IErrorReportGenerator
    public ErrorReport generateAssertionErrorReport(String str) {
        return generateCoreErrorReport(null, str, ErrorReport.Type.ASSERTION_FAILED, null, new Throwable("Marker"));
    }

    @Override // com.urbandroid.common.error.IErrorReportGenerator
    public ErrorReport generateOnDemandErrorReport(String str, String str2, Thread thread, Throwable th) {
        return generateCoreErrorReport(str, str2, ErrorReport.Type.ON_DEMAND, thread, th);
    }

    @Override // com.urbandroid.common.error.IErrorReportGenerator
    public ErrorReport generateUncaughtErrorReport(Thread thread, Throwable th) {
        return generateCoreErrorReport(null, null, ErrorReport.Type.EXCEPTION_THROWN, thread, th);
    }
}
