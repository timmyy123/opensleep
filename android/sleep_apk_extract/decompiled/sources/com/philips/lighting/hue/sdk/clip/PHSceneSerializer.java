package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHScene;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHSceneSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canFetchAll();

    boolean canRead();

    boolean canUpdate();

    JSONObject createActivateScenePacket(String str);

    JSONObject createScenePacket(PHScene pHScene, boolean z);

    boolean isVersion2Scene();

    PHScene parseSceneDetails(String str, String str2);

    List<PHScene> parseScenes(JSONObject jSONObject);

    boolean validateAPI(PHScene pHScene);
}
