package com.philips.lighting.model.sensor.metadata;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchButtonActionPair {
    private PHSwitchButtonAction action;
    private PHSwitchButtonInfo buttonInfo;

    public enum PHSwitchButtonAction {
        SHORT_PRESS,
        LONG_PRESS,
        PRESS_HOLD,
        PRESS_START,
        PRESS_RELEASE,
        NONE,
        INITIAL_PRESSED,
        HOLD,
        SHORT_RELEASED,
        LONG_RELEASED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHSwitchButtonAction[] valuesCustom() {
            PHSwitchButtonAction[] pHSwitchButtonActionArrValuesCustom = values();
            int length = pHSwitchButtonActionArrValuesCustom.length;
            PHSwitchButtonAction[] pHSwitchButtonActionArr = new PHSwitchButtonAction[length];
            System.arraycopy(pHSwitchButtonActionArrValuesCustom, 0, pHSwitchButtonActionArr, 0, length);
            return pHSwitchButtonActionArr;
        }
    }

    public PHSwitchButtonActionPair(PHSwitchButtonInfo pHSwitchButtonInfo, PHSwitchButtonAction pHSwitchButtonAction) {
        this.buttonInfo = pHSwitchButtonInfo;
        this.action = pHSwitchButtonAction;
    }

    public PHSwitchButtonAction getAction() {
        return this.action;
    }

    public PHSwitchButtonInfo getButtonInfo() {
        return this.buttonInfo;
    }

    public void setAction(PHSwitchButtonAction pHSwitchButtonAction) {
        this.action = pHSwitchButtonAction;
    }

    public void setButtonInfo(PHSwitchButtonInfo pHSwitchButtonInfo) {
        this.buttonInfo = pHSwitchButtonInfo;
    }
}
