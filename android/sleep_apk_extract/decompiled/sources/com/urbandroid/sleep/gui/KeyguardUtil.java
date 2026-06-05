package com.urbandroid.sleep.gui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.view.Window;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyguardUtil {
    public static void disable(Activity activity) {
        Window window = activity.getWindow();
        if (((KeyguardManager) activity.getApplicationContext().getSystemService("keyguard")).isKeyguardSecure()) {
            Logger.logInfo("Is secured keyguard: ".concat(activity.getClass().getSimpleName()));
            window.addFlags(4718592);
        } else {
            Logger.logInfo("Is not secured keyguard: ".concat(activity.getClass().getSimpleName()));
            window.addFlags(4194304);
        }
    }

    public static void disableWhenKeyboardUsagePossible(Activity activity) {
        disable(activity);
    }

    public static boolean isKeyguard(Context context) {
        return ((KeyguardManager) context.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked();
    }
}
