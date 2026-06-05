package com.philips.lighting.model.sensor;

/* JADX INFO: loaded from: classes4.dex */
public class PHHumiditySensorState extends PHSensorState {
    private Integer humidity;

    public PHHumiditySensorState(Integer num) {
        this.humidity = num;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        Integer num = this.humidity;
        Integer num2 = ((PHHumiditySensorState) obj).humidity;
        if (num == null) {
            if (num2 != null) {
                return false;
            }
        } else if (!num.equals(num2)) {
            return false;
        }
        return true;
    }

    public Integer getHumidity() {
        return this.humidity;
    }

    @Override // com.philips.lighting.model.sensor.PHSensorState
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.humidity;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public void setHumidity(Integer num) {
        this.humidity = num;
    }

    public PHHumiditySensorState() {
    }
}
