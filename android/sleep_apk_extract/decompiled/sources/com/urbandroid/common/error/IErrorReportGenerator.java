package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public interface IErrorReportGenerator {
    ErrorReport generateAssertionErrorReport(String str);

    ErrorReport generateOnDemandErrorReport(String str, String str2, Thread thread, Throwable th);

    ErrorReport generateUncaughtErrorReport(Thread thread, Throwable th);
}
