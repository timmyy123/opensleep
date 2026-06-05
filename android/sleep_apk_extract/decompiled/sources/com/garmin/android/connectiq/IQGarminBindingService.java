package com.garmin.android.connectiq;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.garmin.android.apps.connectmobile.connectiq.ICompanionAppService;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.IQGarminBindingService;
import com.garmin.monkeybrains.serialization.MonkeyType;
import com.garmin.monkeybrains.serialization.Serializer;
import com.urbandroid.sleep.smartwatch.garmin.CIQManager;
import com.urbandroid.sleep.smartwatch.garmin.MessageHandler$$ExternalSyntheticLambda0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class IQGarminBindingService extends Service {
    private final ICompanionAppService.Stub mBinder = new AnonymousClass1();

    /* JADX INFO: renamed from: com.garmin.android.connectiq.IQGarminBindingService$1, reason: invalid class name */
    public class AnonymousClass1 extends ICompanionAppService.Stub {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$transferData$0(ConnectIQ.IQApplicationEventListener iQApplicationEventListener, IQDevice iQDevice, IQApp iQApp, List list) {
            iQApplicationEventListener.onMessageReceived(iQDevice, iQApp, list, ConnectIQ.IQMessageStatus.SUCCESS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$transferData$1(ConnectIQ.IQApplicationEventListener iQApplicationEventListener, IQDevice iQDevice, IQApp iQApp) {
            iQApplicationEventListener.onMessageReceived(iQDevice, iQApp, null, ConnectIQ.IQMessageStatus.FAILURE_INVALID_FORMAT);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.garmin.android.apps.connectmobile.connectiq.ICompanionAppService
        public String transferData(String str) {
            IQMessageReceiver messageReceiver = ConnectIQ.getInstance().getMessageReceiver();
            try {
                IQTrustedGarminPackageVerifier.INSTANCE.enforceTrustedPackage(IQGarminBindingService.this.getApplicationContext());
                Handler handler = new Handler(Looper.getMainLooper());
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("action");
                ConnectIQ.IQDeviceEventListener deviceListener = null;
                switch (string.hashCode()) {
                    case -714652129:
                        if (string.equals("com.garmin.android.connectiq.SEND_MESSAGE_STATUS")) {
                            if (messageReceiver == null) {
                                Log.w("IQGarminBindingService", "IQMessageReceiver is not set.");
                            } else {
                                String string2 = jSONObject.getString("com.garmin.android.connectiq.EXTRA_APPLICATION_ID");
                                JSONObject jSONObject2 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
                                int iOptInt = jSONObject.optInt("com.garmin.android.connectiq.EXTRA_STATUS");
                                IQDevice iQDevice = new IQDevice(jSONObject2.getLong("deviceIdentifier"), jSONObject2.getString("friendlyName"));
                                IQDeviceListenerContainer deviceListenerContainer = messageReceiver.getDeviceListenerContainer(iQDevice.getDeviceIdentifier());
                                ConnectIQ.IQSendMessageListener sendMessageListener = deviceListenerContainer != null ? deviceListenerContainer.getSendMessageListener(string2) : null;
                                if (sendMessageListener != null) {
                                    sendMessageListener.onMessageStatus(iQDevice, new IQApp(string2), iOptInt == 0 ? ConnectIQ.IQMessageStatus.SUCCESS : ConnectIQ.IQMessageStatus.FAILURE_DURING_TRANSFER);
                                }
                            }
                        }
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                    case 123764816:
                        if (string.equals("com.garmin.android.connectiq.INCOMING_MESSAGE")) {
                            final ConnectIQ.IQApplicationEventListener applicationEventListener = ConnectIQ.getInstance().getApplicationEventListener();
                            if (applicationEventListener == null) {
                                Log.w("IQGarminBindingService", "Application event listener is not set.");
                            } else {
                                JSONObject jSONObject3 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_REMOTE_APPLICATION");
                                JSONObject jSONObject4 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
                                final IQApp iQApp = new IQApp(jSONObject3.getString("applicationId"));
                                final IQDevice iQDevice2 = new IQDevice(jSONObject4.getLong("deviceIdentifier"), jSONObject4.getString("friendlyName"));
                                JSONArray jSONArray = new JSONArray(jSONObject.getString("com.garmin.android.connectiq.EXTRA_PAYLOAD"));
                                int length = jSONArray.length();
                                byte[] bArr = new byte[length];
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    bArr[i] = (byte) jSONArray.getInt(i);
                                }
                                if (length == 0) {
                                    applicationEventListener.onMessageReceived(iQDevice2, iQApp, null, ConnectIQ.IQMessageStatus.FAILURE_UNKNOWN);
                                }
                                try {
                                    List<MonkeyType<?>> listDeserialize = Serializer.deserialize(bArr);
                                    final ArrayList arrayList = new ArrayList();
                                    Iterator<MonkeyType<?>> it = listDeserialize.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(IQMessageHelper.INSTANCE.convertToJava(it.next()));
                                    }
                                    handler.post(new Runnable() { // from class: com.garmin.android.connectiq.IQGarminBindingService$1$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            IQGarminBindingService.AnonymousClass1.lambda$transferData$0(applicationEventListener, iQDevice2, iQApp, arrayList);
                                        }
                                    });
                                } catch (UnsupportedEncodingException e) {
                                    Log.e("IQGarminBindingService", "Error deserializing message", e);
                                    handler.post(new Runnable() { // from class: com.garmin.android.connectiq.IQGarminBindingService$1$$ExternalSyntheticLambda1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            IQGarminBindingService.AnonymousClass1.lambda$transferData$1(applicationEventListener, iQDevice2, iQApp);
                                        }
                                    });
                                    return "com.garmin.android.connectiq.EXTRA_STATUS_SUCCESS";
                                }
                            }
                        }
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                    case 1314382397:
                        if (string.equals("com.garmin.android.connectiq.OPEN_APPLICATION")) {
                            if (messageReceiver == null) {
                                Log.w("IQGarminBindingService", "IQMessageReceiver is not set.");
                            } else {
                                String string3 = jSONObject.getString("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_ID");
                                JSONObject jSONObject5 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_DEVICE");
                                IQDevice iQDevice3 = new IQDevice(jSONObject5.getLong("deviceIdentifier"), jSONObject5.getString("friendlyName"));
                                int iOptInt2 = jSONObject.optInt("com.garmin.android.connectiq.EXTRA_OPEN_APPLICATION_RESULT_CODE", -1);
                                IQDeviceListenerContainer deviceListenerContainer2 = messageReceiver.getDeviceListenerContainer(iQDevice3.getDeviceIdentifier());
                                ConnectIQ.IQOpenApplicationListener openApplicationListener = deviceListenerContainer2 != null ? deviceListenerContainer2.getOpenApplicationListener(string3) : null;
                                if (openApplicationListener != null && iOptInt2 >= 0) {
                                    ((MessageHandler$$ExternalSyntheticLambda0) openApplicationListener).onOpenApplicationResponse(iQDevice3, new IQApp(string3), ConnectIQ.IQOpenApplicationStatus.fromInt(iOptInt2));
                                }
                            }
                        }
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                    case 1800512991:
                        if (string.equals("com.garmin.android.connectiq.APPLICATION_INFO")) {
                            if (messageReceiver == null) {
                                Log.w("IQGarminBindingService", "IQMessageReceiver is not set.");
                            } else {
                                String string4 = jSONObject.getString("com.garmin.android.connectiq.EXTRA_APPLICATION_ID");
                                JSONObject jSONObject6 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
                                IQDevice iQDevice4 = new IQDevice(jSONObject6.getLong("deviceIdentifier"), jSONObject6.getString("friendlyName"));
                                int iOptInt3 = jSONObject.optInt("com.garmin.android.connectiq.EXTRA_APPLICATION_VERSION", 65535);
                                IQDeviceListenerContainer deviceListenerContainer3 = messageReceiver.getDeviceListenerContainer(iQDevice4.getDeviceIdentifier());
                                ConnectIQ.IQApplicationInfoListener applicationInfoListener = deviceListenerContainer3 != null ? deviceListenerContainer3.getApplicationInfoListener(string4) : null;
                                if (applicationInfoListener != null) {
                                    if (iOptInt3 < 0 || 65535 == iOptInt3) {
                                        applicationInfoListener.onApplicationNotInstalled(string4);
                                    } else {
                                        applicationInfoListener.onApplicationInfoReceived(new IQApp(string4, iOptInt3));
                                    }
                                }
                            }
                        }
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                    case 2109543865:
                        if (string.equals("com.garmin.android.connectiq.DEVICE_STATUS")) {
                            if (messageReceiver == null) {
                                Log.w("IQGarminBindingService", "IQMessageReceiver is not set.");
                            } else {
                                JSONObject jSONObject7 = jSONObject.getJSONObject("com.garmin.android.connectiq.EXTRA_REMOTE_DEVICE");
                                IQDevice.IQDeviceStatus iQDeviceStatus = IQDevice.IQDeviceStatus.UNKNOWN;
                                int iOptInt4 = jSONObject.optInt("com.garmin.android.connectiq.EXTRA_STATUS", iQDeviceStatus.ordinal());
                                IQDevice iQDevice5 = new IQDevice(jSONObject7.getLong("deviceIdentifier"), jSONObject7.getString("friendlyName"));
                                try {
                                    iQDeviceStatus = IQDevice.IQDeviceStatus.values()[iOptInt4];
                                } catch (IndexOutOfBoundsException unused) {
                                    Log.w("IQGarminBindingService", "Invalid device status value: " + iOptInt4 + ", defaulting to UNKNOWN.");
                                }
                                IQDeviceListenerContainer deviceListenerContainer4 = messageReceiver.getDeviceListenerContainer(iQDevice5.getDeviceIdentifier());
                                if (deviceListenerContainer4 != null) {
                                    deviceListener = deviceListenerContainer4.getDeviceListener();
                                    if (iQDeviceStatus != IQDevice.IQDeviceStatus.CONNECTED) {
                                        deviceListenerContainer4.clearApplicationInfoListeners();
                                        deviceListenerContainer4.clearOpenApplicationListeners();
                                        deviceListenerContainer4.clearSendMessageListeners();
                                    }
                                }
                                if (deviceListener != null) {
                                    CIQManager.lambda$registerDeviceStatusReceiver$0(iQDevice5, iQDeviceStatus);
                                }
                            }
                        }
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                    default:
                        Log.e("IQGarminBindingService", "Unknown action received: ".concat(string));
                        break;
                }
                return "com.garmin.android.connectiq.EXTRA_STATUS_SUCCESS";
            } catch (SecurityException unused2) {
                Log.d("IQGarminBindingService", "Security exception");
                return "Security exception";
            } catch (JSONException e2) {
                Log.d("IQGarminBindingService", "JSON parsing error: " + e2.getMessage(), e2);
                return "Invalid JSON payload: " + e2.getMessage();
            } catch (Exception e3) {
                Log.e("IQGarminBindingService", "Unexpected error: " + e3.getMessage(), e3);
                return "Unexpected error: " + e3.getMessage();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("IQGarminBindingService", "onBind called.");
        return this.mBinder;
    }
}
