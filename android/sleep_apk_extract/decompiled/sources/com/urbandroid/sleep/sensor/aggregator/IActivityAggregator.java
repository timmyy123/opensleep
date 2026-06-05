package com.urbandroid.sleep.sensor.aggregator;

/* JADX INFO: loaded from: classes4.dex */
public interface IActivityAggregator {
    Result update(float f);

    public static class Result {
        public final float actigraph;
        public final boolean isHighActivity;
        public final boolean isSomeActivity;
        public final float rawActivity;

        public Result(float f, float f2, boolean z, boolean z2) {
            this.rawActivity = f;
            this.actigraph = f2;
            this.isSomeActivity = z;
            this.isHighActivity = z2;
        }

        public boolean hasNoData() {
            return this.rawActivity < 0.0f;
        }

        public String toString() {
            return "Actigraph(" + this.rawActivity + "," + this.actigraph + "," + this.isSomeActivity + "," + this.isHighActivity + ")";
        }

        public Result(float f) {
            this(f, f, false, false);
        }
    }
}
