package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHGeofenceSensorConfiguration extends PHSensorConfiguration {
    private String device;
    private Integer radius;

    public PHGeofenceSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2, Integer num2, String str2) {
        super(str, num, bool, bool2);
        this.radius = num2;
        this.device = str2;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHGeofenceSensorConfiguration pHGeofenceSensorConfiguration = (PHGeofenceSensorConfiguration) obj;
        String str = this.device;
        String str2 = pHGeofenceSensorConfiguration.device;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        Integer num = this.radius;
        Integer num2 = pHGeofenceSensorConfiguration.radius;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public String getDevice() {
        return this.device;
    }

    public Integer getRadius() {
        return this.radius;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorConfiguration
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.device;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.radius;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setRadius(Integer num) {
        this.radius = num;
    }

    public PHGeofenceSensorConfiguration(String str, Integer num, Boolean bool, Boolean bool2) {
        super(str, num, bool, bool2);
    }

    public PHGeofenceSensorConfiguration() {
    }
}
