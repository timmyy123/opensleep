package com.philips.lighting.model.sensor;

import com.philips.lighting.model.sensor.metadata.PHSwitchDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitch extends PHSensor {
    private PHSwitchDeviceInfo deviceInfo;
    private Type type;

    public enum Type {
        CLIP("CLIPSwitch"),
        ZLL("ZLLSwitch"),
        ZGP("ZGPSwitch");

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

    public PHSwitch(String str, String str2, Type type, String str3, String str4, String str5, String str6, PHSwitchState pHSwitchState, PHSwitchConfiguration pHSwitchConfiguration) {
        super(str, str2, str3, str4, str5, str6, pHSwitchState, pHSwitchConfiguration);
        Type type2 = Type.CLIP;
        this.deviceInfo = null;
        this.type = type;
    }

    @Override // com.philips.lighting.model.sensor.PHSensor, com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && getClass() == obj.getClass() && this.type == ((PHSwitch) obj).type;
    }

    public PHSwitchConfiguration getConfiguration() {
        return (PHSwitchConfiguration) this.configuration;
    }

    public PHSwitchDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public PHSwitchState getState() {
        return (PHSwitchState) this.state;
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

    public void setConfiguration(PHSwitchConfiguration pHSwitchConfiguration) {
        this.configuration = pHSwitchConfiguration;
    }

    public void setDeviceInfo(PHSwitchDeviceInfo pHSwitchDeviceInfo) {
        this.deviceInfo = pHSwitchDeviceInfo;
    }

    public void setState(PHSwitchState pHSwitchState) {
        this.state = pHSwitchState;
    }

    public PHSwitch(String str, String str2, Type type) {
        super(str, str2);
        Type type2 = Type.CLIP;
        this.deviceInfo = null;
        this.type = type;
    }

    public PHSwitch(String str, String str2) {
        super(str, str2);
        Type type = Type.CLIP;
        this.deviceInfo = null;
        this.type = type;
    }
}
