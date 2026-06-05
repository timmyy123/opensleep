package com.urbandroid.sleep.mic;

/* JADX INFO: loaded from: classes.dex */
public class RecordingThreshold {
    private int multiple;
    private WindowAverage windowAverage1;
    private WindowAverage windowAverage2;

    public RecordingThreshold(int i, int i2) {
        this.windowAverage1 = new WindowAverage(i, -1);
        this.windowAverage2 = new WindowAverage(i, -1);
        this.multiple = i2;
    }

    public int getAverage() {
        return this.windowAverage1.getAverage();
    }

    public long getCount() {
        return this.windowAverage1.getCount();
    }

    public int getThreshold() {
        return Math.min(((this.windowAverage2.getAverage() - this.windowAverage1.getAverage()) * this.multiple) + this.windowAverage1.getAverage(), 28000);
    }

    public boolean update(int i) {
        this.windowAverage1.update(i);
        this.windowAverage2.update(Math.max(this.windowAverage1.getAverage(), i));
        return i > getThreshold();
    }
}
