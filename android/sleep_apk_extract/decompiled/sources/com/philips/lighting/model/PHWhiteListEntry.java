package com.philips.lighting.model;

/* JADX INFO: loaded from: classes4.dex */
public class PHWhiteListEntry {
    public static final String DEVICETYPE_DELIMETER = "#";
    private String appName;
    private String deviceName;
    private String userName;

    public PHWhiteListEntry(String str, String str2, String str3) {
        this.userName = str;
        this.deviceName = str2;
        this.appName = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHWhiteListEntry pHWhiteListEntry = (PHWhiteListEntry) obj;
        String str = this.appName;
        String str2 = pHWhiteListEntry.appName;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.deviceName;
        String str4 = pHWhiteListEntry.deviceName;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        String str5 = this.userName;
        String str6 = pHWhiteListEntry.userName;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        return true;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.deviceName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
