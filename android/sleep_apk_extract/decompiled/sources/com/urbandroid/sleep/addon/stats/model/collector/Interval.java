package com.urbandroid.sleep.addon.stats.model.collector;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes4.dex */
public class Interval {
    private IAggregator aggregator = new Average();
    private double from;
    private String label;
    private double to;

    public Interval(double d, double d2, String str) {
        this.from = d;
        this.to = d2;
        this.label = str;
    }

    public double getMeasure() {
        return this.aggregator.getMeasure();
    }

    public String getRepresentation() {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String str = this.label;
        if (str != null) {
            return str;
        }
        return decimalFormat.format(this.from) + "-" + decimalFormat.format(this.to) + "h";
    }

    public boolean isWithin(double d) {
        return d > this.from && d <= this.to;
    }

    public boolean put(double d, double d2) {
        if (!isWithin(d)) {
            return false;
        }
        this.aggregator.addValue(d2);
        return true;
    }

    public Interval(double d, double d2) {
        this.from = d;
        this.to = d2;
    }
}
