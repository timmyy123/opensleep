package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeConfigurationSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canRead();

    boolean canUpdate();

    String parseBridgeAPIVersion(JSONObject jSONObject);

    PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject);

    String parseBridgeSoftwareVersion(JSONObject jSONObject);

    JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration);

    boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration);
}
