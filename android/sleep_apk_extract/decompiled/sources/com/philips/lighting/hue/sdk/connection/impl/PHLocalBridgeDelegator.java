package com.philips.lighting.hue.sdk.connection.impl;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.listener.PHGroupListener;
import com.philips.lighting.hue.listener.PHHTTPListener;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.listener.PHRuleListener;
import com.philips.lighting.hue.listener.PHSceneListener;
import com.philips.lighting.hue.listener.PHScheduleListener;
import com.philips.lighting.hue.listener.PHSensorListener;
import com.philips.lighting.hue.listener.PHTimeZoneListener;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeResourcesCacheImpl;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.clip.PHTimeZoneSerializer;
import com.philips.lighting.hue.sdk.clip.serialisation.PHCLIPParserBase;
import com.philips.lighting.hue.sdk.data.PHHueConstants;
import com.philips.lighting.hue.sdk.exception.PHInvalidInputException;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl;
import com.philips.lighting.hue.sdk.util.PHHueCountTimer;
import com.philips.lighting.hue.sdk.util.PHHueCountTimerListener;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.PHSoftwareUpdateStatus;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHDaylightSensorConfiguration;
import com.philips.lighting.model.sensor.PHDaylightSensorState;
import com.philips.lighting.model.sensor.PHGenericFlagSensorState;
import com.philips.lighting.model.sensor.PHGenericStatusSensorState;
import com.philips.lighting.model.sensor.PHGeofenceSensorConfiguration;
import com.philips.lighting.model.sensor.PHGeofenceSensorState;
import com.philips.lighting.model.sensor.PHHumiditySensorState;
import com.philips.lighting.model.sensor.PHOpenCloseSensorState;
import com.philips.lighting.model.sensor.PHPresenceSensorConfiguration;
import com.philips.lighting.model.sensor.PHPresenceSensorState;
import com.philips.lighting.model.sensor.PHSensor;
import com.philips.lighting.model.sensor.PHSwitchState;
import com.philips.lighting.model.sensor.PHTemperatureSensorState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLocalBridgeDelegator implements PHBridgeDelegator {
    static final String ACTION = "/action";
    public static final boolean CACHE_UPDATE_DISABLED = false;
    private static final String CONFIG = "config";
    static final String CONFIGURATION = "/config";
    static final String GROUP = "groups/";
    static final String INFO = "info/";
    static final String LIGHT = "lights/";
    static final String LIGHTSTATES = "/lightstates";
    static final int LOCAL_KEY = 4626;
    static final String NEW = "new";
    static final String RULE = "rules/";
    static final String SCENE = "scenes/";
    static final String SCHEDULES = "schedules/";
    static final long SEARCH_DURATION = 60000;
    static final long SEARCH_ITERATION = 2000;
    static final String SENSOR = "sensors/";
    static final String SENSOR_STATE = "/state";
    static final String STARTUPSTATE = "/startupstate";
    static final String STATE = "/state";
    private static final String TAG = "PHLocalBridgeDelegator1_0";
    static final long TIMER_DELAY = 30000;
    static final String TIMEZONES = "timezones";
    private static final long UPGRADE_DURATION = 90000;
    private static final String WHITELIST = "/whitelist/";
    public static final boolean cacheUpdateDisabled = false;
    private String ipAddress;
    private String key;
    private PHHueCountTimer timer = null;
    private PHHueCountTimer softwareUpdateTimer = null;

    public PHLocalBridgeDelegator(String str, String str2) {
        this.ipAddress = str;
        this.key = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalBridgeUpdate(PHBridgeConfiguration pHBridgeConfiguration, Map<String, String> map, PHBridgeImpl pHBridgeImpl) {
        PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl = (PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache();
        PHBridgeConfiguration bridgeConfiguration = pHBridgeResourcesCacheImpl.getBridgeConfiguration();
        if (bridgeConfiguration == null) {
            bridgeConfiguration = new PHBridgeConfiguration();
            pHBridgeResourcesCacheImpl.setBridgeConfiguration(bridgeConfiguration);
        }
        String ipAddress = bridgeConfiguration.getIpAddress();
        boolean z = false;
        for (String str : map.keySet()) {
            if (str.endsWith("ipaddress")) {
                String ipAddress2 = pHBridgeConfiguration.getIpAddress();
                if (ipAddress != null && !ipAddress2.equals(ipAddress)) {
                    z = true;
                }
                this.ipAddress = ipAddress2;
                bridgeConfiguration.setIpAddress(ipAddress2);
                pHBridgeImpl.getBridgeDelegator().onIPAddressChanged(this.ipAddress);
            } else if (str.endsWith("name")) {
                bridgeConfiguration.setName(pHBridgeConfiguration.getName());
            } else if (str.endsWith("proxyaddress")) {
                bridgeConfiguration.setProxy(pHBridgeConfiguration.getProxy());
            } else if (str.endsWith("proxyport")) {
                bridgeConfiguration.setProxyPort(pHBridgeConfiguration.getProxyPort());
            } else if (str.endsWith("netmask")) {
                bridgeConfiguration.setNetmask(pHBridgeConfiguration.getNetmask());
            } else if (str.endsWith("gateway")) {
                bridgeConfiguration.setGateway(pHBridgeConfiguration.getGateway());
            } else if (str.endsWith("dhcp")) {
                bridgeConfiguration.setDhcpEnabled(pHBridgeConfiguration.getDhcpEnabled());
            } else if (str.endsWith("portalservices")) {
                bridgeConfiguration.setPortalServicesEnabled(pHBridgeConfiguration.getPortalServicesEnabled());
            } else if (str.endsWith("zigbeechannel")) {
                bridgeConfiguration.setZigbeeChannel(pHBridgeConfiguration.getZigbeeChannel());
            } else if (str.endsWith("timezone")) {
                bridgeConfiguration.setTimeZone(pHBridgeConfiguration.getTimeZone());
            }
            if (z) {
                PHLog.e("doLocalBridgeUpdate", ipAddress);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalGroupCreate(PHGroup pHGroup, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getGroups().put(pHGroup.getIdentifier(), pHGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalGroupDelete(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getGroups().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalGroupUpdate(PHGroup pHGroup, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        PHGroup pHGroup2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getGroups().get(pHGroup.getIdentifier());
        for (String str : map.keySet()) {
            if (str.endsWith("name")) {
                pHGroup2.setName(pHGroup.getName());
            } else if (str.endsWith("lights")) {
                pHGroup2.setLightIdentifiers(pHGroup.getLightIdentifiers());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalLightDelete(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getLights().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalLightStateUpdate(String str, Map<String, String> map, PHLightState pHLightState, PHBridgeImpl pHBridgeImpl) {
        PHLight pHLight = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getLights().get(str);
        PHLightState lastKnownLightState = pHLight.getLastKnownLightState();
        if (lastKnownLightState == null) {
            lastKnownLightState = new PHLightState();
            pHLight.setLastKnownLightState(lastKnownLightState);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (String str2 : map.keySet()) {
            if (str2.endsWith("on")) {
                lastKnownLightState.setOn(pHLightState.isOn());
            } else if (str2.endsWith("bri")) {
                lastKnownLightState.setBrightness(Integer.valueOf(Integer.parseInt(map.get(str2))));
            } else {
                if (str2.endsWith("hue")) {
                    lastKnownLightState.setHue(Integer.valueOf(Integer.parseInt(map.get(str2))));
                } else if (str2.endsWith("sat")) {
                    lastKnownLightState.setSaturation(Integer.valueOf(Integer.parseInt(map.get(str2))));
                } else if (str2.endsWith("xy")) {
                    JSONArray jSONArray = new JSONArray(map.get(str2));
                    lastKnownLightState.setX(Float.valueOf((float) jSONArray.optDouble(0)), true);
                    lastKnownLightState.setY(Float.valueOf((float) jSONArray.optDouble(1)), true);
                    z3 = true;
                } else if (str2.endsWith("alert")) {
                    lastKnownLightState.setAlertMode(pHLightState.getAlertMode());
                } else if (str2.endsWith("effect")) {
                    lastKnownLightState.setEffectMode(pHLightState.getEffectMode());
                } else if (str2.endsWith(UserDataStore.CITY)) {
                    lastKnownLightState.setCt(Integer.valueOf(Integer.parseInt(map.get(str2))));
                    z2 = true;
                }
                z = true;
            }
        }
        if (z) {
            lastKnownLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
        }
        if (z2) {
            lastKnownLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_CT);
        }
        if (z3) {
            lastKnownLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_XY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalLightUpdate(String str, String str2, PHBridgeImpl pHBridgeImpl) {
        Map<String, PHLight> lights = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getLights();
        if (lights.containsKey(str)) {
            lights.get(str).setName(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalRuleCreate(PHRule pHRule, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getRules().put(pHRule.getIdentifier(), pHRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalRuleDelete(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getRules().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalRuleUpdate(PHRule pHRule, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        PHRule pHRule2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getRules().get(pHRule.getIdentifier());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().endsWith("name")) {
                pHRule2.setName(pHRule.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSceneDelete(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getScenes().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSceneUpdate(PHScene pHScene, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getScenes().put(pHScene.getSceneIdentifier(), pHScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalScheduleCreated(PHSchedule pHSchedule, PHBridgeImpl pHBridgeImpl) {
        PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl = (PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache();
        Map<String, PHSchedule> schedules = pHBridgeResourcesCacheImpl.getSchedules();
        if (schedules == null) {
            schedules = new HashMap<>();
        }
        if (pHSchedule.getOwner() == null || pHSchedule.getOwner().equals("")) {
            pHSchedule.setOwner(pHBridgeResourcesCacheImpl.getBridgeConfiguration().getUsername());
        }
        schedules.put(pHSchedule.getIdentifier(), pHSchedule);
        pHBridgeResourcesCacheImpl.setSchedules(schedules);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalScheduleRemove(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSchedules().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalScheduleUpdate(PHSchedule pHSchedule, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        boolean z;
        boolean z2;
        PHSchedule pHSchedule2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSchedules().get(pHSchedule.getIdentifier());
        if (pHSchedule2 == null) {
            doLocalScheduleCreated(pHSchedule, pHBridgeImpl);
            return;
        }
        if (pHSchedule2.getOwner() == null || pHSchedule2.getOwner().equals("")) {
            pHSchedule2.setOwner(pHBridgeImpl.getResourceCache().getBridgeConfiguration().getUsername());
        }
        for (String str : map.keySet()) {
            if (str.endsWith("name")) {
                pHSchedule2.setName(pHSchedule.getName());
            } else if (str.endsWith("description")) {
                pHSchedule2.setDescription(pHSchedule.getDescription());
            } else if (str.endsWith("time")) {
                pHSchedule2.setDate(pHSchedule.getDate());
                pHSchedule2.setTimer(pHSchedule.getTimer());
                pHSchedule2.setRandomTime(pHSchedule.getRandomTime());
                pHSchedule2.setRecurringDays(pHSchedule.getRecurringDays());
                pHSchedule2.setRecurringTimerInterval(pHSchedule.getRecurringTimerInterval());
            } else if (str.endsWith("command")) {
                pHSchedule2.setLightIdentifier(pHSchedule.getLightIdentifier());
                pHSchedule2.setGroupIdentifier(pHSchedule.getGroupIdentifier());
                PHLightState lightState = pHSchedule.getLightState();
                PHLightState lightState2 = pHSchedule2.getLightState();
                if (lightState != null) {
                    if (lightState2 == null) {
                        lightState2 = new PHLightState();
                    }
                    if (lightState.isOn() != null) {
                        lightState2.setOn(lightState.isOn());
                    }
                    if (lightState.getAlertMode() != null) {
                        lightState2.setAlertMode(lightState.getAlertMode());
                    }
                    if (lightState.getBrightness() != null) {
                        lightState2.setBrightness(lightState.getBrightness());
                    }
                    if (lightState.getColorMode() != null) {
                        lightState2.setColorMode(lightState.getColorMode());
                    }
                    boolean z3 = false;
                    boolean z4 = true;
                    if (lightState.getCt() != null) {
                        lightState2.setCt(lightState.getCt());
                        z = true;
                    } else {
                        z = false;
                    }
                    if (lightState.getEffectMode() != null) {
                        lightState2.setEffectMode(lightState.getEffectMode());
                    }
                    if (lightState.getHue() != null) {
                        lightState2.setHue(lightState.getHue());
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (lightState.getSaturation() != null) {
                        lightState2.setSaturation(lightState.getSaturation());
                        z2 = true;
                    }
                    if (lightState.getTransitionTime() != null) {
                        lightState2.setTransitionTime(lightState.getTransitionTime());
                    }
                    if (lightState.getX() != null) {
                        lightState2.setX(lightState.getX());
                        z3 = true;
                    }
                    if (lightState.getY() != null) {
                        lightState2.setY(lightState.getY());
                    } else {
                        z4 = z3;
                    }
                    if (z2) {
                        lightState2.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
                    }
                    if (z) {
                        lightState2.setColorMode(PHLight.PHLightColorMode.COLORMODE_CT);
                    }
                    if (z4) {
                        lightState2.setColorMode(PHLight.PHLightColorMode.COLORMODE_XY);
                    }
                    if (lightState.getIncrementBri() != null) {
                        lightState2.setIncrementBri(lightState.getIncrementBri());
                    }
                    if (lightState.getIncrementCt() != null) {
                        lightState2.setIncrementCt(lightState.getIncrementCt());
                    }
                    if (lightState.getIncrementHue() != null) {
                        lightState2.setIncrementHue(lightState.getIncrementHue());
                    }
                    if (lightState.getIncrementSat() != null) {
                        lightState2.setIncrementSat(lightState.getIncrementSat());
                    }
                    if (lightState.getIncrementX() != null) {
                        lightState2.setIncrementX(lightState.getIncrementX());
                    }
                    if (lightState.getIncrementY() != null) {
                        lightState2.setIncrementY(lightState.getIncrementY());
                    }
                }
                pHSchedule2.setLightState(lightState2);
            } else if (str.endsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                pHSchedule2.setStatus(pHSchedule.getStatus());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSensorConfigUpdate(PHSensor pHSensor, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        PHSensor pHSensor2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSensors().get(pHSensor.getIdentifier());
        for (String str : map.keySet()) {
            if (str.endsWith("on")) {
                pHSensor2.getBaseConfiguration().setOn(pHSensor.getBaseConfiguration().getOn());
            } else if (str.endsWith("url")) {
                pHSensor2.getBaseConfiguration().setUrl(pHSensor.getBaseConfiguration().getUrl());
            } else if (str.endsWith("battery")) {
                pHSensor2.getBaseConfiguration().setBattery(pHSensor.getBaseConfiguration().getBattery());
            } else if (pHSensor.getBaseConfiguration() instanceof PHPresenceSensorConfiguration) {
                if (str.endsWith("motionsensitivity")) {
                    ((PHPresenceSensorConfiguration) pHSensor2.getBaseConfiguration()).setMotionSensitivity(((PHPresenceSensorConfiguration) pHSensor.getBaseConfiguration()).getMotionSensitivity());
                }
            } else if (pHSensor.getBaseConfiguration() instanceof PHGeofenceSensorConfiguration) {
                if (str.endsWith("radius")) {
                    ((PHGeofenceSensorConfiguration) pHSensor2.getBaseConfiguration()).setRadius(((PHGeofenceSensorConfiguration) pHSensor.getBaseConfiguration()).getRadius());
                } else if (str.endsWith(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) {
                    ((PHGeofenceSensorConfiguration) pHSensor2.getBaseConfiguration()).setDevice(((PHGeofenceSensorConfiguration) pHSensor.getBaseConfiguration()).getDevice());
                }
            } else if (pHSensor.getBaseConfiguration() instanceof PHDaylightSensorConfiguration) {
                if (str.endsWith("long")) {
                    ((PHDaylightSensorConfiguration) pHSensor2.getBaseConfiguration()).setLongitude(((PHDaylightSensorConfiguration) pHSensor.getBaseConfiguration()).getLongitude());
                } else if (str.endsWith("lat")) {
                    ((PHDaylightSensorConfiguration) pHSensor2.getBaseConfiguration()).setLatitude(((PHDaylightSensorConfiguration) pHSensor.getBaseConfiguration()).getLatitude());
                } else if (str.endsWith("sunriseoffset")) {
                    ((PHDaylightSensorConfiguration) pHSensor2.getBaseConfiguration()).setSunriseOffset(((PHDaylightSensorConfiguration) pHSensor.getBaseConfiguration()).getSunriseOffset());
                } else if (str.endsWith("sunsetoffset")) {
                    ((PHDaylightSensorConfiguration) pHSensor2.getBaseConfiguration()).setSunsetOffset(((PHDaylightSensorConfiguration) pHSensor.getBaseConfiguration()).getSunsetOffset());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSensorCreate(PHSensor pHSensor, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSensors().put(pHSensor.getIdentifier(), pHSensor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSensorDelete(String str, PHBridgeImpl pHBridgeImpl) {
        ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSensors().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSensorStateUpdate(PHSensor pHSensor, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        PHSensor pHSensor2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSensors().get(pHSensor.getIdentifier());
        for (String str : map.keySet()) {
            if (pHSensor.getBaseState() instanceof PHGenericFlagSensorState) {
                if (str.endsWith("flag")) {
                    ((PHGenericFlagSensorState) pHSensor2.getBaseState()).setFlag(((PHGenericFlagSensorState) pHSensor.getBaseState()).getFlag());
                }
            } else if (pHSensor.getBaseState() instanceof PHGenericStatusSensorState) {
                if (str.endsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                    ((PHGenericStatusSensorState) pHSensor2.getBaseState()).setStatus(((PHGenericStatusSensorState) pHSensor.getBaseState()).getStatus());
                }
            } else if (pHSensor.getBaseState() instanceof PHSwitchState) {
                if (str.endsWith("buttonevent")) {
                    ((PHSwitchState) pHSensor2.getBaseState()).setButtonEvent(((PHSwitchState) pHSensor.getBaseState()).getButtonEvent());
                }
            } else if (pHSensor.getBaseState() instanceof PHOpenCloseSensorState) {
                if (str.endsWith("open")) {
                    ((PHOpenCloseSensorState) pHSensor2.getBaseState()).setOpen(((PHOpenCloseSensorState) pHSensor.getBaseState()).getOpen());
                }
            } else if (pHSensor.getBaseState() instanceof PHPresenceSensorState) {
                if (str.endsWith("presence")) {
                    ((PHPresenceSensorState) pHSensor2.getBaseState()).setPresence(((PHPresenceSensorState) pHSensor.getBaseState()).getPresence());
                }
            } else if (pHSensor.getBaseState() instanceof PHGeofenceSensorState) {
                if (str.endsWith("presence")) {
                    ((PHGeofenceSensorState) pHSensor2.getBaseState()).setPresence(((PHGeofenceSensorState) pHSensor.getBaseState()).getPresence());
                }
            } else if (pHSensor.getBaseState() instanceof PHTemperatureSensorState) {
                if (str.endsWith("temperature")) {
                    ((PHTemperatureSensorState) pHSensor2.getBaseState()).setTemperature(((PHTemperatureSensorState) pHSensor.getBaseState()).getTemperature());
                }
            } else if (pHSensor.getBaseState() instanceof PHHumiditySensorState) {
                if (str.endsWith("humidity")) {
                    ((PHHumiditySensorState) pHSensor2.getBaseState()).setHumidity(((PHHumiditySensorState) pHSensor.getBaseState()).getHumidity());
                }
            } else if ((pHSensor.getBaseState() instanceof PHDaylightSensorState) && str.endsWith("daylight")) {
                ((PHDaylightSensorState) pHSensor2.getBaseState()).setDaylight(((PHDaylightSensorState) pHSensor.getBaseState()).getDaylight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalSensorUpdate(PHSensor pHSensor, PHBridgeImpl pHBridgeImpl, Map<String, String> map) {
        PHSensor pHSensor2 = ((PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache()).getSensors().get(pHSensor.getIdentifier());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().endsWith("name")) {
                pHSensor2.setName(pHSensor.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doLocalUpdateGroupLights(PHBridgeImpl pHBridgeImpl, Map<String, String> map, PHLightState pHLightState, String str) {
        PHBridgeResourcesCacheImpl pHBridgeResourcesCacheImpl = (PHBridgeResourcesCacheImpl) pHBridgeImpl.getResourceCache();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Map<String, PHLight> lights = pHBridgeResourcesCacheImpl.getLights();
            HashMap map2 = new HashMap();
            for (PHLight pHLight : new ArrayList(lights.values())) {
                pHLight.setLastKnownLightState(getNewLightState(pHLight.getLastKnownLightState(), map, pHLightState));
                map2.put(pHLight.getIdentifier(), pHLight);
            }
            pHBridgeResourcesCacheImpl.setLights(map2);
            return true;
        }
        PHGroup pHGroup = pHBridgeResourcesCacheImpl.getGroups().get(str);
        if (pHGroup == null) {
            return false;
        }
        Map<String, PHLight> lights2 = pHBridgeResourcesCacheImpl.getLights();
        HashMap map3 = new HashMap();
        for (PHLight pHLight2 : new ArrayList(lights2.values())) {
            map3.put(pHLight2.getIdentifier(), pHLight2);
        }
        for (String str2 : pHGroup.getLightIdentifiers()) {
            PHLight pHLight3 = (PHLight) map3.get(str2);
            pHLight3.setLastKnownLightState(getNewLightState(pHLight3.getLastKnownLightState(), map, pHLightState));
            map3.remove(str2);
            map3.put(str2, pHLight3);
        }
        pHBridgeResourcesCacheImpl.setLights(map3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBridgeConfigurations(final PHBridgeConfigurationListener pHBridgeConfigurationListener, PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.CONFIG);
                    String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                    if (data2 == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, 46, null);
                            return;
                        }
                        return;
                    }
                    List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(data2);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHBridgeConfigurationListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    PHBridgeConfiguration bridgeConfiguration = PHBridgeVersionManager.getInstance().getBridgeConfigurationSerializer().parseBridgeConfiguration(new JSONObject(data2));
                    PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                    if (pHNotificationManagerImpl3 != null) {
                        pHNotificationManagerImpl3.notifyBridgeConfigReceived(pHBridgeConfigurationListener, bridgeConfiguration);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPIError(pHBridgeConfigurationListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    private PHLightState getNewLightState(PHLightState pHLightState, Map<String, String> map, PHLightState pHLightState2) {
        if (pHLightState == null) {
            return pHLightState2;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (String str : map.keySet()) {
            if (str.endsWith("on")) {
                pHLightState.setOn(pHLightState2.isOn());
            } else if (str.endsWith("bri")) {
                pHLightState.setBrightness(Integer.valueOf(Integer.parseInt(map.get(str))));
            } else {
                if (str.endsWith("hue")) {
                    pHLightState.setHue(Integer.valueOf(Integer.parseInt(map.get(str))));
                } else if (str.endsWith("sat")) {
                    pHLightState.setSaturation(Integer.valueOf(Integer.parseInt(map.get(str))));
                } else if (str.endsWith("xy")) {
                    JSONArray jSONArray = new JSONArray(map.get(str));
                    pHLightState.setX(Float.valueOf((float) jSONArray.optDouble(0)), true);
                    pHLightState.setY(Float.valueOf((float) jSONArray.optDouble(1)), true);
                    z3 = true;
                } else if (str.endsWith("alert")) {
                    pHLightState.setAlertMode(pHLightState2.getAlertMode());
                } else if (str.endsWith("effect")) {
                    pHLightState.setEffectMode(pHLightState2.getEffectMode());
                } else if (str.endsWith(UserDataStore.CITY)) {
                    pHLightState.setCt(Integer.valueOf(Integer.parseInt(map.get(str))));
                    z2 = true;
                }
                z = true;
            }
        }
        if (z) {
            pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION);
        }
        if (z2) {
            pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_CT);
        }
        if (z3) {
            pHLightState.setColorMode(PHLight.PHLightColorMode.COLORMODE_XY);
        }
        if (pHLightState2.getIncrementBri() != null && pHLightState2.getBrightness() == null && pHLightState.getBrightness() != null) {
            pHLightState.setBrightness(Integer.valueOf(pHLightState2.getIncrementBri().intValue() + pHLightState.getBrightness().intValue()), true);
        }
        if (pHLightState2.getIncrementHue() != null && pHLightState2.getHue() == null && pHLightState.getHue() != null) {
            pHLightState.setHue(Integer.valueOf(pHLightState2.getIncrementHue().intValue() + pHLightState.getHue().intValue()), true);
        }
        if (pHLightState2.getIncrementSat() != null && pHLightState2.getSaturation() == null && pHLightState.getSaturation() != null) {
            pHLightState.setSaturation(Integer.valueOf(pHLightState2.getIncrementSat().intValue() + pHLightState.getSaturation().intValue()), true);
        }
        if (pHLightState2.getIncrementCt() != null && pHLightState2.getCt() == null && pHLightState.getCt() != null) {
            pHLightState.setCt(Integer.valueOf(pHLightState2.getIncrementCt().intValue() + pHLightState.getCt().intValue()), true);
        }
        if (pHLightState2.getIncrementX() != null && pHLightState2.getX() == null && pHLightState.getX() != null) {
            pHLightState.setX(Float.valueOf(pHLightState2.getIncrementX().floatValue() + pHLightState.getX().floatValue()), true);
        }
        if (pHLightState2.getIncrementY() != null && pHLightState2.getY() == null && pHLightState.getY() != null) {
            pHLightState.setY(Float.valueOf(pHLightState2.getIncrementY().floatValue() + pHLightState.getY().floatValue()), true);
        }
        return pHLightState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSoftwareUpdateStatus(final PHBridgeConfigurationListener pHBridgeConfigurationListener, final PHBridgeImpl pHBridgeImpl) {
        PHHueCountTimer pHHueCountTimer = new PHHueCountTimer(UPGRADE_DURATION, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.14
            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
            public void onFinish() {
            }

            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
            public void onTick() {
                PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                final PHBridgeConfigurationListener pHBridgeConfigurationListener2 = pHBridgeConfigurationListener;
                final PHBridgeImpl pHBridgeImpl2 = pHBridgeImpl;
                pHLocalBridgeDelegator.getBridgeConfigurations(new PHBridgeConfigurationListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.14.1
                    @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                    public void onError(int i, String str) {
                        PHLocalBridgeDelegator.this.softwareUpdateTimer.restart(PHLocalBridgeDelegator.TIMER_DELAY);
                    }

                    @Override // com.philips.lighting.hue.listener.PHBridgeConfigurationListener
                    public void onReceivingConfiguration(PHBridgeConfiguration pHBridgeConfiguration) {
                        PHLocalBridgeDelegator.this.softwareUpdateRemoveNotify(pHBridgeConfigurationListener2, pHBridgeImpl2);
                    }

                    @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                    public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
                    }

                    @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                    public void onSuccess() {
                    }
                }, pHBridgeImpl);
            }
        });
        this.softwareUpdateTimer = pHHueCountTimer;
        pHHueCountTimer.start(TIMER_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean searchLights(PHNotificationManagerImpl pHNotificationManagerImpl, PHLightListener pHLightListener) throws Throwable {
        if (pHNotificationManagerImpl == null) {
            return false;
        }
        try {
            StringBuffer stringBufferBuildHttpAddress = buildHttpAddress();
            stringBufferBuildHttpAddress.append(LIGHT);
            String strPostData = getConnectionObject().postData("", stringBufferBuildHttpAddress.toString());
            if (strPostData == null) {
                pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 46, PHHueConstants.TXT_COULD_NOT_SEARCH_LIGHTS);
                return false;
            }
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPostData);
            if (error.size() == 0) {
                return true;
            }
            PHHueError pHHueError = error.get(0);
            pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, pHHueError.getCode(), pHHueError.getMessage());
            return false;
        } catch (Exception e) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "Exception: " + e);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean searchSensors(PHNotificationManagerImpl pHNotificationManagerImpl, PHSensorListener pHSensorListener) throws Throwable {
        if (pHNotificationManagerImpl == null) {
            return false;
        }
        try {
            StringBuffer stringBufferBuildHttpAddress = buildHttpAddress();
            stringBufferBuildHttpAddress.append(SENSOR);
            String strPostData = getConnectionObject().postData("", stringBufferBuildHttpAddress.toString());
            if (strPostData == null) {
                pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 46, PHHueConstants.TXT_COULD_NOT_SEARCH_SENSORS);
                return false;
            }
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPostData);
            if (error.size() == 0) {
                pHNotificationManagerImpl.notifyBridgeAPISuccess(pHSensorListener);
                return true;
            }
            PHHueError pHHueError = error.get(0);
            pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
            return false;
        } catch (Exception e) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "Exception: " + e);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean searchSensorsWithSerials(PHNotificationManagerImpl pHNotificationManagerImpl, List<String> list, PHSensorListener pHSensorListener) throws Throwable {
        if (pHNotificationManagerImpl == null) {
            return false;
        }
        StringBuffer stringBufferBuildHttpAddress = buildHttpAddress();
        stringBufferBuildHttpAddress.append(SENSOR);
        String string = stringBufferBuildHttpAddress.toString();
        try {
            String strPostData = getConnectionObject().postData(PHBridgeVersionManager.getInstance().getSensorSerializer().createFindSensorWithSerialsPacket(list).toString(), string);
            if (strPostData == null) {
                pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                return false;
            }
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPostData);
            if (error.size() == 0) {
                pHNotificationManagerImpl.notifyBridgeAPISuccess(pHSensorListener);
                return true;
            }
            PHHueError pHHueError = error.get(0);
            pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
            return false;
        } catch (Exception e) {
            pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void softwareUpdateRemoveNotify(final PHBridgeConfigurationListener pHBridgeConfigurationListener, PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        try {
            PHBridgeConfiguration pHBridgeConfiguration = new PHBridgeConfiguration();
            PHSoftwareUpdateStatus pHSoftwareUpdateStatus = new PHSoftwareUpdateStatus();
            pHSoftwareUpdateStatus.setState(PHSoftwareUpdateStatus.PHStateType.NO_UPDATE);
            pHBridgeConfiguration.setSoftwareStatus(pHSoftwareUpdateStatus);
            updateBridgeConfigurations(pHBridgeConfiguration, new PHBridgeConfigurationListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.15
                @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                public void onError(int i, String str) {
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, i, str);
                    }
                }

                @Override // com.philips.lighting.hue.listener.PHBridgeConfigurationListener
                public void onReceivingConfiguration(PHBridgeConfiguration pHBridgeConfiguration2) {
                }

                @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyBridgeAPISuccess(pHBridgeConfigurationListener);
                    }
                }

                @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
                public void onSuccess() {
                }
            }, pHBridgeImpl);
        } catch (Exception e) {
            notificationManager.notifyBridgeAPIError(pHBridgeConfigurationListener, 42, e.getMessage());
        }
    }

    private void startSoftwareUpdate(final PHBridgeConfigurationListener pHBridgeConfigurationListener, final PHBridgeImpl pHBridgeImpl) {
        PHBridgeConfiguration pHBridgeConfiguration = new PHBridgeConfiguration();
        PHSoftwareUpdateStatus pHSoftwareUpdateStatus = new PHSoftwareUpdateStatus();
        pHSoftwareUpdateStatus.setState(PHSoftwareUpdateStatus.PHStateType.INSTALLING_UPDATES);
        pHBridgeConfiguration.setSoftwareStatus(pHSoftwareUpdateStatus);
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        updateBridgeConfigurations(pHBridgeConfiguration, new PHBridgeConfigurationListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.13
            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onError(int i, String str) {
                PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                if (pHNotificationManagerImpl != null) {
                    pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, i, str);
                }
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeConfigurationListener
            public void onReceivingConfiguration(PHBridgeConfiguration pHBridgeConfiguration2) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
                if (list.size() <= 0) {
                    PHLocalBridgeDelegator.this.getSoftwareUpdateStatus(pHBridgeConfigurationListener, pHBridgeImpl);
                    return;
                }
                PHHueError pHHueError = list.get(0);
                PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                if (pHNotificationManagerImpl != null) {
                    pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, pHHueError.getCode(), pHHueError.getAddress());
                }
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onSuccess() {
            }
        }, pHBridgeImpl);
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void activateScene(final String str, final String str2, final PHSceneListener pHSceneListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.18
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.GROUP);
                    stringBufferBuildHttpAddress.append(str2);
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.ACTION);
                    try {
                        String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(PHBridgeVersionManager.getInstance().getScenesSerializer().createActivateScenePacket(str).toString(), stringBufferBuildHttpAddress.toString());
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHSceneListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                                return;
                            }
                            return;
                        }
                        List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPutData);
                        if (error.size() == 0) {
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPISuccess(pHSceneListener);
                                return;
                            }
                            return;
                        }
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHSceneListener, pHHueError.getCode(), pHHueError.getMessage());
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIError(pHSceneListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    public StringBuffer buildHttpAddress() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://");
        stringBuffer.append(this.ipAddress);
        stringBuffer.append("/api/");
        stringBuffer.append(this.key);
        stringBuffer.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        return stringBuffer;
    }

    public StringBuffer buildScheduleCommand(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/api/");
        stringBuffer.append(str);
        stringBuffer.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        return stringBuffer;
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void createGroup(final PHGroup pHGroup, final PHGroupListener pHGroupListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getGroupSerializer().createGroupPacket(pHGroup).toString();
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.GROUP);
                    String strPostData = PHLocalBridgeDelegator.this.getConnectionObject().postData(string, stringBufferBuildHttpAddress.toString());
                    if (strPostData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHGroupListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPostData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHGroupListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    String str = pHCLIPParserBase.parseSuccess(strPostData).get("id");
                    if (str == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHGroupListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    PHGroup pHGroup2 = new PHGroup(pHGroup.getName(), str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r0.length - 1]);
                    pHGroup2.setLightIdentifiers(pHGroup.getLightIdentifiers());
                    if (pHGroup2.getIdentifier() != null) {
                        PHLocalBridgeDelegator.this.doLocalGroupCreate(pHGroup2, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.GROUPS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyGroupCreated(pHGroupListener, pHGroup2);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHGroupListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void createRule(final PHRule pHRule, final PHRuleListener pHRuleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.29
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getRulesSerializer().createRule(pHRule).toString();
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.RULE);
                    String strPostData = PHLocalBridgeDelegator.this.getConnectionObject().postData(string, stringBufferBuildHttpAddress.toString());
                    if (strPostData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHRuleListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPostData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHRuleListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    String str = pHCLIPParserBase.parseSuccess(strPostData).get("id");
                    if (str == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHRuleListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    pHRule.setIdentifier(str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r0.length - 1]);
                    if (pHRule.getIdentifier() != null) {
                        PHLocalBridgeDelegator.this.doLocalRuleCreate(pHRule, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.RULE_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyRuleDetails(pHRuleListener, pHRule);
                        notificationManager.notifyBridgeAPISuccess(pHRuleListener);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHRuleListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void createSchedule(final PHSchedule pHSchedule, final PHScheduleListener pHScheduleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHScheduleListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else if (schedulesSerializer.validateAPI(pHSchedule)) {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.10
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    String string;
                    String owner = PHLocalBridgeDelegator.this.getOwner(pHBridgeImpl, pHSchedule);
                    if (pHSchedule.getLightIdentifier() != null) {
                        StringBuffer stringBufferBuildScheduleCommand = PHLocalBridgeDelegator.this.buildScheduleCommand(owner);
                        stringBufferBuildScheduleCommand.append(PHLocalBridgeDelegator.LIGHT);
                        stringBufferBuildScheduleCommand.append(pHSchedule.getLightIdentifier());
                        stringBufferBuildScheduleCommand.append("/state");
                        string = stringBufferBuildScheduleCommand.toString();
                    } else if (pHSchedule.getGroupIdentifier() != null) {
                        StringBuffer stringBufferBuildScheduleCommand2 = PHLocalBridgeDelegator.this.buildScheduleCommand(owner);
                        stringBufferBuildScheduleCommand2.append(PHLocalBridgeDelegator.GROUP);
                        stringBufferBuildScheduleCommand2.append(pHSchedule.getGroupIdentifier());
                        stringBufferBuildScheduleCommand2.append(PHLocalBridgeDelegator.ACTION);
                        string = stringBufferBuildScheduleCommand2.toString();
                    } else if (pHSchedule.getSceneIdentifier() != null) {
                        String groupIdentifier = pHSchedule.getGroupIdentifier();
                        PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                        if (groupIdentifier != null) {
                            StringBuffer stringBufferBuildScheduleCommand3 = pHLocalBridgeDelegator.buildScheduleCommand(owner);
                            stringBufferBuildScheduleCommand3.append(PHLocalBridgeDelegator.GROUP);
                            stringBufferBuildScheduleCommand3.append(pHSchedule.getGroupIdentifier());
                            stringBufferBuildScheduleCommand3.append(PHLocalBridgeDelegator.ACTION);
                            string = stringBufferBuildScheduleCommand3.toString();
                        } else {
                            StringBuffer stringBufferBuildScheduleCommand4 = pHLocalBridgeDelegator.buildScheduleCommand(owner);
                            stringBufferBuildScheduleCommand4.append(PHLocalBridgeDelegator.GROUP);
                            stringBufferBuildScheduleCommand4.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            stringBufferBuildScheduleCommand4.append(PHLocalBridgeDelegator.ACTION);
                            string = stringBufferBuildScheduleCommand4.toString();
                        }
                    } else {
                        string = null;
                    }
                    try {
                        String string2 = PHBridgeVersionManager.getInstance().getSchedulesSerializer().createSchedulePacket(pHSchedule, string, "PUT", pHBridgeImpl.getResourceCache().getBridgeConfiguration().getTimeZone()).toString();
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCHEDULES);
                        String strPostData = PHLocalBridgeDelegator.this.getConnectionObject().postData(string2, stringBufferBuildHttpAddress.toString());
                        if (strPostData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHScheduleListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPostData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHScheduleListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        String str = pHCLIPParserBase.parseSuccess(strPostData).get("id");
                        if (str == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHScheduleListener, 52, PHHueConstants.TXT_INVALID_JSON);
                                return;
                            }
                            return;
                        }
                        pHSchedule.setIdentifier(str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r0.length - 1]);
                        PHLocalBridgeDelegator.this.doLocalScheduleCreated(pHSchedule, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SCHEDULES_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyScheduleCreated(pHScheduleListener, pHSchedule);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                        if (pHNotificationManagerImpl6 != null) {
                            pHNotificationManagerImpl6.notifyBridgeAPIError(pHScheduleListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        } else {
            notificationManager.notifyBridgeAPIError(pHScheduleListener, 54, PHHueConstants.TXT_UNSUPPORTED_IN_EXISTING_VERSION);
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void createSensor(final PHSensor pHSensor, final PHSensorListener pHSensorListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSensorListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.24
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        String string = PHBridgeVersionManager.getInstance().getSensorSerializer().createSensorPacket(pHSensor).toString();
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                        String strPostData = PHLocalBridgeDelegator.this.getConnectionObject().postData(string, stringBufferBuildHttpAddress.toString());
                        if (strPostData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPostData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        String str = pHCLIPParserBase.parseSuccess(strPostData).get("id");
                        if (str == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHSensorListener, 52, PHHueConstants.TXT_INVALID_JSON);
                                return;
                            }
                            return;
                        }
                        pHSensor.setIdentifier(str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r0.length - 1]);
                        if (pHSensor.getIdentifier() != null) {
                            PHLocalBridgeDelegator.this.doLocalSensorCreate(pHSensor, pHBridgeImpl);
                            PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                            if (pHNotificationManagerImpl4 != null) {
                                pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SENSOR_CACHE_UPDATED.intValue(), pHBridgeImpl);
                            }
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifySensorDetails(pHSensorListener, pHSensor);
                            notificationManager.notifyBridgeAPISuccess(pHSensorListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                        if (pHNotificationManagerImpl6 != null) {
                            pHNotificationManagerImpl6.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void deleteGroup(final String str, final PHGroupListener pHGroupListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.GROUP);
                    stringBufferBuildHttpAddress.append(str);
                    String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                    if (strDeleteData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHGroupListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHGroupListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHGroupListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalGroupDelete(str, pHBridgeImpl);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.GROUPS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHGroupListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHGroupListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void deleteLight(final String str, final PHLightListener pHLightListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canDelete()) {
            notificationManager.notifyBridgeAPIError(pHLightListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.20
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHT);
                        stringBufferBuildHttpAddress.append(str);
                        String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                        if (strDeleteData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHLightListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHLightListener, 52, PHHueConstants.TXT_INVALID_JSON);
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalLightDelete(str, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.LIGHTS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHLightListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                        if (pHNotificationManagerImpl6 != null) {
                            pHNotificationManagerImpl6.notifyBridgeAPIError(pHLightListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void deleteRule(final String str, final PHRuleListener pHRuleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.31
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.RULE);
                    stringBufferBuildHttpAddress.append(str);
                    String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                    if (strDeleteData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHRuleListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHRuleListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHRuleListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalRuleDelete(str, pHBridgeImpl);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.RULE_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHRuleListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHRuleListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void deleteScene(final String str, final PHSceneListener pHSceneListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canDelete()) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.36
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCENE);
                        stringBufferBuildHttpAddress.append(str);
                        String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                        if (strDeleteData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHSceneListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHSceneListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHSceneListener, 52, PHHueConstants.TXT_INVALID_JSON);
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalSceneDelete(str, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.LIGHTS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHSceneListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                        if (pHNotificationManagerImpl6 != null) {
                            pHNotificationManagerImpl6.notifyBridgeAPIError(pHSceneListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void deleteSensor(final String str, final PHSensorListener pHSensorListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.26
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                    stringBufferBuildHttpAddress.append(str);
                    String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                    if (strDeleteData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHSensorListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalSensorDelete(str, pHBridgeImpl);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SENSOR_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHSensorListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void doDelete(String str, PHHTTPListener pHHTTPListener) {
        doPostOrPutOrDelete("DELETE", str, "", pHHTTPListener);
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void doGet(final String str, final PHHTTPListener pHHTTPListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.33
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(str);
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (data2 == null) {
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyHTTPResponse(pHHTTPListener, "Unable to Process Request");
                        }
                    } else if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyHTTPResponse(pHHTTPListener, data2);
                    }
                } catch (Exception unused) {
                    PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                    if (pHNotificationManagerImpl2 != null) {
                        pHNotificationManagerImpl2.notifyHTTPResponse(pHHTTPListener, "Unable to Process Request");
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void doPost(String str, String str2, PHHTTPListener pHHTTPListener) {
        doPostOrPutOrDelete("POST", str, str2, pHHTTPListener);
    }

    public void doPostOrPutOrDelete(final String str, final String str2, final String str3, final PHHTTPListener pHHTTPListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.34
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    PHHueHttpConnection connectionObject = PHLocalBridgeDelegator.this.getConnectionObject();
                    String strPutData = str.equalsIgnoreCase("PUT") ? connectionObject.putData(str3, str2) : str.equalsIgnoreCase("POST") ? connectionObject.postData(str3, str2) : connectionObject.deleteData(str2);
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (strPutData == null) {
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyHTTPResponse(pHHTTPListener, "Unable to Process Request");
                        }
                    } else if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyHTTPResponse(pHHTTPListener, strPutData);
                    }
                } catch (Exception unused) {
                    PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                    if (pHNotificationManagerImpl2 != null) {
                        pHNotificationManagerImpl2.notifyHTTPResponse(pHHTTPListener, "Unable to Process Request");
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void doPut(String str, String str2, PHHTTPListener pHHTTPListener) {
        doPostOrPutOrDelete("PUT", str, str2, pHHTTPListener);
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void findNewLights(final PHLightListener pHLightListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (PHLocalBridgeDelegator.this.searchLights(notificationManager, pHLightListener)) {
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.startSearchNotification();
                    }
                    if (PHLocalBridgeDelegator.this.timer != null && PHLocalBridgeDelegator.this.timer.isRunning()) {
                        PHLocalBridgeDelegator.this.timer.stop();
                    }
                    PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                    final PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                    final PHLightListener pHLightListener2 = pHLightListener;
                    pHLocalBridgeDelegator.timer = new PHHueCountTimer(PHLocalBridgeDelegator.SEARCH_DURATION, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.1.1
                        @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                        public void onFinish() {
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyLightHeaders(pHLightListener2, new ArrayList(), true);
                            }
                        }

                        @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                        public void onTick() throws Throwable {
                            try {
                                StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHT);
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.NEW);
                                String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                                if (data2 != null) {
                                    List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(data2);
                                    if (error.size() != 0) {
                                        PHHueError pHHueError = error.get(0);
                                        PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                                        if (pHNotificationManagerImpl3 != null) {
                                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHLightListener2, pHHueError.getCode(), pHHueError.getMessage());
                                        }
                                    } else {
                                        List<PHBridgeResource> getAllLightHeaders = PHBridgeVersionManager.getInstance().getLightSerializer().parseGetAllLightHeaders(data2);
                                        if (getAllLightHeaders == null || getAllLightHeaders.size() == 0) {
                                            pHNotificationManagerImpl2.notifyLightHeaders(pHLightListener2, new ArrayList(), false);
                                        } else {
                                            PHNotificationManagerImpl pHNotificationManagerImpl4 = pHNotificationManagerImpl2;
                                            if (pHNotificationManagerImpl4 != null) {
                                                pHNotificationManagerImpl4.notifyLightHeaders(pHLightListener2, getAllLightHeaders, false);
                                            }
                                        }
                                        if (!new JSONObject(data2).optString("lastscan").equals("active")) {
                                            onFinish();
                                            return;
                                        }
                                    }
                                }
                                PHNotificationManagerImpl pHNotificationManagerImpl5 = pHNotificationManagerImpl2;
                                if (pHNotificationManagerImpl5 != null) {
                                    if (pHNotificationManagerImpl5.isSearchRunning()) {
                                        PHLocalBridgeDelegator.this.timer.restart(PHLocalBridgeDelegator.SEARCH_ITERATION);
                                    } else {
                                        pHNotificationManagerImpl2.notifyLightHeaders(pHLightListener2, new ArrayList(), true);
                                    }
                                }
                            } catch (Exception e) {
                                if (PHLog.isLoggable()) {
                                    PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                                }
                                PHNotificationManagerImpl pHNotificationManagerImpl6 = pHNotificationManagerImpl2;
                                if (pHNotificationManagerImpl6 != null) {
                                    pHNotificationManagerImpl6.notifyBridgeAPIError(pHLightListener2, 42, e.getMessage());
                                }
                            }
                        }
                    });
                    PHLocalBridgeDelegator.this.timer.start(0L);
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void findNewLightsWithSerials(final List<String> list, final PHLightListener pHLightListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHLightListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.19
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (PHLocalBridgeDelegator.this.searchLightsWithSerials(notificationManager, list, pHLightListener)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.startSearchNotification();
                        }
                        if (PHLocalBridgeDelegator.this.timer != null && PHLocalBridgeDelegator.this.timer.isRunning()) {
                            PHLocalBridgeDelegator.this.timer.stop();
                        }
                        PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                        final PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        final PHLightListener pHLightListener2 = pHLightListener;
                        pHLocalBridgeDelegator.timer = new PHHueCountTimer(PHLocalBridgeDelegator.SEARCH_DURATION, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.19.1
                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onFinish() {
                                pHNotificationManagerImpl2.notifyLightHeaders(pHLightListener2, new ArrayList(), true);
                            }

                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onTick() throws Throwable {
                                StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHT);
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.NEW);
                                try {
                                    String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                                    if (data2 != null) {
                                        if (PHCLIPParserBase.getInstance().parseError(data2).size() != 0) {
                                            PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                                            if (pHNotificationManagerImpl3 != null) {
                                                pHNotificationManagerImpl3.notifyLightHeaders(pHLightListener2, new ArrayList(), false);
                                            }
                                        } else {
                                            List<PHBridgeResource> getAllLightHeaders = PHBridgeVersionManager.getInstance().getLightSerializer().parseGetAllLightHeaders(data2);
                                            if (getAllLightHeaders == null || getAllLightHeaders.size() == 0) {
                                                PHNotificationManagerImpl pHNotificationManagerImpl4 = pHNotificationManagerImpl2;
                                                if (pHNotificationManagerImpl4 != null) {
                                                    pHNotificationManagerImpl4.notifyLightHeaders(pHLightListener2, new ArrayList(), false);
                                                }
                                            } else {
                                                PHNotificationManagerImpl pHNotificationManagerImpl5 = pHNotificationManagerImpl2;
                                                if (pHNotificationManagerImpl5 != null) {
                                                    pHNotificationManagerImpl5.notifyLightHeaders(pHLightListener2, getAllLightHeaders, false);
                                                }
                                            }
                                            if (!new JSONObject(data2).optString("lastscan").equals("active")) {
                                                onFinish();
                                                return;
                                            }
                                        }
                                    }
                                    PHNotificationManagerImpl pHNotificationManagerImpl6 = pHNotificationManagerImpl2;
                                    if (pHNotificationManagerImpl6 != null) {
                                        if (pHNotificationManagerImpl6.isSearchRunning()) {
                                            PHLocalBridgeDelegator.this.timer.restart(PHLocalBridgeDelegator.SEARCH_ITERATION);
                                        } else {
                                            pHNotificationManagerImpl2.notifyLightHeaders(pHLightListener2, new ArrayList(), true);
                                        }
                                    }
                                } catch (Exception e) {
                                    if (PHLog.isLoggable()) {
                                        PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                                    }
                                    PHNotificationManagerImpl pHNotificationManagerImpl7 = pHNotificationManagerImpl2;
                                    if (pHNotificationManagerImpl7 != null) {
                                        pHNotificationManagerImpl7.notifyBridgeAPIError(pHLightListener2, 42, e.getMessage());
                                    }
                                }
                            }
                        });
                        PHLocalBridgeDelegator.this.timer.start(0L);
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void findNewSensors(final PHSensorListener pHSensorListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSensorListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.22
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (PHLocalBridgeDelegator.this.searchSensors(notificationManager, pHSensorListener)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.startSearchNotification();
                        }
                        if (PHLocalBridgeDelegator.this.timer != null && PHLocalBridgeDelegator.this.timer.isRunning()) {
                            PHLocalBridgeDelegator.this.timer.stop();
                        }
                        PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                        final PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        final PHSensorListener pHSensorListener2 = pHSensorListener;
                        pHLocalBridgeDelegator.timer = new PHHueCountTimer(PHLocalBridgeDelegator.SEARCH_DURATION, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.22.1
                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onFinish() {
                                PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                                if (pHNotificationManagerImpl3 != null) {
                                    pHNotificationManagerImpl3.notifySensorSearchFinished(pHSensorListener2);
                                }
                            }

                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onTick() throws Throwable {
                                try {
                                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.NEW);
                                    String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                                    if (data2 != null) {
                                        List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(data2);
                                        if (error.size() != 0) {
                                            PHHueError pHHueError = error.get(0);
                                            PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                                            if (pHNotificationManagerImpl3 != null) {
                                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHSensorListener2, pHHueError.getCode(), pHHueError.getMessage());
                                            }
                                        } else {
                                            List<PHBridgeResource> getAllLightHeaders = PHBridgeVersionManager.getInstance().getLightSerializer().parseGetAllLightHeaders(data2);
                                            if (getAllLightHeaders == null || getAllLightHeaders.size() == 0) {
                                                pHNotificationManagerImpl2.notifySensorsReceived(pHSensorListener2, new ArrayList());
                                            } else {
                                                PHNotificationManagerImpl pHNotificationManagerImpl4 = pHNotificationManagerImpl2;
                                                if (pHNotificationManagerImpl4 != null) {
                                                    pHNotificationManagerImpl4.notifySensorsReceived(pHSensorListener2, getAllLightHeaders);
                                                }
                                            }
                                            if (!new JSONObject(data2).optString("lastscan").equals("active")) {
                                                onFinish();
                                                return;
                                            }
                                        }
                                    }
                                    if (pHNotificationManagerImpl2.isSearchRunning()) {
                                        PHLocalBridgeDelegator.this.timer.restart(PHLocalBridgeDelegator.SEARCH_ITERATION);
                                    } else {
                                        pHNotificationManagerImpl2.notifySensorSearchFinished(pHSensorListener2);
                                    }
                                } catch (Exception e) {
                                    if (PHLog.isLoggable()) {
                                        PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                                    }
                                    PHNotificationManagerImpl pHNotificationManagerImpl5 = pHNotificationManagerImpl2;
                                    if (pHNotificationManagerImpl5 != null) {
                                        pHNotificationManagerImpl5.notifyBridgeAPIError(pHSensorListener2, 42, e.getMessage());
                                    }
                                }
                            }
                        });
                        PHLocalBridgeDelegator.this.timer.start(0L);
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void findNewSensorsWithSerials(final List<String> list, final PHSensorListener pHSensorListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSensorListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.23
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (PHLocalBridgeDelegator.this.searchSensorsWithSerials(notificationManager, list, pHSensorListener)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.startSearchNotification();
                        }
                        if (PHLocalBridgeDelegator.this.timer != null && PHLocalBridgeDelegator.this.timer.isRunning()) {
                            PHLocalBridgeDelegator.this.timer.stop();
                        }
                        PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                        final PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        final PHSensorListener pHSensorListener2 = pHSensorListener;
                        pHLocalBridgeDelegator.timer = new PHHueCountTimer(PHLocalBridgeDelegator.SEARCH_DURATION, new PHHueCountTimerListener() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.23.1
                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onFinish() {
                                pHNotificationManagerImpl2.notifySensorSearchFinished(pHSensorListener2);
                            }

                            @Override // com.philips.lighting.hue.sdk.util.PHHueCountTimerListener
                            public void onTick() throws Throwable {
                                StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.NEW);
                                try {
                                    String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                                    if (data2 != null) {
                                        if (PHCLIPParserBase.getInstance().parseError(data2).size() != 0) {
                                            PHNotificationManagerImpl pHNotificationManagerImpl3 = pHNotificationManagerImpl2;
                                            if (pHNotificationManagerImpl3 != null) {
                                                pHNotificationManagerImpl3.notifySensorsReceived(pHSensorListener2, new ArrayList());
                                            }
                                        } else {
                                            List<PHBridgeResource> getAllLightHeaders = PHBridgeVersionManager.getInstance().getLightSerializer().parseGetAllLightHeaders(data2);
                                            if (getAllLightHeaders == null || getAllLightHeaders.size() == 0) {
                                                PHNotificationManagerImpl pHNotificationManagerImpl4 = pHNotificationManagerImpl2;
                                                if (pHNotificationManagerImpl4 != null) {
                                                    pHNotificationManagerImpl4.notifySensorsReceived(pHSensorListener2, new ArrayList());
                                                }
                                            } else {
                                                PHNotificationManagerImpl pHNotificationManagerImpl5 = pHNotificationManagerImpl2;
                                                if (pHNotificationManagerImpl5 != null) {
                                                    pHNotificationManagerImpl5.notifySensorsReceived(pHSensorListener2, getAllLightHeaders);
                                                }
                                            }
                                            if (!new JSONObject(data2).optString("lastscan").equals("active")) {
                                                onFinish();
                                                return;
                                            }
                                        }
                                    }
                                    PHNotificationManagerImpl pHNotificationManagerImpl6 = pHNotificationManagerImpl2;
                                    if (pHNotificationManagerImpl6 != null) {
                                        if (pHNotificationManagerImpl6.isSearchRunning()) {
                                            PHLocalBridgeDelegator.this.timer.restart(PHLocalBridgeDelegator.SEARCH_ITERATION);
                                        } else {
                                            pHNotificationManagerImpl2.notifySensorSearchFinished(pHSensorListener2);
                                        }
                                    }
                                } catch (Exception e) {
                                    if (PHLog.isLoggable()) {
                                        PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                                    }
                                    PHNotificationManagerImpl pHNotificationManagerImpl7 = pHNotificationManagerImpl2;
                                    if (pHNotificationManagerImpl7 != null) {
                                        pHNotificationManagerImpl7.notifyBridgeAPIError(pHSensorListener2, 42, e.getMessage());
                                    }
                                }
                            }
                        });
                        PHLocalBridgeDelegator.this.timer.start(0L);
                    }
                }
            }.start();
        }
    }

    public PHHueHttpConnection getConnectionObject() {
        return new PHHueHttpConnection();
    }

    public String getOwner(PHBridge pHBridge, PHSchedule pHSchedule) {
        if (pHSchedule.getOwner() == null || !pHSchedule.getOwner().equals("")) {
            return pHSchedule.getIdentifier() == null ? this.key : pHBridge.getResourceCache().getSchedules().containsKey(pHSchedule.getIdentifier()) ? pHBridge.getResourceCache().getSchedules().get(pHSchedule.getIdentifier()).getOwner() : this.key;
        }
        return pHSchedule.getOwner();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void getScene(final String str, final PHSceneListener pHSceneListener, PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        if (str == null) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 23, "Scene identifier not set.");
        } else if (PHBridgeVersionManager.getInstance().getScenesSerializer() == null) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.35
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCENE);
                    stringBufferBuildHttpAddress.append(str);
                    String string = stringBufferBuildHttpAddress.toString();
                    try {
                        PHHueHttpConnection connectionObject = PHLocalBridgeDelegator.this.getConnectionObject();
                        PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
                        String data2 = connectionObject.getData(string);
                        if (data2 == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHSceneListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                                return;
                            }
                            return;
                        }
                        List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(data2);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHSceneListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        PHScene sceneDetails = pHBridgeVersionManager.getScenesSerializer().parseSceneDetails(data2, str);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeGetScene(pHSceneListener, sceneDetails);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIError(pHSceneListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void getSupportedTimeZones(final PHTimeZoneListener pHTimeZoneListener) {
        final PHTimeZoneSerializer timeZoneSerializer = PHBridgeVersionManager.getInstance().getTimeZoneSerializer();
        if (timeZoneSerializer == null) {
            pHTimeZoneListener.onError(PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.32
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.INFO);
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.TIMEZONES);
                        String data2 = PHLocalBridgeDelegator.this.getConnectionObject().getData(stringBufferBuildHttpAddress.toString());
                        PHTimeZoneListener pHTimeZoneListener2 = pHTimeZoneListener;
                        if (data2 == null) {
                            if (pHTimeZoneListener2 != null) {
                                pHTimeZoneListener2.onError(PHHueConstants.TXT_NO_DATA);
                            }
                        } else if (pHTimeZoneListener2 != null) {
                            pHTimeZoneListener.onSuccess(timeZoneSerializer.parseTimeZones(data2));
                        }
                    } catch (Exception e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                        }
                        PHTimeZoneListener pHTimeZoneListener3 = pHTimeZoneListener;
                        if (pHTimeZoneListener3 != null) {
                            pHTimeZoneListener3.onError("Exception: " + e);
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public String getWhitelistIdentifier() {
        return this.key;
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void onIPAddressChanged(String str) {
        this.ipAddress = str;
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void removeSchedule(final String str, final PHScheduleListener pHScheduleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.12
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCHEDULES);
                    stringBufferBuildHttpAddress.append(str);
                    String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                    if (strDeleteData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHScheduleListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strDeleteData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHScheduleListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    if (!pHCLIPParserBase.parseIsSuccess(strDeleteData)) {
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHScheduleListener, 52, PHHueConstants.TXT_INVALID_JSON);
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalScheduleRemove(str, pHBridgeImpl);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SCHEDULES_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHScheduleListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHScheduleListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void removeUsername(final String str, final PHBridgeConfigurationListener pHBridgeConfigurationListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.9
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.CONFIG);
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.WHITELIST);
                    stringBufferBuildHttpAddress.append(str);
                    String strDeleteData = PHLocalBridgeDelegator.this.getConnectionObject().deleteData(stringBufferBuildHttpAddress.toString());
                    if (strDeleteData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, 46, null);
                            return;
                        }
                        return;
                    }
                    List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strDeleteData);
                    if (error.size() == 0) {
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPISuccess(pHBridgeConfigurationListener);
                            return;
                        }
                        return;
                    }
                    PHHueError pHHueError = error.get(0);
                    PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                    if (pHNotificationManagerImpl3 != null) {
                        pHNotificationManagerImpl3.notifyBridgeAPIError(pHBridgeConfigurationListener, pHHueError.getCode(), pHHueError.getMessage());
                    }
                } catch (Exception e) {
                    if (PHLog.isLoggable()) {
                        PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPIError(pHBridgeConfigurationListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void saveLightStateInScene(final PHLightState pHLightState, final String str, final String str2, final PHSceneListener pHSceneListener) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.17
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    String string;
                    String str3 = str2;
                    boolean z = true;
                    if (str3 != null && str3.length() >= 1 && str2.length() <= 16) {
                        z = false;
                    }
                    if (pHLightState == null || z || str == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHSceneListener, 23, PHHueResourcesConstants.TXT_INVALID_INPUT);
                            return;
                        }
                        return;
                    }
                    try {
                        PHHueHttpConnection connectionObject = PHLocalBridgeDelegator.this.getConnectionObject();
                        PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
                        boolean zIsVersion2Scene = pHBridgeVersionManager.getScenesSerializer().isVersion2Scene();
                        PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                        if (zIsVersion2Scene) {
                            StringBuffer stringBufferBuildHttpAddress = pHLocalBridgeDelegator.buildHttpAddress();
                            stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCENE);
                            stringBufferBuildHttpAddress.append(str2);
                            stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHTSTATES);
                            stringBufferBuildHttpAddress.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                            stringBufferBuildHttpAddress.append(str);
                            string = stringBufferBuildHttpAddress.toString();
                        } else {
                            StringBuffer stringBufferBuildHttpAddress2 = pHLocalBridgeDelegator.buildHttpAddress();
                            stringBufferBuildHttpAddress2.append(PHLocalBridgeDelegator.SCENE);
                            stringBufferBuildHttpAddress2.append(str2);
                            stringBufferBuildHttpAddress2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                            stringBufferBuildHttpAddress2.append(PHLocalBridgeDelegator.LIGHT);
                            stringBufferBuildHttpAddress2.append(str);
                            stringBufferBuildHttpAddress2.append("/state");
                            string = stringBufferBuildHttpAddress2.toString();
                        }
                        String strPutData = connectionObject.putData(pHBridgeVersionManager.getLightSerializer().updateLightStatePacket(pHLightState).toString(), string);
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHSceneListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHSceneListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIStateUpdate(pHSceneListener, success, error);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPIError(pHSceneListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void saveSceneWithCurrentLightStates(final PHScene pHScene, final PHSceneListener pHSceneListener, final PHBridgeImpl pHBridgeImpl, final boolean z) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        if (pHScene == null) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 23, "Scene is null");
            return;
        }
        if (pHScene.getSceneIdentifier() == null) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 23, "Scene identifier not set.");
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            notificationManager.notifyBridgeAPIError(pHSceneListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.16
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String string;
                    try {
                        PHHueHttpConnection connectionObject = PHLocalBridgeDelegator.this.getConnectionObject();
                        PHBridgeVersionManager pHBridgeVersionManager = PHBridgeVersionManager.getInstance();
                        boolean zIsVersion2Scene = pHBridgeVersionManager.getScenesSerializer().isVersion2Scene();
                        if (!zIsVersion2Scene || z) {
                            StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                            stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCENE);
                            stringBufferBuildHttpAddress.append(pHScene.getSceneIdentifier());
                            string = stringBufferBuildHttpAddress.toString();
                        } else {
                            StringBuffer stringBufferBuildHttpAddress2 = PHLocalBridgeDelegator.this.buildHttpAddress();
                            stringBufferBuildHttpAddress2.append(PHLocalBridgeDelegator.SCENE);
                            string = stringBufferBuildHttpAddress2.toString();
                        }
                        String string2 = pHBridgeVersionManager.getScenesSerializer().createScenePacket(pHScene, z).toString();
                        String strPutData = (!zIsVersion2Scene || z) ? connectionObject.putData(string2, string) : connectionObject.postData(string2, string);
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHSceneListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHSceneListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalSceneUpdate(pHScene, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.SCENE_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIStateUpdate(pHSceneListener, success, error);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPIError(pHSceneListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void saveSensorConfiguration(final PHSensor pHSensor, final PHSensorListener pHSensorListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.28
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                if (pHSensor == null) {
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 23, PHHueResourcesConstants.TXT_INVALID_INPUT);
                        return;
                    }
                    return;
                }
                StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                stringBufferBuildHttpAddress.append(pHSensor.getIdentifier());
                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.CONFIGURATION);
                try {
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(PHBridgeVersionManager.getInstance().getSensorSerializer().updateSensorConfigurationPacket(pHSensor).toString(), stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHSensorListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                    PHLocalBridgeDelegator.this.doLocalSensorConfigUpdate(pHSensor, pHBridgeImpl, success);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SENSOR_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIStateUpdate(pHSensorListener, success, error);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void saveSensorState(final PHSensor pHSensor, final PHSensorListener pHSensorListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.27
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                if (pHSensor == null) {
                    PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                    if (pHNotificationManagerImpl != null) {
                        pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 23, PHHueResourcesConstants.TXT_INVALID_INPUT);
                        return;
                    }
                    return;
                }
                StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                stringBufferBuildHttpAddress.append(pHSensor.getIdentifier());
                stringBufferBuildHttpAddress.append("/state");
                try {
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(PHBridgeVersionManager.getInstance().getSensorSerializer().updateSensorStatePacket(pHSensor).toString(), stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHSensorListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                    PHLocalBridgeDelegator.this.doLocalSensorStateUpdate(pHSensor, pHBridgeImpl, success);
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SENSOR_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIStateUpdate(pHSensorListener, success, error);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                    if (pHNotificationManagerImpl6 != null) {
                        pHNotificationManagerImpl6.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    public boolean searchLightsWithSerials(PHNotificationManagerImpl pHNotificationManagerImpl, List<String> list, PHLightListener pHLightListener) throws Throwable {
        if (pHNotificationManagerImpl == null) {
            return false;
        }
        StringBuffer stringBufferBuildHttpAddress = buildHttpAddress();
        stringBufferBuildHttpAddress.append(LIGHT);
        String string = stringBufferBuildHttpAddress.toString();
        try {
            String strPostData = getConnectionObject().postData(PHBridgeVersionManager.getInstance().getLightSerializer().createFindLightWithSerialsPacket(list).toString(), string);
            if (strPostData == null) {
                pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 46, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_RESPONSE);
                return false;
            }
            List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPostData);
            if (error.size() == 0) {
                return true;
            }
            PHHueError pHHueError = error.get(0);
            pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, pHHueError.getCode(), pHHueError.getMessage());
            return false;
        } catch (Exception e) {
            pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 42, e.getMessage());
            return false;
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void setLightStateForGroup(final String str, final PHLightState pHLightState, final PHGroupListener pHGroupListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        String strValidateState = pHLightState.validateState();
        if (strValidateState != null) {
            notificationManager.notifyBridgeAPIError(pHGroupListener, 51, strValidateState);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.6
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    PHNotificationManagerImpl pHNotificationManagerImpl;
                    try {
                        String string = PHBridgeVersionManager.getInstance().getLightSerializer().updateLightStatePacket(pHLightState).toString();
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.GROUP);
                        stringBufferBuildHttpAddress.append(str);
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.ACTION);
                        String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHGroupListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                        Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHGroupListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        if (PHLocalBridgeDelegator.this.doLocalUpdateGroupLights(pHBridgeImpl, success, pHLightState, str) && (pHNotificationManagerImpl = notificationManager) != null) {
                            pHNotificationManagerImpl.notifyCacheUpdated(PHMessageType.LIGHTS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIStateUpdate(pHGroupListener, success, error);
                            notificationManager.notifyBridgeAPISuccess(pHGroupListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPIError(pHGroupListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateBridgeConfigurations(final PHBridgeConfiguration pHBridgeConfiguration, final PHBridgeConfigurationListener pHBridgeConfigurationListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.8
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getBridgeConfigurationSerializer().updateBridgeConfigurationPacket(pHBridgeConfiguration).toString();
                    if (string == null) {
                        throw new PHInvalidInputException();
                    }
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.CONFIG);
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHBridgeConfigurationListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                    PHLocalBridgeDelegator.this.doLocalBridgeUpdate(pHBridgeConfiguration, success, pHBridgeImpl);
                    PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                    if (pHNotificationManagerImpl2 != null) {
                        pHNotificationManagerImpl2.notifyCacheUpdated(PHMessageType.BRIDGE_CONFIGURATION_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyBridgeAPIError(pHBridgeConfigurationListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPIStateUpdate(pHBridgeConfigurationListener, success, error);
                        notificationManager.notifyBridgeAPISuccess(pHBridgeConfigurationListener);
                    }
                } catch (Exception e) {
                    if (PHLog.isLoggable()) {
                        PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIError(pHBridgeConfigurationListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateGroup(final PHGroup pHGroup, final PHGroupListener pHGroupListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getGroupSerializer().updateGroupPacket(pHGroup).toString();
                    if (string == null) {
                        throw new PHInvalidInputException();
                    }
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.GROUP);
                    stringBufferBuildHttpAddress.append(pHGroup.getIdentifier());
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHGroupListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHGroupListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalGroupUpdate(pHGroup, pHBridgeImpl, pHCLIPParserBase.parseSuccess(strPutData));
                    PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                    if (pHNotificationManagerImpl3 != null) {
                        pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.GROUPS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPISuccess(pHGroupListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIError(pHGroupListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateLight(final PHLight pHLight, final PHLightListener pHLightListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canUpdate()) {
            notificationManager.notifyBridgeAPIError(pHLightListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else if (lightSerializer.validateAPI(pHLight)) {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        String string = PHBridgeVersionManager.getInstance().getLightSerializer().updateLightPacket(pHLight).toString();
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHT);
                        stringBufferBuildHttpAddress.append(pHLight.getIdentifier());
                        String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 46, PHHueConstants.TXT_COULD_NOT_UPDATE_LIGHT);
                                return;
                            }
                            return;
                        }
                        List<PHHueError> error = PHCLIPParserBase.getInstance().parseError(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHLightListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalLightUpdate(pHLight.getIdentifier(), pHLight.getName(), pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.LIGHTS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPISuccess(pHLightListener);
                        }
                    } catch (Exception e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(PHLocalBridgeDelegator.TAG, "Exception: " + e);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPIError(pHLightListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        } else {
            notificationManager.notifyBridgeAPIError(pHLightListener, 42, PHHueConstants.TXT_COULD_NOT_UPDATE_LIGHT);
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateLightState(final String str, final PHLightState pHLightState, final PHLightListener pHLightListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canLightStateUpdate()) {
            notificationManager.notifyBridgeAPIError(pHLightListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
            return;
        }
        String strValidateState = pHLightState.validateState();
        if (strValidateState != null) {
            notificationManager.notifyBridgeAPIError(pHLightListener, 51, strValidateState);
        } else {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.21
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        String string = PHBridgeVersionManager.getInstance().getLightSerializer().updateLightStatePacket(pHLightState).toString();
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.LIGHT);
                        stringBufferBuildHttpAddress.append(str);
                        stringBufferBuildHttpAddress.append("/state");
                        String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHLightListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = new PHCLIPParserBase();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                        Map<String, String> success = pHCLIPParserBase.parseSuccess(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHLightListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalLightStateUpdate(str, success, pHLightState, pHBridgeImpl);
                        PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                        if (pHNotificationManagerImpl3 != null) {
                            pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.LIGHTS_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyBridgeAPIStateUpdate(pHLightListener, success, error);
                            notificationManager.notifyBridgeAPISuccess(pHLightListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPIError(pHLightListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateRule(final PHRule pHRule, final PHRuleListener pHRuleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.30
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getRulesSerializer().updateRule(pHRule).toString();
                    if (string == null) {
                        throw new PHInvalidInputException();
                    }
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.RULE);
                    stringBufferBuildHttpAddress.append(pHRule.getIdentifier());
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHRuleListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHRuleListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalRuleUpdate(pHRule, pHBridgeImpl, pHCLIPParserBase.parseSuccess(strPutData));
                    PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                    if (pHNotificationManagerImpl3 != null) {
                        pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.RULE_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPISuccess(pHRuleListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIError(pHRuleListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateSchedule(final PHSchedule pHSchedule, final PHScheduleListener pHScheduleListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canUpdate()) {
            notificationManager.notifyBridgeAPIError(pHScheduleListener, 50, PHHueConstants.TXT_UNSUPPORTED_BRIDGE_VERSION);
        } else if (schedulesSerializer.validateAPI(pHSchedule)) {
            new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.11
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    String string;
                    try {
                        String owner = PHLocalBridgeDelegator.this.getOwner(pHBridgeImpl, pHSchedule);
                        if (pHSchedule.getLightIdentifier() != null) {
                            StringBuffer stringBufferBuildScheduleCommand = PHLocalBridgeDelegator.this.buildScheduleCommand(owner);
                            stringBufferBuildScheduleCommand.append(PHLocalBridgeDelegator.LIGHT);
                            stringBufferBuildScheduleCommand.append(pHSchedule.getLightIdentifier());
                            stringBufferBuildScheduleCommand.append("/state");
                            string = stringBufferBuildScheduleCommand.toString();
                        } else if (pHSchedule.getGroupIdentifier() != null) {
                            StringBuffer stringBufferBuildScheduleCommand2 = PHLocalBridgeDelegator.this.buildScheduleCommand(owner);
                            stringBufferBuildScheduleCommand2.append(PHLocalBridgeDelegator.GROUP);
                            stringBufferBuildScheduleCommand2.append(pHSchedule.getGroupIdentifier());
                            stringBufferBuildScheduleCommand2.append(PHLocalBridgeDelegator.ACTION);
                            string = stringBufferBuildScheduleCommand2.toString();
                        } else if (pHSchedule.getSceneIdentifier() != null) {
                            String groupIdentifier = pHSchedule.getGroupIdentifier();
                            PHLocalBridgeDelegator pHLocalBridgeDelegator = PHLocalBridgeDelegator.this;
                            if (groupIdentifier != null) {
                                StringBuffer stringBufferBuildScheduleCommand3 = pHLocalBridgeDelegator.buildScheduleCommand(owner);
                                stringBufferBuildScheduleCommand3.append(PHLocalBridgeDelegator.GROUP);
                                stringBufferBuildScheduleCommand3.append(pHSchedule.getGroupIdentifier());
                                stringBufferBuildScheduleCommand3.append(PHLocalBridgeDelegator.ACTION);
                                string = stringBufferBuildScheduleCommand3.toString();
                            } else {
                                StringBuffer stringBufferBuildScheduleCommand4 = pHLocalBridgeDelegator.buildScheduleCommand(owner);
                                stringBufferBuildScheduleCommand4.append(PHLocalBridgeDelegator.GROUP);
                                stringBufferBuildScheduleCommand4.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                stringBufferBuildScheduleCommand4.append(PHLocalBridgeDelegator.ACTION);
                                string = stringBufferBuildScheduleCommand4.toString();
                            }
                        } else {
                            string = null;
                        }
                        String string2 = PHBridgeVersionManager.getInstance().getSchedulesSerializer().updateSchedulePacket(pHSchedule, string, "PUT", pHBridgeImpl.getResourceCache().getBridgeConfiguration().getTimeZone()).toString();
                        if (string2 == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                            if (pHNotificationManagerImpl != null) {
                                pHNotificationManagerImpl.notifyBridgeAPIError(pHScheduleListener, 44, PHHueResourcesConstants.TXT_INVALID_INPUT);
                                return;
                            }
                            return;
                        }
                        StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                        stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SCHEDULES);
                        stringBufferBuildHttpAddress.append(pHSchedule.getIdentifier());
                        String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string2, stringBufferBuildHttpAddress.toString());
                        if (strPutData == null) {
                            PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                            if (pHNotificationManagerImpl2 != null) {
                                pHNotificationManagerImpl2.notifyBridgeAPIError(pHScheduleListener, 46, null);
                                return;
                            }
                            return;
                        }
                        PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                        List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                        if (error.size() != 0) {
                            PHHueError pHHueError = error.get(0);
                            PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                            if (pHNotificationManagerImpl3 != null) {
                                pHNotificationManagerImpl3.notifyBridgeAPIError(pHScheduleListener, pHHueError.getCode(), pHHueError.getMessage());
                                return;
                            }
                            return;
                        }
                        PHLocalBridgeDelegator.this.doLocalScheduleUpdate(pHSchedule, pHBridgeImpl, pHCLIPParserBase.parseSuccess(strPutData));
                        PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                        if (pHNotificationManagerImpl4 != null) {
                            pHNotificationManagerImpl4.notifyCacheUpdated(PHMessageType.SCHEDULES_CACHE_UPDATED.intValue(), pHBridgeImpl);
                        }
                        PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                        if (pHNotificationManagerImpl5 != null) {
                            pHNotificationManagerImpl5.notifyBridgeAPISuccess(pHScheduleListener);
                        }
                    } catch (Exception e) {
                        PHNotificationManagerImpl pHNotificationManagerImpl6 = notificationManager;
                        if (pHNotificationManagerImpl6 != null) {
                            pHNotificationManagerImpl6.notifyBridgeAPIError(pHScheduleListener, 42, e.getMessage());
                        }
                    }
                }
            }.start();
        } else {
            notificationManager.notifyBridgeAPIError(pHScheduleListener, 54, PHHueConstants.TXT_UNSUPPORTED_IN_EXISTING_VERSION);
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateSensor(final PHSensor pHSensor, final PHSensorListener pHSensorListener, final PHBridgeImpl pHBridgeImpl) {
        final PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        new Thread() { // from class: com.philips.lighting.hue.sdk.connection.impl.PHLocalBridgeDelegator.25
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String string = PHBridgeVersionManager.getInstance().getSensorSerializer().updateSensorPacket(pHSensor).toString();
                    if (string == null) {
                        throw new PHInvalidInputException();
                    }
                    StringBuffer stringBufferBuildHttpAddress = PHLocalBridgeDelegator.this.buildHttpAddress();
                    stringBufferBuildHttpAddress.append(PHLocalBridgeDelegator.SENSOR);
                    stringBufferBuildHttpAddress.append(pHSensor.getIdentifier());
                    String strPutData = PHLocalBridgeDelegator.this.getConnectionObject().putData(string, stringBufferBuildHttpAddress.toString());
                    if (strPutData == null) {
                        PHNotificationManagerImpl pHNotificationManagerImpl = notificationManager;
                        if (pHNotificationManagerImpl != null) {
                            pHNotificationManagerImpl.notifyBridgeAPIError(pHSensorListener, 46, null);
                            return;
                        }
                        return;
                    }
                    PHCLIPParserBase pHCLIPParserBase = PHCLIPParserBase.getInstance();
                    List<PHHueError> error = pHCLIPParserBase.parseError(strPutData);
                    if (error.size() != 0) {
                        PHHueError pHHueError = error.get(0);
                        PHNotificationManagerImpl pHNotificationManagerImpl2 = notificationManager;
                        if (pHNotificationManagerImpl2 != null) {
                            pHNotificationManagerImpl2.notifyBridgeAPIError(pHSensorListener, pHHueError.getCode(), pHHueError.getMessage());
                            return;
                        }
                        return;
                    }
                    PHLocalBridgeDelegator.this.doLocalSensorUpdate(pHSensor, pHBridgeImpl, pHCLIPParserBase.parseSuccess(strPutData));
                    PHNotificationManagerImpl pHNotificationManagerImpl3 = notificationManager;
                    if (pHNotificationManagerImpl3 != null) {
                        pHNotificationManagerImpl3.notifyCacheUpdated(PHMessageType.SENSOR_CACHE_UPDATED.intValue(), pHBridgeImpl);
                    }
                    PHNotificationManagerImpl pHNotificationManagerImpl4 = notificationManager;
                    if (pHNotificationManagerImpl4 != null) {
                        pHNotificationManagerImpl4.notifyBridgeAPISuccess(pHSensorListener);
                    }
                } catch (Exception e) {
                    PHNotificationManagerImpl pHNotificationManagerImpl5 = notificationManager;
                    if (pHNotificationManagerImpl5 != null) {
                        pHNotificationManagerImpl5.notifyBridgeAPIError(pHSensorListener, 42, e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    public void updateSoftware(PHBridgeConfigurationListener pHBridgeConfigurationListener, PHBridgeImpl pHBridgeImpl) {
        PHNotificationManagerImpl notificationManager = PHNotificationManagerImpl.getNotificationManager();
        if (notificationManager == null) {
            return;
        }
        try {
            PHBridgeConfiguration bridgeConfiguration = pHBridgeImpl.getResourceCache().getBridgeConfiguration();
            if (!bridgeConfiguration.getPortalServicesEnabled().booleanValue()) {
                notificationManager.notifyBridgeAPIError(pHBridgeConfigurationListener, 48, PHHueConstants.TXT_PORTAL_SERVICE_NOT_ACTIVATED);
                return;
            }
            PHSoftwareUpdateStatus softwareStatus = bridgeConfiguration.getSoftwareStatus();
            if (softwareStatus != null) {
                if (softwareStatus.isSoftwareUpdateAvailable()) {
                    startSoftwareUpdate(pHBridgeConfigurationListener, pHBridgeImpl);
                } else if (bridgeConfiguration.getSoftwareStatus().getState() == PHSoftwareUpdateStatus.PHStateType.NO_UPDATE) {
                    notificationManager.notifyBridgeAPIError(pHBridgeConfigurationListener, 49, PHHueConstants.TXT_NO_SOFTWARE_UPGRADE);
                } else {
                    notificationManager.notifyBridgeAPIError(pHBridgeConfigurationListener, 57, PHHueConstants.TXT_SOFTWARE_DOWNLOADING);
                }
            }
        } catch (Exception e) {
            notificationManager.notifyBridgeAPIError(pHBridgeConfigurationListener, 42, e.getMessage());
        }
    }

    @Override // com.philips.lighting.hue.sdk.bridge.impl.PHBridgeDelegator
    @Deprecated
    public void createGroup(String str, List<String> list, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl) {
        PHGroup pHGroup = new PHGroup(str, "");
        pHGroup.setLightIdentifiers(list);
        createGroup(pHGroup, pHGroupListener, pHBridgeImpl);
    }
}
