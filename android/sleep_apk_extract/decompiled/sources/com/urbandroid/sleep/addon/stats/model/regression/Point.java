package com.urbandroid.sleep.addon.stats.model.regression;

/* JADX INFO: loaded from: classes4.dex */
public class Point {
    private final double x;
    private final double y;

    public Point(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int hashCode() {
        return new Double(this.x).hashCode();
    }

    public String toString() {
        return "Point(" + this.x + "," + this.y + ")";
    }
}
