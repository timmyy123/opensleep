package com.philips.lighting.model.sensor;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class PHSensorState {
    private Date lastUpdated = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Date date = this.lastUpdated;
        Date date2 = ((PHSensorState) obj).lastUpdated;
        if (date == null) {
            if (date2 != null) {
                return false;
            }
        } else if (!date.equals(date2)) {
            return false;
        }
        return true;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public int hashCode() {
        Date date = this.lastUpdated;
        return 31 + (date == null ? 0 : date.hashCode());
    }

    public void setLastUpdated(Date date) {
        this.lastUpdated = date;
    }
}
