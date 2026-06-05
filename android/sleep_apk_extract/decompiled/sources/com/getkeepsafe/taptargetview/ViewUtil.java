package com.getkeepsafe.taptargetview;

import android.view.View;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
abstract class ViewUtil {
    private static boolean isLaidOut(View view) {
        return ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static void onLaidOut(final View view, final Runnable runnable) {
        if (isLaidOut(view)) {
            runnable.run();
        } else {
            final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.getkeepsafe.taptargetview.ViewUtil.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewUtil.removeOnGlobalLayoutListener(viewTreeObserver.isAlive() ? viewTreeObserver : view.getViewTreeObserver(), this);
                    runnable.run();
                }
            });
        }
    }

    public static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void removeView(ViewManager viewManager, View view) {
        if (viewManager == null || view == null) {
            return;
        }
        try {
            viewManager.removeView(view);
        } catch (Exception unused) {
        }
    }
}
