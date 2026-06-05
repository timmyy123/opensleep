package com.urbandroid.smartlight.common;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"TAG", "", "SHARED_PREFERENCES_STORE", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "getDefaultSharedPreferences", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Common_smartlightKt {
    public static final String SHARED_PREFERENCES_STORE = "smartlight-prefs";
    public static final String TAG = "SmartLight";

    public static final SharedPreferences getDefaultSharedPreferences(Context context) {
        context.getClass();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.getClass();
        return defaultSharedPreferences;
    }
}
