package com.urbandroid.sleep.graph;

import java.lang.Comparable;

/* JADX INFO: loaded from: classes4.dex */
public class AxisBoundaries<T extends Comparable> {
    private final T max;
    private final T min;

    public AxisBoundaries(GraphValuesBoundaries<T> graphValuesBoundaries, boolean z) {
        if (z) {
            this.min = (T) graphValuesBoundaries.getMinX();
            this.max = (T) graphValuesBoundaries.getMaxX();
        } else {
            this.min = (T) graphValuesBoundaries.getMinY();
            this.max = (T) graphValuesBoundaries.getMaxY();
        }
    }

    public T getMax() {
        return this.max;
    }

    public T getMin() {
        return this.min;
    }
}
