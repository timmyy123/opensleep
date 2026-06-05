package com.philips.lighting.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class PHBridgeConfiguration extends PHBridgeResource {
    public static final int VALUE_NOT_SET = -55;
    private String apiVersion;
    private PHBackup backup;
    private String bridgeID;
    private Boolean checkForUpdate;
    private Boolean dhcpEnabled;
    private boolean factoryNew;
    private String gateway;
    private String ipAddress;
    private String localTime;
    private String macAddress;
    private String modelId;
    private String netmask;
    private Boolean portalServicesEnabled;
    private PHPortalState portalState;
    private String proxy;
    private int proxyPort;
    private boolean reboot;
    private String replacesBridgeId;
    private PHSoftwareUpdateStatus softwareStatus;
    private String softwareVersion;
    private String time;
    private String timeZone;
    private Boolean touchlink;
    private String userName;
    private ArrayList<PHWhiteListEntry> whiteListEntries;
    private Integer zigbeeChannel;

    public PHBridgeConfiguration(PHBridgeConfiguration pHBridgeConfiguration) {
        super(pHBridgeConfiguration.getName(), pHBridgeConfiguration.getIdentifier());
        this.proxyPort = -55;
        this.apiVersion = null;
        this.whiteListEntries = new ArrayList<>();
        this.portalState = null;
        this.reboot = false;
        this.zigbeeChannel = null;
        this.checkForUpdate = null;
        this.bridgeID = pHBridgeConfiguration.bridgeID;
        this.replacesBridgeId = pHBridgeConfiguration.replacesBridgeId;
        this.factoryNew = pHBridgeConfiguration.factoryNew;
        this.dhcpEnabled = pHBridgeConfiguration.dhcpEnabled;
        this.gateway = pHBridgeConfiguration.gateway;
        this.ipAddress = pHBridgeConfiguration.ipAddress;
        this.macAddress = pHBridgeConfiguration.macAddress;
        this.netmask = pHBridgeConfiguration.netmask;
        this.portalServicesEnabled = pHBridgeConfiguration.portalServicesEnabled;
        this.proxy = pHBridgeConfiguration.proxy;
        this.proxyPort = pHBridgeConfiguration.proxyPort;
        this.softwareStatus = pHBridgeConfiguration.softwareStatus;
        this.softwareVersion = pHBridgeConfiguration.softwareVersion;
        this.apiVersion = pHBridgeConfiguration.apiVersion;
        this.time = pHBridgeConfiguration.time;
        this.localTime = pHBridgeConfiguration.localTime;
        this.timeZone = pHBridgeConfiguration.timeZone;
        this.userName = pHBridgeConfiguration.userName;
        this.whiteListEntries = pHBridgeConfiguration.whiteListEntries;
        this.portalState = pHBridgeConfiguration.portalState;
        this.reboot = pHBridgeConfiguration.reboot;
        this.zigbeeChannel = pHBridgeConfiguration.zigbeeChannel;
        this.checkForUpdate = pHBridgeConfiguration.checkForUpdate;
        this.backup = pHBridgeConfiguration.backup;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHBridgeConfiguration pHBridgeConfiguration = (PHBridgeConfiguration) obj;
        String str = this.apiVersion;
        String str2 = pHBridgeConfiguration.apiVersion;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.bridgeID;
        String str4 = pHBridgeConfiguration.bridgeID;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        Boolean bool = this.checkForUpdate;
        Boolean bool2 = pHBridgeConfiguration.checkForUpdate;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        Boolean bool3 = this.dhcpEnabled;
        Boolean bool4 = pHBridgeConfiguration.dhcpEnabled;
        if (bool3 == null) {
            if (bool4 != null) {
                return false;
            }
        } else if (!bool3.equals(bool4)) {
            return false;
        }
        String str5 = this.gateway;
        String str6 = pHBridgeConfiguration.gateway;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        String str7 = this.ipAddress;
        String str8 = pHBridgeConfiguration.ipAddress;
        if (str7 == null) {
            if (str8 != null) {
                return false;
            }
        } else if (!str7.equals(str8)) {
            return false;
        }
        String str9 = this.macAddress;
        String str10 = pHBridgeConfiguration.macAddress;
        if (str9 == null) {
            if (str10 != null) {
                return false;
            }
        } else if (!str9.equals(str10)) {
            return false;
        }
        String str11 = this.modelId;
        String str12 = pHBridgeConfiguration.modelId;
        if (str11 == null) {
            if (str12 != null) {
                return false;
            }
        } else if (!str11.equals(str12)) {
            return false;
        }
        String str13 = this.netmask;
        String str14 = pHBridgeConfiguration.netmask;
        if (str13 == null) {
            if (str14 != null) {
                return false;
            }
        } else if (!str13.equals(str14)) {
            return false;
        }
        Boolean bool5 = this.portalServicesEnabled;
        Boolean bool6 = pHBridgeConfiguration.portalServicesEnabled;
        if (bool5 == null) {
            if (bool6 != null) {
                return false;
            }
        } else if (!bool5.equals(bool6)) {
            return false;
        }
        PHPortalState pHPortalState = this.portalState;
        PHPortalState pHPortalState2 = pHBridgeConfiguration.portalState;
        if (pHPortalState == null) {
            if (pHPortalState2 != null) {
                return false;
            }
        } else if (!pHPortalState.equals(pHPortalState2)) {
            return false;
        }
        String str15 = this.proxy;
        String str16 = pHBridgeConfiguration.proxy;
        if (str15 == null) {
            if (str16 != null) {
                return false;
            }
        } else if (!str15.equals(str16)) {
            return false;
        }
        if (this.proxyPort != pHBridgeConfiguration.proxyPort || this.reboot != pHBridgeConfiguration.reboot) {
            return false;
        }
        PHSoftwareUpdateStatus pHSoftwareUpdateStatus = this.softwareStatus;
        PHSoftwareUpdateStatus pHSoftwareUpdateStatus2 = pHBridgeConfiguration.softwareStatus;
        if (pHSoftwareUpdateStatus == null) {
            if (pHSoftwareUpdateStatus2 != null) {
                return false;
            }
        } else if (!pHSoftwareUpdateStatus.equals(pHSoftwareUpdateStatus2)) {
            return false;
        }
        PHBackup pHBackup = this.backup;
        PHBackup pHBackup2 = pHBridgeConfiguration.backup;
        if (pHBackup == null) {
            if (pHBackup2 != null) {
                return false;
            }
        } else if (!pHBackup.equals(pHBackup2)) {
            return false;
        }
        String str17 = this.softwareVersion;
        String str18 = pHBridgeConfiguration.softwareVersion;
        if (str17 == null) {
            if (str18 != null) {
                return false;
            }
        } else if (!str17.equals(str18)) {
            return false;
        }
        String str19 = this.timeZone;
        String str20 = pHBridgeConfiguration.timeZone;
        if (str19 == null) {
            if (str20 != null) {
                return false;
            }
        } else if (!str19.equals(str20)) {
            return false;
        }
        String str21 = this.userName;
        String str22 = pHBridgeConfiguration.userName;
        if (str21 == null) {
            if (str22 != null) {
                return false;
            }
        } else if (!str21.equals(str22)) {
            return false;
        }
        ArrayList<PHWhiteListEntry> arrayList = this.whiteListEntries;
        ArrayList<PHWhiteListEntry> arrayList2 = pHBridgeConfiguration.whiteListEntries;
        if (arrayList == null) {
            if (arrayList2 != null) {
                return false;
            }
        } else if (!arrayList.equals(arrayList2)) {
            return false;
        }
        Integer num = this.zigbeeChannel;
        Integer num2 = pHBridgeConfiguration.zigbeeChannel;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public String getAPIVersion() {
        return this.apiVersion;
    }

    public PHBackup getBackup() {
        return this.backup;
    }

    public String getBridgeID() {
        String str = this.bridgeID;
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

    public Boolean getCheckForUpdate() {
        return this.checkForUpdate;
    }

    public Boolean getDhcpEnabled() {
        return this.dhcpEnabled;
    }

    public boolean getFactoryNew() {
        return this.factoryNew;
    }

    public String getGateway() {
        return this.gateway;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getLocalTime() {
        return this.localTime;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getNetmask() {
        return this.netmask;
    }

    public Boolean getPortalServicesEnabled() {
        return this.portalServicesEnabled;
    }

    public PHPortalState getPortalState() {
        return this.portalState;
    }

    public String getProxy() {
        return this.proxy;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public String getReplacesBridgeId() {
        return this.replacesBridgeId;
    }

    public PHSoftwareUpdateStatus getSoftwareStatus() {
        return this.softwareStatus;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public Boolean getTouchlink() {
        return this.touchlink;
    }

    public String getUsername() {
        return this.userName;
    }

    public ArrayList<PHWhiteListEntry> getWhiteListEntries() {
        return this.whiteListEntries;
    }

    public Integer getZigbeeChannel() {
        return this.zigbeeChannel;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.apiVersion;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bridgeID;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.checkForUpdate;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.dhcpEnabled;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.gateway;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ipAddress;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.localTime;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.macAddress;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.modelId;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.netmask;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool3 = this.portalServicesEnabled;
        int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        PHPortalState pHPortalState = this.portalState;
        int iHashCode13 = (iHashCode12 + (pHPortalState == null ? 0 : pHPortalState.hashCode())) * 31;
        String str9 = this.proxy;
        int iHashCode14 = (((((iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.proxyPort) * 31) + (this.reboot ? 1231 : 1237)) * 31;
        PHSoftwareUpdateStatus pHSoftwareUpdateStatus = this.softwareStatus;
        int iHashCode15 = (iHashCode14 + (pHSoftwareUpdateStatus == null ? 0 : pHSoftwareUpdateStatus.hashCode())) * 31;
        PHBackup pHBackup = this.backup;
        int iHashCode16 = (iHashCode15 + (pHBackup == null ? 0 : pHBackup.hashCode())) * 31;
        String str10 = this.softwareVersion;
        int iHashCode17 = (iHashCode16 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.time;
        int iHashCode18 = (iHashCode17 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.timeZone;
        int iHashCode19 = (iHashCode18 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.userName;
        int iHashCode20 = (iHashCode19 + (str13 == null ? 0 : str13.hashCode())) * 31;
        ArrayList<PHWhiteListEntry> arrayList = this.whiteListEntries;
        int iHashCode21 = (iHashCode20 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Integer num = this.zigbeeChannel;
        return iHashCode21 + (num != null ? num.hashCode() : 0);
    }

    public boolean isReboot() {
        return this.reboot;
    }

    public void setAPIVersion(String str) {
        this.apiVersion = str;
    }

    public void setBackup(PHBackup pHBackup) {
        this.backup = pHBackup;
    }

    public void setBridgeID(String str) {
        if (str != null) {
            this.bridgeID = str.toUpperCase();
        } else {
            this.bridgeID = str;
        }
    }

    public void setCheckForUpdate(Boolean bool) {
        this.checkForUpdate = bool;
    }

    public void setDhcpEnabled(Boolean bool) {
        this.dhcpEnabled = bool;
    }

    public void setFactoryNew(boolean z) {
        this.factoryNew = z;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setLocalTime(String str) {
        this.localTime = str;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setNetmask(String str) {
        this.netmask = str;
    }

    public void setPortalServicesEnabled(Boolean bool) {
        this.portalServicesEnabled = bool;
    }

    public void setPortalState(PHPortalState pHPortalState) {
        this.portalState = pHPortalState;
    }

    public void setProxy(String str) {
        this.proxy = str;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public void setReboot(boolean z) {
        this.reboot = z;
    }

    public void setReplacesBridgeId(String str) {
        this.replacesBridgeId = str;
    }

    public void setSoftwareStatus(PHSoftwareUpdateStatus pHSoftwareUpdateStatus) {
        this.softwareStatus = pHSoftwareUpdateStatus;
    }

    public void setSoftwareVersion(String str) {
        this.softwareVersion = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public void setTouchlink(Boolean bool) {
        this.touchlink = bool;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setWhiteListEntries(ArrayList<PHWhiteListEntry> arrayList) {
        this.whiteListEntries = arrayList;
    }

    public void setZigbeeChannel(Integer num) {
        this.zigbeeChannel = num;
    }

    public PHBridgeConfiguration() {
        super(null, null);
        this.proxyPort = -55;
        this.apiVersion = null;
        this.whiteListEntries = new ArrayList<>();
        this.portalState = null;
        this.reboot = false;
        this.zigbeeChannel = null;
        this.checkForUpdate = null;
    }
}
