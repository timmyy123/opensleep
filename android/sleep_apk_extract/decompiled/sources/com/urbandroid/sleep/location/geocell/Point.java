package com.urbandroid.sleep.location.geocell;

/* JADX INFO: loaded from: classes4.dex */
public class Point {
    private double lat;
    private double lon;

    public Point(double d, double d2) {
        if (d <= 90.0d && d >= -90.0d) {
            new IllegalArgumentException("Latitude must be in [-90, 90]  but was " + d);
        }
        if (d2 <= 180.0d && d2 >= -180.0d) {
            new IllegalArgumentException("Longitude must be in [-180, 180] but was " + d2);
        }
        this.lat = d;
        this.lon = d2;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public String toString() {
        return "Point{lat=" + this.lat + ", lon=" + this.lon + '}';
    }
}
