package com.urbandroid.sleep.alarmclock;

import android.widget.Toast;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ToastMaster {
    private static Toast sToast;

    public static void cancelToast() {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
        }
        sToast = null;
    }

    public static void setToast(Toast toast) {
        Toast toast2 = sToast;
        if (toast2 != null) {
            toast2.cancel();
        }
        sToast = toast;
    }
}
