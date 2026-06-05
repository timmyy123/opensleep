package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.PHSceneSerializer;
import com.philips.lighting.hue.sdk.exception.PHHueException;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import com.philips.lighting.model.PHScene;
import java.util.ArrayList;
import java.util.List;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSceneSerializer1 extends PHCLIPParserBase implements PHSceneSerializer {
    private static PHSceneSerializer1 scenesSerialisation1;

    private PHScene.PHSceneActiveState chooseSceneActiveState(Boolean bool) {
        return bool == null ? PHScene.PHSceneActiveState.SCENE_STATE_UNKNOWN : bool.booleanValue() ? PHScene.PHSceneActiveState.SCENE_STATE_ACTIVE : PHScene.PHSceneActiveState.SCENE_STATE_INACTIVE;
    }

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHSceneSerializer1 m852getInstance() {
        try {
            if (scenesSerialisation1 == null) {
                scenesSerialisation1 = new PHSceneSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return scenesSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canCreate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canFetchAll() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canUpdate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public JSONObject createActivateScenePacket(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("scene", str);
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public JSONObject createScenePacket(PHScene pHScene, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < pHScene.getLightIdentifiers().size(); i++) {
            jSONArray.put(i, pHScene.getLightIdentifiers().get(i));
        }
        jSONObject.putOpt("name", pHScene.getName());
        jSONObject.putOpt("lights", jSONArray);
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean isVersion2Scene() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public PHScene parseSceneDetails(String str, String str2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:15:0x0029, B:17:0x0030, B:22:0x003b, B:23:0x0042, B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0057, B:34:0x0067, B:36:0x006f, B:37:0x0075, B:39:0x007b, B:40:0x0094, B:33:0x005f, B:41:0x009e, B:42:0x00a5), top: B:52:0x0029, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1 A[SYNTHETIC] */
    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<PHScene> parseScenes(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("scenes");
        if (jSONObjectOptJSONObject2 != null) {
            jSONObject = jSONObjectOptJSONObject2;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String strOptString = jSONArrayNames.optString(i);
                    if (strOptString != null) {
                        try {
                            if (strOptString.length() < 1 || strOptString.length() > 16) {
                                throw new PHHueException(PHHueResourcesConstants.TXT_INVALID_SCENE_IDENTIFIER);
                            }
                            jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                            if (jSONObjectOptJSONObject == null) {
                                continue;
                            } else {
                                String strOptString2 = jSONObjectOptJSONObject.optString("name");
                                if (strOptString2 == null || strOptString2.length() == 0) {
                                    throw new PHHueException(PHHueResourcesConstants.TXT_RESOURCE_NAME_MISSING);
                                }
                                Boolean boolValueOf = jSONObjectOptJSONObject.isNull("active") ? null : Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("active"));
                                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("lights");
                                if (jSONArrayOptJSONArray != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                        arrayList2.add(jSONArrayOptJSONArray.optString(i2));
                                    }
                                    PHScene pHScene = new PHScene();
                                    pHScene.setSceneIdentifier(strOptString);
                                    pHScene.setName(strOptString2);
                                    pHScene.setActiveState(chooseSceneActiveState(boolValueOf));
                                    pHScene.setLightIdentifiers(arrayList2);
                                    arrayList.add(pHScene);
                                }
                            }
                        } catch (Exception e) {
                            reportParsingError(63, strOptString, "Scene unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(strOptString));
                        }
                    } else {
                        jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                        if (jSONObjectOptJSONObject == null) {
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e2) {
            if (PHLog.isLoggable()) {
                PHLog.e("PCCLIPParser1_1", "Excpetion: " + e2);
                e2.printStackTrace();
            }
            return null;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean validateAPI(PHScene pHScene) {
        return PHSceneSerializer2.m853getInstance().validateAPI(pHScene) && pHScene.getTransitionTime() == 0;
    }
}
