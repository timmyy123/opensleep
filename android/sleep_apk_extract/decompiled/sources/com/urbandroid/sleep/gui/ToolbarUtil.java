package com.urbandroid.sleep.gui;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.ForceLocale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ToolbarUtil {
    public static void apply(AppCompatActivity appCompatActivity) {
        Toolbar toolbar = (Toolbar) appCompatActivity.findViewById(R.id.toolbar);
        if (toolbar != null) {
            try {
                appCompatActivity.setSupportActionBar(toolbar);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowCompat.setDecorFitsSystemWindows(appCompatActivity.getWindow(), false);
            EdgeToEdgeUtil.insetsTop(appCompatActivity.findViewById(R.id.appbar));
            EdgeToEdgeUtil.insetsBottom(appCompatActivity.findViewById(R.id.fab));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.content));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.viewpager));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.fragment));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.list));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.recyclerView));
            EdgeToEdgeUtil.insetsHorizontal(appCompatActivity.findViewById(R.id.drawer));
            appCompatActivity.getWindow().setDecorFitsSystemWindows(false);
            appCompatActivity.getWindow().setStatusBarContrastEnforced(false);
            appCompatActivity.getWindow().setNavigationBarContrastEnforced(false);
        }
        ForceLocale.force(appCompatActivity);
    }

    public static void fixTitle(AppCompatActivity appCompatActivity, int i) {
    }
}
