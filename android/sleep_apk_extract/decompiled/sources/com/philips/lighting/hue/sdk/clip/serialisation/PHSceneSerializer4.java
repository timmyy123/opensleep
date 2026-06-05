package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.fbp.PHBridgeVersionManager;
import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.philips.lighting.model.PHAppData;
import com.philips.lighting.model.PHScene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSceneSerializer4 extends PHSceneSerializer3 {
    private static PHSceneSerializer4 sceneSerializer4;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHSceneSerializer4 m855getInstance() {
        try {
            if (sceneSerializer4 == null) {
                sceneSerializer4 = new PHSceneSerializer4();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sceneSerializer4;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canDelete() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public JSONObject createScenePacket(PHScene pHScene, boolean z) {
        JSONObject jSONObjectCreateScenePacket = super.createScenePacket(pHScene, z);
        if (pHScene.getAppData() != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", pHScene.getAppData().getVersion());
            jSONObject.put("data", pHScene.getAppData().getData());
            jSONObjectCreateScenePacket.put("appdata", jSONObject);
        }
        if (!pHScene.isRecycle() && !z) {
            jSONObjectCreateScenePacket.put("recycle", false);
        }
        if (pHScene.getPicture() != null && !pHScene.getPicture().isEmpty()) {
            jSONObjectCreateScenePacket.put("picture", pHScene.getPicture());
        }
        if (pHScene.getLightIdentifiers().isEmpty()) {
            jSONObjectCreateScenePacket.remove("lights");
        }
        return jSONObjectCreateScenePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean isVersion2Scene() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public PHScene parseSceneDetails(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        PHScene pHScene = new PHScene();
        pHScene.setSceneIdentifier(str2);
        pHScene.setName(jSONObject.optString("name"));
        pHScene.setOwner(jSONObject.optString("owner"));
        pHScene.setLocked(jSONObject.optBoolean("locked"));
        pHScene.setRecycle(jSONObject.optBoolean("recycle"));
        pHScene.setVersion(Integer.valueOf(jSONObject.optInt("version")));
        pHScene.setPicture(jSONObject.optString("picture"));
        pHScene.setLastupdated(PHUtilities.stringToDate(jSONObject.optString("lastupdated")));
        if (jSONObject.has("appdata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("appdata");
            PHAppData pHAppData = new PHAppData();
            if (jSONObject2.has("version")) {
                pHAppData.setVersion(Integer.valueOf(jSONObject2.optInt("version")));
            }
            pHAppData.setData(jSONObject2.optString("data"));
            pHScene.setAppData(pHAppData);
        }
        if (jSONObject.has("lightstates")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("lightstates");
            JSONArray jSONArrayNames = jSONObject3.names();
            HashMap map = new HashMap();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String strOptString = jSONArrayNames.optString(i);
                    map.put(strOptString, PHBridgeVersionManager.getInstance().getLightSerializer().parseLightState(jSONObject3.optJSONObject(strOptString)));
                }
                pHScene.setLightStates(map);
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lights");
        if (jSONArrayOptJSONArray == null) {
            return pHScene;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i2));
        }
        pHScene.setLightIdentifiers(arrayList);
        return pHScene;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public List<PHScene> parseScenes(JSONObject jSONObject) {
        List<PHScene> scenes = super.parseScenes(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("scenes");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(jSONArrayNames.optString(i));
                scenes.get(i).setLocked(jSONObjectOptJSONObject2.optBoolean("false"));
                scenes.get(i).setRecycle(jSONObjectOptJSONObject2.optBoolean("recycle"));
                scenes.get(i).setLastupdated(PHUtilities.stringToDate(jSONObjectOptJSONObject2.optString("lastupdated")));
                scenes.get(i).setOwner(jSONObjectOptJSONObject2.optString("owner"));
                scenes.get(i).setVersion(Integer.valueOf(jSONObjectOptJSONObject2.optInt("version")));
                scenes.get(i).setPicture(jSONObjectOptJSONObject2.optString("picture"));
                if (jSONObjectOptJSONObject2.has("appdata")) {
                    JSONObject jSONObject2 = jSONObjectOptJSONObject2.getJSONObject("appdata");
                    PHAppData pHAppData = new PHAppData();
                    if (jSONObject2.has("version")) {
                        pHAppData.setVersion(Integer.valueOf(jSONObject2.optInt("version")));
                    }
                    pHAppData.setData(jSONObject2.optString("data"));
                    scenes.get(i).setAppData(pHAppData);
                }
            }
        }
        return scenes;
    }
}
