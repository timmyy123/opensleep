package com.philips.lighting.hue.sdk.clip.serialisation;

import com.facebook.internal.AnalyticsEvents;
import com.philips.lighting.model.PHBackup;
import com.philips.lighting.model.PHBridgeConfiguration;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer8 extends PHBridgeConfigurationSerializer7 {
    private static PHBridgeConfigurationSerializer8 bridgeConfigSerialisation8;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer8 m839getInstance() {
        try {
            if (bridgeConfigSerialisation8 == null) {
                bridgeConfigSerialisation8 = new PHBridgeConfigurationSerializer8();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation8;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer7, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer6, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        if (bridgeConfiguration != null) {
            if (jSONObject.has("config")) {
                jSONObject = jSONObject.getJSONObject("config");
            }
            if (jSONObject.has("factorynew")) {
                bridgeConfiguration.setFactoryNew(jSONObject.getBoolean("factorynew"));
            }
            if (jSONObject.has("replacesbridgeid")) {
                bridgeConfiguration.setReplacesBridgeId(jSONObject.optString("replacesbridgeid"));
            }
            if (jSONObject.has("backup")) {
                PHBackup backup = bridgeConfiguration.getBackup();
                if (backup == null) {
                    backup = new PHBackup();
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("backup");
                if (jSONObject2.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                    backup.setStatus(PHBackup.getBackupStatus(jSONObject2.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)));
                }
                if (jSONObject2.has("errorcode")) {
                    backup.setErrorCode(Integer.valueOf(jSONObject2.getInt("errorcode")));
                }
                bridgeConfiguration.setBackup(backup);
            }
        }
        return bridgeConfiguration;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer7, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer6, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer5, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        PHBackup backup = pHBridgeConfiguration.getBackup();
        if (backup != null) {
            JSONObject jSONObject = new JSONObject();
            PHBackup.PHBackupStatus status = backup.getStatus();
            if (status != null) {
                jSONObject.putOpt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, status.toString().toLowerCase());
            }
            jSONObjectUpdateBridgeConfigurationPacket.putOpt("backup", jSONObject);
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }
}
