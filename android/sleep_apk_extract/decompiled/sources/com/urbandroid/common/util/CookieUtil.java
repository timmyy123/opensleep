package com.urbandroid.common.util;

import android.content.Context;
import android.webkit.CookieManager;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CookieUtil {
    public static void clearCookies(Context context) {
        CookieManager cookieManager = CookieManager.getInstance();
        Logger.logInfo("Clear cookies API >=" + String.valueOf(21));
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }
}
