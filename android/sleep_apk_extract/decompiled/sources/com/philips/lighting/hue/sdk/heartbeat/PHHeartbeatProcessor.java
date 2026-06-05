package com.philips.lighting.hue.sdk.heartbeat;

import com.facebook.GraphResponse;
import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeResourcesCacheImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer;
import com.philips.lighting.hue.sdk.clip.PHCLIPParser;
import com.philips.lighting.hue.sdk.clip.PHGroupSerializer;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.clip.serialisation.PHCLIPParserBase;
import com.philips.lighting.hue.sdk.connection.impl.PHBridgeInternal;
import com.philips.lighting.hue.sdk.connection.impl.PHHueHttpConnection;
import com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.PHWhiteListEntry;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHHeartbeatProcessor extends TimerTask {
    public static final byte NO_OF_RETRIES = 1;
    private static final String TAG = "PHHeartbeatProcessor";
    private PHBridge bridge;
    private PHHeartbeatType heartbeatType;
    private boolean isProcessing;
    private int currentTry = 0;
    private boolean notifyConnectionResume = true;
    private List<Integer> cacheNotificationsList = new ArrayList();

    public enum PHHeartbeatType {
        FULL_CONFIG,
        LIGHTS,
        SCENES,
        SENSORS,
        CONFIG,
        RULES,
        GROUPS,
        SCHEDULES;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHHeartbeatType[] valuesCustom() {
            PHHeartbeatType[] pHHeartbeatTypeArrValuesCustom = values();
            int length = pHHeartbeatTypeArrValuesCustom.length;
            PHHeartbeatType[] pHHeartbeatTypeArr = new PHHeartbeatType[length];
            System.arraycopy(pHHeartbeatTypeArrValuesCustom, 0, pHHeartbeatTypeArr, 0, length);
            return pHHeartbeatTypeArr;
        }
    }

    public PHHeartbeatProcessor(PHBridge pHBridge, PHHeartbeatType pHHeartbeatType) {
        this.bridge = pHBridge;
        this.heartbeatType = pHHeartbeatType;
    }

    private boolean checkAndUpdateRules(List<PHRule> list, Map<String, PHRule> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHRule pHRule : list) {
            PHRule pHRule2 = map.get(pHRule.getIdentifier());
            if (pHRule2 == null) {
                map.put(pHRule.getIdentifier(), pHRule);
                return true;
            }
            if (!pHRule2.equals(pHRule)) {
                return true;
            }
        }
        return false;
    }

    private void checkAppNameDeviceName(PHBridgeConfiguration pHBridgeConfiguration) {
        final String whitelistIdentifier = ((PHBridgeImpl) this.bridge).getBridgeDelegator().getWhitelistIdentifier();
        PHWhiteListEntry pHWhiteListEntry = null;
        for (PHWhiteListEntry pHWhiteListEntry2 : pHBridgeConfiguration.getWhiteListEntries()) {
            if (pHWhiteListEntry2.getUserName().equals(whitelistIdentifier)) {
                pHWhiteListEntry = pHWhiteListEntry2;
            }
        }
        if (pHWhiteListEntry == null || pHWhiteListEntry.getDeviceName() != null) {
            return;
        }
        PHHueSDK.getInstance().getAppName();
        PHHueSDK.getInstance().getDeviceName();
        new Thread() { // from class: com.philips.lighting.hue.sdk.heartbeat.PHHeartbeatProcessor.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                PHHueHttpConnection pHHueHttpConnection = new PHHueHttpConnection();
                final PHBridgeDelegator bridgeDelegator = ((PHBridgeImpl) PHHeartbeatProcessor.this.bridge).getBridgeDelegator();
                try {
                    StringBuffer stringBuffer = (StringBuffer) bridgeDelegator.getClass().getMethod("buildHttpAddress", null).invoke(bridgeDelegator, null);
                    stringBuffer.append("config");
                    if (pHHueHttpConnection.putData("{\"linkbutton\":true}", stringBuffer.toString()).contains(GraphResponse.SUCCESS_KEY)) {
                        final String str = whitelistIdentifier;
                        bridgeDelegator.removeUsername(str, new PHBridgeConfigurationListener() { // from class: com.philips.lighting.hue.sdk.heartbeat.PHHeartbeatProcessor.1.1
                            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                            public void onError(int i, String str2) {
                                PHHueSDK pHHueSDK = PHHueSDK.getInstance();
                                try {
                                    Field declaredField = PHLocalBridgeDelegator.class.getDeclaredField("ipAddress");
                                    declaredField.setAccessible(true);
                                    String str3 = (String) declaredField.get(bridgeDelegator);
                                    PHAccessPoint pHAccessPoint = new PHAccessPoint();
                                    pHAccessPoint.setIpAddress(str3);
                                    pHAccessPoint.setUsername(str);
                                    pHHueSDK.startPushlinkAuthentication(pHAccessPoint);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (IllegalArgumentException e2) {
                                    e2.printStackTrace();
                                } catch (NoSuchFieldException e3) {
                                    e3.printStackTrace();
                                } catch (SecurityException e4) {
                                    e4.printStackTrace();
                                }
                            }

                            @Override // com.philips.lighting.hue.listener.PHBridgeConfigurationListener
                            public void onReceivingConfiguration(PHBridgeConfiguration pHBridgeConfiguration2) {
                            }

                            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                            public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
                            }

                            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                            public void onSuccess() {
                                PHHueSDK pHHueSDK = PHHueSDK.getInstance();
                                try {
                                    Field declaredField = PHLocalBridgeDelegator.class.getDeclaredField("ipAddress");
                                    declaredField.setAccessible(true);
                                    String str2 = (String) declaredField.get(bridgeDelegator);
                                    PHAccessPoint pHAccessPoint = new PHAccessPoint();
                                    pHAccessPoint.setIpAddress(str2);
                                    pHAccessPoint.setUsername(str);
                                    pHHueSDK.startPushlinkAuthentication(pHAccessPoint);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (IllegalArgumentException e2) {
                                    e2.printStackTrace();
                                } catch (NoSuchFieldException e3) {
                                    e3.printStackTrace();
                                } catch (SecurityException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (SecurityException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
            }
        }.start();
    }

    private void disconnectBridge(boolean z) {
        PHHueSDK storedSDKObject = PHHueSDK.getStoredSDKObject();
        if (storedSDKObject == null) {
            return;
        }
        if (!z) {
            storedSDKObject.removeBridge(this.bridge);
        } else {
            storedSDKObject.getHeartbeatManager().disableAllHeartbeats(this.bridge);
            storedSDKObject.disconnect(this.bridge);
        }
    }

    private PHAccessPoint disconnectedBridgeAsAccessPoint() {
        if (this.bridge == null) {
            return null;
        }
        PHAccessPoint pHAccessPoint = new PHAccessPoint();
        PHBridgeConfiguration bridgeConfiguration = this.bridge.getResourceCache().getBridgeConfiguration();
        pHAccessPoint.setIpAddress(bridgeConfiguration.getIpAddress());
        pHAccessPoint.setMacAddress(bridgeConfiguration.getMacAddress());
        pHAccessPoint.setBridgeId(bridgeConfiguration.getBridgeID());
        pHAccessPoint.setUsername(bridgeConfiguration.getUsername());
        return pHAccessPoint;
    }

    private Map<String, PHGroup> getNewGroupsCache(List<PHGroup> list) {
        HashMap map = new HashMap();
        for (PHGroup pHGroup : list) {
            map.put(pHGroup.getIdentifier(), pHGroup);
        }
        return map;
    }

    private Map<String, PHLight> getNewLightsCache(List<PHLight> list) {
        HashMap map = new HashMap();
        for (PHLight pHLight : list) {
            map.put(pHLight.getIdentifier(), pHLight);
        }
        return map;
    }

    private Map<String, PHRule> getNewRulesCache(List<PHRule> list) {
        HashMap map = new HashMap();
        for (PHRule pHRule : list) {
            map.put(pHRule.getIdentifier(), pHRule);
        }
        return map;
    }

    private Map<String, PHScene> getNewScenesCache(List<PHScene> list) {
        HashMap map = new HashMap();
        for (PHScene pHScene : list) {
            map.put(pHScene.getSceneIdentifier(), pHScene);
        }
        return map;
    }

    private Map<String, PHSchedule> getNewSchedulesCache(List<PHSchedule> list) {
        HashMap map = new HashMap();
        for (PHSchedule pHSchedule : list) {
            map.put(pHSchedule.getIdentifier(), pHSchedule);
        }
        return map;
    }

    private Map<String, PHSensor> getNewSensorsCache(List<PHSensor> list) {
        HashMap map = new HashMap();
        for (PHSensor pHSensor : list) {
            map.put(pHSensor.getIdentifier(), pHSensor);
        }
        return map;
    }

    private String getResponseFromResource() {
        PHBridgeConfiguration bridgeConfiguration = ((PHBridgeResourcesCacheImpl) this.bridge.getResourceCache()).getBridgeConfiguration();
        PHBridgeInternal internalObject = getInternalObject();
        PHHeartbeatType pHHeartbeatType = this.heartbeatType;
        return pHHeartbeatType == PHHeartbeatType.CONFIG ? internalObject.getConfigDetails(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.GROUPS ? internalObject.getGroupsDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.LIGHTS ? internalObject.getLightsDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.SCENES ? internalObject.getScenesDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.SCHEDULES ? internalObject.getSchedulesDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.SENSORS ? internalObject.getSensorsDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : pHHeartbeatType == PHHeartbeatType.RULES ? internalObject.getRulesDetail(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress()) : internalObject.getBridgeDetails(bridgeConfiguration.getUsername(), bridgeConfiguration.getIpAddress());
    }

    private boolean isGroupsChanged(List<PHGroup> list, Map<String, PHGroup> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHGroup pHGroup : list) {
            PHGroup pHGroup2 = map.get(pHGroup.getIdentifier());
            if (pHGroup2 == null || !pHGroup2.equals(pHGroup)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLightsChanged(List<PHLight> list, Map<String, PHLight> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHLight pHLight : list) {
            PHLight pHLight2 = map.get(pHLight.getIdentifier());
            if (pHLight2 == null || !pHLight2.equals(pHLight)) {
                return true;
            }
        }
        return false;
    }

    private boolean isScenesChanged(List<PHScene> list, Map<String, PHScene> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHScene pHScene : list) {
            PHScene pHScene2 = map.get(pHScene.getSceneIdentifier());
            if (pHScene2 == null) {
                map.put(pHScene.getSceneIdentifier(), pHScene);
                return true;
            }
            if (!pHScene2.equals(pHScene)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSchedulesChanged(List<PHSchedule> list, Map<String, PHSchedule> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHSchedule pHSchedule : list) {
            PHSchedule pHSchedule2 = map.get(pHSchedule.getIdentifier());
            if (pHSchedule2 == null || !pHSchedule2.equals(pHSchedule)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSensorsChanged(List<PHSensor> list, Map<String, PHSensor> map) {
        if (list == null || map == null) {
            return false;
        }
        if (list.size() != map.size()) {
            return true;
        }
        for (PHSensor pHSensor : list) {
            PHSensor pHSensor2 = map.get(pHSensor.getIdentifier());
            if (pHSensor2 == null) {
                map.put(pHSensor.getIdentifier(), pHSensor);
                return true;
            }
            if (!pHSensor2.equals(pHSensor)) {
                return true;
            }
        }
        return false;
    }

    private void processHeartbeatResponse(String str) {
        PHBridgeConfigurationSerializer bridgeConfigurationSerializer;
        PHBridgeConfiguration bridgeConfiguration;
        PHGroupSerializer groupSerializer;
        List<PHGroup> groups;
        PHLightSerializer lightSerializer;
        List<PHLight> lights;
        PHSceneSerializer scenesSerializer;
        List<PHScene> scenes;
        PHScheduleSerializer schedulesSerializer;
        List<PHSchedule> schedules;
        PHSensorSerializer sensorSerializer;
        List<PHSensor> sensors;
        PHRuleSerializer rulesSerializer;
        PHBridgeConfiguration pHBridgeConfiguration;
        try {
            JSONObject jSONObject = new JSONObject(str);
            PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
            PHHeartbeatType pHHeartbeatType = this.heartbeatType;
            PHHeartbeatType pHHeartbeatType2 = PHHeartbeatType.CONFIG;
            if (pHHeartbeatType == pHHeartbeatType2 || pHHeartbeatType == PHHeartbeatType.FULL_CONFIG) {
                PHBridgeConfigurationSerializer bridgeConfigurationSerializer2 = pHBridgeVersionManager.getBridgeConfigurationSerializer();
                pHBridgeVersionManager.setBridgeVersion(bridgeConfigurationSerializer2.parseBridgeSoftwareVersion(jSONObject), bridgeConfigurationSerializer2.parseBridgeAPIVersion(jSONObject));
            }
            PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
            ArrayList arrayList = new ArrayList();
            PHHeartbeatType pHHeartbeatType3 = this.heartbeatType;
            List<PHRule> rules = null;
            if ((pHHeartbeatType3 == pHHeartbeatType2 || pHHeartbeatType3 == PHHeartbeatType.FULL_CONFIG) && (bridgeConfigurationSerializer = pHBridgeVersionManager.getBridgeConfigurationSerializer()) != null) {
                bridgeConfiguration = bridgeConfigurationSerializer.parseBridgeConfiguration(jSONObject);
                PHCLIPParser pHCLIPParser = (PHCLIPParser) bridgeConfigurationSerializer;
                arrayList.addAll(pHCLIPParser.getParsingErrors());
                pHCLIPParser.clearErrors();
            } else {
                bridgeConfiguration = null;
            }
            PHHeartbeatType pHHeartbeatType4 = this.heartbeatType;
            if ((pHHeartbeatType4 == PHHeartbeatType.GROUPS || pHHeartbeatType4 == PHHeartbeatType.FULL_CONFIG) && (groupSerializer = pHBridgeVersionManager.getGroupSerializer()) != null) {
                groups = groupSerializer.parseGroups(jSONObject);
                PHCLIPParser pHCLIPParser2 = (PHCLIPParser) groupSerializer;
                arrayList.addAll(pHCLIPParser2.getParsingErrors());
                pHCLIPParser2.clearErrors();
            } else {
                groups = null;
            }
            PHHeartbeatType pHHeartbeatType5 = this.heartbeatType;
            if ((pHHeartbeatType5 == PHHeartbeatType.LIGHTS || pHHeartbeatType5 == PHHeartbeatType.FULL_CONFIG) && (lightSerializer = pHBridgeVersionManager.getLightSerializer()) != null) {
                lights = lightSerializer.parseLights(jSONObject);
                PHCLIPParser pHCLIPParser3 = (PHCLIPParser) lightSerializer;
                arrayList.addAll(pHCLIPParser3.getParsingErrors());
                pHCLIPParser3.clearErrors();
            } else {
                lights = null;
            }
            PHHeartbeatType pHHeartbeatType6 = this.heartbeatType;
            if ((pHHeartbeatType6 == PHHeartbeatType.SCENES || pHHeartbeatType6 == PHHeartbeatType.FULL_CONFIG) && (scenesSerializer = pHBridgeVersionManager.getScenesSerializer()) != null) {
                scenes = scenesSerializer.parseScenes(jSONObject);
                PHCLIPParser pHCLIPParser4 = (PHCLIPParser) scenesSerializer;
                arrayList.addAll(pHCLIPParser4.getParsingErrors());
                pHCLIPParser4.clearErrors();
            } else {
                scenes = null;
            }
            PHHeartbeatType pHHeartbeatType7 = this.heartbeatType;
            if ((pHHeartbeatType7 == PHHeartbeatType.SCHEDULES || pHHeartbeatType7 == PHHeartbeatType.FULL_CONFIG) && (schedulesSerializer = pHBridgeVersionManager.getSchedulesSerializer()) != null) {
                schedules = schedulesSerializer.parseSchedules(jSONObject, this.bridge.getResourceCache().getBridgeConfiguration().getTimeZone());
                PHCLIPParser pHCLIPParser5 = (PHCLIPParser) schedulesSerializer;
                arrayList.addAll(pHCLIPParser5.getParsingErrors());
                pHCLIPParser5.clearErrors();
            } else {
                schedules = null;
            }
            PHHeartbeatType pHHeartbeatType8 = this.heartbeatType;
            if ((pHHeartbeatType8 == PHHeartbeatType.SENSORS || pHHeartbeatType8 == PHHeartbeatType.FULL_CONFIG) && (sensorSerializer = pHBridgeVersionManager.getSensorSerializer()) != null) {
                sensors = sensorSerializer.parseSensors(jSONObject);
                PHCLIPParser pHCLIPParser6 = (PHCLIPParser) sensorSerializer;
                arrayList.addAll(pHCLIPParser6.getParsingErrors());
                pHCLIPParser6.clearErrors();
            } else {
                sensors = null;
            }
            PHHeartbeatType pHHeartbeatType9 = this.heartbeatType;
            if ((pHHeartbeatType9 == PHHeartbeatType.RULES || pHHeartbeatType9 == PHHeartbeatType.FULL_CONFIG) && (rulesSerializer = pHBridgeVersionManager.getRulesSerializer()) != null) {
                rules = rulesSerializer.parseRules(jSONObject);
                PHCLIPParser pHCLIPParser7 = (PHCLIPParser) rulesSerializer;
                arrayList.addAll(pHCLIPParser7.getParsingErrors());
                pHCLIPParser7.clearErrors();
            }
            if (notificationManager != null && arrayList.size() != 0) {
                notificationManager.notifyParsingError(arrayList);
            }
            PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl = (PHBridgeResourcesCacheImpl) this.bridge.getResourceCache();
            Map<String, PHLight> lights2 = pHBridgeResourcesCacheImpl.getLights();
            Map<String, PHGroup> groups2 = pHBridgeResourcesCacheImpl.getGroups();
            PHBridgeConfiguration bridgeConfiguration2 = pHBridgeResourcesCacheImpl.getBridgeConfiguration();
            Map<String, PHSchedule> schedules2 = pHBridgeResourcesCacheImpl.getSchedules();
            Map<String, PHScene> scenes2 = pHBridgeResourcesCacheImpl.getScenes();
            Map<String, PHSensor> sensors2 = pHBridgeResourcesCacheImpl.getSensors();
            Map<String, PHRule> rules2 = pHBridgeResourcesCacheImpl.getRules();
            this.cacheNotificationsList.clear();
            if (isLightsChanged(lights, lights2)) {
                pHBridgeConfiguration = bridgeConfiguration;
                this.cacheNotificationsList.add(PHMessageType.LIGHTS_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setLights(getNewLightsCache(lights));
                PHLog.d(TAG, "LIGHTS_CACHE_UPDATED");
            } else {
                pHBridgeConfiguration = bridgeConfiguration;
            }
            if (isGroupsChanged(groups, groups2)) {
                this.cacheNotificationsList.add(PHMessageType.GROUPS_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setGroups(getNewGroupsCache(groups));
                PHLog.d(TAG, "GROUPS_CACHE_UPDATED");
            }
            if (isSchedulesChanged(schedules, schedules2)) {
                this.cacheNotificationsList.add(PHMessageType.SCHEDULES_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setSchedules(getNewSchedulesCache(schedules));
                PHLog.d(TAG, "SCHEDULES_CACHE_UPDATED");
            }
            if (isScenesChanged(scenes, scenes2)) {
                this.cacheNotificationsList.add(PHMessageType.SCENE_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setScenes(getNewScenesCache(scenes));
                PHLog.d(TAG, "SCENE_CACHE_UPDATED");
            }
            if (isSensorsChanged(sensors, sensors2)) {
                this.cacheNotificationsList.add(PHMessageType.SENSOR_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setSensors(getNewSensorsCache(sensors));
                PHLog.d(TAG, "SENSOR_CACHE_UPDATED");
            }
            if (checkAndUpdateRules(rules, rules2)) {
                this.cacheNotificationsList.add(PHMessageType.RULE_CACHE_UPDATED);
                pHBridgeResourcesCacheImpl.setRules(getNewRulesCache(rules));
                PHLog.d(TAG, "RULE_CACHE_UPDATED");
            }
            if (pHBridgeConfiguration != null) {
                PHBridgeConfiguration pHBridgeConfiguration2 = pHBridgeConfiguration;
                pHBridgeConfiguration2.setUserName(bridgeConfiguration2.getUsername());
                if (bridgeConfiguration2.equals(pHBridgeConfiguration2)) {
                    pHBridgeResourcesCacheImpl.setBridgeConfiguration(pHBridgeConfiguration2);
                } else {
                    pHBridgeResourcesCacheImpl.setBridgeConfiguration(pHBridgeConfiguration2);
                    this.cacheNotificationsList.add(PHMessageType.BRIDGE_CONFIGURATION_CACHE_UPDATED);
                    PHLog.d(TAG, "BRIDGE_CONFIGURATION_CACHE_UPDATED");
                }
            }
            PHLog.d(TAG, "Notified with notificationFlags :" + this.cacheNotificationsList.size());
            if (this.cacheNotificationsList.size() == 0 || notificationManager == null) {
                return;
            }
            notificationManager.notifyCacheUpdated(this.cacheNotificationsList, this.bridge);
        } catch (Exception e) {
            e.printStackTrace();
            PHNotificationManagerImpl notificationManager2 = PHNotificationManagerImpl.getNotificationManager();
            if (notificationManager2 != null) {
                notificationManager2.notifySDKError(42, PHHueResourcesConstants.TXT_INTERNAL_ERROR);
            }
        }
    }

    public PHBridgeInternal getInternalObject() {
        return new PHBridgeInternal();
    }

    public PHHeartbeatType getType() {
        return this.heartbeatType;
    }

    public boolean isProcessing() {
        return this.isProcessing;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (PHHueSDK.getStoredSDKObject() == null) {
            this.isProcessing = false;
            return;
        }
        if (this.bridge == null) {
            if (notificationManager != null) {
                notificationManager.notifySDKError(42, PHHueResourcesConstants.TXT_NO_BRIDGE_OBJECT_FOUND);
                return;
            }
            return;
        }
        this.isProcessing = true;
        String responseFromResource = getResponseFromResource();
        if (responseFromResource != null) {
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(responseFromResource);
            if (error.size() != 0) {
                this.isProcessing = false;
                disconnectBridge(true);
                PHHueError pHHueError = error.get(0);
                if (notificationManager != null) {
                    notificationManager.notifySDKError(pHHueError.getCode(), pHHueError.getMessage());
                }
                cancel();
            } else {
                if (!this.notifyConnectionResume) {
                    this.notifyConnectionResume = true;
                    PHHueSDK storedSDKObject = PHHueSDK.getStoredSDKObject();
                    if (storedSDKObject != null) {
                        storedSDKObject.addBridge(this.bridge);
                    }
                }
                if (notificationManager != null) {
                    notificationManager.notifyConnectionResumed(this.bridge);
                }
                PHLog.d(TAG, "start processing HeartbeatResponse for type " + this.heartbeatType.toString());
                processHeartbeatResponse(responseFromResource);
            }
        } else {
            this.notifyConnectionResume = false;
            int i = this.currentTry;
            if (i < 1) {
                this.currentTry = i + 1;
                run();
            } else {
                disconnectBridge(false);
                if (notificationManager != null) {
                    notificationManager.notifySDKError(22, PHHueConstants.TXT_COULD_NOT_CONNECT);
                }
                PHAccessPoint pHAccessPointDisconnectedBridgeAsAccessPoint = disconnectedBridgeAsAccessPoint();
                if (notificationManager != null) {
                    notificationManager.notifyConnectionLost(pHAccessPointDisconnectedBridgeAsAccessPoint);
                }
            }
        }
        this.isProcessing = false;
    }
}
