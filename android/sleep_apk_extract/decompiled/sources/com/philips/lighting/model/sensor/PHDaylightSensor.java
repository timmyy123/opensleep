package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHDaylightSensor extends PHSensor {
    private Type type;

    public enum Type {
        CLIP("Daylight");

        private String value;

        Type(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }

        public String getValue() {
            return this.value;
        }
    }

    public PHDaylightSensor(String str, String str2, String str3, String str4, String str5, String str6, PHDaylightSensorState pHDaylightSensorState, PHDaylightSensorConfiguration pHDaylightSensorConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHDaylightSensorState, pHDaylightSensorConfiguration);
        this.type = Type.CLIP;
    }

    public PHDaylightSensorConfiguration getConfiguration() {
        return (PHDaylightSensorConfiguration) this.configuration;
    }

    public PHDaylightSensorState getState() {
        return (PHDaylightSensorState) this.state;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor
    public String getTypeAsString() {
        return this.type.getValue();
    }

    public void setConfiguration(PHDaylightSensorConfiguration pHDaylightSensorConfiguration) {
        this.configuration = pHDaylightSensorConfiguration;
    }

    public void setState(PHDaylightSensorState pHDaylightSensorState) {
        this.state = pHDaylightSensorState;
    }

    public PHDaylightSensor(String str, String str2) {
        super(str, str2);
        this.type = Type.CLIP;
    }
}
