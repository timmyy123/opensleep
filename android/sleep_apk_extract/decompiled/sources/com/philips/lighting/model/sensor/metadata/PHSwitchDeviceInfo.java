package com.philips.lighting.model.sensor.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchDeviceInfo {
    private List<PHSwitchButtonInfo> buttons;
    private Map<Integer, List<PHSwitchButtonActionPair>> eventButtonMapping;
    private String housingImageName;
    private String manufacturerName;
    private String modelId;
    private String modelName;
    private List<Long> srcIdEndList;
    private List<Long> srcIdStartList;

    public PHSwitchDeviceInfo() {
        this.modelName = null;
        this.modelId = null;
        this.manufacturerName = null;
        this.srcIdStartList = new ArrayList();
        this.srcIdEndList = new ArrayList();
        this.buttons = null;
        this.eventButtonMapping = null;
        this.buttons = new ArrayList();
        this.eventButtonMapping = new HashMap();
    }

    public List<PHSwitchButtonActionPair> getButtonActionPairForEventCode(Integer num) {
        if (num != null) {
            return this.eventButtonMapping.get(num);
        }
        return null;
    }

    public List<PHSwitchButtonInfo> getButtons() {
        return this.buttons;
    }

    public Map<Integer, List<PHSwitchButtonActionPair>> getEventButtonMapping() {
        return this.eventButtonMapping;
    }

    public String getHousingImageName() {
        return this.housingImageName;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getModelName() {
        return this.modelName;
    }

    public List<Long> getSrcIdEnd() {
        return this.srcIdEndList;
    }

    public List<Long> getSrcIdStart() {
        return this.srcIdStartList;
    }

    public void setButtons(List<PHSwitchButtonInfo> list) {
        this.buttons = list;
    }

    public void setEventButtonMapping(Map<Integer, List<PHSwitchButtonActionPair>> map) {
        this.eventButtonMapping = map;
    }

    public void setHousingImageName(String str) {
        this.housingImageName = str;
    }

    public void setManufacturerName(String str) {
        this.manufacturerName = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setSrcIdEnd(List<Long> list) {
        this.srcIdEndList = list;
    }

    public void setSrcIdStart(List<Long> list) {
        this.srcIdStartList = list;
    }

    public PHSwitchDeviceInfo(String str, String str2, String str3, List<Long> list, List<Long> list2, List<PHSwitchButtonInfo> list3, Map<Integer, List<PHSwitchButtonActionPair>> map, String str4) {
        this.modelName = null;
        this.modelId = null;
        this.manufacturerName = null;
        this.srcIdStartList = new ArrayList();
        new ArrayList();
        this.modelName = str;
        this.modelId = str2;
        this.manufacturerName = str3;
        this.srcIdStartList = list;
        this.srcIdEndList = list2;
        this.buttons = list3;
        this.eventButtonMapping = map;
        this.housingImageName = str4;
    }

    public PHSwitchDeviceInfo(String str, String str2, String str3, List<Long> list, List<Long> list2, String str4) {
        this();
        this.modelName = str;
        this.modelId = str2;
        this.manufacturerName = str3;
        this.srcIdStartList = list;
        this.srcIdEndList = list2;
        this.housingImageName = str4;
    }
}
