package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer2 extends PHBridgeConfigurationSerializer1 {
    private static PHBridgeConfigurationSerializer2 bridgeConfigSerialisation2;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer2 m834getInstance() {
        try {
            if (bridgeConfigSerialisation2 == null) {
                bridgeConfigSerialisation2 = new PHBridgeConfigurationSerializer2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation2;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = jSONObject;
            }
            String strOptString = jSONObjectOptJSONObject.optString("timezone");
            String strOptString2 = jSONObjectOptJSONObject.optString("localtime");
            String strOptString3 = jSONObjectOptJSONObject.optString("apiversion");
            if (bridgeConfiguration == null) {
                return bridgeConfiguration;
            }
            bridgeConfiguration.setTimeZone(strOptString);
            bridgeConfiguration.setLocalTime(strOptString2);
            bridgeConfiguration.setAPIVersion(strOptString3);
            return bridgeConfiguration;
        } catch (Exception e) {
            reportParsingError(60, "", "Config unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject("config"));
            return bridgeConfiguration;
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        if (pHBridgeConfiguration.getTimeZone() != null && pHBridgeConfiguration.getTimeZone().length() > 0) {
            jSONObjectUpdateBridgeConfigurationPacket.putOpt("timezone", pHBridgeConfiguration.getTimeZone());
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration) {
        return pHBridgeConfiguration.getZigbeeChannel() == null && !pHBridgeConfiguration.isReboot() && pHBridgeConfiguration.getPortalState() == null;
    }
}
