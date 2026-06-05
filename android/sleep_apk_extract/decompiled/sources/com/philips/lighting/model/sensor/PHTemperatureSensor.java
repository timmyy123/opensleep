package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHTemperatureSensor extends PHSensor {
    private Type type;

    public enum Type {
        CLIP("CLIPTemperature"),
        ZLL("ZLLTemperature");

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

    public PHTemperatureSensor(String str, String str2, Type type, String str3, String str4, String str5, String str6, PHTemperatureSensorState pHTemperatureSensorState, PHTemperatureSensorConfiguration pHTemperatureSensorConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHTemperatureSensorState, pHTemperatureSensorConfiguration);
        Type type2 = Type.CLIP;
        this.type = type;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor, com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && getClass() == obj.getClass() && this.type == ((PHTemperatureSensor) obj).type;
    }

    public PHTemperatureSensorConfiguration getConfiguration() {
        return (PHTemperatureSensorConfiguration) this.configuration;
    }

    public PHTemperatureSensorState getState() {
        return (PHTemperatureSensorState) this.state;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor
    public String getTypeAsString() {
        return this.type.getValue();
    }

    @Override // com.philips.lighting.model.sensor.PHSensor, com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Type type = this.type;
        return iHashCode + (type == null ? 0 : type.hashCode());
    }

    public void setConfiguration(PHTemperatureSensorConfiguration pHTemperatureSensorConfiguration) {
        this.configuration = pHTemperatureSensorConfiguration;
    }

    public void setState(PHTemperatureSensorState pHTemperatureSensorState) {
        this.state = pHTemperatureSensorState;
    }

    public PHTemperatureSensor(String str, String str2, Type type) {
        super(str, str2);
        Type type2 = Type.CLIP;
        this.type = type;
    }

    public PHTemperatureSensor(String str, String str2) {
        super(str, str2);
        this.type = Type.CLIP;
    }
}
