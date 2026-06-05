package com.urbandroid.sleep.graph;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MinMaxAxisLabels implements IAxisLabels<Float> {
    private double max;
    private double min;

    public MinMaxAxisLabels(double d, double d2) {
        this.max = d2;
        this.min = d;
    }

    public String getLabelAt(AxisBoundaries<Float> axisBoundaries, Float f) {
        return f.floatValue() == 0.2f ? String.valueOf(Math.round(this.min)) : f.floatValue() == 1.0f ? String.valueOf(Math.round(this.max)) : "";
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public Set<Float> getValues(AxisBoundaries<Float> axisBoundaries) {
        HashSet hashSet = new HashSet();
        hashSet.add(Float.valueOf(0.2f));
        hashSet.add(Float.valueOf(0.5f));
        hashSet.add(Float.valueOf(1.0f));
        return hashSet;
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public /* bridge */ /* synthetic */ String getLabelAt(AxisBoundaries axisBoundaries, Comparable comparable) {
        return getLabelAt((AxisBoundaries<Float>) axisBoundaries, (Float) comparable);
    }
}
