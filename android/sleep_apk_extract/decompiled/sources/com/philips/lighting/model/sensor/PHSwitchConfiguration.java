package com.philips.lighting.model.sensor;

import com.philips.lighting.model.sensor.PHSensorConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchConfiguration extends PHSensorConfiguration {
    public PHSwitchConfiguration(String str, int i, Boolean bool, Boolean bool2) {
        super(str, Integer.valueOf(i), bool, bool2);
    }

    public PHSwitchConfiguration() {
    }

    public PHSwitchConfiguration(String str, int i, Boolean bool, Boolean bool2, Boolean bool3, PHSensorConfiguration.PHSensorAlertMode pHSensorAlertMode) {
        super(str, Integer.valueOf(i), bool, bool2, bool3, pHSensorAlertMode);
    }
}
