package com.urbandroid.common.util.math.luckycatlabs.sunrisesunset;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes4.dex */
public class Zenith {
    private final BigDecimal degrees;
    public static final Zenith ASTRONOMICAL = new Zenith(108.0d);
    public static final Zenith NAUTICAL = new Zenith(102.0d);
    public static final Zenith CIVIL = new Zenith(96.0d);
    public static final Zenith OFFICIAL = new Zenith(90.8333d);

    public Zenith(double d) {
        this.degrees = BigDecimal.valueOf(d);
    }

    public BigDecimal degrees() {
        return this.degrees;
    }
}
