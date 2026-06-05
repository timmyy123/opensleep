package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHLight;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer7 extends PHLightSerializer6 {
    private static final String TAG = "PHLightSerializer7";
    private static PHLightSerializer7 lightSerialisation7;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer7 m850getInstance() {
        try {
            if (lightSerialisation7 == null) {
                lightSerialisation7 = new PHLightSerializer7();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation7;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer5, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public PHLight parseLightDetails(String str, String str2) {
        PHLight lightDetails = super.parseLightDetails(str, str2);
        try {
            lightDetails.setLuminaireUniqueId(new JSONObject(str).optString("luminaireuniqueid"));
            return lightDetails;
        } catch (JSONException e) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "JSONException: " + e);
            }
            return lightDetails;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer5, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public List<PHLight> parseLights(JSONObject jSONObject) {
        List<PHLight> lights = super.parseLights(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lights");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                lights.get(i).setLuminaireUniqueId(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optString("luminaireuniqueid"));
            }
        }
        return lights;
    }
}
