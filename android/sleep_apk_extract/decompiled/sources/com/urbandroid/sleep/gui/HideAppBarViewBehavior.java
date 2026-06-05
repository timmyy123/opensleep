package com.urbandroid.sleep.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class HideAppBarViewBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    public HideAppBarViewBehavior() {
    }

    private void hideLinearLayout(Toolbar toolbar) {
        toolbar.animate().translationY(-toolbar.getHeight());
    }

    private void showLinearLayout(Toolbar toolbar) {
        toolbar.animate().translationY(0.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar toolbar, View view, int i, int i2, int[] iArr) {
        if (i2 < 0) {
            showLinearLayout(toolbar);
        } else if (i2 > 0) {
            hideLinearLayout(toolbar);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar toolbar, View view, View view2, int i) {
        return i == 2;
    }

    public HideAppBarViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
