package com.urbandroid.sleep.smartwatch.phaser.protocol;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class ActigraphyResult {
    public final int index;
    public final Status status;
    public final float[] values;

    public ActigraphyResult(int i, Status status, float[] fArr) {
        this.index = i;
        this.status = status;
        this.values = fArr;
    }

    public String toString() {
        return "ActigraphyResult{index=" + this.index + ", status=" + this.status + ", values=" + Arrays.toString(this.values) + "}";
    }
}
