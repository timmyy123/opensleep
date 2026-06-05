package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHGroup;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGroupSerializer4 extends PHGroupSerializer3 {
    private static PHGroupSerializer4 groupSerializer4;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHGroupSerializer4 m843getInstance() {
        try {
            if (groupSerializer4 == null) {
                groupSerializer4 = new PHGroupSerializer4();
            }
        } catch (Throwable th) {
            throw th;
        }
        return groupSerializer4;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer1, com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public JSONObject createGroupPacket(PHGroup pHGroup) {
        JSONObject jSONObjectCreateGroupPacket = super.createGroupPacket(pHGroup);
        jSONObjectCreateGroupPacket.putOpt("class", pHGroup.getGroupClass());
        return jSONObjectCreateGroupPacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHGroupSerializer1, com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public List<PHGroup> parseGroups(JSONObject jSONObject) {
        List<PHGroup> groups = super.parseGroups(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("groups");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                groups.get(i).setGroupClass(PHGroup.PHGroupClass.fromString(jSONObject.optJSONObject(jSONArrayNames.optString(i)).optString("class")));
            }
        }
        return groups;
    }
}
