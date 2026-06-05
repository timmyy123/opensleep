package com.urbandroid.sleep.mic;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class WindowAverage {
    private long count;
    private long sum;
    private LinkedList<Integer> values;
    private int windowSize;

    public WindowAverage(int i, int i2) {
        this.windowSize = 500;
        this.sum = 0L;
        this.count = 1L;
        LinkedList<Integer> linkedList = new LinkedList<>();
        this.values = linkedList;
        this.windowSize = i;
        if (i2 < 1) {
            this.count = 1L;
            this.sum = 1L;
            linkedList.add(1);
        } else {
            this.sum = i2 * i;
            this.count = i;
            for (int i3 = 0; i3 < i; i3++) {
                this.values.add(Integer.valueOf(i2));
            }
        }
    }

    public int getAverage() {
        return (int) (this.sum / this.count);
    }

    public long getCount() {
        return this.count;
    }

    public boolean isOverAverage(int i, float f) {
        return ((float) i) > (f + 1.0f) * ((float) getAverage());
    }

    public void update(int i) {
        if (this.values.size() > this.windowSize) {
            this.sum -= (long) this.values.removeLast().intValue();
            this.count--;
        }
        this.sum += (long) i;
        this.count++;
        this.values.addFirst(Integer.valueOf(i));
    }
}
