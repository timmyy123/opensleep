package com.urbandroid.common.util.math;

import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class JulianDay {
    private double d;
    private int day;
    private int h;
    private double julianDay;
    private int m;
    private int mo;
    private int s;
    private double secondsInDay = 86400.0d;
    private int y;
    private static SimpleTimeZone z = new SimpleTimeZone(0, "Z");
    private static final double THIRTYPLUS = 30.6001d;

    public JulianDay(GregorianCalendar gregorianCalendar) throws Exception {
        this.y = gregorianCalendar.get(1);
        this.mo = gregorianCalendar.get(2) + 1;
        this.day = gregorianCalendar.get(5);
        this.h = gregorianCalendar.get(11);
        this.m = gregorianCalendar.get(12);
        this.s = gregorianCalendar.get(13);
        set_d();
        setJulianDay();
        sanityCheck();
    }

    private int floor(double d) throws Exception {
        if (d >= 0.0d) {
            return (int) Math.floor(d);
        }
        throw new Exception("Hey, this is negative: " + d);
    }

    private void sanityCheck() throws Exception {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.mo;
        if (i5 >= 1 && i5 <= 12 && (i = this.day) >= 1 && i <= 31) {
            double d = this.d;
            if (d >= 0.0d && d < 32.0d && (i2 = this.h) >= 0 && i2 <= 23 && (i3 = this.m) >= 0 && i3 <= 59 && (i4 = this.s) >= 0 && i4 <= 59) {
                return;
            }
        }
        throw new Exception();
    }

    private void setJulianDay() throws Exception {
        int iFloor;
        int i = this.y;
        int i2 = this.mo;
        if (i2 == 1 || i2 == 2) {
            i--;
            i2 += 12;
        }
        if (dateIsGregorian()) {
            int iFloor2 = floor(((double) i) / 100.0d);
            iFloor = (2 - iFloor2) + floor(((double) iFloor2) / 4.0d);
        } else {
            iFloor = 0;
        }
        this.julianDay = (((Math.floor(THIRTYPLUS * ((double) (i2 + 1))) + Math.floor(((double) (i + 4716)) * 365.25d)) + this.d) + ((double) iFloor)) - 1524.5d;
    }

    private void set_d() {
        this.d = (((double) ((((this.h * 60) + this.m) * 60) + this.s)) / this.secondsInDay) + ((double) this.day);
    }

    public boolean dateIsGregorian() {
        int i = this.y;
        if (i > 1582) {
            return true;
        }
        if (i < 1582) {
            return false;
        }
        int i2 = this.mo;
        if (i2 > 10) {
            return true;
        }
        return i2 >= 10 && this.day > 4;
    }

    public double julianDay() {
        return this.julianDay;
    }

    public String toString() {
        return this.y + "-" + this.mo + "-" + this.d + "(" + this.day + ")--" + this.h + ":" + this.m + ":" + this.s + "--" + this.julianDay;
    }
}
