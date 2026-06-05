package com.philips.lighting.hue.sdk.clip.serialisation;

import com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer;
import com.philips.lighting.model.PHBridgeConfiguration;
import com.philips.lighting.model.PHSoftwareUpdateStatus;
import com.philips.lighting.model.PHWhiteListEntry;
import java.util.ArrayList;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfigurationSerializer1 extends PHCLIPParserBase implements PHBridgeConfigurationSerializer {
    private static PHBridgeConfigurationSerializer1 bridgeConfigSerialisation1;

    public static synchronized PHBridgeConfigurationSerializer1 getInstance() {
        try {
            if (bridgeConfigSerialisation1 == null) {
                bridgeConfigSerialisation1 = new PHBridgeConfigurationSerializer1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bridgeConfigSerialisation1;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean canCreate() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean canDelete() {
        return false;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean canRead() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean canUpdate() {
        return true;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public String parseBridgeAPIVersion(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        String strOptString = jSONObject.optString("apiversion");
        if (strOptString.isEmpty()) {
            return null;
        }
        return strOptString;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public PHBridgeConfiguration parseBridgeConfiguration(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        PHBridgeConfiguration pHBridgeConfiguration = new PHBridgeConfiguration();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = jSONObject;
            }
            String strOptString = jSONObjectOptJSONObject.optString("ipaddress");
            String strOptString2 = jSONObjectOptJSONObject.optString("mac");
            String strOptString3 = jSONObjectOptJSONObject.optString("name");
            String strOptString4 = jSONObjectOptJSONObject.optString("proxyaddress");
            String strOptString5 = jSONObjectOptJSONObject.optString("netmask");
            String strOptString6 = jSONObjectOptJSONObject.optString("gateway");
            int iOptInt = jSONObjectOptJSONObject.optInt("proxyport");
            Boolean boolValueOf = jSONObjectOptJSONObject.isNull("dhcp") ? null : Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("dhcp"));
            String strOptString7 = jSONObjectOptJSONObject.optString("swversion");
            Boolean boolValueOf2 = jSONObjectOptJSONObject.isNull("portalservices") ? null : Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("portalservices"));
            String strOptString8 = jSONObjectOptJSONObject.optString("UTC");
            PHSoftwareUpdateStatus pHSoftwareUpdateStatus = new PHSoftwareUpdateStatus();
            str = "config";
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("swupdate");
                String str5 = "name";
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt2 = jSONObjectOptJSONObject2.optInt("updatestate");
                    str2 = strOptString2;
                    boolean zOptBoolean = jSONObjectOptJSONObject2.optBoolean("notify");
                    pHSoftwareUpdateStatus.setState(iOptInt2);
                    pHSoftwareUpdateStatus.setNotify(zOptBoolean);
                    pHSoftwareUpdateStatus.setReleaseNotesUrl(jSONObjectOptJSONObject2.optString("url"));
                    pHSoftwareUpdateStatus.setUpdateText(jSONObjectOptJSONObject2.optString("text"));
                } else {
                    str2 = strOptString2;
                    pHSoftwareUpdateStatus.setNotify(false);
                }
                JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject("whitelist");
                String[] names = JSONObject.getNames(jSONObject2);
                ArrayList<PHWhiteListEntry> arrayList = new ArrayList<>();
                int length = names.length;
                int i = 0;
                while (i < length) {
                    Boolean bool = boolValueOf2;
                    String str6 = names[i];
                    PHSoftwareUpdateStatus pHSoftwareUpdateStatus2 = pHSoftwareUpdateStatus;
                    Boolean bool2 = boolValueOf;
                    String str7 = str5;
                    str5 = str7;
                    String[] strArrSplit = ((String) jSONObject2.getJSONObject(str6).opt(str7)).split("#");
                    String str8 = strArrSplit[0];
                    if (strArrSplit.length >= 2) {
                        str3 = strArrSplit[1];
                        str4 = str8;
                    } else {
                        str3 = str8;
                        str4 = null;
                    }
                    JSONObject jSONObject3 = jSONObject2;
                    arrayList.add(new PHWhiteListEntry(str6, str3, str4));
                    i++;
                    boolValueOf2 = bool;
                    pHSoftwareUpdateStatus = pHSoftwareUpdateStatus2;
                    boolValueOf = bool2;
                    jSONObject2 = jSONObject3;
                }
                pHBridgeConfiguration.setIpAddress(strOptString);
                pHBridgeConfiguration.setName(strOptString3);
                pHBridgeConfiguration.setProxy(strOptString4);
                pHBridgeConfiguration.setProxyPort(iOptInt);
                pHBridgeConfiguration.setNetmask(strOptString5);
                pHBridgeConfiguration.setGateway(strOptString6);
                pHBridgeConfiguration.setDhcpEnabled(boolValueOf);
                pHBridgeConfiguration.setSoftwareVersion(strOptString7);
                pHBridgeConfiguration.setPortalServicesEnabled(boolValueOf2);
                pHBridgeConfiguration.setSoftwareStatus(pHSoftwareUpdateStatus);
                pHBridgeConfiguration.setTime(strOptString8);
                pHBridgeConfiguration.setMacAddress(str2);
                pHBridgeConfiguration.setWhiteListEntries(arrayList);
                pHBridgeConfiguration.setModelId("BSB001");
                return pHBridgeConfiguration;
            } catch (Exception e) {
                e = e;
                reportParsingError(60, "", "Config unparsable due to error: " + e.getMessage(), jSONObject.optJSONObject(str));
                return pHBridgeConfiguration;
            }
        } catch (Exception e2) {
            e = e2;
            str = "config";
        }
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public String parseBridgeSoftwareVersion(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        String strOptString = jSONObject.optString("swversion");
        if (strOptString.isEmpty()) {
            return null;
        }
        return strOptString;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public JSONObject updateBridgeConfigurationPacket(PHBridgeConfiguration pHBridgeConfiguration) {
        JSONObject jSONObject = new JSONObject();
        if (pHBridgeConfiguration.getName() != null) {
            jSONObject.putOpt("name", pHBridgeConfiguration.getName());
        }
        if (pHBridgeConfiguration.getTime() != null) {
            jSONObject.putOpt("UTC", pHBridgeConfiguration.getTime());
        }
        if (pHBridgeConfiguration.getProxy() != null) {
            jSONObject.putOpt("proxyaddress", pHBridgeConfiguration.getProxy());
        }
        if (pHBridgeConfiguration.getProxyPort() != -55) {
            jSONObject.putOpt("proxyport", Integer.valueOf(pHBridgeConfiguration.getProxyPort()));
        }
        if (pHBridgeConfiguration.getDhcpEnabled() != null) {
            jSONObject.putOpt("dhcp", pHBridgeConfiguration.getDhcpEnabled());
        }
        if (pHBridgeConfiguration.getIpAddress() != null) {
            jSONObject.putOpt("ipaddress", pHBridgeConfiguration.getIpAddress());
        }
        if (pHBridgeConfiguration.getNetmask() != null) {
            jSONObject.putOpt("netmask", pHBridgeConfiguration.getNetmask());
        }
        if (pHBridgeConfiguration.getGateway() != null) {
            jSONObject.putOpt("gateway", pHBridgeConfiguration.getGateway());
        }
        if (pHBridgeConfiguration.getPortalServicesEnabled() != null) {
            jSONObject.putOpt("portalservices", pHBridgeConfiguration.getPortalServicesEnabled());
        }
        PHSoftwareUpdateStatus softwareStatus = pHBridgeConfiguration.getSoftwareStatus();
        if (softwareStatus != null) {
            JSONObject jSONObject2 = new JSONObject();
            PHSoftwareUpdateStatus.PHStateType state = softwareStatus.getState();
            if (state != null) {
                if (state == PHSoftwareUpdateStatus.PHStateType.NO_UPDATE) {
                    jSONObject2.putOpt("notify", Boolean.FALSE);
                } else {
                    jSONObject2.putOpt("updatestate", Integer.valueOf(state.ordinal()));
                }
            }
            jSONObject.putOpt("swupdate", jSONObject2);
        }
        return jSONObject;
    }

    @Override // com.philips.lighting.hue.sdk.clip.PHBridgeConfigurationSerializer
    public boolean validateAPI(PHBridgeConfiguration pHBridgeConfiguration) {
        return PHBridgeConfigurationSerializer2.m834getInstance().validateAPI(pHBridgeConfiguration) && pHBridgeConfiguration.getLocalTime() == null && pHBridgeConfiguration.getTimeZone() == null;
    }
}
