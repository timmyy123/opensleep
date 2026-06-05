package com.urbandroid.common.error;

import android.util.Log;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ThreadUtil;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorReportingExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final ErrorReporter reporter;
    private final Set<String> nonFatalThreads = new HashSet();
    private final Thread.UncaughtExceptionHandler chaninedHandler = Thread.getDefaultUncaughtExceptionHandler();

    public ErrorReportingExceptionHandler(ErrorReporter errorReporter) {
        this.reporter = errorReporter;
    }

    public void addNonFatalThread(String str) {
        this.nonFatalThreads.add(str);
    }

    public void finalize() throws Throwable {
        if (Thread.getDefaultUncaughtExceptionHandler().equals(this)) {
            Thread.setDefaultUncaughtExceptionHandler(this.chaninedHandler);
        }
        super.finalize();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null && th.getMessage() != null && th.getMessage().equals("WakeLock under-locked SleepCloud Backup")) {
            Logger.logWarning("Ignoring " + th.getMessage(), th);
            return;
        }
        if (thread != null && thread.getName() != null && this.nonFatalThreads.contains(thread.getName())) {
            Logger.logSevere("Letting app live after exception in thread: " + thread.getName(), th);
            return;
        }
        Log.e("SleepAsAndroid", "UncaughtException", th);
        try {
            this.reporter.handleUncaughtException(thread, th);
        } catch (Exception e) {
            Logger.logSevere("Exception in exception handling...", e);
        }
        Logger.logDebug("Passing control to next handler");
        if (this.chaninedHandler != null) {
            if (!ThreadUtil.isInUiThread()) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
            this.chaninedHandler.uncaughtException(thread, th);
        }
    }
}
