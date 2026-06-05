package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHGenericStatusSensor extends PHSensor {
    private Type type;

    public enum Type {
        CLIP("CLIPGenericStatus");

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

    public PHGenericStatusSensor(String str, String str2, String str3, String str4, String str5, String str6, PHGenericStatusSensorState pHGenericStatusSensorState, PHGenericStatusSensorConfiguration pHGenericStatusSensorConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHGenericStatusSensorState, pHGenericStatusSensorConfiguration);
        this.type = Type.CLIP;
    }

    public PHGenericStatusSensorConfiguration getConfiguration() {
        return (PHGenericStatusSensorConfiguration) this.configuration;
    }

    public PHGenericStatusSensorState getState() {
        return (PHGenericStatusSensorState) this.state;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor
    public String getTypeAsString() {
        return this.type.getValue();
    }

    public void setConfiguration(PHGenericStatusSensorConfiguration pHGenericStatusSensorConfiguration) {
        this.configuration = pHGenericStatusSensorConfiguration;
    }

    public void setState(PHGenericStatusSensorState pHGenericStatusSensorState) {
        this.state = pHGenericStatusSensorState;
    }

    public PHGenericStatusSensor(String str, String str2) {
        super(str, str2);
        this.type = Type.CLIP;
    }
}
