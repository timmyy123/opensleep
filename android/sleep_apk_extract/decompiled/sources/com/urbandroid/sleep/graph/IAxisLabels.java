package com.urbandroid.sleep.graph;

import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface IAxisLabels<T extends Comparable> {
    String getLabelAt(AxisBoundaries<T> axisBoundaries, T t);

    Set<T> getValues(AxisBoundaries<T> axisBoundaries);
}
