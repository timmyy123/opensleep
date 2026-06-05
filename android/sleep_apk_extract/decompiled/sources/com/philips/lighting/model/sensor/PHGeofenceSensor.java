package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHGeofenceSensor extends PHSensor {
    private Type type;

    public enum Type {
        CLIP("Geofence");

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

    public PHGeofenceSensor(String str, String str2, String str3, String str4, String str5, String str6, PHGeofenceSensorState pHGeofenceSensorState, PHGeofenceSensorConfiguration pHGeofenceSensorConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHGeofenceSensorState, pHGeofenceSensorConfiguration);
        this.type = Type.CLIP;
    }

    public PHGeofenceSensorConfiguration getConfiguration() {
        return (PHGeofenceSensorConfiguration) this.configuration;
    }

    public PHGeofenceSensorState getState() {
        return (PHGeofenceSensorState) this.state;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor
    public String getTypeAsString() {
        return this.type.getValue();
    }

    public void setConfiguration(PHGeofenceSensorConfiguration pHGeofenceSensorConfiguration) {
        this.configuration = pHGeofenceSensorConfiguration;
    }

    public void setState(PHGeofenceSensorState pHGeofenceSensorState) {
        this.state = pHGeofenceSensorState;
    }

    public PHGeofenceSensor(String str, String str2) {
        super(str, str2);
        this.type = Type.CLIP;
    }
}
