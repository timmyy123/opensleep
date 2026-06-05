package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHDaylightSensorConfiguration extends PHSensorConfiguration {
    private String latitude;
    private String longitude;
    private Integer sunriseOffset;
    private Integer sunsetOffset;

    public PHDaylightSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2, String str2, String str3, Integer num2, Integer num3) {
        super(str, num, bool, bool2);
        this.latitude = str2;
        this.longitude = str3;
        this.sunriseOffset = num2;
        this.sunsetOffset = num3;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHDaylightSensorConfiguration pHDaylightSensorConfiguration = (PHDaylightSensorConfiguration) obj;
        String str = this.latitude;
        String str2 = pHDaylightSensorConfiguration.latitude;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.longitude;
        String str4 = pHDaylightSensorConfiguration.longitude;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        Integer num = this.sunriseOffset;
        Integer num2 = pHDaylightSensorConfiguration.sunriseOffset;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        Integer num3 = this.sunsetOffset;
        Integer num4 = pHDaylightSensorConfiguration.sunsetOffset;
        if (num3 == null) {
            if (num4 != null) {
                return false;
            }
        } else if (!num3.equals(num4)) {
            return false;
        }
        return true;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public Integer getSunriseOffset() {
        return this.sunriseOffset;
    }

    public Integer getSunsetOffset() {
        return this.sunsetOffset;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.latitude;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.longitude;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.sunriseOffset;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sunsetOffset;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setSunriseOffset(Integer num) {
        this.sunriseOffset = num;
    }

    public void setSunsetOffset(Integer num) {
        this.sunsetOffset = num;
    }

    public PHDaylightSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2) {
        super(str, num, bool, bool2);
    }

    public PHDaylightSensorConfiguration() {
    }
}
