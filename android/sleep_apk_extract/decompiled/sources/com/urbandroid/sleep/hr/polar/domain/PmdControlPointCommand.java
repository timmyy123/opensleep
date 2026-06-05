package com.urbandroid.sleep.hr.polar.domain;

/* JADX INFO: loaded from: classes.dex */
public enum PmdControlPointCommand {
    NULL_ITEM(0),
    GET_MEASUREMENT_SETTINGS(1),
    REQUEST_MEASUREMENT_START(2),
    STOP_MEASUREMENT(3);

    private int numVal;

    PmdControlPointCommand(int i) {
        this.numVal = i;
    }

    public int getNumVal() {
        return this.numVal;
    }
}
