package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHGenericFlagSensorState extends PHSensorState {
    private Boolean flag;

    public PHGenericFlagSensorState(Boolean bool) {
        this.flag = bool;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Boolean bool = this.flag;
        Boolean bool2 = ((PHGenericFlagSensorState) obj).flag;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        return true;
    }

    public Boolean getFlag() {
        return this.flag;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Boolean bool = this.flag;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public void setFlag(Boolean bool) {
        this.flag = bool;
    }

    public PHGenericFlagSensorState() {
    }
}
