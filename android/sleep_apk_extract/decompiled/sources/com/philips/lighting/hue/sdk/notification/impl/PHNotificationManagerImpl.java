package com.philips.lighting.hue.sdk.notification.impl;

import com.philips.lighting.hue.listener.PHBridgeAPIListener;
import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.listener.PHGroupListener;
import com.philips.lighting.hue.listener.PHHTTPListener;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.listener.PHRuleListener;
import com.philips.lighting.hue.listener.PHSceneListener;
import com.philips.lighting.hue.listener.PHScheduleListener;
import com.philips.lighting.hue.listener.PHSensorListener;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHNotificationManager;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHHueParsingError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PHNotificationManagerImpl extends PHNotificationManager {
    private static PHNotificationManagerImpl notificationManager;
    private List<PHSDKListener> localSDKListeners = new ArrayList();
    private boolean searchPolling = true;

    private PHNotificationManagerImpl() {
    }

    public static void cleanNotificationManager() {
        notificationManager = null;
    }

    public static synchronized PHNotificationManagerImpl getInstance() {
        try {
            if (notificationManager == null) {
                notificationManager = new PHNotificationManagerImpl();
            }
        } catch (Throwable th) {
            throw th;
        }
        return notificationManager;
    }

    public static PHNotificationManagerImpl getNotificationManager() {
        return notificationManager;
    }

    @Override // com.philips.lighting.hue.sdk.PHNotificationManager
    public void cancelSearchNotification() {
        this.searchPolling = false;
    }

    public boolean isSearchRunning() {
        return this.searchPolling;
    }

    public void notifyAllGroupDetails(final PHGroupListener pHGroupListener, final List<PHBridgeResource> list) {
        if (pHGroupListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.11
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHGroupListener.onReceivingAllGroups(list);
            }
        }).execute(null);
    }

    public void notifyBridgeAPIError(final PHBridgeAPIListener pHBridgeAPIListener, final int i, final String str) {
        if (pHBridgeAPIListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.18
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                PHBridgeAPIListener pHBridgeAPIListener2 = pHBridgeAPIListener;
                if (pHBridgeAPIListener2 != null) {
                    pHBridgeAPIListener2.onError(i, str);
                }
            }
        }).execute(null);
    }

    public void notifyBridgeAPIStateUpdate(final PHBridgeAPIListener pHBridgeAPIListener, final Map<String, String> map, final List<PHHueError> list) {
        if (pHBridgeAPIListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.16
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                PHBridgeAPIListener pHBridgeAPIListener2 = pHBridgeAPIListener;
                if (pHBridgeAPIListener2 != null) {
                    pHBridgeAPIListener2.onStateUpdate(map, list);
                }
            }
        }).execute(null);
    }

    public void notifyBridgeAPISuccess(final PHBridgeAPIListener pHBridgeAPIListener) {
        if (pHBridgeAPIListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.17
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                PHBridgeAPIListener pHBridgeAPIListener2 = pHBridgeAPIListener;
                if (pHBridgeAPIListener2 != null) {
                    pHBridgeAPIListener2.onSuccess();
                }
            }
        }).execute(null);
    }

    public void notifyBridgeAuthentication(final PHAccessPoint pHAccessPoint) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.4
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onAuthenticationRequired(pHAccessPoint);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyBridgeConfigReceived(final PHBridgeConfigurationListener pHBridgeConfigurationListener, final PHBridgeConfiguration pHBridgeConfiguration) {
        if (pHBridgeConfigurationListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.15
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                PHBridgeConfigurationListener pHBridgeConfigurationListener2 = pHBridgeConfigurationListener;
                if (pHBridgeConfigurationListener2 != null) {
                    pHBridgeConfigurationListener2.onReceivingConfiguration(pHBridgeConfiguration);
                }
            }
        }).execute(null);
    }

    public void notifyBridgeConnected(final PHBridge pHBridge, final String str) {
        if (PHHueSDK.getInstance() != null && pHBridge != null) {
            PHHueSDK.getInstance().setSelectedBridge(pHBridge);
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.5
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onBridgeConnected(pHBridge, str);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyBridgeGetScene(final PHSceneListener pHSceneListener, final PHScene pHScene) {
        if (pHSceneListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.24
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHSceneListener.onSceneReceived(pHScene);
            }
        }).execute(null);
    }

    public void notifyBridgeSearchResult(final List<PHAccessPoint> list) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.3
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onAccessPointsFound(list);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyCacheUpdated(int i, PHBridge pHBridge) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        notifyCacheUpdated(arrayList, pHBridge);
    }

    public void notifyConnectionLost(final PHAccessPoint pHAccessPoint) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.7
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onConnectionLost(pHAccessPoint);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyConnectionResumed(final PHBridge pHBridge) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.8
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onConnectionResumed(pHBridge);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyGroupCreated(final PHGroupListener pHGroupListener, final PHGroup pHGroup) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.9
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHGroupListener.onCreated(pHGroup);
            }
        }).execute(null);
    }

    public void notifyGroupDetails(final PHGroupListener pHGroupListener, final PHGroup pHGroup) {
        if (pHGroupListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.10
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHGroupListener.onReceivingGroupDetails(pHGroup);
            }
        }).execute(null);
    }

    public void notifyHTTPResponse(final PHHTTPListener pHHTTPListener, final String str) {
        if (pHHTTPListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.25
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHHTTPListener.onHTTPResponse(str);
            }
        }).execute(null);
    }

    public void notifyLightDetails(final PHLightListener pHLightListener, final PHLight pHLight) {
        if (pHLightListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.12
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHLightListener.onReceivingLightDetails(pHLight);
            }
        }).execute(null);
    }

    public void notifyLightHeaders(final PHLightListener pHLightListener, final List<PHBridgeResource> list, final boolean z) {
        if (pHLightListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.13
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHLightListener.onReceivingLights(list);
                if (z) {
                    pHLightListener.onSearchComplete();
                }
            }
        }).execute(null);
    }

    public void notifyParsingError(final List<PHHueParsingError> list) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.2
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onParsingErrors(list);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyRuleDetails(final PHRuleListener pHRuleListener, final PHRule pHRule) {
        if (pHRuleListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.23
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHRuleListener.onReceivingRuleDetails(pHRule);
            }
        }).execute(null);
    }

    public void notifySDKError(final int i, final String str) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.1
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onError(i, str);
                    }
                }
            }
        }).execute(null);
    }

    public void notifyScenesReceived(final PHSceneListener pHSceneListener, final List<PHScene> list) {
        if (pHSceneListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.19
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHSceneListener.onScenesReceived(list);
            }
        }).execute(null);
    }

    public void notifyScheduleCreated(final PHScheduleListener pHScheduleListener, final PHSchedule pHSchedule) {
        if (pHScheduleListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.14
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHScheduleListener.onCreated(pHSchedule);
            }
        }).execute(null);
    }

    public void notifySensorDetails(final PHSensorListener pHSensorListener, final PHSensor pHSensor) {
        if (pHSensorListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.21
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHSensorListener.onReceivingSensorDetails(pHSensor);
            }
        }).execute(null);
    }

    public void notifySensorSearchFinished(final PHSensorListener pHSensorListener) {
        if (pHSensorListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.22
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHSensorListener.onSensorSearchFinished();
            }
        }).execute(null);
    }

    public void notifySensorsReceived(final PHSensorListener pHSensorListener, final List<PHBridgeResource> list) {
        if (pHSensorListener == null) {
            return;
        }
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.20
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                pHSensorListener.onSensorsReceived(list);
            }
        }).execute(null);
    }

    @Override // com.philips.lighting.hue.sdk.PHNotificationManager
    public void registerSDKListener(PHSDKListener pHSDKListener) {
        if (pHSDKListener != null) {
            this.localSDKListeners.add(pHSDKListener);
        }
    }

    public void startSearchNotification() {
        this.searchPolling = true;
    }

    @Override // com.philips.lighting.hue.sdk.PHNotificationManager
    public void unregisterSDKListener(PHSDKListener pHSDKListener) {
        if (pHSDKListener != null) {
            this.localSDKListeners.remove(pHSDKListener);
        }
    }

    public void notifyCacheUpdated(final List<Integer> list, final PHBridge pHBridge) {
        new PHHueResultReceiver(new PHHandlerListener() { // from class: com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl.6
            @Override // com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener
            public void onReceived() {
                for (PHSDKListener pHSDKListener : PHNotificationManagerImpl.this.localSDKListeners) {
                    if (pHSDKListener != null) {
                        pHSDKListener.onCacheUpdated(list, pHBridge);
                    }
                }
            }
        }).execute(null);
    }
}
