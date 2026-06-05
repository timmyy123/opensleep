package com.urbandroid.sleep.smartwatch;

/* JADX INFO: loaded from: classes5.dex */
public interface IConnectivityCallback {
    void cancel();

    boolean isCancelled();

    void status(SmartWatch smartWatch, boolean z);
}
