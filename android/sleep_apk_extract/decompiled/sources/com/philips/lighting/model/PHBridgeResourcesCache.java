package com.philips.lighting.model;

import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeResourcesCache {
    List<PHGroup> getAllGroups();

    List<PHLight> getAllLights();

    List<PHRule> getAllRules();

    List<PHScene> getAllScenes();

    List<PHSchedule> getAllSchedules(boolean z);

    List<PHSensor> getAllSensors();

    List<PHSchedule> getAllTimers(boolean z);

    PHBridgeConfiguration getBridgeConfiguration();

    Map<String, PHGroup> getGroups();

    Map<String, PHLight> getLights();

    Map<String, PHRule> getRules();

    Map<String, PHScene> getScenes();

    Map<String, PHSchedule> getSchedules();

    Map<String, PHSensor> getSensors();
}
