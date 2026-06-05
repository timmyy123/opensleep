package com.urbandroid.util;

import android.app.Dialog;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ActivityStateUtil {
    public static void dismiss(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }
}
