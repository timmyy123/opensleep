package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.clip.PHGroupSerializer;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHGroupSerializer1 extends PHCLIPParserBase implements PHGroupSerializer {
    private static final String TAG = "PHGroupSerializer1";
    private static PHGroupSerializer1 groupSerialisation1;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHGroupSerializer1 m840getInstance() {
        try {
            if (groupSerialisation1 == null) {
                groupSerialisation1 = new PHGroupSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return groupSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public boolean canDelete() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public JSONObject createGroupPacket(PHGroup pHGroup) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < pHGroup.getLightIdentifiers().size(); i++) {
            jSONArray.put(i, pHGroup.getLightIdentifiers().get(i));
        }
        jSONObject.putOpt("name", pHGroup.getName());
        jSONObject.putOpt("lights", jSONArray);
        return jSONObject;
    }

    public List<PHBridgeResource> parseGetAllGroup(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String strOptString = jSONArrayNames.optString(i);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new PHBridgeResource(jSONObjectOptJSONObject.optString("name"), strOptString));
                    }
                }
            }
            return arrayList;
        } catch (JSONException e) {
            if (!PHLog.isLoggable()) {
                return null;
            }
            PHLog.e(TAG, "JSONException: " + e);
            return null;
        }
    }

    public PHGroup parseGetGroupDetails(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("name");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lights");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
            PHGroup pHGroup = new PHGroup(strOptString, str2);
            pHGroup.setLightIdentifiers(arrayList);
            return pHGroup;
        } catch (JSONException e) {
            if (!PHLog.isLoggable()) {
                return null;
            }
            PHLog.e(TAG, "JSONException: " + e);
            return null;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public List<PHGroup> parseGroups(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("groups");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String strOptString = jSONArrayNames.optString(i);
                try {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject2 != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("lights");
                        PHGroup pHGroup = new PHGroup(jSONObjectOptJSONObject2.optString("name"), strOptString);
                        if (jSONArrayOptJSONArray != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i2));
                            }
                            pHGroup.setLightIdentifiers(arrayList2);
                        }
                        arrayList.add(pHGroup);
                    }
                } catch (Exception e) {
                    reportParsingError(62, strOptString, "Group unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                }
            }
        }
        return arrayList;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public JSONObject updateGroupPacket(PHGroup pHGroup) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", pHGroup.getName());
        if (pHGroup.getLightIdentifiers() == null) {
            return jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < pHGroup.getLightIdentifiers().size(); i++) {
            jSONArray.put(i, pHGroup.getLightIdentifiers().get(i));
        }
        jSONObject.putOpt("lights", jSONArray);
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public boolean validateAPI(PHGroup pHGroup) {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHGroupSerializer
    public JSONObject createGroupPacket(String str, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(i, list.get(i));
        }
        jSONObject.putOpt("name", str);
        jSONObject.putOpt("lights", jSONArray);
        return jSONObject;
    }
}
