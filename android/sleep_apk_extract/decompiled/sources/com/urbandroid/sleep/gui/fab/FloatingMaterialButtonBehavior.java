package com.urbandroid.sleep.gui.fab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: classes.dex */
public class FloatingMaterialButtonBehavior extends CoordinatorLayout.Behavior<MaterialButton> {
    private float mFabTranslationY;

    public FloatingMaterialButtonBehavior(Context context, AttributeSet attributeSet) {
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, View view) {
        return Math.min(0.0f, ViewCompat.getTranslationY(view) - view.getHeight());
    }

    private void updateFabTranslationForSnackbar(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, View view) {
        this.mFabTranslationY = getFabTranslationYForSnackbar(coordinatorLayout, materialButton, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, View view) {
        if (!(view instanceof Snackbar.SnackbarLayout)) {
            return false;
        }
        updateFabTranslationForSnackbar(coordinatorLayout, materialButton, view);
        ViewCompat.setTranslationY(materialButton, this.mFabTranslationY);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, View view) {
        super.onDependentViewRemoved(coordinatorLayout, materialButton, view);
        ViewCompat.setTranslationY(materialButton, 0.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }
}
