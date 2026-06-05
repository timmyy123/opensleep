package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer5 extends PHBridgeConfigurationSerializer4 {
    private static PHBridgeConfigurationSerializer5 bridgeConfigSerialisation5;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer5 m836getInstance() {
        try {
            if (bridgeConfigSerialisation5 == null) {
                bridgeConfigSerialisation5 = new PHBridgeConfigurationSerializer5();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation5;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        if (pHBridgeConfiguration.getZigbeeChannel() != null) {
            jSONObjectUpdateBridgeConfigurationPacket.put("zigbeechannel", pHBridgeConfiguration.getZigbeeChannel());
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }
}
