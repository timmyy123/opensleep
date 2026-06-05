package com.urbandroid.sleep.sensor.respiration.v2;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/v2/FloatArrayBuffer;", "", "", "size", "<init>", "(I)V", "", "a", "", "add", "([F)V", "get", "()[F", "I", "getSize", "()I", "array", "[F", "getArray", "setArray", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FloatArrayBuffer {
    private volatile float[] array = new float[0];
    private final int size;

    public FloatArrayBuffer(int i) {
        this.size = i;
    }

    public final void add(float[] a) {
        a.getClass();
        this.array = ArraysKt.plus(this.array, a);
        if (this.array.length > this.size) {
            this.array = ArraysKt.sliceArray(this.array, RangesKt.until(this.array.length - this.size, this.array.length));
        }
    }

    /* JADX INFO: renamed from: get, reason: from getter */
    public final float[] getArray() {
        return this.array;
    }
}
