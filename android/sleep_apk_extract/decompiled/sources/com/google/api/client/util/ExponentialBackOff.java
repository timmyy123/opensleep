package com.google.api.client.util;

/* JADX INFO: loaded from: classes4.dex */
public class ExponentialBackOff implements BackOff {
    private int currentIntervalMillis;
    private final int initialIntervalMillis;
    private final int maxElapsedTimeMillis;
    private final int maxIntervalMillis;
    private final double multiplier;
    private final NanoClock nanoClock;
    private final double randomizationFactor;
    long startTimeNanos;

    public static class Builder {
        int initialIntervalMillis = 500;
        double randomizationFactor = 0.5d;
        double multiplier = 1.5d;
        int maxIntervalMillis = 60000;
        int maxElapsedTimeMillis = 900000;
        NanoClock nanoClock = NanoClock.SYSTEM;
    }

    public ExponentialBackOff(Builder builder) {
        int i = builder.initialIntervalMillis;
        this.initialIntervalMillis = i;
        double d = builder.randomizationFactor;
        this.randomizationFactor = d;
        double d2 = builder.multiplier;
        this.multiplier = d2;
        int i2 = builder.maxIntervalMillis;
        this.maxIntervalMillis = i2;
        int i3 = builder.maxElapsedTimeMillis;
        this.maxElapsedTimeMillis = i3;
        this.nanoClock = builder.nanoClock;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(0.0d <= d && d < 1.0d);
        Preconditions.checkArgument(d2 >= 1.0d);
        Preconditions.checkArgument(i2 >= i);
        Preconditions.checkArgument(i3 > 0);
        reset();
    }

    public static int getRandomValueFromInterval(double d, double d2, int i) {
        double d3 = i;
        double d4 = d * d3;
        double d5 = d3 - d4;
        return (int) (((((d3 + d4) - d5) + 1.0d) * d2) + d5);
    }

    private void incrementCurrentInterval() {
        int i = this.currentIntervalMillis;
        double d = i;
        int i2 = this.maxIntervalMillis;
        double d2 = this.multiplier;
        if (d >= ((double) i2) / d2) {
            this.currentIntervalMillis = i2;
        } else {
            this.currentIntervalMillis = (int) (((double) i) * d2);
        }
    }

    public final long getElapsedTimeMillis() {
        return (this.nanoClock.nanoTime() - this.startTimeNanos) / 1000000;
    }

    @Override // com.google.api.client.util.BackOff
    public long nextBackOffMillis() {
        if (getElapsedTimeMillis() > this.maxElapsedTimeMillis) {
            return -1L;
        }
        int randomValueFromInterval = getRandomValueFromInterval(this.randomizationFactor, Math.random(), this.currentIntervalMillis);
        incrementCurrentInterval();
        return randomValueFromInterval;
    }

    @Override // com.google.api.client.util.BackOff
    public final void reset() {
        this.currentIntervalMillis = this.initialIntervalMillis;
        this.startTimeNanos = this.nanoClock.nanoTime();
    }

    public ExponentialBackOff() {
        this(new Builder());
    }
}
