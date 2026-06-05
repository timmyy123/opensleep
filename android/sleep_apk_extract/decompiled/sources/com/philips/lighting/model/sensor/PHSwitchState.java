package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchState extends PHSensorState {
    public static final int BUTTON_EVENT_CODE_PRESS_BUTTON_1 = 98;
    public static final int BUTTON_EVENT_CODE_PRESS_BUTTON_2 = 100;
    public static final int BUTTON_EVENT_CODE_RELEASE_BUTTON_1 = 99;
    public static final int BUTTON_EVENT_CODE_RELEASE_BUTTON_2 = 101;
    public static final int BUTTON_EVENT_CODE_SCENE_1 = 16;
    public static final int BUTTON_EVENT_CODE_SCENE_2 = 17;
    public static final int BUTTON_EVENT_CODE_SCENE_3 = 18;
    public static final int BUTTON_EVENT_CODE_SCENE_4 = 19;
    public static final int BUTTON_EVENT_CODE_SCENE_5 = 20;
    public static final int BUTTON_EVENT_CODE_SCENE_6 = 21;
    public static final int BUTTON_EVENT_CODE_SCENE_7 = 22;
    public static final int BUTTON_EVENT_CODE_SCENE_8 = 23;
    public static final int BUTTON_EVENT_CODE_TOGGLE = 34;
    public static final int BUTTON_EVENT_CODE_UNKNOWN = 0;
    private Integer buttonEvent;

    public PHSwitchState(Integer num) {
        this.buttonEvent = num;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Integer num = this.buttonEvent;
        Integer num2 = ((PHSwitchState) obj).buttonEvent;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public Integer getButtonEvent() {
        return this.buttonEvent;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.buttonEvent;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public void setButtonEvent(Integer num) {
        this.buttonEvent = num;
    }

    public PHSwitchState() {
    }
}
