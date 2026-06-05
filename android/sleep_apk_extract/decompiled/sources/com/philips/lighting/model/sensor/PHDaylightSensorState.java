package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHDaylightSensorState extends PHSensorState {
    private Boolean daylight;

    public PHDaylightSensorState(Boolean bool) {
        this.daylight = bool;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Boolean bool = this.daylight;
        Boolean bool2 = ((PHDaylightSensorState) obj).daylight;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        return true;
    }

    public Boolean getDaylight() {
        return this.daylight;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Boolean bool = this.daylight;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public void setDaylight(Boolean bool) {
        this.daylight = bool;
    }

    public PHDaylightSensorState() {
    }
}
