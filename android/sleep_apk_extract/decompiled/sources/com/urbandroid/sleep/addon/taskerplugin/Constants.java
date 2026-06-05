package com.urbandroid.sleep.addon.taskerplugin;

import android.content.Context;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Constants {
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (UnsupportedOperationException unused) {
            return 1;
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return 0;
        }
    }
}
