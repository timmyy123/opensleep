package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public class EmailIntentDispatcherConfiguration implements IErrorDispatcherConfiguration {
    private String[] mailTo;
    private IErrorReportSerializer serializer;
    private String subject = "Crash report";
    private String messageBody = "Sorry, the application has crashed unexpectedly. Please help us fix the problem promptly by sending the attached error report.";
    private String onRecoveryMessageBody = "Sorry, last time you used the application, it hung or crashed. Please help fix the problem promptly by sending the attached error report.";
    private String onDemandMessageBody = "Please help us improve the application by sending the attached error report.";
    private String onAssertionFailedMessageBody = "Sorry, there was an issue when you last used the application. Please help us fix this problem by sending the attached error report.";
    private String reportFilename = "crash-report.dat";

    public EmailIntentDispatcherConfiguration(IErrorReportSerializer iErrorReportSerializer, String[] strArr) {
        this.serializer = iErrorReportSerializer;
        this.mailTo = strArr;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String[] getMailTo() {
        return this.mailTo;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getMessageBody() {
        return this.messageBody;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getOnAssertionFailedMessageBody() {
        return this.onAssertionFailedMessageBody;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getOnDemandMessageBody() {
        return this.onDemandMessageBody;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getOnRecoveryMessageBody() {
        return this.onRecoveryMessageBody;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getReportFilename() {
        return this.reportFilename;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public IErrorReportSerializer getSerializer() {
        return this.serializer;
    }

    @Override // com.urbandroid.common.error.IErrorDispatcherConfiguration
    public String getSubject() {
        return this.subject;
    }
}
