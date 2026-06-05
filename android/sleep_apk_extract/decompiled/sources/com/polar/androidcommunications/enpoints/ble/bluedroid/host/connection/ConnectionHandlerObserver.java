package com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection;

import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectionHandlerObserver {
    void deviceConnectionCancelled(BDDeviceSessionImpl bDDeviceSessionImpl);

    void deviceDisconnected(BDDeviceSessionImpl bDDeviceSessionImpl);

    void deviceSessionStateChanged(BDDeviceSessionImpl bDDeviceSessionImpl);
}
