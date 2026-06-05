package com.urbandroid.sleep.snoring.feature;

import com.urbandroid.sleep.snoring.record.MonoSample;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class IntervalsOverUnder {
    public final List<Interval> over;
    public final MonoSample sample;
    public final List<Interval> under;

    public IntervalsOverUnder(MonoSample monoSample, List<Interval> list, List<Interval> list2) {
        this.sample = monoSample;
        this.over = Collections.unmodifiableList(list);
        this.under = Collections.unmodifiableList(list2);
    }

    public double getOverFrequency() {
        return ((double) this.over.size()) / this.sample.getDurationSeconds();
    }

    public double getUnderFrequency() {
        return ((double) this.under.size()) / this.sample.getDurationSeconds();
    }
}
