package com.urbandroid.sleep.sensor;

import android.hardware.SensorEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/sensor/AxisData;", "", "Landroid/hardware/SensorEvent;", "event", "<init>", "(Landroid/hardware/SensorEvent;)V", "data", "", "getDiff", "(Lcom/urbandroid/sleep/sensor/AxisData;)F", "x", "F", "getX", "()F", "y", "getY", "z", "getZ", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AxisData {
    private final float x;
    private final float y;
    private final float z;

    public AxisData(SensorEvent sensorEvent) {
        sensorEvent.getClass();
        float[] fArr = sensorEvent.values;
        this.x = fArr[0];
        this.y = fArr[1];
        this.z = fArr[2];
    }

    public final float getDiff(AxisData data2) {
        data2.getClass();
        return Math.abs(this.z - data2.z) + Math.abs(this.y - data2.y) + Math.abs(this.x - data2.x);
    }
}
