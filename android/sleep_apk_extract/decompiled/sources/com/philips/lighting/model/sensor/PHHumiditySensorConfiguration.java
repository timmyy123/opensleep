package com.philips.lighting.model.sensor;

import com.philips.lighting.model.sensor.PHSensorConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public class PHHumiditySensorConfiguration extends PHSensorConfiguration {
    public PHHumiditySensorConfiguration(String str, int i, Boolean bool, Boolean bool2) {
        super(str, Integer.valueOf(i), bool, bool2);
    }

    public PHHumiditySensorConfiguration() {
    }

    public PHHumiditySensorConfiguration(String str, int i, Boolean bool, Boolean bool2, Boolean bool3, PHSensorConfiguration.PHSensorAlertMode pHSensorAlertMode) {
        super(str, Integer.valueOf(i), bool, bool2, bool3, pHSensorAlertMode);
    }
}
