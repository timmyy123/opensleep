package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer7 extends PHBridgeConfigurationSerializer6 {
    private static PHBridgeConfigurationSerializer7 bridgeConfigSerialisation7;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer7 m838getInstance() {
        try {
            if (bridgeConfigSerialisation7 == null) {
                bridgeConfigSerialisation7 = new PHBridgeConfigurationSerializer7();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation7;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer6, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        if (bridgeConfiguration != null) {
            if (jSONObject.has("config")) {
                jSONObject = jSONObject.getJSONObject("config");
            }
            if (jSONObject.has("modelid")) {
                bridgeConfiguration.setModelId(jSONObject.getString("modelid"));
            }
            if (jSONObject.has("bridgeid")) {
                bridgeConfiguration.setBridgeID(jSONObject.getString("bridgeid"));
            }
        }
        return bridgeConfiguration;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer6, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer5, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        if (pHBridgeConfiguration.getTouchlink() != null) {
            jSONObjectUpdateBridgeConfigurationPacket.putOpt("touchlink", pHBridgeConfiguration.getTouchlink());
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }
}
