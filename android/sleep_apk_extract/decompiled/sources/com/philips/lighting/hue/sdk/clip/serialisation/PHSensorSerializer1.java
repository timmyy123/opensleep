package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHSensorSerializer;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHDaylightSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHGenericFlagSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHGenericStatusSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHGeofenceSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHHumiditySensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHOpenCloseSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHPresenceSensorSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHSwitchSerializer1;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHTemperatureSensorSerializer1;
import com.philips.lighting.hue.sdk.exception.PHHueException;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.sensor.PHDaylightSensor;
import com.philips.lighting.model.sensor.PHGenericFlagSensor;
import com.philips.lighting.model.sensor.PHGenericStatusSensor;
import com.philips.lighting.model.sensor.PHGeofenceSensor;
import com.philips.lighting.model.sensor.PHHumiditySensor;
import com.philips.lighting.model.sensor.PHOpenCloseSensor;
import com.philips.lighting.model.sensor.PHPresenceSensor;
import com.philips.lighting.model.sensor.PHSensor;
import com.philips.lighting.model.sensor.PHSensorConfiguration;
import com.philips.lighting.model.sensor.PHSensorState;
import com.philips.lighting.model.sensor.PHSwitch;
import com.philips.lighting.model.sensor.PHTemperatureSensor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSensorSerializer1 extends PHCLIPParserBase implements PHSensorSerializer {
    private static final String TAG = "PHSensorSerializer1";
    private static PHSensorSerializer1 sensorSerialisation1;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHSensorSerializer1 m861getInstance() {
        try {
            if (sensorSerialisation1 == null) {
                sensorSerialisation1 = new PHSensorSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sensorSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canDelete() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canFetchAll() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorConfigurationCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorConfigurationDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorConfigurationRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorConfigurationUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorStateCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorStateDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorStateRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canSensorStateUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public JSONObject createFindSensorWithSerialsPacket(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("deviceid", jSONArray);
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public JSONObject createSensorPacket(PHSensor pHSensor) {
        if (pHSensor instanceof PHDaylightSensor) {
            return PHDaylightSensorSerializer1.getJSON((PHDaylightSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericFlagSensor) {
            return PHGenericFlagSensorSerializer1.getJSON((PHGenericFlagSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericStatusSensor) {
            return PHGenericStatusSensorSerializer1.getJSON((PHGenericStatusSensor) pHSensor);
        }
        if (pHSensor instanceof PHGeofenceSensor) {
            return PHGeofenceSensorSerializer1.getJSON((PHGeofenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHHumiditySensor) {
            return PHHumiditySensorSerializer1.getJSON((PHHumiditySensor) pHSensor);
        }
        if (pHSensor instanceof PHOpenCloseSensor) {
            return PHOpenCloseSensorSerializer1.getJSON((PHOpenCloseSensor) pHSensor);
        }
        if (pHSensor instanceof PHPresenceSensor) {
            return PHPresenceSensorSerializer1.getJSON((PHPresenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHSwitch) {
            return PHSwitchSerializer1.getJSON((PHSwitch) pHSensor);
        }
        if (pHSensor instanceof PHTemperatureSensor) {
            return PHTemperatureSensorSerializer1.getJSON((PHTemperatureSensor) pHSensor);
        }
        return null;
    }

    public PHSensor parseGetSensorDetails(String str, String str2) {
        try {
            List<PHSensor> sensors = parseSensors(new JSONObject(str));
            if (sensors == null || sensors.size() == 0) {
                return null;
            }
            for (PHSensor pHSensor : sensors) {
                if (pHSensor.getIdentifier().equals(str2)) {
                    return pHSensor;
                }
            }
            return null;
        } catch (JSONException e) {
            if (!PHLog.isLoggable()) {
                return null;
            }
            PHLog.e(TAG, "JSONException: " + e);
            return null;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public List<PHSensor> parseSensors(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sensors");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String strOptString = jSONArrayNames.optString(i);
                try {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString2 = jSONObjectOptJSONObject2.optString("type");
                        if (strOptString2 == null || strOptString2.length() == 0) {
                            throw new PHHueException(PHHueResourcesConstants.TXT_SENSOR_TYPE_MISSING);
                        }
                        if (strOptString2.equals(PHGenericFlagSensor.Type.CLIP.getValue())) {
                            arrayList.add(PHGenericFlagSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHGenericStatusSensor.Type.CLIP.getValue())) {
                            arrayList.add(PHGenericStatusSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHSwitch.Type.CLIP.getValue()) || strOptString2.equals(PHSwitch.Type.ZLL.getValue()) || strOptString2.equals(PHSwitch.Type.ZGP.getValue())) {
                            arrayList.add(PHSwitchSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHOpenCloseSensor.Type.CLIP.getValue()) || strOptString2.equals(PHOpenCloseSensor.Type.ZLL.getValue())) {
                            arrayList.add(PHOpenCloseSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHPresenceSensor.Type.CLIP.getValue()) || strOptString2.equals(PHPresenceSensor.Type.ZLL.getValue())) {
                            arrayList.add(PHPresenceSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHGeofenceSensor.Type.CLIP.getValue())) {
                            arrayList.add(PHGeofenceSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHTemperatureSensor.Type.CLIP.getValue()) || strOptString2.equals(PHTemperatureSensor.Type.ZLL.getValue())) {
                            arrayList.add(PHTemperatureSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else if (strOptString2.equals(PHHumiditySensor.Type.CLIP.getValue()) || strOptString2.equals(PHHumiditySensor.Type.ZLL.getValue())) {
                            arrayList.add(PHHumiditySensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        } else {
                            if (!strOptString2.equals(PHDaylightSensor.Type.CLIP.getValue())) {
                                throw new PHHueException(PHHueResourcesConstants.TXT_SENSOR_TYPE_MISSING);
                            }
                            arrayList.add(PHDaylightSensorSerializer1.createFromJSON(jSONObjectOptJSONObject2, strOptString));
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    reportParsingError(65, strOptString, "Sensor unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                }
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public JSONObject updateSensorConfigurationPacket(PHSensor pHSensor) {
        if (pHSensor instanceof PHDaylightSensor) {
            return PHDaylightSensorSerializer1.getConfigurationJSON((PHDaylightSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericFlagSensor) {
            return PHGenericFlagSensorSerializer1.getConfigurationJSON((PHGenericFlagSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericStatusSensor) {
            return PHGenericStatusSensorSerializer1.getConfigurationJSON((PHGenericStatusSensor) pHSensor);
        }
        if (pHSensor instanceof PHGeofenceSensor) {
            return PHGeofenceSensorSerializer1.getConfigurationJSON((PHGeofenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHHumiditySensor) {
            return PHHumiditySensorSerializer1.getConfigurationJSON((PHHumiditySensor) pHSensor);
        }
        if (pHSensor instanceof PHOpenCloseSensor) {
            return PHOpenCloseSensorSerializer1.getConfigurationJSON((PHOpenCloseSensor) pHSensor);
        }
        if (pHSensor instanceof PHPresenceSensor) {
            return PHPresenceSensorSerializer1.getConfigurationJSON((PHPresenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHSwitch) {
            return PHSwitchSerializer1.getConfigurationJSON((PHSwitch) pHSensor);
        }
        if (pHSensor instanceof PHTemperatureSensor) {
            return PHTemperatureSensorSerializer1.getConfigurationJSON((PHTemperatureSensor) pHSensor);
        }
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public JSONObject updateSensorPacket(PHSensor pHSensor) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("name", pHSensor.getName());
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public JSONObject updateSensorStatePacket(PHSensor pHSensor) {
        if (pHSensor instanceof PHDaylightSensor) {
            return PHDaylightSensorSerializer1.getStateJSON((PHDaylightSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericFlagSensor) {
            return PHGenericFlagSensorSerializer1.getStateJSON((PHGenericFlagSensor) pHSensor);
        }
        if (pHSensor instanceof PHGenericStatusSensor) {
            return PHGenericStatusSensorSerializer1.getStateJSON((PHGenericStatusSensor) pHSensor);
        }
        if (pHSensor instanceof PHGeofenceSensor) {
            return PHGeofenceSensorSerializer1.getStateJSON((PHGeofenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHHumiditySensor) {
            return PHHumiditySensorSerializer1.getStateJSON((PHHumiditySensor) pHSensor);
        }
        if (pHSensor instanceof PHOpenCloseSensor) {
            return PHOpenCloseSensorSerializer1.getStateJSON((PHOpenCloseSensor) pHSensor);
        }
        if (pHSensor instanceof PHPresenceSensor) {
            return PHPresenceSensorSerializer1.getStateJSON((PHPresenceSensor) pHSensor);
        }
        if (pHSensor instanceof PHSwitch) {
            return PHSwitchSerializer1.getStateJSON((PHSwitch) pHSensor);
        }
        if (pHSensor instanceof PHTemperatureSensor) {
            return PHTemperatureSensorSerializer1.getStateJSON((PHTemperatureSensor) pHSensor);
        }
        return null;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean validateAPI(PHSensor pHSensor) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean validateAPI(PHSensorConfiguration pHSensorConfiguration) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSensorSerializer
    public boolean validateAPI(PHSensorState pHSensorState) {
        return true;
    }
}
