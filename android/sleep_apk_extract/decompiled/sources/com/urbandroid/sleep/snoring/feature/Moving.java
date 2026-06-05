package com.urbandroid.sleep.snoring.feature;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.util.Percentile;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Comparator;
import java.util.PriorityQueue;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Moving {
    private static final FloatFunction identity = new FloatFunction() { // from class: com.urbandroid.sleep.snoring.feature.Moving.1
        @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
        public float apply(float f) {
            return f;
        }
    };

    public static FloatFunction avg(int i) {
        if (i >= 1) {
            return i == 1 ? identity : new FloatFunction(i) { // from class: com.urbandroid.sleep.snoring.feature.Moving.2
                private final FloatRingBuffer history;
                private float sum = 0.0f;
                final /* synthetic */ int val$period;

                {
                    this.val$period = i;
                    this.history = new FloatRingBuffer(i + 1);
                }

                @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
                public float apply(float f) {
                    this.history.add(f);
                    if (this.history.size() <= this.val$period) {
                        float f2 = this.sum + f;
                        this.sum = f2;
                        return f2 / this.history.size();
                    }
                    float fFirst = (this.sum - this.history.first()) + this.history.last();
                    this.sum = fFirst;
                    return fFirst / (this.history.size() - 1);
                }
            };
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        return null;
    }

    public static FloatFunction max(int i) {
        return minOrMax(i, true);
    }

    public static FloatFunction min(int i) {
        return minOrMax(i, false);
    }

    private static FloatFunction minOrMax(int i, boolean z) {
        if (i >= 1) {
            return i == 1 ? identity : new FloatFunction(i, z) { // from class: com.urbandroid.sleep.snoring.feature.Moving.4
                private final Comparator<Float> comparator;
                private final FloatRingBuffer history;
                private final PriorityQueue<Float> ordered;
                final /* synthetic */ boolean val$max;
                final /* synthetic */ int val$period;

                {
                    this.val$period = i;
                    this.val$max = z;
                    this.history = new FloatRingBuffer(i);
                    Comparator<Float> comparator = z ? new Comparator<Float>() { // from class: com.urbandroid.sleep.snoring.feature.Moving.4.1
                        @Override // java.util.Comparator
                        public int compare(Float f, Float f2) {
                            return -f.compareTo(f2);
                        }
                    } : new Comparator<Float>() { // from class: com.urbandroid.sleep.snoring.feature.Moving.4.2
                        @Override // java.util.Comparator
                        public int compare(Float f, Float f2) {
                            return f.compareTo(f2);
                        }
                    };
                    this.comparator = comparator;
                    this.ordered = new PriorityQueue<>(i, comparator);
                }

                @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
                public float apply(float f) {
                    if (this.history.size() == this.val$period) {
                        this.ordered.remove(Float.valueOf(this.history.first()));
                    }
                    this.history.add(f);
                    this.ordered.add(Float.valueOf(f));
                    return this.ordered.peek().floatValue();
                }
            };
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        return null;
    }

    public static FloatFunction quantilePrecise(int i, float f) {
        if (i < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
            return null;
        }
        if (f >= 0.0f && f <= 1.0f) {
            return i == 1 ? identity : new FloatFunction(i, f) { // from class: com.urbandroid.sleep.snoring.feature.Moving.7
                private final FloatRingBuffer history;
                private final Percentile percentile = new Percentile();
                final /* synthetic */ int val$period;
                final /* synthetic */ float val$quantile;

                {
                    this.val$period = i;
                    this.val$quantile = f;
                    this.history = new FloatRingBuffer(i);
                }

                @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
                public float apply(float f2) {
                    this.history.add(f2);
                    return this.percentile.evaluate(this.history.toArray(), this.val$quantile * 100.0f);
                }
            };
        }
        Events$$ExternalSyntheticBUOutline0.m("", f);
        return null;
    }

    public static FloatFunction quantileScalable(int i, float f) {
        if (i < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
            return null;
        }
        if (f >= 0.0f && f <= 1.0f) {
            return i == 1 ? identity : new FloatFunction(i, f) { // from class: com.urbandroid.sleep.snoring.feature.Moving.8
                private final FloatRingBuffer history;
                final /* synthetic */ int val$period;
                final /* synthetic */ float val$quantile;
                private final PriorityQueue<Float> low = new PriorityQueue<>(1, new Comparator<Float>() { // from class: com.urbandroid.sleep.snoring.feature.Moving.8.1
                    @Override // java.util.Comparator
                    public int compare(Float f2, Float f3) {
                        return -f2.compareTo(f3);
                    }
                });
                private final PriorityQueue<Float> high = new PriorityQueue<>(1, new Comparator<Float>() { // from class: com.urbandroid.sleep.snoring.feature.Moving.8.2
                    @Override // java.util.Comparator
                    public int compare(Float f2, Float f3) {
                        return f2.compareTo(f3);
                    }
                });

                {
                    this.val$period = i;
                    this.val$quantile = f;
                    this.history = new FloatRingBuffer(i + 1);
                }

                private boolean isEmpty() {
                    return size() == 0;
                }

                private float peek() {
                    return (this.low.isEmpty() ? this.high : this.low).peek().floatValue();
                }

                private int size() {
                    return this.high.size() + this.low.size();
                }

                @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
                public float apply(float f2) {
                    if (isEmpty() || f2 <= peek()) {
                        this.low.add(Float.valueOf(f2));
                    } else {
                        this.high.add(Float.valueOf(f2));
                    }
                    this.history.add(f2);
                    if (this.history.isFull()) {
                        float fFirst = this.history.first();
                        if (!this.low.remove(Float.valueOf(fFirst))) {
                            this.high.remove(Float.valueOf(fFirst));
                        }
                    }
                    int iRound = Math.round(this.val$quantile * size());
                    while (!this.low.isEmpty() && this.low.size() > iRound) {
                        this.high.add(this.low.poll());
                    }
                    while (!this.high.isEmpty() && this.low.size() < iRound) {
                        this.low.add(this.high.poll());
                    }
                    return peek();
                }
            };
        }
        Events$$ExternalSyntheticBUOutline0.m("", f);
        return null;
    }

    public static FloatFunction sum(int i) {
        if (i >= 1) {
            return i == 1 ? identity : new FloatFunction(i) { // from class: com.urbandroid.sleep.snoring.feature.Moving.3
                private final FloatRingBuffer history;
                private float prevResult = 0.0f;
                final /* synthetic */ int val$period;

                {
                    this.val$period = i;
                    this.history = new FloatRingBuffer(i + 1);
                }

                @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
                public float apply(float f) {
                    this.history.add(f);
                    int size = this.history.size();
                    int i2 = this.val$period;
                    float f2 = this.prevResult;
                    float fLast = size <= i2 ? this.history.last() + f2 : (this.history.last() + f2) - this.history.first();
                    this.prevResult = fLast;
                    return fLast;
                }
            };
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        return null;
    }
}
