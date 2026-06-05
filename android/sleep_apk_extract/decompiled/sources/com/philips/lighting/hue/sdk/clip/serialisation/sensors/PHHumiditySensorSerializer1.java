package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHHumiditySensor;
import com.philips.lighting.model.sensor.PHHumiditySensorConfiguration;
import com.philips.lighting.model.sensor.PHHumiditySensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHHumiditySensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHHumiditySensorConfiguration pHHumiditySensorConfiguration) {
        if (pHHumiditySensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHHumiditySensorConfiguration);
            if (jSONObject.getString("type").equals(PHHumiditySensor.Type.ZLL.getValue())) {
                jSONSensorConfigurationBase.remove("battery");
            }
            jSONObject.put("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHHumiditySensorState pHHumiditySensorState) {
        if (pHHumiditySensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHHumiditySensorState);
            if (!jSONObject.getString("type").equals(PHHumiditySensor.Type.ZLL.getValue())) {
                jSONSensorStateBase.putOpt("humidity", pHHumiditySensorState.getHumidity());
            }
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHHumiditySensor createConfigurationFromJSON(JSONObject jSONObject, PHHumiditySensor pHHumiditySensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHHumiditySensor.setConfiguration((PHHumiditySensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHHumiditySensorConfiguration(), jSONObjectOptJSONObject));
        }
        return pHHumiditySensor;
    }

    public static PHHumiditySensor createFromJSON(JSONObject jSONObject, String str) {
        PHHumiditySensor.Type type = PHHumiditySensor.Type.CLIP;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            PHHumiditySensor.Type type2 = PHHumiditySensor.Type.ZLL;
            if (strOptString.equals(type2.getValue())) {
                type = type2;
            }
        }
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHHumiditySensor) PHSensorSerializerBase1.fillBasicSensor(new PHHumiditySensor("", str, type), jSONObject)));
    }

    private static PHHumiditySensor createStateFromJSON(JSONObject jSONObject, PHHumiditySensor pHHumiditySensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHHumiditySensorState pHHumiditySensorState = (PHHumiditySensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHHumiditySensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("humidity")) {
                pHHumiditySensorState.setHumidity(Integer.valueOf(jSONObjectOptJSONObject.optInt("humidity")));
            } else {
                pHHumiditySensorState.setHumidity(null);
            }
            pHHumiditySensor.setState(pHHumiditySensorState);
        }
        return pHHumiditySensor;
    }

    public static JSONObject getConfigurationJSON(PHHumiditySensor pHHumiditySensor) {
        return getJSON(pHHumiditySensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHHumiditySensor pHHumiditySensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHHumiditySensor);
        jSONSensorBase.putOpt("type", pHHumiditySensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHHumiditySensor.getState()), pHHumiditySensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHHumiditySensor pHHumiditySensor) {
        return getJSON(pHHumiditySensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
