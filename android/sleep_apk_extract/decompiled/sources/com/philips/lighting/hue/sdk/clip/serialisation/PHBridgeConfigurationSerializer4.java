package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer4 extends PHBridgeConfigurationSerializer3 {
    private static PHBridgeConfigurationSerializer4 bridgeConfigSerialisation4;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer4 m835getInstance() {
        try {
            if (bridgeConfigSerialisation4 == null) {
                bridgeConfigSerialisation4 = new PHBridgeConfigurationSerializer4();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation4;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        if (bridgeConfiguration != null) {
            if (jSONObject.has("config")) {
                jSONObject = jSONObject.getJSONObject("config");
            }
            if (jSONObject.has("zigbeechannel")) {
                bridgeConfiguration.setZigbeeChannel(Integer.valueOf(jSONObject.getInt("zigbeechannel")));
            }
        }
        return bridgeConfiguration;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration) {
        return pHBridgeConfiguration.getCheckForUpdate() == null;
    }
}
