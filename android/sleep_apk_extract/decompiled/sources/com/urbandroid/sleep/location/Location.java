package com.urbandroid.sleep.location;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.util.ScienceUtil;

/* JADX INFO: loaded from: classes5.dex */
public class Location {
    private double lat;
    private double lon;

    public Location(double d, double d2) {
        this.lat = d;
        this.lon = d2;
    }

    public Location getCoarse() {
        return new Location(ScienceUtil.round(this.lat, 1), ScienceUtil.round(this.lon, 1));
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Loc ");
        sb.append((int) this.lat);
        sb.append(".XXX, ");
        return FileInsert$$ExternalSyntheticOutline0.m((int) this.lon, ".XXX", sb);
    }
}
