package com.urbandroid.common.util;

import android.app.Activity;
import android.content.Context;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PermissionCompat {
    public static int checkSelfPermission(Context context, String str) {
        if (Environment.isMOrGreater()) {
            try {
                return ((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return 0;
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return checkSelfPermission(context, str) == 0;
    }

    public static void requestPermission(Activity activity, String str, int i) {
        requestPermissions(activity, new String[]{str}, i);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (Environment.isMOrGreater()) {
            try {
                activity.getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(activity, strArr, Integer.valueOf(i));
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }
}
