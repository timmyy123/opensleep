package com.garmin.android.connectiq;

import android.content.Context;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.adb.AdbConnection;
import com.garmin.android.connectiq.exception.InvalidStateException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectIQAdbStrategy extends ConnectIQ {
    private AdbConnection.AdbConnectionListener connListener = new AdbConnection.AdbConnectionListener() { // from class: com.garmin.android.connectiq.ConnectIQAdbStrategy.1
        @Override // com.garmin.android.connectiq.adb.AdbConnection.AdbConnectionListener
        public void onConnectionStatusChanged(IQDevice iQDevice, IQDevice.IQDeviceStatus iQDeviceStatus) {
            ConnectIQAdbStrategy.this.deviceStatusChanged(iQDevice, iQDeviceStatus);
        }
    };

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void getApplicationInfo(String str, IQDevice iQDevice, ConnectIQ.IQApplicationInfoListener iQApplicationInfoListener) throws InvalidStateException {
        verifyInitialized();
        if (!AdbConnection.getInstance().isConnected()) {
            throw new InvalidStateException("SDK not initialized. Did you forget to call ConnectIQ::initialize()?");
        }
        if (iQDevice != null || iQApplicationInfoListener == null) {
            iQApplicationInfoListener.onApplicationInfoReceived(new IQApp(str));
        } else {
            iQApplicationInfoListener.onApplicationNotInstalled(str);
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public List<IQDevice> getConnectedDevices() {
        verifyInitialized();
        if (!AdbConnection.getInstance().isConnected()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new IQDevice(12345L, "Simulator"));
        return arrayList;
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public IQDevice.IQDeviceStatus getDeviceStatus(IQDevice iQDevice) {
        verifyInitialized();
        IQDevice.IQDeviceStatus iQDeviceStatus = IQDevice.IQDeviceStatus.NOT_PAIRED;
        return AdbConnection.getInstance().isConnected() ? IQDevice.IQDeviceStatus.CONNECTED : IQDevice.IQDeviceStatus.NOT_CONNECTED;
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void initialize(Context context, boolean z, ConnectIQ.ConnectIQListener connectIQListener) {
        AdbConnection adbConnection = AdbConnection.getInstance();
        adbConnection.setContext(context);
        if (!adbConnection.isActive()) {
            adbConnection.establishConnection(this.connListener);
        }
        super.initialize(context, z, connectIQListener);
        if (connectIQListener != null) {
            connectIQListener.onSdkReady();
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void registerForRemoteAppEvents(IQApp iQApp) {
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void sendMessageProtocol(IQDevice iQDevice, IQApp iQApp, byte[] bArr, ConnectIQ.IQSendMessageListener iQSendMessageListener, boolean z) {
        if (AdbConnection.getInstance().sendMessage(bArr)) {
            if (iQSendMessageListener != null) {
                iQSendMessageListener.onMessageStatus(iQDevice, iQApp, ConnectIQ.IQMessageStatus.SUCCESS);
            }
        } else if (iQSendMessageListener != null) {
            iQSendMessageListener.onMessageStatus(iQDevice, iQApp, ConnectIQ.IQMessageStatus.FAILURE_UNKNOWN);
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void unregisterForRemoteAppEvents(IQApp iQApp) {
    }
}
