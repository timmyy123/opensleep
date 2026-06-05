package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHLightSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canFetchAll();

    boolean canLightConfigurationCreate();

    boolean canLightConfigurationDelete();

    boolean canLightConfigurationRead();

    boolean canLightConfigurationUpdate();

    boolean canLightStateCreate();

    boolean canLightStateDelete();

    boolean canLightStateRead();

    boolean canLightStateUpdate();

    boolean canRead();

    boolean canUpdate();

    JSONObject createFindLightWithSerialsPacket(List<String> list);

    JSONObject createLightStatePacket(PHLightState pHLightState);

    List<PHBridgeResource> parseGetAllLightHeaders(String str);

    PHLight parseLightDetails(String str, String str2);

    PHLightState parseLightState(JSONObject jSONObject);

    List<PHLight> parseLights(JSONObject jSONObject);

    JSONObject updateLightPacket(PHLight pHLight);

    JSONObject updateLightStatePacket(PHLightState pHLightState);

    boolean validateAPI(PHLight pHLight);

    boolean validateAPI(PHLightState pHLightState);
}
