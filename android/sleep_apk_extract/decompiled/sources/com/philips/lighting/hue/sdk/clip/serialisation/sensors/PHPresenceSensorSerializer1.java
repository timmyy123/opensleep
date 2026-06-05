package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHPresenceSensor;
import com.philips.lighting.model.sensor.PHPresenceSensorConfiguration;
import com.philips.lighting.model.sensor.PHPresenceSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHPresenceSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHPresenceSensorConfiguration pHPresenceSensorConfiguration) {
        if (pHPresenceSensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHPresenceSensorConfiguration);
            jSONSensorConfigurationBase.putOpt("motionsensitivity", pHPresenceSensorConfiguration.getMotionSensitivity());
            if (jSONObject.getString("type").equals(PHPresenceSensor.Type.ZLL.getValue())) {
                jSONSensorConfigurationBase.remove("battery");
            }
            jSONObject.putOpt("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHPresenceSensorState pHPresenceSensorState) {
        if (pHPresenceSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHPresenceSensorState);
            if (!jSONObject.getString("type").equals(PHPresenceSensor.Type.ZLL.getValue())) {
                jSONSensorStateBase.putOpt("presence", pHPresenceSensorState.getPresence());
            }
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHPresenceSensor createConfigurationFromJSON(JSONObject jSONObject, PHPresenceSensor pHPresenceSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            PHPresenceSensorConfiguration pHPresenceSensorConfiguration = (PHPresenceSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHPresenceSensorConfiguration(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("motionsensitivity")) {
                pHPresenceSensorConfiguration.setMotionSensitivity(Integer.valueOf(jSONObjectOptJSONObject.optInt("motionsensitivity")));
            } else {
                pHPresenceSensorConfiguration.setMotionSensitivity(null);
            }
            pHPresenceSensor.setConfiguration(pHPresenceSensorConfiguration);
        }
        return pHPresenceSensor;
    }

    public static PHPresenceSensor createFromJSON(JSONObject jSONObject, String str) {
        PHPresenceSensor.Type type = PHPresenceSensor.Type.CLIP;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            PHPresenceSensor.Type type2 = PHPresenceSensor.Type.ZLL;
            if (strOptString.equals(type2.getValue())) {
                type = type2;
            }
        }
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHPresenceSensor) PHSensorSerializerBase1.fillBasicSensor(new PHPresenceSensor("", str, type), jSONObject)));
    }

    private static PHPresenceSensor createStateFromJSON(JSONObject jSONObject, PHPresenceSensor pHPresenceSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHPresenceSensorState pHPresenceSensorState = (PHPresenceSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHPresenceSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("presence")) {
                pHPresenceSensorState.setPresence(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("presence")));
            } else {
                pHPresenceSensorState.setPresence(null);
            }
            pHPresenceSensor.setState(pHPresenceSensorState);
        }
        return pHPresenceSensor;
    }

    public static JSONObject getConfigurationJSON(PHPresenceSensor pHPresenceSensor) {
        return getJSON(pHPresenceSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHPresenceSensor pHPresenceSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHPresenceSensor);
        jSONSensorBase.putOpt("type", pHPresenceSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHPresenceSensor.getState()), pHPresenceSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHPresenceSensor pHPresenceSensor) {
        return getJSON(pHPresenceSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
