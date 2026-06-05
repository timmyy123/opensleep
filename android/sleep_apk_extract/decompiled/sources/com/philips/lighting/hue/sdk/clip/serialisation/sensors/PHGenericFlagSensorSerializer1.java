package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHGenericFlagSensor;
import com.philips.lighting.model.sensor.PHGenericFlagSensorConfiguration;
import com.philips.lighting.model.sensor.PHGenericFlagSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGenericFlagSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHGenericFlagSensorConfiguration pHGenericFlagSensorConfiguration) {
        jSONObject.putOpt("config", PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHGenericFlagSensorConfiguration));
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHGenericFlagSensorState pHGenericFlagSensorState) {
        if (pHGenericFlagSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHGenericFlagSensorState);
            jSONSensorStateBase.putOpt("flag", pHGenericFlagSensorState.getFlag());
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHGenericFlagSensor createConfigurationFromJSON(JSONObject jSONObject, PHGenericFlagSensor pHGenericFlagSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHGenericFlagSensor.setConfiguration((PHGenericFlagSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHGenericFlagSensorConfiguration(), jSONObjectOptJSONObject));
        }
        return pHGenericFlagSensor;
    }

    public static PHGenericFlagSensor createFromJSON(JSONObject jSONObject, String str) {
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHGenericFlagSensor) PHSensorSerializerBase1.fillBasicSensor(new PHGenericFlagSensor("", str), jSONObject)));
    }

    private static PHGenericFlagSensor createStateFromJSON(JSONObject jSONObject, PHGenericFlagSensor pHGenericFlagSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHGenericFlagSensorState pHGenericFlagSensorState = (PHGenericFlagSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHGenericFlagSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("flag")) {
                pHGenericFlagSensorState.setFlag(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("flag")));
            } else {
                pHGenericFlagSensorState.setFlag(null);
            }
            pHGenericFlagSensor.setState(pHGenericFlagSensorState);
        }
        return pHGenericFlagSensor;
    }

    public static JSONObject getConfigurationJSON(PHGenericFlagSensor pHGenericFlagSensor) {
        return getJSON(pHGenericFlagSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHGenericFlagSensor pHGenericFlagSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHGenericFlagSensor);
        jSONSensorBase.putOpt("type", pHGenericFlagSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHGenericFlagSensor.getState()), pHGenericFlagSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHGenericFlagSensor pHGenericFlagSensor) {
        return getJSON(pHGenericFlagSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
