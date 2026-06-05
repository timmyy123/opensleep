package com.urbandroid.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Percentile implements Serializable {
    static final long serialVersionUID = -8091216485095130416L;
    private float quantile;

    public Percentile(float f) {
        this.quantile = 0.0f;
        setQuantile(f);
    }

    private float evaluateSorted(float[] fArr, float f) {
        float length = fArr.length;
        float f2 = ((length + 1.0f) * f) / 100.0f;
        float fFloor = (float) Math.floor(f2);
        int i = (int) fFloor;
        float f3 = f2 - fFloor;
        if (f2 < 1.0f) {
            return fArr[0];
        }
        if (f2 >= length) {
            return fArr[fArr.length - 1];
        }
        float f4 = fArr[i - 1];
        return FileInsert$$ExternalSyntheticOutline0.m(fArr[i], f4, f3, f4);
    }

    private void test(float[] fArr, int i, int i2) {
        if (i < 0 || i > fArr.length || i2 < i || i2 > fArr.length) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("This is not a valid subrange");
        }
    }

    public float evaluate(List<Float> list, int i) {
        if (i > 100 || i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "invalid quantile value: "));
            return 0.0f;
        }
        if (list.size() == 0) {
            return Float.NaN;
        }
        if (list.size() == 1) {
            return list.get(0).floatValue();
        }
        float[] fArr = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            fArr[i2] = list.get(i2).floatValue();
        }
        Arrays.sort(fArr);
        return evaluateSorted(fArr, i);
    }

    public void setQuantile(float f) {
        if (f <= 0.0f || f > 100.0f) {
            Events$$ExternalSyntheticBUOutline0.m("Illegal quantile value: ", f);
        } else {
            this.quantile = f;
        }
    }

    public Percentile() {
        this(50.0f);
    }

    public float evaluate(float[] fArr, int i, int i2, float f) {
        test(fArr, i, i2);
        if (f > 100.0f || f <= 0.0f) {
            Events$$ExternalSyntheticBUOutline0.m("invalid quantile value: ", f);
            return 0.0f;
        }
        if (i2 == 0) {
            return Float.NaN;
        }
        if (i2 == 1) {
            return fArr[i];
        }
        float[] fArr2 = new float[i2];
        System.arraycopy(fArr, i, fArr2, 0, i2);
        Arrays.sort(fArr2);
        return evaluateSorted(fArr2, f);
    }

    public float evaluate(float[] fArr, float f) {
        test(fArr, 0, 0);
        return evaluate(fArr, 0, fArr.length, f);
    }
}
