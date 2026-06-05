package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHSoftwareUpdateDeviceTypes;
import com.philips.lighting.model.PHSoftwareUpdateStatus;
import org.json.hue.JSONArray;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer6 extends PHBridgeConfigurationSerializer5 {
    private static PHBridgeConfigurationSerializer6 bridgeConfigSerialisation6;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHBridgeConfigurationSerializer6 m837getInstance() {
        try {
            if (bridgeConfigSerialisation6 == null) {
                bridgeConfigSerialisation6 = new PHBridgeConfigurationSerializer6();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation6;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        PHBridgeConfiguration bridgeConfiguration = super.parseBridgeConfiguration(jSONObject);
        if (bridgeConfiguration != null) {
            if (jSONObject.has("config")) {
                jSONObject = jSONObject.getJSONObject("config");
            }
            if (jSONObject.has("checkforupdate")) {
                bridgeConfiguration.setCheckForUpdate(Boolean.valueOf(jSONObject.getBoolean("checkforupdate")));
            }
            if (jSONObject.has("swupdate")) {
                PHSoftwareUpdateStatus softwareStatus = bridgeConfiguration.getSoftwareStatus();
                if (softwareStatus == null) {
                    softwareStatus = new PHSoftwareUpdateStatus();
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("swupdate");
                if (jSONObject2.has("devicetypes")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("devicetypes");
                    PHSoftwareUpdateDeviceTypes pHSoftwareUpdateDeviceTypes = new PHSoftwareUpdateDeviceTypes();
                    if (jSONObject3.has("lights")) {
                        JSONArray jSONArray = jSONObject3.getJSONArray("lights");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (string != null) {
                                pHSoftwareUpdateDeviceTypes.addMainsLight(string);
                            }
                        }
                    }
                    if (jSONObject3.has("batterylights")) {
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("batterylights");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            String string2 = jSONArray2.getString(i2);
                            if (string2 != null) {
                                pHSoftwareUpdateDeviceTypes.addBatteryLight(string2);
                            }
                        }
                    }
                    if (jSONObject3.has("mainssensors")) {
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("mainssensors");
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            String string3 = jSONArray3.getString(i3);
                            if (string3 != null) {
                                pHSoftwareUpdateDeviceTypes.addMainsSensor(string3);
                            }
                        }
                    }
                    if (jSONObject3.has("batterysensors")) {
                        JSONArray jSONArray4 = jSONObject3.getJSONArray("batterysensors");
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            String string4 = jSONArray4.getString(i4);
                            if (string4 != null) {
                                pHSoftwareUpdateDeviceTypes.addBatterySensor(string4);
                            }
                        }
                    }
                    if (jSONObject3.has("slowsensors")) {
                        JSONArray jSONArray5 = jSONObject3.getJSONArray("slowsensors");
                        for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                            String string5 = jSONArray5.getString(i5);
                            if (string5 != null) {
                                pHSoftwareUpdateDeviceTypes.addSlowSensor(string5);
                            }
                        }
                    }
                    softwareStatus.setDeviceTypes(pHSoftwareUpdateDeviceTypes);
                }
                bridgeConfiguration.setSoftwareStatus(softwareStatus);
            }
        }
        return bridgeConfiguration;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer5, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObjectUpdateBridgeConfigurationPacket = super.updateBridgeConfigurationPacket(pHBridgeConfiguration);
        if (pHBridgeConfiguration.getCheckForUpdate() != null) {
            jSONObjectUpdateBridgeConfigurationPacket.put("checkforupdate", pHBridgeConfiguration.getCheckForUpdate().booleanValue());
        }
        return jSONObjectUpdateBridgeConfigurationPacket;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer4, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer3, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer2, com.philips.lighting.hue.sdk.clip.serialisation.PHBridgeConfigurationSerializer1, com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration) {
        return true;
    }
}
