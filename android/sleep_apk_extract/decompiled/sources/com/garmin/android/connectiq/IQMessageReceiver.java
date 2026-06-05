package com.garmin.android.connectiq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.monkeybrains.serialization.MonkeyType;
import com.garmin.monkeybrains.serialization.Serializer;
import com.urbandroid.sleep.smartwatch.garmin.CIQManager;
import com.urbandroid.sleep.smartwatch.garmin.MessageHandler$$ExternalSyntheticLambda0;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class IQMessageReceiver extends BroadcastReceiver {
    private final HashMap<Long, IQDeviceListenerContainer> mDeviceListenerContainers = new HashMap<>();

    public void addDeviceListenerContainer(long j, IQDeviceListenerContainer iQDeviceListenerContainer) {
        this.mDeviceListenerContainers.put(Long.valueOf(j), iQDeviceListenerContainer);
    }

    public void clearApiCallbackListeners() {
        for (IQDeviceListenerContainer iQDeviceListenerContainer : this.mDeviceListenerContainers.values()) {
            iQDeviceListenerContainer.clearApplicationInfoListeners();
            iQDeviceListenerContainer.clearOpenApplicationListeners();
            iQDeviceListenerContainer.clearSendMessageListeners();
        }
    }

    public void clearDeviceAndAppListeners() {
        for (IQDeviceListenerContainer iQDeviceListenerContainer : this.mDeviceListenerContainers.values()) {
            iQDeviceListenerContainer.clearDeviceListener();
            iQDeviceListenerContainer.clearAppListeners();
        }
    }

    public IQDeviceListenerContainer getDeviceListenerContainer(long j) {
        return this.mDeviceListenerContainers.get(Long.valueOf(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        IQDevice iQDevice = intent.getAction().equals("com.garmin.android.connectiq.OPEN_APPLICATION") ? (IQDevice) intent.getParcelableExtra("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_DEVICE") : (IQDevice) intent.getParcelableExtra("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
        if (iQDevice == null) {
            return;
        }
        IQDeviceListenerContainer iQDeviceListenerContainer = this.mDeviceListenerContainers.get(Long.valueOf(iQDevice.getDeviceIdentifier()));
        ConnectIQ.IQDeviceEventListener deviceListener = null;
        applicationInfoListener = null;
        ConnectIQ.IQApplicationInfoListener applicationInfoListener = null;
        openApplicationListener = null;
        ConnectIQ.IQOpenApplicationListener openApplicationListener = null;
        if (!intent.getAction().equals("com.garmin.android.connectiq.INCOMING_MESSAGE")) {
            if (intent.getAction().equals("com.garmin.android.connectiq.DEVICE_STATUS")) {
                IQDevice.IQDeviceStatus iQDeviceStatus = IQDevice.IQDeviceStatus.UNKNOWN;
                try {
                    iQDeviceStatus = IQDevice.IQDeviceStatus.values()[intent.getIntExtra("com.garmin.android.connectiq.EXTRA_STATUS", iQDeviceStatus.ordinal())];
                } catch (IndexOutOfBoundsException unused) {
                }
                if (iQDeviceListenerContainer != null) {
                    deviceListener = iQDeviceListenerContainer.getDeviceListener();
                    if (iQDeviceStatus != IQDevice.IQDeviceStatus.CONNECTED) {
                        iQDeviceListenerContainer.clearApplicationInfoListeners();
                        iQDeviceListenerContainer.clearOpenApplicationListeners();
                        iQDeviceListenerContainer.clearSendMessageListeners();
                    }
                }
                if (deviceListener != null) {
                    CIQManager.lambda$registerDeviceStatusReceiver$0(iQDevice, iQDeviceStatus);
                    return;
                }
                return;
            }
            if (intent.getAction().equals("com.garmin.android.connectiq.APPLICATION_INFO")) {
                String stringExtra = intent.getStringExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_ID");
                int intExtra = intent.getIntExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_VERSION", 65535);
                if (iQDeviceListenerContainer != null && stringExtra != null) {
                    applicationInfoListener = iQDeviceListenerContainer.getApplicationInfoListener(stringExtra);
                }
                if (applicationInfoListener != null) {
                    if (intExtra < 0 || 65535 == intExtra) {
                        applicationInfoListener.onApplicationNotInstalled(stringExtra);
                        return;
                    } else {
                        applicationInfoListener.onApplicationInfoReceived(new IQApp(stringExtra, intExtra));
                        return;
                    }
                }
                return;
            }
            if (!intent.getAction().equals("com.garmin.android.connectiq.OPEN_APPLICATION")) {
                if (intent.getAction().equals("com.garmin.android.connectiq.SEND_MESSAGE_STATUS")) {
                    int intExtra2 = intent.getIntExtra("com.garmin.android.connectiq.EXTRA_STATUS", 0);
                    String stringExtra2 = intent.getStringExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_ID");
                    ConnectIQ.IQSendMessageListener sendMessageListener = iQDeviceListenerContainer != null ? iQDeviceListenerContainer.getSendMessageListener(stringExtra2) : null;
                    if (sendMessageListener != null) {
                        sendMessageListener.onMessageStatus(iQDevice, new IQApp(stringExtra2), intExtra2 == 0 ? ConnectIQ.IQMessageStatus.SUCCESS : ConnectIQ.IQMessageStatus.FAILURE_DURING_TRANSFER);
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra3 = intent.getStringExtra("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_ID");
            int intExtra3 = intent.getIntExtra("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_RESULT_CODE", -1);
            if (iQDeviceListenerContainer != null && stringExtra3 != null) {
                openApplicationListener = iQDeviceListenerContainer.getOpenApplicationListener(stringExtra3);
            }
            if (openApplicationListener == null || intExtra3 < 0) {
                return;
            }
            ((MessageHandler$$ExternalSyntheticLambda0) openApplicationListener).onOpenApplicationResponse(iQDevice, new IQApp(stringExtra3), ConnectIQ.IQOpenApplicationStatus.fromInt(intExtra3));
            return;
        }
        IQApp iQApp = (IQApp) intent.getParcelableExtra("com.garmin.android.connectiq.EXTRA_REMOTE_APPLICATION");
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.garmin.android.connectiq.EXTRA_PAYLOAD");
        ConnectIQ.IQApplicationEventListener appListener = iQDeviceListenerContainer != null ? iQDeviceListenerContainer.getAppListener(iQApp.getApplicationId()) : null;
        if (byteArrayExtra == null && appListener != null) {
            appListener.onMessageReceived(iQDevice, iQApp, null, ConnectIQ.IQMessageStatus.FAILURE_UNKNOWN);
        }
        try {
            List<MonkeyType<?>> listDeserialize = Serializer.deserialize(byteArrayExtra);
            ArrayList arrayList = new ArrayList();
            Iterator<MonkeyType<?>> it = listDeserialize.iterator();
            while (it.hasNext()) {
                arrayList.add(IQMessageHelper.INSTANCE.convertToJava(it.next()));
            }
            if (appListener != null) {
                appListener.onMessageReceived(iQDevice, iQApp, arrayList, ConnectIQ.IQMessageStatus.SUCCESS);
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            Log.e("RemoteMessageReceiver", "Error deserializing message", e);
            if (appListener == null) {
                appListener.onMessageReceived(iQDevice, iQApp, null, ConnectIQ.IQMessageStatus.FAILURE_INVALID_FORMAT);
            }
        } catch (BufferUnderflowException e2) {
            e = e2;
            Log.e("RemoteMessageReceiver", "Error deserializing message", e);
            if (appListener == null) {
            }
        }
    }
}
