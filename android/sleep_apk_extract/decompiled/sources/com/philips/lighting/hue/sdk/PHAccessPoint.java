package com.philips.lighting.hue.sdk;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHAccessPoint {
    private String bridgeId;
    private String ipAddress;
    private String macAddress;
    private String username;

    public PHAccessPoint(PHAccessPoint pHAccessPoint) {
        if (pHAccessPoint == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            throw null;
        }
        this.ipAddress = pHAccessPoint.ipAddress;
        this.macAddress = pHAccessPoint.macAddress;
        this.username = pHAccessPoint.username;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PHAccessPoint)) {
            return false;
        }
        PHAccessPoint pHAccessPoint = (PHAccessPoint) obj;
        String str = this.ipAddress;
        String str2 = pHAccessPoint.ipAddress;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.macAddress;
        String str4 = pHAccessPoint.macAddress;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        String str5 = this.username;
        String str6 = pHAccessPoint.username;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        return true;
    }

    public String getBridgeId() {
        String str = this.bridgeId;
        if (str != null) {
            return str;
        }
        String str2 = this.macAddress;
        if (str2 == null) {
            return null;
        }
        String strReplace = str2.replace(":", "");
        if (strReplace.length() != 12) {
            return this.macAddress;
        }
        return (strReplace.substring(0, 6) + "FFFE" + strReplace.substring(6)).toUpperCase();
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getMacAddress() {
        String str = this.macAddress;
        if (str != null) {
            return str.toUpperCase();
        }
        return null;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.ipAddress;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.macAddress;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.username;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setBridgeId(String str) {
        if (str != null) {
            this.bridgeId = str.toUpperCase();
        } else {
            this.bridgeId = str;
        }
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public PHAccessPoint(String str, String str2, String str3) {
        this.ipAddress = str;
        this.username = str2;
        this.macAddress = str3;
    }

    public PHAccessPoint() {
    }
}
