package com.philips.lighting.model;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import java.util.Date;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHScene {
    private PHSceneActiveState activeState;
    private PHAppData appData;
    private Date lastupdated;
    private List<String> lightIdentifiers;
    private Map<String, PHLightState> lightStates;
    private boolean locked;
    private String name;
    private String owner;
    private String picture;
    private boolean recycle;
    private String sceneIdentifier;
    private int transitionTime;
    private Integer version;

    public enum PHSceneActiveState {
        SCENE_STATE_UNKNOWN,
        SCENE_STATE_INACTIVE,
        SCENE_STATE_ACTIVE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHSceneActiveState[] valuesCustom() {
            PHSceneActiveState[] pHSceneActiveStateArrValuesCustom = values();
            int length = pHSceneActiveStateArrValuesCustom.length;
            PHSceneActiveState[] pHSceneActiveStateArr = new PHSceneActiveState[length];
            System.arraycopy(pHSceneActiveStateArrValuesCustom, 0, pHSceneActiveStateArr, 0, length);
            return pHSceneActiveStateArr;
        }
    }

    public PHScene(PHScene pHScene) {
        this.sceneIdentifier = "";
        if (pHScene == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            throw null;
        }
        this.name = pHScene.name;
        this.sceneIdentifier = pHScene.sceneIdentifier;
        this.activeState = pHScene.activeState;
        this.lightIdentifiers = pHScene.lightIdentifiers;
        this.transitionTime = pHScene.transitionTime;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHScene pHScene = (PHScene) obj;
        if (this.activeState != pHScene.activeState) {
            return false;
        }
        List<String> list = this.lightIdentifiers;
        List<String> list2 = pHScene.lightIdentifiers;
        if (list == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list.equals(list2)) {
            return false;
        }
        String str = this.name;
        String str2 = pHScene.name;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.sceneIdentifier;
        String str4 = pHScene.sceneIdentifier;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return this.transitionTime == pHScene.transitionTime;
    }

    public PHSceneActiveState getActiveState() {
        return this.activeState;
    }

    public PHAppData getAppData() {
        return this.appData;
    }

    public Date getLastupdated() {
        return this.lastupdated;
    }

    public List<String> getLightIdentifiers() {
        return this.lightIdentifiers;
    }

    public Map<String, PHLightState> getLightStates() {
        return this.lightStates;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getSceneIdentifier() {
        return this.sceneIdentifier;
    }

    public int getTransitionTime() {
        return this.transitionTime;
    }

    public Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        PHSceneActiveState pHSceneActiveState = this.activeState;
        int iHashCode = ((pHSceneActiveState == null ? 0 : pHSceneActiveState.hashCode()) + 31) * 31;
        List<String> list = this.lightIdentifiers;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sceneIdentifier;
        return ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.transitionTime;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean isRecycle() {
        return this.recycle;
    }

    public void setActiveState(PHSceneActiveState pHSceneActiveState) {
        this.activeState = pHSceneActiveState;
    }

    public void setAppData(PHAppData pHAppData) {
        this.appData = pHAppData;
    }

    public void setLastupdated(Date date) {
        this.lastupdated = date;
    }

    public void setLightIdentifiers(List<String> list) {
        this.lightIdentifiers = list;
    }

    public void setLightStates(Map<String, PHLightState> map) {
        this.lightStates = map;
    }

    public void setLocked(boolean z) {
        this.locked = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setRecycle(boolean z) {
        this.recycle = z;
    }

    public void setSceneIdentifier(String str) {
        this.sceneIdentifier = str;
    }

    public void setTransitionTime(int i) {
        this.transitionTime = i;
    }

    public void setVersion(Integer num) {
        this.version = num;
    }

    public PHScene() {
        this.sceneIdentifier = "";
    }
}
