package com.philips.lighting.hue.sdk.bridge.impl;

import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHGroup;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHScene;
import com.philips.lighting.model.PHSchedule;
import com.philips.lighting.model.rule.PHRule;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeResourcesCacheImpl implements PHBridgeResourcesCache {
    private PHBridgeConfiguration bridgeConfig;
    private Map<String, PHLight> lights = new HashMap();
    private Map<String, PHGroup> groups = new HashMap();
    private Map<String, PHSchedule> schedules = new HashMap();
    private Map<String, PHScene> scenes = new HashMap();
    private Map<String, PHSensor> sensors = new HashMap();
    private Map<String, PHRule> rules = new HashMap();

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHGroup> getAllGroups() {
        ArrayList arrayList = new ArrayList();
        Iterator<PHGroup> it = this.groups.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHLight> getAllLights() {
        ArrayList arrayList = new ArrayList();
        Iterator<PHLight> it = this.lights.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHRule> getAllRules() {
        ArrayList arrayList = new ArrayList();
        Iterator<PHRule> it = this.rules.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHScene> getAllScenes() {
        Map<String, PHScene> map = this.scenes;
        if (map == null) {
            return null;
        }
        Collection<PHScene> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        Iterator<PHScene> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHSchedule> getAllSchedules(boolean z) {
        Collection<PHSchedule> collectionValues = this.schedules.values();
        ArrayList arrayList = new ArrayList();
        for (PHSchedule pHSchedule : collectionValues) {
            if (z && pHSchedule.getRecurringDays() != 0 && pHSchedule.getDate() != null) {
                arrayList.add(pHSchedule);
            } else if (!z && pHSchedule.getRecurringDays() == 0 && pHSchedule.getDate() != null) {
                arrayList.add(pHSchedule);
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHSensor> getAllSensors() {
        ArrayList arrayList = new ArrayList();
        Iterator<PHSensor> it = this.sensors.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public List<PHSchedule> getAllTimers(boolean z) {
        Collection<PHSchedule> collectionValues = this.schedules.values();
        ArrayList arrayList = new ArrayList();
        for (PHSchedule pHSchedule : collectionValues) {
            if (z && pHSchedule.getTimer() != 0 && pHSchedule.getRecurringTimerInterval() != 0) {
                arrayList.add(pHSchedule);
            } else if (!z && pHSchedule.getTimer() != 0 && pHSchedule.getRecurringTimerInterval() == 0) {
                arrayList.add(pHSchedule);
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public PHBridgeConfiguration getBridgeConfiguration() {
        return this.bridgeConfig;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHGroup> getGroups() {
        return this.groups;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHLight> getLights() {
        return this.lights;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHRule> getRules() {
        return this.rules;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHScene> getScenes() {
        return this.scenes;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHSchedule> getSchedules() {
        return this.schedules;
    }

    @Override // com.philips.lighting.model.PHBridgeResourcesCache
    public Map<String, PHSensor> getSensors() {
        return this.sensors;
    }

    public void setBridgeConfiguration(PHBridgeConfiguration pHBridgeConfiguration) {
        this.bridgeConfig = pHBridgeConfiguration;
    }

    public void setGroups(Map<String, PHGroup> map) {
        this.groups = map;
    }

    public void setLights(Map<String, PHLight> map) {
        this.lights = map;
    }

    public void setRules(Map<String, PHRule> map) {
        this.rules = map;
    }

    public void setScenes(Map<String, PHScene> map) {
        this.scenes = map;
    }

    public void setSchedules(Map<String, PHSchedule> map) {
        this.schedules = map;
    }

    public void setSensors(Map<String, PHSensor> map) {
        this.sensors = map;
    }
}
