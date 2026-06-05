package com.garmin.android.connectiq;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteException;
import com.garmin.android.apps.connectmobile.connectiq.IConnectIQService;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.exception.InvalidStateException;
import com.garmin.android.connectiq.exception.ServiceUnavailableException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectIQDeviceStrategy extends ConnectIQ {
    private boolean mBound = false;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.garmin.android.connectiq.ConnectIQDeviceStrategy.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ConnectIQDeviceStrategy.this.mRemoteService = IConnectIQService.Stub.asInterface(iBinder);
            ConnectIQDeviceStrategy.this.mBound = true;
            ConnectIQ.ConnectIQListener connectIQListener = ConnectIQDeviceStrategy.this.mListener;
            if (connectIQListener != null) {
                connectIQListener.onSdkReady();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ConnectIQDeviceStrategy.this.mRemoteService = null;
            ConnectIQDeviceStrategy.this.mBound = false;
            ConnectIQ.ConnectIQListener connectIQListener = ConnectIQDeviceStrategy.this.mListener;
            if (connectIQListener != null) {
                connectIQListener.onSdkShutDown();
            }
        }
    };
    private IConnectIQService mRemoteService;

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void getApplicationInfo(String str, IQDevice iQDevice, ConnectIQ.IQApplicationInfoListener iQApplicationInfoListener) throws ServiceUnavailableException, InvalidStateException {
        verifyInitialized();
        String strReplaceAll = str.toUpperCase().replaceAll("[\\s\\-]", "");
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        if (iQDevice == null) {
            if (iQApplicationInfoListener != null) {
                iQApplicationInfoListener.onApplicationNotInstalled(strReplaceAll);
                return;
            }
            return;
        }
        IQDeviceListenerContainer deviceListenerContainer = getMessageReceiver().getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer != null) {
            deviceListenerContainer.setApplicationInfoListener(strReplaceAll, iQApplicationInfoListener);
        } else {
            IQDeviceListenerContainer iQDeviceListenerContainer = new IQDeviceListenerContainer(iQDevice.getDeviceIdentifier());
            iQDeviceListenerContainer.setApplicationInfoListener(strReplaceAll, iQApplicationInfoListener);
            getMessageReceiver().addDeviceListenerContainer(iQDevice.getDeviceIdentifier(), iQDeviceListenerContainer);
        }
        try {
            this.mRemoteService.getApplicationInfo(this.mContext.getPackageName(), "com.garmin.android.connectiq.APPLICATION_INFO", iQDevice, strReplaceAll);
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public List<IQDevice> getConnectedDevices() throws InvalidStateException, ServiceUnavailableException {
        verifyInitialized();
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        try {
            return this.mRemoteService.getConnectedDevices();
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public IQDevice.IQDeviceStatus getDeviceStatus(IQDevice iQDevice) throws ServiceUnavailableException, InvalidStateException {
        verifyInitialized();
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        try {
            return IQDevice.IQDeviceStatus.values()[this.mRemoteService.getStatus(iQDevice)];
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            return IQDevice.IQDeviceStatus.UNKNOWN;
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void initialize(Context context, boolean z, ConnectIQ.ConnectIQListener connectIQListener) {
        super.initialize(context, z, connectIQListener);
        try {
            if (this.mContext.getPackageManager().getPackageInfo("com.garmin.android.apps.connectmobile", 0).versionCode >= 10617) {
                Intent intent = new Intent("com.garmin.android.apps.connectmobile.CONNECTIQ_SERVICE_ACTION");
                intent.setComponent(new ComponentName("com.garmin.android.apps.connectmobile", "com.garmin.android.apps.connectmobile.connectiq.ConnectIQService"));
                this.mContext.bindService(intent, this.mConnection, 1);
                return;
            }
            ConnectIQ.ConnectIQListener connectIQListener2 = this.mListener;
            if (connectIQListener2 != null) {
                connectIQListener2.onInitializeError(ConnectIQ.IQSdkErrorStatus.GCM_UPGRADE_NEEDED);
            }
            if (z) {
                String packageName = this.mContext.getPackageName();
                Resources resources = this.mContext.getResources();
                int identifier = resources.getIdentifier("upgrade_needed_title", "string", packageName);
                int identifier2 = resources.getIdentifier("upgrade_needed_message", "string", packageName);
                int identifier3 = resources.getIdentifier("upgrade_cancel", "string", packageName);
                int identifier4 = resources.getIdentifier("upgrade_yes", "string", packageName);
                displayGCMDialog(identifier != 0 ? this.mContext.getString(identifier) : "Upgrade Needed", identifier2 != 0 ? this.mContext.getString(identifier2) : "An upgrade to Garmin Connect Mobile is required to use this application. Would you like to upgrade now?", identifier3 != 0 ? this.mContext.getString(identifier3) : "Cancel", identifier4 != 0 ? this.mContext.getString(identifier4) : "Upgrade");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (z) {
                String packageName2 = this.mContext.getPackageName();
                Resources resources2 = this.mContext.getResources();
                int identifier5 = resources2.getIdentifier("install_needed_title", "string", packageName2);
                int identifier6 = resources2.getIdentifier("install_needed_message", "string", packageName2);
                int identifier7 = resources2.getIdentifier("install_cancel", "string", packageName2);
                int identifier8 = resources2.getIdentifier("install_yes", "string", packageName2);
                displayGCMDialog(identifier5 != 0 ? this.mContext.getString(identifier5) : "Additional App Required", identifier6 != 0 ? this.mContext.getString(identifier6) : "Garmin Connect Mobile is required to use this application. Would you like to install it now?", identifier7 != 0 ? this.mContext.getString(identifier7) : "Cancel", identifier8 != 0 ? this.mContext.getString(identifier8) : "Yes");
            }
            ConnectIQ.ConnectIQListener connectIQListener3 = this.mListener;
            if (connectIQListener3 != null) {
                connectIQListener3.onInitializeError(ConnectIQ.IQSdkErrorStatus.GCM_NOT_INSTALLED);
            }
            super.initialize(context, z, connectIQListener);
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void registerForRemoteAppEvents(IQApp iQApp) throws InvalidStateException, ServiceUnavailableException {
        verifyInitialized();
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        try {
            this.mRemoteService.registerApp(iQApp, "com.garmin.android.connectiq.INCOMING_MESSAGE", this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void sendMessageProtocol(IQDevice iQDevice, IQApp iQApp, byte[] bArr, ConnectIQ.IQSendMessageListener iQSendMessageListener, boolean z) throws ServiceUnavailableException, InvalidStateException {
        verifyInitialized();
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        if (iQDevice == null) {
            if (iQSendMessageListener != null) {
                iQSendMessageListener.onMessageStatus(iQDevice, iQApp, ConnectIQ.IQMessageStatus.FAILURE_INVALID_DEVICE);
                return;
            }
            return;
        }
        IQDeviceListenerContainer deviceListenerContainer = getMessageReceiver().getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer != null) {
            deviceListenerContainer.setSendMessageListener(iQApp.getApplicationId(), iQSendMessageListener);
        } else {
            IQDeviceListenerContainer iQDeviceListenerContainer = new IQDeviceListenerContainer(iQDevice.getDeviceIdentifier());
            iQDeviceListenerContainer.setSendMessageListener(iQApp.getApplicationId(), iQSendMessageListener);
            getMessageReceiver().addDeviceListenerContainer(iQDevice.getDeviceIdentifier(), iQDeviceListenerContainer);
        }
        IQMessage iQMessage = new IQMessage(bArr, this.mContext.getPackageName(), "com.garmin.android.connectiq.SEND_MESSAGE_STATUS");
        IConnectIQService iConnectIQService = this.mRemoteService;
        try {
            if (z) {
                iConnectIQService.sendTransientMessage(iQMessage, iQDevice, iQApp);
            } else {
                iConnectIQService.sendMessage(iQMessage, iQDevice, iQApp);
            }
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void shutdown(Context context) {
        super.shutdown(context);
        if (this.mBound) {
            this.mContext.unbindService(this.mConnection);
        }
    }

    @Override // com.garmin.android.connectiq.ConnectIQ
    public void unregisterForRemoteAppEvents(IQApp iQApp) throws InvalidStateException, ServiceUnavailableException {
        verifyInitialized();
        if (!this.mBound) {
            throw new InvalidStateException("SDK not initialized.  Did you forget to call ConnectIQ::initialize()?");
        }
        try {
            this.mRemoteService.unregisterApp(iQApp, this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }
    }
}
