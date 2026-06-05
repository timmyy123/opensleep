package com.urbandroid.sleep.smartwatch;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractConnectivityCallback implements IConnectivityCallback {
    private boolean cancelled = false;

    @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
    public void cancel() {
        this.cancelled = true;
    }

    public abstract void doStatus(SmartWatch smartWatch, boolean z);

    @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
    public void status(SmartWatch smartWatch, boolean z) {
        if (this.cancelled) {
            return;
        }
        doStatus(smartWatch, z);
    }
}
