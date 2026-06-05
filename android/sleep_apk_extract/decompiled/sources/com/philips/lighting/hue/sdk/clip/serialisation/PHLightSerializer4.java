package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer4 extends PHLightSerializer3 {
    private static final String TAG = "PHLightSerializer4";
    private static PHLightSerializer4 lightSerialisation4;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer4 m847getInstance() {
        try {
            if (lightSerialisation4 == null) {
                lightSerialisation4 = new PHLightSerializer4();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation4;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightConfigurationUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public PHLight parseLightDetails(String str, String str2) {
        PHLight lightDetails = super.parseLightDetails(str, str2);
        try {
            lightDetails.setUniqueId(new JSONObject(str).optString("uniqueid"));
            return lightDetails;
        } catch (JSONException e) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "JSONException: " + e);
            }
            return lightDetails;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public List<PHLight> parseLights(JSONObject jSONObject) {
        List<PHLight> lights = super.parseLights(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lights");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                lights.get(i).setUniqueId(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optString("uniqueid"));
            }
        }
        return lights;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean validateAPI(PHLight pHLight) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean validateAPI(PHLightState pHLightState) {
        return true;
    }
}
