package com.philips.lighting.model.rule;

import com.philips.lighting.model.PHLightState;

/* JADX INFO: loaded from: classes4.dex */
public class PHSimpleRuleAction extends PHRuleAction {
    private String groupIdentifier;
    private String lightIdentifier;
    private PHLightState lightState;
    private String sceneIdentifier;

    @Override // com.philips.lighting.model.rule.PHRuleAction
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHSimpleRuleAction pHSimpleRuleAction = (PHSimpleRuleAction) obj;
        String str = this.groupIdentifier;
        String str2 = pHSimpleRuleAction.groupIdentifier;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.lightIdentifier;
        String str4 = pHSimpleRuleAction.lightIdentifier;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        PHLightState pHLightState = this.lightState;
        PHLightState pHLightState2 = pHSimpleRuleAction.lightState;
        if (pHLightState == null) {
            if (pHLightState2 != null) {
                return false;
            }
        } else if (!pHLightState.equals(pHLightState2)) {
            return false;
        }
        String str5 = this.sceneIdentifier;
        String str6 = pHSimpleRuleAction.sceneIdentifier;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        return true;
    }

    public String getGroupIdentifier() {
        return this.groupIdentifier;
    }

    public String getLightIdentifier() {
        return this.lightIdentifier;
    }

    public PHLightState getLightState() {
        return this.lightState;
    }

    public String getSceneIdentifier() {
        return this.sceneIdentifier;
    }

    @Override // com.philips.lighting.model.rule.PHRuleAction
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.groupIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lightIdentifier;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PHLightState pHLightState = this.lightState;
        int iHashCode4 = (iHashCode3 + (pHLightState == null ? 0 : pHLightState.hashCode())) * 31;
        String str3 = this.sceneIdentifier;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setGroupIdentifier(String str) {
        this.groupIdentifier = str;
    }

    public void setLightIdentifier(String str) {
        this.lightIdentifier = str;
    }

    public void setLightState(PHLightState pHLightState) {
        this.lightState = pHLightState;
    }

    public void setSceneIdentifier(String str) {
        this.sceneIdentifier = str;
    }
}
