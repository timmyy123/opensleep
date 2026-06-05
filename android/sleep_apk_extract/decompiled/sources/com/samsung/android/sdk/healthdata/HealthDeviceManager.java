package com.samsung.android.sdk.healthdata;

import android.os.RemoteException;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class HealthDeviceManager {
    private final HealthDataStore a;

    public HealthDeviceManager(HealthDataStore healthDataStore) {
        this.a = healthDataStore;
    }

    private IDeviceManager a() {
        try {
            IDeviceManager iDeviceManager = HealthDataStore.getInterface(this.a).getIDeviceManager();
            if (iDeviceManager != null) {
                return iDeviceManager;
            }
            throw new IllegalStateException("IDeviceManager is null");
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    private void b() {
        if (a() != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Illegal store connection state");
    }

    public HealthDevice getLocalDevice() {
        b();
        try {
            return a().getLocalDevice();
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }
}
