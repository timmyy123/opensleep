package com.urbandroid.sleep.service.health;

/* JADX INFO: loaded from: classes5.dex */
public class ExceptionResultStatus implements ResultStatus {
    private final Exception exception;

    public ExceptionResultStatus(Exception exc) {
        this.exception = exc;
    }

    @Override // com.urbandroid.sleep.service.health.ResultStatus
    public boolean isSuccess() {
        return false;
    }

    public String toString() {
        return this.exception.toString();
    }
}
