package com.philips.lighting.hue.sdk.clip.serialisation.sensors;

import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.philips.lighting.model.sensor.PHSensor;
import com.philips.lighting.model.sensor.PHSensorConfiguration;
import com.philips.lighting.model.sensor.PHSensorState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSensorSerializerBase1 {
    public static PHSensor fillBasicSensor(PHSensor pHSensor, JSONObject jSONObject) {
        pHSensor.setName(jSONObject.optString("name"));
        pHSensor.setModelId(jSONObject.optString("modelid"));
        pHSensor.setManufacturerName(jSONObject.optString("manufacturername"));
        pHSensor.setSwVersion(jSONObject.optString("swversion"));
        pHSensor.setUniqueId(jSONObject.optString("uniqueid"));
        return pHSensor;
    }

    public static PHSensorConfiguration fillBasicSensorConfiguration(PHSensorConfiguration pHSensorConfiguration, JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            pHSensorConfiguration.setUrl(jSONObject.optString("url"));
        } else {
            pHSensorConfiguration.setUrl(null);
        }
        if (jSONObject.has("battery")) {
            pHSensorConfiguration.setBattery(Integer.valueOf(jSONObject.optInt("battery")));
        } else {
            pHSensorConfiguration.setBattery(null);
        }
        if (jSONObject.has("reachable")) {
            pHSensorConfiguration.setReachable(Boolean.valueOf(jSONObject.optBoolean("reachable")));
        } else {
            pHSensorConfiguration.setReachable(null);
        }
        if (jSONObject.has("on")) {
            pHSensorConfiguration.setOn(Boolean.valueOf(jSONObject.optBoolean("on")));
        } else {
            pHSensorConfiguration.setOn(null);
        }
        if (jSONObject.has("usertest")) {
            pHSensorConfiguration.setUserTest(Boolean.valueOf(jSONObject.optBoolean("usertest")));
        } else {
            pHSensorConfiguration.setUserTest(null);
        }
        if (jSONObject.has("alert")) {
            pHSensorConfiguration.setAlertMode(PHSensorConfiguration.PHSensorAlertMode.fromValue(jSONObject.optString("alert")));
            return pHSensorConfiguration;
        }
        pHSensorConfiguration.setAlertMode(null);
        return pHSensorConfiguration;
    }

    public static PHSensorState fillBasicSensorState(PHSensorState pHSensorState, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("lastupdated");
        if (strOptString == null || strOptString.length() == 0) {
            pHSensorState.setLastUpdated(null);
            return pHSensorState;
        }
        pHSensorState.setLastUpdated(PHUtilities.stringToDate(strOptString, "UTC"));
        return pHSensorState;
    }

    public static JSONObject getJSONSensorBase(PHSensor pHSensor) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("name", pHSensor.getName());
        jSONObject.putOpt("manufacturername", pHSensor.getManufacturerName());
        jSONObject.putOpt("modelid", pHSensor.getModelId());
        jSONObject.putOpt("swversion", pHSensor.getSwVersion());
        jSONObject.putOpt("uniqueid", pHSensor.getUniqueId());
        return jSONObject;
    }

    public static JSONObject getJSONSensorConfigurationBase(PHSensorConfiguration pHSensorConfiguration) {
        if (pHSensorConfiguration == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("url", pHSensorConfiguration.getUrl());
        jSONObject.putOpt("battery", pHSensorConfiguration.getBattery());
        jSONObject.putOpt("on", pHSensorConfiguration.getOn());
        jSONObject.putOpt("usertest", pHSensorConfiguration.getUserTest());
        if (pHSensorConfiguration.getAlertMode() != null) {
            jSONObject.putOpt("alert", pHSensorConfiguration.getAlertMode().getValue());
        }
        return jSONObject;
    }

    public static JSONObject getJSONSensorStateBase(PHSensorState pHSensorState) {
        if (pHSensorState != null) {
            return new JSONObject();
        }
        return null;
    }
}
