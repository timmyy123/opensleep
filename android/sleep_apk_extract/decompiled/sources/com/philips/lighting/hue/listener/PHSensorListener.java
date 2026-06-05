package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.sensor.PHSensor;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHSensorListener extends PHBridgeAPIListener {
    void onReceivingSensorDetails(PHSensor pHSensor);

    void onSensorSearchFinished();

    void onSensorsReceived(List<PHBridgeResource> list);
}
