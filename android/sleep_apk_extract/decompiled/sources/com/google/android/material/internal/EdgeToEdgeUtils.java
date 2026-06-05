package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;
import com.philips.lighting.hue.sdk.utilities.impl.Color;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EdgeToEdgeUtils {
    public static void applyEdgeToEdge(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, Color.BLACK);
            if (z2) {
                num = Integer.valueOf(color);
            }
            if (z3) {
                num2 = Integer.valueOf(color);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z);
        int statusBarColor = getStatusBarColor(window.getContext(), z);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z);
        setStatusBarColor(window, statusBarColor);
        setNavigationBarColor(window, navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }

    private static int getNavigationBarColor(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(context, R.attr.navigationBarColor, Color.BLACK), 128);
        }
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, Color.BLACK);
    }

    private static int getStatusBarColor(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, Color.BLACK);
    }

    private static boolean isUsingLightSystemBar(int i, boolean z) {
        if (MaterialColors.isColorLight(i)) {
            return true;
        }
        return i == 0 && z;
    }

    public static void setLightNavigationBar(Window window, boolean z) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z);
    }

    public static void setLightStatusBar(Window window, boolean z) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z);
    }

    public static void setNavigationBarColor(Window window, int i) {
        if (Build.VERSION.SDK_INT < 35) {
            window.setNavigationBarColor(i);
        }
    }

    public static void setStatusBarColor(Window window, int i) {
        if (Build.VERSION.SDK_INT < 35) {
            window.setStatusBarColor(i);
        }
    }

    public static int getNavigationBarColor(Window window) {
        if (Build.VERSION.SDK_INT < 35) {
            return window.getNavigationBarColor();
        }
        return 0;
    }
}
