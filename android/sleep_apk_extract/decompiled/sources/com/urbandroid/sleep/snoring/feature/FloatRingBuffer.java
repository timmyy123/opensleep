package com.urbandroid.sleep.snoring.feature;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class FloatRingBuffer {
    private int lastIndex;
    private final int maxSize;
    private int size;
    private final float[] values;

    public FloatRingBuffer(int i) {
        if (i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
            throw null;
        }
        this.maxSize = i;
        this.values = new float[i];
        this.size = 0;
        this.lastIndex = -1;
    }

    public void add(float f) {
        int i = this.lastIndex + 1;
        this.lastIndex = i;
        int i2 = this.maxSize;
        if (i >= i2) {
            this.lastIndex = 0;
        }
        this.values[this.lastIndex] = f;
        int i3 = this.size;
        if (i3 < i2) {
            this.size = i3 + 1;
        }
    }

    public float first() {
        return get(0);
    }

    public float get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.size)) {
            return this.values[((this.lastIndex + i) + 1) % i2];
        }
        throw new IndexOutOfBoundsException(i + " >= " + this.size);
    }

    public boolean isFull() {
        return size() == this.maxSize;
    }

    public float last() {
        if (this.size != 0) {
            return this.values[this.lastIndex];
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return this.size;
    }

    public float[] toArray() {
        float[] fArr = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            fArr[i] = get(i);
        }
        return fArr;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.size; i++) {
            arrayList.add(Float.valueOf(get(i)));
        }
        return arrayList.toString();
    }
}
