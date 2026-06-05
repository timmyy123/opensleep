package com.philips.lighting.model.sensor;

import com.philips.lighting.model.PHBridgeResource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PHSensor extends PHBridgeResource {
    protected PHSensorConfiguration configuration;
    private String manufacturerName;
    private String modelId;
    protected PHSensorState state;
    private String swVersion;
    private String uniqueId;

    public PHSensor(String str, String str2, String str3, String str4, String str5, String str6, PHSensorState pHSensorState, PHSensorConfiguration pHSensorConfiguration) {
        super(str, str2);
        this.modelId = str3;
        this.manufacturerName = str4;
        this.swVersion = str5;
        this.uniqueId = str6;
        this.state = pHSensorState;
        this.configuration = pHSensorConfiguration;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PHSensor pHSensor = (PHSensor) obj;
        PHSensorConfiguration pHSensorConfiguration = this.configuration;
        PHSensorConfiguration pHSensorConfiguration2 = pHSensor.configuration;
        if (pHSensorConfiguration == null) {
            if (pHSensorConfiguration2 != null) {
                return false;
            }
        } else if (!pHSensorConfiguration.equals(pHSensorConfiguration2)) {
            return false;
        }
        String str = this.manufacturerName;
        String str2 = pHSensor.manufacturerName;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        String str3 = this.modelId;
        String str4 = pHSensor.modelId;
        if (str3 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str3.equals(str4)) {
            return false;
        }
        PHSensorState pHSensorState = this.state;
        PHSensorState pHSensorState2 = pHSensor.state;
        if (pHSensorState == null) {
            if (pHSensorState2 != null) {
                return false;
            }
        } else if (!pHSensorState.equals(pHSensorState2)) {
            return false;
        }
        String str5 = this.swVersion;
        String str6 = pHSensor.swVersion;
        if (str5 == null) {
            if (str6 != null) {
                return false;
            }
        } else if (!str5.equals(str6)) {
            return false;
        }
        String str7 = this.uniqueId;
        String str8 = pHSensor.uniqueId;
        if (str7 == null) {
            if (str8 != null) {
                return false;
            }
        } else if (!str7.equals(str8)) {
            return false;
        }
        return true;
    }

    public PHSensorConfiguration getBaseConfiguration() {
        return this.configuration;
    }

    public PHSensorState getBaseState() {
        return this.state;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getSwVersion() {
        return this.swVersion;
    }

    public abstract String getTypeAsString();

    public String getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.philips.lighting.model.PHBridgeResource
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        PHSensorConfiguration pHSensorConfiguration = this.configuration;
        int iHashCode2 = (iHashCode + (pHSensorConfiguration == null ? 0 : pHSensorConfiguration.hashCode())) * 31;
        String str = this.manufacturerName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.modelId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PHSensorState pHSensorState = this.state;
        int iHashCode5 = (iHashCode4 + (pHSensorState == null ? 0 : pHSensorState.hashCode())) * 31;
        String str3 = this.swVersion;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uniqueId;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public void setManufacturerName(String str) {
        this.manufacturerName = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setSwVersion(String str) {
        this.swVersion = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public PHSensor(String str, String str2) {
        super(str, str2);
    }
}
