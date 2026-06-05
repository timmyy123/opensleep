package com.urbandroid.sleep.sensor.sonar;

/* JADX INFO: loaded from: classes4.dex */
public interface ILowLevelActivityAggregator {

    public static class Result {
        public final float actigraph;
        public final boolean isHighActivity;

        public Result(float f, boolean z) {
            this.actigraph = f;
            this.isHighActivity = z;
        }
    }

    float getAggregatedActivity();

    Result update(float f);
}
