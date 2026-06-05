package com.urbandroid.sleep.addon.stats.util;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MinMaxFinder {
    protected double minValue = Double.MAX_VALUE;
    protected double maxValue = 0.0d;
    protected Date minDate = null;
    protected Date maxDate = new Date();
    protected double minValueX = Double.MAX_VALUE;
    protected double maxValueX = 0.0d;
    protected boolean minValueXInit = false;
    protected boolean maxValueXInit = false;
    protected boolean minValueInit = false;
    protected boolean maxValueInit = false;

    public void addDate(Date date) {
        if (this.minDate == null) {
            this.minDate = date;
        }
        this.maxDate = date;
    }

    public void addFinder(MinMaxFinder minMaxFinder) {
        if (minMaxFinder.maxValueInit) {
            addValue(minMaxFinder.maxValue);
        }
        if (minMaxFinder.minValueInit) {
            addValue(minMaxFinder.minValue);
        }
        if (minMaxFinder.maxValueXInit) {
            addValueX(minMaxFinder.maxValueX);
        }
        if (minMaxFinder.minValueXInit) {
            addValueX(minMaxFinder.minValueX);
        }
    }

    public void addValue(double d) {
        if (d < this.minValue) {
            this.minValue = d;
            this.minValueInit = true;
        }
        if (d > this.maxValue) {
            this.maxValue = d;
            this.maxValueInit = true;
        }
    }

    public void addValueX(double d) {
        if (d < this.minValueX) {
            this.minValueX = d;
            this.minValueXInit = true;
        }
        if (d > this.maxValueX) {
            this.maxValueX = d;
            this.maxValueXInit = true;
        }
    }

    public Date getMaxDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.maxDate);
        calendar.add(10, 12);
        return calendar.getTime();
    }

    public double getMaxValue() {
        double d = this.maxValue;
        return (0.001d * d) + d;
    }

    public double getMaxValueX() {
        return this.maxValueX;
    }

    public Date getMinDate() {
        return this.minDate;
    }

    public double getMinValue() {
        double d = this.minValue;
        return d - (0.001d * d);
    }

    public double getMinValueX() {
        return this.minValueX;
    }

    public boolean isAfterDays(int i, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -i);
        return calendar.getTime().before(date);
    }

    public void setMaxValue(double d) {
        this.maxValue = d;
    }

    public void setMinDate(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.maxDate);
        calendar.add(5, -i);
        if (this.minDate == null || calendar.getTime().after(this.minDate)) {
            this.minDate = calendar.getTime();
        }
    }

    public void setMinValue(double d) {
        this.minValue = d;
    }
}
