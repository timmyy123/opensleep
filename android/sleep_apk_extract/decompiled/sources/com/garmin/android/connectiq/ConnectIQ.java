package com.garmin.android.connectiq;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.exception.InvalidStateException;
import com.garmin.android.connectiq.exception.ServiceUnavailableException;
import com.garmin.monkeybrains.serialization.Serializer;
import com.urbandroid.sleep.smartwatch.garmin.CIQManager;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectIQ {
    protected static IQConnectType sConnectType = IQConnectType.WIRELESS;
    protected static ConnectIQ sInstance;
    protected Context mContext;
    private Handler mHandler;
    protected ConnectIQListener mListener;
    private IQMessageReceiver mMessageReceiver;
    protected boolean mInitialized = false;
    private boolean mUsingBinderService = false;
    private IQApplicationEventListener mBindingServiceApplicationEventListener = null;

    public interface ConnectIQListener {
        void onInitializeError(IQSdkErrorStatus iQSdkErrorStatus);

        void onSdkReady();

        void onSdkShutDown();
    }

    public interface IQApplicationEventListener {
        void onMessageReceived(IQDevice iQDevice, IQApp iQApp, List<Object> list, IQMessageStatus iQMessageStatus);
    }

    public interface IQApplicationInfoListener {
        void onApplicationInfoReceived(IQApp iQApp);

        void onApplicationNotInstalled(String str);
    }

    public enum IQConnectType {
        TETHERED,
        WIRELESS
    }

    public interface IQDeviceEventListener {
    }

    public enum IQMessageStatus {
        SUCCESS,
        FAILURE_UNKNOWN,
        FAILURE_INVALID_FORMAT,
        FAILURE_MESSAGE_TOO_LARGE,
        FAILURE_UNSUPPORTED_TYPE,
        FAILURE_DURING_TRANSFER,
        FAILURE_INVALID_DEVICE,
        FAILURE_DEVICE_NOT_CONNECTED
    }

    public interface IQOpenApplicationListener {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public enum IQOpenApplicationStatus {
        PROMPT_SHOWN_ON_DEVICE,
        PROMPT_NOT_SHOWN_ON_DEVICE,
        APP_IS_NOT_INSTALLED,
        APP_IS_ALREADY_RUNNING,
        UNKNOWN_FAILURE;

        public static IQOpenApplicationStatus fromInt(int i) {
            return i < values().length + (-1) ? values()[i] : UNKNOWN_FAILURE;
        }
    }

    public enum IQSdkErrorStatus {
        GCM_NOT_INSTALLED,
        GCM_UPGRADE_NEEDED,
        SERVICE_ERROR
    }

    public interface IQSendMessageListener {
        void onMessageStatus(IQDevice iQDevice, IQApp iQApp, IQMessageStatus iQMessageStatus);
    }

    public static ConnectIQ getInstance() {
        if (sInstance == null) {
            if (sConnectType.ordinal() != 0) {
                sInstance = new ConnectIQDeviceStrategy();
            } else {
                sInstance = new ConnectIQAdbStrategy();
            }
        }
        return sInstance;
    }

    public void deviceStatusChanged(final IQDevice iQDevice, final IQDevice.IQDeviceStatus iQDeviceStatus) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.garmin.android.connectiq.ConnectIQ.2
                @Override // java.lang.Runnable
                public void run() {
                    IQDeviceListenerContainer deviceListenerContainer = ConnectIQ.this.mMessageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
                    if (deviceListenerContainer == null || deviceListenerContainer.getDeviceListener() == null) {
                        return;
                    }
                    CIQManager.lambda$registerDeviceStatusReceiver$0(iQDevice, iQDeviceStatus);
                }
            });
        }
    }

    public void displayGCMDialog(final String str, final String str2, final String str3, final String str4) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.garmin.android.connectiq.ConnectIQ.1
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent(ConnectIQ.this.mContext, (Class<?>) AutoUIDialogHostActivity.class);
                    intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                    intent.putExtra("EXTRA_DIALOG_TITLE", str);
                    intent.putExtra("EXTRA_DIALOG_MESSAGE", str2);
                    intent.putExtra("EXTRA_DIALOG_NEGATIVE_BUTTON_TEXT", str3);
                    intent.putExtra("EXTRA_DIALOG_POSITIVE_BUTTON_TEXT", str4);
                    ConnectIQ.this.mContext.startActivity(intent);
                }
            });
        }
    }

    public IQApplicationEventListener getApplicationEventListener() {
        return this.mBindingServiceApplicationEventListener;
    }

    public abstract void getApplicationInfo(String str, IQDevice iQDevice, IQApplicationInfoListener iQApplicationInfoListener);

    public abstract List<IQDevice> getConnectedDevices();

    public abstract IQDevice.IQDeviceStatus getDeviceStatus(IQDevice iQDevice);

    public final IQMessageReceiver getMessageReceiver() {
        return this.mMessageReceiver;
    }

    public void initialize(Context context, boolean z, ConnectIQListener connectIQListener) {
        this.mContext = context;
        this.mListener = connectIQListener;
        this.mHandler = new Handler();
        this.mMessageReceiver = new IQMessageReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.garmin.android.connectiq.APPLICATION_INFO");
        intentFilter.addAction("com.garmin.android.connectiq.OPEN_APPLICATION");
        intentFilter.addAction("com.garmin.android.connectiq.SEND_MESSAGE_STATUS");
        intentFilter.addAction("com.garmin.android.connectiq.DEVICE_STATUS");
        intentFilter.addAction("com.garmin.android.connectiq.INCOMING_MESSAGE");
        int i = Build.VERSION.SDK_INT;
        IQMessageReceiver iQMessageReceiver = this.mMessageReceiver;
        if (i >= 33) {
            context.registerReceiver(iQMessageReceiver, intentFilter, 2);
        } else {
            context.registerReceiver(iQMessageReceiver, intentFilter);
        }
        this.mInitialized = true;
    }

    public void registerForAppEvents(IQDevice iQDevice, IQApp iQApp, IQApplicationEventListener iQApplicationEventListener) {
        verifyInitialized();
        try {
            registerForRemoteAppEvents(iQApp);
        } catch (InvalidStateException unused) {
        }
        IQDeviceListenerContainer deviceListenerContainer = this.mMessageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer == null) {
            IQDeviceListenerContainer iQDeviceListenerContainer = new IQDeviceListenerContainer(iQDevice.getDeviceIdentifier());
            iQDeviceListenerContainer.setAppListener(iQApp.getApplicationId(), iQApplicationEventListener);
            this.mMessageReceiver.addDeviceListenerContainer(iQDevice.getDeviceIdentifier(), iQDeviceListenerContainer);
        } else if (deviceListenerContainer.getAppListener(iQApp.getApplicationId()) != iQApplicationEventListener) {
            deviceListenerContainer.setAppListener(iQApp.getApplicationId(), iQApplicationEventListener);
        }
    }

    public void registerForDeviceEvents(IQDevice iQDevice, IQDeviceEventListener iQDeviceEventListener) {
        verifyInitialized();
        IQDeviceListenerContainer deviceListenerContainer = this.mMessageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer != null) {
            if (deviceListenerContainer.getDeviceListener() != iQDeviceEventListener) {
                deviceListenerContainer.setDeviceListener(iQDeviceEventListener);
                return;
            }
            return;
        }
        IQDeviceListenerContainer iQDeviceListenerContainer = new IQDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        iQDeviceListenerContainer.setDeviceListener(iQDeviceEventListener);
        this.mMessageReceiver.addDeviceListenerContainer(iQDevice.getDeviceIdentifier(), iQDeviceListenerContainer);
        if (iQDeviceEventListener != null) {
            IQDevice.IQDeviceStatus deviceStatus = IQDevice.IQDeviceStatus.UNKNOWN;
            try {
                deviceStatus = getDeviceStatus(iQDevice);
            } catch (InvalidStateException unused) {
            } catch (ServiceUnavailableException unused2) {
                deviceStatus = IQDevice.IQDeviceStatus.NOT_CONNECTED;
            }
            CIQManager.lambda$registerDeviceStatusReceiver$0(iQDevice, deviceStatus);
        }
    }

    public abstract void registerForRemoteAppEvents(IQApp iQApp);

    public void sendMessage(IQDevice iQDevice, IQApp iQApp, Object obj, IQSendMessageListener iQSendMessageListener) {
        byte[] bArrSerialize;
        verifyInitialized();
        try {
            bArrSerialize = Serializer.serialize(obj);
        } catch (Exception unused) {
            if (iQSendMessageListener != null) {
                iQSendMessageListener.onMessageStatus(iQDevice, iQApp, IQMessageStatus.FAILURE_INVALID_FORMAT);
            }
            bArrSerialize = null;
        }
        byte[] bArr = bArrSerialize;
        if (bArr != null) {
            sendMessage(iQDevice, iQApp, bArr, iQSendMessageListener, false);
        }
    }

    public abstract void sendMessageProtocol(IQDevice iQDevice, IQApp iQApp, byte[] bArr, IQSendMessageListener iQSendMessageListener, boolean z);

    public void shutdown(Context context) {
        unregisterAllForEvents();
        this.mMessageReceiver.clearApiCallbackListeners();
        ConnectIQListener connectIQListener = this.mListener;
        if (connectIQListener != null) {
            connectIQListener.onSdkShutDown();
        }
        if (!this.mUsingBinderService) {
            context.unregisterReceiver(this.mMessageReceiver);
        }
        this.mMessageReceiver = null;
        this.mBindingServiceApplicationEventListener = null;
        this.mInitialized = false;
    }

    public void unregisterAllForEvents() {
        verifyInitialized();
        this.mMessageReceiver.clearDeviceAndAppListeners();
    }

    public void unregisterForApplicationEvents(IQDevice iQDevice, IQApp iQApp) {
        verifyInitialized();
        if (this.mUsingBinderService) {
            throw new InvalidStateException("Cannot unregister for application events per device when using the binder service. Use unregisterForAppEvents(IQApp) instead.");
        }
        try {
            unregisterForRemoteAppEvents(iQApp);
        } catch (InvalidStateException unused) {
        }
        IQDeviceListenerContainer deviceListenerContainer = this.mMessageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer != null) {
            deviceListenerContainer.clearAppListeners();
        }
    }

    public void unregisterForDeviceEvents(IQDevice iQDevice) {
        verifyInitialized();
        IQDeviceListenerContainer deviceListenerContainer = this.mMessageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
        if (deviceListenerContainer != null) {
            deviceListenerContainer.clearDeviceListener();
        }
    }

    public abstract void unregisterForRemoteAppEvents(IQApp iQApp);

    public void verifyInitialized() {
        if (!this.mInitialized) {
            throw new InvalidStateException("SDK not initialized");
        }
    }

    private void sendMessage(IQDevice iQDevice, IQApp iQApp, byte[] bArr, IQSendMessageListener iQSendMessageListener, boolean z) {
        if (bArr.length > 16384 && iQSendMessageListener != null) {
            iQSendMessageListener.onMessageStatus(iQDevice, iQApp, IQMessageStatus.FAILURE_MESSAGE_TOO_LARGE);
        }
        sendMessageProtocol(iQDevice, iQApp, bArr, iQSendMessageListener, z);
    }

    public static ConnectIQ getInstance(Context context, IQConnectType iQConnectType) {
        ConnectIQ connectIQ = sInstance;
        if (connectIQ != null && sConnectType != iQConnectType) {
            try {
                connectIQ.shutdown(context);
            } catch (InvalidStateException unused) {
            }
            sInstance = null;
        }
        sConnectType = iQConnectType;
        return getInstance();
    }
}
