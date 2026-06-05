package com.urbandroid.sleep.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class RevereseHideBottomViewBehavior extends CoordinatorLayout.Behavior<LinearLayout> {
    public RevereseHideBottomViewBehavior() {
    }

    private void hideLinearLayout(LinearLayout linearLayout) {
        linearLayout.animate().translationY(linearLayout.getHeight());
    }

    private void showLinearLayout(LinearLayout linearLayout) {
        linearLayout.animate().translationY(0.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            showLinearLayout(linearLayout);
        } else if (i2 < 0) {
            hideLinearLayout(linearLayout);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, View view2, int i) {
        return i == 2;
    }

    public RevereseHideBottomViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
