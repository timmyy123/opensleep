package com.philips.lighting.hue.sdk.connection.impl;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.GraphResponse;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeResourcesCacheImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer;
import com.philips.lighting.hue.sdk.clip.PHGroupSerializer;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.clip.serialisation.PHCLIPParserBase;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;
import com.philips.lighting.hue.sdk.util.PHHueCountTimer;
import com.philips.lighting.hue.sdk.util.PHHueCountTimerListener;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeInternal {
    private static final long START_DELAY_TIMEINMS = 0;
    private static final String TAG = "PHBridgeInternal";
    private static final long TIMEOUT_PUSHLINKINMS = 30000;
    private static final long TIMER_DELAY = 1000;
    private PHHueCountTimer pushLinkTimer = null;

    private void addGroupsToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHGroupSerializer groupSerializer = pHBridgeVersionManager.getGroupSerializer();
        if (groupSerializer != null) {
            List<PHGroup> groups = groupSerializer.parseGroups(jSONObject);
            if (!pHBridgeResourcesCacheImpl.getGroups().isEmpty() || groups == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHGroup pHGroup : groups) {
                map.put(pHGroup.getIdentifier(), pHGroup);
            }
            pHBridgeResourcesCacheImpl.setGroups(map);
        }
    }

    private void addLightsToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHLightSerializer lightSerializer = pHBridgeVersionManager.getLightSerializer();
        if (lightSerializer != null) {
            List<PHLight> lights = lightSerializer.parseLights(jSONObject);
            if (!pHBridgeResourcesCacheImpl.getLights().isEmpty() || lights == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHLight pHLight : lights) {
                map.put(pHLight.getIdentifier(), pHLight);
            }
            pHBridgeResourcesCacheImpl.setLights(map);
        }
    }

    private void addRulesToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHRuleSerializer rulesSerializer = pHBridgeVersionManager.getRulesSerializer();
        if (rulesSerializer != null) {
            List<PHRule> rules = rulesSerializer.parseRules(jSONObject);
            if (!pHBridgeResourcesCacheImpl.getRules().isEmpty() || rules == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHRule pHRule : rules) {
                map.put(pHRule.getIdentifier(), pHRule);
            }
            pHBridgeResourcesCacheImpl.setRules(map);
        }
    }

    private void addScenesToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHSceneSerializer scenesSerializer = pHBridgeVersionManager.getScenesSerializer();
        if (scenesSerializer != null) {
            List<PHScene> scenes = scenesSerializer.parseScenes(jSONObject);
            if (!pHBridgeResourcesCacheImpl.getScenes().isEmpty() || scenes == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHScene pHScene : scenes) {
                map.put(pHScene.getSceneIdentifier(), pHScene);
            }
            pHBridgeResourcesCacheImpl.setScenes(map);
        }
    }

    private void addSchedulesToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHScheduleSerializer schedulesSerializer = pHBridgeVersionManager.getSchedulesSerializer();
        if (schedulesSerializer != null) {
            List<PHSchedule> schedules = schedulesSerializer.parseSchedules(jSONObject, (pHBridgeResourcesCacheImpl == null || pHBridgeResourcesCacheImpl.getBridgeConfiguration() == null) ? null : pHBridgeResourcesCacheImpl.getBridgeConfiguration().getTimeZone());
            if (!pHBridgeResourcesCacheImpl.getSchedules().isEmpty() || schedules == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHSchedule pHSchedule : schedules) {
                map.put(pHSchedule.getIdentifier(), pHSchedule);
            }
            pHBridgeResourcesCacheImpl.setSchedules(map);
        }
    }

    private void addSensorsToBridge(PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl, JSONObject jSONObject, PHBridgeVersionManager pHBridgeVersionManager) {
        PHSensorSerializer sensorSerializer = pHBridgeVersionManager.getSensorSerializer();
        if (sensorSerializer != null) {
            List<PHSensor> sensors = sensorSerializer.parseSensors(jSONObject);
            if (!pHBridgeResourcesCacheImpl.getSensors().isEmpty() || sensors == null) {
                return;
            }
            HashMap map = new HashMap();
            for (PHSensor pHSensor : sensors) {
                map.put(pHSensor.getIdentifier(), pHSensor);
            }
            pHBridgeResourcesCacheImpl.setSensors(map);
        }
    }

    private boolean checkAlreadyConnected(String str) {
        PHHueSDK storedSDKObject = PHHueSDK.getStoredSDKObject();
        if (storedSDKObject == null) {
            return false;
        }
        Iterator<PHBridge> it = storedSDKObject.getAllBridges().iterator();
        while (it.hasNext()) {
            if (it.next().getResourceCache().getBridgeConfiguration().getIpAddress().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private String getDataFromURL(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return getConnectionObject().getData(str);
        } catch (Exception e) {
            PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
            if (notificationManager == null) {
                return null;
            }
            notificationManager.notifySDKError(42, e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDeviceKey(PHHueCountTimer pHHueCountTimer, PHAccessPoint pHAccessPoint) throws Throwable {
        JSONObject jSONObjectOptJSONObject;
        if (pHAccessPoint == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        try {
            PHHueSDK pHHueSDK = PHHueSDK.getInstance();
            String deviceName = pHHueSDK.getDeviceName();
            String appName = pHHueSDK.getAppName();
            PHLog.d(TAG, "postDeviceKey deviceID..." + pHAccessPoint.getUsername());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("devicetype", String.valueOf(appName) + "#" + deviceName);
            String strPostData = getConnectionObject().postData(jSONObject.toString(), "http://" + pHAccessPoint.getIpAddress() + "/api/");
            if (strPostData == null) {
                if (pHHueCountTimer.isRunning()) {
                    pHHueCountTimer.restart(TIMER_DELAY);
                    return;
                }
                return;
            }
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPostData);
            if (error.size() != 0) {
                for (PHHueError pHHueError : error) {
                    if (pHHueError.getCode() == 101) {
                        PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
                        if (notificationManager != null) {
                            notificationManager.notifySDKError(101, pHHueError.getMessage());
                        }
                        if (pHHueCountTimer.isRunning()) {
                            pHHueCountTimer.restart(TIMER_DELAY);
                        }
                    }
                }
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(strPostData);
                String string = (jSONArray.length() != 1 || (jSONObjectOptJSONObject = jSONArray.getJSONObject(0).optJSONObject(GraphResponse.SUCCESS_KEY)) == null) ? null : jSONObjectOptJSONObject.getString("username");
                if (string != null) {
                    if (pHHueCountTimer != null) {
                        pHHueCountTimer.stop();
                    }
                    PHLog.d(TAG, "postDeviceKey() GOT A KEY!: ");
                    pHAccessPoint.setUsername(string);
                }
                connectToAccessPoint(pHAccessPoint);
            } catch (JSONException unused) {
                PHNotificationManagerImpl notificationManager2 = PHNotificationManagerImpl.getNotificationManager();
                if (notificationManager2 != null) {
                    notificationManager2.notifySDKError(52, PHHueConstants.TXT_INVALID_JSON);
                }
            }
        } catch (Exception e) {
            if (pHHueCountTimer.isRunning()) {
                pHHueCountTimer.restart(TIMER_DELAY);
            }
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "Exception: " + e);
            }
        }
    }

    public void connectToAccessPoint(final PHAccessPoint pHAccessPoint) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        if (pHAccessPoint == null) {
            notificationManager.notifySDKError(44, PHHueConstants.TXT_NO_DATA);
        } else if (checkAlreadyConnected(pHAccessPoint.getIpAddress())) {
            notificationManager.notifySDKError(27, PHHueConstants.TXT_BRIDGE_ALREADY_CONNECTED);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHBridgeInternal.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        String username = pHAccessPoint.getUsername();
                        String bridgeDetails = PHBridgeInternal.this.getBridgeDetails(username, pHAccessPoint.getIpAddress());
                        if (bridgeDetails == null) {
                            notificationManager.notifySDKError(46, PHHueConstants.TXT_NOT_RESPONDING);
                            return;
                        }
                        List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(bridgeDetails);
                        if (error.size() != 0) {
                            Iterator<PHHueError> it = error.iterator();
                            while (it.hasNext()) {
                                if (it.next().getCode() == 1) {
                                    notificationManager.notifyBridgeAuthentication(pHAccessPoint);
                                }
                            }
                            return;
                        }
                        PHBridgeImpl pHBridgeImplProcessResponse = PHBridgeInternal.this.processResponse(bridgeDetails, username);
                        if (pHBridgeImplProcessResponse != null) {
                            notificationManager.notifyBridgeConnected(pHBridgeImplProcessResponse, username);
                        }
                    } catch (Exception e) {
                        notificationManager.notifySDKError(42, e.getMessage());
                    }
                }
            }.start();
        }
    }

    public String getBridgeDetails(String str, String str2) {
        if (str2 != null) {
            return getDataFromURL(Fragment$$ExternalSyntheticOutline1.m("http://", str2, "/api/", str));
        }
        return null;
    }

    public String getConfigDetails(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/config"));
    }

    public PHHueHttpConnection getConnectionObject() {
        return new PHHueHttpConnection();
    }

    public String getGroupsDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/groups"));
    }

    public String getLightsDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/lights"));
    }

    public String getRulesDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/rules"));
    }

    public String getScenesDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/scenes"));
    }

    public String getSchedulesDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/schedules"));
    }

    public String getSensorsDetail(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getDataFromURL(FileInsert$$ExternalSyntheticOutline0.m("http://", str2, "/api/", str, "/sensors"));
    }

    public PHBridgeImpl processResponse(String str, String str2) {
        PHBridgeImpl pHBridgeImpl;
        PHBridgeConfiguration bridgeConfiguration;
        try {
            JSONObject jSONObject = new JSONObject(str);
            PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
            PHBridgeConfigurationSerializer bridgeConfigurationSerializer = pHBridgeVersionManager.getBridgeConfigurationSerializer();
            pHBridgeVersionManager.setBridgeVersion(bridgeConfigurationSerializer.parseBridgeSoftwareVersion(jSONObject), bridgeConfigurationSerializer.parseBridgeAPIVersion(jSONObject));
            bridgeConfiguration = pHBridgeVersionManager.getBridgeConfigurationSerializer().parseBridgeConfiguration(jSONObject);
            pHBridgeImpl = new PHBridgeImpl(new PHLocalBridgeDelegator(bridgeConfiguration.getIpAddress(), str2));
            PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl = (PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache();
            if (pHBridgeResourcesCacheImpl.getBridgeConfiguration() == null) {
                bridgeConfiguration.setUserName(str2);
                pHBridgeResourcesCacheImpl.setBridgeConfiguration(bridgeConfiguration);
            }
            addLightsToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
            addGroupsToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
            addSchedulesToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
            addScenesToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
            addSensorsToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
            addRulesToBridge(pHBridgeResourcesCacheImpl, jSONObject, pHBridgeVersionManager);
        } catch (Exception e) {
            e.printStackTrace();
            pHBridgeImpl = null;
        }
        if (checkAlreadyConnected(bridgeConfiguration.getIpAddress())) {
            PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
            if (notificationManager != null) {
                notificationManager.notifySDKError(27, PHHueConstants.TXT_BRIDGE_ALREADY_CONNECTED);
            }
            return null;
        }
        PHHueSDK storedSDKObject = PHHueSDK.getStoredSDKObject();
        if (storedSDKObject != null) {
            storedSDKObject.addBridge(pHBridgeImpl);
        }
        if (pHBridgeImpl != null) {
            return pHBridgeImpl;
        }
        PHNotificationManagerImpl notificationManager2 = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager2 != null) {
            notificationManager2.notifySDKError(45, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
        }
        return null;
    }

    public void startPushlinkTimer(final PHAccessPoint pHAccessPoint) {
        if (this.pushLinkTimer == null) {
            PHHueCountTimer pHHueCountTimer = new PHHueCountTimer(TIMEOUT_PUSHLINKINMS, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHBridgeInternal.2
                @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                public void onFinish() {
                    PHBridgeInternal.this.pushLinkTimer = null;
                    PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
                    if (notificationManager != null) {
                        notificationManager.notifySDKError(PHMessageType.PUSHLINK_AUTHENTICATION_FAILED, PHHueConstants.TXT_AUTHENTICATION_FAILED);
                    }
                }

                @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                public void onTick() throws Throwable {
                    PHBridgeInternal pHBridgeInternal = PHBridgeInternal.this;
                    pHBridgeInternal.postDeviceKey(pHBridgeInternal.pushLinkTimer, pHAccessPoint);
                }
            });
            this.pushLinkTimer = pHHueCountTimer;
            pHHueCountTimer.start(START_DELAY_TIMEINMS);
        }
    }

    public boolean stopPushLinkTimer() {
        PHHueCountTimer pHHueCountTimer = this.pushLinkTimer;
        if (pHHueCountTimer == null) {
            return false;
        }
        pHHueCountTimer.stop();
        return true;
    }
}
