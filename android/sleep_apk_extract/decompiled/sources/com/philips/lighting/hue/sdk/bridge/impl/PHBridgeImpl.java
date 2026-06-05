package com.philips.lighting.hue.sdk.bridge.impl;

import com.facebook.appevents.AppEventsConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.listener.PHGroupListener;
import com.philips.lighting.hue.listener.PHHTTPListener;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.listener.PHRuleListener;
import com.philips.lighting.hue.listener.PHSceneListener;
import com.philips.lighting.hue.listener.PHScheduleListener;
import com.philips.lighting.hue.listener.PHSensorListener;
import com.philips.lighting.hue.listener.PHTimeZoneListener;
import com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer;
import com.philips.lighting.hue.sdk.clip.PHGroupSerializer;
import com.philips.lighting.hue.sdk.clip.PHLightSerializer;
import com.philips.lighting.hue.sdk.clip.PHRuleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.clip.PHScheduleSerializer;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeImpl implements PHBridge {
    private PHBridgeResourcesCacheImpl cacheImpl;
    private PHBridgeDelegator delegator;
    private boolean isPortal;

    public PHBridgeImpl(PHBridgeDelegator pHBridgeDelegator) {
        this.delegator = pHBridgeDelegator;
        this.cacheImpl = new PHBridgeResourcesCacheImpl();
    }

    @Override // com.philips.lighting.model.PHBridge
    public void activateScene(String str, String str2, PHSceneListener pHSceneListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null || str2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.activateScene(str, str2, pHSceneListener);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void createGroup(PHGroup pHGroup, PHGroupListener pHGroupListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHGroup.getLightIdentifiers() == null || pHGroup.getName() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
        if (groupSerializer == null || !groupSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.createGroup(pHGroup, pHGroupListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void createRule(PHRule pHRule, PHRuleListener pHRuleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHRule == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHRuleSerializer rulesSerializer = PHBridgeVersionManager.getInstance().getRulesSerializer();
        if (rulesSerializer == null || !rulesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.createRule(pHRule, pHRuleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void createSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSchedule == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.createSchedule(pHSchedule, pHScheduleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void createSensor(PHSensor pHSensor, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSensor == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.createSensor(pHSensor, pHSensorListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void deleteGroup(String str, PHGroupListener pHGroupListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
        if (groupSerializer == null || !groupSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.deleteGroup(str, pHGroupListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void deleteLight(String str, PHLightListener pHLightListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.deleteLight(str, pHLightListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void deleteRule(String str, PHRuleListener pHRuleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHRuleSerializer rulesSerializer = PHBridgeVersionManager.getInstance().getRulesSerializer();
        if (rulesSerializer == null || !rulesSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.deleteRule(str, pHRuleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void deleteScene(String str, PHSceneListener pHSceneListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.deleteScene(str, pHSceneListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void deleteSensor(String str, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.deleteSensor(str, pHSensorListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void doHTTPDelete(String str, PHHTTPListener pHHTTPListener) {
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.doDelete(str, pHHTTPListener);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void doHTTPGet(String str, PHHTTPListener pHHTTPListener) {
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.doGet(str, pHHTTPListener);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void doHTTPPost(String str, String str2, PHHTTPListener pHHTTPListener) {
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.doPost(str, str2, pHHTTPListener);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void doHTTPPut(String str, String str2, PHHTTPListener pHHTTPListener) {
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.doPut(str, str2, pHHTTPListener);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void findNewLights(PHLightListener pHLightListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        } else if (PHBridgeVersionManager.getInstance().getLightSerializer() != null) {
            this.delegator.findNewLights(pHLightListener);
        } else {
            Home$$ExternalSyntheticBUOutline0.m$3();
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void findNewLightsWithSerials(List<String> list, PHLightListener pHLightListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (list == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.findNewLightsWithSerials(list, pHLightListener);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void findNewSensors(PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.findNewSensors(pHSensorListener);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void findNewSensorsWithSerials(List<String> list, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (list == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.findNewSensorsWithSerials(list, pHSensorListener);
        }
    }

    public PHBridgeDelegator getBridgeDelegator() {
        return this.delegator;
    }

    @Override // com.philips.lighting.model.PHBridge
    public PHBridgeResourcesCache getResourceCache() {
        return this.cacheImpl;
    }

    @Override // com.philips.lighting.model.PHBridge
    public void getScene(String str, PHSceneListener pHSceneListener) {
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.getScene(str, pHSceneListener, this);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void getSupportedTimeZones(PHTimeZoneListener pHTimeZoneListener) {
        if (pHTimeZoneListener == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.getSupportedTimeZones(pHTimeZoneListener);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void removeSchedule(String str, PHScheduleListener pHScheduleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canDelete()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.removeSchedule(str, pHScheduleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void removeUsername(String str, PHBridgeConfigurationListener pHBridgeConfigurationListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHBridgeConfigurationSerializer bridgeConfigurationSerializer = PHBridgeVersionManager.getInstance().getBridgeConfigurationSerializer();
        if (bridgeConfigurationSerializer == null || !bridgeConfigurationSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.removeUsername(str, pHBridgeConfigurationListener);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void saveLightState(PHLightState pHLightState, String str, String str2, PHSceneListener pHSceneListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHLightState == null || str == null || str2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.saveLightStateInScene(pHLightState, str, str2, pHSceneListener);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void saveScene(PHScene pHScene, PHSceneListener pHSceneListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHScene == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.saveSceneWithCurrentLightStates(pHScene, pHSceneListener, this, true);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void saveSceneWithCurrentLightStates(PHScene pHScene, PHSceneListener pHSceneListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHScene == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSceneSerializer scenesSerializer = PHBridgeVersionManager.getInstance().getScenesSerializer();
        if (scenesSerializer == null || !scenesSerializer.canCreate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.saveSceneWithCurrentLightStates(pHScene, pHSceneListener, this, false);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void saveSensorConfiguration(PHSensor pHSensor, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSensor == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canSensorConfigurationUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.saveSensorConfiguration(pHSensor, pHSensorListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void saveSensorState(PHSensor pHSensor, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSensor == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canSensorStateUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.saveSensorState(pHSensor, pHSensorListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void setLightStateForDefaultGroup(PHLightState pHLightState) {
        PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
        if (groupSerializer == null || !groupSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            setLightStateForGroup(AppEventsConstants.EVENT_PARAM_VALUE_NO, pHLightState);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void setLightStateForGroup(String str, PHLightState pHLightState) {
        PHGroupListener pHGroupListener = new PHGroupListener() { // from class: com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl.2
            @Override // com.philips.lighting.hue.listener.PHGroupListener
            public void onCreated(PHGroup pHGroup) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onError(int i, String str2) {
            }

            @Override // com.philips.lighting.hue.listener.PHGroupListener
            public void onReceivingAllGroups(List<PHBridgeResource> list) {
            }

            @Override // com.philips.lighting.hue.listener.PHGroupListener
            public void onReceivingGroupDetails(PHGroup pHGroup) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onSuccess() {
            }
        };
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        if (pHLightState == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
        if (groupSerializer == null || !groupSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.setLightStateForGroup(str, pHLightState, pHGroupListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateBridgeConfigurations(PHBridgeConfiguration pHBridgeConfiguration, PHBridgeConfigurationListener pHBridgeConfigurationListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (pHBridgeConfiguration == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        PHBridgeConfigurationSerializer bridgeConfigurationSerializer = PHBridgeVersionManager.getInstance().getBridgeConfigurationSerializer();
        if (bridgeConfigurationSerializer == null || !bridgeConfigurationSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateBridgeConfigurations(pHBridgeConfiguration, pHBridgeConfigurationListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateGroup(PHGroup pHGroup, PHGroupListener pHGroupListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHGroup == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
        if (groupSerializer == null || !groupSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateGroup(pHGroup, pHGroupListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateLight(PHLight pHLight, PHLightListener pHLightListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHLight == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateLight(pHLight, pHLightListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateLightState(String str, PHLightState pHLightState, PHLightListener pHLightListener) {
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null || pHLightState == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer == null || !lightSerializer.canLightStateUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateLightState(str, pHLightState, pHLightListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateRule(PHRule pHRule, PHRuleListener pHRuleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHRule == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHRuleSerializer rulesSerializer = PHBridgeVersionManager.getInstance().getRulesSerializer();
        if (rulesSerializer == null || !rulesSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateRule(pHRule, pHRuleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSchedule == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHScheduleSerializer schedulesSerializer = PHBridgeVersionManager.getInstance().getSchedulesSerializer();
        if (schedulesSerializer == null || !schedulesSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateSchedule(pHSchedule, pHScheduleListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateSensor(PHSensor pHSensor, PHSensorListener pHSensorListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (pHSensor == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        PHSensorSerializer sensorSerializer = PHBridgeVersionManager.getInstance().getSensorSerializer();
        if (sensorSerializer == null || !sensorSerializer.canUpdate()) {
            Home$$ExternalSyntheticBUOutline0.m$3();
        } else {
            this.delegator.updateSensor(pHSensor, pHSensorListener, this);
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateSoftware(PHBridgeConfigurationListener pHBridgeConfigurationListener) {
        if (this.isPortal) {
            Home$$ExternalSyntheticBUOutline0.m$3();
            return;
        }
        PHBridgeDelegator pHBridgeDelegator = this.delegator;
        if (pHBridgeDelegator != null) {
            pHBridgeDelegator.updateSoftware(pHBridgeConfigurationListener, this);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
        }
    }

    public PHBridgeImpl(PHBridgeDelegator pHBridgeDelegator, boolean z) {
        this(pHBridgeDelegator);
        this.isPortal = z;
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateLightState(PHLight pHLight, PHLightState pHLightState, PHLightListener pHLightListener) {
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer != null && lightSerializer.canLightStateUpdate()) {
            this.delegator.updateLightState(pHLight.getIdentifier(), pHLightState, pHLightListener, this);
        } else {
            Home$$ExternalSyntheticBUOutline0.m$3();
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void updateLightState(PHLight pHLight, PHLightState pHLightState) {
        PHLightListener pHLightListener = new PHLightListener() { // from class: com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl.1
            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onError(int i, String str) {
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onReceivingLightDetails(PHLight pHLight2) {
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onReceivingLights(List<PHBridgeResource> list) {
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onSearchComplete() {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onSuccess() {
            }
        };
        PHLightSerializer lightSerializer = PHBridgeVersionManager.getInstance().getLightSerializer();
        if (lightSerializer != null && lightSerializer.canLightStateUpdate()) {
            this.delegator.updateLightState(pHLight.getIdentifier(), pHLightState, pHLightListener, this);
        } else {
            Home$$ExternalSyntheticBUOutline0.m$3();
        }
    }

    @Override // com.philips.lighting.model.PHBridge
    public void setLightStateForGroup(String str, PHLightState pHLightState, PHGroupListener pHGroupListener) {
        if (this.delegator == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_DELEGATOR);
            return;
        }
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return;
        }
        if (pHLightState != null) {
            PHGroupSerializer groupSerializer = PHBridgeVersionManager.getInstance().getGroupSerializer();
            if (groupSerializer != null && groupSerializer.canUpdate()) {
                this.delegator.setLightStateForGroup(str, pHLightState, pHGroupListener, this);
                return;
            } else {
                Home$$ExternalSyntheticBUOutline0.m$3();
                return;
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
    }

    @Override // com.philips.lighting.model.PHBridge
    public void createGroup(String str, List<String> list, PHGroupListener pHGroupListener) {
        PHGroup pHGroup = new PHGroup(str, "");
        pHGroup.setLightIdentifiers(list);
        createGroup(pHGroup, pHGroupListener);
    }
}
