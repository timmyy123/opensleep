package com.philips.lighting.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PHSoftwareUpdateDeviceTypes {
    private List<String> batteryLights;
    private List<String> batterySensors;
    private List<String> mainsLights;
    private List<String> mainsSensors;
    private List<String> slowSensors;

    public PHSoftwareUpdateDeviceTypes() {
        this.mainsLights = new ArrayList();
        this.batteryLights = new ArrayList();
        this.mainsSensors = new ArrayList();
        this.batterySensors = new ArrayList();
        this.slowSensors = new ArrayList();
    }

    public void addBatteryLight(String str) {
        if (this.batteryLights == null) {
            this.batteryLights = new ArrayList();
        }
        this.batteryLights.add(str);
    }

    public void addBatterySensor(String str) {
        if (this.batterySensors == null) {
            this.batterySensors = new ArrayList();
        }
        this.batterySensors.add(str);
    }

    public void addMainsLight(String str) {
        if (this.mainsLights == null) {
            this.mainsLights = new ArrayList();
        }
        this.mainsLights.add(str);
    }

    public void addMainsSensor(String str) {
        if (this.mainsSensors == null) {
            this.mainsSensors = new ArrayList();
        }
        this.mainsSensors.add(str);
    }

    public void addSlowSensor(String str) {
        if (this.slowSensors == null) {
            this.slowSensors = new ArrayList();
        }
        this.slowSensors.add(str);
    }

    public List<String> getBatteryLights() {
        return this.batteryLights;
    }

    public List<String> getBatterySensors() {
        return this.batterySensors;
    }

    public List<String> getMainsLights() {
        return this.mainsLights;
    }

    public List<String> getMainsSensors() {
        return this.mainsSensors;
    }

    public List<String> getSlowSensors() {
        return this.slowSensors;
    }

    public void setBatteryLights(List<String> list) {
        this.batteryLights = list;
    }

    public void setBatterySensors(List<String> list) {
        this.batterySensors = list;
    }

    public void setMainsLights(List<String> list) {
        this.mainsLights = list;
    }

    public void setMainsSensors(List<String> list) {
        this.mainsSensors = list;
    }

    public void setSlowSensors(List<String> list) {
        this.slowSensors = list;
    }

    public PHSoftwareUpdateDeviceTypes(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        this.mainsLights = list;
        this.batteryLights = list2;
        this.mainsSensors = list3;
        this.batterySensors = list4;
        this.slowSensors = list5;
    }
}
