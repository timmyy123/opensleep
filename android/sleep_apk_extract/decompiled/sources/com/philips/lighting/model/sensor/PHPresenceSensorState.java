package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHPresenceSensorState extends PHSensorState {
    private Boolean presence;

    public PHPresenceSensorState(Boolean bool) {
        this.presence = bool;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Boolean bool = this.presence;
        Boolean bool2 = ((PHPresenceSensorState) obj).presence;
        if (bool == null) {
            if (bool2 != null) {
                return false;
            }
        } else if (!bool.equals(bool2)) {
            return false;
        }
        return true;
    }

    public Boolean getPresence() {
        return this.presence;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Boolean bool = this.presence;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public void setPresence(Boolean bool) {
        this.presence = bool;
    }

    public PHPresenceSensorState() {
    }
}
