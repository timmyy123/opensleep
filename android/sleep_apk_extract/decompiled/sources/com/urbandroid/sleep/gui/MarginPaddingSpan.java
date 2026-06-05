package com.urbandroid.sleep.gui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public class MarginPaddingSpan extends ReplacementSpan {
    private final int marginLeft;
    private final int marginRight;
    private final int paddingLeft;
    private final int paddingRight;

    public MarginPaddingSpan(int i, int i2, int i3, int i4) {
        this.paddingLeft = i;
        this.paddingRight = i2;
        this.marginLeft = i3;
        this.marginRight = i4;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.drawText(charSequence, i, i2, f + this.marginLeft + this.paddingLeft, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) (paint.measureText(charSequence.subSequence(i, i2).toString()) + this.marginLeft + this.paddingLeft + this.paddingRight + this.marginRight);
    }
}
