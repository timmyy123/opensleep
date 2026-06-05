package com.urbandroid.sleep.gui;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes4.dex */
public class ProgressCircle {
    private int max;
    private Paint p;

    public ProgressCircle(int i) {
        Paint paint = new Paint();
        this.p = paint;
        this.max = i;
        paint.setAntiAlias(true);
        this.p.setDither(true);
        this.p.setStyle(Paint.Style.STROKE);
    }
}
