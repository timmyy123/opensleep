package com.urbandroid.sleep.snoring.record;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class MonoSample {
    private final float[] sample;
    private final int sampleRate;

    public MonoSample(float[] fArr, int i) {
        this.sample = fArr;
        this.sampleRate = i;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MonoSample m2159clone() {
        float[] fArr = this.sample;
        return new MonoSample(Arrays.copyOf(fArr, fArr.length), this.sampleRate);
    }

    public MonoSample downSample(int i) {
        if (i == 1) {
            return this;
        }
        int size = size() / i;
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = get(i2 * i);
        }
        return new MonoSample(fArr, this.sampleRate / i);
    }

    public MonoSample fragment(int i, int i2) {
        if (i2 <= size()) {
            return new MonoSample(Arrays.copyOfRange(this.sample, i, i2), this.sampleRate);
        }
        throw new IndexOutOfBoundsException(i2 + " > " + size());
    }

    public float get(int i) {
        return this.sample[i];
    }

    public double getDurationSeconds() {
        return ((double) this.sample.length) / ((double) this.sampleRate);
    }

    public float[] getSample() {
        return this.sample;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public MonoSample reSampleIP(int i) {
        if (this.sampleRate == i) {
            return this;
        }
        int size = size();
        float f = i / this.sampleRate;
        int iFloor = (int) Math.floor(size() * f);
        float[] fArr = new float[iFloor];
        for (int i2 = 0; i2 < iFloor; i2++) {
            float f2 = i2 / f;
            double d = f2;
            int iFloor2 = (int) Math.floor(d);
            int iCeil = (int) Math.ceil(d);
            if (iFloor2 == iCeil) {
                fArr[i2] = get(iFloor2);
            } else if (iCeil >= size) {
                fArr[i2] = get(iFloor2);
            } else {
                fArr[i2] = FileInsert$$ExternalSyntheticOutline0.m(iCeil, f2, get(iFloor2), (f2 - iFloor2) * get(iCeil));
            }
        }
        return new MonoSample(fArr, i);
    }

    public int size() {
        return this.sample.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MonoSample(");
        sb.append(Arrays.toString(this.sample));
        sb.append(", ");
        return FileInsert$$ExternalSyntheticOutline0.m(this.sampleRate, ")", sb);
    }
}
