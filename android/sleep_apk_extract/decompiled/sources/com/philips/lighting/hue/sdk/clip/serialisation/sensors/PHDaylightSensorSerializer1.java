package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.facebook.internal.ServerProtocol;
import com.philips.lighting.model.sensor.PHDaylightSensor;
import com.philips.lighting.model.sensor.PHDaylightSensorConfiguration;
import com.philips.lighting.model.sensor.PHDaylightSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHDaylightSensorSerializer1 extends PHSensorSerializerBase1 {
    private static JSONObject addSensorConfigurationJSON(JSONObject jSONObject, PHDaylightSensorConfiguration pHDaylightSensorConfiguration) {
        if (pHDaylightSensorConfiguration != null) {
            JSONObject jSONSensorConfigurationBase = PHSensorSerializerBase1.getJSONSensorConfigurationBase(pHDaylightSensorConfiguration);
            jSONSensorConfigurationBase.remove("battery");
            jSONSensorConfigurationBase.remove("url");
            jSONSensorConfigurationBase.putOpt("lat", pHDaylightSensorConfiguration.getLatitude());
            jSONSensorConfigurationBase.putOpt("long", pHDaylightSensorConfiguration.getLongitude());
            jSONSensorConfigurationBase.putOpt("sunriseoffset", pHDaylightSensorConfiguration.getSunriseOffset());
            jSONSensorConfigurationBase.putOpt("sunsetoffset", pHDaylightSensorConfiguration.getSunsetOffset());
            jSONObject.put("config", jSONSensorConfigurationBase);
        }
        return jSONObject;
    }

    private static JSONObject addSensorStateJSON(JSONObject jSONObject, PHDaylightSensorState pHDaylightSensorState) {
        if (pHDaylightSensorState != null) {
            JSONObject jSONSensorStateBase = PHSensorSerializerBase1.getJSONSensorStateBase(pHDaylightSensorState);
            jSONSensorStateBase.putOpt("daylight", pHDaylightSensorState.getDaylight());
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONSensorStateBase);
        }
        return jSONObject;
    }

    private static PHDaylightSensor createConfigurationFromJSON(JSONObject jSONObject, PHDaylightSensor pHDaylightSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            PHDaylightSensorConfiguration pHDaylightSensorConfiguration = (PHDaylightSensorConfiguration) PHSensorSerializerBase1.fillBasicSensorConfiguration(new PHDaylightSensorConfiguration(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("lat")) {
                pHDaylightSensorConfiguration.setLatitude(jSONObjectOptJSONObject.optString("lat"));
            }
            if (jSONObjectOptJSONObject.has("long")) {
                pHDaylightSensorConfiguration.setLongitude(jSONObjectOptJSONObject.optString("long"));
            }
            if (jSONObjectOptJSONObject.has("sunriseoffset")) {
                pHDaylightSensorConfiguration.setSunriseOffset(Integer.valueOf(jSONObjectOptJSONObject.optInt("sunriseoffset")));
            } else {
                pHDaylightSensorConfiguration.setSunriseOffset(null);
            }
            if (jSONObjectOptJSONObject.has("sunsetoffset")) {
                pHDaylightSensorConfiguration.setSunsetOffset(Integer.valueOf(jSONObjectOptJSONObject.optInt("sunsetoffset")));
            } else {
                pHDaylightSensorConfiguration.setSunsetOffset(null);
            }
            pHDaylightSensor.setConfiguration(pHDaylightSensorConfiguration);
        }
        return pHDaylightSensor;
    }

    public static PHDaylightSensor createFromJSON(JSONObject jSONObject, String str) {
        return createStateFromJSON(jSONObject, createConfigurationFromJSON(jSONObject, (PHDaylightSensor) PHSensorSerializerBase1.fillBasicSensor(new PHDaylightSensor("", str), jSONObject)));
    }

    private static PHDaylightSensor createStateFromJSON(JSONObject jSONObject, PHDaylightSensor pHDaylightSensor) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject != null) {
            PHDaylightSensorState pHDaylightSensorState = (PHDaylightSensorState) PHSensorSerializerBase1.fillBasicSensorState(new PHDaylightSensorState(), jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject.has("daylight")) {
                pHDaylightSensorState.setDaylight(Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("daylight")));
            } else {
                pHDaylightSensorState.setDaylight(null);
            }
            pHDaylightSensor.setState(pHDaylightSensorState);
        }
        return pHDaylightSensor;
    }

    public static JSONObject getConfigurationJSON(PHDaylightSensor pHDaylightSensor) {
        return getJSON(pHDaylightSensor).getJSONObject("config");
    }

    public static JSONObject getJSON(PHDaylightSensor pHDaylightSensor) {
        JSONObject jSONSensorBase = PHSensorSerializerBase1.getJSONSensorBase(pHDaylightSensor);
        jSONSensorBase.putOpt("type", pHDaylightSensor.getTypeAsString());
        return addSensorConfigurationJSON(addSensorStateJSON(jSONSensorBase, pHDaylightSensor.getState()), pHDaylightSensor.getConfiguration());
    }

    public static JSONObject getStateJSON(PHDaylightSensor pHDaylightSensor) {
        return getJSON(pHDaylightSensor).getJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
    }
}
