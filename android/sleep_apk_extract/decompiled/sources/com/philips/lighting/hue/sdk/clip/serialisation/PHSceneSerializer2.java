package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHScene;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHSceneSerializer2 extends PHSceneSerializer1 {
    private static PHSceneSerializer2 scenesSerialisation2;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHSceneSerializer2 m853getInstance() {
        try {
            if (scenesSerialisation2 == null) {
                scenesSerialisation2 = new PHSceneSerializer2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return scenesSerialisation2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public JSONObject createScenePacket(PHScene pHScene, boolean z) {
        JSONObject jSONObjectCreateScenePacket = super.createScenePacket(pHScene, z);
        if (pHScene.getTransitionTime() != 0) {
            jSONObjectCreateScenePacket.put("transitiontime", pHScene.getTransitionTime());
        }
        return jSONObjectCreateScenePacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean validateAPI(PHScene pHScene) {
        return true;
    }
}
