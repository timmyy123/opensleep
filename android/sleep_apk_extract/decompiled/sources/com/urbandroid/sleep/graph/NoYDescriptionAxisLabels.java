package com.urbandroid.sleep.graph;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class NoYDescriptionAxisLabels implements IAxisLabels<Float> {
    private final Context context;

    public NoYDescriptionAxisLabels(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public /* bridge */ /* synthetic */ String getLabelAt(AxisBoundaries axisBoundaries, Comparable comparable) {
        return getLabelAt((AxisBoundaries<Float>) axisBoundaries, (Float) comparable);
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public Set<Float> getValues(AxisBoundaries<Float> axisBoundaries) {
        return new HashSet();
    }

    public String getLabelAt(AxisBoundaries<Float> axisBoundaries, Float f) {
        return "";
    }
}
