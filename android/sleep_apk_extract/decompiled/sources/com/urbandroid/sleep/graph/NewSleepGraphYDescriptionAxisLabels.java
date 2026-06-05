package com.urbandroid.sleep.graph;

import android.content.Context;
import com.urbandroid.sleep.R;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class NewSleepGraphYDescriptionAxisLabels implements IAxisLabels<Float> {
    private final Context context;

    public NewSleepGraphYDescriptionAxisLabels(Context context) {
        this.context = context;
    }

    public String getLabelAt(AxisBoundaries<Float> axisBoundaries, Float f) {
        return f.floatValue() == 0.25f ? this.context.getString(R.string.label_deep_sleep) : f.floatValue() == 0.75f ? this.context.getString(R.string.rem) : f.floatValue() == 0.5f ? this.context.getString(R.string.label_light_sleep) : f.floatValue() == 1.0f ? this.context.getString(R.string.awake) : "";
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public Set<Float> getValues(AxisBoundaries<Float> axisBoundaries) {
        HashSet hashSet = new HashSet();
        hashSet.add(Float.valueOf(0.25f));
        hashSet.add(Float.valueOf(0.5f));
        hashSet.add(Float.valueOf(0.75f));
        hashSet.add(Float.valueOf(1.0f));
        return hashSet;
    }

    @Override // com.urbandroid.sleep.graph.IAxisLabels
    public /* bridge */ /* synthetic */ String getLabelAt(AxisBoundaries axisBoundaries, Comparable comparable) {
        return getLabelAt((AxisBoundaries<Float>) axisBoundaries, (Float) comparable);
    }
}
