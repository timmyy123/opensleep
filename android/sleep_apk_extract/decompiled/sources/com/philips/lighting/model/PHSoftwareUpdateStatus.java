package com.philips.lighting.model;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class PHSoftwareUpdateStatus {
    private PHSoftwareUpdateDeviceTypes deviceTypes;
    private boolean notify;
    private String releaseNotesUrl;
    private PHStateType state;
    private String updateText;

    public enum PHStateType {
        NO_UPDATE,
        UPDATE_DOWNLOADING,
        UPDATE_READY_FOR_INSTALL,
        INSTALLING_UPDATES;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHStateType[] valuesCustom() {
            PHStateType[] pHStateTypeArrValuesCustom = values();
            int length = pHStateTypeArrValuesCustom.length;
            PHStateType[] pHStateTypeArr = new PHStateType[length];
            System.arraycopy(pHStateTypeArrValuesCustom, 0, pHStateTypeArr, 0, length);
            return pHStateTypeArr;
        }
    }

    public PHSoftwareUpdateStatus(PHSoftwareUpdateStatus pHSoftwareUpdateStatus) {
        if (pHSoftwareUpdateStatus == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            throw null;
        }
        this.releaseNotesUrl = pHSoftwareUpdateStatus.releaseNotesUrl;
        this.state = pHSoftwareUpdateStatus.state;
        this.updateText = pHSoftwareUpdateStatus.updateText;
        this.notify = pHSoftwareUpdateStatus.notify;
        this.deviceTypes = pHSoftwareUpdateStatus.deviceTypes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHSoftwareUpdateStatus pHSoftwareUpdateStatus = (PHSoftwareUpdateStatus) obj;
        PHSoftwareUpdateDeviceTypes pHSoftwareUpdateDeviceTypes = this.deviceTypes;
        PHSoftwareUpdateDeviceTypes pHSoftwareUpdateDeviceTypes2 = pHSoftwareUpdateStatus.deviceTypes;
        if (pHSoftwareUpdateDeviceTypes == null) {
            if (pHSoftwareUpdateDeviceTypes2 != null) {
                return false;
            }
        } else if (!pHSoftwareUpdateDeviceTypes.equals(pHSoftwareUpdateDeviceTypes2)) {
            return false;
        }
        if (this.notify != pHSoftwareUpdateStatus.notify) {
            return false;
        }
        String str = this.releaseNotesUrl;
        String str2 = pHSoftwareUpdateStatus.releaseNotesUrl;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        if (this.state != pHSoftwareUpdateStatus.state) {
            return false;
        }
        String str3 = this.updateText;
        String str4 = pHSoftwareUpdateStatus.updateText;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public PHSoftwareUpdateDeviceTypes getDeviceTypes() {
        return this.deviceTypes;
    }

    public String getReleaseNotesUrl() {
        return this.releaseNotesUrl;
    }

    public PHStateType getState() {
        return this.state;
    }

    public String getUpdateText() {
        return this.updateText;
    }

    public int hashCode() {
        PHSoftwareUpdateDeviceTypes pHSoftwareUpdateDeviceTypes = this.deviceTypes;
        int iHashCode = ((((pHSoftwareUpdateDeviceTypes == null ? 0 : pHSoftwareUpdateDeviceTypes.hashCode()) + 31) * 31) + (this.notify ? 1231 : 1237)) * 31;
        String str = this.releaseNotesUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        PHStateType pHStateType = this.state;
        int iHashCode3 = (iHashCode2 + (pHStateType == null ? 0 : pHStateType.hashCode())) * 31;
        String str2 = this.updateText;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isNotify() {
        return this.notify;
    }

    public boolean isSoftwareUpdateAvailable() {
        return this.state == PHStateType.UPDATE_READY_FOR_INSTALL;
    }

    public void setDeviceTypes(PHSoftwareUpdateDeviceTypes pHSoftwareUpdateDeviceTypes) {
        this.deviceTypes = pHSoftwareUpdateDeviceTypes;
    }

    public void setNotify(boolean z) {
        this.notify = z;
    }

    public void setReleaseNotesUrl(String str) {
        PHStateType pHStateType = this.state;
        if (pHStateType != PHStateType.UPDATE_DOWNLOADING && pHStateType != PHStateType.UPDATE_READY_FOR_INSTALL) {
            this.releaseNotesUrl = str;
            return;
        }
        if (str == null || str.length() == 0) {
            str = null;
        }
        this.releaseNotesUrl = str;
    }

    public void setState(int i) {
        if (i == 1) {
            this.state = PHStateType.UPDATE_DOWNLOADING;
        } else if (i != 2) {
            this.state = PHStateType.NO_UPDATE;
        } else {
            this.state = PHStateType.UPDATE_READY_FOR_INSTALL;
        }
    }

    public void setUpdateText(String str) {
        PHStateType pHStateType = this.state;
        if (pHStateType != PHStateType.UPDATE_DOWNLOADING && pHStateType != PHStateType.UPDATE_READY_FOR_INSTALL) {
            this.updateText = str;
            return;
        }
        if (str == null || str.length() == 0) {
            str = null;
        }
        this.updateText = str;
    }

    public void setState(PHStateType pHStateType) {
        this.state = pHStateType;
    }

    public PHSoftwareUpdateStatus() {
    }
}
