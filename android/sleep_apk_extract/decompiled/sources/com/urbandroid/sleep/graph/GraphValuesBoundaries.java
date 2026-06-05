package com.urbandroid.sleep.graph;

import java.lang.Comparable;

/* JADX INFO: loaded from: classes4.dex */
public class GraphValuesBoundaries<T extends Comparable> {
    private final T maxX;
    private final T maxY;
    private final T minX;
    private final T minY;

    public GraphValuesBoundaries(T t, T t2, T t3, T t4) {
        this.minX = t;
        this.maxX = t3;
        this.minY = t2;
        this.maxY = t4;
    }

    public T getMaxX() {
        return this.maxX;
    }

    public T getMaxY() {
        return this.maxY;
    }

    public T getMinX() {
        return this.minX;
    }

    public T getMinY() {
        return this.minY;
    }
}
