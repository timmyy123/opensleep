package com.urbandroid.common.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ActivityUtils {
    public static int getDip(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void randomGravity(LinearLayout linearLayout) {
        int iRange = RandUtil.range(0, 1000);
        int iRange2 = RandUtil.range(0, linearLayout.getWidth() / 8);
        int iRange3 = RandUtil.range(0, linearLayout.getHeight() / 8);
        if (iRange < 20) {
            linearLayout.setGravity(80);
            linearLayout.setPadding(0, 0, 0, iRange3);
            return;
        }
        if (iRange < 40) {
            linearLayout.setGravity(48);
            linearLayout.setPadding(0, iRange3, 0, 0);
            return;
        }
        if (iRange < 60) {
            linearLayout.setGravity(3);
            linearLayout.setPadding(iRange2, 0, 0, 0);
            return;
        }
        if (iRange < 80) {
            linearLayout.setGravity(5);
            linearLayout.setPadding(0, 0, iRange2, 0);
            return;
        }
        if (iRange < 100) {
            linearLayout.setGravity(1);
            linearLayout.setPadding(0, 0, 0, 0);
        } else if (iRange < 120) {
            linearLayout.setGravity(16);
            linearLayout.setPadding(0, 0, 0, 0);
        } else if (iRange < 160) {
            linearLayout.setGravity(17);
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    public static void setFinishOnTouchOutside(Activity activity, boolean z) {
        try {
            Activity.class.getMethod("setFinishOnTouchOutside", Boolean.TYPE).invoke(activity, Boolean.valueOf(z));
        } catch (Exception e) {
            Logger.logInfo("Cannot fetch screen state", e);
        } catch (NoSuchMethodError unused) {
        }
    }

    public static void setLayerTypeSoftware(View view) {
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(view, 1, null);
        } catch (Throwable unused) {
        }
    }
}
