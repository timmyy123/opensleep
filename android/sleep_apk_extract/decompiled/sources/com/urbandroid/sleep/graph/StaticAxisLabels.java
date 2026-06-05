package com.urbandroid.sleep.graph;

import java.lang.Comparable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StaticAxisLabels<T extends Comparable> implements IAxisLabels<T> {
    private Map<T, String> labels = new HashMap();

    public void addLabel(T t, String str) {
        this.labels.put(t, str);
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public String getLabelAt(AxisBoundaries<T> axisBoundaries, T t) {
        return this.labels.get(t);
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public Set<T> getValues(AxisBoundaries<T> axisBoundaries) {
        HashSet hashSet = new HashSet();
        for (T t : this.labels.keySet()) {
            if (axisBoundaries.getMin() == null || t.compareTo(axisBoundaries.getMin()) >= 0) {
                if (axisBoundaries.getMax() == null || t.compareTo(axisBoundaries.getMax()) <= 0) {
                    hashSet.add(t);
                }
            }
        }
        return hashSet;
    }
}
