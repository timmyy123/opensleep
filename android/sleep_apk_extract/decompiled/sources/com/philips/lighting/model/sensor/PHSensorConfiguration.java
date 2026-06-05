package com.philips.lighting.model.sensor;

import com.facebook.appevents.integrity.IntegrityManager;

/* JADX INFO: loaded from: classes4.dex */
public class PHSensorConfiguration {
    private PHSensorAlertMode alertMode;
    private Integer battery;
    private Boolean on;
    private Boolean reachable;
    private String url;
    private Boolean userTest;

    public enum PHSensorAlertMode {
        NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
        SELECT("select"),
        LONG_SELECT("lselect");

        private String value;

        PHSensorAlertMode(String str) {
            this.value = str;
        }

        public static PHSensorAlertMode fromValue(String str) {
            PHSensorAlertMode pHSensorAlertMode = SELECT;
            if (str.equals(pHSensorAlertMode.getValue())) {
                return pHSensorAlertMode;
            }
            PHSensorAlertMode pHSensorAlertMode2 = LONG_SELECT;
            return str.equals(pHSensorAlertMode2.getValue()) ? pHSensorAlertMode2 : NONE;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PHSensorAlertMode[] valuesCustom() {
            PHSensorAlertMode[] pHSensorAlertModeArrValuesCustom = values();
            int length = pHSensorAlertModeArrValuesCustom.length;
            PHSensorAlertMode[] pHSensorAlertModeArr = new PHSensorAlertMode[length];
            System.arraycopy(pHSensorAlertModeArrValuesCustom, 0, pHSensorAlertModeArr, 0, length);
            return pHSensorAlertModeArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public PHSensorConfiguration() {
        this.url = null;
        this.battery = null;
        this.reachable = null;
        this.on = null;
        this.alertMode = null;
        this.userTest = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PHSensorConfiguration pHSensorConfiguration = (PHSensorConfiguration) obj;
        if (this.alertMode != pHSensorConfiguration.alertMode) {
            return false;
        }
        Integer num = this.battery;
        Integer num2 = pHSensorConfiguration.battery;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        Boolean bool = this.on;
        Boolean bool2 = pHSensorConfiguration.on;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        Boolean bool3 = this.reachable;
        Boolean bool4 = pHSensorConfiguration.reachable;
        if (bool3 == null) {
            if (bool4 != null) {
                return false;
            }
        } else if (!bool3.equals(bool4)) {
            return false;
        }
        String str = this.url;
        String str2 = pHSensorConfiguration.url;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        Boolean bool5 = this.userTest;
        Boolean bool6 = pHSensorConfiguration.userTest;
        if (bool5 == null) {
            if (bool6 != null) {
                return false;
            }
        } else if (!bool5.equals(bool6)) {
            return false;
        }
        return true;
    }

    public PHSensorAlertMode getAlertMode() {
        return this.alertMode;
    }

    public Integer getBattery() {
        return this.battery;
    }

    public Boolean getOn() {
        return this.on;
    }

    public Boolean getReachable() {
        return this.reachable;
    }

    public String getUrl() {
        return this.url;
    }

    public Boolean getUserTest() {
        return this.userTest;
    }

    public int hashCode() {
        PHSensorAlertMode pHSensorAlertMode = this.alertMode;
        int iHashCode = ((pHSensorAlertMode == null ? 0 : pHSensorAlertMode.hashCode()) + 31) * 31;
        Integer num = this.battery;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.on;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.reachable;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.url;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool3 = this.userTest;
        return iHashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public void setAlertMode(PHSensorAlertMode pHSensorAlertMode) {
        this.alertMode = pHSensorAlertMode;
    }

    public void setBattery(Integer num) {
        this.battery = num;
    }

    public void setOn(Boolean bool) {
        this.on = bool;
    }

    public void setReachable(Boolean bool) {
        this.reachable = bool;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserTest(Boolean bool) {
        this.userTest = bool;
    }

    public PHSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2) {
        this.url = str;
        this.battery = num;
        this.reachable = bool;
        this.on = bool2;
    }

    public PHSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str2) {
        this(str, num, bool, bool2);
        this.userTest = bool3;
        this.alertMode = PHSensorAlertMode.fromValue(str2);
    }

    public PHSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, PHSensorAlertMode pHSensorAlertMode) {
        this(str, num, bool, bool2);
        this.userTest = bool3;
        this.alertMode = pHSensorAlertMode;
    }
}
