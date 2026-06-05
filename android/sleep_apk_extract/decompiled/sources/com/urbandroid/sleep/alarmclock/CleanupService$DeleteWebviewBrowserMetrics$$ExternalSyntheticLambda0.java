package com.urbandroid.sleep.alarmclock;

import com.urbandroid.sleep.alarmclock.CleanupService;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class CleanupService$DeleteWebviewBrowserMetrics$$ExternalSyntheticLambda0 implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return CleanupService.DeleteWebviewBrowserMetrics.doRun$lambda$0(file, str);
    }
}
