package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHOpenCloseSensor extends PHSensor {
    private Type type;

    public enum Type {
        CLIP("CLIPOpenClose"),
        ZLL("ZLLOpenClose");

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

    public PHOpenCloseSensor(String str, String str2, Type type, String str3, String str4, String str5, String str6, PHOpenCloseSensorState pHOpenCloseSensorState, PHOpenCloseSensorConfiguration pHOpenCloseSensorConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHOpenCloseSensorState, pHOpenCloseSensorConfiguration);
        Type type2 = Type.CLIP;
        this.type = type;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor, com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && getClass() == obj.getClass() && this.type == ((PHOpenCloseSensor) obj).type;
    }

    public PHOpenCloseSensorConfiguration getConfiguration() {
        return (PHOpenCloseSensorConfiguration) this.configuration;
    }

    public PHOpenCloseSensorState getState() {
        return (PHOpenCloseSensorState) this.state;
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

    public void setConfiguration(PHOpenCloseSensorConfiguration pHOpenCloseSensorConfiguration) {
        this.configuration = pHOpenCloseSensorConfiguration;
    }

    public void setState(PHOpenCloseSensorState pHOpenCloseSensorState) {
        this.state = pHOpenCloseSensorState;
    }

    public PHOpenCloseSensor(String str, String str2, Type type) {
        super(str, str2);
        Type type2 = Type.CLIP;
        this.type = type;
    }

    public PHOpenCloseSensor(String str, String str2) {
        super(str, str2);
        this.type = Type.CLIP;
    }
}
