package com.urbandroid.sleep.smartwatch.garmin;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.widget.Toast;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.ConnectIQAdbStrategy;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.exception.InvalidStateException;
import com.garmin.android.connectiq.exception.ServiceUnavailableException;
import com.urbandroid.common.logging.Logger;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
public class CIQManager {
    private static final CIQManager ourInstance = new CIQManager();
    private IQApp activeApp;
    private ConnectIQ connectIQ;
    private Boolean connectIqInitializing;
    public Boolean connectIqReady;
    private Context context;
    private IQDevice deviceCache;
    private boolean didRedirectToStore;

    /* JADX INFO: renamed from: -$$Nest$fputconnectIqInitializing, reason: not valid java name */
    public static /* bridge */ /* synthetic */ void m2101$$Nest$fputconnectIqInitializing(CIQManager cIQManager) {
        cIQManager.connectIqInitializing = Boolean.FALSE;
    }

    private CIQManager() {
        Boolean bool = Boolean.FALSE;
        this.connectIqReady = bool;
        this.connectIqInitializing = bool;
        this.didRedirectToStore = false;
        this.activeApp = null;
    }

    private IQDevice getDevice(ConnectIQ connectIQ) {
        try {
            List<IQDevice> connectedDevices = connectIQ.getConnectedDevices();
            if (connectedDevices == null || connectedDevices.size() <= 0) {
                return this.deviceCache;
            }
            Logger.logDebug("Garmin: CIQManager: getDevice connected: " + connectedDevices.get(0).toString());
            IQDevice iQDevice = connectedDevices.get(0);
            this.deviceCache = iQDevice;
            return iQDevice;
        } catch (InvalidStateException e) {
            Logger.logSevere(e);
            return null;
        } catch (ServiceUnavailableException e2) {
            Logger.logSevere(e2);
            return null;
        }
    }

    public static CIQManager getInstance() {
        return ourInstance;
    }

    private static Context initializeConnectIQWrapped(Context context, ConnectIQ connectIQ, boolean z, ConnectIQ.ConnectIQListener connectIQListener) {
        if (connectIQ instanceof ConnectIQAdbStrategy) {
            connectIQ.initialize(context, z, connectIQListener);
            return context;
        }
        ContextWrapper contextWrapper = new ContextWrapper(context) { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager.2
            private HashMap<BroadcastReceiver, BroadcastReceiver> receiverToWrapper = new HashMap<>();

            @Override // android.content.ContextWrapper, android.content.Context
            public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
                IQMessageReceiverWrapper iQMessageReceiverWrapper = new IQMessageReceiverWrapper(broadcastReceiver);
                synchronized (this.receiverToWrapper) {
                    this.receiverToWrapper.put(broadcastReceiver, iQMessageReceiverWrapper);
                }
                return super.registerReceiver(iQMessageReceiverWrapper, intentFilter);
            }

            @Override // android.content.ContextWrapper, android.content.Context
            public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
                BroadcastReceiver broadcastReceiver2;
                synchronized (this.receiverToWrapper) {
                    broadcastReceiver2 = this.receiverToWrapper.get(broadcastReceiver);
                    this.receiverToWrapper.remove(broadcastReceiver);
                }
                if (broadcastReceiver2 != null) {
                    super.unregisterReceiver(broadcastReceiver2);
                }
            }
        };
        connectIQ.initialize(contextWrapper, z, connectIQListener);
        return contextWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isWatchAppAvailable() {
        try {
            this.connectIQ.getApplicationInfo("1FC99D3F06FE4B02BBABD497CB05874B", getDevice(), new ConnectIQ.IQApplicationInfoListener() { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager.3
                @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationInfoListener
                public void onApplicationInfoReceived(IQApp iQApp) {
                    Logger.logInfo("Garmin: active app " + iQApp.getApplicationId());
                    CIQManager.this.activeApp = iQApp;
                    MessageHandler.sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.CONFIRM_CONNECTED"), CIQManager.this.context);
                }

                @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationInfoListener
                public void onApplicationNotInstalled(String str) {
                    Logger.logInfo("Garmin: not installed " + str);
                    if (CIQManager.getInstance().getDevice() != null) {
                        if (!CIQManager.this.didRedirectToStore) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://apps.garmin.com/apps/" + str));
                            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                            try {
                                CIQManager.this.context.startActivity(intent);
                            } catch (ActivityNotFoundException unused) {
                            }
                            CIQManager.this.didRedirectToStore = true;
                        }
                        Toast.makeText(CIQManager.this.context, "Sleep NEW not installed on your Garmin watch", 1).show();
                        Logger.logDebug("Garmin: CIQManager: Sleep NEW watch app not installed.");
                    }
                }
            });
            this.connectIQ.getApplicationInfo("21CAD9617B914811B0B27EA6240DE29B", getDevice(), new ConnectIQ.IQApplicationInfoListener() { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager.4
                @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationInfoListener
                public void onApplicationInfoReceived(IQApp iQApp) {
                    Logger.logInfo("Garmin: old app installed " + iQApp.getApplicationId());
                    if (CIQManager.this.activeApp == null) {
                        Logger.logInfo("Garmin: setting old as active ");
                        CIQManager.this.activeApp = iQApp;
                        MessageHandler.sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.CONFIRM_CONNECTED"), CIQManager.this.context);
                    }
                }

                @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationInfoListener
                public void onApplicationNotInstalled(String str) {
                    Logger.logDebug("Garmin: CIQManager: Sleep OLD watch app not installed.");
                }
            });
        } catch (InvalidStateException | ServiceUnavailableException e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerDeviceStatusReceiver$0(IQDevice iQDevice, IQDevice.IQDeviceStatus iQDeviceStatus) {
        Logger.logDebug("Garmin: CIQManager: Device status changed, now " + iQDeviceStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerWatchMessagesReceiver$1(IQDevice iQDevice, IQApp iQApp, List list, ConnectIQ.IQMessageStatus iQMessageStatus) {
        if (iQMessageStatus == ConnectIQ.IQMessageStatus.SUCCESS) {
            MessageHandler.getInstance().handleMessageFromWatchUsingCIQ(list, iQMessageStatus, this.context);
            return;
        }
        Logger.logDebug("Garmin: CIQManager: onMessageReceived error, status: " + iQMessageStatus.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerWatchMessagesReceiver$2(IQDevice iQDevice, IQApp iQApp, List list, ConnectIQ.IQMessageStatus iQMessageStatus) {
        if (iQMessageStatus == ConnectIQ.IQMessageStatus.SUCCESS) {
            MessageHandler.getInstance().handleMessageFromWatchUsingCIQ(list, iQMessageStatus, this.context);
            return;
        }
        Logger.logDebug("Garmin: CIQManager: onMessageReceived error, status: " + iQMessageStatus.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerDeviceStatusReceiver() {
        Logger.logDebug("Garmin: CIQManager: registerDeviceStatusReceiver");
        IQDevice device = getInstance().getDevice();
        if (device != null) {
            try {
                this.connectIQ.registerForDeviceEvents(device, new Events$$ExternalSyntheticBUOutline0(12));
            } catch (InvalidStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerWatchMessagesReceiver() {
        IQDevice device = getInstance().getDevice();
        Logger.logDebug("Garmin: CIQManager: registerWatchMessageReceiver " + device + " app " + getApp());
        try {
            if (device == null) {
                Logger.logDebug("Garmin: CIQManager: registerWatchMessagesReceiver: No device found.");
                ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("No device found.");
                return;
            }
            Logger.logDebug("Garmin: CIQManager: registerWatchMessageReceiver " + device.getFriendlyName() + " app " + getApp());
            final int i = 0;
            this.connectIQ.registerForAppEvents(device, getApp(), new ConnectIQ.IQApplicationEventListener(this) { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager$$ExternalSyntheticLambda1
                public final /* synthetic */ CIQManager f$0;

                {
                    this.f$0 = this;
                }

                @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationEventListener
                public final void onMessageReceived(IQDevice iQDevice, IQApp iQApp, List list, ConnectIQ.IQMessageStatus iQMessageStatus) {
                    int i2 = i;
                    CIQManager cIQManager = this.f$0;
                    switch (i2) {
                        case 0:
                            cIQManager.lambda$registerWatchMessagesReceiver$1(iQDevice, iQApp, list, iQMessageStatus);
                            break;
                        default:
                            cIQManager.lambda$registerWatchMessagesReceiver$2(iQDevice, iQApp, list, iQMessageStatus);
                            break;
                    }
                }
            });
            if (this.activeApp == null) {
                Logger.logDebug("Garmin: CIQManager: registerWatchMessageReceiver " + device.getFriendlyName() + " app " + getAppOld());
                final int i2 = 1;
                this.connectIQ.registerForAppEvents(device, getAppOld(), new ConnectIQ.IQApplicationEventListener(this) { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager$$ExternalSyntheticLambda1
                    public final /* synthetic */ CIQManager f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.garmin.android.connectiq.ConnectIQ.IQApplicationEventListener
                    public final void onMessageReceived(IQDevice iQDevice, IQApp iQApp, List list, ConnectIQ.IQMessageStatus iQMessageStatus) {
                        int i22 = i2;
                        CIQManager cIQManager = this.f$0;
                        switch (i22) {
                            case 0:
                                cIQManager.lambda$registerWatchMessagesReceiver$1(iQDevice, iQApp, list, iQMessageStatus);
                                break;
                            default:
                                cIQManager.lambda$registerWatchMessagesReceiver$2(iQDevice, iQApp, list, iQMessageStatus);
                                break;
                        }
                    }
                });
            }
        } catch (InvalidStateException e) {
            Logger.logSevere(e);
        } catch (ServiceUnavailableException e2) {
            Logger.logSevere(e2);
        }
    }

    private void unregisterApp(ConnectIQ connectIQ) {
        if (connectIQ != null) {
            try {
                IQDevice device = getDevice();
                if (device != null) {
                    connectIQ.unregisterForApplicationEvents(device, getApp());
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        if (connectIQ != null) {
            try {
                IQDevice device2 = getDevice();
                if (device2 != null) {
                    connectIQ.unregisterForApplicationEvents(device2, getAppOld());
                }
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        if (connectIQ != null) {
            try {
                IQDevice device3 = getDevice();
                if (device3 != null) {
                    connectIQ.unregisterForDeviceEvents(device3);
                }
            } catch (Exception e3) {
                Logger.logSevere(e3);
            }
        }
    }

    public IQApp getApp() {
        IQApp iQApp = this.activeApp;
        return iQApp != null ? iQApp : new IQApp("1FC99D3F06FE4B02BBABD497CB05874B");
    }

    public IQApp getAppOld() {
        return new IQApp("21CAD9617B914811B0B27EA6240DE29B");
    }

    public void init(Context context, final Intent intent) {
        Logger.logInfo("Garmin: CIQ init " + this.connectIqReady + " " + this.connectIqInitializing);
        if (this.connectIqReady.booleanValue() && !this.connectIqInitializing.booleanValue()) {
            MessageHandler.getInstance().handleMessageFromSleep(intent, this.context);
            return;
        }
        if (this.connectIQ == null) {
            Logger.logInfo("Garmin: CIQManager:  CIQ new instance");
            this.connectIQ = ConnectIQ.getInstance(context, ConnectIQ.IQConnectType.WIRELESS);
        }
        if (this.connectIqReady.booleanValue() || this.connectIqInitializing.booleanValue()) {
            return;
        }
        this.connectIqInitializing = Boolean.TRUE;
        Logger.logInfo("Garmin: CIQManager: initializeConnectIQWrapped");
        this.context = initializeConnectIQWrapped(context, this.connectIQ, false, new ConnectIQ.ConnectIQListener() { // from class: com.urbandroid.sleep.smartwatch.garmin.CIQManager.1
            @Override // com.garmin.android.connectiq.ConnectIQ.ConnectIQListener
            public void onInitializeError(ConnectIQ.IQSdkErrorStatus iQSdkErrorStatus) {
                Logger.logSevere("Garmin: CIQManager:  " + iQSdkErrorStatus.toString());
                CIQManager.this.connectIqReady = Boolean.FALSE;
                ServiceRecoveryManager.getInstance().stopSelfAndScheduleRecovery("onInitializeError");
                CIQManager.this.context.stopService(new Intent(CIQManager.this.context, (Class<?>) GarminProviderService.class));
            }

            @Override // com.garmin.android.connectiq.ConnectIQ.ConnectIQListener
            public void onSdkReady() {
                CIQManager.m2101$$Nest$fputconnectIqInitializing(CIQManager.this);
                CIQManager.this.connectIqReady = Boolean.TRUE;
                Logger.logInfo("Garmin: CIQManager:  onSdkReady");
                CIQManager.this.registerWatchMessagesReceiver();
                CIQManager.this.registerDeviceStatusReceiver();
                CIQManager.this.isWatchAppAvailable();
                MessageHandler.getInstance().handleMessageFromSleep(intent, CIQManager.this.context);
            }

            @Override // com.garmin.android.connectiq.ConnectIQ.ConnectIQListener
            public void onSdkShutDown() {
                Logger.logInfo("Garmin: CIQManager:  onSdkShutdown");
                CIQManager cIQManager = CIQManager.this;
                Boolean bool = Boolean.FALSE;
                CIQManager.m2101$$Nest$fputconnectIqInitializing(cIQManager);
                CIQManager.this.connectIqReady = bool;
            }
        });
    }

    public void onOpenAppOnWatch(ConnectIQ.IQOpenApplicationListener iQOpenApplicationListener) {
    }

    public void resetState() {
        Boolean bool = Boolean.FALSE;
        this.connectIqInitializing = bool;
        this.connectIqReady = bool;
    }

    public void sendMessageToWatch(String str, ConnectIQ.IQSendMessageListener iQSendMessageListener) {
        this.connectIQ.sendMessage(getDevice(), getApp(), str, iQSendMessageListener);
        if (this.activeApp == null) {
            this.connectIQ.sendMessage(getDevice(), getAppOld(), str, iQSendMessageListener);
        }
    }

    public void shutdown(Context context) {
        Logger.logDebug("Garmin: CIQManager: Shutting down");
        this.connectIqReady = Boolean.FALSE;
        unregisterApp(this.connectIQ);
        try {
            if (this.context != null) {
                Logger.logDebug("Garmin: CIQManager: Shutting down with wrapped context");
                this.connectIQ.shutdown(this.context);
            } else {
                Logger.logDebug("Garmin: CIQManager: Shutting down without wrapped context");
                this.connectIQ.shutdown(context);
            }
        } catch (InvalidStateException e) {
            Logger.logSevere("Garmin: CIQManager: This is usually because the SDK was already shut down so no worries.", e);
        } catch (IllegalArgumentException e2) {
            Logger.logSevere(e2);
        } catch (RuntimeException e3) {
            Logger.logSevere(e3);
        }
    }

    public IQDevice getDevice() {
        return getDevice(this.connectIQ);
    }
}
