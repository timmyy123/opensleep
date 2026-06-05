package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHOpenCloseSensorState extends PHSensorState {
    private Boolean open;

    public PHOpenCloseSensorState(Boolean bool) {
        this.open = bool;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Boolean bool = this.open;
        Boolean bool2 = ((PHOpenCloseSensorState) obj).open;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        return true;
    }

    public Boolean getOpen() {
        return this.open;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Boolean bool = this.open;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public void setOpen(Boolean bool) {
        this.open = bool;
    }

    public PHOpenCloseSensorState() {
    }
}
