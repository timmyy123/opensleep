package com.philips.lighting.hue.sdk.bridge.impl;

import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.listener.PHGroupListener;
import com.philips.lighting.hue.listener.PHHTTPListener;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.listener.PHRuleListener;
import com.philips.lighting.hue.listener.PHSceneListener;
import com.philips.lighting.hue.listener.PHScheduleListener;
import com.philips.lighting.hue.listener.PHSensorListener;
import com.philips.lighting.hue.listener.PHTimeZoneListener;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeDelegator {
    void activateScene(String str, String str2, PHSceneListener pHSceneListener);

    void createGroup(PHGroup pHGroup, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl);

    void createGroup(String str, List<String> list, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl);

    void createRule(PHRule pHRule, PHRuleListener pHRuleListener, PHBridgeImpl pHBridgeImpl);

    void createSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener, PHBridgeImpl pHBridgeImpl);

    void createSensor(PHSensor pHSensor, PHSensorListener pHSensorListener, PHBridgeImpl pHBridgeImpl);

    void deleteGroup(String str, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl);

    void deleteLight(String str, PHLightListener pHLightListener, PHBridgeImpl pHBridgeImpl);

    void deleteRule(String str, PHRuleListener pHRuleListener, PHBridgeImpl pHBridgeImpl);

    void deleteScene(String str, PHSceneListener pHSceneListener, PHBridgeImpl pHBridgeImpl);

    void deleteSensor(String str, PHSensorListener pHSensorListener, PHBridgeImpl pHBridgeImpl);

    void doDelete(String str, PHHTTPListener pHHTTPListener);

    void doGet(String str, PHHTTPListener pHHTTPListener);

    void doPost(String str, String str2, PHHTTPListener pHHTTPListener);

    void doPut(String str, String str2, PHHTTPListener pHHTTPListener);

    void findNewLights(PHLightListener pHLightListener);

    void findNewLightsWithSerials(List<String> list, PHLightListener pHLightListener);

    void findNewSensors(PHSensorListener pHSensorListener);

    void findNewSensorsWithSerials(List<String> list, PHSensorListener pHSensorListener);

    void getScene(String str, PHSceneListener pHSceneListener, PHBridgeImpl pHBridgeImpl);

    void getSupportedTimeZones(PHTimeZoneListener pHTimeZoneListener);

    String getWhitelistIdentifier();

    void onIPAddressChanged(String str);

    void removeSchedule(String str, PHScheduleListener pHScheduleListener, PHBridgeImpl pHBridgeImpl);

    void removeUsername(String str, PHBridgeConfigurationListener pHBridgeConfigurationListener);

    void saveLightStateInScene(PHLightState pHLightState, String str, String str2, PHSceneListener pHSceneListener);

    void saveSceneWithCurrentLightStates(PHScene pHScene, PHSceneListener pHSceneListener, PHBridgeImpl pHBridgeImpl, boolean z);

    void saveSensorConfiguration(PHSensor pHSensor, PHSensorListener pHSensorListener, PHBridgeImpl pHBridgeImpl);

    void saveSensorState(PHSensor pHSensor, PHSensorListener pHSensorListener, PHBridgeImpl pHBridgeImpl);

    void setLightStateForGroup(String str, PHLightState pHLightState, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl);

    void updateBridgeConfigurations(PHBridgeConfiguration pHBridgeConfiguration, PHBridgeConfigurationListener pHBridgeConfigurationListener, PHBridgeImpl pHBridgeImpl);

    void updateGroup(PHGroup pHGroup, PHGroupListener pHGroupListener, PHBridgeImpl pHBridgeImpl);

    void updateLight(PHLight pHLight, PHLightListener pHLightListener, PHBridgeImpl pHBridgeImpl);

    void updateLightState(String str, PHLightState pHLightState, PHLightListener pHLightListener, PHBridgeImpl pHBridgeImpl);

    void updateRule(PHRule pHRule, PHRuleListener pHRuleListener, PHBridgeImpl pHBridgeImpl);

    void updateSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener, PHBridgeImpl pHBridgeImpl);

    void updateSensor(PHSensor pHSensor, PHSensorListener pHSensorListener, PHBridgeImpl pHBridgeImpl);

    void updateSoftware(PHBridgeConfigurationListener pHBridgeConfigurationListener, PHBridgeImpl pHBridgeImpl);
}
