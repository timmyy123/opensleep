package com.urbandroid.sleep.location.geocell;

/* JADX INFO: loaded from: classes4.dex */
public class BoundingBox {
    private final Point northEast;
    private final Point southWest;

    public BoundingBox(double d, double d2, double d3, double d4) {
        if (d3 > d) {
            d3 = d;
            d = d3;
        }
        this.northEast = new Point(d, d2);
        this.southWest = new Point(d3, d4);
    }

    public Point center() {
        return new Point(((this.northEast.getLat() - this.southWest.getLat()) / 2.0d) + this.southWest.getLat(), ((this.northEast.getLon() - this.southWest.getLon()) / 2.0d) + this.southWest.getLon());
    }

    public double getEast() {
        return this.northEast.getLon();
    }

    public double getNorth() {
        return this.northEast.getLat();
    }

    public double getSouth() {
        return this.southWest.getLat();
    }

    public double getWest() {
        return this.southWest.getLon();
    }
}
