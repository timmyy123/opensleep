package com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection;

import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectionInterface {
    void cancelDeviceConnection(BDDeviceSessionImpl bDDeviceSessionImpl);

    void connectDevice(BDDeviceSessionImpl bDDeviceSessionImpl);

    void disconnectDevice(BDDeviceSessionImpl bDDeviceSessionImpl);

    boolean isPowered();

    boolean setMtu(BDDeviceSessionImpl bDDeviceSessionImpl);

    void setPhy(BDDeviceSessionImpl bDDeviceSessionImpl);

    boolean startServiceDiscovery(BDDeviceSessionImpl bDDeviceSessionImpl);
}
