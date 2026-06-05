package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHGeofenceSensor;
import com.philips.lighting.model.sensor.PHGeofenceSensorConfiguration;
import com.philips.lighting.model.sensor.PHGeofenceSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGeofenceSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHGeofenceSensorConfiguration pHGeofenceSensorConfiguration) {
        if (pHGeofenceSensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHGeofenceSensorConfiguration);
            jSONSensorConfigurationBase.remove("battery");
            jSONSensorConfigurationBase.remove("url");
            jSONSensorConfigurationBase.putOpt(DeviceRequestsHelper.DEVICE_INFO_DEVICE, pHGeofenceSensorConfiguration.getDevice());
            jSONSensorConfigurationBase.putOpt("radius", pHGeofenceSensorConfiguration.getRadius());
            jSONObject.putOpt("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHGeofenceSensorState pHGeofenceSensorState) {
        if (pHGeofenceSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHGeofenceSensorState);
            jSONSensorStateBase.putOpt("presence", pHGeofenceSensorState.getPresence());
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHGeofenceSensor createConfigurationFromJSON(JSONObject jSONObject, PHGeofenceSensor pHGeofenceSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            PHGeofenceSensorConfiguration pHGeofenceSensorConfiguration = (PHGeofenceSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHGeofenceSensorConfiguration(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("radius")) {
                pHGeofenceSensorConfiguration.setRadius(Integer.valueOf(jSONObjectOptJSONObject.optInt("radius")));
            } else {
                pHGeofenceSensorConfiguration.setRadius(null);
            }
            if (jSONObjectOptJSONObject.has(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) {
                pHGeofenceSensorConfiguration.setDevice(jSONObjectOptJSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_DEVICE));
            } else {
                pHGeofenceSensorConfiguration.setDevice(null);
            }
            pHGeofenceSensor.setConfiguration(pHGeofenceSensorConfiguration);
        }
        return pHGeofenceSensor;
    }

    public static PHGeofenceSensor createFromJSON(JSONObject jSONObject, String str) {
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHGeofenceSensor) PHSensorSerializerBase1.fillBasicSensor(new PHGeofenceSensor("", str), jSONObject)));
    }

    private static PHGeofenceSensor createStateFromJSON(JSONObject jSONObject, PHGeofenceSensor pHGeofenceSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHGeofenceSensorState pHGeofenceSensorState = (PHGeofenceSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHGeofenceSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("presence")) {
                pHGeofenceSensorState.setPresence(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("presence")));
            } else {
                pHGeofenceSensorState.setPresence(null);
            }
            pHGeofenceSensor.setState(pHGeofenceSensorState);
        }
        return pHGeofenceSensor;
    }

    public static JSONObject getConfigurationJSON(PHGeofenceSensor pHGeofenceSensor) {
        return getJSON(pHGeofenceSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHGeofenceSensor pHGeofenceSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHGeofenceSensor);
        jSONSensorBase.putOpt("type", pHGeofenceSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHGeofenceSensor.getState()), pHGeofenceSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHGeofenceSensor pHGeofenceSensor) {
        return getJSON(pHGeofenceSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
