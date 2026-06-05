package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.sensor.PHSensor;
import com.philips.lighting.model.sensor.PHSensorConfiguration;
import com.philips.lighting.model.sensor.PHSensorState;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHSensorSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canFetchAll();

    boolean canRead();

    boolean canSensorConfigurationCreate();

    boolean canSensorConfigurationDelete();

    boolean canSensorConfigurationRead();

    boolean canSensorConfigurationUpdate();

    boolean canSensorStateCreate();

    boolean canSensorStateDelete();

    boolean canSensorStateRead();

    boolean canSensorStateUpdate();

    boolean canUpdate();

    JSONObject createFindSensorWithSerialsPacket(List<String> list);

    JSONObject createSensorPacket(PHSensor pHSensor);

    List<PHSensor> parseSensors(JSONObject jSONObject);

    JSONObject updateSensorConfigurationPacket(PHSensor pHSensor);

    JSONObject updateSensorPacket(PHSensor pHSensor);

    JSONObject updateSensorStatePacket(PHSensor pHSensor);

    boolean validateAPI(PHSensor pHSensor);

    boolean validateAPI(PHSensorConfiguration pHSensorConfiguration);

    boolean validateAPI(PHSensorState pHSensorState);
}
