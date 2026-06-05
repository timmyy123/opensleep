package com.philips.lighting.model;

import com.philips.lighting.hue.listener.PHBridgeConfigurationListener;
import com.philips.lighting.hue.listener.PHGroupListener;
import com.philips.lighting.hue.listener.PHHTTPListener;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.listener.PHRuleListener;
import com.philips.lighting.hue.listener.PHSceneListener;
import com.philips.lighting.hue.listener.PHScheduleListener;
import com.philips.lighting.hue.listener.PHSensorListener;
import com.philips.lighting.hue.listener.PHTimeZoneListener;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridge {
    void activateScene(String str, String str2, PHSceneListener pHSceneListener);

    void createGroup(PHGroup pHGroup, PHGroupListener pHGroupListener);

    @Deprecated
    void createGroup(String str, List<String> list, PHGroupListener pHGroupListener);

    void createRule(PHRule pHRule, PHRuleListener pHRuleListener);

    void createSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener);

    void createSensor(PHSensor pHSensor, PHSensorListener pHSensorListener);

    void deleteGroup(String str, PHGroupListener pHGroupListener);

    void deleteLight(String str, PHLightListener pHLightListener);

    void deleteRule(String str, PHRuleListener pHRuleListener);

    void deleteScene(String str, PHSceneListener pHSceneListener);

    void deleteSensor(String str, PHSensorListener pHSensorListener);

    void doHTTPDelete(String str, PHHTTPListener pHHTTPListener);

    void doHTTPGet(String str, PHHTTPListener pHHTTPListener);

    void doHTTPPost(String str, String str2, PHHTTPListener pHHTTPListener);

    void doHTTPPut(String str, String str2, PHHTTPListener pHHTTPListener);

    void findNewLights(PHLightListener pHLightListener);

    void findNewLightsWithSerials(List<String> list, PHLightListener pHLightListener);

    void findNewSensors(PHSensorListener pHSensorListener);

    void findNewSensorsWithSerials(List<String> list, PHSensorListener pHSensorListener);

    PHBridgeResourcesCache getResourceCache();

    void getScene(String str, PHSceneListener pHSceneListener);

    void getSupportedTimeZones(PHTimeZoneListener pHTimeZoneListener);

    void removeSchedule(String str, PHScheduleListener pHScheduleListener);

    void removeUsername(String str, PHBridgeConfigurationListener pHBridgeConfigurationListener);

    void saveLightState(PHLightState pHLightState, String str, String str2, PHSceneListener pHSceneListener);

    void saveScene(PHScene pHScene, PHSceneListener pHSceneListener);

    void saveSceneWithCurrentLightStates(PHScene pHScene, PHSceneListener pHSceneListener);

    void saveSensorConfiguration(PHSensor pHSensor, PHSensorListener pHSensorListener);

    void saveSensorState(PHSensor pHSensor, PHSensorListener pHSensorListener);

    void setLightStateForDefaultGroup(PHLightState pHLightState);

    void setLightStateForGroup(String str, PHLightState pHLightState);

    void setLightStateForGroup(String str, PHLightState pHLightState, PHGroupListener pHGroupListener);

    void updateBridgeConfigurations(PHBridgeConfiguration pHBridgeConfiguration, PHBridgeConfigurationListener pHBridgeConfigurationListener);

    void updateGroup(PHGroup pHGroup, PHGroupListener pHGroupListener);

    void updateLight(PHLight pHLight, PHLightListener pHLightListener);

    void updateLightState(PHLight pHLight, PHLightState pHLightState);

    void updateLightState(PHLight pHLight, PHLightState pHLightState, PHLightListener pHLightListener);

    void updateLightState(String str, PHLightState pHLightState, PHLightListener pHLightListener);

    void updateRule(PHRule pHRule, PHRuleListener pHRuleListener);

    void updateSchedule(PHSchedule pHSchedule, PHScheduleListener pHScheduleListener);

    void updateSensor(PHSensor pHSensor, PHSensorListener pHSensorListener);

    void updateSoftware(PHBridgeConfigurationListener pHBridgeConfigurationListener);
}
