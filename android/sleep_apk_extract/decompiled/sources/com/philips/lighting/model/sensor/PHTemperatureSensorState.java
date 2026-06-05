package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHTemperatureSensorState extends PHSensorState {
    private Integer temperature;

    public PHTemperatureSensorState(Integer num) {
        this.temperature = num;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Integer num = this.temperature;
        Integer num2 = ((PHTemperatureSensorState) obj).temperature;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public Integer getTemperature() {
        return this.temperature;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.temperature;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public void setTemperature(Integer num) {
        this.temperature = num;
    }

    public PHTemperatureSensorState() {
    }
}
