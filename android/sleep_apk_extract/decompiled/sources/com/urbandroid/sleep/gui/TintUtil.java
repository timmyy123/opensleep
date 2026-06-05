package com.urbandroid.sleep.gui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class TintUtil {
    public static SystemBarTintManager tint(Activity activity) {
        tint(activity, activity.getResources().getColor(R.color.bar));
        return null;
    }

    public static void tintStatusBar(Activity activity) {
    }

    public static SystemBarTintManager tint(Activity activity, int i) {
        tint(activity, i, null);
        return null;
    }

    public static SystemBarTintManager tint(Activity activity, int i, ViewGroup viewGroup) {
        tint(activity, i, viewGroup, true, null);
        return null;
    }

    public static SystemBarTintManager tint(Activity activity, int i, ViewGroup viewGroup, boolean z) {
        tint(activity, i, viewGroup, z, null);
        return null;
    }

    public static SystemBarTintManager tint(Activity activity, int i, ViewGroup viewGroup, boolean z, View view) {
        return null;
    }
}
