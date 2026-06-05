package com.philips.lighting.hue.sdk.clip.serialisation;

import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer2 extends PHLightSerializer1 {
    private static PHLightSerializer2 lightSerialisation2;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer2 m845getInstance() {
        try {
            if (lightSerialisation2 == null) {
                lightSerialisation2 = new PHLightSerializer2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canLightStateCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public JSONObject createFindLightWithSerialsPacket(List<String> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(i, list.get(i));
        }
        jSONObject.putOpt("deviceid", jSONArray);
        return jSONObject;
    }
}
