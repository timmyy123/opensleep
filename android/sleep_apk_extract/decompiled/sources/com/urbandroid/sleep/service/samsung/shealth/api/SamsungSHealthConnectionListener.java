package com.urbandroid.sleep.service.samsung.shealth.api;

import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;

/* JADX INFO: loaded from: classes5.dex */
public interface SamsungSHealthConnectionListener {
    void onConnected(SamsungSHealthApi samsungSHealthApi);

    void onConnectionFailed(HealthConnectionErrorResult healthConnectionErrorResult);
}
