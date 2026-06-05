package com.urbandroid.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class PercentileCalculator {
    private PriorityQueue<Float> lowestElements = new PriorityQueue<>(20, new Comparator<Float>() { // from class: com.urbandroid.util.PercentileCalculator.1
        @Override // java.util.Comparator
        public int compare(Float f, Float f2) {
            if (f.floatValue() == f2.floatValue()) {
                return 0;
            }
            return f.floatValue() < f2.floatValue() ? 1 : -1;
        }
    });
    private final int percentileSize;

    public PercentileCalculator(int i, LinkedList<Float> linkedList) {
        if (i < 1 || i > 99) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid percentil: "));
            throw null;
        }
        Iterator<Float> it = linkedList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().floatValue() > 0.0f) {
                i2++;
            }
        }
        int i3 = (i2 * i) / 100;
        this.percentileSize = i3;
        if (i3 < 1) {
            return;
        }
        for (Float f : linkedList) {
            if (f.floatValue() > 0.0f) {
                addValue(f);
            }
        }
    }

    private void addValue(Float f) {
        if (this.lowestElements.size() < this.percentileSize) {
            this.lowestElements.add(f);
        } else if (f.floatValue() < this.lowestElements.peek().floatValue()) {
            this.lowestElements.poll();
            this.lowestElements.add(f);
        }
    }

    public Float getPercentileValue() {
        if (this.lowestElements.isEmpty()) {
            return null;
        }
        return this.lowestElements.peek();
    }
}
