package com.urbandroid.sleep.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public class SquareLayout extends LinearLayout {
    private int ratio;

    public SquareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ratio = 2;
    }

    private int getDip(int i) {
        try {
            return (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iMax = Math.max(i5, getDip(240));
        int iMax2 = Math.max(i5 / this.ratio, getDip(120));
        layoutParams.height = iMax2;
        setLayoutParams(layoutParams);
        setMeasuredDimension(iMax, iMax2);
        super.onLayout(z, i, i2, i3, i2 + iMax);
    }
}
