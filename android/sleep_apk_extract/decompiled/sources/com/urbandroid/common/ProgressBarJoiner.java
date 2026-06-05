package com.urbandroid.common;

import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes5.dex */
public class ProgressBarJoiner {
    private int[] phaseSizes;
    private final int[] phaseWeights;
    private final ProgressBar progressBar;
    private int max = 1000;
    private int step = 1;

    private ProgressBarJoiner(ProgressBar progressBar, int[] iArr) {
        this.progressBar = progressBar;
        this.phaseWeights = iArr;
        recalculate();
    }

    public static ProgressBarJoiner from(ProgressBar progressBar, int... iArr) {
        return new ProgressBarJoiner(progressBar, iArr);
    }

    private void recalculate() {
        int[] iArr = this.phaseWeights;
        this.phaseSizes = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = this.max / i2;
        while (true) {
            int[] iArr2 = this.phaseWeights;
            if (i >= iArr2.length) {
                this.progressBar.setMax(this.max);
                return;
            } else {
                this.phaseSizes[i] = iArr2[i] * i4;
                i++;
            }
        }
    }

    public void hide() {
        this.progressBar.setVisibility(4);
    }

    public void update(int i, int i2, int i3) {
        int iMin = Math.min(i, this.phaseSizes.length - 1);
        float f = i3 == 0 ? 1.0f : i2 / i3;
        int i4 = 0;
        if (iMin > 0) {
            int i5 = 0;
            while (i4 < iMin) {
                i5 += this.phaseSizes[i4];
                i4++;
            }
            i4 = i5;
        }
        this.progressBar.setProgress((int) ((f * this.phaseSizes[iMin]) + i4));
    }
}
