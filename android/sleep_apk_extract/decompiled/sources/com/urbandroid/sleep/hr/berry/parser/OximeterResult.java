package com.urbandroid.sleep.hr.berry.parser;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
public class OximeterResult {
    public final int perfusionIndex;
    public final int pulseRate;
    public final int rrInterval;
    public final int spo2;

    public OximeterResult(int i, int i2, int i3, int i4) {
        this.spo2 = i;
        this.pulseRate = i2;
        this.perfusionIndex = i3;
        this.rrInterval = i4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OximeterResult(");
        sb.append(this.perfusionIndex);
        sb.append(",");
        sb.append(this.spo2);
        sb.append(",");
        sb.append(this.pulseRate);
        sb.append(",");
        return FileInsert$$ExternalSyntheticOutline0.m(this.rrInterval, ")", sb);
    }
}
