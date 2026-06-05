package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHGenericStatusSensorState extends PHSensorState {
    private Integer status;

    public PHGenericStatusSensorState(Integer num) {
        this.status = num;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Integer num = this.status;
        Integer num2 = ((PHGenericStatusSensorState) obj).status;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public Integer getStatus() {
        return this.status;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.status;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public PHGenericStatusSensorState() {
    }
}
