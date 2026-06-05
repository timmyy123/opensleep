package com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes4.dex */
public class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Location(double d, double d2) {
        this.latitude = new BigDecimal(d);
        this.longitude = new BigDecimal(d2);
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }
}
