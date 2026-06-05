package com.urbandroid.sleep.trial;

/* JADX INFO: loaded from: classes5.dex */
public interface IBillingStatusListener {

    public enum Status {
        OWNED,
        NOT_OWNED,
        USER_CANCELLED,
        ERROR,
        REFRESH_ERROR,
        VERIFICATION_FAILED,
        PURCHASE_ERROR
    }

    void onStatusDetected(String str, Status status);
}
