package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalFlowLayout extends RelativeLayout {
    public HorizontalFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iMax = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (childAt.getLayoutParams() == null || !(childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    i6 = marginLayoutParams.leftMargin;
                    i7 = marginLayoutParams.rightMargin;
                    i8 = marginLayoutParams.topMargin;
                    i5 = marginLayoutParams.bottomMargin;
                }
                if (getPaddingRight() + FileInsert$$ExternalSyntheticOutline0.m(paddingLeft, i6, measuredWidth, i7) > i3 - i) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += iMax;
                    iMax = measuredHeight + i8 + i5;
                } else {
                    iMax = Math.max(iMax, i8 + measuredHeight + i5);
                }
                int i10 = paddingLeft + i6;
                int i11 = i8 + paddingTop;
                childAt.layout(i10, i11, i10 + measuredWidth, measuredHeight + i11);
                paddingLeft = i6 + measuredWidth + i7 + paddingLeft;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iMax = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (childAt.getLayoutParams() == null || !(childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    i4 = marginLayoutParams.leftMargin;
                    i5 = marginLayoutParams.rightMargin;
                    i6 = marginLayoutParams.topMargin;
                    i3 = marginLayoutParams.bottomMargin;
                }
                if (getPaddingRight() + FileInsert$$ExternalSyntheticOutline0.m(paddingLeft, i4, measuredWidth, i5) > size) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += iMax;
                    iMax = i6 + measuredHeight + i3;
                } else {
                    iMax = Math.max(iMax, i6 + measuredHeight + i3);
                }
                paddingLeft = FileInsert$$ExternalSyntheticOutline0.m(i4, measuredWidth, i5, paddingLeft);
            }
        }
        int paddingBottom = getPaddingBottom() + iMax + paddingTop;
        if (View.MeasureSpec.getMode(i2) == 0 || (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && paddingBottom < size2)) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }
}
