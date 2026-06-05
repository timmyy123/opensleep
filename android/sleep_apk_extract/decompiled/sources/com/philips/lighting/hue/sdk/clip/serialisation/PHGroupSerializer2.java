package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHGroup;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGroupSerializer2 extends PHGroupSerializer1 {
    private static PHGroupSerializer2 groupSerializer2;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHGroupSerializer2 m841getInstance() {
        try {
            if (groupSerializer2 == null) {
                groupSerializer2 = new PHGroupSerializer2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return groupSerializer2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer1, com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public JSONObject createGroupPacket(PHGroup pHGroup) {
        JSONObject jSONObjectCreateGroupPacket = super.createGroupPacket(pHGroup);
        jSONObjectCreateGroupPacket.putOpt("type", pHGroup.getType());
        return jSONObjectCreateGroupPacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer1, com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public List<PHGroup> parseGroups(JSONObject jSONObject) {
        List<PHGroup> groups = super.parseGroups(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("groups");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(jSONArrayNames.optString(i));
                String strOptString = jSONObjectOptJSONObject2.optString("modelid");
                String strOptString2 = jSONObjectOptJSONObject2.optString("type");
                groups.get(i).setModelId(strOptString);
                groups.get(i).setType(strOptString2);
            }
        }
        return groups;
    }
}
