package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
interface IErrorDispatcherConfiguration {
    String[] getMailTo();

    String getMessageBody();

    String getOnAssertionFailedMessageBody();

    String getOnDemandMessageBody();

    String getOnRecoveryMessageBody();

    String getReportFilename();

    IErrorReportSerializer getSerializer();

    String getSubject();
}
