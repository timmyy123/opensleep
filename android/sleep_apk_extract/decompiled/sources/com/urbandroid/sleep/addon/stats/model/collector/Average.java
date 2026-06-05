package com.urbandroid.sleep.addon.stats.model.collector;

/* JADX INFO: loaded from: classes4.dex */
public class Average implements IAggregator, Comparable<Average> {
    protected double sum = 0.0d;
    protected int count = 0;
    protected int days = 0;
    protected double lengthSum = Double.NaN;

    public void addValue(double d, double d2, int i) {
        if (d <= 0.0d) {
            return;
        }
        this.sum += d;
        if (Double.isNaN(this.lengthSum)) {
            this.lengthSum = 0.0d;
        }
        this.count += i;
        this.lengthSum += d2;
        this.days++;
    }

    @Override // java.lang.Comparable
    public int compareTo(Average average) {
        return Double.compare(getMeasure(), average.getMeasure());
    }

    public int getCount() {
        return this.count;
    }

    public int getDays() {
        return this.days;
    }

    public double getLengthSum() {
        return this.lengthSum;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public double getMeasure() {
        double d = this.sum;
        return d == 0.0d ? d : d / ((double) this.days);
    }

    public double getSum() {
        return this.sum;
    }

    public String toString() {
        return "Average{sum=" + this.sum + ", count=" + this.count + ", days=" + this.days + ", lengthSum=" + this.lengthSum + '}';
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IAggregator
    public void addValue(double d) {
        if (d < 0.0d) {
            return;
        }
        this.sum += d;
        this.days++;
        this.count++;
    }
}
