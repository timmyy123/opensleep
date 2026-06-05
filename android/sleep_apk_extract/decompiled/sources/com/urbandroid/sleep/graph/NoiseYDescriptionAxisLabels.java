package com.urbandroid.sleep.graph;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseYDescriptionAxisLabels implements IAxisLabels<Float> {
    private final Context context;
    private SleepRecord record;

    public NoiseYDescriptionAxisLabels(Context context, SleepRecord sleepRecord) {
        this.context = context;
        this.record = sleepRecord;
    }

    public String getLabelAt(AxisBoundaries<Float> axisBoundaries, Float f) {
        if (f.floatValue() != 1.0f) {
            return "";
        }
        return this.context.getString(R.string.noise) + " " + Math.round(this.record.getNoiseLevel() * 100.0f) + "%";
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public Set<Float> getValues(AxisBoundaries<Float> axisBoundaries) {
        HashSet hashSet = new HashSet();
        hashSet.add(Float.valueOf(1.0f));
        return hashSet;
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public /* bridge */ /* synthetic */ String getLabelAt(AxisBoundaries axisBoundaries, Comparable comparable) {
        return getLabelAt((AxisBoundaries<Float>) axisBoundaries, (Float) comparable);
    }
}
