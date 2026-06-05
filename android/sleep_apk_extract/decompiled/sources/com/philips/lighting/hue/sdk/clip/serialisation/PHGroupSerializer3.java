package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHGroup;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGroupSerializer3 extends PHGroupSerializer2 {
    private static PHGroupSerializer3 groupSerializer3;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHGroupSerializer3 m842getInstance() {
        try {
            if (groupSerializer3 == null) {
                groupSerializer3 = new PHGroupSerializer3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return groupSerializer3;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer1, com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public List<PHGroup> parseGroups(JSONObject jSONObject) {
        List<PHGroup> groups = super.parseGroups(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("groups");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                groups.get(i).setUniqueId(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optString("uniqueid"));
            }
        }
        return groups;
    }
}
