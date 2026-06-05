package com.urbandroid.sleep.domain;

import com.urbandroid.sleep.transform.MaximumDataTransformer;
import com.urbandroid.sleep.transform.MovingAveragesDataTransformer;

/* JADX INFO: loaded from: classes5.dex */
public class PresentationFilterFunction implements FilterFunction {
    private boolean isWatch;

    public PresentationFilterFunction(boolean z) {
        this.isWatch = z;
    }

    @Override // com.urbandroid.sleep.domain.FilterFunction
    public float[] filter(float[] fArr, int i, int i2) {
        int i3 = i / 4;
        if (i3 < 1) {
            i3 = 1;
        }
        return new MaximumDataTransformer(((fArr.length / i3) / i2) + 1, true).transform(new MovingAveragesDataTransformer(4, this.isWatch ? 0.5f : 3.0f).transform(new MaximumDataTransformer(i3, true).transform(fArr)));
    }
}
