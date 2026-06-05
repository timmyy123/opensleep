package com.urbandroid.sleep.gui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: loaded from: classes4.dex */
public class FixedNavigationView extends NavigationView {
    public FixedNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.navigation.NavigationView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle;
        if (parcelable != null && (bundle = ((NavigationView.SavedState) parcelable).menuState) != null) {
            bundle.setClassLoader(getContext().getClass().getClassLoader());
        }
        super.onRestoreInstanceState(parcelable);
    }
}
