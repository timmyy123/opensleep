package com.urbandroid.sleep.sensor;

import android.hardware.SensorEvent;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/sensor/AxisThresholdGuard;", "", "", "window", "", "threshold", "<init>", "(IF)V", "Landroid/hardware/SensorEvent;", "currentEvent", "", "update", "(Landroid/hardware/SensorEvent;)V", "", "overThreshold", "()Z", "getAvg", "()F", "I", "getWindow", "()I", "F", "getThreshold", "Lcom/urbandroid/sleep/sensor/AxisData;", "lastData", "Lcom/urbandroid/sleep/sensor/AxisData;", "", "list", "Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AxisThresholdGuard {
    private AxisData lastData;
    private final List<Float> list = new ArrayList();
    private final float threshold;
    private final int window;

    public AxisThresholdGuard(int i, float f) {
        this.window = i;
        this.threshold = f;
    }

    public final float getAvg() {
        return ScienceUtil.avg(CollectionsKt.toFloatArray(this.list));
    }

    public final boolean overThreshold() {
        return getAvg() > this.threshold;
    }

    public final synchronized void update(SensorEvent currentEvent) {
        try {
            currentEvent.getClass();
            AxisData axisData = new AxisData(currentEvent);
            AxisData axisData2 = this.lastData;
            if (axisData2 != null) {
                this.list.add(Float.valueOf(axisData2.getDiff(axisData)));
                if (this.list.size() > this.window) {
                    this.list.remove(0);
                }
            }
            this.lastData = axisData;
        } catch (Throwable th) {
            throw th;
        }
    }
}
