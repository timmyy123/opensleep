package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHGroup;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHGroupSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canRead();

    boolean canUpdate();

    JSONObject createGroupPacket(PHGroup pHGroup);

    JSONObject createGroupPacket(String str, List<String> list);

    List<PHGroup> parseGroups(JSONObject jSONObject);

    JSONObject updateGroupPacket(PHGroup pHGroup);

    boolean validateAPI(PHGroup pHGroup);
}
