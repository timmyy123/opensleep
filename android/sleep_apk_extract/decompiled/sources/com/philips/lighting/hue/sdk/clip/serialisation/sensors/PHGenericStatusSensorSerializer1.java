package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHGenericStatusSensor;
import com.philips.lighting.model.sensor.PHGenericStatusSensorConfiguration;
import com.philips.lighting.model.sensor.PHGenericStatusSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGenericStatusSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHGenericStatusSensorConfiguration pHGenericStatusSensorConfiguration) {
        if (pHGenericStatusSensorConfiguration != null) {
            jSONObject.put("config", PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHGenericStatusSensorConfiguration));
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHGenericStatusSensorState pHGenericStatusSensorState) {
        if (pHGenericStatusSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHGenericStatusSensorState);
            jSONSensorStateBase.putOpt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, pHGenericStatusSensorState.getStatus());
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHGenericStatusSensor createConfigurationFromJSON(JSONObject jSONObject, PHGenericStatusSensor pHGenericStatusSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            pHGenericStatusSensor.setConfiguration((PHGenericStatusSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHGenericStatusSensorConfiguration(), jSONObjectOptJSONObject));
        }
        return pHGenericStatusSensor;
    }

    public static PHGenericStatusSensor createFromJSON(JSONObject jSONObject, String str) {
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHGenericStatusSensor) PHSensorSerializerBase1.fillBasicSensor(new PHGenericStatusSensor("", str), jSONObject)));
    }

    private static PHGenericStatusSensor createStateFromJSON(JSONObject jSONObject, PHGenericStatusSensor pHGenericStatusSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHGenericStatusSensorState pHGenericStatusSensorState = (PHGenericStatusSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHGenericStatusSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                pHGenericStatusSensorState.setStatus(Integer.valueOf(jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)));
            } else {
                pHGenericStatusSensorState.setStatus(null);
            }
            pHGenericStatusSensor.setState(pHGenericStatusSensorState);
        }
        return pHGenericStatusSensor;
    }

    public static JSONObject getConfigurationJSON(PHGenericStatusSensor pHGenericStatusSensor) {
        return getJSON(pHGenericStatusSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHGenericStatusSensor pHGenericStatusSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHGenericStatusSensor);
        jSONSensorBase.putOpt("type", pHGenericStatusSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHGenericStatusSensor.getState()), pHGenericStatusSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHGenericStatusSensor pHGenericStatusSensor) {
        return getJSON(pHGenericStatusSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
