package com.philips.lighting.model.sensor;

import com.philips.lighting.model.sensor.PHSensorConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public class PHPresenceSensorConfiguration extends PHSensorConfiguration {
    private Integer motionSensitivity;

    public PHPresenceSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, PHSensorConfiguration.PHSensorAlertMode pHSensorAlertMode, Integer num2) {
        super(str, num, bool, bool2, bool3, pHSensorAlertMode);
        this.motionSensitivity = num2;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Integer num = this.motionSensitivity;
        Integer num2 = ((PHPresenceSensorConfiguration) obj).motionSensitivity;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public Integer getMotionSensitivity() {
        return this.motionSensitivity;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.motionSensitivity;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public void setMotionSensitivity(Integer num) {
        this.motionSensitivity = num;
    }

    public PHPresenceSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2) {
        super(str, num, bool, bool2);
    }

    public PHPresenceSensorConfiguration() {
    }
}
