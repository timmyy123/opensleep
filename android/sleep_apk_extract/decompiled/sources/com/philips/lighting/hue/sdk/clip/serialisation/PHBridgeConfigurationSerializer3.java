package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHPortalState;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer3 extends PHBridgeConfigurationSerializer2 {
    private static PHBridgeConfigurationSerializer3 bridgeConfigSerialisation3;

    public static synchronized PHBridgeConfigurationSerializer2 getInstance() {
        try {
            if (bridgeConfigSerialisation3 == null) {
                bridgeConfigSerialisation3 = new PHBridgeConfigurationSerializer3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation3;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        if (bridgeConfiguration != null) {
            if (jSONObject.has("config")) {
                jSONObject = jSONObject.getJSONObject("config");
            }
            if (jSONObject.has("portalstate")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("portalstate");
                bridgeConfiguration.setPortalState(new PHPortalState(jSONObject2.has("signedon") ? Boolean.valueOf(jSONObject2.getBoolean("signedon")) : null, jSONObject2.has("incoming") ? Boolean.valueOf(jSONObject2.getBoolean("incoming")) : null, jSONObject2.has("outgoing") ? Boolean.valueOf(jSONObject2.getBoolean("outgoing")) : null, jSONObject2.has("communication") ? PHPortalState.PHPortalCommunicationState.getCommunicationState(jSONObject2.getString("communication")) : null));
            }
        }
        return bridgeConfiguration;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        if (pHBridgeConfiguration.isReboot()) {
            jSONObjectUpdateBridgeConfigurationPacket.put("reboot", true);
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration) {
        return pHBridgeConfiguration.getZigbeeChannel() == null;
    }
}
