package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public interface IErrorDispatcher {
    void handleErrorReport(ErrorReport errorReport);

    void performStartupRecovery();
}
