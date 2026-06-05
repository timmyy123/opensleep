package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer5 extends PHLightSerializer4 {
    private static final String TAG = "PHLightSerializer5";
    private static PHLightSerializer5 lightSerialisation5;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer5 m848getInstance() {
        try {
            if (lightSerialisation5 == null) {
                lightSerialisation5 = new PHLightSerializer5();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation5;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject createLightStatePacket(PHLightState pHLightState) {
        JSONObject jSONObjectCreateLightStatePacket = super.createLightStatePacket(pHLightState);
        if (pHLightState.getIncrementBri() != null) {
            jSONObjectCreateLightStatePacket.putOpt("bri_inc", pHLightState.getIncrementBri());
        }
        if (pHLightState.getIncrementCt() != null) {
            jSONObjectCreateLightStatePacket.putOpt("ct_inc", pHLightState.getIncrementCt());
        }
        if (pHLightState.getIncrementHue() != null) {
            jSONObjectCreateLightStatePacket.putOpt("hue_inc", pHLightState.getIncrementHue());
        }
        if (pHLightState.getIncrementSat() != null) {
            jSONObjectCreateLightStatePacket.putOpt("sat_inc", pHLightState.getIncrementSat());
        }
        if (pHLightState.getIncrementX() != null && pHLightState.getIncrementY() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(pHLightState.getIncrementX());
            jSONArray.put(pHLightState.getIncrementY());
            jSONObjectCreateLightStatePacket.putOpt("xy_inc", jSONArray);
        }
        return jSONObjectCreateLightStatePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public PHLight parseLightDetails(String str, String str2) {
        PHLight lightDetails = super.parseLightDetails(str, str2);
        try {
            lightDetails.setManufacturerName(new JSONObject(str).optString("manufacturername"));
            return lightDetails;
        } catch (JSONException e) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "JSONException: " + e);
            }
            return lightDetails;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public List<PHLight> parseLights(JSONObject jSONObject) {
        List<PHLight> lights = super.parseLights(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lights");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                lights.get(i).setManufacturerName(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optString("manufacturername"));
            }
        }
        return lights;
    }
}
