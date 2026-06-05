package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHOpenCloseSensor;
import com.philips.lighting.model.sensor.PHOpenCloseSensorConfiguration;
import com.philips.lighting.model.sensor.PHOpenCloseSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHOpenCloseSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHOpenCloseSensorConfiguration pHOpenCloseSensorConfiguration) {
        if (pHOpenCloseSensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHOpenCloseSensorConfiguration);
            if (jSONObject.getString("type").equals(PHOpenCloseSensor.Type.ZLL.getValue())) {
                jSONSensorConfigurationBase.remove("battery");
            }
            jSONObject.put("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHOpenCloseSensorState pHOpenCloseSensorState) {
        if (pHOpenCloseSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHOpenCloseSensorState);
            if (!jSONObject.getString("type").equals(PHOpenCloseSensor.Type.ZLL.getValue())) {
                jSONSensorStateBase.putOpt("open", pHOpenCloseSensorState.getOpen());
            }
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHOpenCloseSensor createConfigurationFromJSON(JSONObject jSONObject, PHOpenCloseSensor pHOpenCloseSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHOpenCloseSensor.setConfiguration((PHOpenCloseSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHOpenCloseSensorConfiguration(), jSONObjectOptJSONObject));
        }
        return pHOpenCloseSensor;
    }

    public static PHOpenCloseSensor createFromJSON(JSONObject jSONObject, String str) {
        PHOpenCloseSensor.Type type = PHOpenCloseSensor.Type.CLIP;
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            PHOpenCloseSensor.Type type2 = PHOpenCloseSensor.Type.ZLL;
            if (strOptString.equals(type2.getValue())) {
                type = type2;
            }
        }
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHOpenCloseSensor) PHSensorSerializerBase1.fillBasicSensor(new PHOpenCloseSensor("", str, type), jSONObject)));
    }

    private static PHOpenCloseSensor createStateFromJSON(JSONObject jSONObject, PHOpenCloseSensor pHOpenCloseSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHOpenCloseSensorState pHOpenCloseSensorState = (PHOpenCloseSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHOpenCloseSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("open")) {
                pHOpenCloseSensorState.setOpen(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("open")));
            } else {
                pHOpenCloseSensorState.setOpen(null);
            }
            pHOpenCloseSensor.setState(pHOpenCloseSensorState);
        }
        return pHOpenCloseSensor;
    }

    public static JSONObject getConfigurationJSON(PHOpenCloseSensor pHOpenCloseSensor) {
        return getJSON(pHOpenCloseSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHOpenCloseSensor pHOpenCloseSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHOpenCloseSensor);
        jSONSensorBase.putOpt("type", pHOpenCloseSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHOpenCloseSensor.getState()), pHOpenCloseSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHOpenCloseSensor pHOpenCloseSensor) {
        return getJSON(pHOpenCloseSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
