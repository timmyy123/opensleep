package com.urbandroid.sleep.graph;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SensorAxisLabels implements IAxisLabels<Float> {
    private final Context context;
    private SleepRecord record;

    public SensorAxisLabels(Context context, SleepRecord sleepRecord) {
        this.context = context;
        this.record = sleepRecord;
    }

    public String getLabelAt(AxisBoundaries<Float> axisBoundaries, Float f) {
        StringBuilder sb = new StringBuilder();
        if (this.record.getEvents().hasLabel(EventLabel.HR)) {
            sb.append(this.context.getResources().getString(R.string.hr_short));
            sb.append(", ");
        }
        if (this.record.getEvents().hasLabel(EventLabel.SDNN)) {
            sb.append(this.context.getResources().getString(R.string.hrv));
            sb.append(", ");
        }
        if (this.record.getEvents().hasLabel(EventLabel.SPO2)) {
            sb.append(this.context.getResources().getString(R.string.spo2));
            sb.append(", ");
        }
        if (this.record.getEvents().hasLabel(EventLabel.RR)) {
            sb.append(this.context.getResources().getString(R.string.rr));
            sb.append(", ");
        }
        if (this.record.getEvents().hasLabel(EventLabel.LUX)) {
            sb.append(this.context.getResources().getString(R.string.light));
            sb.append(", ");
        }
        return f.floatValue() == 1.0f ? sb.length() > 2 ? sb.substring(0, sb.length() - 2) : sb.toString() : "";
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
