package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHTemperatureSensor;
import com.philips.lighting.model.sensor.PHTemperatureSensorConfiguration;
import com.philips.lighting.model.sensor.PHTemperatureSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHTemperatureSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHTemperatureSensorConfiguration pHTemperatureSensorConfiguration) {
        if (pHTemperatureSensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHTemperatureSensorConfiguration);
            if (jSONObject.getString("type").equals(PHTemperatureSensor.Type.ZLL.getValue())) {
                jSONSensorConfigurationBase.remove("battery");
            }
            jSONObject.put("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHTemperatureSensorState pHTemperatureSensorState) {
        if (pHTemperatureSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHTemperatureSensorState);
            if (!jSONObject.getString("type").equals(PHTemperatureSensor.Type.ZLL.getValue())) {
                jSONSensorStateBase.putOpt("temperature", pHTemperatureSensorState.getTemperature());
            }
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHTemperatureSensor createConfigurationFromJSON(JSONObject jSONObject, PHTemperatureSensor pHTemperatureSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHTemperatureSensor.setConfiguration((PHTemperatureSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHTemperatureSensorConfiguration(), jSONObjectOptJSONObject));
        }
        return pHTemperatureSensor;
    }

    public static PHTemperatureSensor createFromJSON(JSONObject jSONObject, String str) {
        PHTemperatureSensor.Type type = PHTemperatureSensor.Type.CLIP;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            PHTemperatureSensor.Type type2 = PHTemperatureSensor.Type.ZLL;
            if (strOptString.equals(type2.getValue())) {
                type = type2;
            }
        }
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHTemperatureSensor) PHSensorSerializerBase1.fillBasicSensor(new PHTemperatureSensor("", str, type), jSONObject)));
    }

    private static PHTemperatureSensor createStateFromJSON(JSONObject jSONObject, PHTemperatureSensor pHTemperatureSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHTemperatureSensorState pHTemperatureSensorState = (PHTemperatureSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHTemperatureSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("temperature")) {
                pHTemperatureSensorState.setTemperature(Integer.valueOf(jSONObjectOptJSONObject.optInt("temperature")));
            } else {
                pHTemperatureSensorState.setTemperature(null);
            }
            pHTemperatureSensor.setState(pHTemperatureSensorState);
        }
        return pHTemperatureSensor;
    }

    public static JSONObject getConfigurationJSON(PHTemperatureSensor pHTemperatureSensor) {
        return getJSON(pHTemperatureSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHTemperatureSensor pHTemperatureSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHTemperatureSensor);
        jSONSensorBase.putOpt("type", pHTemperatureSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHTemperatureSensor.getState()), pHTemperatureSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHTemperatureSensor pHTemperatureSensor) {
        return getJSON(pHTemperatureSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
