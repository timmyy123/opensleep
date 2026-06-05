package androidx.health.platform.client.impl.permission.token;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionTokenManager {
    private static final String KEY_TOKEN = "token";
    private static final String PREFERENCES_FILE_NAME = "PermissionTokenManager.healthdata";

    private PermissionTokenManager() {
    }

    public static String getCurrentToken(Context context) {
        return getSharedPreferences(context).getString(KEY_TOKEN, null);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
    }

    public static void setCurrentToken(Context context, String str) {
        getSharedPreferences(context).edit().putString(KEY_TOKEN, str).commit();
    }
}
